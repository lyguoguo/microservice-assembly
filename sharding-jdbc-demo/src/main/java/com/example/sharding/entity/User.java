package com.example.sharding.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {
	private Long id;
	private String name;
	private String phone;
	private String email;
	private String password;
	private Integer cityId;
    private Date createTime;
    private Integer sex;
}
