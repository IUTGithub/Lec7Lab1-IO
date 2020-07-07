import java.io.FileInputStream;
import java.io.PrintStream;
import java.io.File;
import java.util.Scanner;

public class Lab1 {
	public static void main(String[] args) throws Exception {
		File fHandle = new File("input.txt");
		boolean read = true;
		int length;
		String currentLine;
		int[] intArray;
		int count = 0;
		int largest = 0;
		int smallest = 100;
		
		 // Handles does not exit (Doesn't throw an exception)
		if (fHandle.exists() == false) {
			read = false;
			System.out.printf("input.txt does not exist"); 
		}
		
		// If file does exist, then do program's intended function
		if (read) {
			PrintStream outStream = new PrintStream("sysOutput.txt");
			System.setOut(outStream);
			FileInputStream fileinput = new FileInputStream("input.txt");
			System.setIn(fileinput);
			Scanner keyboard = new Scanner(System.in); 
			// Reads in from the FileInputStream ("input.txt");
			
			length = Integer.parseInt(keyboard.nextLine());
			intArray = new int[length];
			
			while (count < length) {
				currentLine = keyboard.nextLine();
				String[] parsedLine = currentLine.split(" ");
				
				for (int x = 0; x < parsedLine.length; x++) {
					intArray[count] = Integer.parseInt(parsedLine[x]);
					count++;
				}
			}
			
			for (int x = 0; x < intArray.length; x++) {
				for (int i = 0; i < intArray.length; i++) {
					if (intArray[i] > largest) {
						largest = intArray[i];
					}
					if (intArray[i] < smallest) {
						smallest = intArray[i];
					}
				}
			}
			System.out.printf("%d\n%d\n", largest, smallest);
			
			outStream.close();
			fileinput.close();
			keyboard.close();
		}
		
	}
}
