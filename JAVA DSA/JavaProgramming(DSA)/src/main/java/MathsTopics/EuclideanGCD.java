package MathsTopics;

public class EuclideanGCD {
    public static void main(String[] args) {
        int num1 = 20;
        int num2 = 40;

        while (num1 > 0 && num2 > 0) {
            if (num1 > num2)
                num1 = num1 % num2;
            else
                num2 = num2 % num1;
        }

        if (num1 == 0) {
            System.out.println("GCD is : " + num2);
        } else {
            System.out.println("GCD is : " + num1);
        }
    }
}
