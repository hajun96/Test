package TTS.S3.S334000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_334_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI)throws AudiumException {
		/*m_strCreditItemCode : 단축종목코드 
		m_strCreditItemFullCode : 종목번호 
		m_strItemName : 종목명
		m_strCreditCrdtSect : 신용구분 (ex : 유융, 자융, 유대, 일담, 자대, 대차, 매입, 매도, 대용, 단기, 현금)
		m_strCreditHoldQty : 보유수량 (ex : 00000036500)    	
		m_strCreditEnblQty : 가능수량 (ex : 00000036500)
		m_strCreditLoanDate : 대출일자  (ex : 20161114)   	
		m_strCreditUprc : 단가 (ex : 00000012000)
		m_strCreditExprDate : 만기일자 (ex : 20170512) */
		
		String m_strItemName = (String) actionAPI.getSessionData("m_strItemName");	//종목명
		String m_strCreditEnblQty = (String) actionAPI.getSessionData("m_strCreditEnblQty");	//가능수량
		m_strCreditEnblQty = trimNum(m_strCreditEnblQty);
		String m_strCreditCrdtSect = (String) actionAPI.getSessionData("m_strCreditCrdtSect");	//신용구분
		String m_strCreditUprc = (String) actionAPI.getSessionData("m_strCreditUprc");	//단가
		m_strCreditUprc = trimNum(m_strCreditUprc);
		String m_strCreditLoanDate = (String) actionAPI.getSessionData("m_strCreditLoanDate");	//대출일자
		String m_strLoanYear = m_strCreditLoanDate.substring(0, 4);
		String m_strLoanMonth = m_strCreditLoanDate.substring(4, 6);
		String m_strLoanDay = m_strCreditLoanDate.substring(6);
		m_strLoanMonth = trimNum(m_strLoanMonth);
		m_strLoanDay = trimNum(m_strLoanDay);
		String m_strCreditExprDate = (String) actionAPI.getSessionData("m_strCreditExprDate");	//만기일자
		String m_strExprYear = m_strCreditExprDate.substring(0, 4);
		String m_strExprMonth = m_strCreditExprDate.substring(4, 6);
		String m_strExprDay = m_strCreditExprDate.substring(6);
		m_strExprMonth = trimNum(m_strExprMonth);
		m_strExprDay = trimNum(m_strExprDay);
		
		StringBuffer sb = new StringBuffer();
		
		//종목명
		if(m_strItemName.equals("0") || m_strItemName.equals("") || m_strItemName.equals(null)){
			sb.append("종목명, 없고,");
		}else{
			sb.append(m_strItemName).append(", ");
		}
		
		//가능수량
		if(m_strCreditEnblQty.equals("0") || m_strCreditEnblQty.equals("") || m_strCreditEnblQty.equals(null)){
			sb.append(", 가능수량, 없고,");
		}else{
			sb.append(m_strCreditEnblQty)
			.append(", 주, ");
		}
		
		//신용구분 (유융, 자융, 유대, 일담, 자대, 대차, 매입, 매도, 대용, 단기, 현금)
		if(m_strCreditCrdtSect.equals("0") || m_strCreditCrdtSect.equals("") || m_strCreditCrdtSect.equals(null)){
			sb.append(", 신용구분, 없고, ");
		}else if(m_strCreditCrdtSect.equals("유융")){
			sb.append(", 유융, ");
		}else if(m_strCreditCrdtSect.equals("자융")){
			sb.append(", 자기융자, ");
		}else if(m_strCreditCrdtSect.equals("유대")){
			sb.append(", 유대, ");
		}else if(m_strCreditCrdtSect.equals("일담")){
			sb.append(", 담보융자, ");
		}else if(m_strCreditCrdtSect.equals("자대")){
			sb.append(", 자대, ");
		}else if(m_strCreditCrdtSect.equals("매입")){
			sb.append(", 매입, ");
		}else if(m_strCreditCrdtSect.equals("매도")){
			sb.append(", 매도, ");
		}else if(m_strCreditCrdtSect.equals("대용")){
			sb.append(", 대용, ");
		}else if(m_strCreditCrdtSect.equals("단기")){
			sb.append(", 단기, ");
		}else if(m_strCreditCrdtSect.equals("현금")){
			sb.append(", 현금, ");
		}else{
			sb.append(", 신용구분, 없고, ");
		}
		
		//융자단가
		if(m_strCreditUprc.equals("0") || m_strCreditUprc.equals("") || m_strCreditUprc.equals(null)){
			sb.append(", 융자단가, 없고,");
		}else{
			sb.append(", 융자단가, ")
			.append(m_strCreditUprc)
			.append(", 원, ");
		}
		
		//융자일자
		if(m_strCreditLoanDate.equals("0") || m_strCreditLoanDate.equals("") || m_strCreditLoanDate.equals(null)){
			sb.append(", 융자일자, 없고,");
		}else{
			sb.append(", 융자일자, ")
			.append(m_strLoanYear).append(", 년, ").append(m_strLoanMonth).append(", 월, ").append(m_strLoanDay).append(", 일, ");
		}
		
		//만기일자
		if(m_strCreditExprDate.equals("0") || m_strCreditExprDate.equals("") || m_strCreditExprDate.equals(null)){
			sb.append(", 만기일자, 없습니다.");
		}else{
			sb.append(", 만기일자, ")
			.append(m_strExprYear).append(", 년, ").append(m_strExprMonth).append(", 월, ").append(m_strExprDay).append(", 일, ")
			.append(", 입니다. ");
		}
		
		actionAPI.setSessionData("ment", sb.toString());
	}
	
	private String trimNum(String num) {
		if (num == null)
			return "0";

		boolean isMinus = false;
		String result = "";

		if (num.startsWith("-")) {
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
		if (result.isEmpty()) {
			return "0";
		}

		if (result.startsWith("."))
			result = "0" + result;

		if (isMinus) {
			result = "-" + result;
		}

		return result;
	}
}
