package com.medisupply.platform.u20241a195.procurement.infrastructure.persistence.jpa.entities;
import com.medisupply.platform.u20241a195.procurement.domain.model.valueobjects.SupplyRequestStatus;
import com.medisupply.platform.u20241a195.shared.infrastructure.persistence.jpa.entities.AuditableAbstractPersistenceEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;
    @Entity
    @Table(name = "supply_requests")
    @Getter
    @Setter
    @NoArgsConstructor
    public class SupplyRequestPersistenceEntity extends AuditableAbstractPersistenceEntity {
 @Column(name = "request_code", nullable = false, unique = true)
        private String requestCode;
        @Column(name = "facility_id", nullable = false)
        private UUID facilityId;
        @Column(name = "fulfillment_period_start_date", nullable = false)
        private LocalDate fulfillmentPeriodStartDate;
        @Column(name = "fulfillment_period_end_date", nullable = false)
        private LocalDate fulfillmentPeriodEndDate;
        @Column(name = "supply_batch_quantity", nullable = false)
        private Integer supplyBatchQuantity;
        @Column(name = "supply_batch_unit", nullable = false)
        private String supplyBatchUnit;
        @Column(name = "urgency_level", nullable = false)
        private Integer urgencyLevel;
        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private SupplyRequestStatus status;
        @Column(name = "request_notes")
        private String requestNotes;
}
