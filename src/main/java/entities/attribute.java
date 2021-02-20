package entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Attribute")
public class attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String desc;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<attributeTerm> tList;

    public attribute() {
    }

    public attribute(String name, String desc, List<attributeTerm> tList) {
        this.name = name;
        this.desc = desc;
        this.tList = tList;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<attributeTerm> gettList() {
        return tList;
    }

    public void settList(List<attributeTerm> tList) {
        this.tList = tList;
    }

    @Override
    public String toString() {
        return "attribute{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", tList=" + tList +
                '}';
    }
}
