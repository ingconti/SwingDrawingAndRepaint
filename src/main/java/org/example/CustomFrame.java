package org.example;

import javax.swing.*;
import java.awt.*;

public class CustomFrame extends JFrame {
    private String msg = "Hello";

    // veery bad hack:
    //Graphics g = null;

    public CustomFrame(String title) throws HeadlessException {
        super(title);
    }

    public void paint(Graphics g) {
        // this.g = g; // fake, trying to save to paint in code.
        super.paint(g); // always call this first - if not dont erase..

        g.drawString(msg, 200, 50);
        int x = 30;
        int y = 100;
        int rectwidth = 50;
        int rectheight = 100;

        g.drawRect(x, y, rectwidth, rectheight);
    }

    public void setMsg(String msg) {
        this.msg = msg;
        System.out.println(msg);
        // dont update.. crash...
        //paint(this.g);
        this.repaint();
        /* NO NEED....
        // https://www.oracle.com/java/technologies/painting.html#swing

        SwingUtilities.invokeLater(
                () -> {
                    System.out.println(Thread.currentThread().getId());
                    this.repaint();
                }
                );*/
        this.repaint();
    }
}

