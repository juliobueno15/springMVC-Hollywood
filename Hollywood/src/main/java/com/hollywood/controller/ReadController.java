package com.hollywood.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.hollywood.dao.AtorDao;
import com.hollywood.model.Ator;
import com.hollywood.dao.FilmeDao;
import com.hollywood.model.Filme;

@Controller
public class ReadController {

	@Autowired
	private AtorDao atorDao;
	
	@Autowired
	private FilmeDao filmeDao;
	
	@RequestMapping(value = "/read")
	public ModelAndView readAtor(ModelAndView model) throws IOException {
		
		List<Ator> listAtor = atorDao.read();
		model.addObject("listAtor", listAtor);
		model.setViewName("read");

		return model;
	}
	
	@RequestMapping(value = "/readFilme")
	public ModelAndView readFilme(ModelAndView model) throws IOException {

		List<Filme> listFilme = filmeDao.read();
		model.addObject("listFilme", listFilme);
		model.setViewName("readFilme");

		return model;
	}
	
	
}