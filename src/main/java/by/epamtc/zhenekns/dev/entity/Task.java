package by.epamtc.zhenekns.dev.entity;

import java.util.Objects;

public class Task {

    private int id;
    private String name;
    private String description;
    private int teamId;
    private String status;

    public Task(){}

    public Task(int id, String name, String description, int teamId, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.teamId = teamId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                teamId == task.teamId &&
                name.equals(task.name) &&
                description.equals(task.description) &&
                status.equals(task.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, teamId, status);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", teamId=" + teamId +
                ", status='" + status + '\'' +
                '}';
    }
}
