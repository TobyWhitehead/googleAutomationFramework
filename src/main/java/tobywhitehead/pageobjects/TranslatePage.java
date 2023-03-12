package tobywhitehead.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TranslatePage extends AbstractPageMethods {
    public TranslatePage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(css = "textarea[aria-label='Source text']")
//    WebElement inputTextBox;

    public void waitForPageLoad() {
        By inputTextBoxBy = By.cssSelector("div[class='QFw9Te']");
        WebElement inputTextBoxElement = driver.findElement(inputTextBoxBy);
        waitForElementToBeVisible(inputTextBoxElement);
    }

    public void translateText(String inputText) {
        waitForPageLoad();
        WebElement inputTextBox = driver.findElement(By.xpath("//div[@class='QFw9Te']/textarea"));
        inputTextBox.sendKeys(inputText);
        inputTextBox.sendKeys(Keys.RETURN);
    }

    public String getTranslatedText() {
        By translatedTextBy = By.cssSelector("div[class='lRu31']");
        WebElement translatedTextBox = driver.findElement(translatedTextBy);
        return translatedTextBox.getText();
    }
}
