package servlets;

import beans.Account;
import beans.Question;
import utils.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "QuestionEditServlet", value = "/questionEdit.do")
public class QuestionEditServlet extends HttpServlet {
    CourseUtil courseUtil = null;
    TCUtil tcUtil=null;
    SCUtil scUtil;
    AccountUtil accountUtil;
    QuestionUtil questionUtil;
    Account account;
    HttpSession httpSession;
    int qid;
    String method;
    String cid;
    Question q;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initthis(request,response);
        method = request.getParameter("method");
        q= (Question) request.getSession().getAttribute("q");
        if (q==null)    q=new Question();
        System.out.println("123"+q);
        cid = (String) request.getSession().getAttribute("cid");
        if (method.equals("ask")){
            this.q.setTitle(request.getParameter("title"));
            this.q.setQuestion(request.getParameter("question"));
            Account account = (Account)request.getSession().getAttribute("account");
            String sid = account.getId();
            this.q.setSid(sid);
            this.q.setCid(cid);
            this.q.setId(null);
            this.q.setState("未解答");
            questionUtil.insertQuestion(this.q);
        }
        if (method.equals("ans")){
            this.q.setQuestion(request.getParameter("answer"));
            this.q.setState("已解答");
           questionUtil.updateQuestion(this.q);

        }
        if (method.equals("change")){
            this.q.setTitle(request.getParameter("title"));
            this.q.setQuestion(request.getParameter("question"));
            questionUtil.updateQuestion(this.q);
        }
        String cid = request.getParameter("cid");
        request.getRequestDispatcher("./course.do").forward(request,response);
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


}
