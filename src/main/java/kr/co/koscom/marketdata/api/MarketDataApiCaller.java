package kr.co.koscom.marketdata.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.koscom.marketdata.model.InputModel;
import kr.co.koscom.marketdata.model.Price;
import kr.co.koscom.marketdata.util.HttpClientUtil;

@Component
public class MarketDataApiCaller {

	private static String URI_PREFIX = "https://sandbox-apigw.koscom.co.kr/v2/market/stocks/kospi/";
	private static String URI_POSTFIX = "/price";
	
	private static String APIKEY = "l7xxabca7d33dacd45b385e33cc8f2857896";
	
	@Autowired
	private HttpClientUtil httpClientUtil;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public Price getPrice(InputModel inputdata) {
		
		try {
			String jsonStr = httpClientUtil.execute(URI_PREFIX + inputdata.getIssue_code() + URI_POSTFIX + "?apikey=" + APIKEY);
			JsonNode node = objectMapper.readTree(jsonStr);
			
			Price price = objectMapper.readValue(node.findValue("result").toString(), Price.class);
			
			return price;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
