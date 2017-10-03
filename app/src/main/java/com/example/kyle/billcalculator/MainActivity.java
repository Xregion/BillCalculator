package com.example.kyle.billcalculator;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tipAmount = (TextView) findViewById(R.id.tip_amount_output);
        final TextView totalAmount = (TextView) findViewById(R.id.total);

        final EditText billAmount = (EditText) findViewById(R.id.editText_bill);
        final EditText tipPercentage = (EditText) findViewById(R.id.editText_tip_percentage);

        final Button calculate = (Button) findViewById(R.id.calculate_button);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(billAmount.getText().toString().trim()) || TextUtils.isEmpty(tipPercentage.getText().toString().trim())) {
                    Toast.makeText(MainActivity.this, "Please insert a Bill and Tip Percentage", Toast.LENGTH_LONG).show();
                } else {
                    TipCalculator calculator = new TipCalculator(Float.valueOf(billAmount.getText().toString()), Float.valueOf(tipPercentage.getText().toString()));
                    tipAmount.setText("$" + String.format("%.2f", calculator.CalculateTip()));
                    totalAmount.setText("$" + String.format("%.2f", calculator.CalculateTotal()));
                }
            }
        });
    }
}
