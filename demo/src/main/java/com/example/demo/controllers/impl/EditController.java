package com.example.demo.controllers.impl;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.controllers.BaseController;
import com.example.demo.entities.MstPokemon;
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
	public String index(EditForm form) {
		return addAttributesForThymeleaf(form);
	}

	@PostMapping({ "/edit/edit" })
	public String edit(@Validated EditForm form, BindingResult br) {
		if (br.hasErrors()) {
			return dirThymeleaf + "/edit";
		}

		String errMsg = editService.edit(form);
		if (StringUtils.isEmpty(errMsg)) {
			// 成功
			return "redirect:/search";
		} else {
			// 失敗
			form.setErrMsg(errMsg);
			return dirThymeleaf + "/edit";
		}
	}

	@PostMapping({ "/edit/delete" })
	public String delete(EditForm form) {
		String errMsg = editService.delete(form);
		if (StringUtils.isEmpty(errMsg)) {
			// 成功
			return "redirect:/search";
		} else {
			// 失敗
			form.setErrMsg(errMsg);
			return dirThymeleaf + "/edit";
		}
	}

	protected String addAttributesForThymeleaf(BaseForm form) {
		/* 編集モードなら初期表示 */
		EditForm ef = (EditForm) form;
		if (StringUtils.isNotEmpty(ef.getId())) {
			// 編集モード
			MstPokemon pokemon = editService.findInitData(ef);
			ModelMapper mapper = new ModelMapper();
			mapper.map(pokemon, ef);
		}

		return dirThymeleaf + "/edit";
	}

}
