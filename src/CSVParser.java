// JAMES NALEPA
// --- JAVA CSV PARSER PROGRAM ---
// DESIGNED TO GRAB AN INPUT FILE AND LOAD EACH LINE INTO A STRING VARIABLE
// THESE STRINGS ARE THEN WRITTEN TO AN OUTPUT FILE IN THE SAME FORMAT

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVParser {

	public static void main(String[] args) throws Exception {
		converter();
	}

	public static void converter() throws IOException
	{
		try
		{
			boolean written = false;
			String strFile = "./UranianSystem.csv";
			String strFile2 = "./UranianSystemOutput.csv";
			File f = new File(strFile);
			BufferedReader br = new BufferedReader( new FileReader(f)); // input csv reader
			File f2 = new File(strFile2);
			BufferedWriter bw = new BufferedWriter( new FileWriter(f2)); // output file

			String strLine = "";
			String wLine = "";
			int lineNumber = 0;
			boolean replaced = false;
			while( (strLine = br.readLine()) != null)
			{
				replaced = false;
				lineNumber++;
				System.out.println(lineNumber);
				
			    strLine = strLine.replaceAll(" ", ",");
			    strLine = strLine.replaceAll(",,", ",");
			    replaced = true;

				bw.write(strLine);
				
				bw.newLine();
				written = true;
			}
			br.close();
			bw.close();

			System.out.println("Finished");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found " + e); 
		}
	}

}