package com.example.demo.controllers;

import org.springframework.stereotype.Controller;

/**
 * 基底コントローラクラス
 * 
 * @author perfect.yoshi@gmail.com
 *
 */
@Controller
public abstract class BaseController {

	/**
	 * タイムリーフディレクトリ名
	 */
	protected final String dirThymeleaf = "thymeleaf";

	/**
	 * Reactディレクトリ名
	 */
	protected final String dirReact = "react";

	/**
	 * Vueディレクトリ名
	 */
	protected final String dirVue = "vue";

	/**
	 * Angularディレクトリ名
	 */
	protected final String dirAngular = "angular";

}
