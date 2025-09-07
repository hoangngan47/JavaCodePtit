import java.util.Scanner;

public class HinhChuNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //read data from keyboard
        int a = sc.nextInt(); // input int from keyboard
        int b = sc.nextInt(); // input int from keyboard
        
        if (a<=0 || b<=0){
            System.out.println(0);
        }
        else{
            int chuVi = 2*(a+b);
            int dienTich = (a*b);
            System.out.println(chuVi+" "+dienTich);
        }
        sc.close();
    }
}
