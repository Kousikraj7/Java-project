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

import com.petpeers.DAO.UserDAOImpl;

/**
 * Servlet implementation class Userservlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger LOGGER = LogManager.getLogger(UserServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("User Servlet is called");
		request.setAttribute("userList", new UserDAOImpl().findUser());
	        RequestDispatcher rd = request
	                .getRequestDispatcher("userList.jsp");
	        rd.forward(request, response);
	        LOGGER.debug("User List is Fetched from Database");
	}

}
