package com.hollywood.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hollywood.model.Ator;
import com.hollywood.model.Filme;


public interface AtorDao {

	public int create(Ator ator);

	public List<Ator> read();

	public List<Ator> findAtorByName(String nomeAtor);

	public int update(Ator ator, String nomeCadastro);

	public int delete(String nomeAtor);

}
