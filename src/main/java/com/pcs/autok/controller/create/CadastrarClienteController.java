package com.pcs.autok.controller.create;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcs.autok.model.Cliente;

@WebServlet("/cadastrarCliente2")
public class CadastrarClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doService(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doService(request, response);
	}

	private void doService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Cliente cliente = new Cliente();
			request.setAttribute("cliente", cliente);
			request.getRequestDispatcher("/views/cliente/formulario.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	}

}
