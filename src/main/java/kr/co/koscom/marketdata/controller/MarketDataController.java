package kr.co.koscom.marketdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MarketDataController {
	
    @RequestMapping(path = "/greeting")
    public @ResponseBody String greeting() {
        return "Welcome to burning day~ (a.k.a HELL)";
    }

}
