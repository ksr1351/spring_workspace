package part04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// http://localhost:8090/myapp/booksearch.do

@Controller
public class SearchDaumController {

	public SearchDaumController() {
		
	}
	
	@RequestMapping(value="/booksearch.do", method=RequestMethod.GET)
	public String form() {
		return "part04/form";
	}//end form()
	
	@ResponseBody
	@RequestMapping(value="/searchOpen.do", method=RequestMethod.GET)
	public String process(String query) throws MalformedURLException, IOException {
		/*
		 GET /v2/search/web HTTP/1.1
		 Host: dapi.kakao.com
		 Authorization: KakaoAK ${REST_API_KEY}
		*/
		String url = "https://dapi.kakao.com/v3/search/book?target=title&query="+URLEncoder.encode(query, "UTF-8");
		HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
		con.setRequestProperty("Authorization", "KakaoAK f5eb8a9eb5965d37432b0aadefc9f6a3");
		con.setRequestMethod("GET");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String input = null;
		String total = "";
		while((input = reader.readLine()) != null)
			total += input;
		
		System.out.println(total);
		return total;
	}//end process()
	
}//end class
