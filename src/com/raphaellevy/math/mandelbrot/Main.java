package com.raphaellevy.math.mandelbrot;

import com.raphaellevy.math.ComplexDouble;
import com.raphaellevy.math.graphics.Graphics;

import static com.raphaellevy.math.ComplexDouble.addCD;
import static com.raphaellevy.math.ComplexDouble.zero;

/**
 * Created by raffa on 5/30/16.
 */
public class Main {
    static final double ESCAPE = 20;
    public static void main(String args[]) {

//        ComplexDouble x = new ComplexDouble(1,1);
//        System.out.println(isIn(x));
        //ComplexDouble y = new ComplexDouble(2,5);
        //ComplexDouble z = zero;
//        for (int i = 0;i<20;i++) {
//            z = f(x,z);
//            z.println();
//        }
        Graphics.plotComplexSet(Main::isIn);
    }
    public static boolean isIn(ComplexDouble v) {
        ComplexDouble z = zero;
        for (int i = 0;i<100;i++) {
            z = f(v,z);
            //z.println();
            if(z.magnitude()>=ESCAPE) {
                return false;
            }
        }
        return true;
    }
    public static ComplexDouble f(ComplexDouble c, ComplexDouble z) {
        return addCD(z.squared(),c);
    }
}
