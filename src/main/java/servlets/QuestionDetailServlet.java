package servlets;

import beans.Account;
import beans.Question;
import utils.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "QuestionDetailServlet", value = "/questionDetail.do")
public class QuestionDetailServlet extends HttpServlet {
    CourseUtil courseUtil = null;
    TCUtil tcUtil=null;
    SCUtil scUtil;
    AccountUtil accountUtil;
    QuestionUtil questionUtil;
    Account account;
    HttpSession httpSession;
    int qid;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            qid = Integer.parseInt(request.getParameter("qid"));
            initthis(request,response);
            Question question = questionUtil.selectByQid(qid);
            request.getSession().setAttribute("q",question);
            if (account.getIdentity().equals("教师")) request.getRequestDispatcher("./jspFiles/teacherAnswerQuestion.jsp").forward(request,response);
        if (account.getIdentity().equals("学生")) request.getRequestDispatcher("./jspFiles/questionDetail.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void initthis(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        try {
            courseUtil = new CourseUtil();
            tcUtil =new TCUtil();
            scUtil = new SCUtil();
            accountUtil = new AccountUtil();
            questionUtil = new QuestionUtil();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        httpSession = request.getSession();
        account = (Account) httpSession.getAttribute("account");
    }
}
