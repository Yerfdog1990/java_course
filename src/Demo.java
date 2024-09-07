import java.util.Scanner;

public class Demo {
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) {
        try (Scanner userInput = new Scanner(System.in)){
            System.out.print("Enter text: ");
            String text = userInput.nextLine();
            System.out.print("Enter shift key: ");
            int key = userInput.nextInt();
            System.out.println("Encrypted text: " +encrypt(text, key));
            System.out.println("Decrypted text: " +decrypt(encrypt(text, key), -key));
        }
    }
    private static String encrypt(String text, int shiftKey){
        if(!validateInput(text)){
            throw new IllegalArgumentException("Invalid input, try again!");
        }
        StringBuilder encryptText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentCharacter = text.toLowerCase().charAt(i);
            encryptText.append(shiftCharacter(currentCharacter, shiftKey));
        }
        return encryptText.toString();
    }
    //Method to perform decryption
    private static String decrypt(String text, int shiftKey){
        if(!validateInput(text)){
            throw new IllegalArgumentException("Invalid input. Please try again!");
        }
        StringBuilder decryptText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentCharacter = text.toLowerCase().charAt(i);
            decryptText.append(shiftCharacter(currentCharacter, shiftKey));
        }
        return decryptText.toString();
    }
    public static char shiftCharacter(char c, int key) {
        //Define the current position of the character
        int currentPos = alphabet.indexOf(c);
        if(currentPos != -1){
            int newPos = (currentPos + key) % alphabet.length();
            if(newPos < 0){
                newPos += alphabet.length();
            }
            return alphabet.charAt(newPos);
        }else{
            return c;
        }
    }
    public static boolean validateInput(String text){
        //Define list of valid punctuation
        String validPunctuation = "`. , ? ! : ; ' \" - — ( ) [ ] { } ... / \\ < > | _ * & @ # $ % ^ ~ ``";
        //Iterate over each character in the alphabet
        for(char c : text.toLowerCase().toCharArray()){
            if(alphabet.indexOf(c) == -1 && validPunctuation.indexOf(c) == -1 && !Character.isWhitespace(c) && !Character.isLetterOrDigit(c)){
                return false;
            }
        }
        return true;
    }
}
