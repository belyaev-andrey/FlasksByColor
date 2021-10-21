package ru.vsu.cs.Lukashev;

import java.awt.*;
import java.util.List;

public class DrawFlasks
{
    public static void drawFlaskList(Graphics2D g, int n, List<FlasksList.Flask> flaskList )
    {
        for(int i=0; i<n; i++)
        {
            flaskList.get(i).paint(g);
        }
    }
}
