package ru.netology.todos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simple = new SimpleTask(5, "Позвонить родителям");
        Epic epic = new Epic(55, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simple);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simple, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchShouldReturnOnlyMatchingTasks() {
        SimpleTask simple = new SimpleTask(5, "Позвонить родителям");
        Epic epic = new Epic(55, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simple);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("НетоБанк");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchShouldReturnMultipleMatches() {
        SimpleTask simple = new SimpleTask(1, "Купить Хлеб");
        Epic epic = new Epic(2, new String[]{"Молоко", "Хлеб"});
        Meeting meeting = new Meeting(3, "Статус по Хлебу", "Продуктовый проект", "завтра");

        Todos todos = new Todos();
        todos.add(simple);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simple, epic, meeting};
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchShouldReturnEmptyIfNoMatches() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Позвонить маме"));
        todos.add(new Epic(2, new String[]{"Молоко"}));
        todos.add(new Meeting(3, "Стендап", "Проект А", "сегодня"));

        Task[] actual = todos.search("помидоры");

        Assertions.assertEquals(0, actual.length);
    }
}