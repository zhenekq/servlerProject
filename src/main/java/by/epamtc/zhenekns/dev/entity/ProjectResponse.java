package by.epamtc.zhenekns.dev.entity;

import java.util.Objects;

public class ProjectResponse {

    private int id;
    private int ownerId;
    private int responsibleId;
    private int projectId;
    private String projectDetails;
    private String status;
    private int possiblePrice;
    private String deadline;

    public ProjectResponse(){}

    public ProjectResponse(int id, int ownerId, int responsibleId, int projectId, String projectDetails, int possiblePrice, String deadline) {
        this.id = id;
        this.ownerId = ownerId;
        this.responsibleId = responsibleId;
        this.projectId = projectId;
        this.projectDetails = projectDetails;
        this.possiblePrice = possiblePrice;
        this.deadline = deadline;
    }

    public ProjectResponse(int ownerId, int responsibleId, int projectId, String projectDetails, int possiblePrice, String deadline) {
        this.ownerId = ownerId;
        this.responsibleId = responsibleId;
        this.projectId = projectId;
        this.projectDetails = projectDetails;
        this.possiblePrice = possiblePrice;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(int responsibleId) {
        this.responsibleId = responsibleId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(String projectDetails) {
        this.projectDetails = projectDetails;
    }

    public int getPossiblePrice() {
        return possiblePrice;
    }

    public void setPossiblePrice(int possiblePrice) {
        this.possiblePrice = possiblePrice;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
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
        ProjectResponse that = (ProjectResponse) o;
        return id == that.id &&
                ownerId == that.ownerId &&
                responsibleId == that.responsibleId &&
                projectId == that.projectId &&
                possiblePrice == that.possiblePrice &&
                projectDetails.equals(that.projectDetails) &&
                status.equals(that.status) &&
                deadline.equals(that.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerId, responsibleId, projectId, projectDetails, status, possiblePrice, deadline);
    }

    @Override
    public String toString() {
        return "ProjectResponse{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", responsibleId=" + responsibleId +
                ", projectId=" + projectId +
                ", projectDetails='" + projectDetails + '\'' +
                ", status='" + status + '\'' +
                ", possiblePrice=" + possiblePrice +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}
