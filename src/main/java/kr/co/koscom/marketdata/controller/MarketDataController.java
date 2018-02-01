package kr.co.koscom.marketdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.koscom.marketdata.api.MarketDataApiCaller;
import kr.co.koscom.marketdata.calc.AlphabetSplit;
import kr.co.koscom.marketdata.calc.Calculator;
import kr.co.koscom.marketdata.model.InputModel;
import kr.co.koscom.marketdata.model.Price;
import kr.co.koscom.marketdata.model.Trend;
import kr.co.koscom.marketdata.model.Master;

@Controller
public class MarketDataController {

	@Autowired
	private MarketDataApiCaller marketDataApiCaller;

	/*
	 * @RequestMapping(path = "/lovestock") public String lovestock() {
	 * 
	 * return "intro"; }
	 */

	@RequestMapping(value = "/lovestock_intro", method = RequestMethod.GET)
	public String sum_form(ModelMap modelMap) {
		// 도메일 객체 생성
		InputModel inputdata = new InputModel();

		// Model에 도메일 객체 전달
		modelMap.addAttribute("inputdata", inputdata);

		// 전달 할 jsp 페이지
		return "intro";
	}

	@RequestMapping(value = "/testinput", method = RequestMethod.POST)
	public String testinput(@ModelAttribute("inputdata") InputModel inputmodel, ModelMap modelMap) {
		modelMap.addAttribute("inputdata", inputmodel);
		modelMap.addAttribute("price", marketDataApiCaller.getPrice(inputmodel));
		modelMap.addAttribute("master", marketDataApiCaller.getMaster(inputmodel));
		modelMap.addAttribute("trend", marketDataApiCaller.getTrend(inputmodel));
		Price price = marketDataApiCaller.getPrice(inputmodel);
		Master master = marketDataApiCaller.getMaster(inputmodel);
		Trend trend = marketDataApiCaller.getTrend(inputmodel);
		
		double[] scores = new double[3];
		double[] bonus_scores = new double[1];
		
		Calculator cal = new Calculator();
		scores[0] = (cal.nameCal(cal.cutName(inputmodel.getName()), cal.cutName(master.getIsuKorAbbrv())) / 100.0); /* 0 <= nameCalval <= 1 */
		scores[1] = cal.score1(Integer.parseInt(master.getParval()), (int)price.getHgprc(), (int)price.getLwprc());
		scores[2] = cal.score2(Integer.parseInt(master.getPrevddClsprc()), (int)price.getOpnprc());
		bonus_scores[0] = cal.bonus_score1(Double.parseDouble(trend.getValue()), Integer.parseInt(trend.getCount()));

		double friendly_score = (int)(cal.friendly_score1(scores,  bonus_scores) * 1000) / 10.0;
		
		modelMap.addAttribute("friendly_score", friendly_score);
		
		modelMap.addAttribute("imageSrcPath", "../img/aa"+(int)(friendly_score/20 + 1) + ".png");
		
		modelMap.addAttribute("score0", scores[0]);
		modelMap.addAttribute("score1", scores[1]);
		modelMap.addAttribute("score2", scores[2]);
		modelMap.addAttribute("bonus_score0", bonus_scores[0]);
		
		return "test_viewer";
	}

}

