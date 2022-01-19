package com.SpartaGlobal.GroupA.WebFramework.pom;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.InventoryPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.Matchers.containsString;

public class LoggingInStepdefs {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private WebDriver webDriver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();

    }

    @Given("I am on the log in page,")
    public void iAmOnTheLogInPage() {
    }

    @When("I enter the correct user details")
    public void iEnterTheCorrectUserDetails() {
        loginPage = new LoginPage(webDriver, "standard_user", "secret_sauce");
    }

    @When("I enter the correct problem user details")
    public void iEnterTheCorrectProblemUserDetails() {
        loginPage = new LoginPage(webDriver, "problem_user", "secret_sauce");
    }

    @When("I enter the correct performance glitch user details")
    public void iEnterTheCorrectPerformanceGlitchUserDetails() {
        loginPage = new LoginPage(webDriver, "performance_glitch_user", "secret_sauce");
    }

    @Then("I will be taken to the inventory page and see products")
    public void iWillBeTakenToTheInventoryPageAndSeeProducts() {
        MatcherAssert.assertThat(loginPage.login(), Matchers.equalTo("https://www.saucedemo.com/inventory.html"));
    }

    @When("I do not enter a username,")
    public void iDoNotEnterAUsername() {
        loginPage = new LoginPage(webDriver, "", "secret_sauce");
    }

    @Then("I will be told Epic sadface: username is required.")
    public void iWillBeToldEpicSadfaceUsernameIsRequired() {
        loginPage.login();
        var error = webDriver.findElement(By.className("error-message-container"));
        MatcherAssert.assertThat(error.getText(), containsString("Epic sadface: Username is required"));
    }

    @When("I enter the incorrect username,")
    public void iEnterTheIncorrectUsername() {
        loginPage = new LoginPage(webDriver, "wdjw", "secret_sauce");
    }

    @Then("I will be told Epic sadface: username and password do not match any user in this service.")
    public void iWillBeToldEpicSadfaceUsernameAndPasswordDoNotMatchAnyUserInThisService() {
        loginPage.login();
        var error = webDriver.findElement(By.className("error-message-container"));
        MatcherAssert.assertThat(error.getText(), containsString("Epic sadface: Username and password do not match any user in this service"));
    }

    @When("I do not enter a password,")
    public void iDoNotEnterAPassword() {
        loginPage = new LoginPage(webDriver, "standard_user", "");
    }

    @When("I do not enter a problem password,")
    public void iDoNotEnterAProblemPassword() {
        loginPage = new LoginPage(webDriver, "problem_user", "");
    }

    @When("I do not enter a performance glitch password,")
    public void iDoNotEnterAPerformanceGlitchPassword() {
        loginPage = new LoginPage(webDriver, "performance_glitch_user", "");
    }

    @When("I do not enter a locked out password,")
    public void iDoNotEnterALockedOutPassword() {
        loginPage = new LoginPage(webDriver, "locked_out_user", "");
    }

    @Then("I will be told Epic sadface: password is required.")
    public void iWillBeToldEpicSadfacePasswordIsRequired() {
        loginPage.login();
        var error = webDriver.findElement(By.className("error-message-container"));
        MatcherAssert.assertThat(error.getText(), containsString("Epic sadface: Password is required"));
    }

    @When("I enter the incorrect password,")
    public void iEnterTheIncorrectPassword() {
        loginPage = new LoginPage(webDriver, "standard_user", "jij");
    }

    @When("I enter the incorrect problem password,")
    public void iEnterTheIncorrectProblemPassword() {
        loginPage = new LoginPage(webDriver, "problem_user", "jdbc");
    }

    @When("I enter the incorrect performance glitch password,")
    public void iEnterTheIncorrectPerformanceGlitchPassword() {
        loginPage = new LoginPage(webDriver, "performance_glitch_user", "ofiv");
    }

    @When("I enter the incorrect locked out password,")
    public void iEnterTheIncorrectLockedOutPassword() {
        loginPage = new LoginPage(webDriver, "locked_out_user", "fkjv");
    }

    @When("I enter the correct details of the locked out account,")
    public void iEnterTheCorrectDetailsOfTheLockedOutAccount() {
        loginPage = new LoginPage(webDriver, "locked_out_user", "secret_sauce");
    }

    @Then("I will be told Epic sadface: Sorry, this user has been locked out.")
        public void iWillBeToldEpicSadfaceSorryThisUserHasBeenLockedOut() {
            loginPage.login();
            var error = webDriver.findElement(By.className("error-message-container"));
            MatcherAssert.assertThat(error.getText(), containsString("Epic sadface: Sorry, this user has been locked out"));
    }
}
