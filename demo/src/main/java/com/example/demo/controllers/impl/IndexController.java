package com.example.demo.controllers.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.controllers.BaseController;
import com.example.demo.utils.Training;

import lombok.RequiredArgsConstructor;

/**
 * 初期表示コントローラ
 * 
 * @author perfect.yoshi@gmail.com
 *
 */
@RequiredArgsConstructor
@Controller
public class IndexController extends BaseController {

	/**
	 * 処理モード
	 */
	@Value("${training.mode}")
	protected String mode;

	/**
	 * ページ名
	 */
	protected String page = "index";

	@GetMapping({ "/", "/index" })
	public String index() {
		/* トレーニングモードによって処理を分岐 */
		if (Training.Mode.THYMELEAF.name().toString().equals(mode)) {
			// タイムリーフ
			return dirThymeleaf + "/" + page;
		} else if (Training.Mode.REACT.name().toString().equals(mode)) {
			// React
			return dirReact + "/" + page;
		} else if (Training.Mode.VUE.name().toString().equals(mode)) {
			// Vue
			return dirVue + "/" + page;
		} else if (Training.Mode.ANGULAR.name().toString().equals(mode)) {
			// Angular
			return dirReact + "/" + page;
		} else {
			return "redirect:/mock/" + page + ".html";
		}
	}
}
