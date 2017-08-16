package chapter2_5;

import java.io.File;
import java.util.Arrays;

public class FileSorter {

	public static void main(String[] args) {
		String directory = args[0];
		File dir = new File(directory);
		
		String[] filenames = dir.list();
		Arrays.sort(filenames);
		System.out.println(Arrays.toString(filenames));
	}
}
