package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/ajax")
public class AjaxController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSONObject myJsonObj = new JSONObject();
		StringBuilder sb = new StringBuilder();
		
		// List<Product> products = UserServiceImpl.getAllProduct(); 
		
		myJsonObj.append("par1", "123");
		myJsonObj.append("par2", "456");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(myJsonObj.toString());		
	}
}
