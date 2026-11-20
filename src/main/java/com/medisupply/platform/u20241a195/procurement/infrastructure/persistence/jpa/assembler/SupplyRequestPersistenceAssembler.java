package com.medisupply.platform.u20241a195.procurement.infrastructure.persistence.jpa.assembler;

import com.medisupply.platform.u20241a195.procurement.domain.model.aggregates.SupplyRequest;
import com.medisupply.platform.u20241a195.procurement.domain.model.valueobjects.FacilityId;
import com.medisupply.platform.u20241a195.procurement.domain.model.valueobjects.FulfillmentPeriod;
import com.medisupply.platform.u20241a195.procurement.domain.model.valueobjects.RequestCode;
import com.medisupply.platform.u20241a195.procurement.domain.model.valueobjects.SupplyBatch;
import com.medisupply.platform.u20241a195.procurement.infrastructure.persistence.jpa.entities.SupplyRequestPersistenceEntity;

public class SupplyRequestPersistenceAssembler {
    private SupplyRequestPersistenceAssembler() {
    }
    public static SupplyRequest toDomainFromPersistence(SupplyRequestPersistenceEntity entity) {
        var supplyRequest = new SupplyRequest(
                new RequestCode(entity.getRequestCode()),
                new FacilityId(entity.getFacilityId()),
                new FulfillmentPeriod(entity.getFulfillmentPeriodStartDate(), entity.getFulfillmentPeriodEndDate()),
                new SupplyBatch(entity.getSupplyBatchQuantity(), entity.getSupplyBatchUnit()),
                entity.getUrgencyLevel(),
                entity.getStatus(),
                entity.getRequestNotes());
        supplyRequest.assignPersistenceData(entity.getId(), entity.getCreatedAt(), entity.getUpdatedAt());
        return supplyRequest;
    }
    public static SupplyRequestPersistenceEntity toPersistenceFromDomain(SupplyRequest supplyRequest) {
        var entity = new SupplyRequestPersistenceEntity();
        if (supplyRequest.getId() != null) {
            entity.setId(supplyRequest.getId());

        }

        entity.setRequestCode(supplyRequest.RequestCode().code());
        entity.setFacilityId(supplyRequest.getFacilityId().value());
        entity.setFulfillmentPeriodStartDate(supplyRequest.getFulfillmentPeriod().startDate());
        entity.setFulfillmentPeriodEndDate(supplyRequest.getFulfillmentPeriod().endDate());
        entity.setSupplyBatchQuantity(supplyRequest.getSupplyBatch().quantity());
        entity.setSupplyBatchUnit(supplyRequest.getSupplyBatch().unit());
        entity.setUrgencyLevel(supplyRequest.getUrgencyLevel());
        entity.setStatus(supplyRequest.getStatus());
        entity.setRequestNotes(supplyRequest.getRequestNotes());
        return entity;

    }

}

