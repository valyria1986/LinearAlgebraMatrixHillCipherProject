
import java.util.Scanner;

public class MatrixCrypto{

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        double[] encode = new double[4];
        double[] decode;
        char[] letters;
        int[] letValue;

        System.out.println("Would you like to (E)ncode or (D)ecode a message or (Q)uit? ");
        String input = scanner.nextLine();

        while(!"q".equalsIgnoreCase(input)){
            if("e".equalsIgnoreCase(input)){
                System.out.print("Enter the first row vector for your 2x2 Encode Matrix: ");
                encode[0] = scanner.nextDouble();
                encode[1] = scanner.nextDouble();

                System.out.print("Enter the second row vector for your 2x2 Encode Matrix: ");
                encode[2] = scanner.nextDouble();
                encode[3] = scanner.nextDouble();

                System.out.print("Enter a message (w/out punctuation): ");
                input = scanner.nextLine();
                letters = stringToCharArray(input);
                letValue = charToIntArray(letters);

                if(determinant(encode) == 0){
                    System.out.println("Make sure your matrix A is invertible! Det(A) cannot = 0.");
                    break;
                }

                for(int i = 0; i < letValue.length; i++)
                    System.out.print(letValue[i] + " ");
                break;
            }

        }
    }

    private static double determinant(double[] b){
        return ((b[0]*b[3]) - (b[1]*b[2]));
    }

    private static double[] inverse(double det, double[] b){
        double temp = b[0];
        b[0] = b[3];
        b[3] = temp;
        b[1] = -b[1];
        b[2] = -b[2];
        for(int i = 0; i < b.length; i++)
            b[i] = 1/det * b[i];
        return b;
    }

    private static char[] stringToCharArray(String a){
        char[] letters = new char[a.length()];
        for(int i = 0; i < a.length(); i++)
            letters[i] = a.charAt(i);
        return letters;
    }

    private static int[] charToIntArray(char[] a){
        int[] b = new int[a.length];
        for(int i = 0; i < a.length; i++){
            b[i] = charToInt(a[i]);
        }
        return b;
    }

    private static int charToInt(char a){
        int integer = (int) a - 96;
        if((int) a < 97)
            integer = (int) a - 64;
        else if((int) a == 32)
            integer = 0;
        return integer;
    }
}
