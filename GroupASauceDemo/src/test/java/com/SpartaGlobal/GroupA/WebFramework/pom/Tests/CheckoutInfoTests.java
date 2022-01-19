package com.SpartaGlobal.GroupA.WebFramework.pom.Tests;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout.CheckoutInfoPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout.YourCartPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.InventoryPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckoutInfoTests {
    private static WebDriver webDriver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private YourCartPage yourCartPage;
    private CheckoutInfoPage checkoutInfoPage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";

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

    }

    @Test
    @DisplayName("Check Cancel button on Check Your Information Pg to Your cart Page")
    public void CheckoutToOverviewPage(){
        checkoutInfoPage.fillInfo("a", "a", "a");
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html",  checkoutInfoPage.continueCheckout().getURL());

    }

    @Test
    @DisplayName("Check Cancel button on Check Your Information Pg to Your cart Page")
    public void CheckoutToCartPage(){
        checkoutInfoPage.gotoYourCartPage();
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", checkoutInfoPage.getURL() );

    }


    @AfterEach
    void teardown(){ webDriver.close(); }

    @AfterAll
    static void teardownAll(){ webDriver.quit();}
}
