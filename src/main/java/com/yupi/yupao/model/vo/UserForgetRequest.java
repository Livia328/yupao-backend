package com.yupi.yupao.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserForgetRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;

    private String userEmail;

    private String code;

    private String userPassword;


}