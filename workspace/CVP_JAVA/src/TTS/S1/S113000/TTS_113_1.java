package TTS.S1.S113000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_113_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		//m_strStockPriceCurrentAmt : 현재지수 (소수점2자리)
		String m_strStockPriceCurrentAmt = (String) actionAPI.getSessionData("m_strStockPriceCurrentAmt");
		
		// m_strStockPriceCurrentAmt 의 값이 NULL 이나 비어있지 않으면, 
		if(m_strStockPriceCurrentAmt != null && !m_strStockPriceCurrentAmt.isEmpty()){
			// 소수점 자리수를 가져온다. 
			int strDotIndex = m_strStockPriceCurrentAmt.indexOf(".");
			// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
			String strDotLeft = m_strStockPriceCurrentAmt.substring(0, strDotIndex);
			// 앞에 0이 있으면 없앤다.
			strDotLeft = trimNum(strDotLeft);
			// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
			String strDotRight = m_strStockPriceCurrentAmt.substring(strDotIndex+1);
			
			
			//문자열을 저장할 StringBuffer 객체를 만든다. 
			StringBuffer sb = new StringBuffer();
			sb.append(", 전일 , 코스닥지수는, ").append(strDotLeft).append(", 쩜, [").append(strDotRight).append("], 포인트, 입니다.")
			.append(", 예상지수, 안내는, 여덟시, 삼십분, 부터 가능합니다., ");
			
			
			
			actionAPI.setSessionData("ment", sb.toString());
		}else {
			actionAPI.setSessionData("ment", "error");
		}
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
