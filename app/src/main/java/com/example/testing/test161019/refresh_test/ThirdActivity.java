package com.example.testing.test161019.refresh_test;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.testing.test161019.R;
import com.example.testing.test161019.hellocharts.gesture.ContainerScrollType;
import com.example.testing.test161019.hellocharts.gesture.ZoomType;
import com.example.testing.test161019.hellocharts.model.Axis;
import com.example.testing.test161019.hellocharts.model.AxisValue;
import com.example.testing.test161019.hellocharts.model.Line;
import com.example.testing.test161019.hellocharts.model.LineChartData;
import com.example.testing.test161019.hellocharts.model.PointValue;
import com.example.testing.test161019.hellocharts.model.ValueShape;
import com.example.testing.test161019.hellocharts.model.Viewport;
import com.example.testing.test161019.hellocharts.view.LineChartView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ThirdActivity extends AppCompatActivity {

    @Bind(R.id.line_chart)
    LineChartView chart;

    @Bind(R.id.activity_third)
    RelativeLayout activityThird;

    private List<PointValue> mWeightValues = new ArrayList<PointValue>();//体重的坐标集合
    private List<PointValue> mFatValues = new ArrayList<PointValue>();//脂肪的坐标集合
    private List<AxisValue> mAxisValues = new ArrayList<AxisValue>();//时间的坐标标注集合
    private int[] weather = {100, 200, 30, 40, 50, 16, 68, 62};

    String[] date = {"08.06.2016", "09.06.2016", "10.06.2016", "11.06.2016",
            "12.06.2016", "13.06.2016", "14.06.2016", "15.06.2016", "16.06.2016",
            "17.06.2016", "18.06.2016", "19.06.2016", "20.06.2016", "21.06.2016",
            "22.06.2016", "23.06.2016", "24.06.2016", "25.06.2016", "26.06.2016",
            "27.06.2016", "28.06.2016", "29.06.2016", "30.06.2016", "31.06.2016"};//X轴的底部时间标注集合

    float[] weight = {125.8f, 124.8f, 126.1f, 127.2f, 126.5f, 126.9f, 125.9f, 126.0f,
            125.8f, 124.8f, 126.1f, 127.2f, 126.5f, 126.9f, 125.9f, 126.0f,
            125.8f, 124.8f, 126.1f, 127.2f, 126.5f, 126.9f, 125.9f, 126.0f};//图表体重数据集合

    float[] fatValue = {115.8f, 114.8f, 116.1f, 117.2f, 116.5f, 115.8f, 117.2f, 116.5f,
            114.8f, 116.1f, 116.5f, 116.9f, 115.9f, 116.9f, 115.9f, 116.0f,
            116.1f, 117.2f, 114.8f, 116.9f, 115.9f, 116.0f, 115.8f, 116.0f};//图表的脂肪数据集合

    String[] fatLable = {"15.8%", "14.8%", "16.1%", "17.2%", "16.5%", "15.8%",
            "117.2%", "16.5%", "14.8%", "16.1%", "16.5%", "16.9%", "15.9%",
            "116.9%", "15.9%", "16.0%", "16.1%", "17.2%", "14.8%", "16.9%",
            "115.9%", "16.0%", "15.8%", "16.0%"};//图表的脂肪显示的标签的数据集合


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);

        getAxisXLables();//获取x轴的标注
        getAxisPoints();//获取坐标点
        initLineChart();//初始化

    }

    /**
     * 设置X 轴的显示
     */
    private void getAxisXLables() {
        for (int i = 0; i < date.length; i++) {
            mAxisValues.add(new AxisValue(i).setLabel(date[i]));
        }
    }

    /**
     * 图表的每个点的显示
     */
    private void getAxisPoints() {
        for (int i = 0; i < date.length; i++) {
            mWeightValues.add(new PointValue(i, weight[i]));//体重坐标数据
            mFatValues.add(new PointValue(i, fatValue[i]));
        }
    }

    private void initLineChart() {    //折线的集合，也就是体重和脂肪的折线保存的集合
        List<Line> lines = new ArrayList<Line>();    //体重的折线
        Line line = new Line(mWeightValues).setColor(Color.BLUE);  //折线的颜色和坐标数据
        //折线图上每个数据点的形状（有三种 ：ValueShape.SQUARE正方形  ValueShape.CIRCLE圆点  ValueShape.DIAMOND菱形）
        line.setShape(ValueShape.CIRCLE);
        line.setStrokeWidth(2);
        line.setPointRadius(2);
        line.setCubic(true);//曲线是否平滑
        line.setFilled(false);//是否填充曲线的面积
        line.setHasLabels(true);//曲线的数据坐标是否加上备注//  line.setHasLabelsOnlyForSelected(true);//点击数据坐标提示数据（设置了这个line.setHasLabels(true);就无效）
        line.setHasLines(true);//是否用直线显示。如果为false 则没有曲线只有点显示
        line.setHasPoints(true);//是否显示圆点 如果为false 则没有原点只有点显示
        lines.add(line);//将体重折线保存到集合中

        //脂肪的折线
        Line line2 = new Line(mFatValues).setColor(Color.BLUE);  //折线的颜色和坐标数据
        line2.setShape(ValueShape.CIRCLE);
        line2.setCubic(true);//曲线是否平滑
        line2.setFilled(true);//是否填充曲线的面积
        line2.setHasLabels(true);//曲线的数据坐标是否加上备注
        line2.setHasLines(true);//是否用直线显示。如果为false 则没有曲线只有点显示
        line2.setHasPoints(false);//是否显示圆点 如果为false 则没有原点只有点显示
        lines.add(line2);//将脂肪折线保存到集合中

        // LineChartData是宏观上面的折线数据显示，
        //因为我们已经将所有的数据都填充进折线中，
        //现在只需要将它保存到LineChartData中
        LineChartData data = new LineChartData(lines);    //设置时间坐标轴
        Axis axisX = new Axis(); //X轴
        axisX.setTextColor(Color.BLACK);  //设置字体颜色
        axisX.setTextSize(8);//设置字体大小
        axisX.setValues(mAxisValues);  //填充X轴的坐标名称
        data.setAxisXBottom(axisX); //x 轴在底部

        //设置Y坐标轴
        Axis axisY = new Axis();  //Y轴
        axisY.setHasLines(true);
        data.setAxisYLeft(axisY);  //Y轴设置在左边

        //将所有的数据填充到折线控件中
        chart.setLineChartData(data);    //设置行为属性，支持缩放、滑动以及平移
        chart.setInteractive(true);
        chart.setZoomType(ZoomType.HORIZONTAL_AND_VERTICAL);
        chart.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
        chart.setVisibility(View.VISIBLE);    //设置一下整体的Y轴显示的开始和结束坐标
        final Viewport v1 = new Viewport(chart.getMaximumViewport());
        v1.bottom = 110;
        v1.top = 130;    // You have to set max and current viewports separately.
        chart.setMaximumViewport(v1);    //设置当前的窗口显示多少个坐标数据，必须将折线的可以缩放的开关打开
        Viewport v = new Viewport(chart.getMaximumViewport());
        v.left = 0;
        v.right = 6;
        chart.setCurrentViewport(v);
    }

    private void showToast() {
        Toast.makeText(this, "hahaha", Toast.LENGTH_LONG).show();
    }
}
