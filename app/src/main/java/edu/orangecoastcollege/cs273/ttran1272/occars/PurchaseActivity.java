package edu.orangecoastcollege.cs273.ttran1272.occars;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Locale;

public class PurchaseActivity extends AppCompatActivity {

    public Car mCar;

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

        carPrice = Double.parseDouble(carPriceEditText.getText().toString());
        downPayment = Double.parseDouble(downPaymentEditText.getText().toString());

        mCar.setPrice(carPrice);
        mCar.setDownPayment(downPayment);
    }


    public void getLoanTerm(){

        threeYearsTermRButton = (RadioButton) findViewById(R.id.threeYearsRadioButton);
        fourYearsTermRButton = (RadioButton) findViewById(R.id.fourYearsRadioButton);
        fiveYearsTermRButton = (RadioButton) findViewById(R.id.fiveYearsRadioButton);

        if (threeYearsTermRButton.isChecked())
            loanTerm = 3;
        else if (fourYearsTermRButton.isChecked())
            loanTerm = 4;
        else if (fiveYearsTermRButton.isChecked())
            loanTerm = 5;
        else
            loanTerm = 0;

        mCar.setLoanTerm(loanTerm);
    }

    protected void goToLoanReport(View v) {

        getInformation();
        getLoanTerm();

        double borrowedAmount = mCar.calculateBorrowedAmount();
        double interestAmount = mCar.calculateInterestAmount();
        double monthlyPayment = mCar.calculateMonthlyPayment();
        double taxAmount = mCar.calculateTaxAmount();
        double totalCost = mCar.calculateTotalCost();

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

        Intent myIntent = new Intent(this, LoanSummaryActivity.class);
        myIntent.putExtra("term", "" + loanTerm);
        myIntent.putExtra("price", "" + format.format(carPrice));
        myIntent.putExtra("downPmt", "" + format.format(downPayment));
        myIntent.putExtra("borrow", "" + format.format(borrowedAmount));
        myIntent.putExtra("interest", "" + format.format(interestAmount));
        myIntent.putExtra("monthlyPmt", format.format(monthlyPayment));
        myIntent.putExtra("tax", "" + format.format(taxAmount));
        myIntent.putExtra("total", "" + format.format(totalCost));
        startActivity(myIntent);
   }
}
