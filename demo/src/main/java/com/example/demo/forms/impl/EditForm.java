package com.example.demo.forms.impl;

import java.sql.Date;

import com.example.demo.forms.BaseForm;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EditForm extends BaseForm {

	private Integer id;

	@Pattern(regexp = "^[0-9０-９]+$", message = "数値を入力してください")
	private Integer nationalPokedex;

	@NotBlank(message = "必須です")
	private String name;

	@NotBlank(message = "必須です")
	private String type1;

	private String type2;

	private Integer createdUserId;

	private Integer updatedUserId;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

}
