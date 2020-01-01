package com.start.mts.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "records", schema = "mts")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int recordId;

    private String userName;
    private String referenceEnv;
    private String ticketNumber;
    private String objectType;
    private String objectName;
    private String action; //TODO: enum
    /*@Transient
    private List<EnvDeploy> envs;*/
    private Date sysTestDeployed;
    private Date accTestDeployed;
    private Date prodDeployed;

    public void setProdDeployed(Date prodDeployed) {
        this.prodDeployed = prodDeployed;
    }

    public Date getProdDeployed() {
        return prodDeployed;
    }

    public void setSysTestDeployed(Date sysTestDeployed) {
        this.sysTestDeployed = sysTestDeployed;
    }

    public void setAccTestDeployed(Date accTestDeployed) {
        this.accTestDeployed = accTestDeployed;
    }

    public Date getSysTestDeployed() {
        return sysTestDeployed;
    }

    public Date getAccTestDeployed() {
        return accTestDeployed;
    }

    public Record() {
    }

    public int getRecordId() {
        return recordId;
    }

    public String getUserName() {
        return userName;
    }

    public String getReferenceEnv() {
        return referenceEnv;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getObjectType() {
        return objectType;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getAction() {
        return action;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setReferenceEnv(String referenceEnv) {
        this.referenceEnv = referenceEnv;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

 /*   public void setEnvs(List<EnvDeploy> envs) {
        this.envs = envs;
    }

    public List<EnvDeploy> getEnvs() {
        return envs;
    }
    public String findEnvsString() {
        List<EnvDeploy> list = this.getEnvs();
        String res = "";
        for (EnvDeploy env: list){
            res = res + env.getEnv() + " " + env.getDate().toString();
        }
        return res;
    }*/
}
