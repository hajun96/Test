package TTS.S3.S354000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_354_1 extends ActionElementBase {
	public void doAction(String name, ActionElementData actionAPI)throws AudiumException {
		String m_strTrdTypeSect = (String) actionAPI.getSessionData("m_strTrdTypeSect"); //매매유형구분 (1. 매도, 2. 매수, 3. 전환)
		String m_strProcStatSect = (String) actionAPI.getSessionData("m_strProcStatSect"); //처리상태구분 (1. 신청중 2. 신청취소 3. 결제완료 4. 결제취소)
		String m_strItemNm = (String) actionAPI.getSessionData("m_strItemNm");	//종목명
		String m_strBalanSeq = (String) actionAPI.getSessionData("m_strBalanSeq"); //잔고일련번호
		m_strBalanSeq = trimNum(m_strBalanSeq);
		String m_strOffrDate = (String) actionAPI.getSessionData("m_strOffrDate"); //신청일자
		
		String m_strApplicationYear = m_strOffrDate.substring(0, 4); // 신청일자 년
		String m_strApplicationMonth = m_strOffrDate.substring(4, 6); // 신청일자 월
		m_strApplicationMonth = trimNum(m_strApplicationMonth);
		String m_strApplicationDay = m_strOffrDate.substring(6, 8); // 신청일자 일
		m_strApplicationDay = trimNum(m_strApplicationDay);
		
		String m_strOffrQty = (String) actionAPI.getSessionData("m_strOffrQty"); //신청수량
		m_strOffrQty = trimNum(m_strOffrQty);
		String m_strOffrAmt = (String) actionAPI.getSessionData("m_strOffrAmt"); //신청금액
		m_strOffrAmt = trimNum(m_strOffrAmt);
		
		String m_strBsprAplyDate = (String) actionAPI.getSessionData("m_strBsprAplyDate"); //기준가적용일자		
		String m_strBsprAplyYear = m_strBsprAplyDate.substring(0, 4); // 신청일자 년
		String m_strBsprAplyMonth = m_strBsprAplyDate.substring(4, 6); // 신청일자 월
		m_strBsprAplyMonth = trimNum(m_strBsprAplyMonth);
		String m_strBsprAplyDay = m_strBsprAplyDate.substring(6, 8); // 신청일자 일
		m_strBsprAplyDay = trimNum(m_strBsprAplyDay);
		
		
		StringBuffer sb = new StringBuffer();
		if(m_strTrdTypeSect.equals("1")){
			sb.append("신청일, ")
			.append(m_strApplicationYear)
			.append(", 년, ")
			.append(m_strApplicationMonth)
			.append(", 월, ")
			.append(m_strApplicationDay)
			.append(", 일, ")
			.append(m_strBalanSeq)
			.append(", 번의, ")
			.append(m_strItemNm)
			.append(m_strBsprAplyYear)
			.append(", 년, ")
			.append(m_strBsprAplyMonth)
			.append(", 월, ")
			.append(m_strBsprAplyDay)
			.append(", 일, ")
			.append(", 기준가로, ")
			.append(m_strOffrQty)
			.append(", 좌를, ")
			.append(", 매도, ");
			
			if(m_strProcStatSect.equals("1")){//1. 신청중 
				sb.append(",신청, 하셨습니다.");
			}else if(m_strProcStatSect.equals("2")){//2. 신청취소 
				sb.append(",신청취소, 하셨습니다.");
			}else if(m_strProcStatSect.equals("3")){//3. 결제완료 
				sb.append(",결제완료, 하셨습니다.");
			}else if(m_strProcStatSect.equals("4")){//4. 결제취소
				sb.append(",결제취소, 하셨습니다.");
			}else{
				sb.append("하셨습니다.");
			}
		}else if(m_strTrdTypeSect.equals("2")){ //매수
			sb.append("신청일, ")
			.append(m_strApplicationYear)
			.append(", 년, ")
			.append(m_strApplicationMonth)
			.append(", 월, ")
			.append(m_strApplicationDay)
			.append(", 일, ")
			.append(m_strBalanSeq)
			.append(", 번의, ")
			.append(m_strItemNm)
			.append(m_strBsprAplyYear)
			.append(", 년, ")
			.append(m_strBsprAplyMonth)
			.append(", 월, ")
			.append(m_strBsprAplyDay)
			.append(", 일, ")
			.append(", 기준가로, ")
			.append(m_strOffrAmt)
			.append(", 원을, ")
			.append(", 매수, ");
			
			if(m_strProcStatSect.equals("1")){//1. 신청중 
				sb.append(",신청, 하셨습니다.");
			}else if(m_strProcStatSect.equals("2")){//2. 신청취소 
				sb.append(",신청취소, 하셨습니다.");
			}else if(m_strProcStatSect.equals("3")){//3. 결제완료 
				sb.append(",결제완료, 하셨습니다.");
			}else if(m_strProcStatSect.equals("4")){//4. 결제취소
				sb.append(",결제취소, 하셨습니다.");
			}else{
				sb.append("하셨습니다.");
			}
					
					
		}else{ //그외
			sb.append("error");
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