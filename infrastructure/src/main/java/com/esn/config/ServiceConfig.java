package com.esn.config;

import com.esn.adapters.services.ProdutoServiceImpl;
import com.esn.adapters.services.DocumentoServiceImpl;
import com.esn.ports.ProdutoRepositoryPort;
import com.esn.ports.BeneficiarioServicePort;
import com.esn.ports.MovimentoManualRepositoryPort;
import com.esn.ports.DocumentoServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    BeneficiarioServicePort beneficiarioServicePort(ProdutoRepositoryPort repositoryPort, DocumentoServicePort documentoServicePort){
        return new ProdutoServiceImpl(repositoryPort, documentoServicePort);
    }

    @Bean
    DocumentoServicePort documentoServicePort(MovimentoManualRepositoryPort repositoryPort){
        return new DocumentoServiceImpl(repositoryPort);
    }

}
