package test;

import preprocess.FilePreprocess;
import java.io.File;
import org.junit.Test;

public class FilePreprocessTest {
    
    @Test
	public void testFilePreprocess(){
		String inputFile = "lingshan.txt";
		String outputDir = "./testfolder/";
		if (!new File(outputDir).exists())
			new File(outputDir).mkdirs();
		FilePreprocess filePreprocess = new FilePreprocess();
		filePreprocess.preprocess(new File(inputFile), outputDir);
	}
}
