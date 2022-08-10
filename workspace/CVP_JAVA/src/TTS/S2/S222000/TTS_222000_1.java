package TTS.S2.S222000;


import java.util.Hashtable;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_222000_1 extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
		
		// TR 통신 후 결과값이 존재하는 Hashtable 을 가져온다.
		Hashtable table = (Hashtable) actionAPI.getSessionData("g_objHostRecv");
		StringBuffer sb = new StringBuffer();
		
		
		String m_strStockPriceCurrentAmt = (String) table.get("A1_Current3");
		
		int index = m_strStockPriceCurrentAmt.indexOf(".");
		
		String before = m_strStockPriceCurrentAmt.substring(0, index);
		String after = m_strStockPriceCurrentAmt.substring(index + 1, m_strStockPriceCurrentAmt.length() );
		
		
		before = trimNum(before);
		
		
		sb.append(", 전일,  ,코스닥 지수는,").append(before).append(", 쩜, [").append(after).append("] 포인트 입니다.");
		sb.append(", 예상지수 안내는, 8시 30분부터 가능합니다., ");
		
		
		// 멘트를 만들기 위한 String 데이터를 ment 라는 이름의 Session Data 로 저장한다.
		actionAPI.setSessionData("ment", sb.toString());
		
		
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
