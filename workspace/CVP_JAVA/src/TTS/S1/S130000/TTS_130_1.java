package TTS.S1.S130000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_130_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		/*TdayBusinDate / m_strBalBusinDate1 / 당일영업일자 
		AftDayBusinDate / m_strBalBusinDate2 / 후일영업일자
		Aft2dayBusinDate / m_strBalBusinDate3 / 후2일영업일자
		DepCashAmt / m_strBalDepCashAmt / 예수금액
		DepCash1 / m_strBalDepCashAmt1 / 예수금1
		DepCash2 / m_strBalDepCashAmt2 / 예수금2
		OamtEnblAmt / m_strBalOutEnAmt / 출금가능금액
		AssmDepAsstAmt / m_strBalAssmDepAsstAmt / 추정예탁자산금액
		TmpAdjAmt / m_strBalTempAdjAmt / 가정산금액
		GRID_Cnt / A_CNT / 그리드 카운트
		*/
		String m_strBalDepCashAmt = (String) actionAPI.getSessionData("m_strBalDepCashAmt"); //예수금액
		m_strBalDepCashAmt = trimNum(m_strBalDepCashAmt);
		Float f_m_strBalDepCashAmt = Float.parseFloat(m_strBalDepCashAmt);
		String m_strBalTempAdjAmt = (String) actionAPI.getSessionData("m_strBalTempAdjAmt"); //가정산금액
		m_strBalTempAdjAmt = trimNum(m_strBalTempAdjAmt);
		Float f_m_strBalTempAdjAmt = Float.parseFloat(m_strBalTempAdjAmt);
		String m_strBalOutEnAmt = (String) actionAPI.getSessionData("m_strBalOutEnAmt"); //출금가능금액
		m_strBalOutEnAmt = trimNum(m_strBalOutEnAmt);
		Float f_m_strBalOutEnAmt = Float.parseFloat(m_strBalOutEnAmt);
		String m_strBalBusinDate1 = (String) actionAPI.getSessionData("m_strBalBusinDate1"); //당일영업일자
		String month = m_strBalBusinDate1.substring(4, 6);
		String day = m_strBalBusinDate1.substring(6);
		month = trimNum(month);
		day = trimNum(day);
		
		StringBuffer sb = new StringBuffer();
		
		if(f_m_strBalDepCashAmt != 0.0){
			sb.append(month).append(", 월, ").append(day).append(", 일, ")
			.append(", 예수금은, ")
			.append(m_strBalDepCashAmt)
			.append(", 원 ,");
		}else{
			sb.append(month).append(", 월, ").append(day).append(", 일, ")
			.append(", 예수금은, ")
			.append(", 없고,");
		}
		
		if(f_m_strBalTempAdjAmt != 0.0){
			sb.append(", 가정산금액은, ")
			.append(m_strBalTempAdjAmt)
			.append(", 원 ,");
		}else{
			sb.append("가정산금액은")
			.append(", 없고 ,");
		}
		
		if(f_m_strBalOutEnAmt != 0.0){
			sb.append(", 출금가능금액은, ")
			.append(m_strBalOutEnAmt)
			.append(", 원 ,");
		}else{
			sb.append("출금가능금액은")
			.append(", 없고 ,");
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
