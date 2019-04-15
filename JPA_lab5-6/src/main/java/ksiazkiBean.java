import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.*;

@ManagedBean(name="ksiazkiBean")
@SessionScoped
@Getter
@Setter
public class ksiazkiBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Ksiazka> listaKsiazek;
    private int noweId;
    private String nowyTytul;
    private String nowyAutor;
    private String nowyTyp;
    private Double nowaCena;
    private String nowaWaluta;
    private int noweStrony;
    private int zmienioneID;
    private String zmienionyTytul=null;
    private String zmienionyAutor=null;
    private String zmienionyTyp=null;
    private Double zmienionaCena;
    private String zmienionaWaluta=null;
    private int zmienioneStrony;

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAexample");
    EntityManager em = factory.createEntityManager();

    public ksiazkiBean() {
        wczytajZBazy();
    }

    public void inicjujBaze() {
        em.getTransaction().begin();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/bartlomiej/IdeaProjects/SOA_lab3_JSF1/src/ksiazki.txt"));
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(";");
                Ksiazka ksiazka = new Ksiazka();
                ksiazka.id = Integer.parseInt(cols[0]);
                ksiazka.tytul = cols[1];
                ksiazka.autor = cols[2];
                ksiazka.typ = cols[3];
                ksiazka.cena = Double.parseDouble(cols[4]);
                ksiazka.waluta = cols[5];
                ksiazka.strony = Integer.parseInt(cols[6]);
                ksiazka.wybrana = false;
                em.persist(ksiazka);
                System.out.println("Zapisano w bazie: " + ksiazka);
            }
        } catch (Exception e) {
            System.err.println("blad" + e);
        }
        em.getTransaction().commit();
    }

    public void wczytajZBazy() {
        List<Ksiazka> ksiazki = null;
        try {
            Query q = em.createQuery("FROM Ksiazka", Ksiazka.class);
            listaKsiazek = q.getResultList();

        } catch (Exception e) {
            System.err.println("Blad przy pobueraniu rekord—w: " + e);
        }
    }

    public void usunKsiazke(int id) {
        Ksiazka k = em.find(Ksiazka.class, id);
        em.getTransaction().begin();
        em.remove(k);
        em.getTransaction().commit();
        wczytajZBazy();
    }

    public void dodajDoBazy() {
        Ksiazka k = new Ksiazka(noweId, nowyTytul, nowyAutor, nowyTyp, nowaCena, nowaWaluta, noweStrony, false);
        em.getTransaction().begin();
        em.merge(k);
        em.getTransaction().commit();
        wczytajZBazy();
    }

    public void zmienKsiazke(int id) {
        Ksiazka k = em.find(Ksiazka.class, id);
        em.getTransaction().begin();
        if(zmienionyTytul!=null)
            k.setTytul(zmienionyTytul);
        if(zmienioneID!=0)
           k.setId(zmienioneID);
        if(zmienionyAutor!=null)
           k.setAutor(zmienionyAutor);
        if(zmienionaCena!=null)
            k.setCena(zmienionaCena);
        if(zmienionyTyp!=null)
           k.setTyp(zmienionyTyp);
        if(zmienionaWaluta!=null)
           k.setWaluta(zmienionaWaluta);
        if(zmienioneStrony!=0)
           k.setStrony(zmienioneStrony);
        em.getTransaction().commit();
        wczytajZBazy();
    }



}
