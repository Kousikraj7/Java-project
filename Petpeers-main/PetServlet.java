package com.petpeers.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petpeers.DAO.PetDaoImpl;
 
 
/**
 * Servlet implementation class petServlet
 */
@WebServlet("/PetServlet")
public class PetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("petList", new PetDaoImpl().findPet());
        RequestDispatcher rd = request
                .getRequestDispatcher("petList.jsp");
        rd.forward(request, response);

    }
 
}