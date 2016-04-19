package action15;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2876345826293821160L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder("<html>");

		sb.append("<head>");
		sb.append("<title>ERROR!!!</title>");
		sb.append("</head>");
		sb.append("<body>");

		sb.append("<center><font color=red><h1>MEGA-ERROR!!!");

		sb.append("</body>");
		sb.append("</head>");

		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(sb.toString());
	}

}
