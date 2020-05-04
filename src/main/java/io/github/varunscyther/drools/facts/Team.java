package io.github.varunscyther.drools.facts;

public class Team {
    public String teamName;
    public String role;
    public String ownership;
    public String productOwner;
    public String scrumMaster;
    public int teamSize;
    public String startDate;
    public String startTime;

    public Team(String teamName, String role, String ownership, String productOwner, String scrumMaster,int teamSize
    , String startDate, String startTime) {
        this.teamName = teamName;
        this.role = role;
        this.ownership = ownership;
        this.productOwner = productOwner;
        this.scrumMaster = scrumMaster;
        this.teamSize = teamSize;
        this.startDate = startDate;
        this.startTime = startTime;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(String productOwner) {
        this.productOwner = productOwner;
    }

    public String getScrumMaster() {
        return scrumMaster;
    }

    public void setScrumMaster(String scrumMaster) {
        this.scrumMaster = scrumMaster;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getStartTime() {
        return startTime;
    }
}
