package pages.mifosX;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseUIPage;
import utils.DateUtils;
import utils.DriverUtils;
import utils.PageUtils;
import utils.RuntimeUtils;

public class LoanPage extends BaseUIPage{
    private String productID = "select#productId";
    private String principalID = "principal";
    private String principal = "10000";
    private String loanTermFrequencyID = "loanTermFrequency";
    private String loanTermFrequency = "15";
    private String loanTermFrequencyTypeID = "select#loanTermFrequencyType";
    private String loanTermFrequencyType = "Months";
    private String numberOfRepaymentsID = "numberOfRepayments";
    private String numberOfRepayments = "30";
    private String repaymentEveryID = "repaymentEvery";
    private String repaymentEvery = "2";
    private String amortizationTypeID = "select#amortizationType";
    private String amortizationType = "Equal principal payments";
    private String interestCalculationPeriodTypeID = "select#interestCalculationPeriodType";
    private String interestCalculationPeriodType = "Same as repayment period";
    private String transactionProcessingStrategyID = "select#transactionProcessingStrategyId";
    private String transactionProcessingStrategy = "Mifos style";
    private String inArrearsToleranceID = "1000";
    private String submittedOnDateID = "input#submittedOnDate";
    private String expectedDisbursementDateID = "input#expectedDisbursementDate";

    public LoanPage() {
        RuntimeUtils.saveState("currentPage", this);

        int clientNumber = Integer.parseInt(RuntimeUtils.retrieveState("clientNumber").toString());
        PageUtils.navigateTo("https://demo.openmf.org/#/newclientloanaccount/" + clientNumber);
        DriverUtils.saveScreenShotAs("Loan Page", "");
    }

    public void addLoan(String product) {
        selectLoanProduct(product);
        enterDate("div[ng-controller=NewLoanAccAppController]", submittedOnDateID, DateUtils.getTodaysDate());
        enterDate("div[ng-controller=NewLoanAccAppController]", expectedDisbursementDateID, DateUtils.getTodaysDate());
        PageUtils.enterValueInInputBox(driver, principalID, principal);
        PageUtils.enterValueInInputBox(driver, loanTermFrequencyID, loanTermFrequency);
        PageUtils.selectFromDropDown(driver, loanTermFrequencyTypeID, loanTermFrequencyType);
        PageUtils.enterValueInInputBox(driver, numberOfRepaymentsID, numberOfRepayments);
    }


    private void enterDate(String parentID, String fieldID, String date) {
        WebElement parentDiv = driver.findElement(By.cssSelector(parentID));
        parentDiv.findElement(By.cssSelector(fieldID)).click();
        parentDiv.findElement(By.cssSelector(fieldID)).sendKeys(date);
        parentDiv.findElement(By.cssSelector(fieldID)).click();
        driver.findElement(By.cssSelector("input#search")).click();

    }

    private void selectLoanProduct(String product) {
        PageUtils.selectFromDropDown(driver, productID, product);
    }
}
