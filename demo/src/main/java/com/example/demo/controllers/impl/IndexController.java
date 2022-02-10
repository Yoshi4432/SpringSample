package com.example.demo.controllers.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.controllers.BaseController;
import com.example.demo.controllers.dtos.BaseControllerDto;
import com.example.demo.forms.BaseForm;

@Controller
public class IndexController extends BaseController {

	@GetMapping({ "/", "/index" })
	public String index() {
		// パラメータ設定
		String page = addAttributesForThymeleaf(null, null);
		return page;
	}

	@Override
	protected String addAttributesForThymeleaf(BaseForm form, BaseControllerDto dto) {
		return dirThymeleaf + "/index";
	}

}
