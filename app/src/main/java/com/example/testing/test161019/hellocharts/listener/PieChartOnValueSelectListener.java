package com.example.testing.test161019.hellocharts.listener;

import com.example.testing.test161019.hellocharts.model.SliceValue;

public interface PieChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int arcIndex, SliceValue value);

}
