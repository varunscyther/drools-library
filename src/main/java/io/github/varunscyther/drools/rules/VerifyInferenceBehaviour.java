package io.github.varunscyther.drools.rules;

import io.github.varunscyther.drools.facts.Company;
import io.github.varunscyther.drools.facts.Department;
import io.github.varunscyther.drools.facts.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

public class VerifyInferenceBehaviour {
    public static void main(String[] args) {

        System.out.println( "Bootstrapping the Rule Engine ..." );
        Department dep = new Department("IT");
        List<Department> listOfDep = new ArrayList<>();
        listOfDep.add(dep);
        Company cmp = new Company("IT", "SL66ED", listOfDep);
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession =  kContainer.newKieSession("inferenceRule-session");
        kSession.insert(dep);
        kSession.insert(cmp);

        int fired = kSession.fireAllRules();
        kSession.dispose();
        System.out.println( "Number of Rules executed = " + fired );

    }
}
