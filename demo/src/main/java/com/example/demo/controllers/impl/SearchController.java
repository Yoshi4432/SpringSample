package com.example.demo.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.controllers.BaseController;
import com.example.demo.entities.MstPokemon;
import com.example.demo.forms.BaseForm;
import com.example.demo.forms.impl.SearchForm;
import com.example.demo.services.SearchService;
import com.example.demo.utils.Training;

import lombok.RequiredArgsConstructor;

/**
 * 検索コントローラ
 * 
 * @author perfect.yoshi@gmail.com
 *
 */
@RequiredArgsConstructor
@Controller
public class SearchController extends BaseController {

	/**
	 * 検索モデル
	 */
	protected final SearchService searchService;

	/**
	 * 処理モード
	 */
	@Value("${training.mode}")
	protected String mode;

	/**
	 * ページ名
	 */
	protected String page = "search";

	/**
	 * 検索初期表示
	 * 
	 * @param form 検索画面フォーム
	 * @return 表示ページ
	 */
	@GetMapping({ "/search" })
	public String index(@ModelAttribute SearchForm form) {
		/* トレーニングモードによって処理を分岐 */
		if (Training.Mode.THYMELEAF.name().toString().equals(mode)) {
			// タイムリーフ
			return indexByThymeleaf(form);
		} else {
			return "redirect:/mock/" + page + ".html";
		}
	}

	protected String indexByThymeleaf(BaseForm form) {
		/* 検索 */
		SearchForm sf = (SearchForm) form;
		List<MstPokemon> list = searchService.search(sf);
		sf.setMstPokemonList(list);

		return dirThymeleaf + "/" + page;
	}

}
