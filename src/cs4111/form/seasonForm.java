package cs4111.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

public class seasonForm extends ActionForm {
    private String season_id;    
    private String season_abstract;
    private String aired_from;           
    private String aired_until;      
    private String character;  
    
    private boolean isused;               
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        isused=false;
        super.reset(mapping, request);
    }                 

    public String getSeason_id()
    {
    	return season_id;
    }
    
    public void setSeason_id(String season_id) {
        this.season_id = season_id;
    }
    
    public String getSeason_abstract()
    {
    	return season_abstract;
    }
    
    public void setSeason_abstract(String season_abstract)
    {
    	this.season_abstract = season_abstract;
    }
    
    public String getAired_from()
    {
    	return aired_from;
    }
    
    public void setAired_from(String aired_from) {
        this.aired_from = aired_from;
    }
    
    public String getAired_until()
    {
    	return aired_until;
    }
    
    public void setAired_until(String aired_until) {
        this.aired_until = aired_until;
    }
    
    public String getCharacter()
    {
    	return character;
    }
    
    public void setCharacter(String character) {
        this.character = character;
    }
}
