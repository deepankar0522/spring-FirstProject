package com.app.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.deligate.LoginDeligate;
import com.app.model.UserLoginVO;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/Login")
public class MyController {

	@Autowired
	private LoginDeligate loginDeligate;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "redirect:/Login";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView Login(@ModelAttribute("LoginForm") UserLoginVO userLoginVO, HttpServletRequest request,
			HttpServletRequest response) {
		ModelAndView model = null;

		try {
			boolean isValidUser = loginDeligate.isValidUser(userLoginVO.getUsername(), userLoginVO.getPassword());
			if (isValidUser) {
				System.out.println("Login succcessful");
				request.setAttribute("loggedInUser", userLoginVO.getUsername());
				model = new ModelAndView("Welcome");
			} else {
				System.out.println("Login failed");
				request.setAttribute("loggedInFailed", "invalid credentials");
				model = new ModelAndView("/Login");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
}
