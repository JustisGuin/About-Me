import java.util.Scanner;
import java.util.ArrayList;

public class guintextBasedAdventureRnd1{
    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);
        System.out.println("The goal of this game is to find the treasure. There will be many sea blocks in the way as you go I wish you all the luck traveler");   //Printing to the console 
        ui.nextLine();  //Going to the nexr line 
        System.out.println("The first task for you traveler is to find the correct path.");
        ui.nextLine();
        System.out.println("Which Path Do u want A,B,C".toUpperCase()); //Getting user input 
        String s=ui.nextLine(); //Setting up a string to pull ui input 

        if(s.toUpperCase().equals("A")){    //Making the variable upper case 
            System.out.println("You choose the wrong path traveler now you have to restart ");
            System.exit(0); //Exiting the program 
            ui.nextLine();
            
        }
        else if (s.toUpperCase().equals("B")){
            System.out.println("Very Good Choice Traveler but you have not choosen the right path ");
            ui.nextLine();
            System.exit(0); //exiting the program 
            

        }
        else if(s.toUpperCase().equals("C")){
            System.out.println("Great Job Traveler You have choosen the correct path. You may continue you finding for the treasure.");
            ui.nextLine();
            System.out.println("You are coming up on a island");
            ui.nextLine();
            
            
        }
        System.out.println("Would you Like to Stop at the Island(y/n)".toLowerCase());
        String a=ui.nextLine();
        if(a.equals("y")){  //using .equals instead of == becuase == is for int not string 
            System.out.println("You have docked on the Island\nYour Men are searching around and they find a abandoed ship on the other isde of the island they find helpful supplies for your Journey\nWith the supplies that you have collected you will be able to go farther! You have gained 50 gold");
            ui.nextLine();
        }
        else if(a.equals("n")){
            System.out.println("You might have missed some valueable items back there. But their is no stoping full steam ahead.");
            ui.nextLine();
            System.out.println("3 days has passed and your matties are starting to get angry you go down to the deck and reliaze that you have ran out of food.");
            ui.nextLine();
            System.out.println("You Relize that you should of stopped at the island back there to see if their was any food.");
            ui.nextLine();
            System.out.println("Your Ship matties have all died of starvation. You will have to restart.");
            ui.nextLine();

        }
        System.out.println("Your Second Road Block is coming up would you like to try to find a way around which could be dangerous or go towards it and see if you can get through it. Go through it(A) or Go Around it (B)");
        String c=ui.nextLine();
        if(c.toUpperCase().equals("A")){
            System.out.println("Ohh I see you have chosen to face the danger traveler very good choice");
            ui.nextLine();
            System.out.println("A Bird pops up and says you may not pass without finsihing this riddle.");
            ui.nextLine();
            System.out.println("The riddle you ask what it is? The riddle is ");
            c=("How do you make a pirate angry?");
            if(c.equals("Take away the p and he becomes irate") || c.equals("take away the p")|| c.equals("take p in pirate") || c.equals("remove the p")){
                System.out.println("Correct! You may pass traveler");
                ui.nextLine();
            }
            
            while(!c.equals("Take away the p and he becomes irate") && !c.equals("take away the p")&&(!c.equals("take p in pirate"))){
                System.out.println("How do you make a pirate angry?");
                ui.nextLine();
            }

        }
        else if (c.equals("B")){
            System.out.println("Ahh I see you have picked the risky route.You may risk your boat for this. You are coming around the road block. You look into your telescope and see debris blocking the path you try to turn around and something hits your boat.");
            ui.nextLine();
            System.out.println("You realize that you should of picked the other route and you are sinking in the middle of the ocean.");
            ui.nextLine();
    
        }
        String u=ui.nextLine();
        System.out.println("You are running low on supplies would you like to stop at a near bye island where you can buy more supplies with your Gold(y/y)");
        ui.nextLine();
        if (u.equals("y")){
            ArrayList<String> vendorList = new ArrayList<String>(); //using array list to 
            vendorList.add("Food(0)");      //adding the items to the list 
            vendorList.add("Water(1)");
            vendorList.add("Telescope(2)");
            vendorList.add("Boat Supplies(3)");
        }
        System.out.println("Would you like to buy food?(1), water(2), Telescope(3), Boat Supplies(4)"); //pulling the items from the list 
        if (u=="0"){
            System.out.println("45 Gold");  //pulling the 0 index from the list and so on 
            ui.nextLine();
        }
            
        else if  (u=="1"){
            System.out.println("30 Gold");
            ui.nextLine();
        }
            
        else if  (u=="2"){
            System.out.println("You have 25 Gold");
            ui.nextLine();
        }   
            
        else if  (u=="3"){
            System.out.println("You Have 20 Gold");
            ui.nextLine();
        }

        System.out.println("Would you like to leave the island(y/y)");      //getting user input 
        ui.nextLine();

        System.out.println("You have been in the water for the last 3 days you have not seen a single island in days. You Look out of your telescope to look for a island. You yell to your crew. There is Land!");
        ui.nextLine();
        System.out.println("Would you like to dock at this island to see if this island has the treasure you are looking for?");
        ui.nextLine();
        
        String j=ui.nextLine();
        System.out.println("Would you Like to search for the treausre at this island? (y/y)");
        
        if(j.equals("y")){          //if statement with strings 
        System.out.println("You have left the Vendor Island");
        ui.nextLine();
        System.out.println("You have been in the water for the last 3 days you have not seen a single island in days. You Look out of your telescope to look for a island. You yell to your crew. There is Land!");
        ui.nextLine();
        System.out.println("Would you like to dock at this island to see if this island has the treasure you are looking for?");
        ui.nextLine();

        }
        if(j.equals("y")){
            System.out.println("You come up to the island you see that this may be the same situation.");
            ui.nextLine();
            System.out.println("Travler you see that shiny thing sticking up in the ground.");
        }
        if (j.equals("n")){
            System.out.println("You are passing the island You see the shiny thing in the corner of your eye. You forget that you are driving a ship and crash into a big rock. Your ship start to go into the water and you drown and faint.");
            ui.nextLine();

        }
        String l=ui.nextLine(); //making a variable 
        System.out.println("Would you like to fight for the shiny thing in the ground(y/n)");
        if (l.equals("y")){
            System.out.println("You have picked y traveler. You begin to fight. You are scared that you may lose. ");
        }
            
        if (l.equals("n")){
            System.out.println("You stand down and decide to not fight for might be the treausre. The enemy see this and takes the oppertunity to suprise attack you. You lose the fight and lose all your men.");
            System.out.println("You start to see that you are lossing men very quickly.");
            System.out.println("Would you like to continue fighting(y/n)");
        }
           
        if (l.equals("y")){
           System.out.println("You have lost all of your men and you are on the brink of death. "); 
        }
            
        if (l.equals("n")){
            System.out.println("Traveler you have decided to back down a very smart choice.");
        }
         
    Integer k=ui.nextInt(); //using a int for ui input 
    System.out.println("Traveler You have 3 choices. Suprise attck them(1). Try to sneak one of your mates behind them and try to dig the shiny thing our of the ground(2). Or ask them nicely to hand the shiny thing over(3)");
    if (k==1){
        System.out.println("You choose to Suprise attack them. You get to make the first move. You take down a few men with this suprise attack ");
        
    }
    
        

        




           







    
    
    }
    
}
/*



if (user=="y"):
    print("You Come Up the island and there are people on the island. You are surpised that people live here. You come to greet them and you see that they have weapons.")
    user=input("Would you like to tell your men to get there weapons(w). Talk to them and try to calm the situation(t).")
    if (user=="w"):
            print("You take out your weapons and start to fight you see that you are lossing some men. But you are winning. You start to yell out we are winning men! You start to yell to the others we can stop this right now. You don't see anyone stoping.")
            print("You don't stop either. You see that you are out numbering them. You tell your men to stop and you tell the other men to stop. You tell them that you just want to look for treausre. They say that this is there land. ")
            print("Still you keep saying that you are going to search this land no matter what. You see that you have nore men then them. You yell to them we have more men. We wouldn't want to see you die. Would you like to join out squad.")
    inputlist=[
                    input("What is ur name"),
                    input("What is your ships name"),
                    input("Would you like to join my crew"),
                    input("How old are you Rrrr"),
                    input("What arrrre yourrrr good at matie")
                ]
print("Ok maite so your name is {}. So the ship that you where on is {}. {} you would like to join my crew. {} years old you will fit real nice in my ship. {} that is a good thing to me good at.".format(inputlist[0],inputlist[1],inputlist[2],inputlist[3],inputlist[4]))
print("You didn't find any treasure but you did find a new mate.")
print("You keep over watch over the new crew mate. Your not 100 percent comfortable with him. But your getting there.") 
print("You keep going to island to island continue to look for treausre.")
user=input("Travler would you like to go to this island?(y/n)")        
if (user=="y"):
    print("You come up to the island you see that this may be the same situation.")
    print("Travler you see that shiny thing sticking up in the ground.")
if (user=="n"):
    print("You are passing the island You see the shiny thing in the corner of your eye. You forget that you are driving a ship and crash into a big rock. Your ship start to go into the water and you drown and faint.")
user=input("Would you like to fight for the shiny thing in the ground(y/n)")
if (user=="y"):
    print("You have picked y traveler. You begin to fight. You are scared that you may lose. ")
    if (user=="n"):
      print("You stand down and decide to not fight for might be the treausre. The enemy see this and takes the oppertunity to suprise attack you. You lose the fight and lose all your men.")
    print("You start to see that you are lossing men very quickly.")
    print("Would you like to continue fighting(y/n)")
    if (user=="y"):
        print("You have lost all of your men and you are on the brink of death. ")
    if (user=="n"):
            print("Traveler you have decided to back down a very smart choice.")
user=input("Traveler You have 3 choices. Suprise attck them(1). Try to sneak one of your mates behind them and try to dig the shiny thing our of the ground(2). Or ask them nicely to hand the shiny thing over(3)")
if (user==1):
  print("You choose to Suprise attack them. You get to make the first move. You take down a few men with this suprise attack ")
*/