package store.bigdata.analysis.wry.contollor;

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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import store.bigdata.analysis.wry.pojo.BiPojo;
import store.bigdata.analysis.wry.pojo.BossBiPojo;
import store.bigdata.analysis.wry.service.BiService;


@Controller
public class BIController {
	@Autowired
	BiService biService;
		
	//词云图 所有词必须是字符串
	//把实体类转换为json格式  echarts需要json格式
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
	
	
	@RequestMapping("getBiListGroupByDaySeq")
	public String getBiListGroupByDaySeq(Model model){
		List<BiPojo> json= new ArrayList<BiPojo>();
		Map<String, String> map=null;
		json=biService.findlistgroupbydatseq();
		JSONObject jo=new JSONObject();
		JSONArray arr=new JSONArray();
		JSONArray arr2=new JSONArray();
			for (BiPojo biPojo : json) {
				StringBuilder sb = new StringBuilder(biPojo.getDay_seq());
			
				arr.add(biPojo.getFreq());
//				System.out.println(biPojo.getFreq()+"*********"+biPojo.getWord()+biPojo.getDay_seq());
				arr2.add("热词为:  "+biPojo.getWord()+"   时间为:  "+sb.replace(0, 4, "2021"));
		}
			jo.put("number", arr);

			jo.put("addr", arr2);
			model.addAttribute("data",jo);
		return "/BI/ciyuntu";
	}
}
