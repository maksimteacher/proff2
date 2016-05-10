package domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Notebook on 27.04.2016.
 */
@Entity
public class Theme {
    private Integer id;
    private String theme;

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
    @Column(name = "theme")
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Theme theme1 = (Theme) o;

        if (id != null ? !id.equals(theme1.id) : theme1.id != null) return false;
        if (theme != null ? !theme.equals(theme1.theme) : theme1.theme != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (theme != null ? theme.hashCode() : 0);
        return result;
    }
}
