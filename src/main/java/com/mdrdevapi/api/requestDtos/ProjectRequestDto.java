package com.mdrdevapi.api.requestDtos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectRequestDto implements Serializable {
    @NotNull
    private String projectname;

    @NotNull
    private String projectdetails;

    @NotNull
    private String projectfeatures;

    @NotNull
    private String projectcategory;

    @NotNull
    private int projectprice;

    @NotNull
    private String projecttype;

    @NotNull
    private String email;

}
