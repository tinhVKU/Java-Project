import java.io.File;

public class file {
	public file(String path) {
		File file = new File(path);
		String[] filename = file.list();
		for(int i= 0;i<filename.length;i++) {
			System.out.println(filename[i]);
			
		}
	}
	public static void main(String[] args) {
		new file("C:\\Phanvantinh");
	}
}
