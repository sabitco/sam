package co.edu.unal.sam.aspect.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadFromPropertiesFile {

	public static String getProperties(String key) throws IOException {
		InputStream inputStream = ReadFromPropertiesFile.class.getClassLoader()
				.getResourceAsStream("messages_es.properties");
		Properties myproperties = new Properties();
		// ///////////load the properties file
		myproperties.load(inputStream);
		return myproperties.getProperty(key);
	}
}