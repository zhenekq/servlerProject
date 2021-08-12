package by.epamtc.zhenekns.dev.entity;

import java.util.Objects;

public class Project {

    private int id;
    private String title;
    private String description;
    private String qualification;
    private int teamSize;
    private String status;
    private int cost;
    private String deadline;
    private int user_id;

    public Project(){}

    public Project(int id, String title, String description, String qualification, int teamSize, int cost, String deadline, int user_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.qualification = qualification;
        this.teamSize = teamSize;
        this.cost = cost;
        this.deadline = deadline;
        this.user_id = user_id;
    }

    public Project(String title, String description, String qualification, int teamSize, int cost, String deadline, int user_id) {
        this.title = title;
        this.description = description;
        this.qualification = qualification;
        this.teamSize = teamSize;
        this.cost = cost;
        this.deadline = deadline;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
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
        Project project = (Project) o;
        return id == project.id &&
                teamSize == project.teamSize &&
                cost == project.cost &&
                user_id == project.user_id &&
                title.equals(project.title) &&
                description.equals(project.description) &&
                qualification.equals(project.qualification) &&
                status.equals(project.status) &&
                deadline.equals(project.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, qualification, teamSize, status, cost, deadline, user_id);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", qualification='" + qualification + '\'' +
                ", teamSize=" + teamSize +
                ", status='" + status + '\'' +
                ", cost=" + cost +
                ", deadline='" + deadline + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
