package com.mayi.user.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserDto implements Serializable {
    private Integer userId;

    private String name;

    private String nickName;

    private String cardId;

    private String cardFrontUrl;

    private String cardBackUrl;

    private String mobile;

    private Date createTime;

    private Date modifyTime;

    private String honorName;

    private Integer honorLevel;

    private Integer deleteFlag;

    private static final long serialVersionUID = 1L;

}