package cs4111.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

public class rankForm extends ActionForm {
    private String username;    
    private String music_name;
    private String episode_name;
    private String character_name;
    private String points;
    
    private boolean isused;               
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        isused=false;
        super.reset(mapping, request);
    }                 

    public String getUsername()
    {
    	return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getMusic_name()
    {
    	return music_name;
    }
    
    public void setMusic_name(String music_name)
    {
    	this.music_name = music_name;
    }
   
    public String getEpisode_name()
    {
    	return episode_name;
    }
    
    public void setEpisode_name(String episode_name)
    {
    	this.episode_name = episode_name;
    }
    
    public String getCharacter_name()
    {
    	return character_name;
    }
    
    public void setCharacter_name(String character_name)
    {
    	this.character_name = character_name;
    }
    
    public String getPionts()
    {
    	return points;
    }
    
    public void setPionts(String points)
    {
    	this.points = points;
    }
}
