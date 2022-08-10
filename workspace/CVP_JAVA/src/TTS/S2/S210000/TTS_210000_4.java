package TTS.S2.S210000;

import java.util.Hashtable;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_210000_4 extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
			
		StringBuffer sb = new StringBuffer();
		
		/*
		 * 시가안내 TTS 생성 클래스
		 */
		String m_strOpenAmt = (String) actionAPI.getSessionData("m_strOpenAmt");
		String m_strHighAmt = (String) actionAPI.getSessionData("m_strHighAmt");
		String m_strLowAmt = (String) actionAPI.getSessionData("m_strLowAmt");
		
		m_strOpenAmt = trimNum(m_strOpenAmt);
		m_strHighAmt = trimNum(m_strHighAmt);
		m_strLowAmt = trimNum(m_strLowAmt);
		
		if(m_strOpenAmt != null && Integer.parseInt(m_strOpenAmt) > 0) {
			sb.append(", 시까,").append(m_strOpenAmt).append(", ,").append(", 원,");
		} else {
			sb.append(", 시까, 없고,");
		}
		
		if(m_strHighAmt != null && Integer.parseInt(m_strHighAmt) > 0) {
			sb.append(", 고까,").append(m_strHighAmt).append(", ,").append(",원,");
		} else {
			sb.append(", 고까, 없고,");
		}
		
		if(m_strLowAmt != null && Integer.parseInt(m_strLowAmt) > 0) {
			sb.append(", 저까,").append(m_strLowAmt).append(", ,").append(",원, 입니다.");
		} else {
			sb.append(", 저까, 없습니다.");
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
