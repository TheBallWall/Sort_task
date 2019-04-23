package com.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ConsoleModel implements Model {
    View view;

    public ConsoleModel(View view) {
        this.view = view;
    }

    public Data getData() throws IOException {
        Data d = new Data();

        // Строка позволяющая установитькодировку текста
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

        view.show("Введите целое число, соответсвующее кол-ву слов для сортировки:");
        boolean done = false;
        // Процедура ввода данных
        while (!done) {
            try {
                d.setLen(Integer.parseInt(reader.readLine())); // Попытка получить целое число из строки
                if (d.getLen() == 0) throw new ArithmeticException(); // 0 не устраивает
                if (d.getLen() < 0) return d; // Отрицательное значение означает выход из программы
                done = true;
            } catch (Exception e) {
                view.show("Попробуйте снова");
            }
        }
        view.show("Введите сортируемые слова через пробел:");
        d.setInputString(reader.readLine());

        return d;
    }
}
