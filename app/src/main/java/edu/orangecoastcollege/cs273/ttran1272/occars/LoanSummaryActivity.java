package edu.orangecoastcollege.cs273.ttran1272.occars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LoanSummaryActivity extends AppCompatActivity {

    private String report_line1, report_line2, report_line3, report_line4, report_line5, report_line6,
            report_line7, report_line8, report_line9, report_line10, report_line11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        Bundle extras = getIntent().getExtras();


        String loanTerm = extras.getString("term");
        String priceAmount = extras.getString("price");
        String downPayment = extras.getString("downPmt");
        String borrow = extras.getString("borrow");
        String interest = extras.getString("interest");
        String monthlyPayment = extras.getString("monthlyPmt");
        String tax = extras.getString("tax");
        String totalCost = extras.getString("total");


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



        loanSummaryTextView.setText(report_line1 + " " + monthlyPayment + report_line2 + priceAmount
        + report_line3 + " " + downPayment + " " + report_line4 + " " +tax + " " + report_line5 + " "
        + totalCost + report_line6 + " " + borrow + report_line7 + " " + report_line8 + interest + " "
                + report_line9 + " " + loanTerm );

        noteTextView.setText(report_line10 + report_line11);

    }
}
