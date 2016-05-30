package com.raphaellevy.math.graphics;

import com.raphaellevy.math.ComplexDouble;

import javax.swing.*;
import java.awt.*;
import java.util.function.Predicate;

/**
 * Created by raffa on 5/30/16.
 */
public class Graphics {
    public static final int WWIDTH = 1250;
    public static final int WHEIGHT  = 750;
    public static void plotComplexSet(Predicate<ComplexDouble> f) {
        JFrame frame = new JFrame("Set");
        frame.setSize(WWIDTH,WHEIGHT);
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g1) {
                super.paintComponent(g1);
                Graphics2D g = (Graphics2D) g1;
                for (int m = 0;m<WWIDTH;m++) {
                    for (int n = 0;n<WHEIGHT;n++) {
                        ComplexDouble mn = new ComplexDouble(((double)(m-300)-WWIDTH/2)/400,((double)n-WHEIGHT/2)/400);
                        if (f.test(mn)) {
                            System.out.println(m+","+n);
                            g.drawLine(m,n,m,n);
                        }
                    }
                }
            }
        };
        frame.add(p);
        frame.setVisible(true);
    }
}
