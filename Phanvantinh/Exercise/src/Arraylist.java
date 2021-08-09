import java.util.*;
  public class Arraylist {
  public static void main(String[] args) {
  // Creae a list and add some colors to the list
  List<String> list_Strings = new ArrayList<String>();
  list_Strings.add("Do");
  list_Strings.add("Cam");
  list_Strings.add("Vang");
  list_Strings.add("Tim");
  list_Strings.add("Xanh");
  // Print the list
  System.out.print("Truoc khi chen:  ");
  System.out.println(list_Strings);
  // Now insert a color at the first and last position of the list
  list_Strings.add(0, "Vang");
  System.out.print("Sau khi chen:  ");
  
  // Print the list
  System.out.println(list_Strings);
 }
  }