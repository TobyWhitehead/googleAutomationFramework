package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import tobywhitehead.pageobjects.AllSearchPage;
import tobywhitehead.pageobjects.HomePage;

public class SearchTextSteps {

    WebDriver driver;
    String baseUrl = "https://www.google.co.uk/";

    @Before
    public void beforeSteps() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseUrl);

        By acceptAllBy = By.xpath("//button//div[text()='Accept all']");
        WebElement acceptAllButton = driver.findElement(acceptAllBy);
        Actions scrollToButton = new Actions(driver);
        scrollToButton.scrollToElement(acceptAllButton);
        scrollToButton.perform();
        acceptAllButton.click();

    }

    @After
    public void afterSteps() {
        driver.close();
    }


    @Given("On the google engine base page")
    public void on_the_google_engine_base_page() {
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl, "Not on the google engine base page");
    }

    @When("I enter {string} and press return")
    public void i_enter_and_press_return (String string) {
        HomePage homePage = new HomePage(driver);
        homePage.searchBoxEnterTextAndReturn(string);
    }

    @Then("Search page is loaded with {string} in search box")
    public void search_page_is_loaded_with_in_search_box(String string) {
        AllSearchPage allSearchPage = new AllSearchPage(driver);
        String searchBoxText = allSearchPage.getSearchBoxText();
        Assert.assertEquals(searchBoxText, string, "Search box text: " + searchBoxText + "\nEntered search text: " + string);
    }


    @When("I enter <text> and click on the Google Search button")
    public void iEnterTextAndClickOnTheGoogleSearchButton(String text) {
        HomePage homepage = new HomePage(driver);
        homepage.searchBoxEnterTextAndClickSearch(text);
    }
}
