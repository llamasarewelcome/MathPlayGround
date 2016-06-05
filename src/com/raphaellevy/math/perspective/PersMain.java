/*
 * Copyright (c) 2016 Raphael Levy. All Rights Reserved.
 */

package com.raphaellevy.math.perspective;

import com.raphaellevy.math.EquationXZY;
import com.raphaellevy.math.Vector3D;

/**
 * Created by raffa on 6/5/16.
 */
public class PersMain {
    public static void main(String[] args) {
        EquationXZY eq = getPlaneEquationFrom3Points(new Vector3D(3,7.2,4),new Vector3D(2,3.67,.3),new Vector3D(.84,3.267,.11));
        System.out.println(eq);
    }
    static EquationXZY getPlaneEquationFrom3Points(Vector3D vc1, Vector3D vc2, Vector3D vc3) {
        double x1 = vc1.x;
        double y1 = vc1.y;
        double z1 = vc1.z;

        double x2 = vc2.x;
        double y2 = vc2.y;
        double z2 = vc2.z;

        double x3 = vc3.x;
        double y3 = vc3.y;
        double z3 = vc3.z;

        double v = z2 * x1 / x2 - z1;
        double q = z3 * x1 / x3 - z1;
        double w = x1 / x2 - 1;
        double r = x1 / x3 - 1;
        double d = v / z1 - w;
        double e = r * v / q - w;

        double a = ((y1 * v / z1 - (y2 * x1 / x2 - y1)) * e / d - ((y3 * x1 / x3 - y1) * v / q - (y2 * x1 / x2 - y1))) / (x1 * v / z1 * e / d);
        double b = ((y2 * x1 / x2 - y1) * e / w - ((y3 * x1 / x3 - y1) * v / q - (y2 * x1 / x2 - y1))) / (v * e / w);
        double c = ((y3 * x1 / x3 - y1) * v / q - (y2 * x1 / x2 - y1)) / e;

        return new EquationXZY(a, b, c);
    }

}
