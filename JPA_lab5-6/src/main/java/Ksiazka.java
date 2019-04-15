import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name = "Ksiazka")
public class Ksiazka {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",nullable=false)
    public int id;
    @Column(name="tytul")
    public String tytul;
    @Column(name="autor")
    public String autor;
    @Column(name="typ")
    public String typ;
    @Column(name="cena")
    public Double cena;
    @Column(name="waluta")
    public String waluta;
    @Column(name="strony")
    public int strony;
    @Column(name="wybrana")
    public boolean wybrana;


    public Ksiazka(){
        super();
    }
    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    public String getTytul(){
        return tytul;
    }
    public String getAutor(){
        return autor;
    }
    public String getTyp(){
        return typ;
    }
    public Double getCena(){
        return cena;
    }
    public String getWaluta(){
        return waluta;
    }
    public int getStrony(){
        return strony;
    }

    public void setTytul(String tytul){
        this.tytul=tytul;
    }
    public void  setAutor(String autor){
        this.autor=autor;
    }
    public void setTyp(String typ){
        this.typ=typ;
    }
    public void setCena(Double cena){
        this.cena=cena;
    }
    public void setWaluta(String waluta){
        this.waluta=waluta;
    }
    public void setStrony(int strony){
        this.strony=strony;
    }
}

