package by.epamtc.zhenekns.dev.entity;

public class Project {
    private int id;
    private String title;
    private String description;
    private int teamSize;
    private int cost;
    private String deadline;
    private int user_id;

    public Project(){}

    public Project(int id, String title, String description, int teamSize, int cost, String deadline, int user_id) {
        this.id = id;
        this.title = title;
        this.description = description;
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
}
