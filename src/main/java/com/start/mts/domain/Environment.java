package com.start.mts.domain;

import javax.persistence.*;

@Entity
@Table(name = "environments", schema = "mts")
public class Environment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int envId;
    String EnvName;
    boolean isReferenceEnvironment;

    public Environment(String envName, boolean isReferenceEnvironment) {
        EnvName = envName;
        this.isReferenceEnvironment = isReferenceEnvironment;
    }

    public Environment() {
    }

    public int getEnvId() {
        return envId;
    }

    public String getEnvName() {
        return EnvName;
    }

    public boolean isReferenceEnvironment() {
        return isReferenceEnvironment;
    }

    public void setEnvId(int envId) {
        this.envId = envId;
    }

    public void setEnvName(String envName) {
        EnvName = envName;
    }

    public void setReferenceEnvironment(boolean referenceEnvironment) {
        isReferenceEnvironment = referenceEnvironment;
    }
}
