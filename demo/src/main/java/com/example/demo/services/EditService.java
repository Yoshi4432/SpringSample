package com.example.demo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.MstPokemon;
import com.example.demo.forms.impl.EditForm;
import com.example.demo.repositories.MstPokemonRepository;

import jakarta.persistence.EntityManager;

@Service
public class EditService {

	protected MstPokemonRepository mpRepository;
	protected EntityManager em;

	public EditService(MstPokemonRepository r, EntityManager m) {
		this.mpRepository = r;
		this.em = m;
	}

	public MstPokemon findInitData(EditForm form) {
		/* 検索 */
		int id = Integer.parseInt(form.getId());
		Optional<MstPokemon> pokemon = mpRepository.findById(id);

		return pokemon.get();
	}

	public boolean edit(EditForm form) {
		return true;
	}

}
