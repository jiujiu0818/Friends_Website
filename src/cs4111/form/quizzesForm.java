package cs4111.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

public class quizzesForm extends ActionForm {
    private String quiz_no;    
    private String topic;
    private String question;           
    private String correct_answer;      
    private String answera;  
    private String answerb; 
    
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
    
    public String getTopic()
    {
    	return topic;
    }
    
    public void setTopic(String topic)
    {
    	this.topic = topic;
    }
    
    public String getQuestion()
    {
    	return question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }
    
    public String getCorrect_answer()
    {
    	return correct_answer;
    }
    
    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }
    
    public String getAnswera()
    {
    	return answera;
    }
    
    public void setAnswera(String answera) {
        this.answera = answera;
    }
    
    public String getAnswerb()
    {
    	return answerb;
    }
    
    public void setAnswerb(String answerb) {
        this.answerb = answerb;
    }
}
