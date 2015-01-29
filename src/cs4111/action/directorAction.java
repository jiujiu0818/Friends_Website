package cs4111.action;

import cs4111.dao.directorDao;
import cs4111.form.directorForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class directorAction extends DispatchAction {
    public ActionForward queryDirector(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){

    	directorForm dform=(directorForm)form;
        String sql_con = "";
        directorDao dao=new directorDao();
        try {
            List list = dao.queryDirector(dform,1, 10);
            request.setAttribute("currentPage",1);
            request.setAttribute("list", list);     
            return mapping.findForward("directorList");
        }
        catch (Exception ex) {
            return mapping.findForward("error");
        }
    }
    
}
