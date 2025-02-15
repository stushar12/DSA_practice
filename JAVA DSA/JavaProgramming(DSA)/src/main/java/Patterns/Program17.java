package Patterns;

//clear a bit at a particular position(i.e. make the bit at that index 0)
// eg. clear the 2nd bit (position=1) for n=5 => binary representation (0101)

// 0101
// 0001 shift 2 places left 0100
//0101 & ~(0100) => 0101 & 1011 => 0001



public class Program17 {
    public static void main(String[] args) {
        int givenNumber = 5;    // 0101
        int indexToCheck = 2;

        int bitMask = 1<<indexToCheck;  //0100

        System.out.println(givenNumber & ~(bitMask));  //  (0101 & ~(0100)) 1 which is 0001
    }
}
