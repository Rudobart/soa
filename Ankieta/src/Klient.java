import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Klient {

  private Czlowiek czlowiek = new Czlowiek();
  private Facet facet = new Facet();
  private Kobieta kobieta = new Kobieta();
  private List<String> preferencje = new ArrayList<>();
  private Wyniki wyniki = new Wyniki();

}
