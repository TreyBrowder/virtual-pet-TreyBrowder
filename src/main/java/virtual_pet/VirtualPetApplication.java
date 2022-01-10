package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {

        int petChoice = 0;
        String gameOptionChoice = " ";
        String petName = " ";
        Scanner input = new Scanner(System.in);
        VirtualPet myPet = new VirtualPet(50, 50, 50, 20);

        System.out.println("WELCOME TO VIRTUAL PET");

        //choose pet type
        petChoice = PickYourPet();
        if(petChoice == 1 ){
            System.out.println("Congrats!! You're a dog parent!!");
        } else if(petChoice == 2){
            System.out.println("Congrats!! You're a cat parent!!");
        }

        //name your pet
        petName = NameYourPet();

        //game menu
        System.out.println("Please select what you would like to do with " + petName + ": ");
        System.out.println("enter 1 to play with " + petName);
        System.out.println("enter 2 to feed " + petName);
        System.out.println("enter 3 to give " + petName + " water");
        System.out.println("enter 4 to take " + petName + " out");
        System.out.println("enter 5 to check the status of " + petName);
        System.out.println("enter 6 to quit and abandon " + petName + " ): ");
        gameOptionChoice = input.nextLine();

        while(!gameOptionChoice.equals("6")){
            if(gameOptionChoice.equals("1")){
                myPet.playTime();
                System.out.println(petName + " is happy to play with you!");
            }else if(gameOptionChoice.equals("2")){
                myPet.giveFood();
                if(myPet.getHunger() >= 50){
                    System.out.println("what type of food do you want to give " + petName + "?");
                    int petFood = chooseFoodType();

                     if(petFood == 1) {
                     System.out.println(petName + " enjoyed the food");
                     System.out.println("you might want to give your pet water next!");
                    }else if(petFood == 2) {
                        System.out.println(petName + " only ate half of the food..");
                        myPet.tick();
                    }
                }else{
                    myPet.refusedFood();
                    System.out.println("your pet refused to eat");
                    System.out.println("it seems to be bored, stop being lazy and play with it!");;
                }
            }else if(gameOptionChoice.equals("3")){
                myPet.giveWater();
                System.out.println("you quenched " + petName + "'s thirst!");
                System.out.println(petName + " might need to be taken out go check your pet's status");
            }else if(gameOptionChoice.equals("4")){
                myPet.bathroomBreak();
                System.out.println("Your pet relieved itself");
                System.out.println("Make sure you clean it up! Then wash your hands lol");
            }else if(gameOptionChoice.equals("5")){

                myPet.petStatus();
                System.out.println("Your pets status:");
                System.out.println("bored level: " + myPet.getBored());
                System.out.println("hunger level: " + myPet.getHunger());
                System.out.println("thirst level: " + myPet.getThirsty());
                System.out.println("bladder level: " + myPet.getBathroom());

            } else {
                System.out.println("sorry invalid choice...Try again");
            }

            //passage of time
            myPet.tick();

            //reprompt menu
            System.out.println("Please select what you would like to do with " + petName + ": ");
            System.out.println("enter 1 to play with " + petName);
            System.out.println("enter 2 to feed " + petName);
            System.out.println("enter 3 to give " + petName + " water");
            System.out.println("enter 4 to take " + petName + " out");
            System.out.println("enter 5 to check the status of " + petName);
            System.out.println("enter 6 to quit and abandon " + petName + " ): ");
            gameOptionChoice = input.nextLine();

        }
    }


    static String NameYourPet(){
        boolean flag = true;
        String theName = " ";
        Scanner input = new Scanner(System.in);

        while(flag) {
            System.out.println("What do you want to name your pet? ");
            theName = input.nextLine();
            if(theName == " "){
                System.out.println("Your pet still needs a name!");
            }else{
                flag = false;
            }
        }

        return theName;
    }

    //chose your pet type
    static int PickYourPet(){
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        int petTypeChoice = 0;

        while(flag) {
            System.out.println("Please enter what type of pet you want: ");
            System.out.println("enter 1 for a dog: ");
            System.out.println("enter 2 for a cat: ");
            petTypeChoice = input.nextInt();

            if(petTypeChoice == 1){
                flag = false;
            }else if(petTypeChoice == 2){
                flag = false;
            }else {
                System.out.println("that's not a valid choice...Try again");
            }
        }
        return petTypeChoice;
    }

    static int chooseFoodType(){
        Scanner input = new Scanner(System.in);
        int foodtype = 0;
        boolean flag = true;


        System.out.println("Please choose the type of food you want for your pet:");
        while (flag) {
            System.out.println("enter 1 for premium food");
            System.out.println("enter 2 for regular food");
            System.out.println("enter 3 for scraps");
            foodtype = input.nextInt();
            input.nextLine();

            if (foodtype == 1) {
                flag = false;
            } else if (foodtype == 2) {
                flag = false;
            } else if (foodtype == 3) {
                flag = false;
            } else {
                System.out.println("sorry invalid answer...Please try again.");
            }
        }
        return foodtype;
    }

}
