package com.example.task02;

public class TimeSpan {
    private int seconds;
    private int minutes;
    private int hours;

    public TimeSpan(int hours, int minutes, int seconds) {
        int extraMinutes = seconds / 60;
        this.seconds = seconds % 60;

        int totalMinutes = minutes + extraMinutes;

        int extraHours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;

        this.hours = hours + extraHours;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void add(TimeSpan time) {
        int minutes = this.minutes + time.minutes;
        int seconds = this.seconds + time.seconds;

        this.hours += time.hours;

        if (minutes >= 60) {
            this.hours += minutes / 60;
            this.minutes = minutes % 60;
        } else {
            this.minutes += time.minutes;
        }
        // 1 час 30 минут + 130 минут. К часам прибавляем 160 / 60 = 2, а минут становится 160 % 60 = 40.
        // В итогу получается 3 часа 40 минут
        // int minutes нужна, чтобы понять, выходит ли время за рамки
        // Мы забираем у текущего времени минуты, и вместе с добавленными минутами, разбиваем это время на часы
        // и оставшиеся минуты присваиваются нашим минутам.

        if (seconds >= 60) {
            this.minutes += seconds / 60;

            if (this.minutes >= 60) {
                this.hours += this.minutes / 60;
                this.minutes = this.minutes % 60;
            }

            this.seconds = seconds % 60;
        } else {
            this.seconds += time.seconds;
        }

    }

    public void subtract(TimeSpan time) {
        if (time.hours > this.hours) {
            this.hours = 0;
            this.minutes = 0;
            this.seconds = 0;
            return; // не продолжаем дальше
        } else {
            this.hours -= time.hours;
        }

        if ((time.minutes > this.minutes) && this.hours == 0) {
            this.minutes = 0;
            this.seconds = 0;
            return;
        }

        if (time.minutes / 60 > this.hours) {
            this.hours = 0;
            this.minutes = 0;
            this.seconds = 0;
            return;
        } else {
            this.hours -= time.minutes / 60;

            int minutesToSubtract = time.minutes % 60;

            if (minutesToSubtract > this.minutes) {
                this.hours -= 1;
                this.minutes += 60;
            }
            this.minutes -= minutesToSubtract;
        }
        // Было 1:10:20, вычитаем 0:40:50
        // Вычитаем time.minutes / 60 = 0, осталось 1:10:20
        // Оставшиеся минуты для вычитания равны 40, они больше чем наши 10 минут
        // Вычитаем час (больше не получится) и добавляем 60 минут. 0:70:20
        // Исправляем минуты: 70 - те минуты для вычитания, то есть получается 0:30:20
        // Это только для часов и минут.
        // Остаётся вычесть 50 секунд

        if (time.seconds > this.seconds) {
            if (this.minutes > 0) {
                this.minutes--;
                this.seconds = 60 - (time.seconds - this.seconds);
            } else {
                if (hours > 0) {
                    this.hours--;
                    this.minutes = 59;
                    this.seconds = 60 - (time.seconds - this.seconds);
                } else {
                    this.minutes = 0;
                    this.seconds = 0;
                }
            }
        } else {
            this.seconds -= time.seconds;
        }
    }

    public String toString() {
        return String.format("Часов: %d%nМинут: %d%nСекунд: %d", hours, minutes, seconds);
    }
}
