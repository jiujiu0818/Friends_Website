package cs4111.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

public class characterForm extends ActionForm {
    private String character_name;    
    private String birthday;
    private String image;           
    private String cast_name; 
    private String nicknames;      
    private String funniest_quotes;  
    
    private boolean isused;               
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        isused=false;
        super.reset(mapping, request);
    }


    public String getCharacter_name() {
        return character_name;
    }

    public void setCharacter_name(String cd) {
        this.character_name = cd;
    }
    
    public String getBirthday()
    {
    	return birthday;
    }
    
    public void setBirthday(String bd)
    {
    	this.birthday = bd;
    }
    
    public String getImage()
    {
    	return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    
    public String getCast_name()
    {
    	return cast_name;
    }
    
    public void setCast_name(String cast_name) {
        this.cast_name = cast_name;
    }
    
    public String getNicknames()
    {
    	return nicknames;
    }
    
    public void setNicknames(String nicknames) {
        this.nicknames = nicknames;
    }
    
    public String getFunniest_quotes()
    {
    	return funniest_quotes;
    }
    
    public void setFunniest_quotes(String funniest_quotes) {
        this.funniest_quotes = funniest_quotes;
    }
}
