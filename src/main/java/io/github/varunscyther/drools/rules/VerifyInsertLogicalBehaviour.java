package io.github.varunscyther.drools.rules;


import io.github.varunscyther.drools.common.Action;
import io.github.varunscyther.drools.common.DataRepository;
import io.github.varunscyther.drools.crossproduct.facts.Passport;
import io.github.varunscyther.drools.crossproduct.facts.Visa;
import io.github.varunscyther.drools.crossproduct.facts.VisaApplication;
import org.kie.api.KieServices;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.Collection;
import java.util.List;


public class VerifyInsertLogicalBehaviour {
    public static void main(String[] args) {

        System.out.println( "Bootstrapping the Rule Engine ..." );
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession =  kContainer.newKieSession("insertLogicalRule-session");

        kSession.addEventListener(new RuleRuntimeEventListener() {
            @Override
            public void objectInserted(ObjectInsertedEvent event) {
                System.out.println("Object Inserted : " + event.getObject());
            }

            @Override
            public void objectUpdated(ObjectUpdatedEvent event) {
                System.out.println("Object Updated : " + event.getObject());
            }

            @Override
            public void objectDeleted(ObjectDeletedEvent event) {
                System.out.println("Object Deleted : " + event.getOldObject());
            }
        });

        List<Passport> passports = DataRepository.getPassports();
        passports.forEach(kSession :: insert);
        List<VisaApplication> applications = DataRepository.getVisaApplications();
        applications.forEach(kSession :: insert);

        System.out.println("========== DROOLS SESSION STARTED =================");
        int fired = kSession.fireAllRules();
        kSession.dispose();
        System.out.println("========== DROOLS SESSION END =================");

        System.out.println( "Number of Rules executed = " + fired );

        Collection<?> visaObjects = kSession.getObjects(o -> o.getClass() == Visa.class);
        visaObjects.forEach(visa -> {
            Visa vsa = (Visa)visa;
            System.out.println(vsa.toString());
        });

    }

}
