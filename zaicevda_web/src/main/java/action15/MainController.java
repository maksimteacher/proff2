package action15;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6783649405345915544L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		StringBuilder sb = new StringBuilder("<html>");

		sb.append("<head>");
		sb.append("<title>LOGIN-PASS</title>");
		sb.append("</head>");
		sb.append("<body>");

		String login = request.getParameter("login");
		String pass = request.getParameter("pass");

		//sb.append("login=" + login + "<br>");
		//sb.append("pass=" + pass);
		if(login.equals("user") && pass.equals("123")){
			response.sendRedirect("cabinet");
		}else{
			response.sendRedirect("error");
		}
		sb.append("</body>");
		sb.append("</head>");

		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(sb.toString());
	}
}
