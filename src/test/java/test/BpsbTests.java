package test;

import org.junit.jupiter.api.Test;
import page.CityChoosePage;
import page.CreditPage;
import page.DepositPage;
import page.MortgagePage;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class BpsbTests extends BaseTest {


    @Test
    public void cityChoose() {
        String expected = "Ростов-на-ону";
        CityChoosePage cityChoosePage = new CityChoosePage(driver);
        cityChoosePage.openSite(driver);
        cityChoosePage.chooseCity(expected);
        String actual = cityChoosePage.getSelectedCity();
        assertThat(actual).as("Check city choose").isEqualTo(expected);

    }

    @Test
    public void credit() {
        String expected = "105 746 ₽";
        CreditPage creditPage = new CreditPage(driver);
        creditPage.openSite(driver);
        creditPage.inputCreditData("2_000_000", "27");
        String actual = creditPage.getActualResult();
        assertThat(actual).as("Check credit results").isEqualTo(expected);

    }

    @Test
    public void deposit() throws InterruptedException {
        Map<String, String> expected = Map.of("wageDeposit", "5 895 730 ₽", "rateDeposit", "18 %");
        DepositPage depositPage = new DepositPage(driver);
        depositPage.openSite(driver);
        depositPage.inputDepositData("16_310_000", "733");
        Map<String, String> actual = depositPage.getActualResults();
        assertThat(actual).as("Check deposit results").isEqualTo(expected); // Работа с мапой

    }

    @Test
    public void mortgage() {
        Map<String, String> expected = Map.of("monthlyPayment", "42 600 ₽", "rate", "6.00%");
        MortgagePage mortgagePage = new MortgagePage(driver);
        mortgagePage.openSite(driver);
        mortgagePage.inputMortgageData("7_985_000", "201", "2_607_142");
        Map<String, String> actual = mortgagePage.getActualResult();
        assertThat(mortgagePage.getActualResult()).as("Check mortgage results").isEqualTo(expected);
    }


}
