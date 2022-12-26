package servlets;

import beans.Account;
import utils.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "DeleteQuestionServlet", value = "/deletequestion.do")
public class DeleteQuestionServlet extends HttpServlet {
    CourseUtil courseUtil = null;
    TCUtil tcUtil=null;
    SCUtil scUtil;
    AccountUtil accountUtil;
    QuestionUtil questionUtil;
    Account account;
    HttpSession httpSession;
    String cid;
    int qid;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        qid= Integer.parseInt(request.getParameter("qid"));
        System.out.println(qid);
        initthis(request,response);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("./course.do?cid=" + questionUtil.selectByQid(qid).getCid());
        deleteQuestion();
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
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
    protected boolean deleteQuestion(){
        if (account.getId().equals(questionUtil.selectByQid(qid).getSid())||account.getIdentity().equals("教师")){
            questionUtil.deleteQuestion(qid);
            return true;
        }
        return false;
    }

}
