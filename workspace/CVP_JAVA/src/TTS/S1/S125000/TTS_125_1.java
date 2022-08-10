package TTS.S1.S125000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_125_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strItemName = (String) actionAPI.getSessionData("m_strItemName");// 종목명
		String m_strPrevOrderNum = (String) actionAPI.getSessionData("m_strPrevOrderNum"); // 주문번호
		m_strPrevOrderNum = trimNum(m_strPrevOrderNum);
		//String m_strOrderItemCode = (String) actionAPI.getSessionData("m_strOrderItemCode"); // 종목코드
		String m_strOrderVol = (String) actionAPI.getSessionData("m_strOrderVol"); // 주문수량
		m_strOrderVol = trimNum(m_strOrderVol);
		String m_strOrderPrice = (String) actionAPI.getSessionData("m_strOrderPrice"); // 주문단가
		m_strOrderPrice = trimNum(m_strOrderPrice);
		Float f_m_strOrderPrice = Float.parseFloat(m_strOrderPrice);
		String m_strContVol = (String) actionAPI.getSessionData("m_strContVol"); // 체결수량
		m_strContVol = trimNum(m_strContVol);
		Float f_m_strContVol = Float.parseFloat(m_strContVol);
		String m_strContPrice = (String) actionAPI.getSessionData("m_strContPrice"); // 체결단가
		m_strContPrice = trimNum(m_strContPrice);
		String m_strTrdSect = (String) actionAPI.getSessionData("m_strTrdSect"); // 매도매수 구분 (1:매도 / 2:매수)
		m_strTrdSect = trimNum(m_strTrdSect);
		String m_strTrdKindSect = (String) actionAPI.getSessionData("m_strTrdKindSect"); // 매매구분 (01:지정가, 02:임의, 05:시장가, 06:조건부지정가)
		//String m_strOrdMkSect = (String) actionAPI.getSessionData("m_strOrdMkSect"); // 주문장구분 (1:장개시전종가, 2:장중, 3:시간외종가, 4:시간외단일가, 5:ECN(현재미사용), 9:단주)
		//String m_strOrdSect = (String) actionAPI.getSessionData("m_strOrdSect"); // 매도매수상세 구분 (01:현금매도, 02:현금매수, 03:신용매도(코스닥포함), 04:신용매수(코스닥포함), 05:저축매도, 06:저축매수, 07:채권매도, 08:채권매수, 09:코스닥현금매도, 10:코스닥현금매수, 11:코스닥저축매도, 12:코스닥저축매수, 13:프리보드매도, 14:프리모드매수)
		String m_strUpdtCnclSect = (String) actionAPI.getSessionData("m_strUpdtCnclSect"); // 주문구분 (0:주문, 1:정정, 2:취소)
		//String m_strOrdCrdtLoanSect = (String) actionAPI.getSessionData("m_strOrdCrdtLoanSect"); // 신용대출구분 (00:현금)
		
		// 주문번호(m_strPrevOrderNum) 번에 , (m_strMitemName) (m_strOrderVol) 주, 
		
		StringBuffer sb = new StringBuffer();
		sb.append(", 주문번호, ")
		.append(m_strPrevOrderNum).append(", ,")
		.append(", 번에, ")
		.append(m_strItemName).append(", ,")
		.append(", , , ")
		.append(m_strOrderVol).append(", ,")
		.append(", 주, ");
		
		if(m_strTrdKindSect.equals("01")){
			if(f_m_strOrderPrice > 0.0){
				sb.append(m_strOrderPrice).append(", ,")
				.append(", 원에, ")
				.append(", 지정가로, ");
			}else{
				sb.append(", 지정가로, ");
			}
		}else if(m_strTrdKindSect.equals("06")){
			if(f_m_strOrderPrice > 0.0){
				sb.append(m_strOrderPrice).append(", ,")
				.append(", 원에, ")
				.append(", 조건부, 지정가로,");
			}else{
				sb.append(", 조건부, 지정가로,");
			}
		}else{
			sb.append(", 시장가로, ");
		}
		
		if(m_strUpdtCnclSect.equals("1")){
			sb.append(", 정정, ")
			.append(", 주문, 해당 체결내역은, ");
		}else if(m_strUpdtCnclSect.equals("2")){
			sb.append(", 취소, ")
			.append(", 주문, 해당 체결내역은, ");
		}else{
			//m_strTrdSect
			if(m_strTrdSect.equals("1")){
				sb.append(", 매도, ")
				.append(", 주문, 해당 체결내역은, ");
			}else if(m_strTrdSect.equals("2")){
				sb.append(", 매수, ")
				.append(", 주문, 해당 체결내역은, ");
			}
		}
		
		if(f_m_strContVol > 0.0){
			sb.append(m_strContVol).append(", ,")
			.append(" , 주가, ")
			.append(m_strContPrice).append(", ,")
			.append(" , 원에, ");
		}else{
			sb.append("없음");
		}
		
		if(m_strTrdSect.equals("1")){ //매도
			sb.append(", 매도, ").append(", ,")
			.append(", 체결, ");
		}else{ //매수
			sb.append(", 매수, ").append(", ,")
			.append(", 체결, ");
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
