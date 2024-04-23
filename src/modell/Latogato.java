package modell;

public class Latogato extends Ember {

    private String terulet;

    public Latogato(String nev, String terulet, Oltozet viselet) throws NevExp {
        super(nev, viselet);
        setTerulet(terulet);
        
    }

    public String getTerulet() {
        return terulet;
    }

    public void setTerulet(String terulet) {
        this.terulet = terulet;
    }
    
     @Override
    public String toString() {
        return getNev()+" (Latogato)";
    }
    

}
