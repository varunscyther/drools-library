package io.github.varunscyther.drools.facts;

import java.util.List;

public class Tribe {
    public String tribeName;
    public List<Team> listOfTeam;

    public Tribe(String tribeName, List<Team> listOfTeam) {
        this.tribeName = tribeName;
        this.listOfTeam = listOfTeam;
    }

    public String getTribeName() {
        return tribeName;
    }

    public void setTribeName(String tribeName) {
        this.tribeName = tribeName;
    }

    public List<Team> getListOfTeam() {
        return listOfTeam;
    }

    public void setListOfTeam(List<Team> listOfTeam) {
        this.listOfTeam = listOfTeam;
    }
}
