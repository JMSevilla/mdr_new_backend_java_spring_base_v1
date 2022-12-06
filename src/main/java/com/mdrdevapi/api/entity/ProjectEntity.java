package com.mdrdevapi.api.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="restful_api_project")
@Data
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="projectname")
    private String projectname;

    @Column(name="projectdetails")
    private String projectdetails;

    @Column(name="projectcategory")
    private String projectcategory;

    @Column(name="projecttype")
    private String projecttype;
    @JsonIgnore
    @Column(name="projectfeatures")
    private String projectfeatures;

    @Column(name="projectprice")
    private int projectprice;

    @Column(name="clientEmail")
    private String clientEmail;

    @Column(name="projectstatus")
    private String projectstatus;

    @Column(name="created_at")
    private Timestamp created_at;

    @Column(name="updated_at")
    private Timestamp updated_at;

    public ProjectEntity() {}

    public ProjectEntity(
            String projectname, String projectdetails,
            String projectcategory, String projecttype,
            String projectfeatures, int projectprice,
            String clientEmail, String projectstatus,
            Timestamp created_at, Timestamp updated_at
    ){
        this.projectname = projectname;
        this.projectdetails = projectdetails;
        this.projectcategory = projectcategory;
        this.projecttype = projecttype;
        this.projectfeatures = projectfeatures;
        this.projectprice = projectprice;
        this.clientEmail = clientEmail;
        this.projectstatus = projectstatus;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
