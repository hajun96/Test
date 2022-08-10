package TTS.S3.S353000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_353_2 extends ActionElementBase {
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		/*
		원거래일련번호 : m_strRsvTrSeq
		입력좌수 : m_strOffrQty
		입력금액 : m_strOffrAmt
		예약거래일련번호 : m_strBalanSeq*/
		
		String m_strItemNm = (String) actionAPI.getSessionData("m_strItemNm"); //펀드명
		String m_strOffrSect = (String) actionAPI.getSessionData("m_strOffrSect"); //매도매수구분 (DTMF 입력값)
		String m_strChoiceNum = (String) actionAPI.getSessionData("m_strChoiceNum"); //선택한번호
		
		String m_strBalanSeq = (String) actionAPI.getSessionData("m_strBalanSeq");	//잔고번호
		m_strBalanSeq = trimNum(m_strBalanSeq);
		String m_strOffrQty = (String) actionAPI.getSessionData("m_strOffrQty"); //매도수량
		m_strOffrQty = trimNum(m_strOffrQty);
		String m_strOffrAmt = (String) actionAPI.getSessionData("m_strOffrAmt"); //매수금액
		m_strOffrAmt = trimNum(m_strOffrAmt);
		String m_strRsvTrSeq = (String) actionAPI.getSessionData("m_strRsvTrSeq"); //예약거래일련번호
		m_strRsvTrSeq = trimNum(m_strRsvTrSeq);
		
		
		StringBuffer sb = new StringBuffer();
		
		if(m_strOffrSect.equals("3")){ //매도
			sb.append(m_strChoiceNum).append(", 번, ")
			.append(m_strItemNm)
			.append(", 매도수량, ")
			.append(m_strOffrQty).append(", 좌, ")
			.append(", 잔고번호, ")
			.append(m_strBalanSeq)
			.append(", 번,")
			.append(", 펀드매도 취소를 요청하셨습니다.");
		}else if(m_strOffrSect.equals("2")){ //매수
			sb.append(m_strChoiceNum).append(", 번, ")
			.append(m_strItemNm)
			.append(", 매수금액, ")
			.append(m_strOffrAmt).append(", 원, ")
			.append(", 잔고번호, ")
			.append(m_strBalanSeq)
			.append(", 번, ")
			.append(", 펀드매수 취소를 요청하셨습니다.");
		}else{
			sb.append("error");
		}
		actionAPI.setSessionData("m_strBalanSeq", m_strBalanSeq); //잔고번호
		actionAPI.setSessionData("m_strOffrQty", m_strOffrQty); //매도수량
		actionAPI.setSessionData("m_strOffrAmt", m_strOffrAmt); //매수금액
		actionAPI.setSessionData("m_strRsvTrSeq", m_strRsvTrSeq); //예약거래일련번호
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