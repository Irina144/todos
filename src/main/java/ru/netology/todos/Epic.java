package ru.netology.todos;

public class Epic extends Task {
    protected String[] subtasks;
    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks == null ? new String[0] : subtasks.clone();
    }
    public String[] getSubtasks() {
        return subtasks.clone();
    }
    @Override
    public boolean matches(String query) {
        if (query == null) return false;
        for (String s : subtasks) {
            if (s != null && s.contains(query)) return true;
        }
        return false;
    }
}