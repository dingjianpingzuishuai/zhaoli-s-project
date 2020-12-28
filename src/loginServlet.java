import javaBean.empBean;
import utility.loginAndRegister.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int empID = Integer.parseInt(request.getParameter("empID"));
        String empPassword = request.getParameter("empPassword");
        int roleID = Integer.parseInt(request.getParameter("ide"));
        login l = new login();
       List<empBean> list = l.login(empID,empPassword,roleID);

        empBean e = null;
        for(int i=0;i<list.size();i++){
            e = list.get(i);
        }
        session.setAttribute("login",e);
        if(list.size()>0){
            if(roleID==1){
                response.sendRedirect("employee/iframe/iframe.jsp");

            }
        }else{
            response.sendRedirect("index.jsp");
        }
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
