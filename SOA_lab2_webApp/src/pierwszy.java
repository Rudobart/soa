import java.io.IOException;
import java.io.PrintWriter;


public class pierwszy extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        String imie = request.getParameter("imie");
        int wiek = Integer.parseInt(request.getParameter("wiek"));
        out.println("<html>");
        out.println("<head><title>pierwszy Servlet</title></head>");
        out.println("<body>");
        out.println("<p>Witaj, " + imie + ", masz " + wiek + " lat</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}