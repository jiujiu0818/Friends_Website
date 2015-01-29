package cs4111.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

public class episodeForm extends ActionForm {
    private String ep_id;    
    private String season_id;
    private String ep_name;           
    private String synopsis;      
    private String script_link;  
    private String video_link;
    
    private boolean isused;               
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        isused=false;
        super.reset(mapping, request);
    }                 

    public String getEp_id()
    {
    	return ep_id;
    }
    
    public void setEp_id(String ep_id) {
        this.ep_id = ep_id;
    }
    
    public String getSeason_id()
    {
    	return season_id;
    }
    
    public void setSeason_id(String season_id) {
        this.season_id = season_id;
    }
    
    public String getEp_name()
    {
    	return ep_name;
    }
    
    public void setEp_name(String name) {
        this.ep_name = name;
    }
    
    public String getSynopsis()
    {
    	return synopsis;
    }
    
    public void setSynopsis(String synopsis)
    {
    	this.synopsis = synopsis;
    }
    
    public String getScript_link()
    {
    	return script_link;
    }
    
    public void setScript_link(String script_link) {
        this.script_link = script_link;
    }
    
    public String getVideo_link()
    {
    	return video_link;
    }
    
    public void setVideo_link(String video_link) {
        this.video_link = video_link;
    }
    
}
