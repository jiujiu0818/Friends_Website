package cs4111.action;

import cs4111.dao.episodeDao;
import cs4111.form.episodeForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class episodeAction extends DispatchAction {
    public ActionForward queryEpisode(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){

    	episodeForm dform=(episodeForm)form;
        String sql_con = "";
        episodeDao dao=new episodeDao();
        try {
            List list = dao.queryEpisode(dform,1, 10);
            request.setAttribute("currentPage",1);
            request.setAttribute("list", list);     
            return mapping.findForward("episodeList");
        }
        catch (Exception ex) {
            return mapping.findForward("error");
        }
    }
    
}
