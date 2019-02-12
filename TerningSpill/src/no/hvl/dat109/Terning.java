package no.hvl.dat109;

import java.util.Random;

public class Terning {

    private int id;
    private int verdi;
    private Random rand;

    public Terning(){
        this.id = 0;
        this.verdi = 0;
        this.rand = new Random();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVerdi() {
        return verdi;
    }

    public void setVerdi(int verdi) {
        this.verdi = verdi;
    }

    public void trill(){
        verdi = rand.nextInt(6)+1;

    }
}
