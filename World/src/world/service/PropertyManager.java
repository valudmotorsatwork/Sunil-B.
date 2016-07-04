package world.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager 
{
	private static String propertyFilename = "./resources/world.config";
	private static Properties properties = new Properties(); // empty
	
	static 
	{
		loadProperties(propertyFilename);
	}
	/** Load properties from a file or resource by name.
	 *  @param filename file or resource name
	 *  @return true if successful
	 */
	private static void loadProperties(String filename) 
	{
		InputStream instream = null;
		// first open as a file relative to "current" directory
		try 
		{
			instream = new FileInputStream( filename );
		} 
		catch ( Exception e )
		{ /* try again */ }

		if (instream == null) 
		{
			ClassLoader loader = PropertyManager.class.getClassLoader();
			instream = loader.getResourceAsStream(filename);
		}
		if (instream == null) return;
		// remove old property values first
		properties.clear();
		try {
			properties.load(instream);
		} catch (IOException e) {
			System.out.println("Error reading properties file "+filename);
		}
		// close input stream to free resources
		try {
			instream.close();
		} catch (IOException ioe) { /* shouldn't happen */ }
	}
}
