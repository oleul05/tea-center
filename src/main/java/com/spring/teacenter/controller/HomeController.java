package com.spring.teacenter.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.teacenter.dao.TeaCenterDao;
import com.spring.teacenter.model.Customer;
import com.spring.teacenter.model.Owner;
import com.spring.teacenter.model.Product;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	TeaCenterDao dao = new TeaCenterDao();
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {

		return new ModelAndView("home");
	}

	@RequestMapping(value = "/owner", method = RequestMethod.GET)
	public ModelAndView owner(HttpServletRequest request, HttpServletResponse response) {

		 HttpSession session = request.getSession();

		return new ModelAndView("owner");
	}
	
	@RequestMapping(value = "/customer-login", method = RequestMethod.GET)
	public ModelAndView getCustomerLogin(HttpServletRequest request, HttpServletResponse response) {

		 HttpSession session = request.getSession();

		return new ModelAndView("customerlogin");
	}
	
	@RequestMapping(value="/add-product", method = RequestMethod.GET)
	public ModelAndView addProduct(HttpServletRequest request) throws Exception {
		
		return new ModelAndView("addproduct");
	}
	
	@RequestMapping(value="/view-product", method = RequestMethod.GET)
	public ModelAndView viewProduct(HttpServletRequest request) throws Exception {
		
		List<Product> product = dao.getAllProduct();
		
		return new ModelAndView("viewproduct","product",product);
	}
	
	@RequestMapping(value="/edit-product/{id}", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable int id, HttpServletRequest request) throws Exception {
		
		logger.info("EmpId=" + id);
		
		Product prd = dao.getProduct(id);
		
		return new ModelAndView("editproduct","prd",prd);
	}
	@RequestMapping(value="/edit-customer/{id}", method = RequestMethod.GET)
	public ModelAndView getEditCustomer(@PathVariable int id, HttpServletRequest request) throws Exception {
		
		logger.info("EmpId=" + id);
		
		Customer cus = dao.getCustomerById(id);
		//Product prd = dao.getProduct(id);
		
		return new ModelAndView("editcustomer","cus",cus);
	}
	
	
	@RequestMapping(value = "deleteproduct/{id}", method = RequestMethod.GET) 
	public ModelAndView deleteProduct(HttpServletRequest request, @PathVariable int id) throws Exception {
		
		dao.deleteProduct(id);
		
		return new ModelAndView("redirect:/view-product");
	}
	@RequestMapping(value = "deletecustomer/{id}", method = RequestMethod.GET) 
	public ModelAndView getDeleteCustomer(HttpServletRequest request, @PathVariable int id) throws Exception {
		
		dao.deleteCustomer(id);
		
		return new ModelAndView("redirect:/all-customer");
	}
	
	//Customer GET
	
	@RequestMapping(value="/add-customer", method = RequestMethod.GET)
	public ModelAndView addCustomer(HttpServletRequest request) throws Exception {
		
		return new ModelAndView("addcustomer");
	}
	
	@RequestMapping(value = "/all-customer", method = RequestMethod.GET)
	public ModelAndView getAllCustomer(HttpServletRequest request) throws Exception {
		
		List<Customer> customer = dao.getAllCustomer();
		
		return new ModelAndView("allcustomer","customer",customer);
	}
	@RequestMapping(value = "/customer-product", method = RequestMethod.GET) 
	public ModelAndView getAllProductCustomer(HttpServletRequest request) throws Exception {
		
		List<Product> product = dao.getAllProduct();
		
		return new ModelAndView("allproductforcustomer","product",product);
	}
	
	@RequestMapping(value = "/owner", method = RequestMethod.POST)
	public ModelAndView owner(HttpServletRequest request, HttpSession session) throws Exception {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String message;

		if (TeaCenterDao.checkClient(username, password)) {
			
			session.setAttribute("username", username);

			return new ModelAndView("redirect:/owner");

		} else {
			message = "Wrong username or password.";

			return new ModelAndView("home", "message", message);
		}
	}
	
	@RequestMapping(value = "/customer-login", method = RequestMethod.POST)
	public ModelAndView postCustomerLogin(HttpServletRequest request, HttpSession session) throws Exception {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String message;

		if (TeaCenterDao.customerLogin(username, password)) {
			
			session.setAttribute("username", username);

			return new ModelAndView("redirect:/customer-product");

		} else {
			message = "Wrong username or password.";

			return new ModelAndView("home", "message", message);
		}
	}
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public ModelAndView addproduct(HttpServletRequest request) throws Exception {
		
		String name = request.getParameter("productname");
		Product prod = new Product();
		prod.setName(name);
		
		int status = dao.saveProduct(prod);
		if(status >0) {
			return new ModelAndView("redirect:/view-product");
		} else {
			return new ModelAndView("redirect:/owner");
		}
	}
	
	@RequestMapping(value = "updateproduct", method = RequestMethod.POST)
	public ModelAndView updateProduct(HttpServletRequest request) throws Exception {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("editproductname");
		
		Product prod = new Product();
		
		prod.setId(id);
		prod.setName(name);
		
		int status = dao.updateProduct(prod);
		if(status >0) {
			return new ModelAndView("redirect:/view-product");
		} else {
			return new ModelAndView("redirect:/owner");
		}
	}
	
	@RequestMapping(value = "updatecustomer", method = RequestMethod.POST)
	public ModelAndView postUpdateCustomer(HttpServletRequest request) throws Exception {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String floor = request.getParameter("floor");
		String building = request.getParameter("building");
		String roomno = request.getParameter("roomno");
		String information = request.getParameter("information");
		
		Customer cus = new Customer();
		
		cus.setId(id);
		cus.setUsername(username);
		cus.setPassword(password);
		cus.setName(name);
		cus.setSurname(surname);
		cus.setFloor(floor);
		cus.setBuilding(building);
		cus.setRoomno(roomno);
		cus.setInformation(information);
		
		
		int status = dao.updateCustomer(cus);
		if(status >0) {
			return new ModelAndView("redirect:/all-customer");
		} else {
			return new ModelAndView("redirect:/owner");
		}
	}
	
	@RequestMapping(value="/addCustomerPost", method = RequestMethod.POST)
	public ModelAndView addCustomerPost(HttpServletRequest request) throws Exception {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String floor = request.getParameter("floor");
		String building = request.getParameter("building");
		String roomno = request.getParameter("roomno");
		String information = request.getParameter("information");
		
		Customer cus = new Customer();
		
		cus.setUsername(username);
		cus.setPassword(password);
		cus.setName(name);
		cus.setSurname(surname);
		cus.setFloor(floor);
		cus.setBuilding(building);
		cus.setRoomno(roomno);
		cus.setInformation(information);
		
		int status = dao.saveCustomer(cus);
		
		if(status >0) {
			return new ModelAndView("redirect:/add-customer");
		} else {
			return new ModelAndView("redirect:/owner");
		}
		
	}
	

}
