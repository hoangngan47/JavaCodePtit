import java.util.Scanner;

public class GiaiPhuongTrinhBacNhat {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double a = scn.nextDouble();
        double b = scn.nextDouble();
    
        if (a==0){
            if (b==0){
                System.out.println("VSN");
            }
            else{
                System.out.println("VN");
            }
        }
        else{
            double x = -b / a;
            System.out.printf("%.2f", x);
        }
    
        scn.close();
    
    
    }
}


