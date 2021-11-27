package br.edu.unoesc.pandemicstats.springboot.utils;

import java.io.BufferedReader;
import java.io.IOException;

import lombok.Data;

@Data
public class JSONimporter {
	
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
			System.out.println(jsonArray);
			
			return jsonArray;
			}catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Parou");
				return "0";
			}
		
	}
}
