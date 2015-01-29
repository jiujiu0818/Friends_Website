package cs4111.action;

import cs4111.dao.userDao;
import cs4111.form.userForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class userAction extends DispatchAction {
    public ActionForward queryUser(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){

    	userForm dform=(userForm)form;
        String sql_con = "";
        userDao dao=new userDao();
        try {
            List list = dao.queryUser(dform,1, 10);
            request.setAttribute("currentPage",1);
            request.setAttribute("list", list); 
            if(list.size()>0)
            {
                request.setAttribute("list", null);
                request.setAttribute("username", dform.getUsername());
            	return mapping.findForward("rankList");
            }
            else
            {
            	request.setAttribute("fail","yes");
            	return mapping.findForward("login");
            }
        }
        catch (Exception ex) {
            return mapping.findForward("error");
        }
    }
    
}
