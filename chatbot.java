import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class chatbot {

    private Scanner input;
    private String name;
    private String[] traits;
    private String[] questions = {"Who was in paris",
            "How many presidents have we had including the current one in office? ", 
            "What does “www” stand for in a website browser?", 
            "How long is an Olympic swimming pool (in meters)?", 
            "Which animal can be seen on the Porsche logo?", 
            "What is the name of the largest ocean on earth?"};

    private String[] answers = {"Kanye",
            "46",
            "world wide web",
            "50 meters",
            "horse",
            "pacific ocean"};

    public String getinsight(int x) {
        return insight[x];
    }

    private String[] insight = {"Meeting a friend's parents can help you to understand why they do some of the things they do",
     "Creativity and divergent thinking are key to solving problems",
      "Studies show that if you get a full night’s sleep, you will be twice as likely to solve a problem than if you stay up all night.",
       "The next time you’re trying to solve a problem, check in with your emotions. You are more likely to experience insight when you’re in a positive mood.",
        "Observation, imitation, and repetition are at the heart of training.",
         "A picture is worth a thousand words", 
          "All that glitters is not gold"}; //add an array for some random responses

    public String getAnswer(int x) {
        return answers[x];
    }

    public String getQuestions(int x) {
        return questions[x];
    }

    public String getName() {
        return name;
    }

    public chatbot(String name, Scanner input) {
        this.input = input;
        this.name = name;
        this.traits = createPersonality();
    }



    public void runConvo() {
        boolean keepTalking = true;
        String response;

        //do while lets me run code at least once before checking condition
        do {
            System.out.println("input a chat! (question, name, insight, personality)");

            response = input.next(); // sets user input to response

            //following switch statement runs a block of code depending on response
            switch (response) {
                case "question", "q":
                    askQuestion(input);
                    break;
                case "name", "n":
                    System.out.println("Hi, my name is " + name + " the chatbot, nice to meet you! ");
                    break;
                case "insight", "i":
                    int rngIndex = (int) Math.round(Math.random() * (insight.length - 1)); // get random index to print out
                    System.out.println(insight[rngIndex]);
                    break;
                case "personality", "p":
                    System.out.println(Arrays.toString(traits));
                    break;
            }

            //Check if user wants to exit program
            System.out.println("Keep going? (yes/no)");
            response = input.next();
            if (response.equals("no")) {
                keepTalking = false;
            }
        } while (keepTalking);


    }

    private void askQuestion(Scanner input) {
        String response;
        int rngIndex = (int) Math.round(Math.random() * (questions.length - 1)); // get random index to print out
        System.out.println("Hey, " + questions[rngIndex] + "?");

        response = input.next();
        if (response.equals(answers[rngIndex])) {
            System.out.println("Correct!" );
        } else {
            System.out.println("It's, " + answers[rngIndex] + "!");
        }
    }

    //method to assign randomly selected traits from a list
    private String[] createPersonality() {
        //declare our final list to return
        ArrayList<String> personality = new ArrayList<String>();

        //declare pre made up traits
        String[] traits = {"cool", "funny", "kind", "annoying", "chill", "evil", "weird", "joyful", "happy", "calm", "nice"};

        // 50/50 chance it gets added to traitlist
        for (String trait:traits) {
            if((int) Math.round(Math.random()) == 1){
                personality.add(trait);
            }
        }

       
        return personality.toArray(new String[0]);
    }


}