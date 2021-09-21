package ru.vsu.cs.Lukashev;

import java.awt.*;

public class Colorr {
    private int r,g, b;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Colorr(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }


    public static class ColorrBuilder{
        private int r, g, b;
        public ColorrBuilder withR(int r)
        {
            this.r=r;
            return this;
        }

        public ColorrBuilder withB(int b)
        {
            this.b=b;
            return this;
        }

        public ColorrBuilder withG(int g)
        {
            this.g=g;
            return this;
        }


        public Colorr build()
        {
            Colorr colorr=new Colorr(this.r, this.g, this.b);
            return colorr;
        }
    }
}
