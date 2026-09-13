package com.example.task04;

/**
 * Класс точки на плоскости
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Считает расстояние от текущей точки до переданной
     *
     * @param point вторая точка
     * @return расстояние между точками
     */
    public double distance(Point point) {
        int diffX = point.x - this.x;
        int diffY = point.y - this.y;

        return Math.sqrt(diffX * diffX + diffY * diffY);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
