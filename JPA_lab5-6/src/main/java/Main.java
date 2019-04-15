import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAexample");
        EntityManager em = factory.createEntityManager();
        try {
            Ksiazka k1=new Ksiazka(1,"abababa","bbb","dsad",14.0,"pln",40,false);
            em.getTransaction().begin();
            em.merge(k1);
            em.getTransaction().commit();
            System.out.println("Zapisano w bazie: " + k1);
        }
        catch(Exception e) {
            System.err.println("Blad przy dodawaniu rekordu: " + e);
        }
    }
}
