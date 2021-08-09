import java.io.BufferedInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.sun.jdi.Field;

public class IOstream {
	public static void main(String[] args) {
		
//		File file = new File("text1.txt");
//		if(file.isFile()) {
//			System.out.println("File "+file.getAbsolutePath());
//			file.delete();
//		}else {
//			System.out.println("Not File");
////			file.createNewFile();
//		}
		
//		DataInputStream inputStream = new DataInputStream(System.in);
//		System.out.println("Nhap N: ");
////		String N = inputStream.readLine();
//		int N = Integer.parseInt(inputStream.readLine());
//		System.out.println(N);
		
		//DOC DU LIEU TU FILE
//		FileInputStream fileInputStream =null;
//		//copy tu file text qua file textcopy(chua tao) se dung FileOutputStream
//		FileOutputStream fileOutputStream =null;
//		try {
//			fileInputStream = new FileInputStream("text.txt");//1 la class IOstream throws IOException 2 la dung try cacth
//			fileOutputStream = new FileOutputStream("textcopy.txt");//chung ta k tao file textcopy maf fileOutoutStream se tu tao
//			int read;
//			while((read = fileInputStream.read())!=-1) {
//			
//				System.out.print((char)read);
//				fileOutputStream.write(read);
//			}
//		} catch ( Exception e) {
//			
//			e.printStackTrace();
//		}
//		finally {
//			if(fileInputStream!=null) {
//				try {
//					fileInputStream.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		//finaly cua outstream
//		
//			if(fileOutputStream!=null) {
//				try {
//					fileOutputStream.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
			//NEXT 1
//		FileReader reader = null;
//		FileWriter writer = null;
//		try {
//			reader = new FileReader("text.txt");
//			writer = new FileWriter("textcopy2.txt");
//			int read;
//			
//			while((read= reader.read())!=-1) {
//				System.out.print((char) read);
//				writer.write(read);
//			}
//			writer.write("\nXin Chao World");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			if(reader!= null) {
//				try {
//					reader.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if(writer != null) {
//				try {
//					writer.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
		//NEXT 2
		FileInputStream fileInputStream = null;
		BufferedInputStream bufferedInputStream = null;
		try {
			fileInputStream = new FileInputStream("text.txt");
			bufferedInputStream = new BufferedInputStream(fileInputStream);
			byte[] data = new byte[512];//may cung dc
			int length = bufferedInputStream.read(data);
			System.out.println("length: "+length);
//			String resulf = new String(data, 0, length);
			String resulf = new String(data);
			System.out.println(resulf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
