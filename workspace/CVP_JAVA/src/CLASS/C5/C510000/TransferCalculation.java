package CLASS.C5.C510000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TransferCalculation extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		// m_strTotOamtAmt = m_strTotOamtAmt + m_strFeeAmt
		String m_strTotOamtAmt = (String) actionAPI.getSessionData("m_strFtrnAmt"); //이체금액
		m_strTotOamtAmt = trimNum(m_strTotOamtAmt);
		Float f_m_strTotOamtAmt = Float.parseFloat(m_strTotOamtAmt);
		String m_strFeeAmt = (String) actionAPI.getSessionData("m_strFeeAmt");	//이체수수료
		m_strFeeAmt = trimNum(m_strFeeAmt);
		Float f_m_strFeeAmt = Float.parseFloat(m_strFeeAmt);
		
		//이체금액 + 이체수수료 계산
		f_m_strTotOamtAmt = f_m_strTotOamtAmt + f_m_strFeeAmt;
		
		//반올림
		int i_m_strTotOamtAmt = Math.round(f_m_strTotOamtAmt);
		m_strTotOamtAmt = String.valueOf(i_m_strTotOamtAmt);
		actionAPI.setSessionData("m_strTotOamtAmt", m_strTotOamtAmt);
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
