package com.medisupply.platform.u20241a195.procurement.domain.repositories;

import com.medisupply.platform.u20241a195.procurement.domain.model.aggregates.SupplyRequest;
import com.medisupply.platform.u20241a195.procurement.domain.model.valueobjects.RequestCode;

public interface SupplyRequestRepository {
    SupplyRequest save(SupplyRequest supplyRequest);
    boolean existsByRequestCode(RequestCode requestCode);

}
