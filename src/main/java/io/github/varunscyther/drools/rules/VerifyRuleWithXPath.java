package io.github.varunscyther.drools.rules;

import io.github.varunscyther.drools.facts.Company;
import io.github.varunscyther.drools.facts.Department;
import io.github.varunscyther.drools.facts.Team;
import io.github.varunscyther.drools.facts.Tribe;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

public class VerifyRuleWithXPath {
    public static void main(String[] args) {

        System.out.println( "Bootstrapping the Rule Engine ..." );

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession =  kContainer.newKieSession("rules-session");
        List<Department> listOfDep = new ArrayList<Department>();
        List<Tribe> listOfTribe = new ArrayList<Tribe>();
        List<Team> listOfTeam = new ArrayList<Team>();
        Team team = new Team("STRIKER", null, null, null, null, 1, null, null);
        listOfTeam.add(team);
        Tribe tribe = new Tribe("DEV", listOfTeam);
        listOfTribe.add(tribe);
        Department dep = new Department("HUB", listOfTribe);
        listOfDep.add(dep);
        Company cmp = new Company("AIRCODE", null, listOfDep);
        kSession.insert(cmp);

        int fired = kSession.fireAllRules();
        kSession.dispose();
        System.out.println( "Number of Rules executed = " + fired );
        System.out.println( "Company Name : " + cmp.getCmpName());

    }
}
