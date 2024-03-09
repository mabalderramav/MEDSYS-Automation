package com.bo.medsys.automation.medsys.core.api.doctors.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Doctor {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("specialty_id")
    @Expose
    private int specialtyId;

    @SerializedName("fullname")
    @Expose
    private String fullName;

    @SerializedName("birthday")
    @Expose
    private String birthday;

    @SerializedName("sexo")
    @Expose
    private String sex;
}
