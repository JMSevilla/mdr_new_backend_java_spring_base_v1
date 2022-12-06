package com.mdrdevapi.api.entity;
import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name="restful_api_contactus")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="fullname")
    private String fullname;

    @Column(name="email")
    private String email;

    @Column(name = "subject")
    private String subject;

    @Column(name="message")
    private String message;

    public ContactEntity() {}

    public ContactEntity(
            String fullname, String email,
            String subject, String message
    ) {
        this.fullname = fullname;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }
}
