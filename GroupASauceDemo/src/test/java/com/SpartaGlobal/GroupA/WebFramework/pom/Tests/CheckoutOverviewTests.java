package com.SpartaGlobal.GroupA.WebFramework.pom.Tests;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout.CheckoutInfoPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout.CoOverviewPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.InventoryPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckoutOverviewTests {
    private static WebDriver webDriver;
    private InventoryPage inventoryPage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";
    private CoOverviewPage coOverviewPage;
    private CheckoutInfoPage checkoutInfoPage;

    @BeforeAll
    static void beforeAll(){
        System.setProperty("webdriver.chrome.driver", DRIVER_LOCATION);
    }

    @BeforeEach
    void setupEach(){
        ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("headless");
        webDriver = new ChromeDriver(chromeOptions);
        inventoryPage = new InventoryPage(webDriver, "standard_user", "secret_sauce");
        checkoutInfoPage = inventoryPage.gotoCartPage().goToCheckoutInformation();
        checkoutInfoPage.fillInfo("a", "a", "a");
        coOverviewPage = checkoutInfoPage.continueCheckout();
    }

    @Test
    @DisplayName("Check correct current url")
    public void currentURLTest() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", coOverviewPage.getURL());
    }

    @Test
    @DisplayName("Check cancel button")
    public void cancelButtonTest() {
        coOverviewPage.cancelCheckout();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", coOverviewPage.getURL());
    }

    @Test
    @DisplayName("Check finish button")
    public void finishButtonTest() {
        coOverviewPage.finishCheckout();
        Assertions.assertEquals("https://www.saucedemo.com/checkout-complete.html", coOverviewPage.getURL());
    }

    @AfterEach
    void teardown(){ webDriver.close(); }

    @AfterAll
    static void teardownAll(){ webDriver.quit();}
}
