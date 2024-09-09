public class Program{
    public static void main(String[] args) {

        if(args.length != 3){
            System.out.println("Invalid expression");
            return;
        }

        double first = 0,second = 0;

        try{
            first = Double.parseDouble(args[0]);        
        }catch (Exception e){
            System.out.println("The first argument is not valid");
            return;
        }

        try{
            second = Double.parseDouble(args[2]);       
        }catch (Exception e){
            System.out.println("The second argument is not valid");
            return;
        }
        
        switch (args[1]){
            case "+":
                System.out.printf("%.2f + %.2f = %.2f", first, second, first + second);
                break;
            case "-":
                System.out.printf("%.2f - %.2f = %.2f", first, second, first - second);
                break;
            case "x":
                System.out.printf("%.2f * %.2f = %.2f", first, second, first * second);
                break;
            case "/":
                if (second == 0){
                    System.out.printf("The second number is zero");
                    return;
                }
                System.out.printf("%.2f / %.2f = %.2f", first, second, first / second);
                break;
            case "^":
                System.out.printf("%.2f ^ %.2f = %.2f", first, second, tinhLuyThua(first, second));
                break;
            default:
                System.out.println("Unsupported operator");
        }
        return;
    }

    public static double tinhLuyThua(double first, double second) {
        double ketQua = 1;
         
        for (int i = 0; i < second; i++) {
            ketQua *= first;
        }
        return ketQua;
    }
}