package factoryPattern;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Clinic {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("[1] Dog");
            System.out.println("[2] Cat");
            System.out.println("[3] Exit");
            System.out.print("\nChoose your pet number: ");
            Integer choice = null;

           
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice, please enter a number.");
                input.next(); 
                continue;
            }

            PetRecord petFile = new PetRecord();
            Pet pet;

            switch(choice){
                case 1:
                    pet = new Dog();
                    petFile.setPetId("D01");
                    petFile.setPetName("Bantay");
                    petFile.setPet(pet);
                    ((Dog) pet).setBreed("German Shepperd");
                    break;
                case 2:
                    pet = new Cat();
                    petFile.setPetId("C01");
                    petFile.setPetName("Muning");
                    petFile.setPet(pet);
                    ((Cat) pet).setNoOfLives(9);
                    break;  
                case 3:
                    System.out.println("Exiting the program.");
                    input.close();  
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
                    continue;  
            }

            System.out.println("Pet id is " + petFile.getPetId());
            System.out.println("Pet name is " + petFile.getPetName());
            System.out.println("Pet kind: " + petFile.getPet().getClass().getSimpleName());
            System.out.println("Communication sound: "+ petFile.getPet().makeSound());
            System.out.println("Play mode: " + petFile.getPet().play());
        }
    }
}
