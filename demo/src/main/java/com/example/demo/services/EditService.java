package com.example.demo.services;

import java.sql.Timestamp;
import java.util.Optional;

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
			// 編集の場合は既存データを取得
			ModelMapper mapper = new ModelMapper();
			MstPokemon pokemon = new MstPokemon();
			mapper.map(form, pokemon);
			mpRepository.save(pokemon);
		} catch (Exception e) {
			message = "データ登録に失敗しました。<br>時間をおいて再度試してください";
		}

		return message;
	}

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
			
			//更新日を設定
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
