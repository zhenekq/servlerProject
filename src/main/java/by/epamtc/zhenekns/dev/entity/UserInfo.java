package by.epamtc.zhenekns.dev.entity;

import java.io.Serializable;

public class UserInfo implements Serializable {

    private int id;
    private String status;
    private String qualification;
    private String country;
    private String city;
    private String experience;
    private String dateOfRegistration;
    private String socialLink;

    private int userId = User.getInstance().getId();

    private static UserInfo instance = new UserInfo();

    public static UserInfo getInstance() {
        if(instance == null){
            instance = new UserInfo();
        }
        return instance;
    }

    public UserInfo() {
    }

    public UserInfo(int id, String status, String qualification, String country, String city, String experience, String dateOfRegistration, String socialLink, int userId) {
        this.id = id;
        this.status = status;
        this.qualification = qualification;
        this.country = country;
        this.city = city;
        this.experience = experience;
        this.dateOfRegistration = dateOfRegistration;
        this.socialLink = socialLink;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getSocialLink() {
        return socialLink;
    }

    public void setSocialLink(String socialLink) {
        this.socialLink = socialLink;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        UserInfo user = (UserInfo) obj;
        return id == user.id &&
                (status == user.status || (status != null && status.equals(user.getStatus()))) &&
                (qualification == user.qualification || (qualification != null && qualification.equals(user.getQualification()))) &&
                (country == user.country || (country != null && country.equals(user.getCountry()))) &&
                (city == user.city || (city != null && city.equals(user.getCity()))) &&
                (experience == user.experience || (experience != null && experience.equals(user.getExperience()))) &&
                (dateOfRegistration == user.dateOfRegistration || (dateOfRegistration != null && dateOfRegistration.equals(user.getDateOfRegistration()))) &&
                (socialLink == user.socialLink || (socialLink != null && socialLink.equals(user.getSocialLink()))) &&
                (userId == user.userId);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((qualification == null) ? 0 : qualification.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((experience == null) ? 0 : experience.hashCode());
        result = prime * result + ((dateOfRegistration == null) ? 0 : dateOfRegistration.hashCode());
        result = prime * result + ((socialLink == null) ? 0 : socialLink.hashCode());
        result = prime * result + userId;
        return result;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", qualification='" + qualification + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", experience='" + experience + '\'' +
                ", dateOfRegistration='" + dateOfRegistration + '\'' +
                ", socialLink='" + socialLink + '\'' +
                ", userId=" + userId +
                '}';
    }
}
