package edu.orangecoastcollege.cs273.ttran1272.occars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class LoanSummaryActivity extends AppCompatActivity {

    private String report_line1, report_line2, report_line3, report_line4, report_line5, report_line6,
            report_line7, report_line8, report_line9, report_line10, report_line11;

    private String loanTerm, priceAmount, downPayment, borrow, interest, monthlyPayment, tax, totalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        Bundle extras = getIntent().getExtras();

        if (extras == null){
            Log.e("Extras is null" , "");
        }

        loanTerm = extras.getString("term");
        priceAmount = extras.getString("price");
        downPayment = extras.getString("downPmt");
        borrow = extras.getString("borrow");
        interest = extras.getString("interest");
        monthlyPayment = extras.getString("monthlyPmt");
        tax = extras.getString("tax");
        totalCost = extras.getString("total");


        TextView loanSummaryTextView = (TextView) findViewById(R.id.loanSummaryTextView);
        TextView noteTextView = (TextView) findViewById(R.id.noteTextView);

        report_line1 = getResources().getString(R.string.report_line1);
        report_line2 = getResources().getString(R.string.report_line2);
        report_line3 = getResources().getString(R.string.report_line3);
        report_line4 = getResources().getString(R.string.report_line4);
        report_line5 = getResources().getString(R.string.report_line5);
        report_line6 = getResources().getString(R.string.report_line6);
        report_line7 = getResources().getString(R.string.report_line7);
        report_line8 = getResources().getString(R.string.report_line8);
        report_line9 = getResources().getString(R.string.report_line9);
        report_line10 = getResources().getString(R.string.report_line10);
        report_line11 = getResources().getString(R.string.report_line11);



        loanSummaryTextView.setText(report_line1 + " " + monthlyPayment + "\n" + report_line2 + priceAmount
        + report_line3 + " " + downPayment + " "  + report_line5 + " "
        + tax + report_line6 + " " + totalCost + report_line7 + " " + borrow + report_line8 + interest + "\n"
               +  report_line4 + " " + loanTerm + " years.");

        noteTextView.setText(report_line9 + report_line10 +  report_line11);

    }


    public void finish(View v) {
        this.finish();
    }


}
