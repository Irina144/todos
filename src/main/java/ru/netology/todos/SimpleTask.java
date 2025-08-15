package ru.netology.todos;

public class SimpleTask extends Task {
    protected String title;
    public SimpleTask(int id, String title) { super(id); this.title = title; }
    public String getTitle() { return title; }
    @Override
    public boolean matches(String query) {
        return title != null && query != null && title.contains(query);
    }
}