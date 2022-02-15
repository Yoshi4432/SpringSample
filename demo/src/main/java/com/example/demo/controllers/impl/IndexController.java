package com.example.demo.controllers.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.controllers.BaseController;
import com.example.demo.utils.Training;

/**
 * 初期表示コントローラ
 * 
 * @author perfect.yoshi@gmail.com
 *
 */
@Controller
public class IndexController extends BaseController {

	@Value("${training.mode}")
	private String mode;

	@GetMapping({ "/", "/index" })
	public String index() {
		// パラメータ設定
		if (Training.Mode.THYMELEAF.name().toString().equals(mode)) {
			// タイムリーフ
			return dirThymeleaf + "/index";
		} else if (Training.Mode.REACT.name().toString().equals(mode)) {
			// React
			return dirReact + "/index";
		} else {
			return "redirect:/mock/index.html";
		}
	}
}
