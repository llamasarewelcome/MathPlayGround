/*
 * Copyright (c) 2016 Raphael Levy. All Rights Reserved.
 */

package com.raphaellevy.math.graphics;

import com.raphaellevy.math.ComplexDouble;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.function.Predicate;

/**
 * Created by raffa on 5/30/16.
 */
public class ComplexGraphics {
    private int WWIDTH;// = 1250;
    private int WHEIGHT;//  = 750;
    private int WIDS;
    private int HIGS;
    JFrame frame;
    JPanel p = null;
    private Rectangle2D.Double viewport;
    public synchronized void setViewport(Rectangle2D.Double vp) {
        viewport = vp;
        p.revalidate();
        p.repaint();
    }
    public static ComplexGraphics init(int width, int height) {
        ComplexGraphics gr = new ComplexGraphics();
        gr.WWIDTH = width;
        gr.WHEIGHT = height;
        gr.WIDS = width;
        gr.HIGS = height;
        gr.viewport = new Rectangle2D.Double(-width/2,-height/2,width,height);
        gr.frame = new JFrame("Set");
        gr.frame.setSize(gr.WWIDTH,gr.WHEIGHT);
        gr.frame.setVisible(true);
        return gr;
    }
    public double zoomFactorW() {
        return (double)viewport.width/WIDS;
    }
    public double zoomFactorH() {
        return (double)viewport.height/HIGS;
    }
    public void plotComplexSet(Predicate<ComplexDouble> f) {

        p = new JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g1) {
                super.paintComponent(g1);
                Graphics2D g = (Graphics2D) g1;
                for (int m = 0;m<WWIDTH;m++) {
                    for (int n = 0;n<WHEIGHT;n++) {
                        ComplexDouble mn = new ComplexDouble(((double)m*zoomFactorW()+viewport.x),((double)n*zoomFactorH()+viewport.y));
                        if (f.test(mn)) {
                            //System.out.println(m+","+n);
                            g.drawLine(m,n,m,n);
                        }
                    }
                }
            }
        };
        frame.add(p);
        frame.revalidate();

    }
}
