package com.medisupply.platform.u20241a195.procurement.domain.model.aggregates;
import com.medisupply.platform.u20241a195.procurement.domain.model.valueobjects.*;
import com.medisupply.platform.u20241a195.shared.domain.model.aggregates.AbstractDomainAggregateRoot;

import java.time.Instant;
public class SupplyRequest extends AbstractDomainAggregateRoot<SupplyRequest> {

    private Long id;
    private final RequestCode requestCode;
    private final FacilityId facilityId;
    private final FulfillmentPeriod fulfillmentPeriod;
    private final SupplyBatch supplyBatch;
    private final Integer urgencyLevel;
    private final SupplyRequestStatus status;
    private final String requestNotes;
    private Instant createdAt;
    private Instant updatedAt;
    public SupplyRequest(RequestCode requestCode, FacilityId facilityId, FulfillmentPeriod fulfillmentPeriod,
                         SupplyBatch supplyBatch, Integer urgencyLevel, SupplyRequestStatus status,
                         String requestNotes) {

        if (requestCode == null || facilityId == null || fulfillmentPeriod == null || supplyBatch == null) {
            throw new IllegalArgumentException("Request code, facility, period and batch are required");
        }
        if (urgencyLevel == null || urgencyLevel < 1 || urgencyLevel > 5) {
            throw new IllegalArgumentException("Urgency level must be between 1 and 5");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status must not be null");
        }

        this.requestCode = requestCode;
        this.facilityId = facilityId;
        this.fulfillmentPeriod = fulfillmentPeriod;
        this.supplyBatch = supplyBatch;
        this.urgencyLevel = urgencyLevel;
        this.status = status;
        this.requestNotes = requestNotes;

    }
}
