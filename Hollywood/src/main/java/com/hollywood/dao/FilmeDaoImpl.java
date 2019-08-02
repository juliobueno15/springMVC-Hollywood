package com.hollywood.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hollywood.model.Filme;

@Repository
public class FilmeDaoImpl implements FilmeDao{

	@Autowired
	@Qualifier("jdbcTemplate")	
	private JdbcTemplate jdbcTemplate;

	public FilmeDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	
	@Override
	public List<Filme> read() {
		List<Filme> filmeList = jdbcTemplate.query("SELECT * FROM filmes", new RowMapper<Filme>() {

			@Override
			public Filme mapRow(ResultSet rs, int rowNum) throws SQLException {
				Filme filme = new Filme();

				filme.setTitulo(rs.getString("titulo"));
				filme.setAno(rs.getInt("ano"));
				filme.setCategoria(rs.getString("categoria"));

				return filme;
			}

		});

		return filmeList;
	}

}
