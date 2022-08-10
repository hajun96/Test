package TTS.S5.S532000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_532_2 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		
		String m_strSelDate = (String) actionAPI.getSessionData("m_strSelDate");	//조회시작일자
		
		//[이체날짜계산]
		String year = m_strSelDate.substring(0, 4);
		String month = m_strSelDate.substring(4, 6);
		String day = m_strSelDate.substring(6);
		month = trimNum(month);
		day = trimNum(day);
		
		StringBuffer sb = new StringBuffer();
		
		if(m_strSelDate.equals("0") || m_strSelDate.equals("") || m_strSelDate.equals(null)){
			sb.append(", 조회시작일, 없음.");
		}else{
			sb.append(year)
			.append(", 년, ")
			.append(month)
			.append(", 월, ")
			.append(day)
			.append(", 일, ")
			.append(", 입출금, 내역이, 없습니다.");
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
