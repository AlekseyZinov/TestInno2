import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PobedaTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\azinov\\Desktop\\chromedrives\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.navigate().to("https://www.google.com/");
    }

    @After
    public void tearDown (){
        driver.quit();
    }

    private final String valueSearch = "Сайт компании Победа";
    private final String textInImg = "Полетели в Калининград!";
    private final By firstLinkLocator = By.xpath("//a[starts-with(@href, 'https://www.pobeda.aero/')]");
    private final By searchAreaGoogleLocator = By.xpath("//*[@name = 'q']");
    private final By goToKaliningradLocator = By.xpath("//*[contains(text(),'Полетели в Калининград')]");
    private final By buttonLangSelectionLocator = By.xpath("//*[@aria-label = 'Поиск']/parent::*/child::button[1]");
    private final By buttonEngLocator = By.xpath("//*[text() = 'English']/parent::*");
    private final By visibleTextTicketSearchLocator = By.xpath("//*[text() = 'Ticket search']");
    private final By visibleTextOnlineCheckInLocator = By.xpath("//*[text() = 'Online check-in']");
    private final By visibleTextManageMyBookingLocator = By.xpath("//*[text() = 'Manage my booking']");


    @Test
    public void tetingSitePobeda() {
        var searchAreaGoogleElement = driver.findElement(searchAreaGoogleLocator);
        searchAreaGoogleElement.sendKeys(valueSearch, Keys.ENTER);
        var firstLinkElement = driver.findElement(firstLinkLocator);
        firstLinkElement.click();
        var goToKaliningradElement = driver.findElement(goToKaliningradLocator);
        wait.until(ExpectedConditions.visibilityOf(goToKaliningradElement));
        Assert.assertEquals(goToKaliningradElement.getText(), textInImg);
        var buttonLangSelectionElement = driver.findElement(buttonLangSelectionLocator);
        buttonLangSelectionElement.click();
        var buttonEngElement = driver.findElement(buttonEngLocator);
        buttonEngElement.click();
        var visibleTextTicketSearchElement = driver.findElement(visibleTextTicketSearchLocator);
        var visibleTextOnlineCheckInElement = driver.findElement(visibleTextOnlineCheckInLocator);
        var visibleTextManageMyBookingElement = driver.findElement(visibleTextManageMyBookingLocator);
        visibleTextTicketSearchElement.isDisplayed();
        visibleTextOnlineCheckInElement.isDisplayed();
        visibleTextManageMyBookingElement.isDisplayed();
    }
}
