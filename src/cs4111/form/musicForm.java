package cs4111.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

public class musicForm extends ActionForm {
    private String music_name;    
    private String singer;
    private String music_link;           
    private String lyrics;      
    private String ep_id;  
    
    private boolean isused;               
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        isused=false;
        super.reset(mapping, request);
    }                 

    public String getMusic_name()
    {
    	return music_name;
    }
    
    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }
    
    public String getSinger()
    {
    	return singer;
    }
    
    public void setSinger(String singer)
    {
    	this.singer = singer;
    }
    
    public String getMusic_link()
    {
    	return music_link;
    }
    
    public void setMusic_link(String music_link) {
        this.music_link = music_link;
    }
    
    public String getLyrics()
    {
    	return lyrics;
    }
    
    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
    
    public String getEp_id()
    {
    	return ep_id;
    }
    
    public void setEp_id(String ep_id) {
        this.ep_id = ep_id;
    }
}
