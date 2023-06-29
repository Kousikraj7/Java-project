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

import com.petpeers.DAO.PetDao;
import com.petpeers.DAO.PetDaoImpl;
import com.petpeers.modal.Pet;

/**
 * Servlet implementation class deletePetServlet
 */
@WebServlet("/DeletePetServlet")
public class DeletePetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static Logger LOGGER = LogManager.getLogger(DeletePetServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Delete Pet Methode is called");
    	int petid= Integer.parseInt(request.getParameter("petId"));
        Pet pet= new Pet(petid);
        PetDao petdao= new PetDaoImpl();
        if(petdao.deletePet(pet)) {
            response.sendRedirect("./PetServlet");
    		LOGGER.debug("Pet is Delete Successfully");
        }else {
               RequestDispatcher rd = request
                        .getRequestDispatcher("deletePetError.jsp");
                rd.forward(request, response);
        		LOGGER.debug("Error in Deleting Method");
        		}
    }
 
}