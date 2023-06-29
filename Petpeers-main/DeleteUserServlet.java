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
 * Servlet implementation class DeleteUserservlet
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger LOGGER = LogManager.getLogger(DeleteUserServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Delete User Methode is called");
		int userid= Integer.parseInt(request.getParameter("userid"));
		User user= new User(userid);
		UserDAO  userDAO= new UserDAOImpl();
		if(userDAO.deleteUser(user)) {
			response.sendRedirect("./UserServlet");
			LOGGER.debug("User is Deleted");
		}else {
			   RequestDispatcher rd = request
		                .getRequestDispatcher("deleteUser-error.jsp");
		        rd.forward(request, response);
		        LOGGER.debug("Error in Delete Method");
		}

	}

}
