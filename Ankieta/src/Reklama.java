import lombok.Getter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@Getter
@ApplicationScoped
@ManagedBean(name = "reklama")
public class Reklama {
  private int licznik;
  private static final String[] reklamy = {
    "http://www.swiat-reklamy.pl/wp-content/uploads/2015/07/napis-reklama-swietlna-01-001.png",
    "https://pracownieorange.pl/media/cache/thumb850x374/uploads/inspirations/ce1d1bd75362b2d24cd8fe813ccf3d51ef4e5ae3.jpeg"
  };

  public String getReklamy() {
    if(Math.random()>0.5)
      return reklamy[0];
    else
      return reklamy[1];
  }
  public void licz() {
    licznik++;
  }
}
