package com.task;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        View view = new ConsoleView();
        view.show("Данная программа сортирует слова по убыванию кол-ва гласных букв и по возрастанию общего кол-ва букв");
        view.show("Вначале учитывается первый признак, причём при соотвествии длины слов и кол-ва гласных слова будут выведены в обратном вводу порядке");
        view.show("--Для выхода из программы введите в следующее поле (ввода целых чисел) отрицательное число--");
        Model model = new ConsoleModel(view);
        Controller controller = new Controller(model, view);
        controller.execute();
    }
}
