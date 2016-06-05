/*
 * Copyright (c) 2016 Raphael Levy. All Rights Reserved.
 */

package com.raphaellevy.math.perspective;

import java.util.function.Function;

/**
 * Created by raffa on 6/4/16.
 */
public class PersMain2D {
    public static void main(String[] args) {
        double a=4;
        double b=4;

        double cx=12;
        double cy=8;

        double q1=10;
        double r1=3;

        double q2=6;
        double r2=9;

        double m1=(cy-b)/(cx-a);
        double m2=(r2-r1)/(q2-q1);

        double allthat = r1-b-m2*q1+m1*a;

        double x = allthat / (m1-m2);
        double y = m1*x+b-m1*a;
        System.out.println(x);
        System.out.println(y);

    }
    static Function<Double,Double> calcE(double a, double b, double c, double d) {
        return (x) -> (d - b) / (c - a) * x + b - (d - b) / (c - a) * a;
    }
}
