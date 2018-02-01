package kr.co.koscom.marketdata.api;

import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.koscom.marketdata.calc.AlphabetSplit;
import kr.co.koscom.marketdata.model.InputModel;
import kr.co.koscom.marketdata.model.Master;
import kr.co.koscom.marketdata.model.Price;
import kr.co.koscom.marketdata.model.Trend;
import kr.co.koscom.marketdata.util.HttpClientUtil;

@Component
public class MarketDataApiCaller {

	private static String URI_PREFIX = "https://sandbox-apigw.koscom.co.kr/v2/market/stocks/kospi/";

	private static String APIKEY = "l7xxabca7d33dacd45b385e33cc8f2857896";

	@Autowired
	private HttpClientUtil httpClientUtil;

	private ObjectMapper objectMapper = new ObjectMapper();

	public Price getPrice(InputModel inputdata) {

		try {
			String jsonStr = httpClientUtil
					.execute(URI_PREFIX + inputdata.getIssue_code() + "/price" + "?apikey=" + APIKEY);
			JsonNode node = objectMapper.readTree(jsonStr);

			Price price = objectMapper.readValue(node.findValue("result").toString(), Price.class);
			AlphabetSplit split = new AlphabetSplit();
			split.nameSplit(inputdata.getName());
			return price;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Master getMaster(InputModel inputdata) {

		try {
			String jsonStr = httpClientUtil
					.execute(URI_PREFIX + inputdata.getIssue_code() + "/master" + "?apikey=" + APIKEY);
			JsonNode node = objectMapper.readTree(jsonStr);

			Master master = objectMapper.readValue(node.findValue("result").toString(), Master.class);
			return master;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Trend getTrend(InputModel inputdata) {

		try {
			String jsonStr = httpClientUtil.execute(
					"https://sandbox-apigw.koscom.co.kr/v1/haystack/news,snek/politics,economy,society,culture,world,tech,opinion/_trends?query="
							+ URLEncoder.encode(inputdata.getKeyword(), "UTF-8")
							+ "&interval=1y&from=20170101&to=20171231&apikey=" + APIKEY);

			JsonNode root = objectMapper.readTree(jsonStr);
			// https://sandbox-apigw.koscom.co.kr/v1/haystack/news,snek/politics,economy,society,culture,world,tech,opinion/_trends?query=북한
			// 핵실험&interval=1y&from=20170101&to=20171231&apikey=
			// "https://sandbox-apigw.koscom.co.kr/v1/haystack/news,snek/politics,economy,society,culture,world,tech,opinion/_trends?query="
			// + inputdata.getKeyword() +
			// "&interval=1y&from=20170101&to=20171231&apikey=" + APIKEY
			// 울

			Trend trend = new Trend();
			trend.setCount("");
			trend.setValue("");
			JsonNode trend_data = root.path("data");
			if (trend_data.isMissingNode()) {
				System.out.println("err1");
				return trend;
			}
			JsonNode trend_data_trends = trend_data.path("trends");
			if (trend_data_trends.isMissingNode()) {
				System.out.println("err2");
				return trend;
			}
			JsonNode trend_data_trends_buckets = trend_data_trends.get(0).path("buckets");
			if (trend_data_trends_buckets.isMissingNode()) {
				System.out.println("err3");
				return trend;
			}
			trend.setCount(trend_data_trends_buckets.get(0).path("count").asText());
			trend.setValue(trend_data_trends_buckets.get(0).path("value").asText());

			return trend;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
