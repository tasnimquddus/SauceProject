package com.SpartaGlobal.GroupA.WebFramework.pom.Tests;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.InventoryPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ItemsToCartTests {
    private static WebDriver webDriver;
    private InventoryPage inventoryPage;
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
    }

    @Test
    public void addingAndRemovingItemsInTheCart() {
        inventoryPage.addBackpackToCart();
        Assertions.assertEquals(1, inventoryPage.itemsInCart());
        inventoryPage.addBikeLightToCart();
        Assertions.assertEquals(2, inventoryPage.itemsInCart());
        inventoryPage.addBoltTShirtToCart();
        Assertions.assertEquals(3, inventoryPage.itemsInCart());
        inventoryPage.addFleeceJacketToCart();
        Assertions.assertEquals(4, inventoryPage.itemsInCart());
        inventoryPage.addOnesieToCart();
        Assertions.assertEquals(5, inventoryPage.itemsInCart());
        inventoryPage.addTestTShirtToCart();
        Assertions.assertEquals(6, inventoryPage.itemsInCart());
        inventoryPage.removeBackpackFromCart();
        Assertions.assertEquals(5, inventoryPage.itemsInCart());
        inventoryPage.removeBikeLightFromCart();
        Assertions.assertEquals(4, inventoryPage.itemsInCart());
        inventoryPage.removeBoltTShirtFromCart();
        Assertions.assertEquals(3, inventoryPage.itemsInCart());
        inventoryPage.removeFleeceJacketFromCart();
        Assertions.assertEquals(2, inventoryPage.itemsInCart());
        inventoryPage.removeOnesieFromCart();
        Assertions.assertEquals(1, inventoryPage.itemsInCart());
        inventoryPage.addBackpackToCart();
        inventoryPage.removeTestTShirtFromCart();
        Assertions.assertEquals(1, inventoryPage.itemsInCart());
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
