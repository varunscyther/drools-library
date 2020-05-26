package io.github.varunscyther.drools.rules;


import io.github.varunscyther.drools.common.Action;
import io.github.varunscyther.drools.common.DataRepository;
import io.github.varunscyther.drools.crossproduct.facts.VisaApplication;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.Collection;
import java.util.List;


public class VerifyInsertFactBehaviour {
    public static void main(String[] args) {

        System.out.println( "Bootstrapping the Rule Engine ..." );
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession =  kContainer.newKieSession("insertFactsRule-session");

        List<VisaApplication> applications = DataRepository.getVisaApplications();
        applications.forEach(kSession :: insert);

        System.out.println("========== DROOLS SESSION STARTED =================");
        int fired = kSession.fireAllRules();
        kSession.dispose();
        System.out.println("========== DROOLS SESSION END =================");

        System.out.println( "Number of Rules executed = " + fired );

        Collection<?> actionObjects = kSession.getObjects(o -> o.getClass() == Action.class);
        actionObjects.forEach(action -> {
            Action act = (Action)action;
            System.out.println("Rule Name : " + act.getRuleName());
            System.out.println("Passport Number : " + act.getActionParamters().get("passportNumber"));
            System.out.println("Application Id : " + act.getActionParamters().get("applicationId"));
        });

    }

}
