package com.example.thecoffeehouse.domain.common.model;

import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;

public abstract class Entity <Id extends ValueObject>{
    @NotNull
    private Id id;
    public Entity(Id objectId) {
        this.id = objectId;
    }
    public Id getId() {return id;}
    public static  boolean equal (ValueObject idEntity1, ValueObject idEntity2) {
        return idEntity1.equals(idEntity2);
    }

}
