package TTS.S1.S124000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_124_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strPrevOrderNum = (String) actionAPI.getSessionData("m_strPrevOrderNum"); // 주문번호
		m_strPrevOrderNum = trimNum(m_strPrevOrderNum);
		
		String m_strOrderVol = (String) actionAPI.getSessionData("m_strOrderVol"); // 주문수량
		m_strOrderVol = trimNum(m_strOrderVol);
		
		String m_strContVol = (String) actionAPI.getSessionData("m_strContVol"); // 
		m_strContVol = trimNum(m_strContVol);
		
		//수량 계산
		int nOrderVol = Integer.parseInt(m_strOrderVol);
		int nContVol = Integer.parseInt(m_strContVol);
		String m_strVol = String.valueOf(nOrderVol - nContVol);
		
		String m_strOrderPrice = (String) actionAPI.getSessionData("m_strOrderPrice"); // 주문단가
		m_strOrderPrice = trimNum(m_strOrderPrice); 
		
		String m_strTrdSect = (String) actionAPI.getSessionData("m_strTrdSect"); // 매도매수 구분 (1:매도 / 2:매수)
		m_strTrdSect = trimNum(m_strTrdSect);
		
		String m_strUpdtCnclSect = (String) actionAPI.getSessionData("m_strUpdtCnclSect"); // 주문구분 (0:주문, 1:정정, 2:취소)
		m_strUpdtCnclSect = trimNum(m_strUpdtCnclSect);
		
		String m_strOrdCrdtLoanSect = (String) actionAPI.getSessionData("m_strOrdCrdtLoanSect"); // 신용대출구분 (00:현금)
		
		//원주문번호 ####번, ####원, ###주,매도or매수or정정or취소 
		StringBuffer sb = new StringBuffer();
		
		//원주문번호
		if(m_strPrevOrderNum != null && !m_strPrevOrderNum.isEmpty()){
			if(m_strOrdCrdtLoanSect.equals("00")){ //현금
				if(m_strUpdtCnclSect.equals("1")){ //정정
					if(m_strOrderPrice.equals("0")){
						sb.append(", 원 주문번호, ")
						.append(m_strPrevOrderNum)
						.append(", 번, ")
						.append(m_strVol)
						.append(", 주 , ");
						
						if(m_strTrdSect.equals("1")){
							sb.append(", 매도, ");
						}else if(m_strTrdSect.equals("2")){
							sb.append(", 매수, ");
						}else{
							sb.append("");
						}
					}else{
						sb.append(", 원 주문번호, ")
						.append(m_strPrevOrderNum)
						.append(", 번, ")
						.append(m_strOrderPrice)
						.append(", 원, ")
						.append(m_strVol)
						.append(", 주 , ");
						
						if(m_strTrdSect.equals("1")){
							sb.append(", 매도, ");
						}else if(m_strTrdSect.equals("2")){
							sb.append(", 매수, ");
						}else{
							sb.append("");
						}
					}
					sb.append("정정");
				}else if(m_strUpdtCnclSect.equals("2")){ //취소
					if(m_strOrderPrice.equals("0")){
						sb.append(", 원 주문번호, ")
						.append(m_strPrevOrderNum)
						.append(", 번, ")
						.append(m_strVol)
						.append(", 주 , ");
						
						if(m_strTrdSect.equals("1")){
							sb.append(", 매도, ");
						}else if(m_strTrdSect.equals("2")){
							sb.append(", 매수, ");
						}else{
							sb.append("");
						}
					}else{
						sb.append(", 원 주문번호, ")
						.append(m_strPrevOrderNum)
						.append(", 번, ")
						.append(m_strOrderPrice)
						.append(", 원, ")
						.append(m_strVol)
						.append(", 주 , ");
						
						if(m_strTrdSect.equals("1")){
							sb.append(", 매도, ");
						}else if(m_strTrdSect.equals("2")){
							sb.append(", 매수, ");
						}else{
							sb.append("");
						}
					}
					sb.append("취소");
				}else{
					if(m_strOrderPrice.equals("0")){
						sb.append(", 원 주문번호, ")
						.append(m_strPrevOrderNum)
						.append(", 번, ")
						.append(m_strVol)
						.append(", 주 , ");
						
						if(m_strTrdSect.equals("1")){
							sb.append(", 매도, ");
						}else if(m_strTrdSect.equals("2")){
							sb.append(", 매수, ");
						}else{
							sb.append("");
						}
					}else{
						sb.append(", 원 주문번호, ")
						.append(m_strPrevOrderNum)
						.append(", 번, ")
						.append(m_strOrderPrice)
						.append(", 원, ")
						.append(m_strVol)
						.append(", 주 , ");
						
						if(m_strTrdSect.equals("1")){
							sb.append(", 매도, ");
						}else if(m_strTrdSect.equals("2")){
							sb.append(", 매수, ");
						}else{
							sb.append("");
						}
					}
				}
			}else{
				sb.append("");
			}
			actionAPI.setSessionData("ment", sb.toString());
		}else{
			actionAPI.setSessionData("ment", "error");
		}
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
