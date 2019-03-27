package az.kapital.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "phones")
public class Phones {

    @XmlElement(name = "phone")
    private List <Phone> phones;

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
