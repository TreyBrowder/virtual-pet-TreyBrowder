package virtual_pet;
import java.util.Scanner;

public class VirtualPet {
    private int bored = 0;
    private int hunger = 0;
    private int thirsty = 0;
    private int bathroom = 0;

    //constructor
    public VirtualPet(int bored, int hunger, int thirsty, int bathroom){
        this.bored = bored;
        this.hunger = hunger;
        this.thirsty = thirsty;
        this.bathroom = bathroom;
    }

    //getters
    public int getBored(){
        return bored;
    }

    public int getHunger(){
        return hunger;
    }

    public int getThirsty(){
        return thirsty;
    }

    public int getBathroom(){
        return bathroom;
    }

    //control pet status levels
    public void petStatus(){

        //keep bored level between 0-100
        if(bored > 100){
            bored = 100;
        }else if(bored < 0){
            bored = 0;
        }

        //keep hunger level between 0-100
        if(hunger > 100){
            hunger = 100;
        }else if(hunger < 0){
            hunger = 0;
        }

        //keep thirsty level between 0-100
        if(thirsty > 100){
            thirsty = 100;
        }else if(thirsty < 0){
            thirsty = 0;
        }

        //keep bathroom level between 0-100
        if(bathroom > 100){
            bathroom = 100;
        }else if(bathroom < 0){
            bathroom = 0;
        }

    }

    //give water
    public void giveWater(){
        thirsty -= 25;
        bathroom += 20;
    }

    //feed
    public void giveFood(){
        if(hunger > 50) {
            hunger -= 20;
            bathroom += 5;
            thirsty += 10;

        }else if(hunger < 50) {
            bored += 10;
        }
    }

    //play
    public void playTime(){
        bored -= 25;
        thirsty += 5;
    }

    //take pet to bathroom
    public void bathroomBreak(){
        bathroom -= 50;
    }
    public void refusedFood() {
        bored +=20;
    }

    //passage of time
    public void tick(){
        bored += 10;
        hunger += 5;
        bathroom += 5;
    }
}
