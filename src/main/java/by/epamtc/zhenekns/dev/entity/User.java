package by.epamtc.zhenekns.dev.entity;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String email;
    private String password;
    private String nickname;
    private Role role = Role.USER;

    private static User instance = new User();

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    public User() {
    }

    public User(String username, String email) {
        this.email = email;
        this.nickname = username;
    }

    public User(String email, String nickname, String password) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public User(int id, String email, String password, String nickname, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
    }

    public User(String email, String password, String nickname, Role role) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRole() {
        return role.toString();
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        User user = (User) obj;
        return id == user.id &&
                (email == user.email || (email != null && email.equals(user.getEmail()))) &&
                (password == user.password || (password != null && password.equals(user.getPassword()))) &&
                (nickname == user.nickname || (nickname != null && nickname.equals(user.getNickname()))) &&
                (role == user.role || (role != null && role.toString().equals(user.getRole())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", role=" + role +
                '}';
    }
}
