package TTS.S2.S270000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;
import java.math.*;

public class TTS_270_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strNowTime = (String) actionAPI.getSessionData("m_strNowTime"); // 현재시간
		String m_strFrgTrd = (String) actionAPI.getSessionData("m_strFrgTrd"); //거래소 외국인매매
		String m_strAgcyTrd = (String) actionAPI.getSessionData("m_strAgcyTrd"); //거래소 기관매매
		String m_strGenTrd = (String) actionAPI.getSessionData("m_strGenTrd"); //거래소 일반매매
		String m_strFrgTrd1 = (String) actionAPI.getSessionData("m_strFrgTrd1"); //코스닥 외국인매매
		String m_strAgcyTrd1 = (String) actionAPI.getSessionData("m_strAgcyTrd1"); //코스닥 기관매매
		String m_strGenTrd1 = (String) actionAPI.getSessionData("m_strGenTrd1"); //코스닥 일반매매
		String m_strFrgTrd2 = (String) actionAPI.getSessionData("m_strFrgTrd2"); //선물동향 외국인매매
		String m_strAgcyTrd2 = (String) actionAPI.getSessionData("m_strAgcyTrd2"); //선물동향 기관매매
		String m_strGenTrd2 = (String) actionAPI.getSessionData("m_strGenTrd2"); //선물동향 일반매매
		String m_strFrgTrd3 = (String) actionAPI.getSessionData("m_strFrgTrd3"); //콜옵션동향 외국인매매
		String m_strAgcyTrd3 = (String) actionAPI.getSessionData("m_strAgcyTrd3"); //콜옵션동향 기관매매
		String m_strGenTrd3 = (String) actionAPI.getSessionData("m_strGenTrd3"); //콜옵션동향 일반매매
		String m_strFrgTrd4 = (String) actionAPI.getSessionData("m_strFrgTrd4"); //풋옵션동향 외국인매매
		String m_strAgcyTrd4 = (String) actionAPI.getSessionData("m_strAgcyTrd4"); //풋옵션동향 기관매매
		String m_strGenTrd4 = (String) actionAPI.getSessionData("m_strGenTrd4"); //풋옵션동향 일반매매	
		String m_strTotBidTot = (String) actionAPI.getSessionData("m_strTotBidTot");	
		String m_strTotBidTot1 = (String) actionAPI.getSessionData("m_strTotBidTot1");//프로그램 코스닥 
		
		m_strTotBidTot = trimNum(m_strTotBidTot);
		Float f_m_strTotBidTot = Float.parseFloat(m_strTotBidTot);
		if(m_strTotBidTot.startsWith("-")){
			m_strTotBidTot = m_strTotBidTot.substring(1);
		    }else{
		    	m_strTotBidTot = m_strTotBidTot;
		    }
		 long l_m_strTotBidTot = Long.parseLong(m_strTotBidTot) * 1000000;

		 m_strTotBidTot = String.valueOf(l_m_strTotBidTot);




		String yyyy = m_strNowTime.substring(0, 4);	//년
		String MM = m_strNowTime.substring(4, 6);	//월
		MM = trimNum(MM);
		String dd = m_strNowTime.substring(6, 8);	//일
		dd = trimNum(dd);
		String HH = m_strNowTime.substring(8, 10);	//시간
		HH = trimNum(HH);
		String mm = m_strNowTime.substring(10, 12);	//분
		mm = trimNum(mm);
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(yyyy).append(", 년, ")
		.append(MM).append(", 월, ")
		.append(dd).append(", 일, ")
		.append(HH).append("시, ")
		.append(mm).append(", 분, ")
		.append(", 현재, ");
		
		//[거래소 시장 외국인매매 연산] 
		m_strFrgTrd = trimNum(m_strFrgTrd);
		Float f_m_strFrgTrd = Float.parseFloat(m_strFrgTrd);
		if(m_strFrgTrd.startsWith("-")){
			m_strFrgTrd = m_strFrgTrd.substring(1);
		    }else{
		    	m_strFrgTrd = m_strFrgTrd;
		    }
		 long l_m_strFrgTrd = Long.parseLong(m_strFrgTrd) * 100000000;

		 m_strFrgTrd = String.valueOf(l_m_strFrgTrd);
		
		//[거래소 시장 기관매매 연산]
		 
		m_strAgcyTrd = trimNum(m_strAgcyTrd);
		Float f_m_strAgcyTrd = Float.parseFloat(m_strAgcyTrd);
		if(m_strAgcyTrd.startsWith("-")){
			m_strAgcyTrd = m_strAgcyTrd.substring(1);
		    }else{
		    	m_strAgcyTrd = m_strAgcyTrd;
		    }
		 long l_m_strAgcyTrd = Long.parseLong(m_strAgcyTrd) * 100000000;
		 m_strAgcyTrd = String.valueOf(l_m_strAgcyTrd);
	
			 
		//[거래소 시장 일반매매 연산]
		 m_strGenTrd = trimNum(m_strGenTrd);
		Float f_m_strGenTrd = Float.parseFloat(m_strGenTrd);
		if(m_strGenTrd.startsWith("-")){
			m_strGenTrd = m_strGenTrd.substring(1);
		    }else{
		    	m_strGenTrd = m_strGenTrd;
		    }
		 long l_m_strGenTrd = Long.parseLong(m_strGenTrd) * 100000000;
		 m_strGenTrd = String.valueOf(l_m_strGenTrd);

		
		if(f_m_strFrgTrd > 0){			
			sb.append("거래소시장은, ")
			.append(", 외국인, ")
			.append(", 순매수, ")
			.append(m_strFrgTrd)
			.append(", 원, ");
		}else if(f_m_strFrgTrd < 0){
			sb.append("거래소시장은, ")
			.append(", 외국인, ")
			.append(", 순매도, ")
			.append(m_strFrgTrd)
			.append(", 원, ");
		}else{
			sb.append("거래소시장은, ")
			.append(", 외국인, ")
			.append(m_strFrgTrd)
			.append(", 원, ");
		}
				
		if(f_m_strAgcyTrd > 0){
			sb.append("기관, ")
			.append(", 순매수, ")
			.append(m_strAgcyTrd)
			.append(", 원, ");
		}else if(f_m_strAgcyTrd < 0){
			sb.append("기관, ")
			.append(", 순매도, ")
			.append(m_strAgcyTrd)
			.append(", 원, ");
		}else{
			sb.append("기관, ")
			.append(m_strAgcyTrd)
			.append(", 원, ");
		}
		if(f_m_strGenTrd > 0){
			sb.append("개인, ")
			.append(", 순매수, ")
			.append(m_strGenTrd)
			.append(", 원, ")
			.append(", 이며, ");
		}else if(f_m_strGenTrd < 0){
			sb.append("개인, ")
			.append(", 순매도, ")
			.append(m_strGenTrd)
			.append(", 원, ")
			.append(", 이며, ");
		}else{
			sb.append("개인, ")
			.append(m_strGenTrd)
			.append(", 원, ")
			.append(", 이며, ");
		}
		
		
		//[거래소 시장 외국인매매 연산] 
		m_strFrgTrd1 = trimNum(m_strFrgTrd1);
		Float f_m_strFrgTrd1 = Float.parseFloat(m_strFrgTrd1);
		if(m_strFrgTrd1.startsWith("-")){
			m_strFrgTrd1 = m_strFrgTrd1.substring(1);
		    }else{
		    	m_strFrgTrd1 = m_strFrgTrd1;
		    }
		 long l_m_strFrgTrd1 = Long.parseLong(m_strFrgTrd1) * 100000000;

		 m_strFrgTrd1 = String.valueOf(l_m_strFrgTrd1);
		
		//[거래소 시장 기관매매 연산]
		 
		m_strAgcyTrd1 = trimNum(m_strAgcyTrd1);
		Float f_m_strAgcyTrd1 = Float.parseFloat(m_strAgcyTrd1);
		if(m_strAgcyTrd1.startsWith("-")){
			m_strAgcyTrd1 = m_strAgcyTrd1.substring(1);
		    }else{
		    	m_strAgcyTrd1 = m_strAgcyTrd1;
		    }
		 long l_m_strAgcyTrd1 = Long.parseLong(m_strAgcyTrd1) * 100000000;
		 m_strAgcyTrd1 = String.valueOf(l_m_strAgcyTrd1);
	
			 
		//[거래소 시장 일반매매 연산]
		m_strGenTrd1 = trimNum(m_strGenTrd1);
		Float f_m_strGenTrd1 = Float.parseFloat(m_strGenTrd1);
		if(m_strGenTrd1.startsWith("-")){
			m_strGenTrd1 = m_strGenTrd1.substring(1);
		    }else{
		    	m_strGenTrd1 = m_strGenTrd1;
		    }
		 long l_m_strGenTrd1 = Long.parseLong(m_strGenTrd1) * 100000000;
		 m_strGenTrd1 = String.valueOf(l_m_strGenTrd1);
		
		
		if(f_m_strFrgTrd1 > 0){
			sb.append("코스닥 시장은, ")
			.append(", 외국인, ")
			.append(", 순매수, ")
			.append(m_strFrgTrd1)
			.append(", 원, ");
		}else if(f_m_strFrgTrd1 < 0){
			sb.append("코스닥 시장은, ")
			.append(", 외국인, ")
			.append(", 순매도, ")
			.append(m_strFrgTrd1)
			.append(", 원, ");
		}else{
			sb.append("코스닥 시장은, ")
			.append(", 외국인, ")
			.append(m_strFrgTrd1)
			.append(", 원, ");
		}
				
		if(f_m_strAgcyTrd1 > 0){
			sb.append("기관, ")
			.append(", 순매수, ")
			.append(m_strAgcyTrd1)
			.append(", 원, ");
		}else if(f_m_strAgcyTrd1 < 0){
			sb.append("기관, ")
			.append(", 순매도, ")
			.append(m_strAgcyTrd1)
			.append(", 원, ");
		}else{
			sb.append("기관, ")
			.append(m_strAgcyTrd1)
			.append(", 원, ");
		}
		if(f_m_strGenTrd1 > 0){
			sb.append("개인, ")
			.append(", 순매수, ")
			.append(m_strGenTrd1)
			.append(", 원, ")
			.append(", 입니다., ");
		}else if(f_m_strGenTrd1 < 0){
			sb.append("개인, ")
			.append(", 순매도, ")
			.append(m_strGenTrd1)
			.append(", 원, ")
			.append(", 입니다., ");
		}else{
			sb.append("개인, ")
			.append(m_strGenTrd1)
			.append(", 원 입니다., ")
			.append(", 이며, ");
		}
		
		//[거래소 시장 외국인매매 연산] 
		m_strFrgTrd2 = trimNum(m_strFrgTrd2);
		Float f_m_strFrgTrd2 = Float.parseFloat(m_strFrgTrd2);
		if(m_strFrgTrd2.startsWith("-")){
			m_strFrgTrd2 = m_strFrgTrd2.substring(1);
		    }else{
		    	m_strFrgTrd2 = m_strFrgTrd2;
		    }
		 long l_m_strFrgTrd2 = Long.parseLong(m_strFrgTrd2) * 1000000;

		 m_strFrgTrd2 = String.valueOf(l_m_strFrgTrd2);
		
		//[거래소 시장 기관매매 연산]
		m_strAgcyTrd2 = trimNum(m_strAgcyTrd2);
		Float f_m_strAgcyTrd2 = Float.parseFloat(m_strAgcyTrd2);
		if(m_strAgcyTrd2.startsWith("-")){
			m_strAgcyTrd2 = m_strAgcyTrd2.substring(1);
		    }else{
		    	m_strAgcyTrd2 = m_strAgcyTrd2;
		    }
		 long l_m_strAgcyTrd2 = Long.parseLong(m_strAgcyTrd2) * 1000000;
		 m_strAgcyTrd2 = String.valueOf(l_m_strAgcyTrd2);
	
			 
		//[거래소 시장 일반매매 연산]
		m_strGenTrd2 = trimNum(m_strGenTrd2);
		Float f_m_strGenTrd2 = Float.parseFloat(m_strGenTrd2);
		if(m_strGenTrd2.startsWith("-")){
			m_strGenTrd2 = m_strGenTrd2.substring(1);
		    }else{
		    	m_strGenTrd2 = m_strGenTrd2;
		    }
		 long l_m_strGenTrd2 = Long.parseLong(m_strGenTrd2) * 1000000;
		 m_strGenTrd2 = String.valueOf(l_m_strGenTrd2);		

		if(f_m_strFrgTrd2 > 0){
			sb.append("선물 동향은, ")
			.append(", 외국인, ")
			.append(", 순매수, ")
			.append(m_strFrgTrd2).append(", , ")
			.append(", 원, ");
		}else if(f_m_strFrgTrd2 < 0){
			sb.append("선물 동향은, ")
			.append(", 외국인, ")
			.append(", 순매도, ")
			.append(m_strFrgTrd2).append(", , ")
			.append(", 원, ");
		}else{
			sb.append("선물 동향은, ")
			.append(", 외국인, ")
			.append(m_strFrgTrd2).append(", , ")
			.append(", 원, ");
		}
		
		if(f_m_strAgcyTrd2 > 0){
			sb.append("기관, ")
			.append(", 순매수, ")
			.append(m_strAgcyTrd2).append(", , ")
			.append(", 원, ");
		}else if(f_m_strAgcyTrd2 < 0){
			sb.append("기관, ")
			.append(", 순매도, ")
			.append(m_strAgcyTrd2).append(", , ")
			.append(", 원, ");
		}else{
			sb.append("기관, ")
			.append(m_strAgcyTrd2).append(", , ")
			.append(", 원, ");
		}

		if(f_m_strGenTrd2 > 0){
			sb.append("개인, ")
			.append(", 순매수, ")
			.append(m_strGenTrd2).append(", , ")
			.append(", 원, ")
			.append(", 이며, ");
		}else if(f_m_strGenTrd2 < 0){
			sb.append("개인, ")
			.append(", 순매도, ")
			.append(m_strGenTrd2).append(", , ")
			.append(", 원, ")
			.append(", 이며, ");
		}else{
			sb.append("개인, ")
			.append(m_strGenTrd2).append(", , ")
			.append(", 원, ")
			.append(", 이며, ");
		}	
		
		//[거래소 시장 외국인매매 연산] 
		m_strFrgTrd3 = trimNum(m_strFrgTrd3);
		Float f_m_strFrgTrd3 = Float.parseFloat(m_strFrgTrd3);
		if(m_strFrgTrd3.startsWith("-")){
			m_strFrgTrd3 = m_strFrgTrd3.substring(1);
		    }else{
		    	m_strFrgTrd3 = m_strFrgTrd3;
		    }
		 long l_m_strFrgTrd3 = Long.parseLong(m_strFrgTrd3) * 1000000;

		 m_strFrgTrd3 = String.valueOf(l_m_strFrgTrd3);
		
		//[거래소 시장 기관매매 연산]
		m_strAgcyTrd3 = trimNum(m_strAgcyTrd3);
		Float f_m_strAgcyTrd3 = Float.parseFloat(m_strAgcyTrd3);
		if(m_strAgcyTrd3.startsWith("-")){
			m_strAgcyTrd3 = m_strAgcyTrd3.substring(1);
		    }else{
		    	m_strAgcyTrd3 = m_strAgcyTrd3;
		    }
		 long l_m_strAgcyTrd3 = Long.parseLong(m_strAgcyTrd3) * 1000000;
		 m_strAgcyTrd3 = String.valueOf(l_m_strAgcyTrd3);
	
			 
		//[거래소 시장 일반매매 연산]
		m_strGenTrd3 = trimNum(m_strGenTrd3);
		Float f_m_strGenTrd3 = Float.parseFloat(m_strGenTrd3);
		if(m_strGenTrd3.startsWith("-")){
			m_strGenTrd3 = m_strGenTrd3.substring(1);
		    }else{
		    	m_strGenTrd3 = m_strGenTrd3;
		    }
		 long l_m_strGenTrd3 = Long.parseLong(m_strGenTrd3) * 1000000;
		 m_strGenTrd3 = String.valueOf(l_m_strGenTrd3);	
		
		
		if(f_m_strFrgTrd3 > 0){
			sb.append("콜옵션 동향은, ")
			.append(", 외국인, ")
			.append(", 순매수, ")
			.append(m_strFrgTrd3)
			.append(", 원, ");
		}else if(f_m_strFrgTrd3 < 0){
			sb.append("콜옵션 동향은, ")
			.append(", 외국인, ")
			.append(", 순매도, ")
			.append(m_strFrgTrd3)
			.append(", 원, ");
		}else{
			sb.append("콜옵션 동향은, ")
			.append(", 외국인, ")
			.append(m_strFrgTrd3)
			.append(", 원, ");
		}
		
		if(f_m_strAgcyTrd3 > 0){
			sb.append("기관, ")
			.append(", 순매수, ")
			.append(m_strAgcyTrd3)
			.append(",원,");
		}else if(f_m_strAgcyTrd3 < 0){
			sb.append("기관, ")
			.append(", 순매도, ")
			.append(m_strAgcyTrd3)
			.append(",원,");
		}else{
			sb.append("기관, ")
			.append(m_strAgcyTrd3)
			.append(",원,");
		}

		if(f_m_strGenTrd3 > 0){
			sb.append("개인, ")
			.append(", 순매수, ")
			.append(m_strGenTrd3)
			.append(",원,")
			.append(",이며,");
		}else if(f_m_strGenTrd3 < 0){
			sb.append("개인, ")
			.append(", 순매도, ")
			.append(m_strGenTrd3)
			.append(",원,")
			.append(",이며,");
		}else{
			sb.append("개인, ")
			.append(m_strGenTrd3)
			.append(",원,")
			.append(",이며,");
		}
		
		//[거래소 시장 외국인매매 연산] 
		m_strFrgTrd4 = trimNum(m_strFrgTrd4);
		Float f_m_strFrgTrd4 = Float.parseFloat(m_strFrgTrd4);
		if(m_strFrgTrd4.startsWith("-")){
			m_strFrgTrd4 = m_strFrgTrd4.substring(1);
		    }else{
		    	m_strFrgTrd4 = m_strFrgTrd4;
		    }
		 long l_m_strFrgTrd4 = Long.parseLong(m_strFrgTrd4) * 1000000;

		 m_strFrgTrd4 = String.valueOf(l_m_strFrgTrd4);
		
		//[거래소 시장 기관매매 연산]
		m_strAgcyTrd4 = trimNum(m_strAgcyTrd4);
		Float f_m_strAgcyTrd4 = Float.parseFloat(m_strAgcyTrd4);
		if(m_strAgcyTrd4.startsWith("-")){
			m_strAgcyTrd4 = m_strAgcyTrd4.substring(1);
		    }else{
		    	m_strAgcyTrd4 = m_strAgcyTrd4;
		    }
		 long l_m_strAgcyTrd4 = Long.parseLong(m_strAgcyTrd4) * 1000000;
		 m_strAgcyTrd4 = String.valueOf(l_m_strAgcyTrd4);
	
			 
		//[거래소 시장 일반매매 연산]
		m_strGenTrd4 = trimNum(m_strGenTrd4);
		Float f_m_strGenTrd4 = Float.parseFloat(m_strGenTrd4);
		if(m_strGenTrd4.startsWith("-")){
			m_strGenTrd4 = m_strGenTrd4.substring(1);
		    }else{
		    	m_strGenTrd4 = m_strGenTrd4;
		    }
		 long l_m_strGenTrd4 = Long.parseLong(m_strGenTrd4) * 1000000;
		 m_strGenTrd4 = String.valueOf(l_m_strGenTrd4);	

		if(f_m_strFrgTrd4 > 0){
			sb.append("풋옵션 동향은, ")
			.append(", 외국인, ")
			.append(", 순매수, ")
			.append(m_strFrgTrd4)
			.append(", 원, ");
		}else if(f_m_strFrgTrd4 < 0){
			sb.append("풋옵션 동향은, ")
			.append(", 외국인, ")
			.append(", 순매도, ")
			.append(m_strFrgTrd4)
			.append(", 원, ");
		}else{
			sb.append("풋옵션 동향은, ")
			.append(", 외국인, ")
			.append(m_strFrgTrd4)
			.append(", 원, ");
		}
		
		if(f_m_strAgcyTrd4 > 0){
			sb.append("기관, ")
			.append(", 순매수, ")
			.append(m_strAgcyTrd4)
			.append(", 원, ");
		}else if(f_m_strAgcyTrd4 < 0){
			sb.append("기관, ")
			.append(", 순매도, ")
			.append(m_strAgcyTrd4)
			.append(", 원, ");
		}else{
			sb.append("기관, ")
			.append(m_strAgcyTrd4)
			.append(", 원, ");
		}

		if(f_m_strGenTrd4 > 0){
			sb.append("개인, ")
			.append(", 순매수, ")
			.append(m_strGenTrd4)
			.append(", 원, ")
			.append(", 이며, ");
		}else if(f_m_strGenTrd4 < 0){
			sb.append("개인, ")
			.append(", 순매도, ")
			.append(m_strGenTrd4)
			.append(", 원, ")
			.append(", 이며, ");
		}else{
			sb.append("개인, ")
			.append(m_strGenTrd4)
			.append(", 원, ")
			.append(", 이며, ");
		}
		
		
		 
		
		
		if(f_m_strTotBidTot > 0){
			sb.append("프로그램 매매동향은, ")
			.append(", 거래소, ")
			.append(", 순매수, ")
			.append(m_strTotBidTot)
			.append(", 원, ");
		}else if(f_m_strTotBidTot < 0){
			sb.append("프로그램 매매동향은, ")
			.append(", 거래소, ")
			.append(", 순매도, ")
			.append(m_strTotBidTot)
			.append(", 원, ");
		}else{
			sb.append("프로그램 매매동향은, ")
			.append(", 거래소, ")
			.append(m_strTotBidTot)
			.append(", 원, ");
		}
		
		if(f_m_strAgcyTrd > 0){
			sb.append("코스닥, ")
			.append(", 순매수, ")
			.append(m_strAgcyTrd)
			.append(", 원, ")
			.append(", 입니다. ");
		}else if(f_m_strAgcyTrd < 0){
			sb.append("코스닥, ")
			.append(", 순매도, ")
			.append(m_strAgcyTrd)
			.append(", 원, ")
			.append(", 입니다. ");
		}else{
			sb.append("코스닥, ")
			.append(m_strAgcyTrd)
			.append(", 원, ")
			.append(", 입니다. ");
		}		
		
		
		
		
		actionAPI.setSessionData("ment", sb.toString());
	}
	
	private String convertHour(String HH) {
		// TODO Auto-generated method stub
		if(HH == null || HH.isEmpty()) {
			return "";
		}
		
		int time = Integer.parseInt(HH);
		if(time <= 12){
			return HH;
		}
		
		time = time - 12;
		
		switch (time) {
		case 1:
			HH = "한시";
			break;
		case 2: 
			HH = "두시";
			break;
		case 3:
			HH = "세시";
			break;
		case 4:
			HH = "네시";
			break;
		case 5:
			HH = "다섯시";
			break;
		case 6:
			HH = "여섯시";
			break;
		case 7:
			HH = "일곱시";
			break;
		case 8:
			HH = "여덟시";
			break;
		case 9:
			HH = "아홉시";
			break;
		case 10:
			HH = "열시";
			break;
		case 11:
			HH = "열한시";
			break;
		case 12:
			HH = "열두시";
			break;
		default:
			break;
		}
		
		return HH;
	}
	
	
	private String trimNum(String num) {
		if(num == null) return "0";

		boolean isMinus = false;
		String result = "";

		if(num.startsWith("-")) {
			num = num.substring(1);
			isMinus = true;
		}

		int index = num.indexOf(".");

		if (index == -1) {
			for (int i = 0; i < num.length(); i++) {
				if (!num.substring(i, i + 1).equals("0")) {
					result = num.substring(i);
					break;
				}
			}

		} else {

			String temp1 = num.substring(0, index);
			String temp2 = num.substring(index + 1, num.length());

			for (int i = 0; i < temp1.length(); i++) {
				if (!temp1.substring(i, i + 1).equals("0")) {
					result = temp1.substring(i);
					break;
				}
			}

			String result2 = "";
			for (int i = temp2.length(); i > 0; i--) {
				if (!temp2.substring(i - 1, i).equals("0")) {
					result2 = temp2.substring(0, i);
					break;
				}
			}
			if (result2.length() != 0) {
				result = result + "." + result2;
			}

		}
		if(result.isEmpty()) {
			return "0";
		}

		if(result.startsWith("."))
			result  = "0" + result;

		if(isMinus){
			result = "-" + result;
		}

		return result;
	}
}
