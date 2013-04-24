package sk.wlio.jstom.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @TableGenerator(
        name="personGen",
        table="ID_GENENERATOR",
        pkColumnName="GEN_KEY",
        valueColumnName="GEN_VALUE",
        pkColumnValue="PERSON_ID",
        allocationSize=1)
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="personGen")
    private Long id;

    private String name;

    private Integer age;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
