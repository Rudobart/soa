package hibernate2;


import javax.persistence.*;
import java.sql.Date;
@Entity
public class Ksiazka2 {
    private int id;

    @Override
    public String toString() {
        String autor = this.autor.getImie() + this.autor.getNazwisko();
        return "Ksiazka{" +
                "id=" + id +
                ", tytul='" + tytul + '\'' +
                ", autor=" + autor +
                ", opis='" + opis + '\'' +
                ", rokWydania=" + rokWydania +
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

    private String tytul;

    @Basic
    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    private Autor autor;

    @ManyToOne
    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    private String opis;

    @Basic
    @Column( length = 100000 )
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    private int rokWydania;

    @Basic
    public int getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(int rokWydania) {
        this.rokWydania = rokWydania;
    }
}