package edu.orangecoastcollege.cs273.ttran1272.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PurchaseActivity extends AppCompatActivity {

    private Car mCar;

    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioGroup loanTermRadioGroup;
    private RadioButton threeYearsTermRButton;
    private RadioButton fourYearsTermRButton;
    private RadioButton fiveYearsTermRButton;
    private int loanTerm;
    private double carPrice;
    private double downPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        mCar = new Car();

    }

    public void getInformation() {

        carPriceEditText = (EditText) findViewById(R.id.carPriceET);
        downPaymentEditText = (EditText) findViewById(R.id.downPaymentET);

        threeYearsTermRButton = (RadioButton) findViewById(R.id.threeYearsRadioButton);
        fourYearsTermRButton = (RadioButton) findViewById(R.id.fourYearsRadioButton2);
        fiveYearsTermRButton = (RadioButton) findViewById(R.id.fiveYearsRadioButton3);

        loanTermRadioGroup = (RadioGroup) findViewById(R.id.radioButtonGroup);
        int selectedID = loanTermRadioGroup.getCheckedRadioButtonId();

        switch (selectedID) {
            case 0:
                loanTerm = 3;
                break;
            case 1:
                loanTerm = 4;
                break;
            case 2:
                loanTerm = 5;
                break;
            default:
                loanTerm = 0;
        }

        carPrice = Double.parseDouble(carPriceEditText.getText().toString());
        downPayment = Double.parseDouble(downPaymentEditText.getText().toString());

        mCar.setPrice(carPrice);
        mCar.setDownPayment(downPayment);
        mCar.setLoanTerm(loanTerm);

    }


    protected void goToLoanReport(View v) {

        getInformation();

        double borrowedAmount = mCar.calculateBorrowedAmount();
        double interestAmount = mCar.calculateInterestAmount();
        double monthlyPayment = mCar.calculateMonthlyPayment();
        double taxAmount = mCar.calculateTaxAmount();
        double totalCost = mCar.calculateTotalCost();

        Intent myIntent = new Intent(this, LoanSummaryActivity.class);
        myIntent.putExtra("loanTerm", loanTerm);
        myIntent.putExtra("priceAmount", carPrice);
        myIntent.putExtra("downPayment", downPayment);
        myIntent.putExtra("borrowAmt", borrowedAmount);
        myIntent.putExtra("interestAmt", interestAmount);
        myIntent.putExtra("monthlyPymt", monthlyPayment);
        myIntent.putExtra("taxAmount", taxAmount);
        myIntent.putExtra("totalCost", totalCost);
        startActivity(myIntent);
   }
}
