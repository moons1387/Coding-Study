package kr.or.ddit.basic;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class T03DOMParsingExam {
	public void parse() throws SAXException, IOException, ParserConfigurationException {

		String svcKey = "Grid_20150827000000000227_1"; // 레시피 재료 정보 조회 서비스
		String apiKey = "1df7e8571e8df3f8cbc9b87691ca7d3e4d04f03c593d477e52bf67b03f0b6e1c"; // 개인별 발급.
		String startIdx = "1"; // 레시피 재료 시작 순번
		String endIdx = "5"; // 레시피 재료 종료 순번
		String recipeId = "195428"; // 래시피가 궁금한 음식 ID

		URL url = new URL("http://211.237.50.150:7080/openapi/" + apiKey + "/xml/" + svcKey + "/" + startIdx + "/"
				+ endIdx + "?RECIPE_ID=" + recipeId);

		// XML 문서를 생성하기 위한 DocumentBuilder 객체 생성하기
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();

		// Document 객체 생성하기
		Document document = db.parse(url.toString());

		// root 엘리먼트 생성
		Element root = document.getDocumentElement();
		System.out.println("root 태그명 : " + root.getTagName());

		// 전체 레시피 수 가져오기
		String totalCnt = root.getElementsByTagName("totalCnt").item(0).getTextContent();
		System.out.println("totalCnt : " + totalCnt);

		url = new URL("http://211.237.50.150:7080/openapi/" + apiKey + "/xml/" + svcKey + "/" + startIdx + "/"
				+ totalCnt + "?RECIPE_ID=" + recipeId);

		// Document 객체 생성하기
		document = db.parse(url.toString());

		// root 엘리먼트 생성
		root = document.getDocumentElement();

		////////////////////////////////////////////////////////////////////

		String code = root.getElementsByTagName("code").item(0).getTextContent();

		if (code.equals("INFO-000")) {
			NodeList rowNodeList = root.getElementsByTagName("row");
			
			System.out.println("----------------------------------------------------------------------------");
			System.out.printf("%3s %8s %10s %10s %8s\n", "순번", "레시피ID", "재료타입명", "재료명", "재료용량");
			System.out.println("----------------------------------------------------------------------------");

			for (int i = 0; i < rowNodeList.getLength(); i++) {
				Element row = (Element) rowNodeList.item(i);
				String rowNum = row.getElementsByTagName("ROW_NUM").item(0).getTextContent();
				String irdntNm = row.getElementsByTagName("IRDNT_NM").item(0).getTextContent();
				String irdntCpcty = row.getElementsByTagName("IRDNT_CPCTY").item(0).getTextContent();
				String irdntTyNm = row.getElementsByTagName("IRDNT_TY_NM").item(0).getTextContent();
				
				System.out.printf("%3s %8s %10s %10s %8s\n", rowNum, recipeId, irdntTyNm, irdntNm, irdntCpcty);
				
			}
			System.out.println("----------------------------------------------------------------------------");
		}
	}

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		new T03DOMParsingExam().parse();
	}
}
