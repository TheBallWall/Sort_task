package com.task;


class ConsoleView implements View {

    public void show(String[] res) {
        for (String s : res) {
            System.out.println(s);
        }
    }

    public void show(String message) {
        System.out.println(message);
    }
}