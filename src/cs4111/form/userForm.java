package cs4111.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

public class userForm extends ActionForm {
    private String username;    
    private String password;
    
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
    
    public String getPassword()
    {
    	return password;
    }
    
    public void setPassword(String password)
    {
    	this.password = password;
    }
    
}
