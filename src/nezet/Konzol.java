package nezet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modell.Dolgozo;
import modell.Ember;
import modell.Epulet;
import modell.Latogato;
import modell.NevExp;
import modell.NyugdijigComp;

public class Konzol implements Serializable {
    
    private Epulet epulet;
    private List<Dolgozo> dolgozok;
    private List<Latogato> latogatok;
    private Map<String, Integer> terulet;
    private List<Object> beolvasottObj = new ArrayList<>();
    
    public Konzol() throws NevExp, Exception {
        terulet = new HashMap<>();
        epulet = new Epulet();
        dolgozok = new ArrayList<>();
        latogatok = new ArrayList<>();
        szetvalogat();
        feladatok();
    }
    
    public void feladatok() throws Exception {
        epuletbenLevoEmberekKonzolon();
        epuletbenLevoEmberekFajlba();
        dolgozokNevSorban();
        dolgozokNyugdijig();
        latogatokTeruletSzerint();
        fajlBeolvas();
    }
    
    private void epuletbenLevoEmberekKonzolon() {
        System.out.println("Épületben lévő emberek:");
        kiir(getEpulet());
    }
    
    public List<Ember> getEpulet() {
        return epulet.getEmberek();
    }
    
    public void setEpulet(Ember emberek) {
        this.epulet.setEmberek(emberek);
    }
    
    public void removeEmberFromEpulet(int index) {
        this.epulet.removeEmberByIndex(index);
    }
    
    private void szetvalogat() {
        for (Ember e : epulet.getEmberek()) {
            if (e instanceof Dolgozo) {
                this.setDolgozok((Dolgozo) e);
            } else if (e instanceof Latogato) {
                this.setLatogatok((Latogato) e);
            }
        }
    }
    
    public List<Dolgozo> getDolgozok() {
        return dolgozok;
    }
    
    public void setDolgozok(Dolgozo dolgozok) {
        this.dolgozok.add(dolgozok);
    }
    
    public List<Latogato> getLatogatok() {
        return latogatok;
    }
    
    public void setLatogatok(Latogato latogatok) {
        this.latogatok.add(latogatok);
    }
    
    private <T> void kiir(List<T> text) {
        for (T t : text) {
            System.out.println(t);
        }
    }
    
    private void epuletbenLevoEmberekFajlba() throws Exception {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ember.txt"));
            oos.writeObject(epulet);
            oos.close();
        } catch (FileNotFoundException ex) {
            throw new Exception("Hiba a fájl kiiratása közben!");
        } catch (IOException ex) {
            throw new Exception("Hiba a fájl kiiratása közben!");
        }
        
    }
    
    private void dolgozokNevSorban() {
        Collections.sort(dolgozok);
    }
    
    private void dolgozokNyugdijig() {
        Collections.sort(dolgozok, new NyugdijigComp());
    }
    
    private void latogatokTeruletSzerint() {
        for (Latogato l : latogatok) {
            terulet.put(l.getTerulet(), terulet.getOrDefault(l.getTerulet(), 0) + 1);
        }
        
        for (Map.Entry<String, Integer> entry : terulet.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            
            System.out.println(key + " -> " + value + " db");
            
        }
    }
    
    private void fajlBeolvas() throws Exception {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ember.txt"));
            Object obj = ois.readObject();
            beolvasottObj.add(obj);
            System.out.println("Beolvasott objektum: " + obj);
            ois.close();
        } catch (FileNotFoundException ex) {
            throw new Exception("Hiba a fájl kiiratása közben!");
        } catch (IOException ex) {
            throw new Exception("Hiba a fájl kiiratása közben!");
        }
        
    }
    
    public List<Object> getBeolvasottObj() {
        return beolvasottObj;
    }
    
    public void setBeolvasottObj(Object Obj) {
        this.beolvasottObj.add(Obj);
    }
    
}
