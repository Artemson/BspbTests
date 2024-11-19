package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

public class DepositPage extends BasePage {
    Map<String, WebElement> mapWebElements = new HashMap<String, WebElement>();

    @FindBy(xpath = "//button[text()='Вклад']")
    private WebElement tabDeposit;
    @FindBy(xpath = "//input[preceding-sibling::p[text()='Сумма вклада']]")
    private WebElement amountDeposit;
    @FindBy(xpath = "//h2[preceding-sibling::p[text()='Доход']]")
    private WebElement wageDeposit;
    @FindBy(xpath = "//div[@role='tabpanel' and not (@hidden)]//h2[preceding-sibling::p[text()='Ставка']]")
    private WebElement rateDeposit;

    public DepositPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        mapWebElements.put("wageDeposit", wageDeposit);
        mapWebElements.put("rateDeposit", rateDeposit);
    }

    public void inputDepositData(String amount, String period) throws InterruptedException {
        actions.moveToElement(tabDeposit).click().perform();

        waitElementBeClicable(amountDeposit);
        inputData(amountDeposit, amount);
        WebElement periodDeposit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'chakra-radio__label')][preceding-sibling::input[@value='" + period + "']]")));
        actions.moveToElement(periodDeposit).click().perform();
    }


    public Map<String, String> waitAndGetActualResult(Map<String, String> expectedResult) {
        Map<String, String> actualResults = new HashMap<String, String>();
        for (String key : expectedResult.keySet()) {
            waitTextInElement(mapWebElements.get(key), expectedResult.get(key));
            actualResults.put(key, mapWebElements.get(key).getText());
        }
        return actualResults;
    }

}
