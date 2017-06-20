package com.example.testing.test161019.hellocharts.listener;

import com.example.testing.test161019.hellocharts.model.PointValue;
import com.example.testing.test161019.hellocharts.model.SubcolumnValue;

public interface ComboLineColumnChartOnValueSelectListener extends OnValueDeselectListener {

    public void onColumnValueSelected(int columnIndex, int subcolumnIndex, SubcolumnValue value);

    public void onPointValueSelected(int lineIndex, int pointIndex, PointValue value);

}
