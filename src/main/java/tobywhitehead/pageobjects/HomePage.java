package tobywhitehead.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AbstractPageMethods {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "About")
    WebElement aboutButton;

    @FindBy(linkText = "Store")
    WebElement storeButton;

    @FindBy(linkText = "Gmail")
    WebElement gmailButton;

    @FindBy(linkText = "Images")
    WebElement imagesButton;

    @FindBy(css = "a[aria-label='Google apps']")
    WebElement appsButton;

    @FindBy(css = "input[title='Search']")
    WebElement searchBox;

    @FindBy(name = "btnI")
    WebElement feelingLuckyButton;

    public void searchBoxEnterText(String text) {
        waitForElementToBeVisible(searchBox);
        searchBox.sendKeys(text);
    }

    public void searchBoxEnterTextAndReturn(String text) {
        searchBoxEnterText(text);
        searchBox.sendKeys(Keys.RETURN);
    }

    public void clickSearchButton() {
        By googleSearchBy = By.name("btnK");
        WebElement googleSearchButton = driver.findElement(googleSearchBy);
        submitElement(googleSearchButton);
    }

    public void clickFeelingLuckyButton() {
        By feelingLuckyBy = By.name("btnI");
        WebElement feelingLuckyButton = driver.findElement(feelingLuckyBy);
        submitElement(feelingLuckyButton);
    }

    public void clickAppsButton() {
        clickElement(appsButton);
    }

    public void clickImagesButton() {
        clickElement(imagesButton);
    }

    public void clickGmailButton() {
        clickElement(gmailButton);
    }

    public void clickStoreButton() {
        clickElement(storeButton);
    }

    public void clickAboutButton() {
        clickElement(aboutButton);
    }

    public void searchBoxEnterTextAndClickSearch(String text) {
        searchBoxEnterText(text);
        searchBox.sendKeys(Keys.ESCAPE);
        clickSearchButton();
    }

    public void searchBoxEnterTextAndClickFeelingLucky(String text) {
        searchBoxEnterText(text);
        searchBox.sendKeys(Keys.ESCAPE);
        clickFeelingLuckyButton();
    }

    public void submitElement(WebElement webElement) {
        webElement.submit();
    }
}
