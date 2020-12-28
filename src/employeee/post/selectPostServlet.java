package employeee.post;

import javaBean.empBean;
import javaBean.postBean;
import utility.postUtil.selectPost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "selectPostServlet")
public class selectPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        empBean e = (empBean)session.getAttribute("login");
        int deptID = e.getDeptID();
        List<postBean> list = new selectPost().selectPost(deptID);
        request.setAttribute("list",list);
        request.getRequestDispatcher("employee/post/selectPost.jsp").forward(request, response);
    }
}
