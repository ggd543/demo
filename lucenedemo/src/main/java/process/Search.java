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
//			// ��������λ�ý���IndexSearcher
//			IndexSearcher searcher = new IndexSearcher(INDEX_STORE_PATH);
//			// ����������Ԫ��searchType����Ҫ������Filed��searchKey����ؼ���
//			Term t = new Term(searchType, searchKey);
//			// ��Term����һ��Query
//			Query q = new TermQuery(t);
//			// ������ʼʱ��
//			Date beginTime = new Date();
//			// ��ȡһ��<document, frequency>��ö�ٶ���TermDocs
//			TermDocs termDocs = searcher.getIndexReader().termDocs(t);
//			while (termDocs.next()) {
//				// ������ĵ��г��ֹؼ��ʵĴ���
//				System.out.println(termDocs.freq());
//				// ����������ؼ��ʵ��ĵ�
//				// System.out.println(searcher.getIndexReader().document(termDocs.doc()));
//			}
//			// �������ʱ��
//			Date endTime = new Date();
//			// ��������ʱ��
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
//		// ����Ŀ¼�ļ��������ļ�����
//		File[] files = filesDir.listFiles();
//		// HashMap�����ļ�����ƥ�������
//		Map rs = new HashMap();
//		// ��¼������ʼʱ��
//		Date beginTime = new Date();
//		// ���������ļ�
//		for (int i = 0; i < files.length; i++) {
//			// ��ʼ��ƥ�����
//			int hits = 0;
//			try {
//				// ��ȡ�ļ�����
//				BufferedReader br = new BufferedReader(new FileReader(files[i]));
//				StringBuffer sb = new StringBuffer();
//				String line = br.readLine();
//				while (line != null) {
//					sb.append(line);
//					line = br.readLine();
//				}
//				br.close();
//				// ��StringBufferת����String���Ա�������
//				String stringToSearch = sb.toString();
//				// ��ʼ��fromIndex
//				int fromIndex = -keyword.length();
//				// ���ƥ��ؼ���
//				while ((fromIndex = stringToSearch.indexOf(keyword, fromIndex
//						+ keyword.length())) != -1) {
//					hits++;
//				}
//				// ���ļ�����ƥ���������HashMap
//				rs.put(files[i].getName(), new Integer(hits));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		// �����ѯ���
//		Iterator it = rs.keySet().iterator();
//		while (it.hasNext()) {
//			String fileName = (String) it.next();
//			Integer hits = (Integer) rs.get(fileName);
//			System.out.println("find " + hits.intValue() + " matches in "
//					+ fileName);
//		}
//		// ��¼����ʱ��
//		Date endTime = new Date();
//		// �õ������ķ�ʱ��
//		long timeOfSearch = endTime.getTime() - beginTime.getTime();
//		System.out.println("The time For string search is " + timeOfSearch + " ms");
//	}
//
//}
