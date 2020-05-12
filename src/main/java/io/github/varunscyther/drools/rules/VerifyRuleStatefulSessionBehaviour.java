package io.github.varunscyther.drools.rules;

import io.github.varunscyther.drools.facts.*;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class VerifyRuleStatefulSessionBehaviour {
    public static void main(String[] args) {

        System.out.println( "Bootstrapping the Rule Engine ..." );

        Person p = new Person("VARUN", "SINGH");
        p.setStreetNumber("PENYSTON ROAD");
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession =  kContainer.newKieSession("statefulRule-session");
        kSession.insert(p);

        int fired = kSession.fireAllRules();
        kSession.dispose();
        System.out.println( "Number of Rules executed = " + fired );
        System.out.println( "House Number : " + p.getHouseNumber());

    }
}
