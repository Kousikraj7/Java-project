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
 * Servlet implementation class addPetServlet
 */
@WebServlet("/AddPetServlet")
public class AddPetServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    static Logger LOGGER = LogManager.getLogger(AddPetServlet.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	LOGGER.debug("Add pet Methode is called");
//    	int petid =Integer.parseInt(request.getParameter("petid"));
//        System.out.println(petid);
        String speciesname = request.getParameter("speciesname");
        String petname =request.getParameter("petname");
        float price = Float.parseFloat(request.getParameter("price"));
        Pet pet = new Pet(speciesname,petname,price);
        System.out.println(pet);
        PetDao petdao = new PetDaoImpl();
        if(petdao.addPet(pet)) {
        	LOGGER.info("Pet is added Succesfully");
            response.sendRedirect("./PetServlet");
            LOGGER.info("Adding Pet is Done");
        }else {
            RequestDispatcher rd = request
                    .getRequestDispatcher("addPetError.jsp");
            rd.forward(request, response);
            LOGGER.debug("Error Occured in Adding Pet");
        }
        
}
}