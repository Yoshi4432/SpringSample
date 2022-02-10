package com.example.demo.controllers.impl;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.controllers.BaseController;
import com.example.demo.controllers.dtos.BaseControllerDto;
import com.example.demo.forms.BaseForm;
import com.example.demo.forms.impl.EditForm;
import com.example.demo.services.EditService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class EditController extends BaseController {

	/**
	 * 編集モデル
	 */
	protected final EditService editService;

	@GetMapping({ "/edit" })
	public String edit(EditForm form) {
		return addAttributesForThymeleaf(form, null);
	}

	@PostMapping({ "/edit/register" })
	public String editRegister(EditForm form, BindingResult br) {
//		// TODO
//		if (result.hasErrors()) {
//			List<String> errorList = new ArrayList<String>();
//			for (ObjectError e : result.getAllErrors()) {
//				errorList.add(e.getDefaultMessage());
//			}
//		}

		boolean result = editService.edit(form);
		if (result) {
			// 成功
			return "redirect:/search";
		} else {
			// 失敗
			return dirThymeleaf + "/edit";
		}
	}

	protected String addAttributesForThymeleaf(BaseForm form, BaseControllerDto dto) {
		return dirThymeleaf + "/edit";
	}

}
