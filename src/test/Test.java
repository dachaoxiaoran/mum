package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TimeZone;
import java.util.TreeSet;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;

import com.mum.db.DAO;
import com.mum.db.function.FunctionEnum;
import com.mum.db.pojo.DbField;
import com.mum.db.pojo.DbFieldSelectOperation;
import com.mum.db.pojo.DbOperateEnum;
import com.mum.db.pojo.DbTable;
import com.mum.utils.PropertiesUtil;
import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import static com.mum.constant.IConstant.*;

public class Test {
	public static void main(String[] args) {
		try {
//			LocalDate beginDate = LocalDate.parse(PropertiesUtil.get(BEGIN_DATE));
//			LocalDate endDate =  LocalDate.now().minusDays(2);
//
//			while(!beginDate.isEqual(endDate)) {
//				HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(String.format(HISTORY_URL, beginDate))).openConnection();
//				httpURLConnection.connect();
//				Parser parser = new Parser(httpURLConnection);
//				NodeFilter tableFilter = new TagNameFilter(TABLE);
//	            NodeList tableNodes = parser.extractAllNodesThatMatch(tableFilter);
//	            Node tableNode = tableNodes.elementAt(tableNodes.size() - 1);
//	            
//	            nodeHandler(tableNode, new Integer(0));
//	            
//	            httpURLConnection.disconnect();
//	            beginDate = beginDate.plusDays(1);
//	            PropertiesUtil.set(BEGIN_DATE, beginDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
//	            break;
//			}
//			
		
//			try(FileInputStream fileInputStream = new FileInputStream(new File("F:/new.txt"));
//				InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "gb2312");
//				BufferedReader br = new BufferedReader(inputStreamReader);) {
//				DbOperator dbOperator = new DbOperator();
//				StringBuilder stringBuilder = new StringBuilder();
//				String s = null;
//				DbTable dbTable = new DbTable("country");
//				DbField dbField = new DbField("code_two");
//				dbTable.putField(dbField);
//				List<Map<String, String>> list = dbOperator.select(dbTable);
//				while ((s = br.readLine())!=null) {
//					String[] strings = s.split(";");
//					for (int i = 0; i < list.size(); i++) {
//						if (list.get(i).get("code_two").equals(strings[0])) {
//							list.remove(i);
//							break;
//						}
//					}
//					
//				}
				
//				try (FileWriter fw = new FileWriter("F:/new1.txt");
//					BufferedWriter bw = new BufferedWriter(fw);) {
//					bw.write(stringBuilder.toString());
//				}


				   
//			}
			
			try(FileInputStream fileInputStream = new FileInputStream(new File("F:/infoHeader.txt"));
				InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
				BufferedReader br = new BufferedReader(inputStreamReader);) {
				
				StringBuilder stringBuilder = new StringBuilder();
				String s = null;
				Set<String> set = new TreeSet<>();
				while ((s = br.readLine()) != null) {
					String[] ss = s.split(",");
					for (String sss : ss) {
						if (sss.indexOf("-") != -1) {
							set.add(sss);
							continue;
						}
						try {
							if (Double.parseDouble(sss) > 2000) {
								set.add(sss);
								continue;
							}
						}catch(Exception e) {
							continue;
						}
					}
					
				}
				
				Iterator<String> iterator = set.iterator();
				while (iterator.hasNext()) {
					stringBuilder.append(iterator.next()).append("\n");
				}
				
				try (FileWriter fw = new FileWriter("F:/new.txt");
					BufferedWriter bw = new BufferedWriter(fw);) {
					bw.write(stringBuilder.toString());
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		//System.out.println(FunctionEnum.VARIANCE.toString());
		
	}
	
	
	private static void nodeHandler(Node node, Integer nodeDropIndex) {
		NodeList nodeList = node.getChildren();
		if (Objects.isNull(nodeList)) {
			textHandler(node);
		} else {
			for (int i = 0; i < nodeList.size(); i++) {
				Node childNode = nodeList.elementAt(i);
				if (Objects.nonNull(nodeDropIndex) && nodeList.indexOf(childNode) == nodeDropIndex.intValue()) {
					continue;
				}
				nodeHandler(childNode, null);
			}
		}
	}
	
	private static void textHandler(Node node) {
		String plainText = node.toPlainTextString().trim();
		if (!plainText.equals(EMPTY)) {
			int index = node.getParent().getParent().getChildren().indexOf(node.getParent());
			System.out.println(index);
		}
	}
}
