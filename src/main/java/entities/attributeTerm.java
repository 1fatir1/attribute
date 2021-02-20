package entities;

import javax.persistence.*;


@Entity
@Table(name = "AttributeTerm")
public class attributeTerm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;
    private String tname;
    private String tdesc;

    public attributeTerm() {
    }

    public attributeTerm(String tname, String tdesc) {
        this.tname = tname;
        this.tdesc = tdesc;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTdesc() {
        return tdesc;
    }

    public void setTdesc(String tdesc) {
        this.tdesc = tdesc;
    }

    @Override
    public String toString() {
        return "attributeTerm{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tdesc='" + tdesc + '\'' +
                '}';
    }
}
