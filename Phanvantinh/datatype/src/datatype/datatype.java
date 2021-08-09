package datatype;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
public class datatype {
static Scanner scanner = new Scanner(System.in);
	public void nhietdo() {
		System.out.print("Input a degree in Fahrenheit: ");
		double f = scanner.nextDouble();
		double c = (5*(f-32))/9;
		System.out.println(f+" degree Fahrenheit is equal to "+c+" in Celsius");
		
	}
	public void doluong() {
		System.out.print("Input a value for inch: ");
		double inch = scanner.nextDouble();
		double m = inch* 0.0254;
		System.out.println(inch+" inch is "+m+" meters");
	}
	public int tong(int n) {
		if(n==0) return 0;
		int c = n%10 +tong(n/10);
		return c;
	}
	public void namthang() {
		System.out.print("Input the number of minutes: ");
		long phut = scanner.nextLong();
		int nam = (int) (phut/(60*24*365));
		int ngay = (int) ((phut%(60*24*365))/(24*60));
		System.out.println(phut+" minutes is approximately "+nam+" years and "+ngay+" days");
	}
	public void gio() {
		  Scanner input = new Scanner(System.in);
	        System.out.print("Input the time zone offset to GMT: ");
	        long timeZoneChange = input.nextInt();
	        long totalMilliseconds = System.currentTimeMillis();
	        long totalSeconds = totalMilliseconds / 1000;
	        long currentSecond = totalSeconds % 60;
	        long totalMinutes = totalSeconds / 60;
	        long currentMinute = totalMinutes % 60;
	        long totalHours = totalMinutes / 60;
	        long currentHour = ((totalHours + timeZoneChange) % 24);
	        System.out.println("Current time is " + currentHour + ":" + currentMinute + ":" + currentSecond);
	}
	public void BMI() {

        Scanner input = new Scanner(System.in);

        System.out.print("Input weight in pounds: ");
        double weight = input.nextDouble();

        System.out.print("Input height in inches: ");
        double inches = input.nextDouble();

        double BMI = weight * 0.45359237 / (inches * 0.0254 * inches * 0.0254);
        System.out.print("Body Mass Index is " + BMI+"\n");
    }
	public void daoso(int n) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		while(n!=0) {
			arrayList.add(n%10);
			n = n/10;
		}
		for(int i =arrayList.size()-1;i>=0;i--) {
			System.out.print(arrayList.get(i)+" ");
		}
		
		
	}
	public void speed() {
		float timeSeconds;
		float mps,kph, mph;

		System.out.print("Input distance in meters: ");
		float distance = scanner.nextFloat();

		System.out.print("Input hour: ");
		float hr = scanner.nextFloat();

		System.out.print("Input minutes: ");
		float min = scanner.nextFloat();

		System.out.print("Input seconds: ");
		float sec = scanner.nextFloat();

		timeSeconds = (hr*3600) + (min*60) + sec;
		mps = distance / timeSeconds;
		kph = ( distance/1000.0f ) / ( timeSeconds/3600.0f );
		mph = kph / 1.609f;

		System.out.println("Your speed in meters/second is "+mps);
		System.out.println("Your speed in km/h is "+kph);
		System.out.println("Your speed in miles/h is "+mph);
		
	}
	 public void power()
	    {
	        Scanner in = new Scanner(System.in);
	        System.out.print("Input the side length value: ");
	        double val = in.nextDouble();

	        System.out.printf("Square: %12.2f\n", val * val);
	        System.out.printf("Cube: %14.2f\n", val * val * val);
	        System.out.printf("Fourth power: %6.2f\n", Math.pow(val, 4));
	    }
	 public void exercise9()
	    {
	        Scanner in = new Scanner(System.in);
	        System.out.print("Input 1st integer: ");
	        int firstInt = in.nextInt();
	        System.out.print("Input 2nd integer: ");
	        int secondInt = in.nextInt();

	        System.out.printf("Sum of two integers: %d%n", firstInt + secondInt);
	        System.out.printf("Difference of two integers: %d%n", firstInt - secondInt);
	        System.out.printf("Product of two integers: %d%n", firstInt * secondInt);
	        System.out.printf("Average of two integers: %.2f%n", (double) (firstInt + secondInt) / 2);
	        System.out.printf("Distance of two integers: %d%n", Math.abs(firstInt - secondInt));
	        System.out.printf("Max integer: %d%n", Math.max(firstInt, secondInt));
	        System.out.printf("Min integer: %d%n", Math.min(firstInt, secondInt));
	    }
	 public void exercise11() {
	        Double dn1 = 0.000213456321d;
	        boolean d1f = Double.isFinite(dn1);
	        Double dn2 = dn1 / 0;
	        boolean d2f = Double.isFinite(dn2);
	        Double dn3 = Double.POSITIVE_INFINITY * 0;
	        boolean d3f = Double.isFinite(dn3);
	        System.out.println("\nFinite doubles\n--------------");
	        System.out.println("Is "+dn1 + " is finite? " + d1f);
	        System.out.println("Is "+dn2 + " (dn1/0) is finite? " + d2f);
	        System.out.println("Is "+dn3 + " is finite? " + d3f);
			Float fn1 = 5.3f;
	        boolean f1f = Float.isFinite(fn1);
	        Float fn2 = fn1 / 0;
	        boolean f2f = Float.isFinite(fn2);
	        Float fn3 = 0f / 0f;
	        boolean f3f = Float.isFinite(fn3);
	        System.out.println("\n\nFinite floats\n-------------");
	        System.out.println("Is "+fn1 + " is finite? " + f1f);
	        System.out.println("Is "+fn2 + " (fn1/0) is finite? " + f2f);
	        System.out.println("Is "+fn3 + " is finite? " + f3f);
	    }
	 public  void exercise12() {
	        int in1 = Integer.MIN_VALUE;
			int in2 = Integer.MAX_VALUE;
			System.out.println("Signed integers: " + in1 + ", " + in2);
			System.out.println("-----------------------------------------");
			int compare_Signed_num = Integer.compare(in1, in2);
			System.out.println("Result of comparing signed numbers: " + compare_Signed_num);
			int compare_Unsigned_num = Integer.compareUnsigned(in1, in2);
	        System.out.println("Result of comparing unsigned numbers: " + compare_Unsigned_num);
	    }
	 public void exercise13() {
	        int x = -2365;
	        int y = 125;
	        System.out.println();
	        System.out.println("Floor division using '/' operator: " + (x / y));
	        System.out.println("Floor division using floorDiv() method is: " + Math.floorDiv(x, y));
	        System.out.println();
	        System.out.println("Floor modulus using '%' operator: " + (x % y));
	        System.out.println("Floor modulus using floorMod() method is: " + Math.floorMod(x, y));
	    }
	 public void exercise14() {
	        BigInteger bigval = BigInteger.valueOf(Long.MAX_VALUE);
	        System.out.println("\nBigInteger value: "+bigval);
			long val_Long = bigval.longValue();
			System.out.println("\nConvert the said BigInteger to an long value: "+val_Long);
	        int val_Int = bigval.intValue();
			System.out.println("\nConvert the said BigInteger to an int value: "+val_Int);
	        short val_Short = bigval.shortValue();
	        System.out.println("\nConvert the said BigInteger to an short value: "+val_Short);
	        byte val_Byte = bigval.byteValue();
	        System.out.println("\nConvert the said BigInteger to byte: "+val_Byte);
	        long val_ExactLong = bigval.longValueExact();
			System.out.println("\nConvert the said BigInteger to exact long: "+val_ExactLong);
	    }
	 public void baitap15() {
	        float fn = 0.2f;
	        System.out.println("\nInitial floating number: " + fn);		
	        float next_down_fn = Math.nextDown(fn);
	        float next_up_fn = Math.nextUp(fn);
	        System.out.println("Float " + fn + " next down is " + next_down_fn);
	        System.out.println("Float " + fn + " next up is " + next_up_fn);
	        double dn = 0.2d;
	       System.out.println("\nInitial double number: " + dn);		
	        double next_down_dn = Math.nextDown(dn);
	        double next_up_dn = Math.nextUp(dn);
	        System.out.println("Double " + dn + " next down is " + next_down_dn);
	        System.out.println("Double " + dn + " next up is " + next_up_dn);
	    }
	public static void main(String[] args) {
		datatype tinh = new datatype();
		
		tinh.nhietdo();
		tinh.doluong();
		System.out.println("Input an integer between 0 and 1000: ");
		int n = scanner.nextInt();
		System.out.println("The sum of all digits in "+n+" is "+tinh.tong(n));
		tinh.namthang();
		tinh.gio();
		tinh.BMI();
		tinh.speed();
		tinh.power();
		tinh.exercise9();
		System.out.print("Input six non-negative digits: ");
		int m = scanner.nextInt();
		tinh.daoso(m);
		tinh.exercise11();
		tinh.exercise12();
		tinh.exercise13();
		tinh.exercise14();
		tinh.baitap15();
		
	}
}
