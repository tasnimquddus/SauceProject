package com.SpartaGlobal.GroupA.WebFramework.pom.Tests;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout.CheckoutInfoPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout.CoCompletePage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout.CoOverviewPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.InventoryPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CompleteOrderTests {
    private static WebDriver webDriver;
    private InventoryPage inventoryPage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver";
    private CoOverviewPage coOverviewPage;
    private CheckoutInfoPage checkoutInfoPage;
    private CoCompletePage coCompletePage;

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
        coCompletePage = coOverviewPage.finishCheckout();

    }

    @Test
    @DisplayName("Check Cancel button on Check Your Information Pg to Your cart Page")
    public void completeOrder(){
        Assertions.assertEquals("https://www.saucedemo.com/checkout-complete.html", coCompletePage.getURL() );

    }


    @AfterEach
    void teardown(){ webDriver.close(); }

    @AfterAll
    static void teardownAll(){webDriver.quit();}


}
