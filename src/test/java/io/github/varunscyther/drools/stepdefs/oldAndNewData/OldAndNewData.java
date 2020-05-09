package io.github.varunscyther.drools.stepdefs.oldAndNewData;

import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import io.github.varunscyther.drools.common.Action;
import io.github.varunscyther.drools.facts.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class OldAndNewData implements En {

    private Person person;
    private String matchedRuleName;
    private int noOfRuleFired;

    public OldAndNewData() {
        Given("^the person with first name as ''VARUN'' and last name as ''SINGH'' exist in the facts$", () -> {
            this.person = new Person("VARUN", "SINGH");
            Person oldData = person;
            person.setOldData(oldData);
        });
        And("^the person name information updated with$", (DataTable dataTable) -> {
            List<List<String>> nameInfoTable = dataTable.asLists();
            nameInfoTable.stream().forEach(nameRow -> {
                person.setFirstName(nameRow.get(0));
                person.setLastName(nameRow.get(1));
            });
        });
        When("^if person first name is updated with following then comparison evaluation needs to be triggered$", () -> {
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession =  kContainer.newKieSession("rules-session");
            kSession.insert(person);
            noOfRuleFired = kSession.fireAllRules();
            kSession.getFactHandles().stream().forEach(factHandle -> {
                Object object = kSession.getObject(factHandle);
                if(object instanceof Action) {
                    Action newAction = (Action)object;
                    matchedRuleName = newAction.getRuleName();
                }
            });
            kSession.dispose();
        });
        Then("^''Rule to validate whether there is change in address or not'' rule should match to detect change in name$", () -> {
            assertTrue(noOfRuleFired == 1);
        });
    }
}
