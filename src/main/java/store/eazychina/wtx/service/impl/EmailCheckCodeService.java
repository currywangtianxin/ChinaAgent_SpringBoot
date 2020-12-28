package store.eazychina.wtx.service.impl;

import store.eazychina.wtx.service.IEmailCheckCodeService;


public class EmailCheckCodeService implements IEmailCheckCodeService{

	@Override
	public boolean checkCodeTime(long localTime,long beforeEmailCodeTime,int seconde) {
        long interval = (localTime-beforeEmailCodeTime)/1000;
        
        System.out.println("两次时间间隔:  "+interval+"秒" );
        
        if (interval>seconde) {
			return true;
		}
		return false;
	}
	

}
