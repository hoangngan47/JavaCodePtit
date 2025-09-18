import java.util.Scanner;

public class TongPhanSo {
    static long gcd(long a, long b){
        while (b!= 0) { //tim ucln
            long ucln = a%b;
            a=b;
            b=ucln;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long a = scn.nextLong(), b = scn.nextLong(), c = scn.nextLong(), d = scn.nextLong();

        long ucln1 = gcd(a,b);  // rut gon ps
        a /= ucln1; b /= ucln1; 
        long ucln2 = gcd(c,d);
        c /= ucln2; d /= ucln2;

        long mauso =  (b*d) / gcd(b,d); //tim mau so chung nho nhat

        long tuso = a*(mauso/b) + c*(mauso/d); //quy dong

        long uocso  = gcd(tuso,mauso); //rut gon phan so
        tuso /= uocso; mauso /= uocso;

        System.out.printf("%d/%d", tuso,mauso);


    scn.close();
    }
}

