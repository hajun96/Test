package TTS.S3.S351000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

//해당 상품의 기준시간은,,{Data.Session.m_strBaseTime} 시, 이며,
public class TTS_351_5 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strBaseTime = (String) actionAPI.getSessionData("m_strBaseTime");// 기준시간
		
		String baseHour = m_strBaseTime.substring(0, 2);
		String baseMinute = m_strBaseTime.substring(2, 4);
		baseMinute = trimNum(baseMinute);
		
		StringBuffer sb = new StringBuffer();
		if(baseMinute.equals("0") || baseMinute.equals("00") || baseMinute.equals(null)){
			sb.append("해당상품의 기준시간은, ").append(baseHour).append(", 시, 이며,");
		}else{
			sb.append("해당상품의 기준시간은, ").append(baseHour).append(", 시,")
			.append(baseMinute).append(", 분, 이며,");
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
