package TTS.S7.S710000;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_710_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strLostDigit = (String) actionAPI.getSessionData("m_strLostDigit"); //분실종류
		
		//[오늘날짜계산]
		String formStr = "yyyyMMdd";
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat(formStr);
		String nowDate = format.format(date);
		//[오늘날짜계산]
		String year = nowDate.substring(0, 4);
		String month = nowDate.substring(4, 6);
		String day = nowDate.substring(6);
		month = trimNum(month);
		day = trimNum(day);
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(year)
		.append(", 년, ")
		.append(month)
		.append(", 월, ")
		.append(day)
		.append(", 일, ");
		
		if(m_strLostDigit.equals("1")){
			sb.append(", 증권카드, 의,");
		}else if(m_strLostDigit.equals("2")){
			sb.append(", 인감, 의,");
		}else if(m_strLostDigit.equals("3")){
			sb.append(", 통장, 의,");
		}else if(m_strLostDigit.equals("4")){
			sb.append(", OTP, 의,");
		}else if(m_strLostDigit.equals("5")){
			sb.append(", 보안카드, 의,");
		}else if(m_strLostDigit.equals("6")){
			sb.append(", 공인인증서, 의,");
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
