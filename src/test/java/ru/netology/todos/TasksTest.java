package ru.netology.todos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void simpleTaskMatchesTitle() {
        SimpleTask t = new SimpleTask(1, "Покупка");
        Assertions.assertTrue(t.matches("Покуп"));
        Assertions.assertFalse(t.matches("Нет"));
    }

    @Test
    public void epicMatchesSubtask() {
        Epic e = new Epic(2, new String[]{"Раз", "Два"});
        Assertions.assertTrue(e.matches("Два"));
        Assertions.assertFalse(e.matches("Три"));
    }

    @Test
    public void meetingMatchesTopicOrProject() {
        Meeting m = new Meeting(3, "Дизайн", "Проект X", "вечер");
        Assertions.assertTrue(m.matches("Дизайн"));
        Assertions.assertTrue(m.matches("Проект"));
        Assertions.assertFalse(m.matches("Тест"));
    }
}