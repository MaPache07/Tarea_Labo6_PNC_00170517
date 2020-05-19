package com.uca.capas.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.dao.ImportanciaDAO;
import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;

@Controller
public class MainController {
	
	@Autowired
	private ImportanciaDAO impDao;
	@Autowired
	private ContribuyenteDAO conDao;
	
	@RequestMapping("/inicio")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		List<Importancia> imps = null;
		try {
			imps = impDao.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("importancias", imps);
		mav.addObject("contribuyente", new Contribuyente());
		return mav;
	}
	
	@RequestMapping("/insert")
	public ModelAndView insertContribuyente(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		List<Importancia> imps = null;
		try {
			imps = impDao.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("importancias", imps);
		if(!result.hasErrors()) {
			Calendar c = Calendar.getInstance();
			String fecha = Integer.toString(c.get(Calendar.DATE)) + "/" + Integer.toString(c.get(Calendar.MONTH)+1) + "/" + Integer.toString(c.get(Calendar.YEAR));
			Date date = new Date();
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
			} catch (ParseException e1) {
				e1.printStackTrace();
			} 
			contribuyente.setFecha(date);
			mav.addObject("contribuyente", new Contribuyente());
			try {
				conDao.insert(contribuyente);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		try {
			contribuyentes = conDao.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("listado");
		mav.addObject("contribuyentes", contribuyentes);
		return mav;
	}
	
	@RequestMapping("/editar")
	public ModelAndView editar(@ModelAttribute Contribuyente contribuyente) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("editar");
		List<Importancia> imps = null;
		try {
			imps = impDao.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("importancias", imps);
		mav.addObject("contribuyente", contribuyente);
		return mav;
	}
	
	@RequestMapping("/listado2")
	public ModelAndView update(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(!result.hasErrors()) {
			Calendar c = Calendar.getInstance();
			String fecha = Integer.toString(c.get(Calendar.DATE)) + "/" + Integer.toString(c.get(Calendar.MONTH)+1) + "/" + Integer.toString(c.get(Calendar.YEAR));
			Date date = new Date();
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
			} catch (ParseException e1) {
				e1.printStackTrace();
			} 
			contribuyente.setFecha(date);
			try {
				conDao.insert(contribuyente);
			} catch(Exception e) {
				e.printStackTrace();
			}
			mav.setViewName("listado");
		}
		else {
			mav.setViewName("editar");
		}
		return mav;
	}
}
