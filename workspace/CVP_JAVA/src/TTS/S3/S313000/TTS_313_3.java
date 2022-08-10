package TTS.S3.S313000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_313_3 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strCurrentFluctFlag = (String) actionAPI.getSessionData("m_strCurrentFluctFlag");// 전일대비 구분
		String m_strCurrentAmt = (String) actionAPI.getSessionData("m_strCurrentAmt"); //현재가
		m_strCurrentAmt = trimNum(m_strCurrentAmt);
		String m_strCurrentFluctAmt = (String) actionAPI.getSessionData("m_strCurrentFluctAmt"); //전일대비
		m_strCurrentFluctAmt = trimNum(m_strCurrentFluctAmt);
		StringBuffer sb = new StringBuffer();
		
		if(m_strCurrentFluctFlag.equals("0")){
			sb.append(", 보함인, ").append(m_strCurrentAmt).append(", , 원, ").append(", 입니다.");
		}else if(m_strCurrentFluctFlag.equals("1")){
			sb.append(m_strCurrentFluctAmt).append(", , 원 ,").append(",  오른, ").
			append(m_strCurrentAmt).append(", , 원, ").append(", 입니다.");
		}else if(m_strCurrentFluctFlag.equals("2")){
			sb.append(", 상한가로, ").append(m_strCurrentAmt).append(", , 원 ,").append(", 입니다.");
		}else if(m_strCurrentFluctFlag.equals("3")){
			sb.append(", 기세상승으로, ").append(m_strCurrentAmt).append(", , 원 ,").append(", 입니다.");
		}else if(m_strCurrentFluctFlag.equals("4")){
			sb.append(", 기세상한으로, ").append(m_strCurrentAmt).append(", , 원 ,").append(", 입니다.");
		}else if(m_strCurrentFluctFlag.equals("5")){
			sb.append(m_strCurrentFluctAmt).append(", , 원 ,").append(",  내린, ").
			append(m_strCurrentAmt).append(", , 원, ").append(", 입니다.");
		}else if(m_strCurrentFluctFlag.equals("6")){
			sb.append(", 하한가로, ").append(m_strCurrentAmt).append(", , 원 ,").append(", 입니다.");
		}else if(m_strCurrentFluctFlag.equals("7")){
			sb.append(", 기세하락으로, ").append(m_strCurrentAmt).append(", , 원 ,").append(", 입니다.");
		}else if(m_strCurrentFluctFlag.equals("8")){
			sb.append(", 기세하한으로, ").append(m_strCurrentAmt).append(", , 원 ,").append(", 입니다.");
		}else if(m_strCurrentFluctFlag.equals("9")){
			sb.append(", 보함인, ").append(m_strCurrentAmt).append(", , 원, ").append(", 입니다.");
		}else{
			actionAPI.setSessionData("ment", "error");
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
