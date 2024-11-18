package test;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import page.CityChoosePage;
import page.CreditPage;
import page.DepositPage;
import page.MortgagePage;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class BpsbTests extends BaseTest {
    SoftAssertions softAssertions = new SoftAssertions();

    @Test
    public void cityChoose() {
        String EXPECTED_RESULT = "Красндар";
        CityChoosePage cityChoosePage = new CityChoosePage(driver);
        cityChoosePage.openSite(driver);
        cityChoosePage.chooseCity(EXPECTED_RESULT);
        softAssertions.assertThat(cityChoosePage.getSelectedCity()).as("Check city choose").isEqualTo(EXPECTED_RESULT);
        softAssertions.assertAll();
    }

    @Test
    public void credit() {
        String EXPECTED_RESULT = "105 746 ₽";
        CreditPage creditPage = new CreditPage(driver);
        creditPage.openSite(driver);
        creditPage.inputData("2_000_000", "27");
        softAssertions.assertThat(creditPage.getResult(EXPECTED_RESULT)).as("Check credit results").isEqualTo(EXPECTED_RESULT);
        softAssertions.assertAll();
    }

    @Test
    public void deposit() throws InterruptedException {
        final List<String> EXPECTED_RESULTS = Arrays.asList("5 895 730 ₽", "18 %");
        DepositPage depositPage = new DepositPage(driver);
        depositPage.openSite(driver);
        depositPage.inputData("16_310_000", "733");
        softAssertions.assertThat(depositPage.getResults(EXPECTED_RESULTS)).as("Check deposit results").isEqualTo(EXPECTED_RESULTS);
        softAssertions.assertAll();
    }

    @Test
    public void mortgage() {
        final List<String> EXPECTED_RESULTS = Arrays.asList("42 600 ₽", "6.00%");
        MortgagePage mortgagePage = new MortgagePage(driver);
        mortgagePage.openSite(driver);
        mortgagePage.inputData("7_985_000", "201", "2_607_142");
        List<String> results = mortgagePage.getResults(EXPECTED_RESULTS);
        softAssertions.assertThat(mortgagePage.getResults(EXPECTED_RESULTS)).as("Check mortgage results").isEqualTo(EXPECTED_RESULTS);
        softAssertions.assertAll();
    }


}
