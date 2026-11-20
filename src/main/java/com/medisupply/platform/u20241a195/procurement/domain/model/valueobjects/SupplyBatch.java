package com.medisupply.platform.u20241a195.procurement.domain.model.valueobjects;

public record SupplyBatch(Integer quantity, String unit) {
    public SupplyBatch {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (unit == null || unit.isBlank()) {
            throw new IllegalArgumentException("Unit must not be null or blank");
        }
    }
    public SupplyBatch addUnits(Integer additionalQuantity) {
        if (additionalQuantity == null || additionalQuantity <= 0) {
            throw new IllegalArgumentException("Additional quantity must be greater than zero");
        }
        if ((long) quantity + additionalQuantity > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Resulting quantity exceeds the maximum allowed");
        }
        return new SupplyBatch(quantity + additionalQuantity, unit);
    }
}
