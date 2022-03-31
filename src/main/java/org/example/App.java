package org.example;

import javax.swing.*;
import java.time.LocalDateTime;


public class App 
{
    static private Thread th;
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());
        CustomFrame f = new CustomFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(550,550);
        f.setVisible(true);
         addClock(f);
        th.start();
    }

    static private void addClock(CustomFrame f) {
        th = new Thread(() -> {
            // write here...
            while (true) {
                LocalDateTime now = LocalDateTime.now();
                String msg = now.toString();
                f.setMsg(msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }// end of λ
        );
    }
}
