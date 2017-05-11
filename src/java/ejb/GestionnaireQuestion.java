package ejb;

import entities.Question;
import java.util.List;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@DataSourceDefinition(
        className = "org.apache.derby.jdbc.ClientDataSource",
        name = "java:app/jdbc/mabase",
        serverName = "localhost",
        portNumber = 1527,
        user = "toto", // name and
        password = "toto", // password for the database
        databaseName = "testquestions"
)
@Stateless
@LocalBean
public class GestionnaireQuestion {

  @PersistenceContext(unitName = "TestPourITUAPU")
  private EntityManager em;

  public Question getById(Long id) {
    String query = "select q from Question q where q.id= :id";
    TypedQuery<Question> tquery = (TypedQuery<Question>) em.createQuery(query);
    tquery.setParameter("id", id);
    try {
      return tquery.getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }

  public List<Question> getAll() {
    String query = "select q from Question q";
    TypedQuery<Question> tquery = (TypedQuery<Question>) em.createQuery(query);
    return tquery.getResultList();
  }

  public long nb() {
    String s = "select count(q) from Question as q";
    TypedQuery<Long> query = em.createQuery(s, Long.class);
    return query.getSingleResult();
  }

  public void create(Question q) {
    em.persist(q);
  }

  public void update(Question q) {
    em.merge(q);
  }

  public void delete(Question q) {
    em.remove(em.merge(q));
  }
}
