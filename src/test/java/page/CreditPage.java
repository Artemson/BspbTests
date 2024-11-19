package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditPage extends BasePage{

    public CreditPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//button[text()='Кредит']")
    private WebElement tabCredit;
    @FindBy(xpath="//input[preceding-sibling::p[text()='Сумма кредита']]")
    private WebElement amountCredit;
    @FindBy(xpath="//input[preceding-sibling::p[text()='Срок кредита']]")
    private WebElement timeCredit;
    @FindBy(xpath="//div[@role='tabpanel' and not (@hidden)]//*[preceding-sibling::p[text()='Ежемесячный платеж']]")
    private WebElement res;

    public void inputData(String amount, String time){
        actions.moveToElement(tabCredit).click().perform();
        inputData(amountCredit, amount);
        inputData(timeCredit, time);
    }

    public String waitAndGetActualResult(String expectedResult){
        waitTextInElement(res, expectedResult);
        return res.getText();
    }

}
