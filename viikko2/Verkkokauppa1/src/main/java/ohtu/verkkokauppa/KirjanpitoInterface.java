package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface KirjanpitoInterface {
    public ArrayList<String> getTapahtumat();
    public void lisaaTapahtuma(String tapahtuma);
}
