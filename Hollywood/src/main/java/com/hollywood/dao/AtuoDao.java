package com.hollywood.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hollywood.model.Atuo;


public interface AtuoDao {
	
	public List<Atuo> filmesByAtor(String nomeAtor);

}
