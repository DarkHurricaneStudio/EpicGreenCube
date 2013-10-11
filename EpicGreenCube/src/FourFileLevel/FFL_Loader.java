package FourFileLevel;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.imageio.ImageIO;

/**
 * this class is used to load files from a Zip archive, for The 4 File Level system 
 * @author Avignak
 * @version 1
 */
public class FFL_Loader {
	
	//fields
	/**
	 * the size of the buffer used to load files
	 */
	static final int BUFFER = 2048; //a buffer to load files

	
	/**
	 * Load an Image from a zip archive
	 * @param path The path to the zip file (ex: "C:/level.zip" )
	 * @param filename The name of the wanted image
	 * @return A BufferedImage of the wanted image
	 */
	public static BufferedImage loadImage(String path, String filename) {
		
		// the return
		BufferedImage image = null;
		// we try
		try {
		// we create an object to load the file into a byte stream
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		// we load the Zip file
		ZipFile zipFile = new ZipFile(path);
		
		// we search the good file from the zip
		ZipEntry zipFileEntry = zipFile.getEntry(filename);
		
		// we load the file into an Input Stream
    	InputStream inputStream = zipFile.getInputStream(zipFileEntry);
    	
    	// The file will be read at a byte[]
    	byte[] buffer = new byte[FFL_Loader.BUFFER];
    	
    	// we load all characters
			for(int n; (n = inputStream.read(buffer)) != -1; )  
				out.write(buffer, 0, n);

    	// we close the stream
    	inputStream.close();  
    	// we close the zip
    	zipFile.close(); 
    	// and the Byte[] output stream
    	out.close(); 
    	// we transform the stream as a real byte array
    	byte[] bytes = out.toByteArray();
    	// and transform it to a BufferedImage
    	image = ImageIO.read(new ByteArrayInputStream(bytes));
		}
		catch (Exception e) {
			System.out.println(filename+" not fond in "+path+" !");
		}
    	
    	// finally, we return the BufferedImage or null if the loading doesn't work
    	return image;
    	
	}
	
	/**
	 *  Load a text file from a zip archive
	 * @param path The path to the zip file (ex: "C:/level.zip" )
	 * @param filename The name of the wanted text file
	 * @param encoding The encoding system from this file (ex : "UTF-8" )
	 * @return a vector of String, each entry represents one line from the file
	 */
	public static ArrayList<String> loadText(String path, String filename, String encoding) {
		
		ArrayList<String> fileLines = new ArrayList<String>();
		
		try {
			// we load the Zip file
			ZipFile zipFile = new ZipFile(path);
			
			// we search the good file from the zip
			ZipEntry zipFileEntry = zipFile.getEntry(filename);
			
			// we load it as an Input Stream
        	InputStream inputStream = zipFile.getInputStream(zipFileEntry);
        	
        	// we load the stream in a bufferedReader
        	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, encoding));
        	
        	// we read each line one by one and stock it in the vector
        	String line = null;
        	while ((line = bufferedReader.readLine()) != null)  {
        		fileLines.add(line);
        	}
        	
        	// we close the Input stream
        	inputStream.close();  
        	// same thing for the zip
        	zipFile.close();  

        	
		} catch (Exception e) {
			System.out.println(filename+" not fond in "+path+" !");
		}
		
		return fileLines;
	}
	
	/**
	 *  Load an UTF-8  text file from a zip archive
	 * @param path The path to the zip file (ex: "C:/level.zip" )
	 * @param filename The name of the wanted text file
	 * @return a vector of String, each entry represents one line from the file
	 */
	public static ArrayList<String> loadText(String path, String filename) {
		return FFL_Loader.loadText(path, filename, "UTF-8");
	}
	
}
