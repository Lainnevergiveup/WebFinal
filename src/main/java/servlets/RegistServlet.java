package servlets;

import beans.Account;
import utils.AccountUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistServlet", value = "/Regist.do")
public class RegistServlet extends HttpServlet {
    String identity;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        identity = request.getParameter("identity");
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        identity = request.getParameter("identity");
        regist(request,response);
    }
    protected void regist(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Account account = new Account();
        account.setId(request.getParameter("uid"));
        account.setName(request.getParameter("uname"));
        String t = request.getParameter("upwd");
        String psw = request.getParameter("confirmpwd");
        if (t.equals(psw)){
            account.setPassword(t);
        }
        account.setIdentity(identity);
        if (account.getPassword()!=null){
            try {
                new AccountUtil().insertAccount(account);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            request.getRequestDispatcher("./index.jsp").forward(request,response);
        }
    }
}
