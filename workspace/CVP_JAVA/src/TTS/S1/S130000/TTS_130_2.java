package TTS.S1.S130000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_130_2 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		/*ItemScd / m_strBalItemcode / 6자리 종목코드
		ItemNo / m_strBalItemFullcode / 12자리 풀 종목코드
		ItemNm / m_strBalItemName / 종목명
		CrdtSect / m_strBalCrdtSect / 신용구분
		HoldQty / m_strBalItemVol / 보유수량
		AvgUprc /  m_strBalAvgUprc / 평균단가 
		EstmAmt / m_strBalEstmAmt / 평가금액*/
		
		//String m_strBalItemcode = (String) actionAPI.getSessionData("m_strBalItemcode"); //6자리 종목코드
		//String m_strBalItemFullcode = (String) actionAPI.getSessionData("m_strBalItemFullcode"); //12자리 풀 종목코드
		String m_strBalItemName = (String) actionAPI.getSessionData("m_strBalItemName"); //종목명
		String m_strBalCrdtSect = (String) actionAPI.getSessionData("m_strBalCrdtSect"); //신용구분
		String m_strBalItemVol = (String) actionAPI.getSessionData("m_strBalItemVol"); //보유수량
		m_strBalItemVol = trimNum(m_strBalItemVol);
		String m_strBalEstmAmt = (String) actionAPI.getSessionData("m_strBalEstmAmt"); //평가금액
		m_strBalEstmAmt = trimNum(m_strBalEstmAmt);
		
		StringBuffer sb = new StringBuffer();
		sb.append(m_strBalItemName).append(", ,");
		
		if(m_strBalCrdtSect.equals("현금")){
			sb.append(", 현금, ");
		}else if(m_strBalCrdtSect.equals("유융")){
			sb.append(", 유통융자, ");
		}else if(m_strBalCrdtSect.equals("자융")){
			sb.append(", 자기융자, ");
		}else if(m_strBalCrdtSect.equals("유대")){
			sb.append(", 유통대주, ");
		}else if(m_strBalCrdtSect.equals("일담")){
			sb.append(", 일반담보대출, ");
		}else if(m_strBalCrdtSect.equals("자대")){
			sb.append(", 자기대주, ");
		}else if(m_strBalCrdtSect.equals("대차")){
			sb.append(", 신용대차, ");
		}else if(m_strBalCrdtSect.equals("매입")){
			sb.append(", 매입자금대출, ");
		}else if(m_strBalCrdtSect.equals("매도")){
			sb.append(", 매도자금담보대출, ");
		}else if(m_strBalCrdtSect.equals("대용")){
			sb.append(", 대용미수금, ");
		}else if(m_strBalCrdtSect.equals("단기")){
			sb.append(", 단기매입자금대출, ");
		}else{
			sb.append("");
		}
		
		//보유수량
		if(m_strBalItemVol.equals("0") || m_strBalItemVol.equals("") || m_strBalItemVol.equals(null)){
			sb.append(", 보유수량, 없고,");
		}else{
			sb.append(m_strBalItemVol)
			.append(", 주 ,");
		}
				
		//평가금액
		if(m_strBalEstmAmt.equals("0") || m_strBalEstmAmt.equals("") || m_strBalEstmAmt.equals(null)){
			sb.append(", 평가금액은, 없습니다.");
		}else{
			sb.append(", 평가금액은 ,")
			.append(m_strBalEstmAmt)
			.append(", 원, ")
			.append(", 입니다. ");
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
