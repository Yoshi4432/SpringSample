package com.example.demo.controllers.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.controllers.BaseController;
import com.example.demo.controllers.dtos.BaseControllerDto;
import com.example.demo.forms.BaseForm;
import com.example.demo.forms.impl.EditForm;

@Controller
public class EditController extends BaseController {

	@GetMapping({ "/edit" })
	public String edit(EditForm form) {
		return addAttributesForThymeleaf(form, null);
	}

	protected String addAttributesForThymeleaf(BaseForm form, BaseControllerDto dto) {
		return dirThymeleaf + "/edit";
	}

}
