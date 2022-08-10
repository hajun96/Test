package TTS.S1.S114000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_114_4 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strCurrentFluctFlag = (String) actionAPI.getSessionData("m_strCurrentFluctFlag"); // 전일대비 구분
		String m_strCurrentFluctAmt = (String) actionAPI.getSessionData("m_strCurrentFluctAmt"); // 전일대비
		m_strCurrentFluctAmt = trimNum(m_strCurrentFluctAmt);
		String m_strCurrentAmt = (String) actionAPI.getSessionData("m_strCurrentAmt"); //현재가
		m_strCurrentAmt = trimNum(m_strCurrentAmt);
		String m_strOverTimeVol = (String) actionAPI.getSessionData("m_strOverTimeVol"); //시간외단일가 거래량
		Float f_m_strOverTimeVol = Float.parseFloat(m_strOverTimeVol);
		m_strOverTimeVol = trimNum(m_strOverTimeVol);
		
		String m_strItemName = (String) actionAPI.getSessionData("m_strItemName");	//종목명
		
		StringBuffer sb = new StringBuffer();
		
		if(m_strCurrentFluctFlag.equals("0")){			//보합
			sb.append(", 보합인, ")
			.append(m_strCurrentAmt).append(" ")
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("1")){	//오른
			sb.append(m_strCurrentFluctAmt).append(", ,")
			.append(", 원, ")
			.append(", 오른, ")
			.append(m_strCurrentAmt).append(", ,")
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("2")){	//상한가
			sb.append(", 상한가로, ")
			.append(m_strCurrentAmt).append(", ,")
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("3")){	//기세상승
			sb.append(", ,")
			.append(", 기세상승으로, ")
			.append(m_strCurrentAmt).append(", ,")
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("4")){	//기세상한
			sb.append(m_strItemName).append(", ,")
			.append(", 기세상한으로, ")
			.append(m_strCurrentAmt).append(", ,")
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("5")){	//내린
			sb.append(m_strItemName)
			.append(m_strCurrentFluctAmt).append(", ,")
			.append(", 원, ")
			.append(", 내린, ")
			.append(m_strCurrentAmt).append(", ,")
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("6")){	//하한가
			sb.append(m_strItemName).append(", ,")
			.append(", 하한가로, ")
			.append(m_strCurrentAmt).append(", ,")
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("7")){	//기세하락
			sb.append(m_strItemName)
			.append(", 기세하락으로, ")
			.append(m_strCurrentAmt)
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("8")){	//기세하한
			sb.append(m_strItemName).append(", ,")
			.append(", 기세하한으로, ")
			.append(m_strCurrentAmt).append(", ,")
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("9")){	//거래없음
			sb.append(m_strItemName).append(", ,")
			.append(", 보합인, ")
			.append(m_strCurrentAmt).append(", ,")
			.append(", 원, ");
		}else{
			actionAPI.setSessionData("ment", "error");
		}
		
		if(f_m_strOverTimeVol > 0.0){
			sb.append(", 시간외단일가 ,")
			.append(", 거래량은 ,")
			.append(m_strOverTimeVol).append(" ")
			.append(", 주 ,")
			.append(", 입니다., ");
			
		}else{
			sb.append(", 시간외단일가, ")
			.append(", 거래량은, ")
			.append(", 없습니다., ");
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
