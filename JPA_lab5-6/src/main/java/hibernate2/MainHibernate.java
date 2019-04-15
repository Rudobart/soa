package hibernate2;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainHibernate {
    public static void initDatabase(Session session) {
        session.beginTransaction();

        Autor a1 = new Autor();
        a1.setImie("Henryk");
        a1.setNazwisko("Sienkiewicz");
        a1.setNarodowosc("PL");

        Autor a2 = new Autor();
        a2.setImie("J.R.R");
        a2.setNazwisko("Tolkien");
        a2.setNarodowosc("GB");

        Autor a3 = new Autor();
        a3.setImie("Andrzej");
        a3.setNazwisko("Sapkowski");
        a3.setNarodowosc("PL");

        Autor a4 = new Autor();
        a4.setImie("Stephen");
        a4.setNazwisko("King");
        a4.setNarodowosc("USA");

        Ksiazka2 k1 = new Ksiazka2();
        k1.setTytul("W pustyni i w puszczy");
        k1.setRokWydania(1911);
        k1.setOpis("Książka dla dzieci");
        k1.setAutor(a1);
        a1.addDzielo(k1);

        Ksiazka2 k2 = new Ksiazka2();
        k2.setTytul("Quo Vadis");
        k2.setRokWydania(1895);
        k2.setOpis(" Powieść historyczna");
        k2.setAutor(a1);
        a1.addDzielo(k2);

        Ksiazka2 k3 = new Ksiazka2();
        k3.setTytul("Krew elfów");
        k3.setRokWydania(1994);
        k3.setOpis("Któraś z kolei część wiedźmina");
        k3.setAutor(a3);
        a3.addDzielo(k3);

        Ksiazka2 k4 = new Ksiazka2();
        k4.setTytul("Wiedźmin");
        k4.setRokWydania(2004);
        k4.setOpis("Książka Fantasy");
        k4.setAutor(a3);
        a3.addDzielo(k4);

        Ksiazka2 k5 = new Ksiazka2();
        k5.setTytul("Pod kopułą");
        k5.setRokWydania(2009);
        k5.setOpis("Intryga");
        k5.setAutor(a4);
        a4.addDzielo(k5);

        Ksiazka2 k6 = new Ksiazka2();
        k6.setTytul("Władca Pierścieni:Drużyna Pierścienia");
        k6.setRokWydania(1996);
        k6.setOpis("Pierwsza część");
        k6.setAutor(a2);
        a2.addDzielo(k6);

        Ksiazka2 k7 = new Ksiazka2();
        k7.setTytul("Władca pierścienie: Dwie wieże");
        k7.setRokWydania(1867);
        k7.setOpis("Druga część");
        k7.setAutor(a2);
        a2.addDzielo(k7);

        Czytelnik c1 = new Czytelnik();
        c1.setImie("Daniel");
        c1.setNazwisko("Poznański");

        Czytelnik c2 = new Czytelnik();
        c2.setImie("Jan");
        c2.setNazwisko("Kowalski");

        Czytelnik c3 = new Czytelnik();
        c3.setImie("Krzysztof");
        c3.setNazwisko("Dziadkowiec");

        Czytelnik c4 = new Czytelnik();
        c4.setImie("Oskar");
        c4.setNazwisko("Pozdro");

        Wypozyczenia w1 = new Wypozyczenia();
        w1.setKsiazka(k6);
        w1.setWypozyczajacy(c1);
        w1.setDataWypozyczenia(new Date(96,5,16));
        w1.setDataZwrotu(new Date(96,5,25));

        Wypozyczenia w2 = new Wypozyczenia();
        w2.setKsiazka(k1);
        w2.setWypozyczajacy(c2);
        w2.setDataWypozyczenia(new Date(118,1,29));
        w2.setDataZwrotu(new Date(118,5,25));

        Wypozyczenia w3 = new Wypozyczenia();
        w3.setWypozyczajacy(c4);
        w3.setKsiazka(k7);
        w3.setDataWypozyczenia(new Date(111,9,1));
        w3.setDataZwrotu(new Date(117,5,19));

        Wypozyczenia w4 = new Wypozyczenia();
        w4.setWypozyczajacy(c2);
        w4.setKsiazka(k7);
        w4.setDataWypozyczenia(new Date(100,2,11));
        w4.setDataZwrotu(new Date(102,4,19));

        Wypozyczenia w5 = new Wypozyczenia();
        w5.setWypozyczajacy(c2);
        w5.setKsiazka(k4);
        w5.setDataWypozyczenia(new Date(98,2,18));
        w5.setDataZwrotu(new Date(102,4,19));

        Wypozyczenia w6 = new Wypozyczenia();
        w6.setWypozyczajacy(c4);
        w6.setKsiazka(k4);
        w6.setDataWypozyczenia(new Date(105,2,18));
        w6.setDataZwrotu(new Date(108,4,19));

        session.persist(a1);
        session.persist(a2);
        session.persist(a3);
        session.persist(a4);
        session.persist(k1);
        session.persist(k2);
        session.persist(k3);
        session.persist(k4);
        session.persist(k5);
        session.persist(k6);
        session.persist(k7);
        session.persist(c1);
        session.persist(c2);
        session.persist(c3);
        session.persist(c4);
        session.persist(w1);
        session.persist(w2);
        session.persist(w3);
        session.persist(w4);
        session.persist(w5);
        session.persist(w6);

        session.getTransaction().commit();
    }

    //wypozyczajacy ksiazki Henryka Sienkiewicza w określonym czasie
    public static void zad1(Session session) {
        Query query = session.createQuery("SELECT czyt FROM Wypozyczenia as wyp JOIN wyp.wypozyczajacy as czyt JOIN wyp.ksiazka as ks JOIN ks.autor as aut WHERE aut.imie = :imie AND aut.nazwisko = :nazwisko AND wyp.dataWypozyczenia > :data1 AND wyp.dataWypozyczenia < :data2");
        query.setParameter("imie", "Henryk");
        query.setParameter("nazwisko", "Sienkiewicz");
        query.setParameter("data1", new Date(118,1,1));
        query.setParameter("data2", new Date(118,5,1));
        List list = query.list();

        for (Object a: list){
            System.out.println(((Czytelnik) a));
        }
    }


    //Wypozyczajacy ksiazke "Wiedźmin"
    public static void zad2(Session session) {
        Query query = session.createQuery("SELECT czyt FROM Wypozyczenia as wyp JOIN wyp.wypozyczajacy as czyt JOIN wyp.ksiazka as ks WHERE ks.tytul = :tytul");
        query.setParameter("tytul", "Wiedźmin");
        List list = query.list();

        for (Object a: list){
            System.out.println(((Czytelnik) a));
        }
    }

    //Autorzy, których książki wypożyczał Daniel Poznański
    public static void zad3(Session session) {
        Query query = session.createQuery("SELECT aut FROM Wypozyczenia as wyp JOIN wyp.wypozyczajacy as czyt JOIN wyp.ksiazka as ks JOIN ks.autor as aut WHERE czyt.imie = :imie AND czyt.nazwisko = :nazwisko");
        query.setParameter("imie", "Daniel");
        query.setParameter("nazwisko", "Poznanski");
        List list = query.list();

        for (Object a: list){
            System.out.println(((Autor) a));
        }
    }

//Ilosc wypozyczonych ksiazek w zaleznosci od autora
    public static void zad4(Session session) {
        Query query = session.createQuery("SELECT aut.nazwisko, count(*) as num FROM Wypozyczenia as wyp JOIN wyp.wypozyczajacy as czyt JOIN wyp.ksiazka as ks JOIN ks.autor as aut GROUP BY aut ORDER BY num DESC");
        Iterator iter = query.iterate();

        while (iter.hasNext()){
            Object[] tuple = (Object[]) iter.next();
            System.out.println(tuple[0] + ":" + tuple[1]);
        }
    }

    public static void printKsiazki(Session session) {
        List<Ksiazka2> list = session.createQuery("FROM Ksiazka2").list();
        for (Ksiazka2 ksiazka : list){
            System.out.println(ksiazka);
        }
    }

    public static void printAutorzy(Session session) {
        List<Autor> list = session.createQuery("FROM Autor").list();
        for (Autor autor : list){
            System.out.println(autor);
        }
    }

    public static void printCzytelnicy(Session session) {
        List<Czytelnik> list = session.createQuery("FROM Czytelnik").list();
        for (Czytelnik czytelnik : list){
            System.out.println(czytelnik);
        }
    }

    public static void printWypozyczenia(Session session) {
        List<Wypozyczenia> list = session.createQuery("FROM Wypozyczenia").list();
        for (Wypozyczenia wypozyczenia : list){
            System.out.println(wypozyczenia);
        }
    }

    public static void addKsiazka(Session session, Scanner scanner) {
        session.beginTransaction();

        Ksiazka2 ksiazka = new Ksiazka2();
        System.out.println("Podaj tytuł: ");
        ksiazka.setTytul(scanner.nextLine());
        System.out.println("Podaj opis: ");
        ksiazka.setOpis(scanner.nextLine());
        System.out.println("Podaj rok wydania: ");
        ksiazka.setRokWydania(Integer.parseInt(scanner.nextLine()));
        System.out.println("Podaj id autora: ");
        Autor autor = (Autor) session.get(Autor.class, Integer.parseInt(scanner.nextLine()));
        ksiazka.setAutor(autor);
        autor.addDzielo(ksiazka);
        session.persist(ksiazka);
        session.getTransaction().commit();
    }

    public static void addAutor(Session session, Scanner scanner) {
        session.beginTransaction();

        Autor autor = new Autor();

        System.out.println("Podaj imie: ");
        autor.setImie(scanner.nextLine());
        System.out.println("Podaj naziwsko: ");
        autor.setNazwisko(scanner.nextLine());
        System.out.println("Podaj narodowosc: ");
        autor.setNarodowosc(scanner.nextLine());

        session.save(autor);
        session.getTransaction().commit();
    }

    public static void printPrompt(){
        System.out.println("Co chcesz zrobić ?");
        System.out.println("1. Wyświetl książki");
        System.out.println("2. Dodaj książkę");
        System.out.println("3. Wyswietl cztelników");
        System.out.println("4. Wyświetl autorów");
        System.out.println("5. Dodaj autora");
        System.out.println("6. Wyświetl wypożyczenia");
        System.out.println("7. Wypozyczajacy ksiazke Henryka Sienkiewicza w określonym czasie");
        System.out.println("8. Wypozyczajacy ksiazke \"Wiedźmin\"");
        System.out.println("9. Autorzy, których książki wypożyczał Daniel Poznański");
        System.out.println("10. Ile wypożyczeń ma poszczególny autor");
        System.out.println("11. Zakończ");
        System.out.println("Podaj numer komendy: ");
    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();


     //   initDatabase(session);

        Boolean goForward = true;
        while (goForward) {
            Scanner scanner = new Scanner(System.in);
            printPrompt();
            switch (Integer.parseInt(scanner.nextLine())){
                case 1:
                    printKsiazki(session);
                    break;
                case 2:
                    addKsiazka(session, scanner);
                    break;
                case 3:
                    printCzytelnicy(session);
                    break;
                case 4:
                    printAutorzy(session);
                    break;
                case 5:
                    addAutor(session,scanner);
                    break;
                case 6:
                    printWypozyczenia(session);
                    break;
                case 7:
                    zad1(session);
                    break;
                case 8:
                    zad2(session);
                    break;
                case 9:
                    zad3(session);
                    break;
                case 10:
                    zad4(session);
                    break;
                case 11:
                    goForward = false;
                    break;
                default:
                    System.out.println("Nieznana komenda");
            }
        }

        session.close();
    }
}