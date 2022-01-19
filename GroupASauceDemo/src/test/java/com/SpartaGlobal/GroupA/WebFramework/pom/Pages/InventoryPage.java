package com.SpartaGlobal.GroupA.WebFramework.pom.Pages;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout.CoCartPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Social.FacebookPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Social.LinkedInPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Social.TwitterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class InventoryPage {
    private WebDriver webDriver;
    private By CartPage =  By.xpath("//*[@id=\"shopping_cart_container\"]/a");


    public InventoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public void getURL() {
        webDriver.getCurrentUrl();
    }

    public CoCartPage gotoCartPage() {
        WebElement firstResult = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(CartPage));
        webDriver.findElement(CartPage).click();
        return new CoCartPage(webDriver);
    }
}

//    public FacebookPage goToFacebookPage() {
//        WebElement FbPage = webDriver.findElement(By.cssSelector("Facebook")).click();
//        return new FacebookPage(webDriver);
//    }
    //WebElement vegetable = driver.findElement(By.className("tomatoes"));
//
//    public TwitterPage goToTwitterPage() {
//        webDriver.findElement(By.className("social_twitter")).click();
//        return new TwitterPage(webDriver);
//    }
//
//    public LinkedInPage goToLinkedInPage() {
//        webDriver.findElement(By.className("social_linkedin")).click();
//        return new LinkedInPage(webDriver);
//    }






