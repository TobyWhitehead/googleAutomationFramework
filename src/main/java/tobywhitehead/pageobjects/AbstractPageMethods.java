package tobywhitehead.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractPageMethods {

    WebDriver driver;

    public AbstractPageMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisible(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void clickElement(WebElement webElement) {
        waitForElementToBeVisible(webElement);
        webElement.click();
    }
}
