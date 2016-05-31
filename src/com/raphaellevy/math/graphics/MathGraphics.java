package com.raphaellevy.math.graphics;

import com.raphaellevy.math.ComplexDouble;

import javax.swing.*;
import java.awt.*;
import java.util.function.Predicate;

/**
 * Created by raffa on 5/30/16.
 */
public class MathGraphics {
    private int WWIDTH;// = 1250;
    private int WHEIGHT;//  = 750;
    private int WIDS;
    private int HIGS;
    JFrame frame;
    JPanel p = null;
    private Rectangle viewport;
    public synchronized void setViewport(Rectangle vp) {
        viewport = vp;
        p.revalidate();
        p.repaint();
    }
    public static MathGraphics init(int width,int height) {
        MathGraphics gr = new MathGraphics();
        gr.WWIDTH = width;
        gr.WHEIGHT = height;
        gr.WIDS = width;
        gr.HIGS = height;
        gr.viewport = new Rectangle(-width/2,-height/2,width,height);
        gr.frame = new JFrame("Set");
        gr.frame.setSize(gr.WWIDTH,gr.WHEIGHT);
        gr.frame.setVisible(true);
        return gr;
    }
    public int zoomFactorW() {
        return WWIDTH/WIDS;
    }
    public int zoomFactorH() {
        return WHEIGHT/HIGS;
    }
    public void plotComplexSet(Predicate<ComplexDouble> f) {

        p = new JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g1) {
                super.paintComponent(g1);
                Graphics2D g = (Graphics2D) g1;
                for (int m = 0;m<WWIDTH;m++) {
                    for (int n = 0;n<WHEIGHT;n++) {
                        ComplexDouble mn = new ComplexDouble(((double)m+viewport.x)*zoomFactorW(),((double)n+viewport.y)*zoomFactorH());
                        if (f.test(mn)) {
                            System.out.println(m+","+n);
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
