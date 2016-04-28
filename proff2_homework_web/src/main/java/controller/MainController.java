package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main")
public class MainController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] arrCook =  req.getCookies();
		for(Cookie cook:arrCook){
			if(cook.getName().equals("cook")){
				req.setAttribute("cookName", cook.getValue());
			}
		}
		String name = (String) req.getParameter("loginIn");
		String pass = (String) req.getParameter("passIn");
		System.out.println("name="+name);
		if(name!= null){
			Cookie cookie = new Cookie("cook",name);
			cookie.setMaxAge(3600);
			cookie.setHttpOnly(true);
			resp.addCookie(cookie);
			
			
			System.out.println("Main_name="+name);
			HttpSession session = req.getSession();
			session.setAttribute("name", name);
			resp.sendRedirect("admin");
		} else {		
			req.getRequestDispatcher("jsp/main.jsp").forward(req, resp);
		}	
	}

}
