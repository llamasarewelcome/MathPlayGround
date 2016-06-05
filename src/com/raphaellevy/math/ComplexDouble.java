/*
 * Copyright (c) 2016 Raphael Levy. All Rights Reserved.
 */

package com.raphaellevy.math;

/**
 * Created by raffa on 5/30/16.
 */
public class ComplexDouble {
    public static final ComplexDouble zero = new ComplexDouble(0,0);
    public double Re;
    public double Im;

    public ComplexDouble(double Re, double Im) {
        this.Re = Re;
        this.Im = Im;
    }
    public void println() {
        String rstring = Double.toString(Re);
        String istring = Double.toString(Im);
        System.out.println(rstring+"+"+istring+"i");
    }
    public ComplexDouble squared() {
        return multiplyCD(this,this);
    }
    public static ComplexDouble multiplyCD(ComplexDouble a, ComplexDouble b) {
        double rere = a.Re * b.Re;
        double reim = a.Re * b.Im; //*i
        double imre = a.Im * b.Re; //*i
        double imim = a.Im * b.Im; //*i*i=*-1
        return new ComplexDouble(rere-imim,reim+imre);
    }
    public static ComplexDouble addCD(ComplexDouble a, ComplexDouble b) {
        return new ComplexDouble(a.Re+b.Re,a.Im+b.Im);
    }

    public double magnitude() {
        return Math.sqrt(Re*Re+Im*Im);
    }
}
