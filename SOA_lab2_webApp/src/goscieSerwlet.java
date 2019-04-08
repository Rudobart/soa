import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.joining;
import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;


@WebServlet(name = "goscieSerwlet")
public class goscieSerwlet extends HttpServlet {

    private List<post> posts = new Vector<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        var gosc = new Gosc();
        gosc.login=request.getParameter("login");
        gosc.email=request.getParameter("email");

        request.getSession(true).setAttribute("guest", gosc);
        redirectToGuestPostPage(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void redirectToGuestPostPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("posts", posts);

        var dispatcher = request.getRequestDispatcher("/goscie.jsp");
        dispatcher.forward(request, response);
    }
}