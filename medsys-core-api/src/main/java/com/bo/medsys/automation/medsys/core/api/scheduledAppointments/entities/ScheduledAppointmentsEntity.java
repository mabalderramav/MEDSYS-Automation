package com.bo.medsys.automation.medsys.core.api.scheduledAppointments.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduledAppointmentsEntity {
    @SerializedName("appointment_id")
    @Expose
    private int appointmentId;

    @SerializedName("hour")
    @Expose
    private String hour;

    @SerializedName("doctor_id")
    @Expose
    private int doctorId;

    @SerializedName("fullname")
    @Expose
    private String fullName;

    @SerializedName("name")
    @Expose
    private String specialty;

    @SerializedName("patient_id")
    @Expose
    private int patientId;

    @SerializedName("date_register_patient")
    @Expose
    private String dateRegisterPatient;
}
