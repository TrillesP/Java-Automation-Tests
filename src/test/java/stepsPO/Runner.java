package stepsPO;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
    features = {"src/test/resources/featuresPO"},
    glue = {"stepsPO"},
    monochrome = true,
    plugin = {
            "pretty",
            "html:target/reports/extendreports",
            "json:target/reports/extendsreport.json"
    }

)
public class Runner extends AbstractTestNGCucumberTests {   //Equivale ao @RunWith do JUnit

}
