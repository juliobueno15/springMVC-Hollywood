package com.hollywood.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hollywood.model.Filme;


public interface FilmeDao {
	
	public List<Filme> read();
}
