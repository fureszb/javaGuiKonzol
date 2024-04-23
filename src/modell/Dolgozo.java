package modell;

import java.util.Random;
import java.util.UUID;

public class Dolgozo extends Ember implements Comparable<Dolgozo> {

    private final UUID uuid = UUID.randomUUID();
    private int nyugdijigEv;
    private Random rnd;

    public Dolgozo(String nev, int nyugdijigEv, Oltozet viselet) throws NevExp {
        super(nev, viselet);
        setNyugdijigEv(nyugdijigEv);
    }

    public Dolgozo(String nev, Oltozet viselet) throws NevExp {
        super(nev, viselet);
        rnd = new Random();
        this.nyugdijigEv = rnd.nextInt(1, 11);
    }

    public int getNyugdijigEv() {
        return nyugdijigEv;
    }

    public void setNyugdijigEv(int nyugdijigEv) {
        this.nyugdijigEv = nyugdijigEv;
    }

    @Override
    public String toString() {
        return getNev()+" (Dolgozo)" +" - "+getViselet();
    }

    @Override
    public int compareTo(Dolgozo o) {
        return this.getNev().compareTo(o.getNev());
    }

}
