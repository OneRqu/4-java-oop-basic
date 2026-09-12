package com.example.task01;

/**
 * Класс точки на плоскости
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * "Вращает" точку относительно начала координат на 180 градусов
     */
    public void flip() {
        int oldX = x;
        x = -y;
        y = -oldX;
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
