package employeee.headPicture;

import javaBean.empBean;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utility.jdbcUtil.jdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "HeadPictureServlet")
public class HeadPictureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
		/*1、用于检测是否一个文件上传的请求。在包实现上传项目前，需要解析一个http请求，
		为了确保这个请求的确是一个正确的上传文件，所以组件FileUpload提供了这样一个静态的方法。

		、用于判断是普通表单，还是带文件上传的表单，起了辨别的作用。若返回值为true则是带文件上传的表单；返回值为false则是普通表单。*/
        if(ServletFileUpload.isMultipartContent(request)/*判断上传的数据是不是多段数据，只有文件上传才是多段数据*/) {
            try {
                //创建FileItemFactory
                //fileUpload是apache的commons组件提供的上传组件，它最主要的工作就是帮我们解析request.getInpustream()
                //DiskFileItemFactory 是创建FileItem 对象的工厂
                FileItemFactory fileItemFactory = new DiskFileItemFactory();

                ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
                //// servletFileUpload.parseRequest(request);解析上传的数据，得到每一个表单项 FileItem
                List<FileItem> fileItemList = servletFileUpload.parseRequest(request);
                //Interface Iterator<E> E - 此迭代器返回的元素的类型

                Iterator<FileItem> fileItems = fileItemList.iterator();
                //hasNext()
                //如果迭代具有更多元素，则返回 true 。
                while(fileItems.hasNext()) {
                    FileItem fileItem = fileItems.next();//next() 返回迭代中的下一个元素。
                    if(fileItem.isFormField()) {//isFormField()判断某项是否是普通的表单类型 是为true，反之
                        String name = fileItem.getFieldName();//获取name属性
                        String value = fileItem.getString();//获取value值
                        System.out.println(name+""+value);
                    }else{
                        //获取文件名
                        String fileName = fileItem.getName();//获取文件名
                        System.out.println("文件名"+fileName);
                        //获取拓展名
                        String suffix = fileName.substring(fileName.lastIndexOf('.'));//返回一个字符该字符串是此字符串的子字符串。 子字符串以指定索引处的字符开头，并扩展到该字符串的末尾。
                        //public int lastIndexOf(String str)
                        //返回指定子字符串最后一次出现的字符串中的索引。 空字符串“”的最后一次出现被认为发生在索引值this.length() 。
                        System.out.println("扩展名"+suffix);
                        //设定新的文件名
                        String newFileName = new Date().getTime()+suffix;
                        System.out.println("新文件名"+newFileName);
                        /*public class Fileextends Objectimplements Serializable, Comparable<File>
                         * 文件和目录路径名的抽象表示。 用户界面和操作系统使用依赖于系统的路径名字符串命名文件和目录。
                         * 这个类提供了一个抽象的，独立于系统的层次化路径名的视图。*/
						/*其中一个构造方法是File(String pathname)
						通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。*/
                        File file = new File("C:/Users/张爷爷！！！/IdeaProjects/peopleSystemWeb/web/employee/img/"+newFileName);
                        //getAbsoluteFile() 返回此抽象路径名的绝对形式。
                        String path = file.getAbsolutePath();
                        System.out.println(path);
                        //创建
                        fileItem.write(file);
                        //接下来将路径保存到数据库中
                        HttpSession session = request.getSession();
                        empBean e = (empBean) session.getAttribute("login");
                        int userid = e.getEmpID();

                        String sql = "update emp set headPicture = '"+newFileName+"' where empID='"+userid+"'" ;
                        Class.forName( "com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/peoplesystem?useUnicode=true&serverTimezone=UTC&characterEncoding=utf8","root","mysql");

                        Statement stmt=con.createStatement();
                        int i = stmt.executeUpdate(sql);
                        if(i>0) {
                            e.setHeadPicture(newFileName);

                            session.setAttribute("login", e);
                            //response.sendRedirect("");
                            System.out.println("插入成功");
                            response.sendRedirect("employee/iframe/right.jsp");
                        }else {
                            System.out.println("插入失败");
                        }
                    }
                }
            }catch(Exception e) {

            }
        }
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
