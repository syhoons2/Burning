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
import kr.co.koscom.marketdata.model.InputModel;
import kr.co.koscom.marketdata.model.Price;
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

		return "test_viewer";
	}

}

