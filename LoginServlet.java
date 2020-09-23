package servlet.message;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Vector;
import javax.servlet.http.HttpServlet;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Vector<Message> data;

	static {
		LoginServlet.data = new Vector<Message>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		final Calendar calendar = Calendar.getInstance();
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		LoginServlet.data.add(
				new Message(request.getParameter("userName"), request.getParameter("userMessage"), formatter.format(calendar.getTime())));

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<!Doctype html>");
		out.println("<html>");
		out.println("<body>");

		for (int i = 0; i < LoginServlet.data.size(); ++i) {
			out.println(LoginServlet.data.get(i).toString());
		}

		out.println("<a href='index.html'>Back</a>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
