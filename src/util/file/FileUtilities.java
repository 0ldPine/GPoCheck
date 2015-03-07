package util.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class FileUtilities {

	public static void createFileFromString(String name, String contents) {
		if ((new File(name)).exists()) {
			if (!(new File(name)).delete()) {
				throw new RuntimeException("Error when trying to remove file: " + name);
			}
		}

		OutputStreamWriter writer = null;
		try {
			File theFile = new File(name);
			writer = new OutputStreamWriter(new FileOutputStream(theFile), "UTF-8");
			writer.append(contents);
			writer.flush();
		} catch (IOException e) {
			throw new RuntimeException("Error writing file: " + name);
		} finally {
			if (writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					throw new RuntimeException("Error closing file: " + name, e);
				}
		}
	}

	public static void createFileFromBytes(String name, byte[] contents) {
		if ((new File(name)).exists()) {
			if (!(new File(name)).delete()) {
				throw new RuntimeException("Error when trying to remove file: " + name);
			}
		}

		FileOutputStream fileWriter = null;
		try {
			File theFile = new File(name);
			fileWriter = new FileOutputStream(theFile);
			fileWriter.write(contents);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			throw new RuntimeException("Error writing file: " + name);
		} finally {
			if (fileWriter != null)
				try {
					fileWriter.close();
				} catch (IOException e) {
					throw new RuntimeException("Error closing file: " + name, e);
				}
		}
	}

	public static void createDirectory(String name) {
		if ((new File(name)).exists()) {
			return;
		}

		if (!(new File(name)).mkdirs()) {
			throw new RuntimeException("Error creating directory: " + name);
		}
	}

	public static String fileToString(String fileName) {
		BufferedReader reader = null;
		try {
			StringBuilder contents = new StringBuilder();
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
			String line;
			while ((line = reader.readLine()) != null) {
				contents.append(line);
			}
			return contents.toString();
		} catch (Exception e) {
			throw new RuntimeException("Error reading file: " + fileName, e);
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					throw new RuntimeException("Error closing file: " + fileName, e);
				}
		}
	}

	public static byte[] fileToBytes(String fileName) {
		InputStream is = null;
		byte[] bs = null;
		try {
			File file = new File(fileName);
			is = new FileInputStream(file);
			long length = file.length();
			if (length > Integer.MAX_VALUE) {
				throw new RuntimeException("Error reading file: " + fileName + ". File too large.");
			}
			bs = new byte[(int) length];
			is.read(bs);
		} catch (Exception e) {
			throw new RuntimeException("Error reading file: " + fileName, e);
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				throw new RuntimeException("Error closing file: " + fileName, e);
			}
		}
		return bs;
	}

	public static List<String> fileToList(String fileName) {
		BufferedReader reader = null;
		try {
			List<String> list = new LinkedList<String>();
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException("Error reading file: " + fileName, e);
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					throw new RuntimeException("Error closing file: " + fileName, e);
				}
		}
	}

}
