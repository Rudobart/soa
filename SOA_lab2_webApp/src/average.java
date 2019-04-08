import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class average extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        int n1 = Integer.parseInt(request.getParameter("number1"));
        int n2 = Integer.parseInt(request.getParameter("number2"));
        int n3 = Integer.parseInt(request.getParameter("number3"));
        int n4 = Integer.parseInt(request.getParameter("number4"));
        int n5 = Integer.parseInt(request.getParameter("number5"));
        double average=(n1+n2+n3+n4+n5)/5;
        out.println("<html>");
        out.println("<head><title>Srednia Servlet</title></head>");
        out.println("<body>");
        out.println("<p> Srednia: " + average  +" </p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
