import vn.edu.tdtu.ArrayOutput;
import java.util.Scanner;
import vn.edu.tdtu.ArrayHandler;


public class Program{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length of array a: ");
        int length_a = scanner.nextInt();
        int[] a = new int[length_a];     
        System.out.println("Enter elements for array a ");
        a = enterArray(length_a);
        
        
        System.out.print("Enter length of array b: ");
        int length_b = scanner.nextInt();
        int[] b = new int[length_b];
        System.out.println("Enter elements for array b ");
        b = enterArray(length_b);

        System.out.print("Array a: ");
        ArrayOutput.print(a);
        System.out.print("Array b: ");
        ArrayOutput.print(b);

        int[] c = ArrayHandler.merge(a, b);
        System.out.print("After merge Array c: ");
        ArrayOutput.print(c);

        ArrayHandler.sort(c);
        System.out.print("After sort Array c: ");
        ArrayOutput.print(c);

        ArrayOutput.write(c, "output.txt");
        System.out.print("Save successfully");

        scanner.close();
    }
    public static int[] enterArray(int length){
        int arr[] = new int[length];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < length; i++) {
            int index = i+1;
            System.out.print("Enter element " + index + ": ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}