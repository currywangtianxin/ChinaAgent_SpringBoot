package store.bigdata.analysis.wry.contollor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minidev.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import store.bigdata.analysis.wry.pojo.BiPojo;
import store.bigdata.analysis.wry.pojo.BossBiPojo;
import store.bigdata.analysis.wry.pojo.HbasePojo;
import store.bigdata.analysis.wry.pojo.WeiBoGenderPojo;
import store.bigdata.analysis.wry.pojo.WeiBoPojo;
import store.bigdata.analysis.wry.service.WeiBoBIDataService;

@Controller
public class WeiBoAnalysisControllor {
	@Autowired(required = false)
	WeiBoBIDataService boss;
	
	@RequestMapping("/weibofindAll")
	public String findAll(Model model) {
		List<WeiBoPojo> list =boss.WeiBofindAll();
		
		
		JSONObject jo=new JSONObject();
		JSONArray arr=new JSONArray();
		JSONArray arr2=new JSONArray();
			for (WeiBoPojo bossBiPojo : list) {
				arr.add(bossBiPojo.getScore());
				arr2.add(bossBiPojo.getSource());
		}
			jo.put("number", arr);
			jo.put("addr", arr2);
			model.addAttribute("data",jo);
		return "/BI/WeiBoSource_All";
	}
	

	@RequestMapping("/weibofindByF")
	public String bossFindByJobNameListData(Model model) {
		List<WeiBoPojo> list =boss.WeiBofindByF();
	
		
		JSONObject jo=new JSONObject();
		JSONArray arr=new JSONArray();
		JSONArray arr2=new JSONArray();
			for (WeiBoPojo bossBiPojo : list) {
				arr.add(bossBiPojo.getScore());
				arr2.add(bossBiPojo.getSource());
		}
			jo.put("number", arr);
			jo.put("addr", arr2);
			model.addAttribute("data",jo);
		return "/BI/WeiBoSource_F";	}
	
	@RequestMapping("/weibofindByM")
	public String findByM(Model model) {
		List<WeiBoPojo> list =boss.WeiBofindByM();

		JSONObject jo=new JSONObject();
		JSONArray arr=new JSONArray();
		JSONArray arr2=new JSONArray();
			for (WeiBoPojo bossBiPojo : list) {
				arr.add(bossBiPojo.getScore());
				arr2.add(bossBiPojo.getSource());
		}
			jo.put("number", arr);
			jo.put("addr", arr2);
			model.addAttribute("data",jo);
		return "/BI/WeiBoSource_M";		}
	

	@RequestMapping("/weibofindGendery")
	public String weibofindGendery(Model model) {

		List<WeiBoGenderPojo> json= new ArrayList<WeiBoGenderPojo>();
		Map<String, String> map=null;
		json=boss.WeiBofindGender();
		JSONArray arr=new JSONArray();
		String s;
		for (WeiBoGenderPojo bossBiPojo : json) {
			JSONObject jo=new JSONObject();
			if (bossBiPojo.getGender().trim().equalsIgnoreCase("f")) {
				 s="女";
			}else {
				 s="男";
			}
			jo.put("name", s);
			jo.put("value",bossBiPojo.getNum());

			arr.add(jo);
		}
		model.addAttribute("data",arr);

		return "/BI/WeiBoGender";
	
	
	}
	
	
	@RequestMapping("/WeiBoGroupByDate")
	public String WeiBoGroupByDate(Model model) {

		List<WeiBoGenderPojo> json= new ArrayList<WeiBoGenderPojo>();
		Map<String, String> map=null;
		json=boss.WeiBoGroupByDate();
		JSONArray arr=new JSONArray();
		JSONArray arr2=new JSONArray();
		JSONObject jo=new JSONObject();
		for (WeiBoGenderPojo hbasePojo : json) {
			   StringBuilder sb = new StringBuilder(hbasePojo.getGender());
			   arr.add(sb.replace(0, 4, "2021").toString());
			   arr2.add(hbasePojo.getNum());
			  }
		System.out.println(arr);
		System.out.println(arr2);
		jo.put("time", arr);
		jo.put("value", arr2);
		model.addAttribute("data", jo);
		return "/BI/WeiBoGroupByData";
	
	}
	
	
	@RequestMapping("WeiBoTextLike")
	public String WeiBoTextLike(Model model, String value) {
		System.out.println(value);
		model.addAttribute("users", boss.WeiBoTextLike(value));
		System.out.println("后端返回数据:"+boss.WeiBoTextLike(value));
		return "/jsp/user/user/list4Weibo" ;
	}
	
	@RequestMapping("WeiFindAll")
	public String WeiFindAll(Model model) {
		List<store.bigdata.analysis.wry.pojo.WeiBoGenderPojo>list=boss.WeiFindAll();
		model.addAttribute("users", boss.WeiFindAll());
		System.out.println("后端返回数据:"+boss.WeiFindAll().size());
		return "/jsp/user/user/list4Weibo" ;
	}
}
