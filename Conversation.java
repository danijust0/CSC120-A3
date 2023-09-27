import java.util.Random;
import java.util.Scanner;
import java.util.random.*;

class Conversation {

  public static void main(String[] arguments) {
    int num_rounds = -1;
    String user_response;
    String[]split_list = {};
    String mirrored_response = "";
    String[] automatic_response = {};
    String[] transcript = {};
    int choice;

    Scanner user_rounds = new Scanner(System.in); // You can make these one 
    Scanner user_input = new Scanner(System.in); 
    Random random = new Random();

    System.out.println("Enter Number of Rounds: "); 
    num_rounds = user_rounds.nextInt(); 
    System.out.println("Hi there! What's on your mind?");
   
    for(int r = 0; r < num_rounds; r++){
      user_response = user_input.nextLine().toLowerCase();
      split_list = user_response.split(" ");
    
      for(int word=0; word < split_list.length; word++) {
        if (split_list[word].equals("i")){
          split_list[word] = split_list[word].replace("i","you");
        } else if (split_list[word].equals("me")){
          split_list[word] = split_list[word].replace("me","you");
        } else if (split_list[word].equals("am")){
          split_list[word] = split_list[word].replace("am","are");
        } else if (split_list[word].equals("you")){
          split_list[word] = split_list[word].replace("you","i");
        } else if (split_list[word].equals("my")){
          split_list[word] = split_list[word].replace("my","your");
        } else if (split_list[word].equals("your")){
          split_list[word] = split_list[word].replace("your","my");
        }
      }
      for (int i=0;i < split_list.length; i++) {
        mirrored_response = mirrored_response + " " + split_list[i];
      }
      System.out.println(mirrored_response + "?" );
      mirrored_response = "";
      }
    System.out.println("See you!");

   }
  }
