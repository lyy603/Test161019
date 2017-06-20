package com.example.testing.test161019.hellocharts.formatter;

import com.example.testing.test161019.hellocharts.model.SliceValue;

public interface PieChartValueFormatter {

    public int formatChartValue(char[] formattedValue, SliceValue value);
}
