//package process;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//import org.apache.lucene.index.Term;
//import org.apache.lucene.index.TermDocs;
//import org.apache.lucene.search.IndexSearcher;
//import org.apache.lucene.search.Query;
//import org.apache.lucene.search.TermQuery;
//
//public class Search {
//	private String INDEX_STORE_PATH = "d:\\index";
//
//	public void indexSearch(String searchType, String searchKey) {
//		try {
//			// 根据索引位置建立IndexSearcher
//			IndexSearcher searcher = new IndexSearcher(INDEX_STORE_PATH);
//			// 建立搜索单元，searchType代表要搜索的Filed，searchKey代表关键字
//			Term t = new Term(searchType, searchKey);
//			// 由Term生成一个Query
//			Query q = new TermQuery(t);
//			// 搜索开始时间
//			Date beginTime = new Date();
//			// 获取一个<document, frequency>的枚举对象TermDocs
//			TermDocs termDocs = searcher.getIndexReader().termDocs(t);
//			while (termDocs.next()) {
//				// 输出在文档中出现关键词的次数
//				System.out.println(termDocs.freq());
//				// 输出搜索到关键词的文档
//				// System.out.println(searcher.getIndexReader().document(termDocs.doc()));
//			}
//			// 搜索完成时间
//			Date endTime = new Date();
//			// 搜索所耗时间
//			long timeOfSearch = endTime.getTime() - beginTime.getTime();
//			System.out
//					.println("The time For indexsearch is " + timeOfSearch + " ms");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void StringSearch(String keyword, String searchDir) {
//		File filesDir = new File(searchDir);
//		// 返回目录文件夹所有文件数组
//		File[] files = filesDir.listFiles();
//		// HashMap保存文件名和匹配次数对
//		Map rs = new HashMap();
//		// 记录搜索开始时间
//		Date beginTime = new Date();
//		// 遍历所有文件
//		for (int i = 0; i < files.length; i++) {
//			// 初始化匹配次数
//			int hits = 0;
//			try {
//				// 读取文件内容
//				BufferedReader br = new BufferedReader(new FileReader(files[i]));
//				StringBuffer sb = new StringBuffer();
//				String line = br.readLine();
//				while (line != null) {
//					sb.append(line);
//					line = br.readLine();
//				}
//				br.close();
//				// 将StringBuffer转化成String，以便于搜索
//				String stringToSearch = sb.toString();
//				// 初始化fromIndex
//				int fromIndex = -keyword.length();
//				// 逐个匹配关键词
//				while ((fromIndex = stringToSearch.indexOf(keyword, fromIndex
//						+ keyword.length())) != -1) {
//					hits++;
//				}
//				// 将文件名和匹配次数加入HashMap
//				rs.put(files[i].getName(), new Integer(hits));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		// 输出查询结果
//		Iterator it = rs.keySet().iterator();
//		while (it.hasNext()) {
//			String fileName = (String) it.next();
//			Integer hits = (Integer) rs.get(fileName);
//			System.out.println("find " + hits.intValue() + " matches in "
//					+ fileName);
//		}
//		// 记录结束时间
//		Date endTime = new Date();
//		// 得到搜索耗费时间
//		long timeOfSearch = endTime.getTime() - beginTime.getTime();
//		System.out.println("The time For string search is " + timeOfSearch + " ms");
//	}
//
//}
