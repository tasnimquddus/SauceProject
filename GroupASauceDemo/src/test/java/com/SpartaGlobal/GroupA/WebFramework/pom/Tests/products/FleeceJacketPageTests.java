package com.SpartaGlobal.GroupA.WebFramework.pom.Tests.products;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.InventoryPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.products.FleeceJacketPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FleeceJacketPageTests {
    private static WebDriver webDriver;
    private InventoryPage inventoryPage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";
    private FleeceJacketPage fleeceJacketPage;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", DRIVER_LOCATION);
    }

    @BeforeEach
    void setupEach() {
        ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("headless");
        webDriver = new ChromeDriver(chromeOptions);
        inventoryPage = new InventoryPage(webDriver, "standard_user", "secret_sauce");
        fleeceJacketPage = inventoryPage.goToFleeceJacketPage();
    }

    @Test
    @DisplayName("Check navigation from inventory page to backpack page")
    public void navigateToBikeLightPageTest() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory-item.html?id=5", fleeceJacketPage.getURL());
    }

    @Test
    @DisplayName("Check the add to cart and remove buttons work")
    public void cartTests() {
        fleeceJacketPage.addFleeceJacketToCart();
        Assertions.assertEquals(1, fleeceJacketPage.itemsInCart());
        fleeceJacketPage.removeFleeceJacketFromCart();
        fleeceJacketPage.addFleeceJacketToCart();
        Assertions.assertEquals(1, fleeceJacketPage.itemsInCart());
    }

    @Test
    @DisplayName("Check navigation from backpack page to inventory")
    public void navigateToInventoryPageTest() {
        fleeceJacketPage.backToProductsButton();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", fleeceJacketPage.getURL());
    }

    @AfterEach
    void teardown() {
        webDriver.close();
    }

    @AfterAll
    static void teardownAll() {
        webDriver.quit();
    }
}
