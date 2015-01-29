package cs4111.action;

import cs4111.dao.musicDao;
import cs4111.form.musicForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class musicAction extends DispatchAction {
    public ActionForward queryMusic(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){

    	musicForm dform=(musicForm)form;
        String sql_con = "";
        musicDao dao=new musicDao();
        try {
            List list = dao.queryMusic(dform,1, 10);
            request.setAttribute("currentPage",1);
            request.setAttribute("list", list);     
            return mapping.findForward("musicList");
        }
        catch (Exception ex) {
            return mapping.findForward("error");
        }
    }
    
    public ActionForward queryMusicForRanks(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){

    	musicForm dform=(musicForm)form;
        String sql_con = "";
        musicDao dao=new musicDao();
        try {
            List list = dao.queryMusic(dform,1, 10);
            request.setAttribute("currentPage",1);
            request.setAttribute("listMusic", list);     
            return mapping.findForward("rankList");
        }
        catch (Exception ex) {
            return mapping.findForward("error");
        }
    }
    
}
