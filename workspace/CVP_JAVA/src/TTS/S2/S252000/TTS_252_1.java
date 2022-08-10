package TTS.S2.S252000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_252_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strGiftYear = (String) actionAPI.getSessionData("m_strGiftYear"); //년 
		String m_strGiftItemCode = (String) actionAPI.getSessionData("m_strGiftItemCode"); //월
		String month = m_strGiftItemCode.substring(1, 3);
		String m_strGiftStrikePrice = (String) actionAPI.getSessionData("m_strGiftStrikePrice"); //행사가격
		String m_strGiftPrevAmt = (String) actionAPI.getSessionData("m_strGiftPrevAmt"); //콜옵션 전일종가
		
		if(m_strGiftStrikePrice != null && !m_strGiftStrikePrice.isEmpty()){
			// 소수점 자리수를 가져온다. 
			int strDotIndex = m_strGiftStrikePrice.indexOf(".");
			// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
			String strDotLeft = m_strGiftStrikePrice.substring(0, strDotIndex);
			// 앞에 0이 있으면 없앤다.
			strDotLeft = trimNum(strDotLeft);
			// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
			String strDotRight = m_strGiftStrikePrice.substring(strDotIndex+1);

		
		if(m_strGiftPrevAmt != null && !m_strGiftPrevAmt.isEmpty()){
				// 소수점 자리수를 가져온다. 
			int strDotIndex1 = m_strGiftPrevAmt.indexOf(".");
				// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
			String strDotLeft1 = m_strGiftPrevAmt.substring(0, strDotIndex1);
				// 앞에 0이 있으면 없앤다.
			strDotLeft1 = trimNum(strDotLeft1);
				// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
			String strDotRight1 = m_strGiftPrevAmt.substring(strDotIndex1+1);

			
			
			
			StringBuffer sb = new StringBuffer();
			
			sb.append(", 코스피 200 , ").append(m_strGiftYear).append(", , ").append(", 년 , ")
			.append(month).append(", , ").append(", 월 , ")
			.append(", 물, ")
			.append(", 행사가격, ")
			.append(strDotLeft).append(", , ").append(" , 쩜 , [")
			.append(strDotRight).append("], , ").append(" , 풋옵션 , ").append(" , 전일종가는 , ").append(strDotLeft1).append(", , ").append(" , 쩜 , [").append(strDotRight1)
			.append("], , ").append(" , 포인트 입니다. ");
			
			actionAPI.setSessionData("ment", sb.toString());
		}else{
			actionAPI.setSessionData("ment", "error");
		}
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
