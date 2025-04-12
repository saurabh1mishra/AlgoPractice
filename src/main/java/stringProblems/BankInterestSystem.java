package stringProblems;


import java.util.HashMap;
import java.util.Map;

/**
 * Create a EMI Calculator application which will provide the interestRate and EMI amount to user
 * System should have a capability to add / update bank details such as bank name, loan type and interest rates for loan types
 * Providing principle amount, bank name, tenure and type of loan as input return the out put as Bank name, type of loan, interest rate and monthly EMI
 * Eg.
 * [
 * {HDFC Bank, Personal, 10%},
 * {HDFC Bank, Car, 8%},
 * {HDFC Bank, Home, 7.5%},
 * {SBI Bank, Personal, 9.5%},
 * {SBI Bank, Car, 7.5%},
 * {SBI Bank, Home, 6.5%},
 * {Axis Bank, Car, 10%}
 * {Axis Bank, Home, 10%}
 * ]
 * <p>
 * Input: Bank Name : HDFC Bank, Type of loan: Home Loan, loan amount : 50,00,000 and tenure : 20 years
 * Output : 40,280
 * <p>
 * <p>
 * <p>
 * The mathematical formula to calculate EMI :
 * <p>
 * <p>
 * EMI = [P x R x (1+R)^N]/[{(1+R)^N}-1]
 * Here P is the Principal Loan Amount, R is the Rate of Interest (on a monthly basis), and N is the Tenure or the loan duration in months.
 **/

// Main class should be named 'Solution'
class BankInterestSystem {

    enum BANK {
        HDFC, SBI, AXIS,
    }

    enum LOAN_TYPE {
        PERSONAL, CAR, HOME;
    }

    static Map<BANK, Map<LOAN_TYPE, Double>> bankDetails = new HashMap<>();

    public static Float calculateEMI(BANK bankName, LOAN_TYPE loantype, Integer laonAmount, Integer tenure) {
        Float IntrestInMonths = (float) (tenure * 12);

        Double rateOfInterset = BankInterestSystem.bankDetails.get(bankName).get(loantype);

        Float monthlyRateOfInterset = (float) (rateOfInterset / 12);

        Float denominator = Float.valueOf((1 + monthlyRateOfInterset));

        return (laonAmount * monthlyRateOfInterset * denominator) / (denominator - 1);
    }


    public static void main(String[] args) {
        System.out.println("Hello, World");


        Map<LOAN_TYPE, Double> hdfcLoanDetails = new HashMap<>();
        hdfcLoanDetails.put(LOAN_TYPE.PERSONAL, 10.00);
        hdfcLoanDetails.put(LOAN_TYPE.CAR, 8.00);
        hdfcLoanDetails.put(LOAN_TYPE.HOME, 7.5);
        bankDetails.put(BANK.HDFC, hdfcLoanDetails);


        Map<LOAN_TYPE, Double> sbiLoanDetails = new HashMap<>();
        sbiLoanDetails.put(LOAN_TYPE.PERSONAL, 9.5);
        sbiLoanDetails.put(LOAN_TYPE.CAR, 7.5);
        sbiLoanDetails.put(LOAN_TYPE.HOME, 6.5);
        bankDetails.put(BANK.SBI, sbiLoanDetails);


        Map<LOAN_TYPE, Double> axisLoanDetails = new HashMap<>();
        axisLoanDetails.put(LOAN_TYPE.CAR, 10.0);
        axisLoanDetails.put(LOAN_TYPE.HOME, 10.0);
        bankDetails.put(BANK.AXIS, axisLoanDetails);

        calculateEMI(BANK.HDFC, LOAN_TYPE.HOME, 5000000, 20);
    }
}
