package com.esn.config;

import com.esn.adapters.services.BeneficiarioServiceImpl;
import com.esn.adapters.services.DocumentoServiceImpl;
import com.esn.ports.BeneficiarioRepositoryPort;
import com.esn.ports.BeneficiarioServicePort;
import com.esn.ports.DocumentoRepositoryPort;
import com.esn.ports.DocumentoServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    BeneficiarioServicePort beneficiarioServicePort(BeneficiarioRepositoryPort repositoryPort, DocumentoServicePort documentoServicePort){
        return new BeneficiarioServiceImpl(repositoryPort, documentoServicePort);
    }

    @Bean
    DocumentoServicePort documentoServicePort(DocumentoRepositoryPort repositoryPort){
        return new DocumentoServiceImpl(repositoryPort);
    }

}
