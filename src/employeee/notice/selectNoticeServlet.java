package employeee.notice;

import javaBean.empBean;
import javaBean.noticeBean;
import utility.noticeUtil.selectNotice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "selectNoticeServlet")
public class selectNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        empBean e = (empBean)session.getAttribute("login");
        int deptID = e.getDeptID();
        List<noticeBean> list = new selectNotice().selectNotice(deptID);
        request.setAttribute("list",list);
        request.getRequestDispatcher("employee/notice/selectNotice.jsp").forward(request, response);
    }
}
