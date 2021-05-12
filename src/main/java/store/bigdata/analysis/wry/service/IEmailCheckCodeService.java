package store.bigdata.analysis.wry.service;

public interface IEmailCheckCodeService {


	public boolean checkCodeTime(long localTime, long beforeEmailCodeTime,int seconde);

}
