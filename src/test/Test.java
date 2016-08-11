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
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;

import com.mum.db.DAO;
import com.mum.db.function.FunctionEnum;
import com.mum.utils.PropertiesUtil;
import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import static com.mum.constant.IConstant.*;

public class Test {
	public static void main(String[] args) {
		try {
			
//			StringBuilder stringBuilder = new StringBuilder();
//			StringBuilder sb = new StringBuilder();
//			int num = 21;
//			for (int i = 20001; i < 100000; i++) {
//				stringBuilder.delete(0, stringBuilder.length());
//				stringBuilder.append("http://zq.win007.com/cn/team/Summary/").append(i).append(".html");
//				String s = stringBuilder.toString();
//				HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(s)).openConnection();
//				httpURLConnection.connect();
//				Parser parser = new Parser(httpURLConnection);
//				NodeFilter tableFilter = new TagNameFilter("title");
//				NodeList titleNodes = parser.extractAllNodesThatMatch(tableFilter);
//				String title = titleNodes.elementAt(0).toPlainTextString().trim();
//				if (!title.equals("无标题页")) {
//					sb.append(title).append(",").append(s).append("\n");
//				}
//				httpURLConnection.disconnect();
//				
//				int ii = i / 1000;
//				if (ii == num) {
//					num++;
//					try (FileWriter fw = new FileWriter("F:/data/new" + ii + ".txt");
//						BufferedWriter bw = new BufferedWriter(fw);) {
//						bw.write(sb.toString());
//						sb = new StringBuilder();
//					}
//				}
//			}
			
//			StringBuilder stringBuilder = new StringBuilder();
//			int jj = 0;
//			try {
//				for (int j = 0; j < 30000; j++) {
//					jj = j;
//					String url = "http://zq.win007.com/cn/team/TeamVenue/" + j + ".html";
//					HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(url)).openConnection();
//					httpURLConnection.setConnectTimeout(60000);
//					httpURLConnection.connect();
//					Parser parser = new Parser(httpURLConnection);
//					parser.setEncoding("utf-8");
//					NodeIterator nodeIterator = parser.elements();
//					String string = "";
//					while (nodeIterator.hasMoreNodes()) {
//						Node node = nodeIterator.nextNode();
//						String nodeHTML = node.toPlainTextString().replaceAll("\n", "").replaceAll("\r", "").trim();
//						if (nodeHTML.indexOf("球队场馆") != -1 && nodeHTML.indexOf("var teamSelectLogic") != -1) {
//							nodeHTML = nodeHTML.substring(nodeHTML.indexOf("球队场馆") + 4, nodeHTML.indexOf("var teamSelectLogic")).trim();
//							nodeHTML = nodeHTML.replaceAll("&nbsp;报错编辑", "");
//							String[] title = {"简体名：", "繁体名：", "英文名：", "城市：", "容量：", "表面：", "旧名称：", "建造年份：", "地址：", "近况：", "场馆介绍"};
//							for (int i = 0; i < title.length; i++) {
//								int start = 0;
//								int end = 0;
//								if (i != title.length - 1) {
//									end = nodeHTML.indexOf(title[i + 1]);
//								} else end = nodeHTML.length();
//								start = nodeHTML.indexOf(title[i]) + title[i].length();
//								String value = nodeHTML.substring(start, end).trim();
//								if (value.length() == 0) value = " ";
//								string += value;
//								string += "````";
//							}
//						}
//						//stringBuilder.append(node.toHtml());
//					}
//					if (string.replaceAll(" ", "").replaceAll("`", "").length() != 0) {
//						string += url;
//						stringBuilder.append(string).append("\n");
//					}
//					httpURLConnection.disconnect();
//				}
//			} catch(Exception e) {
//				e.printStackTrace();
//				System.out.println(jj);
//			} finally {
//				try (FileWriter fw = new FileWriter("F:/data/new.txt");
//						BufferedWriter bw = new BufferedWriter(fw);) {
//						bw.write(stringBuilder.toString());
//					}   
//			}
			
			
			
			
//			String teamDetail = stringBuilder.substring(0, stringBuilder.indexOf("\n"));
//			teamDetail = teamDetail.substring("var teamDetail = [".length() + 1, teamDetail.length() - 2);
//			System.out.println(teamDetail);
			
//			NodeFilter tableFilter = new TagNameFilter("title");
//			NodeList titleNodes = parser.extractAllNodesThatMatch(tableFilter);
//			if (titleNodes.elementAt(0).toPlainTextString().trim().equals("无标题页")) {
//				System.out.println("---");
//			}
			
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
			
			try(FileInputStream fileInputStream = new FileInputStream(new File("F:/data/new1.txt"));
				InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
				BufferedReader br = new BufferedReader(inputStreamReader);) {
				
				StringBuilder stringBuilder = new StringBuilder();
				String s = null;

				while ((s = br.readLine())!=null) {
					
				}
				
				try (FileWriter fw = new FileWriter("F:/data/new2.txt");
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
