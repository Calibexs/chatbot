import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        //CHAT BOT
        Scanner input = new Scanner(System.in);
        chatbot larry = new chatbot("larry", input);

        larry.runConvo();

        System.out.println("finished");
    }
}