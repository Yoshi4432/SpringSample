package com.example.demo.services;

import java.util.Optional;

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
		try {
			ModelMapper mapper = new ModelMapper();
			MstPokemon pokemon = new MstPokemon();
			mapper.map(form, pokemon);
			mpRepository.save(pokemon);
		} catch (Exception e) {
			message = "データ登録に失敗しました。<br>時間をおいて再度試してください";
		}

		return message;
	}

}
