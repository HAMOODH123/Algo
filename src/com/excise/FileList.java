package com.excise;

import java.io.File;

import static com.util.Print.*;

public class FileList {
	public static void fileList(String path, int i) {
		File fr = new File(path);
		for(int j = 0; j < i; j++)
			print("  ");
		println(fr.getName());
		if(fr.isDirectory())
			for(File f : fr.listFiles())
				fileList(f.getAbsolutePath(), i + 1);
	}

	public static void main(String[] args) {
		fileList(args[0], 0);
	}
}
