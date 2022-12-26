package servlets;

import beans.Account;
import utils.AccountUtil;
import utils.CourseUtil;
import utils.SCUtil;
import utils.TCUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "TCChangeServlet", value = "/TCChange.do")
public class TCChangeServlet extends HttpServlet {
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
        if (update!=null){
            doUpdate(request, response);
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

    protected void doUpdate(HttpServletRequest request, HttpServletResponse response){
        tcUtil.updateCourse(request.getParameter("cid"),request.getParameter("tid"));
    }

}
