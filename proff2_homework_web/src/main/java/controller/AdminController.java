package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin")
public class AdminController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String name = (String)session.getAttribute("name");
		
		System.out.println("Admin_name="+name);
		req.setAttribute("atr", name);
		req.getRequestDispatcher("jsp/admin.jsp").forward(req, resp);

	}

}
