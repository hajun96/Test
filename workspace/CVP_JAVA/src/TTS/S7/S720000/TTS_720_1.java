package TTS.S7.S720000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_720_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strCardLostDate = (String) actionAPI.getSessionData("m_strCardLostDate"); //����ī�� �н�����
		String m_strSealLostDate = (String) actionAPI.getSessionData("m_strSealLostDate"); //�ΰ� �н�����
		String m_strBankLostDate = (String) actionAPI.getSessionData("m_strBankLostDate"); //���� �н�����
		String m_strSecuCardLostDate = (String) actionAPI.getSessionData("m_strSecuCardLostDate"); //����ī�� �н�����
		String m_strOTPAccidDate = (String) actionAPI.getSessionData("m_strOTPAccidDate"); //OTP �н�����
		String m_strSecretDate = (String) actionAPI.getSessionData("m_strSecretDate"); //���������� �н�����

		StringBuffer sb = new StringBuffer();
		
		
		//����ī��
		if(m_strCardLostDate.length() > 0){
			String m_strCardLostyear = m_strCardLostDate.substring(0, 4);
			String m_strCardLostmonth = m_strCardLostDate.substring(4, 6);
			String m_strCardLostday = m_strCardLostDate.substring(6, 8);
			m_strCardLostmonth = trimNum(m_strCardLostmonth);
			m_strCardLostday = trimNum(m_strCardLostday);
			
			sb.append(m_strCardLostyear)
			.append(", ��, ")
			.append(m_strCardLostmonth)
			.append(", ��, ")
			.append(m_strCardLostday)
			.append(", ��, ")
			.append(", ����ī��, ");
		}else{
			sb.append(",");
		}
		
		//�ΰ�
		if(m_strSealLostDate.length() > 0){
			String m_strSealLostyear = m_strSealLostDate.substring(0, 4);
			String m_strSealLostmonth = m_strSealLostDate.substring(4, 6);
			String m_strSealLostday = m_strSealLostDate.substring(6, 8);
			m_strSealLostmonth = trimNum(m_strSealLostmonth);
			m_strSealLostday = trimNum(m_strSealLostday);
					
			sb.append(m_strSealLostyear)
			.append(", ��, ")
			.append(m_strSealLostmonth)
			.append(", ��, ")
			.append(m_strSealLostday)
			.append(", ��, ")
			.append(", �ΰ�, ");
		}else{
			sb.append(",");
		}
		
		//����
		if(m_strBankLostDate.length() > 0){
			String m_strBankLostyear = m_strBankLostDate.substring(0, 4);
			String m_strBankLostmonth = m_strBankLostDate.substring(4, 6);
			String m_strBankLostday = m_strBankLostDate.substring(6, 8);
			m_strBankLostmonth = trimNum(m_strBankLostmonth);
			m_strBankLostday = trimNum(m_strBankLostday);
					
			sb.append(m_strBankLostyear)
			.append(", ��, ")
			.append(m_strBankLostmonth)
			.append(", ��, ")
			.append(m_strBankLostday)
			.append(", ��, ")
			.append(", ����, ");
			}else{
				sb.append(",");
			}
		

		if(m_strSecuCardLostDate.length() > 0){
			String m_strSecuCardLostyear = m_strSecuCardLostDate.substring(0, 4);
			String m_strSecuCardLostmonth = m_strSecuCardLostDate.substring(4, 6);
			String m_strSecuCardLostday = m_strSecuCardLostDate.substring(6, 8);
			m_strSecuCardLostmonth = trimNum(m_strSecuCardLostmonth);
			m_strSecuCardLostday = trimNum(m_strSecuCardLostday);
					
			sb.append(m_strSecuCardLostyear)
			.append(", ��, ")
			.append(m_strSecuCardLostmonth)
			.append(", ��, ")
			.append(m_strSecuCardLostday)
			.append(", ��, ")
			.append(", ����ī��, ");
		}else{
			sb.append(",");
		}
		
		//OTP
		if(m_strOTPAccidDate.length() != 0){
			String m_strOTPLostyear = m_strOTPAccidDate.substring(0, 4);
			String m_strOTPLostmonth = m_strOTPAccidDate.substring(4, 6);
			String m_strOTPLostday = m_strOTPAccidDate.substring(6, 8);
			m_strOTPLostmonth = trimNum(m_strOTPLostmonth);
			m_strOTPLostday = trimNum(m_strOTPLostday);
			
			sb.append(m_strOTPLostyear)
			.append(", ��, ")
			.append(m_strOTPLostmonth)
			.append(", ��, ")
			.append(m_strOTPLostday)
			.append(", ��, ")
			.append(", OTPī��, ");
		}else{
			sb.append(",");
		}
		
		//����������
		if(m_strSecretDate.length() != 0){
			String m_strSecretLostyear = m_strSecretDate.substring(0, 4);
			String m_strSecretLostmonth = m_strSecretDate.substring(4, 6);
			String m_strSecretLostday = m_strSecretDate.substring(6, 8);
			m_strSecretLostmonth = trimNum(m_strSecretLostmonth);
			m_strSecretLostday = trimNum(m_strSecretLostday);
			
			sb.append(m_strSecretLostyear)
			.append(", ��, ")
			.append(m_strSecretLostmonth)
			.append(", ��, ")
			.append(m_strSecretLostday)
			.append(", ��, ")
			.append(", ����������, ");
		}else{
			sb.append(",");
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
