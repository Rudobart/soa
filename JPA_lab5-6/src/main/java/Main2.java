import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAexample");
        EntityManager em = factory.createEntityManager();
        try {
            Query q = em.createQuery("FROM Ksiazka", Ksiazka.class);
            List<Ksiazka> ksiazki = q.getResultList();
            System.out.println(ksiazki);
        }
        catch(Exception e) {
            System.err.println("Blad przy pobueraniu rekord—w: " + e);
        }
    }
}
