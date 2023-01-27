
package waffle.pancakeshopsystem;

import java.util.Scanner;

public class  WafflePancakeShopSystem{

    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner (System.in);
        
        int waffle = 1, pancake = 2;                                                /*variables to choose sweet*/
        int waffle_per_piece = 10, pancake_per_piece = 5;                           /*variables to determine price*/
        int end_program = 3;                                                        /*to shut down the system*/
        int user_choice;                                                            /*for user selection of sweet*/
        int number_of_pieces;                                                       /*determine the pieces wanted*/
        int sauce_choice;                                                           /*sauces wanted*/
        int topping;                                                                /*toppings wanted*/
        String count_discount;                                                      /* add discount to total price*/
        String no_discount;                                                         /*no adding discount to total price*/
        String input_sauce = "Sweet";                                               /*to determine sauces added*/
        String input_topping = "Sweet";                                             /* to determine toppings added*/
        int order_info;                                                             /*show order information*/
        double waffle_discount = 0.1, pancake_discount = 0.1;                       /*amount of discount*/
        double waffle_tax = 0.15, pancake_tax = 0.15;                               /*amount of tax*/
        double waffle_price = 0, pancake_price = 0;                                 /*to calculate price only*/
        double add_tax_toWaffle = 0;                                                /*calculate price with tax & discount*/                   
        double add_tax_toPancake = 0;
        
        /*-----------------------------------------------------------*/ 
        
        showMenu();      /*call method*/
        
        System.out.println("\nEnter your choice: ");
            user_choice = keyboard.nextInt();
  
        if (user_choice == 3){                                                       /*to shut down the system*/
            System.out.println("Program ended, thank you :)");
            System.exit(0);
        }
        
        while(user_choice <= 0 || user_choice > 4){                                  /*to correct input mistakes*/
            
        showCheckChoice(); 
        System.out.println("\nEnter your choice: ");
        user_choice = keyboard.nextInt(); 
        
        if (user_choice == 3){
            System.out.println("Program ended, thank you :)");
            System.exit(0);
        }
    }
        
     /*-----------------------------------------------------------*/   
     
        System.out.println("\nEnter the number of pieces: ");
        number_of_pieces = keyboard.nextInt();
        
        waffle_per_piece = number_of_pieces * waffle_per_piece;                      /*calculate the price per piece*/
        pancake_per_piece = number_of_pieces * pancake_per_piece;
       
        /*-----------------------------------------------------------*/ 
        
        showSauceMenu();   /*method call*/
        System.out.println("\nEnter your choice: ");
        sauce_choice = keyboard.nextInt();
        
        if(sauce_choice < 0 || sauce_choice >5){                                     /*to correct input mistakes*/
        System.out.println("\nSorry! Wrong Input, Exiting the program");
            System.exit(0);
        }
        
        if (sauce_choice == 1){                                                      /*to assign the prices*/
            sauce_choice = 2;                                                        /*to assign type to show in screen later*/
            input_sauce = "Chocolate sauce";
        }
        else if (sauce_choice == 2){
            sauce_choice = 2;
            input_sauce = "Honey sauce"; 
        }
        else if(sauce_choice == 3){
            sauce_choice = 2;
            input_sauce = "Caramel sauce";
        }
        else if (sauce_choice == 4){
            sauce_choice = 2;
            input_sauce = "Pistatio sauce";
        }
        else if (sauce_choice == 5){
            sauce_choice = 0;
            input_sauce = "no sauce";
        }

        /*-----------------------------------------------------------*/ 
        
        showToppingMenu();
        System.out.println("\nEnter your choice: ");
        topping = keyboard.nextInt();
        
        if(topping < 0 || topping >4){                                               /*to correct input mistakes*/
        System.out.println("\nSorry! Wrong Input, Exiting the program");
            System.exit(0);
        }
        
        if (topping == 1){
            topping = 5;                                                             /*to assign the prices*/
            input_topping = "strawberry";                                            /*to assign type to show in screen later*/
        }
        else if (topping == 2){
            topping = 5;
            input_topping = "banana";
        }
        else if (topping == 3){
            topping = 3;
            input_topping = "nuts";
        }
        else if (topping == 4){
            topping = 0;
            input_topping = "no addings";
        }
        
        /*-----------------------------------------------------------*/ 
         
        waffle_price = showWafflePrice(waffle_per_piece, topping, sauce_choice);     /*method call*/         
        
        pancake_price = showPancakePrice(pancake_per_piece, topping, sauce_choice);

        /*-----------------------------------------------------------*/ 
      
        add_tax_toWaffle = waffle_price * waffle_tax + waffle_price ;                /*calculate price with tax*/
        
        add_tax_toPancake = pancake_price * pancake_tax + pancake_price;                       
        
         /*-----------------------------------------------------------*/ 
         
        waffle_discount = add_tax_toWaffle - waffle_discount * add_tax_toWaffle;     /*calculate price withh discount*/
        
        pancake_discount = add_tax_toPancake - pancake_discount * add_tax_toPancake;
        
        /*-----------------------------------------------------------*/ 
       
        System.out.println("-------------------------------------------------");
        System.out.println("              your order information");                  /*show oder informations*/
        System.out.println("-------------------------------------------------");
        
        if(user_choice == 1){
            System.out.println("Sweet type: Waffle      "
                             + "     Number of pieces: " + number_of_pieces);
        }
       
        else if(user_choice == 2){
            System.out.println("Sweet type: pancake      "
                             + "    Number of pieces: " + number_of_pieces);
        }
        
        System.out.println("Sauces: " + input_sauce      + "   "
                         + "   Toppings: " +  input_topping);
        
        if (user_choice == 1 && number_of_pieces > 5){
        count_discount  = "10%";
        System.out.print("Discount: " + count_discount);
        }
        
        else if(user_choice == 2 && number_of_pieces > 5){
        count_discount  = "10%";
        System.out.print("Discount: " + count_discount);
        }
        
        else{
            no_discount = "0";
        System.out.print("Discount: " + no_discount);
        }
        
        System.out.println("                Tax: 15&");
        
        
        if (user_choice == 1){
            System.out.println("Total price: " + add_tax_toWaffle);                  /*show total price before discount*/
        }
            
        else if(user_choice == 2){
            System.out.println("Total price: " + add_tax_toPancake);              
        }
        
        if (user_choice == 1  && number_of_pieces > 5){
            System.out.printf("Total price after"
                            + " discount: %.2f \n", waffle_discount);                /*show total price after discount*/
        }
        
        else if (user_choice == 2 && number_of_pieces > 5){
            System.out.printf("Total price after "
                            + "discount: %.2f \n", pancake_discount);
        }
        
    }
    
    /*-----------------------------------------------------------*/ 
    
    public static void showMenu(){
        
        System.out.println("\n-----------------------------------------------");     /*method to show main menu*/
        System.out.println("        Welcome to waffle & pancake shop");
        System.out.println("-----------------------------------------------");
        
        System.out.println("           Enter 1 for waffle."
                         + "\n           Enter 2 for pancake."
                         + "\n           Enter 3 to exit"); 
    }
    
    /*-----------------------------------------------------------*/ 
                             
    public static void showSauceMenu(){                                              /*method to show sauces menu*/
           
    System.out.println("\n---------------------------------------------------");
    System.out.println("               Choose the sauce");
    System.out.println("---------------------------------------------------");
    
    System.out.println("1- Chocolate sauce."
                     + "\n2- Honey sauce."
                     + "\n3- Caramel sauce."
                     + "\n4- Pistatio sauce."
                     + "\n5- no sauce.");
    }
    
    /*-----------------------------------------------------------*/ 
    
    public static void showToppingMenu(){                                            /*method to show toppings menu*/
        
        System.out.println("\n-----------------------------------------------");
        System.out.println("              Choose the toppings");
        System.out.println("-----------------------------------------------");
        
        System.out.println("1- strawberry."
                         + "\n2- banana."
                         + "\n3- nuts."
                         + "\n4- no addings.");
    }
    
    public static int showWafflePrice(int waffle_per_piece, int topping,             /*calculate original price only*/
                                      int sauce_choice){  
        
        return waffle_per_piece + topping + sauce_choice;       
    }

    public static int showPancakePrice(int pancake_per_piece, int topping,           /*calculate original price only*/
                                       int sauce_choice){ 
        
        return pancake_per_piece + topping + sauce_choice;
    }
    
    public static void showCheckChoice(){                                           /*input correction method*/
        
        Scanner keyboard = new Scanner (System.in);
        char choice;
        String input;

        System.out.println("\nSorry wrong selection."
                             + "\nDo you want to try again?(Y/ N)?");
            input = keyboard.nextLine();
            choice = input.charAt(0);
            
            if (choice == 'Y' || choice == 'y'){
            showMenu();
            }
            else{
                System.out.println("Program ended, thank you :)");
            System.exit(0);
            }
    }
}

