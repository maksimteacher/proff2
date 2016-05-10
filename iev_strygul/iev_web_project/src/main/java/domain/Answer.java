package domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Notebook on 27.04.2016.
 */
@Entity
public class Answer {
    private Integer id;
    private String answerContent;
    private User answeredBy;
    private Question question;

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
    @Column(name = "answer_content")
    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (answerContent != null ? !answerContent.equals(answer.answerContent) : answer.answerContent != null)
            return false;
        if (id != null ? !id.equals(answer.id) : answer.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (answerContent != null ? answerContent.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "answered_by_id", referencedColumnName = "id")
    public User getAnsweredBy() {
        return answeredBy;
    }

    public void setAnsweredBy(User answeredBy) {
        this.answeredBy = answeredBy;
    }

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
