package com.task;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void execute() throws IOException {
        for (; ; ) {
            Data data = model.getData();

            // Если в модель было передано отрицательное целое число, то ппрограмма завершит работу на данном этапе
            if (data.getLen() < 0) {
                view.show("Выход");
                break;
            }

            // Получить отдельные слова из строки
            String[] res = data.getInputString().split(" ");

            // Проверка на соответсвие указанного числа и реального кол-ва введённых слов
            if (res.length != data.getLen()) {
                view.show("Исходные данные несоответствуют. Попробуйте снова");
            } else {
                sort(res);

                view.show(res);
            }
        }
    }

    // Обновлённый метод сортировки. Здесь использована сортировка вставками. Хоть сложность и составляет n^2
    // для работы с небольшимы массивами данных данный алгоритм является оптимальным. Кроме того, его использование
    // сильно уменьшило количество кода и увеличило эффективность программы. Как видно в самом методе, теперь основное
    // условие (кол-во гласных) проверяется в условии цикла. В теле обрабатывается единственный случай, когда не должна
    // происходить перестановка элементов: кол-во гласных совпадает и длина рассматриваемого слова больше длины предыдущего.
    public void sort(String[] s) {
        for (int i = 1; i < s.length; i++) {
            for (int j = i; (j > 0) && (vowelCount(s[(j - 1)]) <= vowelCount(s[j])); j--) {
                if ((vowelCount(s[(j - 1)]) == vowelCount(s[j])) && (s[(j - 1)].length() < s[j].length())) {
                    break;
                }
                swap(j, s);
            }
        }
    }

    // Перестановка элементов
    public void swap(int ind, String[] s) {
        String temp = s[(ind - 1)];
        s[(ind - 1)] = s[ind];
        s[ind] = temp;
    }

    // Счёт гласных букв
    public int vowelCount(String b) {
        int count = 0;
        Set<Character> vowel = new java.util.HashSet(Arrays.asList(new Character[]{Character.valueOf('а'), Character.valueOf('е'), Character.valueOf('ё'), Character.valueOf('и'), Character.valueOf('о'), Character.valueOf('у'), Character.valueOf('ы'), Character.valueOf('э'), Character.valueOf('ю'), Character.valueOf('я')}));
        for (int i = 0; i < b.length(); i++) {
            if ((vowel.contains(Character.valueOf(b.charAt(i)))) || (vowel.contains(Character.valueOf(Character.toLowerCase(b.charAt(i)))))) {
                count++;
            }
        }
        return count;
    }
}
