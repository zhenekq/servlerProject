package by.epamtc.zhenekns.dev.entity;

public class ProjectResponse {

    private int id;
    private int ownerId;
    private int responsibleId;
    private int projectId;
    private String projectDetails;
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
}
