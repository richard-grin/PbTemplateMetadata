package ejb;

import entities.Question;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@LocalBean
@Startup
public class Init {

  @EJB
  private GestionnaireQuestion gestionnaireQuestion;

    /**
    * Initialize if database empty
    */
    @PostConstruct
    public void InitData(){
        if(gestionnaireQuestion.nb()==0){
            Question question11 = new Question("Combien de couches au moins dans une application Java EE ?");
            gestionnaireQuestion.create(question11);
            
            Question question12 = new Question("Java EE ?");
            gestionnaireQuestion.create(question12);
            
            Question question13 = new Question("Une application Java EE ne peut pas fonctionner sans");
            gestionnaireQuestion.create(question13);
            
            Question question14 = new Question("Un container");
            gestionnaireQuestion.create(question14);
            
            Question question15 = new Question("Que ne peut pas faire un container EJB");
            gestionnaireQuestion.create(question15);
            
            Question question16 = new Question("S’il y a un conflit entre une configuration dans un fichier " +
                "web.xml et avec une annotation, qui l’emporte ?");
            gestionnaireQuestion.create(question16);
            
            Question question17 = new Question("EJB Lite est un");
            gestionnaireQuestion.create(question17);
            
            Question question18 = new Question("EJB Lite est un");
            gestionnaireQuestion.create(question18);
            
            Question question19 = new Question("JNDI sert à");
            gestionnaireQuestion.create(question19);
            
            Question question10 = new Question("Pour injecter des EJB dans une classe on est obligé " +
"d’utiliser JNDI");
            gestionnaireQuestion.create(question10);
            
        }
    }
}