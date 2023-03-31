package exo2;

import exo2.MorseFileDecoder;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class main 
{
	
	public static void main(String[] args) throws IOException, java.lang.Exception
	{	
		MorseFileDecoder m = new MorseFileDecoder();
		String[] stringsArray;
		stringsArray = m.openFile("exo2.txt");
		m.decodeStringArray(stringsArray);
		
		// Affichage du texte converti dans la console
		m.display(stringsArray);
		
		// Création d'un nouveau fichier qui contiendra le texte traduit
		PrintStream o = new PrintStream(new File("exo2Decode.txt"));
		
		// Redirection à partir de cette ligne vers le nouveau fichier
		System.setOut(o);
		
		// Affichage du texte converti dans le nouveau fichier
		m.display(stringsArray);
	}
}
