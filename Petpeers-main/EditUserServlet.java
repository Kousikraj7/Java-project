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
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger LOGGER = LogManager.getLogger(EditUserServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 LOGGER.debug("Get User Methode Is called");
		int userid =Integer.parseInt(request.getParameter("userid"));
		UserDAO userDAO = new UserDAOImpl();
		
		User user= userDAO.findUser(userid);
		 request.setAttribute("user", user);
	        RequestDispatcher rd = request
	                .getRequestDispatcher("editUser.jsp");
	        rd.forward(request, response);
	        LOGGER.debug("User is Fetching from Database  Succesfully");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Post EditUser Method is called");
		int userid =Integer.parseInt(request.getParameter("userid"));
		String name = request.getParameter("name");
		String mobilenumber = request.getParameter("mobilenumber");
		String cityname = request.getParameter("cityname");
		
		User user = new User(userid,name, mobilenumber,cityname);
		System.out.println(user);
		UserDAO userDAO = new UserDAOImpl();
		if(userDAO.updateUser(user)) {
	        response.sendRedirect("./UserServlet");
	        LOGGER.debug("User Editing is Done");
		}else {
	        RequestDispatcher rd = request
	                .getRequestDispatcher("addUser-error.jsp");
	        rd.forward(request, response);
	        LOGGER.debug("Error in Postedit part method");
		}
	}

}
