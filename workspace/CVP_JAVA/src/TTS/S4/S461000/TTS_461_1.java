package TTS.S4.S461000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_461_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		/*m_strBalBusinDate1 / TnowDayBusinDate		���Ͽ�������       
		m_strBalBusinDate2 / AftnowDayBusinDate		���Ͽ�������       
		m_strBalBusinDate3 / Aft2nowDayBusinDate		��2�Ͽ�������      
		m_strBalDepCashAmt / DepCashAmt		�����ݾ�           
		m_strBalDepCashAmt1 / DepCash1		������1            
		m_strBalDepCashAmt2 / DepCash2		������2            
		m_strBalOutEnAmt / OamtEnblAmt		��ݰ��ɱݾ�       
		m_strBalTempAdjAmt / TmpAdjAmt		������ݾ�*/
		String m_strNowTime = (String) actionAPI.getSessionData("m_strNowTime"); //���� ��, ��, ��
		//[���ó�¥���]
		String nowMonth = m_strNowTime.substring(4, 6);
		String nowDay = m_strNowTime.substring(6);
		nowMonth = trimNum(nowMonth);
		nowDay = trimNum(nowDay);
		
		/*String m_strBalBusinDate1 = (String) actionAPI.getSessionData("m_strBalBusinDate1"); //���Ͽ�������
		String m_strBalBusinDate2 = (String) actionAPI.getSessionData("m_strBalBusinDate2"); //���Ͽ�������
		String m_strBalBusinDate3 = (String) actionAPI.getSessionData("m_strBalBusinDate3"); //��2�Ͽ�������
		String m_strBalDepCashAmt = (String) actionAPI.getSessionData("m_strBalDepCashAmt"); //�����ݾ�
		String m_strBalDepCashAmt1 = (String) actionAPI.getSessionData("m_strBalDepCashAmt1"); //������1
		String m_strBalDepCashAmt2 = (String) actionAPI.getSessionData("m_strBalDepCashAmt2"); //������2
*/		
		String m_strBalDepCashAmt = (String) actionAPI.getSessionData("m_strBalDepCashAmt"); //�����ݾ�
		m_strBalDepCashAmt = trimNum(m_strBalDepCashAmt);
		Float f_m_strBalDepCashAmt = Float.parseFloat(m_strBalDepCashAmt);
		
		String m_strBalOutEnAmt = (String) actionAPI.getSessionData("m_strBalOutEnAmt"); //��ݰ��ɱݾ�
		m_strBalOutEnAmt = trimNum(m_strBalOutEnAmt);
		Float f_m_strBalOutEnAmt = Float.parseFloat(m_strBalOutEnAmt);
		
		String m_strBalTempAdjAmt = (String) actionAPI.getSessionData("m_strBalTempAdjAmt"); //������ݾ�
		m_strBalTempAdjAmt = trimNum(m_strBalTempAdjAmt);
		Float f_m_strBalTempAdjAmt = Float.parseFloat(m_strBalTempAdjAmt);
		
		StringBuffer sb = new StringBuffer();
		sb.append(nowMonth).append(", ��, ").append(nowDay).append(", ��, ");
		sb.append("�ſ�����, �ܰ��, ");

		if(f_m_strBalDepCashAmt != 0.0){
			sb.append(", ��������, ")
			.append(m_strBalDepCashAmt)
			.append(", ��, ");
		}else{
			sb.append(", ��������, ")
			.append(", ����, ");
		}
		
		if(f_m_strBalTempAdjAmt != 0.0){
			sb.append(", ������ݾ���, ")
			.append(m_strBalTempAdjAmt)
			.append(", ��, ");
		}else{
			sb.append(", ������ݾ���, ")
			.append(", ����, ");
		}
		
		if(f_m_strBalOutEnAmt != 0.0){
			sb.append(", ��ݰ��ɱݾ���, ")
			.append(m_strBalOutEnAmt)
			.append(", ��, ");
		}else{
			sb.append(", ��ݰ��ɱݾ���, ")
			.append(", ����, ");
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
