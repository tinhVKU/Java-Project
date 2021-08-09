import java.util.Scanner;
public class tinhnlhdh {
	public static void dientich(double a,double b) {	
		System.out.println("Dien tich cua hinh chu nhat la: "+a*b);
		System.out.println("Chu vi hinh chu nhat la: "+ (a+b)*2);
	}
	public static void main(String[] args) {
		double a,b;
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap vao chieu dai hinh chu nhat: ");
		a=sc.nextDouble();
		System.out.print("Nhap vao chieu rong hinh chu nhat: ");
		b= sc.nextDouble();
		dientich(a,b);
	}
}
