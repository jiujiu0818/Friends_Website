package cs4111.action;

import cs4111.dao.referenceDao;
import cs4111.form.referenceForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class referenceAction extends DispatchAction {
    public ActionForward queryReference(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){

    	referenceForm dform=(referenceForm)form;
        String sql_con = "";
        referenceDao dao=new referenceDao();
        try {
            List list = dao.queryReference(dform,1, 10);
            request.setAttribute("currentPage","1");
            request.setAttribute("list", list);     
            return mapping.findForward("referenceList");
        }
        catch (Exception ex) {
            return mapping.findForward("error");
        }
    }
    
}
