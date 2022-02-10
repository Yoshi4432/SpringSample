package com.example.demo.controllers;

import org.springframework.stereotype.Controller;

import com.example.demo.controllers.dtos.BaseControllerDto;
import com.example.demo.forms.BaseForm;

@Controller
public abstract class BaseController {

	/**
	 * タイムリーフディレクトリ名
	 */
	protected final String dirThymeleaf = "thymeleaf";

	/**
	 * タイムリーフ用のパラメータセットを行う.
	 * 
	 * @param model モデル
	 * @param dto   コントローラ用DTO
	 * @return ページ名
	 */
	protected abstract String addAttributesForThymeleaf(BaseForm form, BaseControllerDto dto);

}
