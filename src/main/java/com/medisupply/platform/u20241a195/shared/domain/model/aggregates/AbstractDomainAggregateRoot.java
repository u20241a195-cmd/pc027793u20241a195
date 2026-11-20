package com.medisupply.platform.u20241a195.shared.domain.model.aggregates;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.Collection;
import java.util.Date;

@NullMarked

public abstract class AbstractDomainAggregateRoot <T extends AbstractDomainAggregateRoot<T>>
        extends AbstractAggregateRoot<T> {
    protected void registerDomainEvent(Object event) {
        super.registerEvent(event);
    }
    @Override
    public Collection<Object> domainEvents() {
        return super.domainEvents();
    }
    @Override
    public void clearDomainEvents() {
        super.clearDomainEvents();
    }

    public abstract void assignPersistenceData(Long id, Date createdAt, Date updatedAt);
}
