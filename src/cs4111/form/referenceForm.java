package cs4111.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

public class referenceForm extends ActionForm {
    private String quiz_no;    
    private String character_name;
    private String music_name;           
    private String ep_id;       
    
    private boolean isused;               
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        isused=false;
        super.reset(mapping, request);
    }                 

    public String getQuiz_no()
    {
    	return quiz_no;
    }
    
    public void setQuiz_no(String quiz_no) {
        this.quiz_no = quiz_no;
    }
    
    public String getCharacter_name()
    {
    	return character_name;
    }
    
    public void setCharacter_name(String character_name) {
        this.character_name = character_name;
    }
    
    
    public String getMusic_name()
    {
    	return music_name;
    }
    
    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }
    
    public String getEp_id()
    {
    	return ep_id;
    }
    
    public void setEp_id(String ep_id) {
        this.ep_id = ep_id;
    }
}
