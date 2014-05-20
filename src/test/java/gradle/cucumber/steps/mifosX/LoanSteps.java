package gradle.cucumber.steps.mifosX;

import cucumber.api.java.en.When;
import businessLayer.mifosX.Loan;

public class LoanSteps {
    @When("^I add \"([^\"]*)\" as a new loan application$")
    public void I_add_as_a_new_loan_application(String product) throws Throwable {
        Loan loan = new Loan();
        loan.addLoanToCreatedClient(product);
    }
}
