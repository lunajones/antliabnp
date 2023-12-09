package com.esn.adapters.rest.validator;

import com.esn.adapters.rest.exceptions.BadRequestException;
import com.esn.adapters.rest.requests.DocumentoRequest;
import com.esn.enums.TipoDocumento;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DocumentoValidator {
    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};


    private DocumentoValidator() {

    }

    public static void validaDocumentos(List<DocumentoRequest> requests){
        Arrays.stream(TipoDocumento.values()).forEach(tipoDocumento -> {
            if(requests.stream().filter(it -> tipoDocumento.equals(it.getTipoDocumento())).toList().size() > 1){
                throw new BadRequestException("Tipo de Documento repetido");
            }
        });

        requests.forEach(DocumentoValidator::validaDocumento);

    }


    public static void validaDocumento(DocumentoRequest request){
        if(TipoDocumento.CPF.equals(request.getTipoDocumento()) && isValidCPF(request.getDescricao())) {
            throw new BadRequestException("CPF inválido");
        }
        if(TipoDocumento.CNPJ.equals(request.getTipoDocumento()) && isValidCNPJ(request.getDescricao())) {
            throw new BadRequestException("CNPJ inválido");
        }
    }


    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
            digito = Integer.parseInt(str.substring(indice,indice+1));
            soma += digito*peso[peso.length-str.length()+indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public static boolean isValidCPF(String cpf) {
        if ((cpf==null) || (cpf.length()!=11)) return false;

        Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
    }

    public static boolean isValidCNPJ(String cnpj) {
        if ((cnpj==null)||(cnpj.length()!=14)) return false;

        Integer digito1 = calcularDigito(cnpj.substring(0,12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0,12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0,12) + digito1.toString() + digito2.toString());
    }
}
