package ru.vsu.cs.Lukashev;

import javax.swing.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;

public class FlasksPaint extends JPanel
{
    int xLeftUpper=200;
    int yLeftUpper=170;
    private List<Color> f = new ArrayList<>();
    private final List<Flask> flaskList= new ArrayList<>();
    private Color[] lowLayerColor;
    private  Color[] middleLayerColor;
    private Color[] UpLayerColor;
    private final int n=8;


    public FlasksPaint(int xLeftUpper, int yLeftUpper, Color[] lowLayerColor, Color[] middleLayerColor, Color[] upLayerColor)
    {
        this.xLeftUpper = xLeftUpper;
        this.yLeftUpper = yLeftUpper;
        this.lowLayerColor = lowLayerColor;
        this.middleLayerColor = middleLayerColor;
        this.UpLayerColor = upLayerColor;



    }


    public Color getListColor(int i){return flaskList.get(i).getListLastColor();}
    public void setListColor(Color color, int i)
    {
        flaskList.get(i).setListColor(color);
    }

    public int isPointFlask(int x, int y)
    {
        int xFlaskContainer;
        int yFlaskContainer;
        for(int i=0;i<n;i++)
        {
            xFlaskContainer=flaskList.get(i).getxFlask();
            yFlaskContainer=flaskList.get(i).getyFlask();
            if(x>xFlaskContainer-20&&x<xFlaskContainer+120
                    &&y>yFlaskContainer-20&&y<yFlaskContainer+200)
            {
                return i;
            }
        }

        return 666;
    }


    public boolean checkWinner()
    {
        ArrayList<Color> listColor;
        Color colorContainer;
        for(int i=0;i<n;i++)
        {
            listColor=flaskList.get(i).getListColor();
            colorContainer=listColor.get(0);
            for(Color color: listColor)
            {
                if (!colorContainer.equals(color))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public void setLowLayerColor(Color[] lowLayerColor)
    {
        this.lowLayerColor = lowLayerColor;
    }

    public void setMiddleLayerColor(Color[] middleLayerColor) {
        this.middleLayerColor = middleLayerColor;
    }

    public void setUpLayerColor(Color[] upLayerColor) {
        this.UpLayerColor = upLayerColor;
    }

    public void addFlaskList()
    {
        int xStep=300;
        int yStep=300;
        int x=xLeftUpper;
        int y=yLeftUpper;
        for(int k=0; k<n/4;k++)
        {
            for(int i=0;i<n/2;i++)
            {
                flaskList.add(i, new Flask(x, y, getLowLayerColor(),
                        getMiddleLayerColor(), getUpLayerColor()));
                x+=xStep;
            }
            x=xLeftUpper;
            y+=yStep;
        }
    }

    public void drawFlaskList(Graphics2D g)
    {
        for(int i=0; i<n; i++)
        {
            flaskList.get(i).paint(g);
        }
    }


    public Color getLowLayerColor() {
        int count=0;
        Color color;
        for (Color value : lowLayerColor) {
            if (value == Color.GRAY) {
                count++;
            }
        }
        int i= (int) (Math.random() * (lowLayerColor.length-count));
        Color[] newArrColor= new Color[lowLayerColor.length];
        color= lowLayerColor[i];
        for(int t = 0, k = 0; t< lowLayerColor.length; t++)
        {
            if(t!=i)
            {
                newArrColor[k]= lowLayerColor[t];
                k++;
            }
        }
        newArrColor[lowLayerColor.length-1]=Color.GRAY;
        setLowLayerColor(newArrColor);
        return color;
    }


    public Color getMiddleLayerColor()
    {
        int count=0;
        Color color;
        for (Color value : middleLayerColor) {
            if (value == Color.GRAY) {
                count++;
            }
        }
        int i= (int) (Math.random() * (middleLayerColor.length-count));
        Color[] newArrColor= new Color[middleLayerColor.length];
        color= middleLayerColor[i];
        for(int t = 0, k = 0; t< middleLayerColor.length; t++)
        {
            if(t!=i)
            {
                newArrColor[k]= middleLayerColor[t];
                k++;
            }
        }
        newArrColor[middleLayerColor.length-1]=Color.GRAY;
        setMiddleLayerColor(newArrColor);
        return color;
    }


    public Color getUpLayerColor()
    {
        int count=0;
        Color color;
        for (Color value : UpLayerColor) {
            if (value == Color.GRAY) {
                count++;
            }
        }
        int i= (int) (Math.random() * (UpLayerColor.length-count));
        Color[] newArrColor= new Color[UpLayerColor.length];
        color= UpLayerColor[i];
        for(int t = 0, k = 0; t< UpLayerColor.length; t++)
        {
            if(t!=i)
            {
                newArrColor[k]= UpLayerColor[t];
                k++;
            }
        }
        newArrColor[UpLayerColor.length-1]=Color.GRAY;
        setUpLayerColor(newArrColor);
        return color;
    }

    /**
     *
     *
     *
     *
     *
     */

    private static class Flask
    {
        private final int xFlask;
        private final int yFlask;
        private Color lowLayer;
        private Color middleLayer;
        private Color upLayer;
        private final Color DEFAULT_COLOR=new Colors().getDEFAULT_COLOR();


        private ArrayList<Color> listColor=new ArrayList<>();


        public void listColorAddColor()
        {
            listColor.add(0,lowLayer);
            listColor.add(1, middleLayer);
            listColor.add(2, upLayer);
        }

        public ArrayList<Color> getListColor()
        { return listColor;}

        public Color getListLastColor()
        {
            Color colorContainer;
            int count=2;
            for (Color color : listColor) {
                if (color.equals(DEFAULT_COLOR) || color.equals(Color.GRAY))
                {
                    count--;
                }
            }
            colorContainer=listColor.get(count);
            listColor.set(count, DEFAULT_COLOR);
            return colorContainer;
        }

        public int getxFlask() {
            return xFlask;
        }

        public int getyFlask() {
            return yFlask;
        }

        public void setListColor(Color color)
        {
            int count=0;
            for(int i=0;i<listColor.size();i++)
            {
                if(!listColor.get(listColor.size()-1-i).equals(DEFAULT_COLOR)&&!listColor.get(listColor.size()-1-i).equals(Color.GRAY))
                {
                    count++;
                }
            }
            if(count<3)
            {
                listColor.set(count, color);

            }
        }



        public Flask(int xFlask, int yFlask, Color lowLayer, Color middleLayer, Color upLayer)
        {
            this.xFlask = xFlask;
            this.yFlask = yFlask;
            this.lowLayer = lowLayer;
            this.middleLayer = middleLayer;
            this.upLayer = upLayer;
            listColorAddColor();
        }



        public void drawFlask(Graphics2D g) {

            if (listColor.get(0) == null || listColor.get(0) == Color.GRAY) {
                listColor.set(0, DEFAULT_COLOR); //lowLayer
            }
            if (listColor.get(1) == null || listColor.get(1) == Color.GRAY) {
                listColor.set(1, DEFAULT_COLOR);//middleLayer
            }
            if (listColor.get(2) == null || listColor.get(2) == Color.GRAY) {
                listColor.set(2, DEFAULT_COLOR); // upLayer
            }

            if (listColor.get(0) == listColor.get(1) && listColor.get(2) == listColor.get(1)) {
                g.setColor(listColor.get(0));
                int[] xArrColorAll = {xFlask + 120, xFlask - 70, xFlask, xFlask, xFlask + 50, xFlask + 50};
                int[] yArrColorAll = {yFlask + 170, yFlask + 170, yFlask + 80, yFlask + 20, yFlask + 20, yFlask + 80};
                g.fillPolygon(xArrColorAll, yArrColorAll, 6);
            } else if (listColor.get(2) == listColor.get(1)) {
                int[] xArrColorMU = {xFlask + 90, xFlask - 40, xFlask, xFlask, xFlask + 50, xFlask + 50};
                int[] yArrColorMU = {yFlask + 130, yFlask + 130, yFlask + 80, yFlask + 20, yFlask + 20, yFlask + 80};
                int[] xArrColorL = {xFlask + 120, xFlask - 70, xFlask - 40, xFlask + 90};
                int[] yArrColorL = {yFlask + 170, yFlask + 170, yFlask + 130, yFlask + 130};
                g.setColor(listColor.get(0));
                g.fillPolygon(xArrColorL, yArrColorL, 4);
                g.setColor(listColor.get(1));
                g.fillPolygon(xArrColorMU, yArrColorMU, 6);
                g.setColor(Color.BLACK);
                g.drawLine(xFlask-38, yFlask+130, xFlask+88, yFlask+130);
            } else if (listColor.get(0) == listColor.get(1)) {
                int[] xArrColorLM = {xFlask + 120, xFlask - 70, xFlask, xFlask + 50};
                int[] yArrColorLM = {yFlask + 170, yFlask + 170, yFlask + 80, yFlask + 80};
                int[] xArrColorU = {xFlask + 50, xFlask, xFlask, xFlask + 50};
                int[] yArrColorU = {yFlask + 80, yFlask + 80, yFlask + 20, yFlask + 20};
                g.setColor(listColor.get(0));
                g.fillPolygon(xArrColorLM, yArrColorLM, 4);
                g.setColor(listColor.get(2));
                g.fillPolygon(xArrColorU, yArrColorU, 4);
                g.setColor(Color.BLACK);
                g.drawLine(xFlask, yFlask+80, xFlask+50, yFlask+80);

            } else {
                int[] xArrColorL = {xFlask + 120, xFlask - 70, xFlask - 40, xFlask + 90};
                int[] xArrColorM = {xFlask + 90, xFlask - 40, xFlask, xFlask + 50};
                int[] xArrColorU = {xFlask + 50, xFlask, xFlask, xFlask + 50};
                int[] yArrColorL = {yFlask + 170, yFlask + 170, yFlask + 130, yFlask + 130};
                int[] yArrColorM = {yFlask + 130, yFlask + 130, yFlask + 80, yFlask + 80};
                int[] yArrColorU = {yFlask + 80, yFlask + 80, yFlask + 20, yFlask + 20};
                g.setColor(listColor.get(0));
                g.fillPolygon(xArrColorL, yArrColorL, 4);

                g.setColor(listColor.get(1));
                g.fillPolygon(xArrColorM, yArrColorM, 4);

                g.setColor(listColor.get(2));
                g.fillPolygon(xArrColorU, yArrColorU, 4);

                g.setColor(Color.BLACK);
                g.drawLine(xFlask, yFlask+80, xFlask+50, yFlask+80);
                g.drawLine(xFlask-38, yFlask+130, xFlask+88, yFlask+130);
            }
        }


        public void paint(Graphics2D g)
        {
            drawFlask(g);
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(5));
            int[] xArrFlask={xFlask, xFlask+50, xFlask+50,xFlask+120,xFlask-70,xFlask};
            int[] yArrFlask={yFlask,yFlask,yFlask+80,yFlask+170,yFlask+170,yFlask+80};
            g.drawPolygon(xArrFlask,yArrFlask,6);
        }
    }
}
