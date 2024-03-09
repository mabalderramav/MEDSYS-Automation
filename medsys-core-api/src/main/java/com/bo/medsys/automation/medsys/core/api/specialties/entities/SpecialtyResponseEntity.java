package com.bo.medsys.automation.medsys.core.api.specialties.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SpecialtyResponseEntity {

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("data")
    @Expose
    private List<SpecialtyEntity> specialties;

    private int statusCode;
}
