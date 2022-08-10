package TTS.S4.S463000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_463_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strMotgKeepRate = (String) actionAPI.getSessionData("m_strMotgKeepRate"); //�㺸��������
		m_strMotgKeepRate = trimNum(m_strMotgKeepRate);
		String m_strMotgLackTamt = (String) actionAPI.getSessionData("m_strMotgLackTamt"); //�����ݾ�
		m_strMotgLackTamt = trimNum(m_strMotgLackTamt);
		
		StringBuffer sb = new StringBuffer();
		
		if(m_strMotgKeepRate.equals("0")){
			sb.append("���簡 ����, ���� �㺸���� ������,")
			.append(", �����ϴ�. ");
		}else{
			sb.append("���簡 ����, ���� �㺸���� ������,")
			.append(m_strMotgKeepRate)
			.append(", �ۼ�Ʈ, ");
		}
		
		if(m_strMotgLackTamt.equals("0")){
			sb.append("����, �ݾ���, ")
			.append("�����ϴ�.");
		}else{
			sb.append("����, �ݾ���, ")
			.append(m_strMotgLackTamt)
			.append(", ��, ")
			.append("�Դϴ�.");
		}
		
		sb.append("����, ����, �ݿ���, 16��, ���Ŀ�, Ȯ����, �����մϴ�.");
		
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
