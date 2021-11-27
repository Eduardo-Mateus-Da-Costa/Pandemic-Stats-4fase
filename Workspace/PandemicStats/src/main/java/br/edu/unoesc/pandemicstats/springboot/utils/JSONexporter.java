package br.edu.unoesc.pandemicstats.springboot.utils;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;

public class JSONexporter {
	FileWriter writeFile = null;
	
	public void exportfromurl(String url, String filename)
	{
	    int codigoSucesso = 200;

	        try {
	            URL link = new URL(url);
	            HttpURLConnection conexao = (HttpURLConnection) link.openConnection();

	            if (conexao.getResponseCode() != codigoSucesso)
	                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

	            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
	            
	            String linha, jsonEmString = "";
	       	 	while ((linha = resposta.readLine()) != null) {
	            		jsonEmString += linha;
	        	}
	       	 	
	       	 	JSONArray json = new JSONArray(jsonEmString);
	            exporter(json, filename);
	       	 	
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Falhou aqui");
	        }
	  }

	
	
	
	public void exporter(JSONArray json, String filename)
	{
		String saida = "C:\\Users\\duduc\\Desktop\\Saidas\\" + filename + ".json";
		try {
			writeFile = new FileWriter(saida);
			writeFile.write(json.toString());
			writeFile.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Falhou ali");
		}
	}
	

}
