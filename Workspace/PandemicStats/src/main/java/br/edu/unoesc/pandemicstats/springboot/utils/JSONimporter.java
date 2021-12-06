package br.edu.unoesc.pandemicstats.springboot.utils;

import java.io.BufferedReader;
import java.io.IOException;

import lombok.Data;

/**
 * @author Eduardo Mateus Da Costa
 * @since 27/11/2021
 * @version 1.2
 */
@Data
public class JSONimporter {
	
	/**
	 * @param String filename
	 * @return String 
	 * @see java.io.FileReader
	 * @see java.io.BufferedReader
	 * @see StringBuilder
	 */
	public String importer(String filename)
	{
		String file = "C:\\Users\\duduc\\Desktop\\Entradas\\" + filename +".json";
		try {
			java.io.FileReader fr = new java.io.FileReader(file);
			java.io.BufferedReader br = new BufferedReader(fr);
			StringBuilder json = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				json = json.append(line);
			}
			br.close();
			fr.close();
			
			String jsonArray = new String(json.toString());
			
			return jsonArray;
			}catch(IOException e)
			{
				throw new RuntimeException("Falhou na importação");
			}
		
	}
}
