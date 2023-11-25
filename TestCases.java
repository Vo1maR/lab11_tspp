package com.example.myapplication;

import android.widget.EditText;

import androidx.test.core.app.ActivityScenario;

import com.example.myapplication.MainActivity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

public class MainActivityTest {

    @Test
    public void testSendMessage() {
        // Запускаємо активність
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                // Створюємо макет текстового поля та встановлюємо текст
                EditText mockTextField = activity.findViewById(R.id.textField);
                mockTextField.setText("Не можу заснути, просто жесть");

                // Викликаємо функцію sendMessage
                int result = activity.sendMessage(mockTextField, "testUser", new Date().getTime());

                // Перевіряємо, чи відповідає результат очікуваному результату
                assertEquals(1, result);
            });
        }
    }

    @Test
    public void testSendMessageMoreThen350() {
        // Запускаємо активність
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                // Створюємо макет текстового поля та встановлюємо текст більше 350 символів
                EditText mockTextField = activity.findViewById(R.id.textField);
                mockTextField.setText(" Не можу заснути, просто жесть. Вчора ввечері я. Не можу заснути, просто жесть. Вчора ввечері я" +
                        " Не можу заснути, просто жесть. Вчора ввечері я  Не можу заснути, просто жесть. Вчора ввечері я" +
                        " Не можу заснути, просто жесть. Вчора ввечері я" +
                        " Не можу заснути, просто жесть. Вчора ввечері я Не можу заснути, просто жесть. Вчора ввечері я Не можу заснути, просто жесть. Вчора ввечері я" +
                        " Не можу заснути, просто жесть. Вчора ввечері я" +
                        " Не можу заснути, просто жесть. Вчора ввечері я Не можу заснути, просто жесть. Вчора ввечері я");

                // Викликаємо функцію sendMessage
                int result = activity.sendMessage(mockTextField, "testUser", new Date().getTime());

                // Перевіряємо, чи відповідає результат очікуваному результату
                assertEquals(-1, result);
            });
        }
    }

    @Test
    public void testSendMessageEmptyText() {
        // Запускаємо активність
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                // Створюємо макет текстового поля та встановлюємо порожній текст
                EditText mockTextField = activity.findViewById(R.id.textField);
                mockTextField.setText("");

                // Викликаємо функцію sendMessage
                int result = activity.sendMessage(mockTextField, "testUser", new Date().getTime());
                // Перевіряємо, чи відповідає результат очікуваному результату при порожньому тексті
                assertEquals(-1, result);
            });
        }
    }

    @Test
    public void testSendMessageInvalidTime() {
        // Запускаємо активність
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                // Створюємо макет текстового поля та встановлюємо текст
                EditText mockTextField = activity.findViewById(R.id.textField);
                mockTextField.setText("Не можу заснути, просто жесть.");

                // Викликаємо функцію sendMessage з невірною датою
                int result = activity.sendMessage(mockTextField, "testUser", new Date().getTime() - 1);
                // Перевіряємо, чи відповідає результат очікуваному результату при невірній даті
                assertEquals(-2, result);
            });
        }
    }
}
