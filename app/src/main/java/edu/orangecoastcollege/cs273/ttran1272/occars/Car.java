package edu.orangecoastcollege.cs273.ttran1272.occars;

/**
 * Created by ttran1272 on 9/29/2017.
 */

public class Car {

    public static final double APR_3_YEARS = 0.0462;
    public static final double APR_4_YEARS = 0.0419;
    public static final double APR_5_years = 0.0416;
    public static final double TAX_RATE = 0.075;


    private double mDownPayment;
    private int mLoanTerm;
    private double mPrice;

    public Car() {
        mDownPayment = 0.0;
        mLoanTerm = 0;
        mPrice = 0.0;
    }

    public double getDownPayment() {
        return mDownPayment;
    }

    public void setDownPayment(double downPayment) {
        mDownPayment = downPayment;
    }

    public int getLoanTerm() {
        return mLoanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        mLoanTerm = loanTerm;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public double calculateBorrowedAmount(){
        if (mPrice > mDownPayment)
            return mPrice - mDownPayment;
        else
            return 0;
    }

    public double calculateInterestAmount() {

        double interest;

        switch (mLoanTerm){
            case 3:
                interest = calculateBorrowedAmount() * APR_3_YEARS * mLoanTerm;
                break;
            case 4:
                interest = calculateBorrowedAmount() * APR_4_YEARS * mLoanTerm;
                break;
            case 5:
                interest = calculateBorrowedAmount() * APR_5_years * mLoanTerm;
                break;
            default:
                interest = 0.0;
        }

        return interest;
    }

    public double calculateMonthlyPayment() {
        if (mLoanTerm > 0)
            return (calculateBorrowedAmount() + calculateInterestAmount() + calculateTaxAmount())/ (12 * mLoanTerm) ;
        else
            return 0;
    }

    public double calculateTotalCost(){
        return mPrice + calculateTaxAmount() + calculateInterestAmount();
    }

    public double calculateTaxAmount(){
        return mPrice * TAX_RATE;
    }
}

