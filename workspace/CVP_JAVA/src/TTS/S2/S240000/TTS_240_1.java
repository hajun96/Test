package TTS.S2.S240000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_240_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strGiftYear = (String) actionAPI.getSessionData("m_strGiftYear"); //년 
		String m_strGiftItemCode = (String) actionAPI.getSessionData("m_strGiftItemCode"); //월
		String m_strGiftCurrentAmt = (String) actionAPI.getSessionData("m_strGiftCurrentAmt"); //전일종가
		
		if(m_strGiftCurrentAmt != null && !m_strGiftCurrentAmt.isEmpty()){
			// 소수점 자리수를 가져온다. 
			int strDotIndex = m_strGiftCurrentAmt.indexOf(".");
			// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
			String strDotLeft = m_strGiftCurrentAmt.substring(0, strDotIndex);
			// 앞에 0이 있으면 없앤다.
			strDotLeft = trimNum(strDotLeft);
			// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
			String strDotRight = m_strGiftCurrentAmt.substring(strDotIndex+1);

			
			StringBuffer sb = new StringBuffer();
			
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물의, ")
			.append("전일 종가는")
			.append(strDotLeft).append(" , 쩜 , ")
			.append(strDotRight).append(" , 포인트 , ")
			.append(" , 입니다. ");
			
			actionAPI.setSessionData("ment", sb.toString());
		}else{
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
	
	private String dotNumTTS(String str, String unit){
		String leftStr = "";
		String rightStr = "";
		StringBuffer sb = new StringBuffer();
		int index = str.indexOf(".");
		
		if(index < 0) {
			leftStr = str;
		} else {
			leftStr = str.substring(0, index);
			rightStr = str.substring(index+1);
		}
		//자연수 처리
		leftStr = trimNum(leftStr);
		sb.append(leftStr);
		//소수점 밑 2자리 처리
		if(rightStr.equals("00") || rightStr.equals("0")){
			sb.append(", " + unit + ", ");
		}else{
			String lastStr = rightStr.substring(rightStr.length() - 1);
			if(lastStr.equals("0")){
				rightStr = rightStr.substring(0, 1);
				sb.append(", 쩜, [")
				.append(rightStr)
				.append("], " + unit + ", ");
			}else{
				sb.append(", 쩜, [")
				.append(rightStr)
				.append("], " + unit + ", ");
			}
		}
		return sb.toString();
	}
}
