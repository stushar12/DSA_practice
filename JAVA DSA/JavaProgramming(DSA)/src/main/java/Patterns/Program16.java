package Patterns;


//set a bit at a particular position(i.e. make the bit at that index 1)
// eg. set the 2nd bit (position =1) for n=5 => binary representation (0101)

// 0101
// 0001 shift 2 places left 0100
//0101 | 0100 => 0101

public class Program16 {
    public static void main(String[] args) {
        int givenNumber = 5;    // 0101
        int indexToCheck = 1;

        int bitMask = 1<<indexToCheck;  //0010

        System.out.println(bitMask | givenNumber);  //  (0010 | 0101) 7 which is 0111
    }
}
