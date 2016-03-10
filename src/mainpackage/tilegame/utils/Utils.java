package mainpackage.tilegame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
	public static String LoadFileAsStringPath(String path){
		StringBuilder builder = new StringBuilder();
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line; // current line we are working on in file
			while((line = br.readLine()) != null){
				builder.append(line + "\n"); //print line then add new line
				
			}
			
		}catch(IOException e){
			e.printStackTrace();// prints error to screen
		}
		return builder.toString();
	}
	
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		return 0;
	}
}
