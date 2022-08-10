package TTS.S2.S210000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_210000_2 extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
		// 엄지선 대리 요청. 현재가 삭제 (2017.01.23)
		
		StringBuffer sb = new StringBuffer();
		
		String m_strPrevAmt = (String)actionAPI.getSessionData("m_strPrevAmt"); 
		//String m_strCurrentAmt = (String)actionAPI.getSessionData("m_strCurrentAmt");
		String m_strPrevVolume = (String)actionAPI.getSessionData("m_strPrevVolume");
		
		
		m_strPrevAmt = trimNum(m_strPrevAmt);
		//m_strCurrentAmt = trimNum(m_strCurrentAmt);
		m_strPrevVolume = trimNum(m_strPrevVolume);
		
		
		sb.append(", 전일 종가는 ,").append(m_strPrevAmt).append(", ,").append(", 원,");
		//sb.append(", 현재까는 ,").append(m_strCurrentAmt).append(", ,").append(", 원,");
		sb.append(", 거래량은 ,").append(m_strPrevVolume).append(", ,").append(", 주, 입니다.");
		
		
		
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
