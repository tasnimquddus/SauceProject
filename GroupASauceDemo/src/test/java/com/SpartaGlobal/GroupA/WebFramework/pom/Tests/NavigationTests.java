package com.SpartaGlobal.GroupA.WebFramework.pom.Tests;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.InventoryPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.LoginPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.YourCartPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.Matchers.equalTo;

public class NavigationTests {
    private static WebDriver webDriver;
    private InventoryPage inventoryPage;
    private YourCartPage yourCartPage;
    private LoginPage loginPage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver";

    @BeforeAll
    static void beforeAll(){
        System.setProperty("webdriver.chrome.driver", DRIVER_LOCATION);
    }

    @BeforeEach
    void setupEach(){
        ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("headless");
        webDriver = new ChromeDriver(chromeOptions);
        loginPage = new LoginPage(webDriver,"standard_user", "secret_sauce");
        inventoryPage = new InventoryPage(webDriver);
        yourCartPage = new YourCartPage(webDriver);
    }

    @Test
    @DisplayName("Ensure that I can navigate back to the Inventory page from the your cart page ")
    public void pressingContinueShoppingButton(){
        String login = loginPage.login();
//        InventoryPage inventoryPage = yourCartPage.pressingContinueShoppingButton();
        Assertions.assertEquals(yourCartPage.pressingContinueShoppingButton().getURL(), equalTo("https://www.saucedemo.com/inventory.html"));
    }

//    private InventoryPage yourCartPage() {
//    }


    @AfterEach
    void teardown(){ webDriver.close(); }

    @AfterAll
    static void teardownAll(){ webDriver.quit();}
}
