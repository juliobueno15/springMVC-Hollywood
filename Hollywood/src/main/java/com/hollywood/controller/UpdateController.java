package com.hollywood.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.hollywood.dao.AtorDao;
import com.hollywood.model.Ator;

@Controller
public class UpdateController {

	@Autowired
	private AtorDao atorDao;

	@RequestMapping(value = "/update/{nomeAtor}")
	public ModelAndView findAtorByName(ModelAndView model, @PathVariable("nomeAtor") String nomeAtor)
			throws IOException {

		List<Ator> listAtor = atorDao.findAtorByName(nomeAtor);
		model.addObject("listAtor", listAtor);
		model.setViewName("update");

		return model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateAtor(@RequestParam("nome") String nome, @RequestParam("idade") int idade, @RequestParam("sexo") String sexo, @RequestParam("nomeCadastro") String nomeCadastro, ModelAndView mv)
	{

		Ator ator = new Ator();
		
		ator.setNome(nome);
		ator.setIdade(idade);
		ator.setSexo(sexo);
		
		int counter = atorDao.update(ator, nomeCadastro);
		
		if (counter > 0) {
			mv.addObject("msg", "Registros atualizados para o ator: " + ator.getNome());
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("update");

		return mv;
	}
}