package cs4111.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

public class directorForm extends ActionForm {
    private String director_name;    
    private String image;
    private String birthday;           
    private String brief_bio;      
    private String gender;  
    private String number_of_episodes;
    
    private boolean isused;               
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        isused=false;
        super.reset(mapping, request);
    }                 

    public String getDirector_name()
    {
    	return director_name;
    }
    
    public void setDirector_name(String director_name) {
        this.director_name = director_name;
    }
    
    public String getImage()
    {
    	return image;
    }
    
    public void setImage(String image)
    {
    	this.image = image;
    }
    
    public String getBirthday()
    {
    	return birthday;
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    public String getBrief_bio()
    {
    	return brief_bio;
    }
    
    public void setBrief_bio(String brief_bio) {
        this.brief_bio = brief_bio;
    }
    
    public String getGender()
    {
    	return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getNumber_of_episodes()
    {
    	return number_of_episodes;
    }
    
    public void setNumber_of_episodes(String number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }
}
