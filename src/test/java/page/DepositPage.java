package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class DepositPage extends BasePage {

    public DepositPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Вклад']")
    private WebElement tabDeposit;
    @FindBy(xpath = "//input[preceding-sibling::p[text()='Сумма вклада']]")
    private WebElement amountDeposit;
    @FindBy(xpath = "//h2[preceding-sibling::p[text()='Доход']]")
    private WebElement wageDeposit;
    @FindBy(xpath = "//div[@role='tabpanel' and not (@hidden)]//h2[preceding-sibling::p[text()='Ставка']]")
    private WebElement rateDeposit;

    public void inputData(String amount, String period) throws InterruptedException {
        actions.moveToElement(tabDeposit).click().perform();

        waitElement(amountDeposit);
        inputData(amountDeposit, amount);
        WebElement periodDeposit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class, 'chakra-radio__label')][preceding-sibling::input[@value='" + period + "']]")));
        Thread.sleep(200);
        actions.moveToElement(periodDeposit).click().perform();
    }

    public List<String> waitAndGetActualResult(List<String> expectedResult){
        waitTextInElement(wageDeposit, expectedResult.get(0));
        waitTextInElement(rateDeposit, expectedResult.get(1));
        return Arrays.asList(wageDeposit.getText(),rateDeposit.getText());

    }

}
