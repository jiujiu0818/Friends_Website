package cs4111.action;

import cs4111.dao.castDao;
import cs4111.form.castForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class castAction extends DispatchAction {
    public ActionForward queryCast(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){

    	castForm dform=(castForm)form;
        String sql_con = "";
        castDao dao=new castDao();
        try {
            List list = dao.queryCast(dform,1, 10);
            request.setAttribute("currentPage",1);
            request.setAttribute("list", list);     
            return mapping.findForward("castList");
        }
        catch (Exception ex) {
            return mapping.findForward("error");
        }
    }
    
  /*  public ActionForward doDelete(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){
    	castForm dform=(castForm)form;
        String flag="";
        try{
        	castDao dao=new castDao();
        	flag=dao.doDelete(dform);
            request.setAttribute("flag",flag);
            return mapping.findForward("queryCharacters");
        }catch (Exception ex){
            ex.printStackTrace();
            return mapping.findForward("error");
        }
    }*/
}
