package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 1drag
 */
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int age = 0;

        //set attributes for jsp
        String stringAge = request.getParameter("age");

        //validation
        if (stringAge.equals("")) {
            request.setAttribute("message", "You must give your current age.");

            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                    .forward(request, response);
            return; // very important!
        } else {

            try {
                age = Integer.parseInt(request.getParameter("age"));
            } catch (NumberFormatException ex) {
                request.setAttribute("message", "You must give your current age.");
                getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                        .forward(request, response);
                return;
            }

            // do calculation
            age++;
            request.setAttribute("message", "You're age next birthday will be " + age);

            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                    .forward(request, response);
        }
    }

}
