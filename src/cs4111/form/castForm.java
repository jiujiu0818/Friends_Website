package cs4111.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

public class castForm extends ActionForm {
    private String cast_name;    
    private String birthday;
    private String image;           
    private String gender;      
    private String brief_bio;  
    
    private boolean isused;               
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        isused=false;
        super.reset(mapping, request);
    }

    public String getCast_name()
    {
    	return cast_name;
    }
    
    public void setCast_name(String cast_name) {
        this.cast_name = cast_name;
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
    
    public String getGender()
    {
    	return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getBrief_bio()
    {
    	return brief_bio;
    }
    
    public void setBrief_bio(String brief_bio) {
        this.brief_bio = brief_bio;
    }
}
