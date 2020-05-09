package io.github.varunscyther.drools.stepdefs.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/io/github/varunscyther/drools/features",
        glue={"helpers", "io.github.varunscyther.drools.stepdefs.not",
                "io.github.varunscyther.drools.stepdefs.and",
                "io.github.varunscyther.drools.stepdefs.oldAndNewData"
}, monochrome = true,plugin = {"json:target/cucumber/cucumber.json"}, strict=true)
public class CucumberRunnerTest {}
