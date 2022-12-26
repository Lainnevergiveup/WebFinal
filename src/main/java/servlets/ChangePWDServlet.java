package servlets;

import beans.Account;
import utils.AccountUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChangePWDServlet", value = "/ChangePWD.do")
public class ChangePWDServlet extends HttpServlet {
    Account account;
    String newpsw;
    String pswconfirm;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        account=(Account) request.getSession().getAttribute("account");
        newpsw = request.getParameter("newpwd");
        pswconfirm = (String) request.getParameter("confirmpwd");
        if (check(newpsw,pswconfirm))  {
            account.setPassword(newpsw);
            new AccountUtil().updateAccount(account);
            request.getRequestDispatcher("./index.jsp").forward(request,response);
        }
        else {
            request.getRequestDispatcher(request.getRequestURI()).forward(request,response);
        }
    }
    protected boolean check(String newp,String pswComfirm){
        return newp.equals(pswComfirm);
    }
}
