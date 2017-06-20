package com.example.testing.test161019.util;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 作者：linyaye on 2016/12/16 10:27
 */

public class TestUtil {

    //截取字符串中的数字
    private void str() {
        String str = "xxx第47297章33";
        String regex = "\\d*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while (m.find()) {
//            if (!"".equals(m.group()))
//                textView.append("1:" + m.group());
        }
    }
    //时间戳时间间隔转换
    public void time(long oldTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        int second = 1000;
        int minute = 60 * 1000;
        int hour = 60 * 60 * 1000;
        long newTime = System.currentTimeMillis();
        long time = (newTime - oldTime);
        if (time / second < 60) {
//            textView.setText("1分钟前");
        } else if (time / minute < 60) {
//            textView.setText(time / minute + "分钟前");
        } else if (time / hour < 24) {
//            textView.setText(time / hour + "小时前");
        } else if (time / hour < 48) {
//            textView.setText("一天前");
        } else {
            String d = format.format(oldTime);
//            textView.setText(d);
        }
    }
}
