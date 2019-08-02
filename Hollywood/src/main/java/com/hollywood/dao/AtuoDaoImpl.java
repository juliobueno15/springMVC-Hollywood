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

import com.hollywood.model.Atuo;

@Repository
public class AtuoDaoImpl implements AtuoDao{
	
	@Autowired
	@Qualifier("jdbcTemplate")	
	private JdbcTemplate jdbcTemplate;

	public AtuoDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}
	
	@Override
	public List<Atuo> filmesByAtor(String nomeAtor){
		String sql = "select * from atuo where ator=?";
		
		List<Atuo> atuoList = jdbcTemplate.query(sql,new Object[] { nomeAtor }, new RowMapper<Atuo>() {

					@Override
					public Atuo mapRow(ResultSet rs, int rowNum) throws SQLException {
						Atuo atuo = new Atuo();

						atuo.setAtor(rs.getString("ator"));
						atuo.setFilme(rs.getString("filme"));
						atuo.setPapel(rs.getString("papel"));

						return atuo;
					}

				});

		return atuoList;
		
	}
	
}
