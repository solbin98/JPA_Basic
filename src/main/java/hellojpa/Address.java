package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    public Address(String city1, String street, String ddd) {
        this.city = city1;
        this.street = street;
        this.zipcode = ddd;
    }

    public Address(){

    }
}
