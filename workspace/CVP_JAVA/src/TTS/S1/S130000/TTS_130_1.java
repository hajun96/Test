package TTS.S1.S130000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_130_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		/*TdayBusinDate / m_strBalBusinDate1 / ���Ͽ������� 
		AftDayBusinDate / m_strBalBusinDate2 / ���Ͽ�������
		Aft2dayBusinDate / m_strBalBusinDate3 / ��2�Ͽ�������
		DepCashAmt / m_strBalDepCashAmt / �����ݾ�
		DepCash1 / m_strBalDepCashAmt1 / ������1
		DepCash2 / m_strBalDepCashAmt2 / ������2
		OamtEnblAmt / m_strBalOutEnAmt / ��ݰ��ɱݾ�
		AssmDepAsstAmt / m_strBalAssmDepAsstAmt / ������Ź�ڻ�ݾ�
		TmpAdjAmt / m_strBalTempAdjAmt / ������ݾ�
		GRID_Cnt / A_CNT / �׸��� ī��Ʈ
		*/
		String m_strBalDepCashAmt = (String) actionAPI.getSessionData("m_strBalDepCashAmt"); //�����ݾ�
		m_strBalDepCashAmt = trimNum(m_strBalDepCashAmt);
		Float f_m_strBalDepCashAmt = Float.parseFloat(m_strBalDepCashAmt);
		String m_strBalTempAdjAmt = (String) actionAPI.getSessionData("m_strBalTempAdjAmt"); //������ݾ�
		m_strBalTempAdjAmt = trimNum(m_strBalTempAdjAmt);
		Float f_m_strBalTempAdjAmt = Float.parseFloat(m_strBalTempAdjAmt);
		String m_strBalOutEnAmt = (String) actionAPI.getSessionData("m_strBalOutEnAmt"); //��ݰ��ɱݾ�
		m_strBalOutEnAmt = trimNum(m_strBalOutEnAmt);
		Float f_m_strBalOutEnAmt = Float.parseFloat(m_strBalOutEnAmt);
		String m_strBalBusinDate1 = (String) actionAPI.getSessionData("m_strBalBusinDate1"); //���Ͽ�������
		String month = m_strBalBusinDate1.substring(4, 6);
		String day = m_strBalBusinDate1.substring(6);
		month = trimNum(month);
		day = trimNum(day);
		
		StringBuffer sb = new StringBuffer();
		
		if(f_m_strBalDepCashAmt != 0.0){
			sb.append(month).append(", ��, ").append(day).append(", ��, ")
			.append(", ��������, ")
			.append(m_strBalDepCashAmt)
			.append(", �� ,");
		}else{
			sb.append(month).append(", ��, ").append(day).append(", ��, ")
			.append(", ��������, ")
			.append(", ����,");
		}
		
		if(f_m_strBalTempAdjAmt != 0.0){
			sb.append(", ������ݾ���, ")
			.append(m_strBalTempAdjAmt)
			.append(", �� ,");
		}else{
			sb.append("������ݾ���")
			.append(", ���� ,");
		}
		
		if(f_m_strBalOutEnAmt != 0.0){
			sb.append(", ��ݰ��ɱݾ���, ")
			.append(m_strBalOutEnAmt)
			.append(", �� ,");
		}else{
			sb.append("��ݰ��ɱݾ���")
			.append(", ���� ,");
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
