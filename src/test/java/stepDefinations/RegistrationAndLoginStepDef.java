package stepDefinations;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.MyMethods;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationAndLoginStepDef extends MyMethods {
    @Given("User should be able to navigate to Pandakindermoebel home page")
    public void userShouldBeAbleToNavigateToPandakindermoebelHomePage() {
        Configuration.startMaximized = true;
        open(url);
        $(akzeptiereButton).click();


    }

    String randomPass = "";

    @When("User schould be able to enter to Mein Konto and create a new Account")
    public void userSchouldBeAbleToEnterToMeinKontoAndCreateANewAccount() {
        randomPass = generate(12);
        $(registerButton).shouldBe(Condition.appear).click();
        $(regUserNameInput).sendKeys(randomUserName());
        $(regMailInput).sendKeys(randomStringMail());
        $(regPasswordInput).sendKeys(randomPass);

        $(createCustomerButton).scrollTo().shouldBe(Condition.enabled).click();
        $$("h1.page-title").filterBy(text(randomUserName()));//By helloText = By.cssSelector("h1.page-title");

        // $(signOutButton).scrollTo().shouldBe(Condition.enabled).click();
        sleep(3000);

    }

    String randomNewPass = "";

    @Then("User should be able to enter his personal info")
    public void userShouldBeAbleToEnterHisPersonalInfo(DataTable dataTable) {
        $(kontoDetails).shouldBe(Condition.appear).click();
        randomNewPass = generate(12);

        List<String> list = dataTable.asList();
        for (int i = 0; i < $$(editAccountInput).size(); i++) {
            if (i == 2) {
                $$(editAccountInput).get(i).shouldBe(Condition.enabled).clear();
                $$(editAccountInput).get(i).setValue(list.get(i));
            } else
                $$(editAccountInput).get(i).setValue(list.get(i));
        }

        $$(editPassInput).get(0).shouldBe(Condition.appear).sendKeys(randomPass);
        $$(editPassInput).get(1).shouldBe(Condition.appear).sendKeys(randomNewPass);
        $$(editPassInput).get(2).shouldBe(Condition.appear).sendKeys(randomNewPass);
        $(saveChangesButton).shouldBe(Condition.appear).click();
        $(successfullyMessage).shouldBe(Condition.text("Kontodetails erfolgreich geändert."));
        sleep(2000);
    }

    @And("User should be able to access the contents of the menuitem")
    public void userShouldBeAbleToAccessTheContentsOfTheMenuitem() {

        for (int i = 5; i <= $$(menuItems).size()-1; i++) {
            $$(menuItems).get(i).shouldBe(Condition.appear).click();
          sleep(1000);
            Selenide.back();
        }
    }
}
