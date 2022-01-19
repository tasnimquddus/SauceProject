package com.SpartaGlobal.GroupA.WebFramework.pom.Tests;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.InventoryPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.LoginPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Social.FacebookPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SocialMediaTests {
    private static WebDriver webDriver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private FacebookPage FbPage;
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
        inventoryPage = new InventoryPage(webDriver);
        FbPage = new FacebookPage(webDriver);
        loginPage = new LoginPage(webDriver, "standard_user", "secret_sauce");
    }

//    @Test
//    @DisplayName("Checking the facebook button works")
//    public void facebookTest() {
//        String login= loginPage.login();
//        Assertions.assertEquals("https://www.facebook.com/saucelabs", inventoryPage.goToFacebookPage().getURL());
//    }

////    @Test
////    @DisplayName("Checking the twitter button works")
////    public void twitterTest() {
////        Assertions.assertEquals("https://twitter.com/saucelabs", inventoryPage.goToTwitterPage());
////    }
////
////    @Test
////    @DisplayName("Checking the linkedin button works")
////    public void linkedinTest() {
////        Assertions.assertEquals("https://www.linkedin.com/company/sauce-labs/", inventoryPage.goToLinkedInPage());
////    }
//
    @AfterEach
    void teardown(){
        webDriver.close();
    }

    @AfterAll
    static void teardownAll(){
        webDriver.quit();
    }
}
