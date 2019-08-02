package com.hollywood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.hollywood.dao.AtorDao;
import com.hollywood.dao.AtorDaoImpl;
import com.hollywood.model.Ator;

@Controller
public class CreateController {

	@Autowired
	private AtorDaoImpl atorDao;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createAtor(@RequestParam("nome") String nome, @RequestParam("idade") int idade,
			@RequestParam("sexo") String sexo, ModelAndView mv) {

		Ator ator = new Ator();
		ator.setNome(nome);
		ator.setIdade(idade);
		ator.setSexo(sexo);

		int counter = atorDao.create(ator);

		if (counter > 0) {
			mv.addObject("msg", "ator registrado com sucesso.");
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("create");

		return mv;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView createIndex(ModelAndView mv) {
		
		mv.setViewName("create");

		return mv;
		
	}

	
}