package com.example.demo.services;

import java.sql.Timestamp;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.example.demo.entities.MstPokemon;
import com.example.demo.forms.impl.EditForm;
import com.example.demo.repositories.MstPokemonRepository;

import jakarta.persistence.EntityManager;

@Service
public class EditService {

	protected MstPokemonRepository mpRepository;
	protected EntityManager em;
	protected ApplicationContext context;

	public EditService(MstPokemonRepository r, EntityManager m, ApplicationContext c) {
		this.mpRepository = r;
		this.em = m;
		this.context = c;
	}

	public MstPokemon findInitData(EditForm form) {
		/* 検索 */
		int id = Integer.parseInt(form.getId());
		Optional<MstPokemon> pokemon = mpRepository.findById(id);

		return pokemon.get();
	}

	public String edit(EditForm form) {
		String message = null;
		// 登録
		try {
			// ポケモンEntity作成
			MstPokemon pokemon = null;
			String id = form.getId();
			if (StringUtils.isEmpty(id)) {
				// 新規作成
				pokemon = new MstPokemon();
			} else {
				int intId = Integer.parseInt(id);
				Optional<MstPokemon> result = mpRepository.findById(intId);
				pokemon = result.get();
			}

			// 画面入力を詰め替え
			ModelMapper mapper = new ModelMapper();
			mapper.map(form, pokemon);

			// 作成日・更新日を設定
			Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
			if (StringUtils.isEmpty(id)) {
				// 新規の場合は作成日も.
				pokemon.setCreatedAt(updatedAt);
			}
			pokemon.setUpdatedAt(updatedAt);

			mpRepository.save(pokemon);
		} catch (Exception e) {
			message = "データ登録に失敗しました。<br>時間をおいて再度試してください";
		}

		return message;
	}

	/**
	 * ポケモンの論理削除を行う.
	 * 
	 * @param form 編集フォーム
	 * @return （エラーがあれば）エラーメッセージ
	 */
	public String delete(EditForm form) {
		// チェック
		String message = null;
		if (!NumberUtils.isDigits(form.getId())) {
			message = "データ削除に失敗しました。<br>時間をおいて再度試してください";
			return message;
		}

		// 削除
		try {
			// 編集なら現データを取得
			MstPokemon pokemon = null;
			String id = form.getId();
			Optional<MstPokemon> result = mpRepository.findById(Integer.parseInt(id));
			pokemon = result.get();

			// form内容を繁栄
			ModelMapper mapper = new ModelMapper();
			mapper.map(form, pokemon);

			// 削除日を設定
			Timestamp deleteAt = new Timestamp(System.currentTimeMillis());
			pokemon.setDeletedAt(deleteAt);

			// 更新日を設定
			Timestamp updateAt = deleteAt;
			pokemon.setUpdatedAt(updateAt);

			// 更新
			mpRepository.save(pokemon);
		} catch (Exception e) {
			message = "データ削除に失敗しました。<br>時間をおいて再度試してください";
		}

		return message;
	}

}
