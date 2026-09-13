package com.example.task05;

/**
 * Ломаная линия
 */
public class PolygonalLine {
    private Point[] points = new Point[0]; // Обязательно инициализируем, чтобы длина бралась не у null

    /**
     * Устанавливает точки ломаной линии
     *
     * @param points массив точек, которыми нужно проинициализировать ломаную линию
     */
    public void setPoints(Point[] points) {
        if (points == null) {
            this.points = new Point[0];
            return;
        }

        this.points = new Point[points.length];

        for (int i = 0; i < points.length; i++) {
            this.points[i] = new Point(points[i].getX(), points[i].getY());
        }
    }

    /**
     * Добавляет точку к ломаной линии
     *
     * @param point точка, которую нужно добавить к ломаной
     */
    public void addPoint(Point point) {
        if (point == null) {
            return;
        }

        Point[] newPoints = new Point[points.length + 1];

        // Копируем массив
        for (int i = 0; i < points.length; i++) {
            newPoints[i] = points[i];
        }

        newPoints[newPoints.length - 1] = new Point(point.getX(), point.getY());
        points = newPoints;
    }

    /**
     * Добавляет точку к ломаной линии
     *
     * @param x координата по оси абсцисс
     * @param y координата по оси ординат
     */
    public void addPoint(double x, double y) {
        Point point = new Point(x, y);
        this.addPoint(point);
    }

    /**
     * Возвращает длину ломаной линии
     *
     * @return длину ломаной линии
     */
    public double getLength() {
        // Вычисляем расстояние между точкой и следующей, используя ранее написанный метод из класса Point

        if (points.length < 2) {
            return 0.0;
        }

        double totalLength = 0.0d;

        for (int i = 0; i < points.length - 1; i++) {
            Point current = points[i];
            Point next = points[i + 1];

            totalLength += current.getLength(next);
        }

        return totalLength;
    }

}
