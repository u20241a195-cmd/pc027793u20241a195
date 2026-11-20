package com.medisupply.platform.u20241a195.procurement.domain.model.valueobjects;

import java.time.LocalDate;

public record FulfillmentPeriod(LocalDate startDate, LocalDate endDate) {
    public FulfillmentPeriod {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Start date and end date must not be null");
        }
        if (!endDate.isAfter(startDate)) {
            throw new IllegalArgumentException("Start date and end date must be after start date");
        }
    }
        public boolean contains (LocalDate checkDate){
            if (checkDate == null) {
                throw new IllegalArgumentException("check date must not be null");

            }
            return !checkDate.isBefore(startDate) && !checkDate.isAfter(endDate);
        }
    }

