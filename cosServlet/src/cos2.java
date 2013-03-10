

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.msv.writer.relaxng.Context;
import com.sun.net.httpserver.HttpContext;

/**
 * Servlet implementation class cos2
 */
@WebServlet("/cos2")
public class cos2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public cos2() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String imie = request.getParameter("imie");
		String nazwisko = request.getParameter("nazwisko");

		HttpSession session = request.getSession();
		ServletContext con = request.getServletContext();
		Integer licznik = (Integer)con.getAttribute("licznik");
		if (licznik==null){
			licznik = 0;
		}
		licznik++;	
		session.setAttribute("imie", imie);
		session.setAttribute("nazwisko", nazwisko);

		con.setAttribute("licznik", licznik);
				
		
	PrintWriter writ = response.getWriter();
	writ.print(imie + " " + nazwisko + " wiedz, że cos sie dzieje..." + licznik);
	
	
	}

}
