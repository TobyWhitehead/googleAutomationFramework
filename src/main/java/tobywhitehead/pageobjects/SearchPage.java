package tobywhitehead.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends AbstractPageMethods {

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "All")
    WebElement allLink;

    @FindBy(linkText = "Videos")
    WebElement videosLink;

    @FindBy(linkText = "Images")
    WebElement imagesLink;

    @FindBy(css = "input[aria-label='Search']")
    WebElement searchBox;

    public void clickImagesLink() {
        scrollToElement(imagesLink);
        clickElement(imagesLink);
    }

    public String getSearchBoxText() {
        scrollToElement(searchBox);
        return searchBox.getAttribute("value");
    }

}