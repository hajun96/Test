package TTS.S1.S111000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_111_3 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		/*111000_Ing_4_TTS : 
			전일대비 {Data.Session.m_strCurrentFluctAmt} 원, 
			오른 기세상한으로, {Data.Session.m_strCurrentAmt} 원,
			거래량은 {Data.Session.m_strCurrentVolume} 주, 입니다.
			*/
		String m_strCurrentFluctFlag = (String) actionAPI.getSessionData("m_strCurrentFluctFlag");
		
		String m_strCurrentFluctAmt = (String) actionAPI.getSessionData("m_strCurrentFluctAmt");
		m_strCurrentFluctAmt = trimNum(m_strCurrentFluctAmt);
		String m_strCurrentAmt = (String) actionAPI.getSessionData("m_strCurrentAmt");
		m_strCurrentAmt = trimNum(m_strCurrentAmt);
		
		String m_strCurrentVolume = (String) actionAPI.getSessionData("m_strCurrentVolume");
		m_strCurrentVolume = trimNum(m_strCurrentVolume);
		Float f_m_strCurrentVolume = Float.parseFloat(m_strCurrentVolume);
		
		StringBuffer sb = new StringBuffer();
		
		if(m_strCurrentFluctFlag.equals("0")){			//보합
			sb.append(", 보합인, ")
			.append(m_strCurrentAmt)
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("1")){	//오른
			sb.append(m_strCurrentFluctAmt)
			.append(", 원, ")
			.append(", 오른, ")
			.append(m_strCurrentAmt)
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("2")){	//상한가
			sb.append(", 전일대비, ")
			.append(m_strCurrentFluctAmt)
			.append(", 원, ")
			.append(", 오른, ")
			.append(", 상한가로, ")
			.append(m_strCurrentAmt)
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("3")){	//기세상승
			sb.append(", 전일대비, ")
			.append(m_strCurrentFluctAmt)
			.append(", 원, ")
			.append(", 오른, ")
			.append(", 기세상승 으로, ")
			.append(m_strCurrentAmt)
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("4")){	//기세상한
			sb.append(", 전일대비, ")
			.append(m_strCurrentFluctAmt)
			.append(", 원, ")
			.append(", 오른, ")
			.append(", 기세상한 으로, ")
			.append(m_strCurrentAmt)
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("5")){	//내린
			sb.append(m_strCurrentFluctAmt)
			.append(", 원, ")
			.append(", 내린, ")
			.append(m_strCurrentAmt)
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("6")){	//하한가
			sb.append(", 전일대비, ")
			.append(m_strCurrentFluctAmt)
			.append(", 원, ")
			.append(", 내린, ")
			.append(", 하한가로, ")
			.append(m_strCurrentAmt)
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("7")){	//기세하락
			sb.append(", 전일대비, ")
			.append(m_strCurrentFluctAmt)
			.append(", 원, ")
			.append(", 내린, ")
			.append(", 기세하락 으로, ")
			.append(m_strCurrentAmt)
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("8")){	//기세하한
			sb.append(", 전일대비, ")
			.append(m_strCurrentFluctAmt)
			.append(", 원, ")
			.append(", 내린, ")
			.append(", 기세하한 으로, ")
			.append(m_strCurrentAmt)
			.append(", 원, ");
		}else if(m_strCurrentFluctFlag.equals("9")){	//거래없음
			sb.append(", 보합인, ")
			.append(m_strCurrentAmt)
			.append(", 원, ");
		}else{
			actionAPI.setSessionData("ment", "error");
		}
		
		if(f_m_strCurrentVolume > 0.0){
			m_strCurrentVolume = trimNum(m_strCurrentVolume);
			sb.append(", 거래량은, ")
			.append(m_strCurrentVolume)
			.append(" , 주, ")
			.append(" , 입니다. ");
		}else{
			sb.append("거래량은")
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
