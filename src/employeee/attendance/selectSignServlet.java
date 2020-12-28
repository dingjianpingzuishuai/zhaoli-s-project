package employeee.attendance;

import javaBean.attendanceBean;
import javaBean.empBean;
import utility.attendanceUtil.selectCheck;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "selectSignServlet")
public class selectSignServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        empBean e = (empBean)session.getAttribute("login");
        int empID = e.getEmpID();
        selectCheck s = new selectCheck();
        List<attendanceBean> list = s.selectCheck(empID);
        System.out.println(list.size());
        request.setAttribute("list",list);
        request.getRequestDispatcher("employee/attendance/attendanceIframe.jsp").forward(request, response);
    }
}
