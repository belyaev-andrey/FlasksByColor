package ru.vsu.cs.Lukashev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainPanel extends JPanel {
    Color colorContainer;
    //    Color colorContainer=new Colors().getDEFAULT_COLOR();
//    FlasksList.DrawFlaskList drawFlaskList= new FlasksList.DrawFlaskList();
//    FlasksList flasksList;
    Game game = new Game();

    public MainPanel() {
        newGame();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                int whichFlask = game.isPointFlask(x, y);
                if (SwingUtilities.isLeftMouseButton(e)) {
                    if (whichFlask != -1 && colorContainer == null) {
                        pressLeftMouseButton(whichFlask);
                    }
                }

                if (SwingUtilities.isRightMouseButton(e)) {
                    if (whichFlask != -1 && colorContainer != null) {
                        pressRightMouseButton(whichFlask);
                    }

                    if (game.checkWinner()) {
                        JOptionPane.showMessageDialog(e.getComponent(), " You are winner!!!");
                        newGame();
                    }
                }

            }
        });

    }


    private void pressLeftMouseButton(int whichFlask) {
        colorContainer = game.getFromWhichFlask(whichFlask);// чет придумать
        repaint();
    }

    private void pressRightMouseButton(int whichFlask) {
//        if(!game.getFlasksList().getFromListLastColor(whichFlask).equals(new Colors().getDEFAULT_COLOR())&&
//        if(
//               !game.getFlasksList().getFromListLastColor(whichFlask).equals(Color.GRAY))
//                game.getFlasksList().getFromListLastColor(whichFlask).equals(colorContainer))
//        {
            game.setIntoWhichFlask(whichFlask, colorContainer);// и тут
            repaint();
            colorContainer = null;
//        }

    }


    private void newGame() {
        game.updateFlaskList();
        repaint();
    }


    @Override
    public void paint(Graphics graphics) {

        super.paint(graphics);
        Graphics2D g = (Graphics2D) graphics;

        g.setColor(Color.GREEN);
        g.setStroke(new BasicStroke(3));
        g.drawRect(70, 50, 1150, 700);
        drawFlaskList(g);
//        g.setBackground(Color.decode("#0f7367"));
        System.out.println("that's all");

    }



    public void drawFlaskList(Graphics2D g)
    {
        DrawFlasks.drawFlaskList(g, game.getFlasksList().getN(), game.getFlasksList().getFlaskList());
    }
}
