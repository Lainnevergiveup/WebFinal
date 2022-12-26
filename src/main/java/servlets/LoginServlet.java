package servlets;

import beans.Account;
import beans.Course;
import org.jetbrains.annotations.NotNull;
import utils.AccountUtil;
import utils.CourseUtil;
import utils.SCUtil;
import utils.TCUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/Login.do")
public class LoginServlet extends HttpServlet {
    CourseUtil courseUtil = null;
    TCUtil tcUtil=null;
    SCUtil scUtil;
    AccountUtil accountUtil;
    Account account;
    List<Course> allCourseslist;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initthis();
        comfirm(request, response);
    }
    protected void comfirm(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//验证登录
        if (request.getSession().getAttribute("account")==null) {
            String id = request.getParameter("uname");
            String pwd = request.getParameter("upwd");
            account = new AccountUtil().selectAccountOfId(id,pwd);
            System.out.println(account);
            request.getSession().setAttribute("account",account);
        }
        else {
            account= (Account) request.getSession().getAttribute("account");
        }
            if (account.getIdentity().equals("学生")){
                setStudentData(request);
                //System.out.println(request.getAttribute("stucourseList"));
                request.getRequestDispatcher("./jspFiles/studentMain.jsp").forward(request,response);
            }
            if (account.getIdentity().equals("教师")){
                setTeacherData(request);
                //System.out.println(request.getAttribute("teacourseList"));
                request.getRequestDispatcher("./jspFiles/teacherMain.jsp").forward(request,response);
            }
            if (account.getIdentity().equals("管理员")){
                setMonitorData(request);
                request.getRequestDispatcher("./jspFiles/superMonitorMain.jsp").forward(request,response);
            }
        request.getRequestDispatcher("./index.jsp").forward(request,response);

    }
    protected void setStudentData( HttpServletRequest request){//加载学生端数据

        List<Course> stucourseList = new ArrayList<>();

        String id = account.getId();
        List<String> courseList = scUtil.getCourseList(id);
        for (Course c: allCourseslist) {
            c.setTeacher( accountUtil.selectAccountById(tcUtil.getTeacher(c.getId())));

            for (String t:courseList){
                if (t.equals(c.getId())){
                    stucourseList.add(c);
                    break;
                }
            }
        }
        request.getSession().setAttribute("courseList",allCourseslist);
        request.getSession().setAttribute("stucourseList",stucourseList);
    }
    protected void setTeacherData(HttpServletRequest request){//加载教师端数据
        List<String> courseList = tcUtil.getCourseList(account.getId());
        List<Course> teacourseList = new ArrayList<>();
        for (Course c: allCourseslist) {

            for (String t:courseList){
                if (t.equals(c.getId())){
                    c.setTeacher( accountUtil.selectAccountById(account.getId()));
                    teacourseList.add(c);
                    break;
                }
            }
        }
        //System.out.println(teacourseList);
        request.getSession().setAttribute("teacourseList",teacourseList);

    }
    protected void setMonitorData(HttpServletRequest request){//加载管理员端数据
        List<Account> teacherList = accountUtil.getAllTeachers();
        for (Course c: allCourseslist) {
            c.setTeacher( accountUtil.selectAccountById(tcUtil.getTeacher(c.getId())));
        }

        request.getSession().setAttribute("teacherList",teacherList);
        request.getSession().setAttribute("courseList",allCourseslist);
    }
    protected void initthis(){
        try {
            courseUtil = new CourseUtil();
            tcUtil =new TCUtil();
            scUtil = new SCUtil();
            accountUtil = new AccountUtil();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        allCourseslist=courseUtil.getAllCourses();
    }
}

