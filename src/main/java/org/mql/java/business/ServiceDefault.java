package org.mql.java.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServiceDefault implements Service {

	public String executeCommand(String command) {
		StringBuilder output = new StringBuilder();

		try {
			String gitBashPath = "bash.exe"; // Change this to your Git Bash path

			ProcessBuilder processBuilder = new ProcessBuilder(gitBashPath, "-c", command);
			Process process = processBuilder.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line).append("\n");
			}

			int exitCode = process.waitFor();
			if (exitCode != 0) {
				System.err.println("Command exited with error code: " + exitCode);
			}

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return output.toString();
	}

}
