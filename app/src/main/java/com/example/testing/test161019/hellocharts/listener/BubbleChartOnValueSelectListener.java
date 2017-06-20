package com.example.testing.test161019.hellocharts.listener;

import com.example.testing.test161019.hellocharts.model.BubbleValue;

public interface BubbleChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int bubbleIndex, BubbleValue value);

}
