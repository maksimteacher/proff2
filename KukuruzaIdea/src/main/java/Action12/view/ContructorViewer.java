package Action12.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import resourses.Contructor;

public class ContructorViewer {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;

    public ContructorViewer(int id, String name) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
    }

    public ContructorViewer(Contructor contructor) {
        this(contructor.getId(), contructor.getName());
    }

    public Contructor toContructor() {
        Contructor contructor = new Contructor(getName());
        contructor.setId(getId());
        return contructor;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

}
