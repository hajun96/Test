package TTS.S3.S347000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_347_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI)throws AudiumException {
		/*m_strPrevOrderNum : 주문번호
		m_strOrderItemCode : 종목코드
		m_strItemName : 종목명
		m_strOrderVol : 주문수량
		m_strOrderPrice : 주문단가
		m_strContVol : 체결수량
		m_strContPrice : 체결단가
		m_strTrdSect : 매도매수구분 (1:매도, 2:매수)
		m_strTrdKindSect : 매매종류구분(01:지정가, 02:임의, 05:시장가, 06:조건부지정가)
		m_strOrdMkSect : 주문장구분(1.장개시전종가, 2.장중, 3.시간외종가, 4.시간외단일가, 5.ECN(현재미사용), 9.단주)
		m_strOrdSect : 주문구분( 01:현금매도, 02:현금매수, 03:신용매도(코스닥포함) , 04:신용매수(코스닥포함) , 05:저축매도 , 06:저축매수, 07:채권매도 , 08:채권매수, 09:코스닥현금매도, 10:코스닥현금매수 , 11:코스닥저축매도 , 12:코스닥저축매수, 13:프리보드매도, 14:프리보드매수)
		m_strUpdtCnclSect : 매매구분(0: 주문, 1: 정정, 2: 취소)
		m_strOrdCrdtLoanSect : 신용대출구분*/
		
		String m_strPrevOrderNum = (String) actionAPI.getSessionData("m_strPrevOrderNum");	//주문번호
		m_strPrevOrderNum = trimNum(m_strPrevOrderNum);
		String m_strUpdtCnclSect = (String) actionAPI.getSessionData("m_strUpdtCnclSect");	//(0: 주문, 1: 정정, 2: 취소)
		String m_strOrderPrice = (String) actionAPI.getSessionData("m_strOrderPrice");	//주문단가
		m_strOrderPrice = trimNum(m_strOrderPrice);
		String m_strOrderVol = (String) actionAPI.getSessionData("m_strOrderVol");	//주문수량
		m_strOrderVol = trimNum(m_strOrderVol);
		String m_strContVol = (String) actionAPI.getSessionData("m_strContVol");	//체결수량
		m_strContVol = trimNum(m_strContVol);
		String m_strTrdSect = (String) actionAPI.getSessionData("m_strTrdSect");	//매도매수구분 (1:매도, 2:매수)
		m_strTrdSect = trimNum(m_strTrdSect);
		String m_strOrdCrdtLoanSect = (String) actionAPI.getSessionData("m_strOrdCrdtLoanSect");	//신용대출구분
		
		StringBuffer sb = new StringBuffer();
		
		//주문번호
		if(m_strOrdCrdtLoanSect.equals("0") || m_strOrdCrdtLoanSect.equals("") || m_strOrdCrdtLoanSect.equals(null)){
			sb.append("신용대출구분, 없고,");
		}else if(m_strOrdCrdtLoanSect.equals("01")){//유통융자
			sb.append(", 자기융자, ");
		}else if(m_strOrdCrdtLoanSect.equals("03")){//자기융자
			sb.append(", 자기융자, ");
		}else if(m_strOrdCrdtLoanSect.equals("06")){//자기융자
			sb.append(", 담보융자, ");
		}else{
			sb.append(",");
		}
		
		//주문번호
		if(m_strPrevOrderNum.equals("0") || m_strPrevOrderNum.equals("") || m_strPrevOrderNum.equals(null)){
			sb.append("원주문번호, 없고,");
		}else{
			sb.append("원주문번호, ")
			.append(m_strPrevOrderNum)
			.append(", 번, ");
		}
		
		//주문가격
		if(m_strOrderPrice.equals("0") || m_strOrderPrice.equals("") || m_strOrderPrice.equals(null)){
			sb.append(",");
		}else{
			sb.append(m_strOrderPrice)
			.append(", 원, ");
		}
		
		
		//미체결내역수량 = 주문수량 - 체결수량
	    if(m_strOrderVol.equals("0") || m_strOrderVol.equals("") || m_strOrderVol.equals(null)){
			   sb.append("주문수량, 없고,");
		}else{
			long m_lOrderVol = Long.parseLong(m_strOrderVol);
			long m_lContVol = Long.parseLong(m_strContVol);
			long m_lVol = m_lOrderVol - m_lContVol;
			String m_strVol = String.valueOf(m_lVol);
			sb.append(m_strVol)
			.append(", 주, ");
			}
		
		
		//매도매수구분
		if(m_strTrdSect.equals("1")){
			sb.append(", 매도, ");
		}else if(m_strTrdSect.equals("2")){
			sb.append(", 매수, ");
		}else{
			sb.append(", 매수, ");
		}
		
		if(m_strUpdtCnclSect.equals("1")){
			sb.append(", 정정, ");
		}else{
			sb.append(",");
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
