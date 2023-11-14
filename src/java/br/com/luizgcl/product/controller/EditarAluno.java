/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.luizgcl.product.controller;

import br.com.luizgcl.product.model.Aluno;
import br.com.luizgcl.product.dao.AlunoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author luizleme
 */
@WebServlet(name = "EditarAluno", urlPatterns = {"/EditarAluno"})
public class EditarAluno extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int idAluno = Integer.parseInt(request.getParameter("id_aluno"));
        String nomeAluno = request.getParameter("nome_aluno");
        int idadeAluno = Integer.parseInt(request.getParameter("idade_aluno"));
        
        Aluno aluno = new Aluno();
        
        aluno.setIdAluno(idAluno);
        aluno.setNomeAluno(nomeAluno);
        aluno.setIdadeAluno(idadeAluno);
        
        String message = "";
        
        try {
            AlunoDAO alunoDAO = new AlunoDAO();
            
            if (alunoDAO.update(aluno)) {
                message = "Aluno atualizado com sucesso!";
            } else {
                message = "Erro ao atualizar aluno!";
            }
            
            request.setAttribute("message", message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
