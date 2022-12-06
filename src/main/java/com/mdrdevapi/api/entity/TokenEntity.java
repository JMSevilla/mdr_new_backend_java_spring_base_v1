package com.mdrdevapi.api.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name="restful_api_tokenization")
@Data
public class TokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="userid")
    private Long userid;

    @Column(name="token")
    private String token;

    @Column(name="lastroute")
    private String lastroute;

    @Column(name="isdestroyed")
    private String isdestroyed;

    @Column(name="isvalid")
    private String isvalid;

    @Column(name="created_at")
    private Timestamp created_at;

    @Column(name="updated_at")
    private Timestamp updated_at;

    public TokenEntity(){}

    public TokenEntity(Long userid, String token, String lastroute, String isdestroyed, String isvalid,
    Timestamp created_at, Timestamp updated_at){
        super();
        this.userid = userid;
        this.token = token;
        this.lastroute = lastroute;
        this.isdestroyed = isdestroyed;
        this.isvalid = isvalid;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
