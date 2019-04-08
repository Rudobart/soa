import lombok.Getter;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@Getter
@SessionScoped
@ManagedBean(name = "sklep")
public class sklep {
  private Klient klient = new Klient();
  private boolean dalej;
  public String[] plci={"M","F"};

  public void przejdzDalej() {
    dalej = true;
  }

}
