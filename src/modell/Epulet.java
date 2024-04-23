package modell;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Epulet implements Serializable {

    @Override
    public String toString() {
        return "Epulet{" + "Epulet=" + Epulet + '}';
    }

    private List<Ember> Epulet;

    public Epulet() throws NevExp {
        Epulet = new ArrayList<>();
        this.setEmberek(new Latogato("bence", "Kék", Ember.Oltozet.megfelelő));
        this.setEmberek(new Latogato("sanyi", "Kék", Ember.Oltozet.megfelelő));
        this.setEmberek(new Latogato("Károly", "Sárga", Ember.Oltozet.megfelelő));
        this.setEmberek(new Dolgozo("Kati", Ember.Oltozet.megfelelő));
        this.setEmberek(new Dolgozo("Béla", Ember.Oltozet.megfelelő));
    }

    public List<Ember> getEmberek() {
        return Epulet;
    }

    public void setEmberek(Ember emberek) {
        this.Epulet.add(emberek);
    }
    
     public void removeEmberByIndex(int index) {
        this.Epulet.remove(index);
    }

}
