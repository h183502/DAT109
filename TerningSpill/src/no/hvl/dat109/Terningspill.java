package no.hvl.dat109;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Terningspill {

    private int id;
    private List<Spiller>spillere;
    private Kopp kopp;

    public Terningspill(){
        this.id = 0;
        this.spillere = new ArrayList<>();
        this.kopp = new Kopp();

        Scanner sc = new Scanner(System.in);
        System.out.println("Antall spillere?");
        int antall = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < antall; i++){
            System.out.println("Navn på spiller nummer: " + (i + 1));
            leggTilSpiller(sc.nextLine());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void leggTilSpiller(String navn){
        spillere.add(new Spiller(navn));
    }

    public void spill(List<Spiller> spillere){

        for (int i = 0; i < spillere.size(); i++){
            spillere.get(i).spill(kopp);
            System.out.println(spillere.get(i));
            System.out.println();
        }

    }

    public void spill(){
        spill(spillere);
        System.out.println("Vinneren er: " + finnVinner().getNavn() + ". Winner Winner Chicken Dinner!!!!");
    }

    public Spiller finnVinner(){

        Spiller vinner = spillere.stream().max(Comparator.comparingInt(Spiller::getVerdi)).orElse(null);

        if (vinner != null){
            List<Spiller> vinnere = spillere.stream().filter(x -> x.getVerdi() == vinner.getVerdi()).collect(Collectors.toList());


            while (vinnere.size() > 1){
                spill(vinnere);
                Spiller nyVinner = spillere.stream().max(Comparator.comparingInt(Spiller::getVerdi)).orElse(null);
                vinnere = spillere.stream().filter(x -> x.getVerdi() == nyVinner.getVerdi()).collect(Collectors.toList());
            }
            return vinnere.get(0);
        }
        return null;

    }

}
