package employeee.dept;

import javaBean.deptBean;
import javaBean.empBean;
import utility.deptUtil.selectDept;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "selectDeptServlet")
public class selectDeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        empBean e = (empBean)session.getAttribute("login");
        int deptID = e.getDeptID();
        List<deptBean> list = new selectDept().selectDept(deptID);
        request.setAttribute("list",list);
        request.getRequestDispatcher("employee/dept/selectDept.jsp").forward(request, response);
    }
}
