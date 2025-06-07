package sample;

import java.io.Serializable;

public class Point_2D implements Serializable {
    private double x, y;
    Point_2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double Y) {
        this.y = y;
    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
}
