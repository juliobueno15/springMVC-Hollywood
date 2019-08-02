package com.hollywood.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.hollywood.dao.AtorDao;

@Controller
public class DeleteController {

	@Autowired
	private AtorDao atorDao;

	@RequestMapping(value = "/delete/{nomeAtor}")
	public ModelAndView deleteAtorByNome(ModelAndView mv, @PathVariable("nomeAtor") String nomeAtor)
			throws IOException {

		int counter = atorDao.delete(nomeAtor);

		if (counter > 0) {
			mv.addObject("msg", "Ator deletado para o registro: " + nomeAtor);
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("delete");

		return mv;
	}

}