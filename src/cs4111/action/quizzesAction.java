package cs4111.action;

import cs4111.dao.quizzesDao;
import cs4111.form.quizzesForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class quizzesAction extends DispatchAction {
    public ActionForward queryQuizzes(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){

    	quizzesForm dform=(quizzesForm)form;
        String sql_con = "";
        quizzesDao dao=new quizzesDao();
        try {
            List list = dao.queryQuizzes(dform,1, 10);
            request.setAttribute("currentPage","1");
            request.setAttribute("list", list);  
            request.setAttribute("flag",true);
            if(dform.getCorrect_answer()!=null&&dform.getCorrect_answer()!=""&&list.size()>0)
            {
            	request.setAttribute("currentPage","2");
            }
            if(dform.getCorrect_answer()!=null&&dform.getCorrect_answer()!=""&&list.size()==0)
            {
            	request.setAttribute("currentPage","3");
            }
            return mapping.findForward("quizzesList");
        }
        catch (Exception ex) {
            return mapping.findForward("error");
        }
    }
    
    public ActionForward answerQuizzes(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){

    	quizzesForm dform=(quizzesForm)form;
        String sql_con = "";
        quizzesDao dao=new quizzesDao();
        try {
            List list = dao.queryQuizzes(dform,1, 10);
            
            request.setAttribute("currentPage","1");
            request.setAttribute("list", null);  
            request.setAttribute("flag",true);
            if(dform.getCorrect_answer()!=null&&dform.getCorrect_answer()!=""&&list.size()>0)
            {
            	request.setAttribute("currentPage","2");
                request.setAttribute("quiz_no", dform.getQuiz_no()); 
            }
            if(dform.getCorrect_answer()!=null&&dform.getCorrect_answer()!=""&&list.size()==0)
            {
            	request.setAttribute("currentPage","3");
            	request.setAttribute("quiz_no", dform.getQuiz_no()); 
            }
            return mapping.findForward("referenceList");
        }
        catch (Exception ex) {
            return mapping.findForward("error");
        }
    }
    
}
