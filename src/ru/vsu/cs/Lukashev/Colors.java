package ru.vsu.cs.Lukashev;

import java.awt.*;
import java.util.Arrays;


public class Colors
{

    private Color red= Color.RED;
    private Color green=Color.green;
    private Color blue=Color.BLUE;
    private Color magenta=Color.magenta;
    private Color orange=Color.ORANGE;
    private Color cyan=Color.CYAN;
    private Color pink=Color.PINK;
    private Color DEFAULT_COLOR=new Color(0f,0f,0f,0f);

    public Color getDEFAULT_COLOR() {
        return DEFAULT_COLOR;
    }

    private Color[] arrColors=
            {
                    red,
                    green,
                    blue,
                    magenta,
                    orange,
                     cyan,
//                    pink//7
            };

    public void setArrColors(Color[] arrColors)
    {
        this.arrColors = arrColors;
    }



    public Color[] getArrColors() {
        return arrColors;
    }



}
