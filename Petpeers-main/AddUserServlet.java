package com.petpeers.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.petpeers.DAO.UserDAO;
import com.petpeers.DAO.UserDAOImpl;
import com.petpeers.modal.User;

/**
 * Servlet implementation class addUserservlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger LOGGER = LogManager.getLogger(AddUserServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Add User Methode is called");
		//int userid =Integer.parseInt(request.getParameter("userid"));
		//System.out.println(userid);
		String name = request.getParameter("name");
		String mobilenumber = request.getParameter("mobilenumber");
		String cityname = request.getParameter("cityname");
		
		User user = new User(name, mobilenumber,cityname);
		System.out.println(user);
		UserDAO userDAO = new UserDAOImpl();
		if(userDAO.addUser(user)) {
			LOGGER.info("User is added Succesfully");
	        response.sendRedirect("./UserServlet");
		}else {
	        RequestDispatcher rd = request
	                .getRequestDispatcher("addUser-error.jsp");
	        rd.forward(request, response);
	        LOGGER.info("Error in Adding User");
		}
	}
}
