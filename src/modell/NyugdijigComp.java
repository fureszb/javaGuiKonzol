package modell;

import java.util.Comparator;

public class NyugdijigComp implements Comparator<Dolgozo> {

    @Override
    public int compare(Dolgozo o1, Dolgozo o2) {
        return Integer.compare(o1.getNyugdijigEv(), o2.getNyugdijigEv());
    }

}
