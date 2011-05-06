import java.io.*;

public class Word{
	public Word(String word){
		this(word,null);
	}	
	
	public Word(String word, String comment){
		this.word = word;
		this.comment = comment;
	}
	
	public String word;
	public String comment;
	
	public byte[] serialize() throws IOException{		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		if (word == null)  dos.writeUTF("");
		else dos.writeUTF(word);
		if (comment == null ) dos.writeUTF("");
		else dos.writeUTF(comment);
		byte[] buf = baos.toByteArray();		
		dos.close();
		baos.close();
		return buf;		
	}
	
	public static Word deserialize(byte[] buf) throws IOException{				
		ByteArrayInputStream  bais= new ByteArrayInputStream(buf);
		DataInputStream dis = new DataInputStream(bais);
		String word = dis.readUTF();
		String comment =dis.readUTF();		
		dis.close();
		bais.close();
		return new Word(word, comment);
	}	
}
