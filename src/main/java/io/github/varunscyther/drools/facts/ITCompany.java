package io.github.varunscyther.drools.facts;

public class ITCompany {
    private Company cmpName;
    private String noOfEmployee;
    private String service;

    public ITCompany(Company cmpName) {
        this.cmpName = cmpName;
    }

    public Company getCmpName() {
        return cmpName;
    }

    public void setCmpName(Company cmpName) {
        this.cmpName = cmpName;
    }

    public String getNoOfEmployee() {
        return noOfEmployee;
    }

    public void setNoOfEmployee(String noOfEmployee) {
        this.noOfEmployee = noOfEmployee;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
