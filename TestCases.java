package com.example.myapplication;
import java.util.Date;
public class TestCases {

    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        testSendMessage();
        testSendMessageMoreThen350();
        testSendMessageEmptyText();
        testSendMessageInvalidTime();
    }

    public static int testSendMessage() {
        TestCases testCases = new TestCases();
        // Вызываем метод sendMessage с неверным временем
        int result = testCases.sendMessage("Не можу заснути, просто жесть", "testUser", new Date().getTime());

        // Печатаем результат
        return result;
    }

    public static int testSendMessageMoreThen350() {
        TestCases testCases = new TestCases();
        // Вызываем метод sendMessage с неверным временем
        StringBuilder longText = new StringBuilder();
        for (int i = 0; i < 360; i++) {
            longText.append("a");
        }
        int result = testCases.sendMessage(longText.toString(), "testUser", new Date().getTime());
        // Печатаем результат
        return result;
    }

    public static int testSendMessageEmptyText() {
        TestCases testCases = new TestCases();
        // Вызываем метод sendMessage с неверным временем
        int result = testCases.sendMessage("", "testUser", new Date().getTime());

        // Печатаем результат
        return result;
    }

    public static int testSendMessageInvalidTime() {
        TestCases testCases = new TestCases();
        // Вызываем метод sendMessage с неверным временем
        int result = testCases.sendMessage("Не можу заснути, просто жесть", "testUser", new Date().getTime() - 1);

        // Печатаем результат
        return result;
    }

    public int sendMessage(String textFieldText, String username, long currentTime) {
        // Реализация метода sendMessage без зависимостей от Android
        if (textFieldText.isEmpty() || textFieldText.length() > 350) return -1;

        // Проверка соответствия времени сообщения переданному времени
        if (currentTime != new Date().getTime()) return -2;

        return 1;
    }
}

