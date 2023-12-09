package com.esn.adapters.rest.requests;

import com.esn.enums.TipoDocumento;

public class DocumentoRequest {
    private TipoDocumento tipoDocumento;
    private String descricao;

    public DocumentoRequest(TipoDocumento tipoDocumento, String descricao) {
        this.tipoDocumento = tipoDocumento;
        this.descricao = descricao;
    }


    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
