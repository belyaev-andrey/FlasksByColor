package ru.vsu.cs.Lukashev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainPanel extends JPanel
{
    int xLeftUpper=175;
    int yLeftUpper=170;
    Color colorContainer=new Colors().getDEFAULT_COLOR();
    Colors colors=new Colors();
    FlasksPaint flasks;



    public MainPanel()
    {
        flasks=new FlasksPaint(xLeftUpper, yLeftUpper, colors.getArrColors(),colors.getArrColors(),colors.getArrColors());
        flasks.addFlaskList();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x=e.getX();
                int y=e.getY();
                int whichFlask=flasks.isPointFlask(x,y);
                if(SwingUtilities.isLeftMouseButton(e))
                {
                    if(whichFlask!=666)
                    {

                            colorContainer=flasks.getListColor(whichFlask);
                            repaint();


                    }
                }
                    if(SwingUtilities.isRightMouseButton(e))
                {
                    if(whichFlask!=666)
                    {
                        if(colorContainer!=null)
                        {

                            flasks.setListColor(colorContainer, whichFlask);
                            repaint();
                            colorContainer = null;
                        }
                    }

                    if(flasks.checkWinner())
                    {
                        JOptionPane.showMessageDialog(e.getComponent(), " You are winner!!!");
                    }
                }
            }
        });

    }


    @Override
    public void paint(Graphics graphics)
    {

        super.paint(graphics);
        Graphics2D g=(Graphics2D)graphics;
        g.setColor(Color.GREEN);
        g.setStroke(new BasicStroke(3));
        g.drawRect(70,50,1150,700);
        flasks.drawFlaskList(g);
        System.out.println("that's all");

    }
}
