package com.esn.adapters.rest;

import com.esn.Produto;
import com.esn.adapters.rest.mappers.BeneficiarioMapper;
import com.esn.adapters.rest.requests.BeneficiarioRequest;
import com.esn.adapters.rest.responses.BeneficiarioResponse;
import com.esn.ports.BeneficiarioServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.esn.adapters.rest.validator.DocumentoValidator.validaDocumentos;
import static java.util.Objects.isNull;


@RestController
@RequestMapping("/v1/beneficiario")
public class BeneficiarioController {

    private final BeneficiarioServicePort beneficiarioServicePort;

    public BeneficiarioController(BeneficiarioServicePort beneficiarioServicePort) {
        this.beneficiarioServicePort = beneficiarioServicePort;
    }

    @PostMapping
    public ResponseEntity<BeneficiarioResponse> create(@RequestBody BeneficiarioRequest request) {
        validaDocumentos(request.getDocumentos());
        return ResponseEntity.ok(
                BeneficiarioMapper.INSTANCE.toResponseFromDomain(
                        beneficiarioServicePort.create(BeneficiarioMapper.INSTANCE.toDomainFromRequest(request))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BeneficiarioResponse>> findAll() {
        List<Produto> produtos = beneficiarioServicePort.findAll();
        if(produtos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(BeneficiarioMapper.INSTANCE.toResponsesFromDomains(beneficiarioServicePort.findAll()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeneficiarioResponse> update(@PathVariable UUID id, @RequestBody BeneficiarioRequest request) {
        validaDocumentos(request.getDocumentos());

        Produto produto = beneficiarioServicePort.modify(BeneficiarioMapper.INSTANCE.toDomainFromRequestAndUUID(request, id));

        if(isNull(produto)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(BeneficiarioMapper.INSTANCE.toResponseFromDomain(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        this.beneficiarioServicePort.remove(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
