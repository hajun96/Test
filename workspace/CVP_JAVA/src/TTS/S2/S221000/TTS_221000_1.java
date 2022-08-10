package TTS.S2.S221000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_221000_1 extends ActionElementBase{
	@Override
	public void doAction(String arg0, ActionElementData actionAPI)throws AudiumException {
		String m_strStockPriceCurrentAmt0 = (String) actionAPI.getSessionData("m_strStockPriceCurrentAmt0");	  //종합주가지수 현재가
		// [종합주가지수 현재가 계산]
		// 소수점 자리수를 가져온다. 
		int strCurrentDotIndex0 = m_strStockPriceCurrentAmt0.indexOf(".");
		// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
		String strCurrentDotLeft0 = m_strStockPriceCurrentAmt0.substring(0, strCurrentDotIndex0);
		// 앞에 0이 있으면 없앤다.
		strCurrentDotLeft0 = trimNum(strCurrentDotLeft0);
		// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
		String strCurrentDotRight0 = m_strStockPriceCurrentAmt0.substring(strCurrentDotIndex0+1);
		
		StringBuffer sb = new StringBuffer();
		
		if(m_strStockPriceCurrentAmt0.equals("0") || m_strStockPriceCurrentAmt0.equals("") || m_strStockPriceCurrentAmt0.equals(null)){
			sb.append(", 전일, ").append(", 종합주가, 지수는, ")
			.append(", 없습니다.");
		}else{
			sb.append(", 전일, ").append(", 종합주가, 지수는, ")
			.append(strCurrentDotLeft0).append(", 쩜 , [").append(strCurrentDotRight0).append("], 포인트  입니다.");
		}
		
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
