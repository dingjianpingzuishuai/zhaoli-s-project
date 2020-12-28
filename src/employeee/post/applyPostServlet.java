package employeee.post;

import javaBean.empBean;
import utility.postUtil.applyPost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "applyPostServlet")
public class applyPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pID = Integer.parseInt(request.getParameter("pID"));
        HttpSession session = request.getSession();
        empBean e = (empBean)session.getAttribute("login");
        int empID = e.getEmpID();
        int i = new applyPost().applyPost(empID,pID);
        if(i==1){
            response.sendRedirect("employee/post/success.jsp");
        }else{
            response.sendRedirect("employee/post/failed.jsp");
        }

    }
}
