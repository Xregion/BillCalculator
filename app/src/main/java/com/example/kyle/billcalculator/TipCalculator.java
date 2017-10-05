package com.example.kyle.billcalculator;

/**
 * Created by Kyle on 9/29/2017.
 */

public class TipCalculator {
    float bill;
    int tip;

    public TipCalculator (float _bill, int _tip) {
        SetBill(_bill);
        SetTip(_tip);
    }

    public float GetBill() {
        return bill;
    }

    public int GetTip() {
        return tip;
    }

    public void SetBill(float _bill) {
        bill = _bill;
    }

    public void SetTip(int _tip) {
        tip = _tip;
    }

    public float CalculateTip() {
        return bill *  ((float) tip / 100);
    }

    public float CalculateTotal() {
        return CalculateTip() + bill;
    }
}
