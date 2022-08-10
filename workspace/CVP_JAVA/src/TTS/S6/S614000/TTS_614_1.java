package TTS.S6.S614000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_614_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		
		
		
		/*
		 * m_strSubsTurn[@m_iCnt] / SubsTurn   청약회차    
		 * 
		 * m_strSubsComptRate[@m_iCnt] /  ComptRate  경쟁률
		 * 
		 * m_strSubsComptRate
		 * 
		 * 
          
		*/
		
		String m_strSubsItemName = (String) actionAPI.getSessionData("m_strSubsItemName"); // 종목명
		String m_strSubsTurn = (String) actionAPI.getSessionData("m_strSubsTurn"); // 청약회차
		m_strSubsTurn = trimNum(m_strSubsTurn);
		String m_strSubsComptRate = (String) actionAPI.getSessionData("m_strSubsComptRate"); // 경쟁률
		String m_strSubsSect = (String) actionAPI.getSessionData("m_strSubsSect"); // 청약그룹(일반, 그외)
		
	
		// REPLACE(LEFT(@m_strSubsComptRate[@m_iCnt], LENGTH(@m_strSubsComptRate[@m_iCnt]) - 3),",","")
		// LEFT(@m_strSubsComptRate, LENGTH(@m_strSubsComptRate) - 3)
		// REPLACE("456,89",",","")
		
		
		// 소수점 자리수를 가져온다. 
		int strDotIndex = m_strSubsComptRate.indexOf(".");
		// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
		String strDotLeft = m_strSubsComptRate.substring(0, strDotIndex);
		// 앞에 0이 있으면 없앤다.
		strDotLeft = trimNum(strDotLeft);
		// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
		String strDotRight = m_strSubsComptRate.substring(strDotIndex+1);

		
		
		
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(m_strSubsTurn).append(", , , ").append(",회차,");
		
		if(m_strSubsSect.equals("01")){
			sb.append(", 일반, ");
		}else{
			sb.append(", 우대 , ");
		}
		
		sb.append(", , , ").append(m_strSubsItemName).append(", , , ")
		.append(",의 청약경쟁률은,").append(strDotLeft).append(", , , ")
		.append(", 쩜 [,").append(strDotRight).append("], , , ").append(", , 대 , 일 입니다.,");
		
		
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



	/* public static void main(String[] args) {
		String m_strSubsComptRate = "333,22";
		
		String strSubsComptRate1 = m_strSubsComptRate.substring(0, m_strSubsComptRate.length() -3);
		strSubsComptRate1 = strSubsComptRate1.replaceAll(",", "");
		String strSubsComptRate2 = m_strSubsComptRate.substring(m_strSubsComptRate.length() - 2, m_strSubsComptRate.length());
		
		StringBuffer sb = new StringBuffer();
		sb.append("1").append("회차").append("종목명").append("의 청약경쟁률은").append(strSubsComptRate1)
		.append("점").append(strSubsComptRate2).append("대 일 입니다.");
		
		System.out.println(sb.toString());
	}
}
	*/