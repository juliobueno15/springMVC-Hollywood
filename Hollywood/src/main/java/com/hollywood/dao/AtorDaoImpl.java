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

import com.hollywood.model.Ator;
import com.hollywood.model.Filme;

@Repository
public class AtorDaoImpl implements AtorDao {

	@Autowired
	@Qualifier("jdbcTemplate")	
	private JdbcTemplate jdbcTemplate;

	public AtorDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	@Override
	public int create(Ator ator) {

		String sql = "insert into atores(nome,idade,sexo) values(?,?,?)";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] { ator.getNome(), ator.getIdade(), ator.getSexo() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Ator> read() {
		List<Ator> atorList = jdbcTemplate.query("SELECT * FROM atores", new RowMapper<Ator>() {

			@Override
			public Ator mapRow(ResultSet rs, int rowNum) throws SQLException {
				Ator ator = new Ator();

				ator.setNome(rs.getString("nome"));
				ator.setIdade(rs.getInt("idade"));
				ator.setSexo(rs.getString("sexo"));

				return ator;
			}

		});

		return atorList;
	}

	@Override
	public List<Ator> findAtorByName(String nomeAtor) {

		List<Ator> atorList = jdbcTemplate.query("SELECT * FROM atores where nome=?",
				new Object[] { nomeAtor }, new RowMapper<Ator>() {

					@Override
					public Ator mapRow(ResultSet rs, int rowNum) throws SQLException {
						Ator ator = new Ator();

						ator.setNome(rs.getString("nome"));
						ator.setIdade(rs.getInt("idade"));
						ator.setSexo(rs.getString("sexo"));

						return ator;
					}

				});

		return atorList;
	}

	@Override
	public int update(Ator ator, String nomeCadastro) {
		String sql = "update  atores set nome=?, idade=?, sexo=? where nome=?";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] { ator.getNome(), ator.getIdade(), ator.getSexo(), nomeCadastro });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(String nomeAtor) {
		String sql = "delete from atores where nome=?";

		try {

			int counter = jdbcTemplate.update(sql, new Object[] { nomeAtor });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}