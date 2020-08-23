import java.util.*;
import java.io.*;

public class Main{
	public static void real_mvp(String original_String){
		System.out.println("Building Huffman Tree and Code tables...");

		Huffman hman = new Huffman(original_String);
		System.out.println("DONE");

		System.out.println("============= Occurence of each character =============");
		for(Map.Entry<Character, Integer> e: hman.mapWC.entrySet()){
			String key = e.getKey().toString();//if not toString then cannot be dereferenced error
			if(key.equals("\n"))key = "\\n";
			System.out.println(key + " occurs " + e.getValue() + " times");
		}
		System.out.println("============= Huffman Code for each word =============");
		for(Map.Entry<Character, String> e: hman.mapCode.entrySet()){
			String key = e.getKey().toString();
			if(key.equals("\n"))key = "\\n";
			System.out.println(key + " = " + e.getValue());
		}

		System.out.println("============= Encoding the file =============");
		String encode = hman.encode();
		System.out.println("DONE");

		System.out.println("============= Decoding the file =============");
		String decode = hman.decode();
		if(original_String.equals(decode)) System.out.println("Decode Successful\n****************** Decoded file = original file ******************");
		else System.out.println("Decode Unsuccessful\n Decoded file != original file");
		System.out.println("DONE");

		double orl = original_String.length()*7; // Each char is represented by 7 bits
		double el = encode.length();
		System.out.println("============= RESULT =============");
		System.out.println("Original string cost = " + (int)orl + " bits") ;
	    System.out.println("Encoded  string cost = " + (int)el + " bits") ;
	    double r = ((el - orl)/orl) * 100 ;
	    System.out.println("****************** % REDUCTION = " + (-r) + " ******************") ;
	}

	public static String readfile(String original_File){
		System.out.println("Reading file...");
		StringBuilder s = new StringBuilder();
		File filename = new File(original_File);
		try{
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line = in.readLine();
			while(line != null){
				s.append(line + "\n");
				line = in.readLine();
			}
		}
		catch(IOException e){
			System.out.println(e);
		}
		return s.toString();
	}

	public static void start(){
		String original_File  = "file.txt";
		System.out.println("Loading File...");
		String original_String = readfile(original_File);
		System.out.println("Done");

		real_mvp(original_String);
	}

	public static void main(String args[]){
		System.out.println("----- START -----");
	  	start();
	  	System.out.println("\n----- DONE ----- ");
	}

}