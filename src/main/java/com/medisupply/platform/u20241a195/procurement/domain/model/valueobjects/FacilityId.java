package com.medisupply.platform.u20241a195.procurement.domain.model.valueobjects;
import java.util.UUID;
public record FacilityId(UUID value) {
    public FacilityId{
        if(value==null){
            throw new IllegalArgumentException("Faciltiy id must not be unll");
        }
    }
}
