package by.epamtc.zhenekns.dev.entity;

import java.util.Objects;

public class Team {

    private int id;
    private String name;
    private String description;
    private int currentTeamSize;
    private int teamSize;
    private int managerId;
    private String status;

    public Team(){}

    public Team(int id, String name, String description, int currentTeamSize, int teamSize, int managerId, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.currentTeamSize = currentTeamSize;
        this.teamSize = teamSize;
        this.managerId = managerId;
        this.status = status;
    }

    public int getCurrentTeamSize() {
        return currentTeamSize;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCurrentTeamSize(int currentTeamSize) {
        this.currentTeamSize = currentTeamSize;
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

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id &&
                currentTeamSize == team.currentTeamSize &&
                teamSize == team.teamSize &&
                managerId == team.managerId &&
                name.equals(team.name) &&
                description.equals(team.description) &&
                status.equals(team.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, currentTeamSize, teamSize, managerId, status);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", currentTeamSize=" + currentTeamSize +
                ", teamSize=" + teamSize +
                ", managerId=" + managerId +
                ", status='" + status + '\'' +
                '}';
    }
}
