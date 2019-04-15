package hibernate2;

import javax.persistence.*;
        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.List;

@Entity
public class Autor {
    private int id;
    private String imie;
    private String nazwisko;
    private String narodowosc;
    private List<Ksiazka2> dziela = new LinkedList<Ksiazka2>();

    @Override
    public String toString() {
        StringBuilder dziela = new StringBuilder();
        for(Ksiazka2 k: this.dziela){
            dziela.append(" {" + k.getTytul() + "} ").append(" ");
        }
        return "hibernate2.Autor{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", narodowosc='" + narodowosc + '\'' +
                ", dziela=" + dziela +
                '}';
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }


    @Basic
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }


    @Basic
    public String getNarodowosc() {
        return narodowosc;
    }

    public void setNarodowosc(String narodowosc) {
        this.narodowosc = narodowosc;
    }


    @OneToMany(mappedBy = "autor")
    public List<Ksiazka2> getDziela() {
        return dziela;
    }

    public void setDziela(List<Ksiazka2> dziela) {
        this.dziela = dziela;
    }

    public void addDzielo(Ksiazka2 ksiazka) {
        if(dziela == null){
            dziela = new ArrayList<Ksiazka2>();
        }
        dziela.add(ksiazka);
    }
}

