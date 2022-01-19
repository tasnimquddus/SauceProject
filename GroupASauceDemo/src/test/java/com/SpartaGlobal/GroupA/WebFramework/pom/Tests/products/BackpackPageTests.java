package com.SpartaGlobal.GroupA.WebFramework.pom.Tests.products;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.InventoryPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.products.BackpackPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BackpackPageTests {
    private static WebDriver webDriver;
    private InventoryPage inventoryPage;
    private BackpackPage backpackPage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";

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
        backpackPage = inventoryPage.goToBackpackPage();
    }

    @Test
    @DisplayName("Check navigation from inventory page to backpack page")
    public void navigateToBackpackPageTest() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory-item.html?id=4", backpackPage.getURL());
    }

    @Test
    @DisplayName("Check the add to cart and remove buttons work")
    public void cartTests() {
        backpackPage.addBackpackToCart();
        Assertions.assertEquals(1, backpackPage.itemsInCart());
        backpackPage.removeBackpackFromCart();
        backpackPage.addBackpackToCart();
        Assertions.assertEquals(1, backpackPage.itemsInCart());
    }

    @Test
    @DisplayName("Check navigation from backpack page to inventory")
    public void navigateToInventoryPageTest() {
        backpackPage.backToProductsButton();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", backpackPage.getURL());
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
