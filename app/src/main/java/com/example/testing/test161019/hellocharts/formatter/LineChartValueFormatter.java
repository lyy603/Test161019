package com.example.testing.test161019.hellocharts.formatter;

import com.example.testing.test161019.hellocharts.model.PointValue;

public interface LineChartValueFormatter {

    public int formatChartValue(char[] formattedValue, PointValue value);
}
