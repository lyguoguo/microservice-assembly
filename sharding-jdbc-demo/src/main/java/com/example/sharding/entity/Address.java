package com.example.sharding.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
	private Long id;
	private String code;
	private String name;
	private String pid;
	private Integer type;
	private Integer lit;
}
