package com.bo.medsys.automation.medsys.core.api.authentications.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponseEntity {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("accessToken")
    @Expose
    private String token;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("fullName")
    @Expose
    private String fullName;

    private int statusCode;

    @SerializedName("error")
    @Expose
    private String errorMessage;
}
