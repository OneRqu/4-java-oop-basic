package com.example.task04;

public class Line {
    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public boolean isCollinearLine(Point p) {
        int x1 = p2.getX() - p1.getX();
        int y1 = p2.getY() - p1.getY();

        int x2 = p.getX() - p1.getX();
        int y2 = p.getY() - p1.getY();

        int crossProduct = x1 * y2 - y1 * x2;
        return crossProduct == 0;
    }


    public String toString() {
        return String.format("Координаты первой точки: (x: %d, y: %d)%n"
                + "Координаты второй точки: (x: %d, y: %d)", p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}
