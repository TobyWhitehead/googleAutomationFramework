package tobywhitehead.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllSearchPage extends AbstractPageMethods{

    public AllSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='All']")
    WebElement allSpan;

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
