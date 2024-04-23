package modell;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Ember implements Serializable{

    private String nev;

    public enum Oltozet {
        elegáns, sportos, megfelelő, szakadt
    };
    Set<Oltozet> viselet;

    public Ember(String nev, Oltozet viselet) throws NevExp {
        setNev(nev);
        this.viselet = new HashSet<>();
        setViselet(viselet);
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) throws NevExp {

        if (nev.length() < 3) {
            throw new NevExp("A nev nem lehet rövidebb mint 3 betű");
        }

        char elsoBetu = nev.charAt(0);
        char nagyBetu = Character.toUpperCase(elsoBetu);

        if (elsoBetu != nagyBetu) {
            this.nev = nagyBetu + nev.substring(1);
        } else {
            this.nev = nev;
        }
    }

    @Override
    public String toString() {
        return "nev=" + nev + ", viselet=" + viselet;
    }

    public Set<Oltozet> getViselet() {
        return viselet;
    }

    public void setViselet(Oltozet viselet) {
        this.viselet.clear();
        this.viselet.add(viselet);
    }

}
