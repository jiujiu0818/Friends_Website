package cs4111.action;

import cs4111.dao.characterDao;
import cs4111.form.characterForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class characterAction extends DispatchAction {
    public ActionForward queryCharacters(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){

    	characterForm dform=(characterForm)form;
        String sql_con = "";
        characterDao dao=new characterDao();
        try {
            List list = dao.queryCharacters(dform,1, 10);
            request.setAttribute("currentPage",1);
            request.setAttribute("list", list);     
            return mapping.findForward("characterList");
        }
        catch (Exception ex) {
            return mapping.findForward("error");
        }
    }
    
    public ActionForward doDelete(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){
    	characterForm dform=(characterForm)form;
        String flag="";
        try{
        	characterDao dao=new characterDao();
        	flag=dao.doDelete(dform);
            request.setAttribute("flag",flag);
            return mapping.findForward("queryCharacters");
        }catch (Exception ex){
            ex.printStackTrace();
            return mapping.findForward("error");
        }
    }
    


}
