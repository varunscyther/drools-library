package io.github.varunscyther.drools.rules;

import io.github.varunscyther.drools.facts.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

public class VerifyRuleStatelessSessionBehaviour {
    public static void main(String[] args) {

        System.out.println( "Bootstrapping the Rule Engine ..." );

        Person p = new Person("VARUN", "SINGH");
        p.setStreetNumber("PENYSTON ROAD");
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        StatelessKieSession kSession = kContainer.newStatelessKieSession("statelessRule-session");
        kSession.execute(p);
        System.out.println( "House Number : " + p.getHouseNumber());

    }
}
