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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CourseSelectServlet", value = "/Select.do")
public class CourseSelectServlet extends HttpServlet {
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
        String select = request.getParameter("select");
        String delete = request.getParameter("delete");
        if (select!=null)  {
            doSelect(request,response,select);
        }
        if (delete!=null)   {
            doDelete(request,response,delete);
        }
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
    protected void addChoice(HttpServletRequest request, HttpServletResponse response,String cid){
        System.out.println(cid);
        scUtil.chooseCourse(cid,account.getId());
    }
    protected void deleteChoice(HttpServletRequest request, HttpServletResponse response,String cid){
        System.out.println(cid);
        scUtil.unchooseCourse(cid,account.getId());
    }
    protected void doSelect(HttpServletRequest request,HttpServletResponse response,String s){
        String[] t = s.split("\\?");
        addChoice(request,response,t[1]);

    }
    protected void doDelete(HttpServletRequest request,HttpServletResponse response,String s){
        String[] t = s.split("\\?");
        deleteChoice(request,response,t[1]);
    }
}
