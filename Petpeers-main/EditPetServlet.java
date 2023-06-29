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
 * Servlet implementation class EditPetServlet
 */
@WebServlet("/EditPetServlet")
public class EditPetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static Logger LOGGER = LogManager.getLogger(EditPetServlet.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	LOGGER.debug("Get Pet Methode is called");
    	int petid =Integer.parseInt(request.getParameter("petId"));
        PetDao petdao = new PetDaoImpl();

        Pet pet= petdao.findPet(petid);
         request.setAttribute("pet", pet);
         System.out.println(pet);
            RequestDispatcher rd = request
                    .getRequestDispatcher("editPet.jsp");
            rd.forward(request, response);
         	LOGGER.debug("PetList is Fetched From Database");
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	LOGGER.debug("Post Pet Methode is called");
    	int petid =Integer.parseInt(request.getParameter("petid"));
        String speciesname = request.getParameter("speciesname");
         String petname =request.getParameter("petname");
        float price = Float.parseFloat(request.getParameter("price"));

        Pet pet = new Pet(petid,speciesname, petname,price);
        System.out.println(pet);
        PetDao petdao = new PetDaoImpl();
        if(petdao.editPet(pet)) {
            response.sendRedirect("./PetServlet");
        	LOGGER.debug("Edit Pet is Added succesfully");
        }else {
            RequestDispatcher rd = request
                    .getRequestDispatcher("editPetError.jsp");
            rd.forward(request, response);
        	LOGGER.debug("Error in Edit Pet Methode");
        }
    }
 
}