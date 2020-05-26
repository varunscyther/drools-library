package io.github.varunscyther.drools.rules;

import io.github.varunscyther.drools.common.DataRepository;
import io.github.varunscyther.drools.facts.Person;
import io.github.varunscyther.drools.listner.AgendaGroupEventListener;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;

import java.util.List;


public class VerifyAgendaGroupBehaviour {
    public static void main(String[] args) {

        System.out.println( "Bootstrapping the Rule Engine ..." );
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession =  kContainer.newKieSession("agendaGroupRule-session");

        kSession.addEventListener(new AgendaGroupEventListener(System.out));

        List<Person> personList = DataRepository.getPersons();
        personList.forEach(kSession :: insert);

        Agenda agenda = kSession.getAgenda();
        agenda.getAgendaGroup("address-information").setFocus();
        agenda.getAgendaGroup("personal-information").setFocus();

        System.out.println("========== DROOLS SESSION STARTED =================");
        int fired = kSession.fireAllRules();
        kSession.dispose();
        System.out.println("========== DROOLS SESSION END =================");

        System.out.println( "Number of Rules executed = " + fired );


    }

}
