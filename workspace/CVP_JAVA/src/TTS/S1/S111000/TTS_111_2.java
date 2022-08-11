package TTS.S1.S111000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_111_2 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strExpectAmt = (String) actionAPI.getSessionData("m_strExpectAmt");			//현재가
		m_strExpectAmt = trimNum(m_strExpectAmt); // TrimNum 추가
		String m_strExpectFlucBit = (String) actionAPI.getSessionData("m_strExpectFlucBit");	//전일대비구분
		String m_strExpectFluctAmt = (String) actionAPI.getSessionData("m_strExpectFluctAmt");	//전일대비
		m_strExpectFluctAmt = trimNum(m_strExpectFluctAmt);
		String m_strExpectVolume = (String) actionAPI.getSessionData("m_strExpectVolume");		//거래량
		m_strExpectVolume = trimNum(m_strExpectVolume);
		Float f_m_strExpectVolume = Float.parseFloat(m_strExpectVolume);
		
		StringBuffer sb = new StringBuffer();
		
		if(m_strExpectFlucBit.equals("0")){			//보합
			sb.append("예상가는")
			.append("보합인")
			.append(m_strExpectAmt)
			.append(", 원, ");
		}else if(m_strExpectFlucBit.equals("1")){	//오른
			sb.append("예상가는")
			.append(m_strExpectFluctAmt)
			.append(", 원, ")
			.append("오른")
			.append(m_strExpectAmt)
			.append(", 원, ");
		}else if(m_strExpectFlucBit.equals("2")){	//상한가
			sb.append("예상가는")
			.append("상한가로")
			.append(m_strExpectAmt)
			.append(", 원, ");
		}else if(m_strExpectFlucBit.equals("3")){	//기세상승
			sb.append("예상가는")
			.append("기세상승으로")
			.append(m_strExpectAmt)
			.append(", 원, ");
		}else if(m_strExpectFlucBit.equals("4")){	//기세상한
			sb.append("예상가는")
			.append("기세상한으로")
			.append(m_strExpectAmt)
			.append(", 원, ");
		}else if(m_strExpectFlucBit.equals("5")){	//내린
			sb.append("예상가는")
			.append(m_strExpectFluctAmt)
			.append(", 원, ")
			.append("내린")
			.append(m_strExpectAmt)
			.append(", 원, ");
		}else if(m_strExpectFlucBit.equals("6")){	//하한가
			sb.append("예상가는")
			.append("하한가로")
			.append(m_strExpectAmt)
			.append(", 원, ");
		}else if(m_strExpectFlucBit.equals("7")){	//기세하락
			sb.append("예상가는")
			.append("기세하락으로")
			.append(m_strExpectAmt)
			.append(", 원, ");
		}else if(m_strExpectFlucBit.equals("8")){	//기세하한
			sb.append("예상가는")
			.append("기세하한으로")
			.append(m_strExpectAmt)
			.append(", 원, ");
		}else if(m_strExpectFlucBit.equals("9")){	//거래없음
			sb.append("예상가는")
			.append("보합인")
			.append(m_strExpectAmt)
			.append(", 원, ");
		}else{
			actionAPI.setSessionData("ment", "error");
		}
		
		if(f_m_strExpectVolume > 0.0){
			m_strExpectVolume = trimNum(m_strExpectVolume);
			sb.append("예상 , 거래량은")
			.append(m_strExpectVolume)
			.append(" , 주, ")
			.append(" , 입니다. ");
		}else{
			sb.append("예상 , 거래량은")
			.append(" , 없습니다. ");
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
