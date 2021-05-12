package store.bigdata.analysis.wry.service;

import java.util.List;

import store.bigdata.analysis.wry.pojo.BossBiPojo;
import store.bigdata.analysis.wry.pojo.BossBiPojoFromAddr;
import store.bigdata.analysis.wry.pojo.WeiBoGenderPojo;
import store.bigdata.analysis.wry.pojo.WeiBoPojo;
import store.bigdata.analysis.wry.pojo.bossPojo;



public interface WeiBoBIDataService {
	public  List<WeiBoPojo> WeiBofindAll();
	public  List<WeiBoPojo> WeiBofindByF();
	public  List<WeiBoPojo> WeiBofindByM();
	public  List<WeiBoGenderPojo> WeiBofindGender();
	public  List<WeiBoGenderPojo> WeiBoGroupByDate();
	public  List<store.bigdata.analysis.wry.pojo.WeiBoGenderPojo> WeiFindAll();
	public  List<store.bigdata.analysis.wry.pojo.WeiBoGenderPojo> WeiBoTextLike(String str);
}

