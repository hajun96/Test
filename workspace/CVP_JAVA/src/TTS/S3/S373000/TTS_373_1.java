package TTS.S3.S373000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_373_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI)throws AudiumException {
		String m_strRsvOrdNo = (String) actionAPI.getSessionData("m_strRsvOrdNo");//예약번호
		m_strRsvOrdNo = trimNum(m_strRsvOrdNo);
		String m_strRsvOrderVol = (String) actionAPI.getSessionData("m_strRsvOrderVol");	//주문수량
		m_strRsvOrderVol = trimNum(m_strRsvOrderVol);
		String m_strRsvTrdSect = (String) actionAPI.getSessionData("m_strRsvTrdSect");	//매매구분
		StringBuffer sb = new StringBuffer();
		//예약주문번호
		if(m_strRsvOrdNo.equals("0") || m_strRsvOrdNo.equals("") || m_strRsvOrdNo.equals(null)){
			sb.append(", 예약번호, 없고,");
		}else{
			sb.append(", 예약번호, ")
			.append(m_strRsvOrdNo)
			.append(", 번, ");
		}
		
		//예약주문수량
		if(m_strRsvOrderVol.equals("0") || m_strRsvOrderVol.equals("") || m_strRsvOrderVol.equals(null)){
			sb.append(", 예약주문수량, 없고, ");
		}else{
			sb.append(m_strRsvOrderVol).append(", 주, ");
		}
		
		if(m_strRsvTrdSect.equals("0") || m_strRsvTrdSect.equals("") || m_strRsvTrdSect.equals(null)){
			sb.append("");
		}else if(m_strRsvTrdSect.equals("1")){
			sb.append(", 매도, ");
		}else{
			sb.append(", 매수, ");
		}
		actionAPI.setSessionData("ment", sb.toString());
	}
	
	private String trimNum(String num) {
		if (num == null)
			return "0";

		boolean isMinus = false;
		String result = "";

		if (num.startsWith("-")) {
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
		if (result.isEmpty()) {
			return "0";
		}

		if (result.startsWith("."))
			result = "0" + result;

		if (isMinus) {
			result = "-" + result;
		}

		return result;
	}
}
