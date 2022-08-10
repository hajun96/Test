package TTS.S3.S351000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_351_3 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strItemNm = (String) actionAPI.getSessionData("m_strItemNm");// 종목명
		String m_strInOrderVol = (String) actionAPI.getSessionData("m_strInOrderVol"); // 매도 수량
		String m_strBalanSeq = (String) actionAPI.getSessionData("m_strBalanSeq"); // 잔고 번호
		String m_strSellAmtStckCntSect = (String) actionAPI.getSessionData("m_strSellAmtStckCntSect"); // 1:일부 / 2:전량
		String m_strFeeTot = (String) actionAPI.getSessionData("m_strFeeTot"); // 환매수수료
		
		
		/*종목명 (m_strItemNm) 
		수량 (m_strInOrderVol) 좌, 
		잔고번호  (m_strBalanSeq) 번을 
		(전량 / 일부) 매도 신청하셨습니다.
		펀드 매도시 
		환매수수료 ##원이 적용됩니다.*/
		m_strInOrderVol = trimNum(m_strInOrderVol);
		m_strBalanSeq = trimNum(m_strBalanSeq);
		m_strFeeTot = trimNum(m_strFeeTot);
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(m_strItemNm); 
		
		if(m_strInOrderVol.equals("0") || m_strInOrderVol.equals(null)){
			sb.append(", 수량, ")
			.append(", 없습니다. ");
		}else{
			sb.append(", 수량, ")
			.append(m_strInOrderVol)
			.append(", 좌, ");
		}
		
		sb.append(", 잔고번호, ")
		.append(m_strBalanSeq)
		.append(", 번을, "); 
		
		if(m_strSellAmtStckCntSect.equals("1")){
			sb.append(", 일부, 매도 신청 하셨습니다.");
		}else if(m_strSellAmtStckCntSect.equals("2")){
			sb.append(", 전량, 매도 신청 하셨습니다.");
		}else{
			sb.append(", 매도 신청 하셨습니다.");
		}
		
		if(m_strFeeTot.equals("0") || m_strFeeTot.equals(null)){
			sb.append(",환매 수수료는 없습니다.");
		}else{
			sb.append(",환매 수수료는")
			.append(m_strFeeTot)
			.append(",원이 적용 됩니다.");
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
