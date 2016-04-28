package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;

public class ProductController extends HttpServlet {
	List<Product> list;

	@Override
	public void init() throws ServletException {
		Product[] products = new Product[] { new Product("car", 1), new Product("truck", 2) };
		list = new ArrayList(Arrays.asList(products));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String name = request.getParameter("productName");
			int code = Integer.parseInt(request.getParameter("productCode"));
			list.add(new Product(name, code));
		} catch (Exception e) {
			System.out.println("error convert data-form to Product!");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/product.jsp");
		request.setAttribute("products", list);
		dispatcher.forward(request, response);

	}
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("productName");
			int code = Integer.parseInt(request.getParameter("productCode"));
			list.add(new Product(name, code));
		} catch (Exception e) {
			System.out.println("error convert data-form to Product!");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/product.jsp");
		request.setAttribute("products", list);
		dispatcher.forward(request, response);
	}
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/proff2_web/first");
	}
	
}
