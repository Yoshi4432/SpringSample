package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.forms.impl.EditForm;
import com.example.demo.repositories.MstPokemonRepository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditService {

	protected MstPokemonRepository mstPokemonRepository;
	protected EntityManager entityManager;

//	public EditService(MstPokemonRepository r, EntityManager m) {
//		this.mpRepository = r;
//		this.em = m;
//	}

	public boolean edit(EditForm form) {
		return true;
	}

}
