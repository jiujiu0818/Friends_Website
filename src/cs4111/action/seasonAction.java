package cs4111.action;

import cs4111.dao.seasonDao;
import cs4111.form.seasonForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class seasonAction extends DispatchAction {
    public ActionForward querySeason(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){

    	seasonForm dform=(seasonForm)form;
        String sql_con = "";
        seasonDao dao=new seasonDao();
        try {
            List list = dao.querySeason(dform,1, 10);
            request.setAttribute("currentPage",1);
            request.setAttribute("list", list);     
            return mapping.findForward("seasonList");
        }
        catch (Exception ex) {
            return mapping.findForward("error");
        }
    }
    
}
