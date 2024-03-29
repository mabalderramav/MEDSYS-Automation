package com.bo.medsys.automation.medsys.core.api.doctorsBySpeciality.entities;

import com.bo.medsys.automation.medsys.core.api.doctors.entities.DoctorEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoctorsBySpecialityResponseEntity {

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("data")
    @Expose
    private List<DoctorEntity> doctors;

    private int statusCode;
}
