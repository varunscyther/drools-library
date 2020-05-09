package io.github.varunscyther.drools.stepdefs.and;

import io.cucumber.core.api.Scenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import io.github.varunscyther.drools.facts.Person;
import org.apache.commons.lang3.StringUtils;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class AndConnectorStepDefinition implements En{
    private Scenario scenario;
    private Person person;
    private int noOfRuleFired;

    public AndConnectorStepDefinition(){

        Before((Scenario scn) -> {
            this.scenario = scn;
        });

        Given("the person name as '(\\w+)' exist in the facts",(String personFirstName) -> {
            if(StringUtils.isNotEmpty(personFirstName)){
                this.person = new Person(personFirstName, "SINGH");
            }
        });

        And("the following is the address",(DataTable dataTable) -> {
            List<List<String>> addressTable = dataTable.asLists();
            addressTable.stream().forEach(addressRow -> {
                person.setHouseNumber(addressRow.get(0));
                person.setStreetNumber(addressRow.get(1));
            });
        });

        When("rules is triggered", () ->{
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession =  kContainer.newKieSession("rules-session");
            kSession.insert(person);
            noOfRuleFired = kSession.fireAllRules();
            kSession.dispose();
        });

        Then("'(\\d+)' rule is executed", (Integer count) ->{
            assertTrue(noOfRuleFired == count);
        });
    }
}
