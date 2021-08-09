import java.util.*;
public class mang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao so phan tu: ");
		n = scanner.nextInt();
		String[] ten;
		 ten= new String[n];
		
		
		for(int i =0;i<n;i++) {
			ten[i]=scanner.next();
			
		}
		for(int i =0;i<n;i++) {
			System.out.println(ten[i]);
			
		}
		
	}

}
