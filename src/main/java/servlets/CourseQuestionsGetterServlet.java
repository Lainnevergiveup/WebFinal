package servlets;

import beans.Account;
import beans.Question;
import utils.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "CourseQuestionsGetterServlet", value = "/course.do")
public class CourseQuestionsGetterServlet extends HttpServlet {
    CourseUtil courseUtil = null;
    TCUtil tcUtil=null;
    SCUtil scUtil;
    AccountUtil accountUtil;
    QuestionUtil questionUtil;
    Account account;
    HttpSession httpSession;
    String cid;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initthis(request,response);
        cid = request.getParameter("cid");
        request.getSession().setAttribute("cid",cid);
        getQuestionData(request);
        if (account.getIdentity().equals("学生")) request.getRequestDispatcher("./jspFiles/QuestionList.jsp").forward(request,response);
        if (account.getIdentity().equals("教师")) request.getRequestDispatcher("./jspFiles/tQuestionList.jsp").forward(request,response);
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
    protected void getQuestionData(HttpServletRequest request){
        List<Question> questionList = questionUtil.selectByCid(cid);
        System.out.println(questionList);
        request.setAttribute("questionList",questionList);
    }


}
