package Exceptions;

public class CreateException {
    //Method to check working age
    public static void eligibleToWork(int age) throws TooYoungError, TooOldError{
        if(age < 18){
            throw new TooYoungError("Sorry! You are below the working age bracket.");
        }if(age > 60){
            throw new TooOldError("Sorry! You are beyond the working age bracket.");
        }else{
            System.out.println("Bravo! Welcome to your new work station.");
        }
    }
    //Main method
    public static void main(String[] args){
        try{
            eligibleToWork(12);
        }catch (TooOldError | TooYoungError e){
            System.out.println("Error! You are not eligible to work.");
        }

    }
}
