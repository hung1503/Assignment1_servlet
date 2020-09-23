package servlet.message;

import javax.servlet.ServletException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class SearchName extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginServlet object;

	public SearchName() {
		this.object = new LoginServlet();
	}

	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, java.io.IOException {
		response.setContentType("text/html");
		final PrintWriter out = response.getWriter();
		out.println("<!Doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Info</title>");
		out.println("</head>");
		out.println("<body>");
		final String nameSearch = request.getParameter("nameSearch");
		int count = 0;
		for (int i = 0; i < LoginServlet.data.size(); ++i) {
			if (LoginServlet.data.get(i).getName().equals(nameSearch)) {
				out.println(LoginServlet.data.get(i).toString());
				count ++;
			}
		}
		if (count == 0) {
			out.println("<p>No results</p>");
		}
		out.println("<a href='index.html'>Back</a>");
		out.println("</body>");
		out.println("</html>");
	}
}