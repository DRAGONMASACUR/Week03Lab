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
public class ArithmeticCalculatorServlet extends HttpServlet {

    //initalize variables
    int first, second, result;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("result", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("first").equals("") || request.getParameter("second").equals("")) {
            request.setAttribute("result", "Invalid");

            try {
                first = Integer.parseInt(request.getParameter("first"));
                request.setAttribute("first", first);
            } catch (NumberFormatException ex) {
            }

            try {
                second = Integer.parseInt(request.getParameter("second"));
                request.setAttribute("second", second);
            } catch (NumberFormatException ex) {
            }

            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                    .forward(request, response);
            return;
        } else {

            switch (request.getParameter("operation")) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
                case "*":
                    result = first * second;
                    break;
                case "%":
                    result = first % second;
                    break;
            }
s
            request.setAttribute("result", result);
            request.setAttribute("first", first);
            request.setAttribute("second", second);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                    .forward(request, response);
        }
    }
}
