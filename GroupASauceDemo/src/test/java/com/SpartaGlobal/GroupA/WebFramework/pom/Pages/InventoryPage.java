package com.SpartaGlobal.GroupA.WebFramework.pom.Pages;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout.YourCartPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Social.FacebookPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {
    private WebDriver webDriver;
    private By CartPage = By.xpath("//*[@id=\"shopping_cart_container\"]/a");


    private By FbPage = By.xpath(("/html/body/div[1]/div/footer/ul/li[2]"));
    //#page_wrapper > footer > ul > li.social_facebook > a
//            xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a");


    //*[@id="page_wrapper"]/footer/ul/li[2]/a

    public InventoryPage(WebDriver webDriver, String username, String password) {
        this.webDriver = webDriver;
        LoginPage loginPage = new LoginPage(webDriver, username, password);
        loginPage.login();
    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    public YourCartPage gotoCartPage() {

        WebElement toCartPg = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(CartPage));
        toCartPg.click();
        return new YourCartPage(webDriver);
    }

//
//


//    public FacebookPage goToFacebookPage() {
//        WebElement element = new WebDriverWait (webDriver, )
//                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
//        webDriver.findElement(FbPage).click();
//        WebElement FbPageResult = new WebDriverWait(webDriver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(FbPage));
//        FbPageResult.click();

//        return new FacebookPage(webDriver);
//    }
//}
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


}


