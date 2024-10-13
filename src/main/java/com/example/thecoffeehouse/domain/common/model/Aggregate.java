package com.example.thecoffeehouse.domain.common.model;

public abstract class Aggregate<Id extends ValueObject> extends Entity<Id>{

    public Aggregate(Id objectId) {
        super(objectId);
    }
}