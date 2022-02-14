package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.example.demo.entities.MstPokemon;
import com.example.demo.forms.impl.SearchForm;
import com.example.demo.repositories.MstPokemonRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class SearchService {

	protected MstPokemonRepository mpRepository;
	protected EntityManager em;

	public SearchService(MstPokemonRepository r, EntityManager m) {
		this.mpRepository = r;
		this.em = m;
	}

	public List<MstPokemon> search(SearchForm form) {
		/* Base */
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MstPokemon> query = cb.createQuery(MstPokemon.class);
		Root<MstPokemon> root = query.from(MstPokemon.class);

		List<Predicate> predicates = new ArrayList<>();

		/* select */
		query.select(root);

		/* where */
		// name
		String name = form.getName();
		if (StringUtils.isNotEmpty(name)) {
			Predicate like = cb.like(root.get("name"), "%" + name + "%");
			predicates.add(like);
		}

		// type
		List<String> tl = new ArrayList<String>();
		if (StringUtils.isNotBlank(form.getType1())) {
			tl.add(form.getType1());
		}
		if (StringUtils.isNotBlank(form.getType2())) {
			tl.add(form.getType2());
		}

		// deleted_at
		Predicate deletedat = cb.isNull(root.get("deletedAt"));
		predicates.add(deletedat);

		// criteria追加
		if (tl.size() > 0) {
			for (String type : tl) {
				Predicate t1 = cb.equal(root.get("type1"), type);
				Predicate t2 = cb.equal(root.get("type2"), type);
				Predicate or = cb.or(t1, t2);
				predicates.add(or);
			}
		}
		// where追加
		Predicate[] ps = predicates.toArray(new Predicate[predicates.size()]);
		query.where(ps);

		/* order */
		Order o1 = cb.asc(root.get("nationalPokedex"));
		Order o2 = cb.asc(root.get("id"));
		Order[] os = { o1, o2 };
		query.orderBy(os);

		/* search */
		List<MstPokemon> list = (List<MstPokemon>) em.createQuery(query).getResultList();

		return list;
	}

}
