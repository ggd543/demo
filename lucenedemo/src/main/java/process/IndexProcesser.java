//package process;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import org.apache.lucene.document.Document;
//import org.apache.lucene.document.Field;
//import org.apache.lucene.index.IndexWriter;
//
//public class IndexProcesser {
//	// 成员变量存储创建的索引文件存放的位置
//	private String INDEX_STORE_PATH = "d:\\index";
//
//	// 创建索引
//	public void createIndex(String inputDir) {
//		try {
//			// MMAnalyzer作为分词工具创建一个IndexWriter
//			IndexWriter writer = new IndexWriter(INDEX_STORE_PATH,
//					new MMAnalyzer(), true);
//			File filesDir = new File(inputDir);
//			// 取得所有需要建立索引的文件数组
//			File[] files = filesDir.listFiles();
//			// 遍历数组
//			for (int i = 0; i < files.length; i++) {
//				// 获取文件名
//				String fileName = files[i].getName();
//				// 判断文件是否为txt类型的文件
//				if (fileName.substring(fileName.lastIndexOf("."))
//						.equals(".txt")) {
//					// 创建一个新的Document
//					Document doc = new Document();
//					// 为文件名创建一个Field
//					Field field = new Field("filename", files[i].getName(),
//							Field.Store.YES, Field.Index.TOKENIZED);
//					doc.add(field);
//					// 为文件内容创建一个Filed
//					field = new Field("content", loadFileToString(files[i]),
//							Field.Store.NO, Field.Index.TOKENIZED);
//					doc.add(field);
//					// 把Document加入IndexWriter
//					writer.addDocument(doc);
//				}
//			}
//			// 关闭IndexWriter
//			writer.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public static void main(String[] args) {
//		IndexProcesser processor = new IndexProcesser();
//		processor.createIndex("d:\\testfolder");
//	}
//	public String loadFileToString(File file) {
//		try {
//			BufferedReader br = new BufferedReader(new FileReader(file));
//			StringBuffer sb = new StringBuffer();
//			String line = br.readLine();
//			while (line != null) {
//				sb.append(line);
//				line = br.readLine();
//			}
//			br.close();
//			return sb.toString();
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//}
