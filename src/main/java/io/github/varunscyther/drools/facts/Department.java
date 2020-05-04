package io.github.varunscyther.drools.facts;

import java.util.List;

public class Department {
    public String departmentName;
    public List<Tribe> listOfTribe;

    public Department(String departmentName, List<Tribe> listOfTribe) {
        this.departmentName = departmentName;
        this.listOfTribe = listOfTribe;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Tribe> getListOfTribe() {
        return listOfTribe;
    }

    public void setListOfTribe(List<Tribe> listOfTribe) {
        this.listOfTribe = listOfTribe;
    }
}
