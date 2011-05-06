import java.io.*;
import javax.microedition.io.*;
import javax.microedition.io.file.*;
import java.util.*;

public class IO{	
	public static final String DIR = "file:///root1/";
	
	static{
		printDeviceRoots();	
	}
	
	public static void printDeviceRoots() {
        Enumeration enumRoot = FileSystemRegistry.listRoots(); // 返回根目录组成的序列		
        while (enumRoot.hasMoreElements()) {
			String strRoot = (String)enumRoot.nextElement();
			System.out.println("file:///"+strRoot);
			listAllFiles("file:///"+strRoot, 1);
        }
	}
	
	public static void listAllFiles(String path, int i){
		if (path == null) throw new IllegalArgumentException();
		try{
			FileConnection fc = (FileConnection)Connector.open(path);			
			Enumeration e = fc.list();
			while(e.hasMoreElements()){
				for (int j = 0 ; j < i; j++)  System.out.print("	");
				String fcName = (String)e.nextElement();
				System.out.println(fcName);
				listAllFiles("file:///"+fc.getPath()+fcName, i+1);
			}
		}catch(Exception e){
			//#debug
			System.out.println(e);
		}
	}
	
	public static void write(String fileName, String text) throws IOException{		
		System.out.println(DIR+fileName);
		FileConnection fconn = (FileConnection)Connector.open(DIR+fileName, Connector.READ_WRITE);										
		if (!fconn.exists()) fconn.create();						
		fconn.setWritable(true);
		OutputStream os = fconn.openOutputStream();		
		byte []buff = text.getBytes();
		os.write(buff);
		os.flush();
		os.close();
		System.out.println("create the file: "+(DIR+fileName)+" successfully");
	}
	
	public static String read(String fileName) throws IOException {
		FileConnection fconn = (FileConnection)Connector.open(DIR+fileName, Connector.READ);		
		InputStream is = fconn.openInputStream();
		int len = -1;
		byte []buf = new byte[32];
		StringBuffer strBuf = new StringBuffer();
		while((len =is.read(buf, 0, buf.length)) != -1){
		    strBuf.append(new String(buf, 0 , len));
		}
	    is.close();
		return strBuf.toString();
	}	
}
