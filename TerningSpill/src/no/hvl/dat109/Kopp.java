package no.hvl.dat109;


import java.util.ArrayList;
import java.util.List;


public class Kopp {

    private int id;
    private int sum;
    private List<Terning>terninger;

    public Kopp(){
        this.id = 0;
        this.sum = 0;
        this.terninger = new ArrayList<>();

        for (int i = 0; i < 2; i++){
            terninger.add(new Terning());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void trill(){

        sum = 0;
        for (int i = 0; i < terninger.size(); i++){
            terninger.get(i).trill();
            sum += terninger.get(i).getVerdi();
        }
    }
}
