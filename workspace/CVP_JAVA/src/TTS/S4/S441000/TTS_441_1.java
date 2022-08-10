package TTS.S4.S441000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_441_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strMaxOrdEnblAmt1 = (String) actionAPI.getSessionData("m_strMaxOrdEnblAmt1"); //융자가능금액
		m_strMaxOrdEnblAmt1 = trimNum(m_strMaxOrdEnblAmt1);
		Float f_m_strMaxOrdEnblAmt1 = Float.parseFloat(m_strMaxOrdEnblAmt1);
		String m_strMaxOrdEnblAmt7 = (String) actionAPI.getSessionData("m_strMaxOrdEnblAmt7"); //현금20%가능금액
		m_strMaxOrdEnblAmt7 = trimNum(m_strMaxOrdEnblAmt7);
		Float f_m_strMaxOrdEnblAmt7 = Float.parseFloat(m_strMaxOrdEnblAmt7);
		String m_strMaxOrdEnblAmt2 = (String) actionAPI.getSessionData("m_strMaxOrdEnblAmt2"); //현금30%가능금액
		m_strMaxOrdEnblAmt2 = trimNum(m_strMaxOrdEnblAmt2);
		Float f_m_strMaxOrdEnblAmt2 = Float.parseFloat(m_strMaxOrdEnblAmt2);
		String m_strMaxOrdEnblAmt3 = (String) actionAPI.getSessionData("m_strMaxOrdEnblAmt3"); //현금40%가능금액
		m_strMaxOrdEnblAmt3 = trimNum(m_strMaxOrdEnblAmt3);
		Float f_m_strMaxOrdEnblAmt3 = Float.parseFloat(m_strMaxOrdEnblAmt3);
		String m_strMaxOrdEnblAmt4 = (String) actionAPI.getSessionData("m_strMaxOrdEnblAmt4"); //대융가없는 가능금액
		m_strMaxOrdEnblAmt4 = trimNum(m_strMaxOrdEnblAmt4);
		Float f_m_strMaxOrdEnblAmt4 = Float.parseFloat(m_strMaxOrdEnblAmt4);
		String m_strMaxOrdEnblAmt5 = (String) actionAPI.getSessionData("m_strMaxOrdEnblAmt5"); //정상 증거금 가능금액
		m_strMaxOrdEnblAmt5 = trimNum(m_strMaxOrdEnblAmt5);
		Float f_m_strMaxOrdEnblAmt5 = Float.parseFloat(m_strMaxOrdEnblAmt5);
		String m_strMaxOrdEnblAmt6 = (String) actionAPI.getSessionData("m_strMaxOrdEnblAmt6"); //불리 증거금 가능금액
		m_strMaxOrdEnblAmt6 = trimNum(m_strMaxOrdEnblAmt6);
		Float f_m_strMaxOrdEnblAmt6 = Float.parseFloat(m_strMaxOrdEnblAmt6);
		
		StringBuffer sb = new StringBuffer();
		
		if(f_m_strMaxOrdEnblAmt1 > 0.0){
			sb.append(", 융자 주문시, ")
			.append(m_strMaxOrdEnblAmt1)
			.append(", 원, ");
		}else{
			sb.append("융자 주문시, ")
			.append(", 없고, ");
		}
		
		if(f_m_strMaxOrdEnblAmt7 > 0.0){
			sb.append(", 현금, 이십, 퍼센트, 주문시, ")
			.append(m_strMaxOrdEnblAmt7)
			.append(", 원, ");
		}else{
			sb.append(", 현금, 이십, 퍼센트, 주문시, ")
			.append(", 없고, ");
		}
		
		if(f_m_strMaxOrdEnblAmt2 > 0.0){
			sb.append(", 현금, 삼십, 퍼센트, 주문시, ")
			.append(m_strMaxOrdEnblAmt2)
			.append(", 원, ");
		}else{
			sb.append(", 현금, 삼십, 퍼센트, 주문시, ")
			.append(", 없고, ");
		}
		
		if(f_m_strMaxOrdEnblAmt3 > 0.0){
			sb.append(", 현금, 사십, 퍼센트, 주문시, ")
			.append(m_strMaxOrdEnblAmt3)
			.append(", 원, ");
		}else{
			sb.append(", 현금, 사십, 퍼센트, 주문시, ")
			.append(", 없고, ");
		}
		
		if(f_m_strMaxOrdEnblAmt4 > 0.0){
			sb.append(", 대용가, 없는, 백, 퍼센트, 주문시, ")
			.append(m_strMaxOrdEnblAmt4)
			.append(", 원, ");
		}else{
			sb.append(", 대용가, 없는, 백, 퍼센트, 주문시, ")
			.append(", 없고, ");
		}
		
		if(f_m_strMaxOrdEnblAmt5 > 0.0){
			sb.append(", 대용가, 있는, 종목 , 정상 증거금, 백, 퍼센트, 주문시, ")
			.append(m_strMaxOrdEnblAmt5)
			.append(", 원, ");
		}else{
			sb.append(", 대용가, 있는, 종목 , 정상 증거금, 백, 퍼센트, 주문시, ")
			.append(", 없고, ");
		}
		
		if(f_m_strMaxOrdEnblAmt6 > 0.0){
			sb.append(", 대용가, 있는, 종목 , 불리 증거금, 백, 퍼센트, 주문시, ")
			.append(m_strMaxOrdEnblAmt6)
			.append(", 원, ")
			.append(", 입니다. ");
		}else{
			sb.append(", 대용가, 있는, 종목 , 불리 증거금, 백, 퍼센트, 주문시, ")
			.append(", 없습니다. ");
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
