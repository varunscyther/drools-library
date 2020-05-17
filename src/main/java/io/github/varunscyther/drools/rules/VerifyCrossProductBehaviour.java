package io.github.varunscyther.drools.rules;


import io.github.varunscyther.drools.common.DataRepository;
import io.github.varunscyther.drools.crossproduct.facts.Passport;
import io.github.varunscyther.drools.crossproduct.facts.VisaApplication;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;


public class VerifyCrossProductBehaviour {
    public static void main(String[] args) {

        System.out.println( "Bootstrapping the Rule Engine ..." );
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession =  kContainer.newKieSession("crossProductRule-session");

        List<Passport> passports = DataRepository.getPassports();
        passports.forEach(kSession :: insert);
        List<VisaApplication> applications = DataRepository.getVisaApplications();
        applications.forEach(kSession :: insert);

        System.out.println("========== DROOLS SESSION STARTED =================");
        int fired = kSession.fireAllRules();
        kSession.dispose();
        System.out.println("========== DROOLS SESSION END =================");

        System.out.println( "Number of Rules executed = " + fired );

        applications.forEach(application ->
                        System.out.println("Visa Application for : " + application.getPassportNumber() + " is " + application.getValidation())
                );

    }

}
