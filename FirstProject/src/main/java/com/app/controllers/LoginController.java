package com.app.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.deligate.LoginDeligate;
import com.app.model.UserLoginVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class LoginController {

	@Autowired
	private LoginDeligate loginDeligate;

	public LoginDeligate getLoginDeligate() {
		return loginDeligate;
	}

	public void setLoginDeligate(LoginDeligate loginDeligate) {
		this.loginDeligate = loginDeligate;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "redirect:/Login";
	}

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response,
			UserLoginVO userLoginVO) {
		ModelAndView model = new ModelAndView("Login");
		// LoginBean loginBean = new LoginBean();
		model.addObject("userLoginVO", userLoginVO);
		model.addObject("ApplicationName", "My First Application");
		return model;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView Login(@ModelAttribute("userLoginVO") UserLoginVO userLoginVO, HttpServletRequest request,
			HttpServletRequest response) {
		ModelAndView model = null;
		System.out.println("user: " + userLoginVO.getUsername() + " pass: " + userLoginVO.getPassword());
		try {
			boolean isValidUser = loginDeligate.isValidUser(userLoginVO.getUsername(), userLoginVO.getPassword());
			if (isValidUser) {
				System.out.println("Login succcessful");
				request.setAttribute("loggedInUser", userLoginVO.getUsername());
				model = new ModelAndView("Welcome");
			} else {
				System.out.println("Login failed");
				request.setAttribute("loggedInFailed", "invalid credentials");
				model = new ModelAndView("Login");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
}
