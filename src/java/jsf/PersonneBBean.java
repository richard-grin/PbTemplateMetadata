package jsf;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@Named(value = "personneBBean")
@SessionScoped
public class PersonneBBean implements Serializable {

  public String deconnexion() {
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    return "/index?faces-redirect=true&amp";
  }
}
