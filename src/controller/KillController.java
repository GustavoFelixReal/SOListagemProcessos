package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}
	
	public void listProcess() {
		try {
			String os = os();
			String process = os.contains("Windows") ? "TASKLIST /FO TABLE" : "ps -ef";
			Process p;
	
			if (os.contains("Windows")) {
				p = Runtime.getRuntime().exec(process);
			} else {
				p = Runtime.getRuntime().exec(new String[] { "/bin/bash", "-c", process });
			}
	
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			
			String linha = buffer.readLine();
			StringBuffer processList = new StringBuffer();
			
			while (linha != null) {
				processList.append(linha + "\n");
				linha = buffer.readLine();
			}
			
			System.out.println(processList);

			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException error) {
			error.printStackTrace();
		}
	}
	
	public void killByPID() {
		
	}
	
	public void killByName() {
		
	}
	
	private String os() {
		return System.getProperty("os.name");
	}
}
