package servlets;

import beans.Account;
import beans.Course;
import utils.AccountUtil;
import utils.CourseUtil;
import utils.SCUtil;
import utils.TCUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "TeacherChangeServlet", value = "/TeacherChange.do")
public class TeacherChangeServlet extends HttpServlet {
    CourseUtil courseUtil = null;
    TCUtil tcUtil=null;
    SCUtil scUtil;
    AccountUtil accountUtil;
    Account account;
    HttpSession httpSession;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initthis(request,response);
        String update = request.getParameter("update");
        String delete = request.getParameter("delete");
        String insert = request.getParameter("insert");
        System.out.println(update);
        System.out.println(delete);
        System.out.println(insert);
        if (update!=null){
            doUpdate(request, response);
        }
        if (delete!=null){
            doDelete(request, response);
        }
        if (insert!=null){
            doInsert(request, response);
        }
//        request.getRequestDispatcher("./jspFiles/superMonitorMain.jsp").forward(request,response);
        request.getRequestDispatcher("./Login.do").forward(request,response);
    }
    protected void initthis(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        try {
            courseUtil = new CourseUtil();
            tcUtil =new TCUtil();
            scUtil = new SCUtil();
            accountUtil = new AccountUtil();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        httpSession = request.getSession();
        account = (Account) httpSession.getAttribute("account");
    }
    protected void doDelete(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        accountUtil.deleteAccount(id);
        tcUtil.deleteByTeacher(id);
    }
    protected void doUpdate(HttpServletRequest request, HttpServletResponse response){
        Account t = new Account(request.getParameter("id"),request.getParameter("name"),
                request.getParameter("password"),"教师");
        accountUtil.updateAccount(account);
    }
    protected void doInsert(HttpServletRequest request, HttpServletResponse response){
        Account t = new Account(request.getParameter("id"),request.getParameter("name"),
                request.getParameter("password"),"教师");
        accountUtil.insertAccount(t);
    }
}
