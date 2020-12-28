package store.eazychina.wtx.contollor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import store.eazychina.wtx.pojo.BiPojo;
import store.eazychina.wtx.service.BiService;


@Controller
public class BIController {
	@Autowired
	BiService biService;
					
	@RequestMapping("getBiDate")
	public String getBiList(Model model){
		List<BiPojo> json= new ArrayList<BiPojo>();
		Map<String, String> map=null;
		json=biService.findlist();
		List<Map<String, String>> json1= new ArrayList<Map<String, String>>();

		for (BiPojo biPojo : json) {
			map=new HashMap<String, String>();
			map.put("value",JSONObject.toJSONString(biPojo.getFreq()));
			map.put("name", JSONObject.toJSONString(biPojo.getWord()));
			json1.add(map);
		}
		model.addAttribute("data", json1);
		return "BI/wordCloud";
		
	}
}
