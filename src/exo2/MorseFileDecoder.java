package exo2;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MorseFileDecoder 
{
	private final String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789çà ";
	private final String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
	        ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
	        "-....", "--...", "---..", "----.", "-----", "-.-..", ".--.-", ""};

	private HashMap<String, String> toText;
	    
	public MorseFileDecoder() 
	{
		toText = new HashMap<>();
		char[] alphaArray = alphabet.toCharArray();
		for(int i = 0; i < morse.length; i++) 
			toText.put(morse[i], String.valueOf(alphaArray[i]));
	}

	public String decode(String s) 
	{
		String[] code = s.split(" ");
		String decoded = "";
	    for(int i = 0; i < code.length; i++)  	
	    	if (toText.containsKey(code[i])) 
	    		decoded += toText.get(code[i]);
	        else 
	        	decoded += " ";

	        return decoded;
	}
	
	public String[] openFile(String s) throws IOException
	{
		Path filePath = new File(s).toPath();
		Stream<String> lines = Files.lines(filePath);
		List<String> result = new ArrayList<String>();
		result = lines.collect(Collectors.toList());
		String[] strLinArray = result.toArray(new String[] {});
		return  strLinArray;
	}
	
	public void decodeStringArray(String[] sa)
	{
		for(int nbLignes = 0; nbLignes < sa.length; nbLignes++)
			decode(sa[nbLignes]);
	}
	
	public void display(String[] sa)
	{
		for(int nbLignes = 0; nbLignes < sa.length; nbLignes++)
			System.out.println(sa[nbLignes] + " -> " + decode(sa[nbLignes]));
	}

}
