package domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "findUserByLogin",
                query = "select * from user where login = :login",
                resultClass = User.class
        ),

        @NamedNativeQuery(
                name = "findAllUsers",
                query = "select * from user",
                resultClass = User.class
        ),

        @NamedNativeQuery(
                name = "findAllThemes",
                query = "select * from theme",
                resultClass = Theme.class
        ),

        @NamedNativeQuery(
                name = "findAllStatuses",
                query = "select * from status",
                resultClass = Status.class
        ),

        @NamedNativeQuery(
                name = "findAllRoles",
                query = "select * from role",
                resultClass = Role.class
        ),

        @NamedNativeQuery(
                name = "findAllQuestions",
                query = "select * from question",
                resultClass = Question.class
        ),

        @NamedNativeQuery(
                name = "findAllAnswers",
                query = "select * from answer",
                resultClass = Answer.class
        )
})
@Entity
public class User {
    private Integer id;
    private String login;
    private String password;
    private Role role;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
