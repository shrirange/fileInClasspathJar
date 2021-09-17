package com.example.fileinclasspathjar;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.io.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

public class Fileinjar implements EnvironmentPostProcessor {

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		// TODO Auto-generated method stub
		System.out.println("File output");
		InputStream is = getClass().getClassLoader().getResourceAsStream("config");
		printInputStream(is);

	}
	
	private static void printInputStream(InputStream is) {

        try (InputStreamReader streamReader =
                    new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("fdfdfd" + line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
