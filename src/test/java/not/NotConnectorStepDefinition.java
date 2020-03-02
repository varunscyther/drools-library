package not;

import facts.Person;
import io.cucumber.core.api.Scenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.apache.commons.lang3.StringUtils;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

import static org.junit.Assert.*;

public class NotConnectorStepDefinition implements En{
    private Scenario scenario;
    private Person person;
    private int noOfRuleFired;

    public NotConnectorStepDefinition(){

        Before((Scenario scn) -> {
            this.scenario = scn;
        });

        Given("the person first name as '(\\w+)' and last name as '(\\w+)' exist in the facts",(String personFirstName, String personLastName) -> {
            if(StringUtils.isNotEmpty(personFirstName) && StringUtils.isNotEmpty(personLastName)){
                this.person = new Person(personFirstName, personLastName);
            }
        });

        And("the following address exist for person",(DataTable dataTable) -> {
            List<List<String>> addressTable = dataTable.asLists();
            addressTable.stream().forEach(addressRow -> {
                person.setHouseNumber(addressRow.get(0));
                person.setStreetNumber(addressRow.get(1));
            });
        });

        When("rules get fired", () ->{
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession =  kContainer.newKieSession("ksession-rules");
            kSession.insert(person);
            noOfRuleFired = kSession.fireAllRules();
        });

        Then("atleast '(\\d+)' rule is executed", (Integer count) ->{
            assertTrue(noOfRuleFired == count);
        });
    }
}
