package employeee.attendance;

import javaBean.empBean;
import utility.attendanceUtil.check;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "signinServlet")
public class signinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        empBean e = (empBean)session.getAttribute("login");
        int empID = e.getEmpID();
        check c = new check();
        int n = c.signin(empID);
        response.getWriter().println(n);
    }
}
