package rules;

import facts.Company;
import facts.Department;
import facts.Team;
import facts.Tribe;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 *  Refer drools documentation for details:
 *  https://docs.jboss.org/drools/release/7.26.0.Final/drools-docs/html_single/#rule-base-configuration-con_decision-management-architecture
 *
 */
public class VerifyRuleWithMultiThreadEvaluation {
    public static void main(String[] args) {

        System.out.println( "Bootstrapping the Rule Engine ..." );

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession =  kContainer.newKieSession("ksession-rules");
        Company newData = newData();
        newData.setOld(oldData());
        kSession.insert(newData);

        int fired = kSession.fireAllRules();
        kSession.dispose();
        kSession.getFactHandles().stream().forEach(e -> System.out.println(e));
        System.out.println( "Number of Rules executed = " + fired );
        System.out.println( "Company Name : " + newData.getCmpName());

    }

    private static Company newData() {
        List<Department> listOfDep = new ArrayList<Department>();
        List<Tribe> listOfTribe = new ArrayList<Tribe>();
        List<Team> listOfTeam = new ArrayList<Team>();
        Team team = new Team("STRIKER", null, null, null, null, 1
        ,"17-02-2019", "1000");
        listOfTeam.add(team);
        Tribe tribe = new Tribe("DEV", listOfTeam);
        listOfTribe.add(tribe);
        Department dep = new Department("HUB", listOfTribe);
        listOfDep.add(dep);
        return new Company("AIRCODE", null, listOfDep);
    }

    private static Company oldData() {
        List<Department> listOfDep = new ArrayList<Department>();
        List<Tribe> listOfTribe = new ArrayList<Tribe>();
        List<Team> listOfTeam = new ArrayList<Team>();
        Team team = new Team("RULE", null, null,
                null, null, 1, "14-02-2019", "1000");
        listOfTeam.add(team);
        Tribe tribe = new Tribe("R&D", listOfTeam);
        listOfTribe.add(tribe);
        Department dep = new Department("HUB", listOfTribe);
        listOfDep.add(dep);
        return new Company("AIRCODE", null, listOfDep);
    }
}
