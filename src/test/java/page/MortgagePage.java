package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MortgagePage extends BasePage {

    public MortgagePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[text()='Ипотека']")
    private WebElement tabMortgage;
    @FindBy(xpath = "//div[@role='tabpanel' and not (@hidden)]//*[preceding-sibling::p[text()='Ежемесячный платеж']]")
    private WebElement monthlyPaymentOfMortgage;
    @FindBy(xpath = "//div[@role='tabpanel' and not (@hidden)]//h2[preceding-sibling::p[text()='Ставка']]")
    private WebElement rateOfMortgage;
    @FindBy(xpath = "//input[preceding-sibling::p[text()='Стоимость недвижимости']]")
    private WebElement priceOfRealty;
    @FindBy(xpath = "//input[preceding-sibling::p[text()='Срок']]")
    private WebElement timeMortgage;
    @FindBy(xpath = "//input[preceding-sibling::p[text()='Первоначальный взнос']]")
    private WebElement initialPayment;


    public void inputData(String price, String time, String initial){
        actions.moveToElement(tabMortgage).click().perform();

        waitElement(priceOfRealty);
        inputData(priceOfRealty, price);

        waitElement(timeMortgage);
        inputData(timeMortgage, time);

        waitElement(initialPayment);
        inputData(initialPayment, initial);
    }

    public List<String> waitAndGetActualResult(List<String> expectedResult){
        waitTextInElement(monthlyPaymentOfMortgage, expectedResult.get(0));
        waitTextInElement(rateOfMortgage, expectedResult.get(1));
        return Arrays.asList(monthlyPaymentOfMortgage.getText(),rateOfMortgage.getText());
    }


}
