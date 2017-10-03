package com.example.kyle.billcalculator;

/**
 * Created by Kyle on 9/29/2017.
 */

public class TipCalculator {
    float bill;
    float tip;

    public TipCalculator (float _bill, float _tip) {
        SetBill(_bill);
        SetTip(_tip);
    }

    public float GetBill() {
        return bill;
    }

    public float GetTip() {
        return tip;
    }

    public void SetBill(float _bill) {
        bill = _bill;
    }

    public void SetTip(float _tip) {
        tip = _tip;
    }

    public float CalculateTip() {
        return bill * (tip / 100);
    }

    public float CalculateTotal() {
        return CalculateTip() + bill;
    }
}
