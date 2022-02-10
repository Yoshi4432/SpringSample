package com.example.demo.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "MstPokemons")
@Entity
public class MstPokemon {

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private Integer id;

	private Integer nationalPokedex;

	private String name;

	private String type1;

	private String type2;

	private Integer createdUserId;

	private Integer updatedUserId;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;
}
