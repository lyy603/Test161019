package com.example.testing.test161019;

/**
 * 作者：linyaye on 2016/10/19 16:30
 * 邮箱：840567289@qq.com
 */

public class Calculator {

    public double sum(double a, double b){
        return a+b;
    }

    public double substract(double a, double b){
        return a-b;
    }

    public double divide(double a, double b){
        if(b == 0){
            return 0;
        }
        return a/b;
    }

    public double multiply(double a, double b){
        return a*b;
    }
}
