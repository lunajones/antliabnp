package com.esn.adapters.rest.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

public class GeneralErrorResponseFactory {

    public static ExceptionBuilder get() { return new ExceptionBuilder(); }


    public static class ExceptionBuilder {

        ObjectMapper objectMapper = new ObjectMapper()
                .findAndRegisterModules().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        public ExceptionBuilder() { super(); }

        public GeneralResponse createGeneralErrorResponse(String message, String statusCode) {

            try {
                return objectMapper.readValue(message, GeneralResponse.class);
            } catch (JsonProcessingException e) {
                System.out.println("erro na conversao do general error response");
            }

            return genericGeneralError(message, statusCode);
        }

        public GeneralResponse genericGeneralError(String mensagem, String statusCode) {

            StatusResponse statusResponse = new StatusResponse();
            statusResponse.setMessage(mensagem);
            statusResponse.setCode(statusCode);

            GeneralResponse generalResponse = new GeneralResponse();
            generalResponse.setStatus(statusResponse);
            return generalResponse;
        }
    }
}
