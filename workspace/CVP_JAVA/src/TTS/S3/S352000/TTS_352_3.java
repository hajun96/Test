package TTS.S3.S352000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_352_3 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strItemNm = (String) actionAPI.getSessionData("m_strItemNm"); // 종목명
		String m_strBalanSeq = (String) actionAPI.getSessionData("m_strBalanSeq"); // 잔고 번호
		m_strBalanSeq = trimNum(m_strBalanSeq);
		String m_strInOrderPrice = (String) actionAPI.getSessionData("m_strInOrderPrice"); // 추가매수금액
		String m_strBsprAplyDate = (String) actionAPI.getSessionData("m_strBsprAplyDate"); // 기준가적용일자
		String m_strSttDate = (String) actionAPI.getSessionData("m_strSttDate"); // 펀드결제일자
		
		StringBuffer sb = new StringBuffer();
		
		if(m_strItemNm.equals("0") || m_strItemNm.equals("") || m_strItemNm.equals(null)){
			sb.append(",");
		}else{
			sb.append(m_strItemNm).append(", ");
		}
		
		if(m_strBalanSeq.equals("0") || m_strBalanSeq.equals("") || m_strBalanSeq.equals(null)){
			sb.append("잔고번호, ")
			.append(", 없고, ");
		}else{
			sb.append("잔고번호, ")
			.append(m_strBalanSeq)
			.append(", 번으로, ");
		}
		
		if(m_strInOrderPrice.equals("0") || m_strInOrderPrice.equals("") || m_strInOrderPrice.equals(null)){
			sb.append("추가매수금액, ")
			.append(", 없습니다., ");
		}else{
			sb.append(m_strInOrderPrice)
			.append(", 원, ")
			.append(", 추가매수 신청 하셨습니다.");
		}
		
		if(m_strBsprAplyDate.equals("0") || m_strBsprAplyDate.equals("") || m_strBsprAplyDate.equals(null)){
			sb.append(", 기준가 적용일은, ")
			.append(", 없으며, ");
		}else{
			String SellBsprAplyDate1 = m_strBsprAplyDate.substring(0, 4); // 년
			String SellBsprAplyDate2 = m_strBsprAplyDate.substring(4, 6); // 월
			SellBsprAplyDate2 = trimNum(SellBsprAplyDate2);
			String SellBsprAplyDate3 = m_strBsprAplyDate.substring(6, 8); // 일
			SellBsprAplyDate3 = trimNum(SellBsprAplyDate3);
			
			sb.append(", 기준가 적용일은, ")
			.append(SellBsprAplyDate1).append(", 년, ")
			.append(SellBsprAplyDate2).append(", 월, ")
			.append(SellBsprAplyDate3).append(", 일, 이며,");
		}
		
		//m_strSttDate
		if(m_strSttDate.equals("0") || m_strSttDate.equals("") || m_strSttDate.equals(null)){
			sb.append(", 펀드 결제일은, ")
			.append(", 없으며, ");
		}else{
			String m_strSellSttDate1 = m_strSttDate.substring(0, 4); // 년
			String m_strSellSttDate2 = m_strSttDate.substring(4, 6); // 월
			m_strSellSttDate2 = trimNum(m_strSellSttDate2);
			String m_strSellSttDate3 = m_strSttDate.substring(6, 8); // 일
			m_strSellSttDate3 = trimNum(m_strSellSttDate3);
			sb.append(", 펀드 결제일은, ")
			.append(m_strSellSttDate1).append(", 년, ")
			.append(m_strSellSttDate2).append(", 월, ")
			.append(m_strSellSttDate3).append(", 일, 입니다.");
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
