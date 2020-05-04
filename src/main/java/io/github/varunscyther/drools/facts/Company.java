package io.github.varunscyther.drools.facts;

import java.util.List;

public class Company {
    public String cmpName;
    public String postCode;
    public List<Department> departmentList;
    public Company old;

    public Company(String cmpName, String postCode, List<Department> departmentList) {
        this.cmpName = cmpName;
        this.postCode = postCode;
        this.departmentList = departmentList;
    }

    public String getCmpName() {
        return cmpName;
    }

    public void setCmpName(String cmpName) {
        this.cmpName = cmpName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public Company getOld() { return old; }

    public void setOld(Company old) { this.old = old;
    
    }
}
