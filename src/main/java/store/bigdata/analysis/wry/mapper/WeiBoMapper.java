package store.bigdata.analysis.wry.mapper;

import java.util.List;



import org.apache.ibatis.annotations.Mapper;

import store.bigdata.analysis.wry.pojo.WeiBoGenderPojo;
import store.bigdata.analysis.wry.pojo.WeiBoPojo;
@Mapper
public interface WeiBoMapper {
	public  List<WeiBoPojo> WeiBofindAll();
	public  List<WeiBoPojo> WeiBofindByF();
	public  List<WeiBoPojo> WeiBofindByM();
	public  List<WeiBoGenderPojo> WeiBofindGender();
	public  List<WeiBoGenderPojo> WeiBoGroupByDate();
	public  List<store.bigdata.analysis.wry.pojo.WeiBoGenderPojo> WeiFindAll();
	public  List<store.bigdata.analysis.wry.pojo.WeiBoGenderPojo> WeiBoTextLike(String str);
}
