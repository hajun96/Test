package TTS.S2.S210000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_210_4 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strOfferAmt9 = (String) actionAPI.getSessionData("m_strOfferAmt9"); //매도1호가
		String m_strOfferVol9 = (String) actionAPI.getSessionData("m_strOfferVol9"); //매도1호가잔량
		String m_strBidAmt0 = (String) actionAPI.getSessionData("m_strBidAmt0"); //매수1호가
		String m_strBidVol0 = (String) actionAPI.getSessionData("m_strBidVol0"); //매수1호가잔량
		m_strOfferAmt9 = trimNum(m_strOfferAmt9);
		m_strOfferVol9 = trimNum(m_strOfferVol9);
		m_strBidAmt0 = trimNum(m_strBidAmt0);
		m_strBidVol0 = trimNum(m_strBidVol0); 
		
		String m_strOfferAmt8 = (String) actionAPI.getSessionData("m_strOfferAmt8"); //매도2호가
		String m_strOfferVol8 = (String) actionAPI.getSessionData("m_strOfferVol8"); //매도2호가잔량
		String m_strBidAmt1 = (String) actionAPI.getSessionData("m_strBidAmt1"); //매수2호가
		String m_strBidVol1 = (String) actionAPI.getSessionData("m_strBidVol1"); //매수2호가잔량
		m_strOfferAmt8 = trimNum(m_strOfferAmt8);
		m_strOfferVol8 = trimNum(m_strOfferVol8);
		m_strBidAmt1 = trimNum(m_strBidAmt1);
		m_strBidVol1 = trimNum(m_strBidVol1); 
		
		String m_strOfferAmt7 = (String) actionAPI.getSessionData("m_strOfferAmt7"); //매도3호가
		String m_strOfferVol7 = (String) actionAPI.getSessionData("m_strOfferVol7"); //매도3호가잔량
		String m_strBidAmt2 = (String) actionAPI.getSessionData("m_strBidAmt2"); //매수3호가
		String m_strBidVol2 = (String) actionAPI.getSessionData("m_strBidVol2"); //매수3호가잔량
		m_strOfferAmt7 = trimNum(m_strOfferAmt7);
		m_strOfferVol7 = trimNum(m_strOfferVol7);
		m_strBidAmt2 = trimNum(m_strBidAmt2);
		m_strBidVol2 = trimNum(m_strBidVol2); 
		
		String m_strOfferAmt6 = (String) actionAPI.getSessionData("m_strOfferAmt6"); //매도4호가
		String m_strOfferVol6 = (String) actionAPI.getSessionData("m_strOfferVol6"); //매도4호가잔량
		String m_strBidAmt3 = (String) actionAPI.getSessionData("m_strBidAmt3"); //매수4호가
		String m_strBidVol3 = (String) actionAPI.getSessionData("m_strBidVol3"); //매수4호가잔량
		m_strOfferAmt6 = trimNum(m_strOfferAmt6);
		m_strOfferVol6 = trimNum(m_strOfferVol6);
		m_strBidAmt3 = trimNum(m_strBidAmt3);
		m_strBidVol3 = trimNum(m_strBidVol3);
		
		String m_strOfferAmt5 = (String) actionAPI.getSessionData("m_strOfferAmt5"); //매도5호가
		String m_strOfferVol5 = (String) actionAPI.getSessionData("m_strOfferVol5"); //매도5호가잔량
		String m_strBidAmt4 = (String) actionAPI.getSessionData("m_strBidAmt4"); //매수4호가
		String m_strBidVol4 = (String) actionAPI.getSessionData("m_strBidVol4"); //매수4호가잔량
		m_strOfferAmt5 = trimNum(m_strOfferAmt5);
		m_strOfferVol5 = trimNum(m_strOfferVol5);
		m_strBidAmt4 = trimNum(m_strBidAmt4);
		m_strBidVol4 = trimNum(m_strBidVol4); 
		
		StringBuffer sb = new StringBuffer();
		
		//매도1호가
		if(m_strOfferAmt9.equals("0") || m_strOfferAmt9.equals("") || m_strOfferAmt9.equals(null)){
			sb.append(", 매도, ")
			.append(", 1, 호가는, ")
			.append(", 없고, "); 
		}else{
			sb.append("매도, ")
			.append(", 1, 호가는, ")
			.append(m_strOfferAmt9)
			.append(", 원에, ");
		}
		//매도1호가잔량
		if(m_strOfferVol9.equals("0") || m_strOfferVol9.equals("") || m_strOfferVol9.equals(null)){
			sb.append("잔량은, ")
			.append(", 없고, ");
		}else{
			sb.append("잔량은, ")
			.append(m_strOfferVol9)
			.append(", 주, ");
		}
		//매수1호가
		if(m_strBidAmt0.equals("0") || m_strBidAmt0.equals("") || m_strBidAmt0.equals(null)){
			sb.append(", 매수, ")
			.append(", 1, 호가는, ")
			.append(", 없고, ");
		}else{
			sb.append("매수, ")
			.append(", 1, 호가는, ")
			.append(m_strBidAmt0)
			.append(", 원에, ");
		}
		//매수1호가잔량
		if(m_strBidVol0.equals("0") || m_strBidVol0.equals("") || m_strBidVol0.equals(null)){
			sb.append("잔량은, ")
			.append(", 없습니다.");
		}else{
			sb.append("잔량은, ")
			.append(m_strBidVol0)
			.append(", 주, ")
			.append(", 입니다.");
		}
		
		
		//매도2호가
		if(m_strOfferAmt8.equals("0") || m_strOfferAmt8.equals("") || m_strOfferAmt8.equals(null)){
			sb.append(", 매도, ")
			.append(", 2, 호가는, ")
			.append(", 없고, "); 
		}else{
			sb.append("매도, ")
			.append(", 2, 호가는, ")
			.append(m_strOfferAmt8)
			.append(", 원에, ");
		}
		//매도2호가잔량
		if(m_strOfferVol8.equals("0") || m_strOfferVol8.equals("") || m_strOfferVol8.equals(null)){
			sb.append("잔량은, ")
			.append(", 없고, ");
		}else{
			sb.append("잔량은, ")
			.append(m_strOfferVol8)
			.append(", 주, ");
		}
		//매수2호가
		if(m_strBidAmt1.equals("0") || m_strBidAmt1.equals("") || m_strBidAmt1.equals(null)){
			sb.append(", 매수, ")
			.append(", 2, 호가는, ")
			.append(", 없고, ");
		}else{
			sb.append("매수, ")
			.append(", 2, 호가는, ")
			.append(m_strBidAmt1)
			.append(", 원에, ");
		}
		//매수2호가잔량
		if(m_strBidVol1.equals("0") || m_strBidVol1.equals("") || m_strBidVol1.equals(null)){
			sb.append("잔량은, ")
			.append(", 없습니다.");
		}else{
			sb.append("잔량은, ")
			.append(m_strBidVol1)
			.append(", 주, ")
			.append(", 입니다.");
		}
		
		//매도3호가
		if(m_strOfferAmt7.equals("0") || m_strOfferAmt7.equals("") || m_strOfferAmt7.equals(null)){
			sb.append(", 매도, ")
			.append(", 3, 호가는, ")
			.append(", 없고, "); 
		}else{
			sb.append("매도, ")
			.append(", 3, 호가는, ")
			.append(m_strOfferAmt7)
			.append(", 원에, ");
		}
		//매도3호가잔량
		if(m_strOfferVol7.equals("0") || m_strOfferVol7.equals("") || m_strOfferVol7.equals(null)){
			sb.append("잔량은, ")
			.append(", 없고, ");
		}else{
			sb.append("잔량은, ")
			.append(m_strOfferVol7)
			.append(", 주, ");
		}
		//매수3호가
		if(m_strBidAmt2.equals("0") || m_strBidAmt2.equals("") || m_strBidAmt2.equals(null)){
			sb.append(", 매수, ")
			.append(", 3, 호가는, ")
			.append(", 없고, ");
		}else{
			sb.append("매수, ")
			.append(", 3, 호가는, ")
			.append(m_strBidAmt2)
			.append(", 원에, ");
		}
		//매수3호가잔량
		if(m_strBidVol2.equals("0") || m_strBidVol2.equals("") || m_strBidVol2.equals(null)){
			sb.append("잔량은, ")
			.append(", 없습니다.");
		}else{
			sb.append("잔량은, ")
			.append(m_strBidVol2)
			.append(", 주, ")
			.append(", 입니다.");
		}
		
		//매도4호가
		if(m_strOfferAmt6.equals("0") || m_strOfferAmt6.equals("") || m_strOfferAmt6.equals(null)){
			sb.append(", 매도, ")
			.append(", 4, 호가는, ")
			.append(", 없고, "); 
		}else{
			sb.append("매도, ")
			.append(", 4, 호가는, ")
			.append(m_strOfferAmt6)
			.append(", 원에, ");
		}
		//매도4호가잔량
		if(m_strOfferVol6.equals("0") || m_strOfferVol6.equals("") || m_strOfferVol6.equals(null)){
			sb.append("잔량은, ")
			.append(", 없고, ");
		}else{
			sb.append("잔량은, ")
			.append(m_strOfferVol6)
			.append(", 주, ");
		}
		//매수4호가
		if(m_strBidAmt3.equals("0") || m_strBidAmt3.equals("") || m_strBidAmt3.equals(null)){
			sb.append(", 매수, ")
			.append(", 4, 호가는, ")
			.append(", 없고, ");
		}else{
			sb.append("매수, ")
			.append(", 4, 호가는, ")
			.append(m_strBidAmt3)
			.append(", 원에, ");
		}
		//매수4호가잔량
		if(m_strBidVol3.equals("0") || m_strBidVol3.equals("") || m_strBidVol3.equals(null)){
			sb.append("잔량은, ")
			.append(", 없습니다.");
		}else{
			sb.append("잔량은, ")
			.append(m_strBidVol3)
			.append(", 주, ")
			.append(", 입니다.");
		}

		//매도5호가
		if(m_strOfferAmt5.equals("0") || m_strOfferAmt5.equals("") || m_strOfferAmt5.equals(null)){
			sb.append(", 매도, ")
			.append(", 5, 호가는, ")
			.append(", 없고, "); 
		}else{
			sb.append("매도, ")
			.append(", 5, 호가는, ")
			.append(m_strOfferAmt5)
			.append(", 원에, ");
		}
		//매도5호가잔량
		if(m_strOfferVol5.equals("0") || m_strOfferVol5.equals("") || m_strOfferVol5.equals(null)){
			sb.append("잔량은, ")
			.append(", 없고, ");
		}else{
			sb.append("잔량은, ")
			.append(m_strOfferVol5)
			.append(", 주, ");
		}
		//매수5호가
		if(m_strBidAmt4.equals("0") || m_strBidAmt4.equals("") || m_strBidAmt4.equals(null)){
			sb.append(", 매수, ")
			.append(", 5, 호가는, ")
			.append(", 없고, ");
		}else{
			sb.append("매수, ")
			.append(", 5, 호가는, ")
			.append(m_strBidAmt4)
			.append(", 원에, ");
		}
		//매수4호가잔량
		if(m_strBidVol4.equals("0") || m_strBidVol4.equals("") || m_strBidVol4.equals(null)){
			sb.append("잔량은, ")
			.append(", 없습니다.");
		}else{
			sb.append("잔량은, ")
			.append(m_strBidVol4)
			.append(", 주, ")
			.append(", 입니다.");
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
