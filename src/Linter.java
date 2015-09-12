import java.io.*;
import java.util.*;

public class Linter {
	
	public static void main(String[] args) {
		try{
			//gets the file
			FileReader file = new FileReader(args[0]);
			//creates a scanner object to parse the file
			Scanner tokens = new Scanner(file);
			//gets the first line to check
			String ln = tokens.nextLine();
			//instantiates the counter
			int lineNum = 1;
			//loop to check the file
			while (ln != null){
				if(check(ln)){
					//if the line should end in a ; and doesn't prints message
					System.out.println("Line " + lineNum + ". Line should end in a semicolon. It does not.");
				}
				//checks to see if there is a next line
				try{
					ln = tokens.nextLine();
				}
				//catch Exception when next line doesn't exist
				catch (NoSuchElementException e){
					break;
				}
				//increment counter
				lineNum++;
			}
			//close the scanner
			tokens.close();
		}
		//catch exception for file not found
		catch (FileNotFoundException e){
			System.out.println("File Not Found Exception: " + e + "\nPlease enter a valid file name.");
		}
}

	public static boolean check(String line){
		//check if line doesn't need a ;
		if (line.contains("{") || line.contains("}") || line.length()==0){
			return false;
		}
		//check if line already ends in a semicolon
		else if (line.contains(";")){
			return false;
		}
		//if not, return true to print the message
		else{
			return true;
		}
	}
}