package com.example.task05;

/**
 * Точка в двумерном пространстве
 */
public class Point {
    private double x;
    private double y;

    /**
     * Конструктор, инициализирующий координаты точки
     *
     * @param x координата по оси абсцисс
     * @param y координата по оси ординат
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Подсчитывает расстояние от текущей точки до точки, переданной в качестве параметра
     *
     * @param point вторая точка отрезка
     * @return расстояние от текущей точки до переданной
     */
    public double getLength(Point point) {
        double diffX = point.x - this.x;
        double diffY = point.y - this.y;

        return Math.sqrt(diffX * diffX + diffY * diffY);
    }

}
