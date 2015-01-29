package cs4111.action;

import cs4111.dao.rankDao;
import cs4111.form.rankForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class rankAction extends DispatchAction {
    public ActionForward queryRank(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){

    	rankForm dform=(rankForm)form;
        String sql_con = "";
        rankDao dao=new rankDao();
        try {
            List list = dao.queryRank(dform,1, 10);
            request.setAttribute("currentPage",1);
            request.setAttribute("list", list);     
            return mapping.findForward("rankList");
        }
        catch (Exception ex) {
            return mapping.findForward("error");
        }
    }
    
    public ActionForward giveMusicRank(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){

    	rankForm dform=(rankForm)form;
        String sql_con = "";
        rankDao dao=new rankDao();
        try {
            List list = dao.giveMusicRank(dform,1, 10);
            request.setAttribute("currentPage",1);
            request.setAttribute("list", list);     
            return mapping.findForward("rankList");
        }
        catch (Exception ex) {
            return mapping.findForward("error");
        }
    }
    
}
