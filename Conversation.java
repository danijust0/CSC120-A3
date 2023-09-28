import java.util.Scanner; // Import Scanner Class

class Conversation {

  public static void main(String[] arguments) {
    // initialize attributes
    int num_rounds = -1; // Number of Rounds
    String user_response; // User's Conversation Input
    String[]split_list = {}; 
    String mirrored_response = ""; // Stores Computer's Mirrored Response
    String[] automatic_response = {"oh, yeah?","sick.","no way, really?!"}; 
    int not_match = 0; 
    int choice;
    int transcript_index = 0 ; // Keeps Track of Index

    Scanner user_rounds = new Scanner(System.in); // Construct Scanners
    Scanner user_input = new Scanner(System.in); 

    System.out.println("Enter Number of Rounds: ");  // Ask for No. Rounds 
    num_rounds = user_rounds.nextInt();
  
    String[] transcript = new String[(2*num_rounds)+2]; // Create Transcipt Array Size

    // Greet User and Add to Transcript
    transcript[transcript_index] = "Hi there! What's on your mind?"; 
    System.out.println("Hi there! What's on your mind?");
   
    for(int r = 0; r < num_rounds; r++){
      not_match = 0; // Restarts Not Key Words Counter
      
      user_response = user_input.nextLine().toLowerCase();  //Take and Store Input
      transcript_index++; // Increase Index
      transcript[transcript_index] = user_response;

      split_list = user_response.split(" ");  // Parse Through Response
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
        } else {
          not_match ++;
        }
      }
      // Figure Out if User Response and Key Word and Response Accordingly
      if (not_match == split_list.length) {    
        choice = (int) (Math.random()*2);
        transcript_index++;
        transcript[transcript_index] = automatic_response[choice];
        System.out.println(transcript_index);
        System.out.println(automatic_response[choice]);
      } else {
        for (int i=0;i < split_list.length; i++) {
          mirrored_response =mirrored_response + split_list[i] + " " ;
        } 
        transcript_index++; // Increase Index
        transcript[transcript_index] = mirrored_response + "?" ;
        System.out.println(mirrored_response + "?" );
        mirrored_response = "";
       } 
    } 
    // Say Bye and Print Transcript
    transcript_index++; // Increase Index
    transcript[transcript_index] = "See you!";
    System.out.println("See you!");

    System.out.println("TRANSCRIPT:");
    for (int thing =0; thing < transcript.length; thing++) {
      System.out.println(transcript[thing]);
    }

    // Close Scanners
    user_input.close();
    user_rounds.close();
   }
  }
