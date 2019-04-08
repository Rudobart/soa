import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WyborPiwa", urlPatterns = {"/wyborPiwa"})
public class WyborPiwa extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        String kolor = request.getParameter("kolor");
        int wiek = Integer.parseInt(request.getParameter("wiek"));
        if (wiek<18){
            out.println("Tylko dla osób pelnoletnich");
        }
        else{
            EkspertPiwny ekspertPiwny = new EkspertPiwny();
            String piwo = ekspertPiwny.polecPiwo(kolor);
            request.setAttribute("piwo", piwo);
            request.getRequestDispatcher("/wynik.jsp").forward(request,response);
        }
    }
}
