package com.medisupply.platform.u20241a195.procurement.domain.model.valueobjects;

public record RequestCode(String code) {
    public RequestCode{
        if (code==null||code.isBlank())
        {
            throw new IllegalArgumentException("Request code must not be null or blank");
        }
    }
}
