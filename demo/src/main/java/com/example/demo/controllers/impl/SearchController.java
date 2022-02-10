package com.example.demo.controllers.impl;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.controllers.BaseController;
import com.example.demo.controllers.dtos.BaseControllerDto;
import com.example.demo.entities.MstPokemon;
import com.example.demo.forms.BaseForm;
import com.example.demo.forms.impl.SearchForm;
import com.example.demo.services.SearchService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SearchController extends BaseController {

	/**
	 * 検索モデル
	 */
	protected final SearchService searchService;

	@GetMapping({ "/search" })
	public String search(@ModelAttribute SearchForm form) {
		// パラメータ設定
		String page = addAttributesForThymeleaf(form, null);
		return page;
	}

	protected String addAttributesForThymeleaf(BaseForm form, BaseControllerDto dto) {
		/* 検索 */
		SearchForm sf = (SearchForm) form;
		List<MstPokemon> list = searchService.search(sf);
		sf.setMstPokemonList(list);

		return dirThymeleaf + "/search";
	}

}
