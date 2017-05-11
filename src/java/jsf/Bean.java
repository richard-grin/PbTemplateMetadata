package jsf;

import ejb.GestionnaireQuestion;
import entities.Question;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;

/**
 * Bean pour tester !!
 *
 * @author richard
 */
@Named(value = "bean")
@SessionScoped
public class Bean implements Serializable {

  @EJB
  private GestionnaireQuestion gestionnaireQuestion;
  private Long id;
  private Question question;
  private List<Question> listeQuestions;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    System.out.println("SETID!!!");
    this.id = id;
  }

  public Bean() {
  }

  public String enregistrer() {
    gestionnaireQuestion.update(question);
    return "/index?faces-redirect=true";
  }

  public Question getQuestion() {
    System.out.println("getQuestion pour " + this);
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  public List<Question> getQuestions() {
    System.out.println("Bean pour getQuestions : " + this);
    if (listeQuestions == null) {
      listeQuestions = gestionnaireQuestion.getAll();
    }
    return listeQuestions;
  }

  public void monAction() {
    this.question = gestionnaireQuestion.getById(id);
    System.out.println("monAction : question = " + question);
  }

}
