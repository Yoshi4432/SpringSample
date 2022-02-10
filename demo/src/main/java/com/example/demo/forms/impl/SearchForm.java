package com.example.demo.forms.impl;

import java.util.List;

import com.example.demo.entities.MstPokemon;
import com.example.demo.forms.BaseForm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchForm extends BaseForm {

	/**
	 * 検索名
	 */
	private String name = "";

	/**
	 * 検索タイプ１
	 */
	private String type1 = "";

	/**
	 * 検索タイプ２
	 */
	private String type2 = "";

	/**
	 * 検索結果表示用リスト
	 */
	private List<MstPokemon> mstPokemonList = null;

}
