package com.example.testing.test161019.hellocharts.listener;

import com.example.testing.test161019.hellocharts.model.PointValue;

public interface LineChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int lineIndex, int pointIndex, PointValue value);

}
