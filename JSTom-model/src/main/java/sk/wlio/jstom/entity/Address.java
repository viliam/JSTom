package sk.wlio.jstom.entity;

import javax.persistence.*;

@Entity
public class Address {

    @TableGenerator(
        name="addressGen",
        table="ID_GENENERATOR",
        pkColumnName="GEN_KEY",
        valueColumnName="GEN_VALUE",
        pkColumnValue="ADDRESS_ID",
        allocationSize=1)
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="addressGen")

    private Long id;

    private String street;

    //todo: bean validation pattern
    private String streetNumber;

    private String city;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
