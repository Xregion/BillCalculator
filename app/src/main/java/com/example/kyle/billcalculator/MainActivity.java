package com.example.kyle.billcalculator;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText billAmount;
    EditText tipPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billAmount = (EditText) findViewById(R.id.editText_bill);
        tipPercentage = (EditText) findViewById(R.id.editText_tip_percentage);

        TextChangeHandler tch = new TextChangeHandler();

        billAmount.addTextChangedListener(tch);
        tipPercentage.addTextChangedListener(tch);
    }

    public void Calculate() {
        TextView tipAmount = (TextView) findViewById(R.id.tip_amount_output);
        TextView totalAmount = (TextView) findViewById(R.id.total);

        String tipPercent = tipPercentage.getText().toString();
        String bill = billAmount.getText().toString();

        try {
            TipCalculator calculator = new TipCalculator(Float.parseFloat(bill), Integer.parseInt(tipPercent));
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            tipAmount.setText(nf.format(calculator.CalculateTip()));
            totalAmount.setText(nf.format(calculator.CalculateTotal()));
        } catch (NumberFormatException e) {
            tipAmount.setText("");
            totalAmount.setText("");
        }
    }


    private class TextChangeHandler implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            Calculate();
        }
    }
}
