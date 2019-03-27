package az.kapital.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="phone")
public class Phone {

    private int id;
    private String version;
    private int count;
    private int active;
    private int samsungid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getSamsungid() {
        return samsungid;
    }

    public void setSamsungid(int samsungid) {
        this.samsungid = samsungid;
    }
}
