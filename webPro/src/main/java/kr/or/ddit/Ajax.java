package kr.or.ddit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/Ajax")
public class Ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ajax() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rst = request.getParameter("sendKey");
		System.out.println("요청정보 >>>> " + rst);
		
		response.setCharacterEncoding("UTF-8");
		
		// PrintWriter: 서블릿으로 들어온 요청을 테스트 형태로 응답하기 위한 출력 스트림
		// write()는 인수를 단일 문자로 해석한다.
		// print()는 인수를 문자열로 변환한다.
		PrintWriter writer = response.getWriter();
//		writer.write("응답정보를 보낸다... " + rst); // 요청 위치로 응답 전달
		
		writer.write("{\"name\":\"" + rst + "\"}"); // 응답정보를 JSON형식으로 전달
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("post입장>>>>>>>>>>>>>>>>>>");
		request.setCharacterEncoding("UTF-8");
//		String param = request.getParameter("sendKey"); // url인코딩 형식 데이터만
		
		//json 데이터 확인하기
		BufferedReader rd = request.getReader();
		String result = rd.readLine();
		System.out.println("요청이 들어왔다>>>>>>>>>>>>" + result);
		
		//GSON사용 json => 객체 변환
		JsonParser parser = new JsonParser();
		JsonObject parse = (JsonObject) parser.parse(result);
		
//		String dataA = parse.get("a").getAsString();
//		String dataC = parse.get("c").getAsString();
//		System.out.println(dataA + ", " + dataC);
		
		String yj = parse.get("yujin").getAsString();
		System.out.println("응답>>" + yj);
		
		
		response.setCharacterEncoding("UTF-8");
//		response.getWriter().print("응답 받아라" + param);
		response.getWriter().print("응답 받으슈>> " + yj); // 요청위치로 응답 전달
		
	}

}
