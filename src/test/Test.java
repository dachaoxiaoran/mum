package test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;

import com.mum.utils.PropertiesUtil;

import static com.mum.constant.IConstant.*;

public class Test {
	public static void main(String[] args) {
		try {
			LocalDate beginDate = LocalDate.parse(PropertiesUtil.get(BEGIN_DATE));
			LocalDate endDate =  LocalDate.now().minusDays(2);

			while(!beginDate.isEqual(endDate)) {
				HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(String.format(HISTORY_URL, beginDate))).openConnection();
				httpURLConnection.connect();
				Parser parser = new Parser(httpURLConnection);
				NodeFilter tableFilter = new TagNameFilter(TABLE);
	            NodeList tableNodes = parser.extractAllNodesThatMatch(tableFilter);
	            Node tableNode = tableNodes.elementAt(tableNodes.size() - 1);
	            
	            nodeHandler(tableNode, new Integer(0));
	            
	            httpURLConnection.disconnect();
	            beginDate = beginDate.plusDays(1);
	            PropertiesUtil.set(BEGIN_DATE, beginDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
	            break;
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
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
