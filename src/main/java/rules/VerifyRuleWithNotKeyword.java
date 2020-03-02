package rules;

import facts.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class VerifyRuleWithNotKeyword {

    public static void main(String[] args) {

        System.out.println( "Bootstrapping the Rule Engine ..." );

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession =  kContainer.newKieSession("ksession-rules");

        Person person = new Person("VARUN", "SINGH");
        person.setHouseNumber("77");
        person.setStreetNumber("BELL COURT");
        System.out.println("Check size of submodule list : " + person.getSubModelAddressList().size());
        kSession.insert(person);

        int fired = kSession.fireAllRules();
        System.out.println( "Number of Rules executed = " + fired );
        System.out.println( "Person Last Name : " + person.getFirstName());

    }
}
