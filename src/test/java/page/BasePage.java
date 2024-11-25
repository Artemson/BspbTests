package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class BasePage {

    private static final Logger log = LoggerFactory.getLogger(BasePage.class);
    protected String oldValue;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.actions = new Actions(driver);
    }

    public void openSite(WebDriver driver) {
        driver.get("https://www.bspb.ru/");
    }

    protected void clickElement(WebElement element) {
        waitElementBeClicable(element);
        element.click();
    }

    protected void waitElementBeClicable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitTextInElement(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    protected void waitForTextChange(WebElement element, String currentValue) {
        log.info("Waiting for text change in element...");
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, currentValue)));
        log.info("Text has changed. New value: {}", element.getText());
    }

    protected void sendData(WebElement element, String data){
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(data);
        element.sendKeys(Keys.ENTER);
    }
}
