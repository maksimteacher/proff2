package domain;

import org.hibernate.annotations.GenericGenerator;
import service.StatusServiceAbstract;

import javax.persistence.*;

@Entity
public class Question {
    private Integer id;
    private String title;
    private String question;
    private Status status;
    private Theme theme;
    private User askedByUser;

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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "question")
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question1 = (Question) o;

        if (id != null ? !id.equals(question1.id) : question1.id != null) return false;
        if (question != null ? !question.equals(question1.question) : question1.question != null) return false;
        if (title != null ? !title.equals(question1.title) : question1.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (question != null ? question.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setStatus(String statusValue) {
        StatusServiceAbstract statusService = new StatusServiceAbstract(Status.class);
        Status status = statusService.findStatus(statusValue);
        if(status != null) {
            setStatus(status);
        } else {
            Status newStatus = new Status();
            newStatus.setStatus(statusValue);
            statusService.add(newStatus);
            setStatus(newStatus);
        }
    }

    @ManyToOne
    @JoinColumn(name = "theme_id", referencedColumnName = "id")
    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getAskedByUser() {
        return askedByUser;
    }

    public void setAskedByUser(User askedByUser) {
        this.askedByUser = askedByUser;
    }
}
