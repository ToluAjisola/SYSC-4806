package book;

import javax.persistence.*;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String phone ;
    private String name ;
    private String address ;
    //private book.AddressBook book;


    public BuddyInfo() {
    }

    public BuddyInfo(String name, String address,String phone) {
        super();
        this.name = name;
        this.phone = phone;
        this.address = address;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone1) {
        this.phone = phone1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name1) {

        name = name1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address1) {
        this.address = address1;
    }
/*
    @ManyToOne
    public book.AddressBook getBook() {
        return book;
    } */

    public String toString() {
        return "[id:" + id + ", name:" + name +  ", address:" + address +  ", phone:" + phone + "]";
    }
}
