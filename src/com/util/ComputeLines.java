package com.util;

import java.io.*;

public class ComputeLines {
	public static int getLineNum(String filename, String filter) throws IOException {
		int result = 0;
		File rootDir = new File(filename);
		if(rootDir.isDirectory()) {
			for(File file : rootDir.listFiles()) {
				if(file.isDirectory()) 
					result += getLineNum(file.getAbsolutePath(), filter);
				else {
					String fname = file.getName();
					if(!fname.matches("\\w+.java")) continue;
					System.out.println(fname);
					int count = 0;
					BufferedReader br = new BufferedReader(new FileReader(file));
					while(br.readLine() != null) {
						count++;
					}
					br.close();
					result += count;
				}
			}
		} else {
			int count = 0;
			BufferedReader br = new BufferedReader(new FileReader(rootDir));
			while(br.readLine() != null) {
				count++;
			}
			br.close();
			result = count;
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(getLineNum(args[0], ".java"));
	}
}
