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

}
