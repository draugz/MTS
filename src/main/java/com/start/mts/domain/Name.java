package com.start.mts.domain;

import javax.persistence.*;

@Entity
@Table(name = "names", schema = "mts")
public class Name {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nameId;
    String name;

    public Name(String name) {
        this.name = name;
    }

    public Name() {
    }

    public int getNameId() {
        return nameId;
    }

    public String getName() {
        return name;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
