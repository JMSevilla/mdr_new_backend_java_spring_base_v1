package com.mdrdevapi.api.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "restful_api_businessowner1")
@Data
public class BusinessOwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name="contactnumber")
    private String contactnumber;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name="usertype")
    private String usertype;

    @Column(name = "islock")
    private String islock;

    @Column(name = "isverified")
    private String isverified;

    @Column(name="imgurl")
    private String imgurl;

    @Column(name="sec_question")
    private String sec_question;

    @Column(name = "sec_answer")
    private String sec_answer;

    @Column(name="created_at")
    private Timestamp created_at;

    @Column(name="updated_at")
    private Timestamp updated_at;

    public BusinessOwnerEntity(){}

    public BusinessOwnerEntity(String firstname, String lastname, String contactnumber,
                               String address, String email, String password, String usertype,
                               String islock, String isverified, String imgurl,
                               String sec_question, String sec_answer,
                               Timestamp created_at, Timestamp updated_at){
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.contactnumber = contactnumber;
        this.address = address;
        this.email = email;
        this.password = password;
        this.usertype = usertype;
        this.islock = islock;
        this.isverified = isverified;
        this.imgurl = imgurl;
        this.sec_question = sec_question;
        this.sec_answer = sec_answer;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
