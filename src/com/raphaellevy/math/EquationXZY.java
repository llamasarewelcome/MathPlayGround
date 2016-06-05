/*
 * Copyright (c) 2016 Raphael Levy. All Rights Reserved.
 */

package com.raphaellevy.math;

/**
 * Created by raffa on 6/5/16.
 */
public class EquationXZY {
    //ax+bz+c=y
    public double a;
    public double b;
    public double c;
    public EquationXZY(double a, double b, double c) {
        this.a=a;
        this.b=b;
        this.c=c;
    }

    @Override
    public String toString() {
        return String.format("y = %sx + %sz + %s",a,b,c);
    }
}
