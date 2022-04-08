package stepsPO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class comprarCursoPO {
    @Given("^I access Iterasys website PO$")
    public void iAccessIterasysWebsitePO() {
        System.out.println("passo 1");
    }

    @When("^I search for \"([^\"]*)\" and click on search button PO$")
    public void iSearchForAndClickOnSearchButtonPO(String arg0) {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^I see the search results for \"([^\"]*)\" PO$")
    public void iSeeTheSearchResultsForPO(String arg0) {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^I click on class name PO$")
    public void iClickOnClassNamePO() {
        System.out.println("passo 2");
    }

    @Then("^I confirm the Class' name as \"([^\"]*)\" and it's price as \"([^\"]*)\" PO$")
    public void iConfirmTheClassNameAsAndItSPriceAsPO(String arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions

    }
}
