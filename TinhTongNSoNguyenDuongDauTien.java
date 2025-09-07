import java.util.Scanner;

public class TinhTongNSoNguyenDuongDauTien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i=0; i<t; i++){
            long n = sc.nextLong();
            if (n<=0){
                System.out.println(0);
            }
            else{
                long s = n * (n+1) / 2;
                System.out.println(s);
            }
        }   
        sc.close();
    }    
}
