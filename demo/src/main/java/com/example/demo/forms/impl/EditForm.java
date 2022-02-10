package com.example.demo.forms.impl;

import java.sql.Date;

import com.example.demo.forms.BaseForm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EditForm extends BaseForm {

	private Integer id;

	
	private Integer nationalPokedex;

	private String name;

	private String type1;

	private String type2;

	private Integer createdUserId;

	private Integer updatedUserId;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

}
