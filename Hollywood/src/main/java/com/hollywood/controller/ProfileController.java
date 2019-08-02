package com.hollywood.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hollywood.dao.AtuoDao;
import com.hollywood.model.Atuo;

@Controller
public class ProfileController {

	@Autowired
	private AtuoDao atuoDao;

	@RequestMapping(value = "/profile/{nomeAtor}")
	public ModelAndView filmeByAtor(ModelAndView mv, @PathVariable("nomeAtor") String nomeAtor)
			throws IOException {

		List<Atuo> listAtuo = atuoDao.filmesByAtor(nomeAtor);
		
		mv.addObject("listAtuo", listAtuo);
		mv.addObject("nomeAtor", nomeAtor);
		mv.setViewName("atorProfile");

		return mv;
	}

}