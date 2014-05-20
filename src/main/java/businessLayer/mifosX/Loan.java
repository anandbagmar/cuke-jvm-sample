package businessLayer.mifosX;

import businessLayer.Base;
import pages.mifosX.LoanPage;

public class Loan extends Base{

    public void addLoanToCreatedClient(String product) {
        LoanPage loanPage = new LoanPage();
        loanPage.addLoan(product);
    }
}
