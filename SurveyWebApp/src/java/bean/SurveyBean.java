/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import com.sun.xml.wss.util.DateUtils;
import ejb.SurveyEJB;
import entity.Survey;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Josh
 */
@Named(value = "surveyBean")
@SessionScoped
public class SurveyBean implements Serializable {

    @EJB
    private SurveyEJB surveyEJB;
    private Survey survey = new Survey();
    private String result;
    /**
     * Creates a new instance of SurveyBean
     */
    public SurveyBean() {
    }

    public SurveyEJB getSurveyEJB() {
        return surveyEJB;
    }

    public void setSurveyEJB(SurveyEJB surveyEJB) {
        this.surveyEJB = surveyEJB;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    public String addSurvey()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        surveyEJB.persist(survey);
        result = "Survey was sucessfully completed for the date of: " + sdf.format(survey.getDate());
        return "complete";
    }
    public String getComplete()
    {
        return "complete";
                }
    public String outputResult()
    {
        return result;
    }
    
    public void validateDate(FacesContext context, UIComponent comp, Object value) throws ValidatorException
    {
        //input
        Date theDate = (Date) value;
        //UIInput enteredDate = (UIInput) comp.getAttributes().get("date");
       // Date entDate = (Date) enteredDate.getValue();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        Calendar d = Calendar.getInstance();
        d.setTime(new Date());
        c.setTime(new Date());
        c.add(Calendar.DATE, -7);
        Date sdpDate = c.getTime();
        Date cDate = d.getTime();
        
       if(theDate.after(sdpDate) && theDate.before(cDate) || theDate.compareTo(cDate) == 0 )
       {
            
       }else
       {
           
           FacesMessage message = new FacesMessage("Invalid Date, date must be within 7 days of visiting");
           throw new ValidatorException(message);
       }
        
        
    }
}
