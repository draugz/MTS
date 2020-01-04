package com.start.mts.domain;

import javax.persistence.*;

@Entity
@Table(name = "object_types", schema = "mts")
public class ObjectType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int objectTypeId;
    String type;

    public ObjectType(String type) {
        this.type = type;
    }

    public ObjectType() {
    }
}
