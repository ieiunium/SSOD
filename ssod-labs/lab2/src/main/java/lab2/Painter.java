package lab2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kirill on 4.9.15.
 */
public class Painter extends JFrame {

    private Way way;

    public Painter(){
        this.setBounds(50,50,640,240);
    }

    public void start(final int ms){
        final Painter painter = this;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    painter.update(painter.getGraphics());
                    try {
                        Thread.sleep(ms);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.clearRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(Color.BLACK);
        int width = this.getWidth();
        int height = this.getHeight();
        int R = Math.min(width,height)/4;
        int x0 = width/2;
        int y0 = height/2;
        g.drawOval(x0-R,y0-R,2*R,2*R);
        int textHeight = 40;
        int textWidth = 20;
        for(Train i: way.getTrainList()){
            double t = (((double)i.getLocation())/1000)*2*Math.PI;
            int x = (int)(x0 + R * Math.cos(t) );
            int y = (int)(y0 + R * Math.sin(t) );
            g.setColor(Color.decode(i.getColor()));
            g.fillOval(x-10,y-10,19,19);
            g.drawString(i.toString(),textWidth,textHeight);
            textHeight += 20;
        }

        if(way.isCrash()){
            g.setColor(Color.BLACK);
            g.drawString("CRASH",x0,y0);
        }
    }

    public Way getWay() {
        return way;
    }

    public void setWay(Way way) {
        this.way = way;
    }
}
