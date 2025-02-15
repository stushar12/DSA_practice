package Patterns;

// Get the 3rd bit(position = 2) of a number n. (n=5)
public class Program15 {
    public static void main(String[] args) {

        int givenNumber = 5;    // 0101
        int indexToCheck = 2;

        int bitMask = 1<<indexToCheck;  //0100

        if((bitMask & givenNumber) != 0){
            System.out.println("Digit is 1");
        }
        else {
            System.out.println("Digit is 0");
        }
    }
}
