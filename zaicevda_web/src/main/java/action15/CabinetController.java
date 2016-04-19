package action15;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CabinetController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6962070291208475126L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		StringBuilder sb = new StringBuilder("<html>");

		sb.append("<head>");
		sb.append("<title>user's Cabinet</title>");
		sb.append("</head>");
		sb.append("<body>");

		sb.append("<center><h2>User: Pupkin<br><br>Status: Ok<br><br>Balance: $0.00 :(");

		sb.append("</body>");
		sb.append("</head>");

		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(sb.toString());
	}
}
