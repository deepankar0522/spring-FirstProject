package com.app.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.app.deligate.RegisterDeligate;
import com.app.model.UserRegVO;;

@Controller
@EnableWebMvc
public class RegisterController {

	@Autowired
	private RegisterDeligate registerDeligate;

	public RegisterDeligate getRegisterDeligate() {
		return registerDeligate;
	}

	public void setRegisterDeligate(RegisterDeligate registerDeligate) {
		this.registerDeligate = registerDeligate;
	}

	@RequestMapping(value = "/Register", method = RequestMethod.GET)
	public ModelAndView displayRegister() {
		ModelAndView model = new ModelAndView("Register");
		return model;
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView newUserRegister(@RequestBody(required = false) UserRegVO userRegVO, HttpServletRequest request,
			HttpServletRequest response) throws SQLException {

		ModelAndView model = new ModelAndView();

		System.out.println("Add User: "+userRegVO.getUsername() + userRegVO.getEmail() + userRegVO.getPassword());

		boolean success = registerDeligate.newUserRegister(userRegVO.getUsername(), userRegVO.getEmail(), userRegVO.getPassword());
		request.setAttribute("addedUser", "added user: " + userRegVO.getEmail() + " username: " + userRegVO.getUsername());
		return model;

	}

}
