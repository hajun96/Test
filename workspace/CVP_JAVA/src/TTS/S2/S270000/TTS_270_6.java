package TTS.S2.S270000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_270_6 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strFrgTrd4 = (String) actionAPI.getSessionData("m_strFrgTrd4"); //�ܱ��θŸ�
		String m_strAgcyTrd4 = (String) actionAPI.getSessionData("m_strAgcyTrd4"); //����Ÿ�
		String m_strGenTrd4 = (String) actionAPI.getSessionData("m_strGenTrd4"); //�ϹݸŸ�
		
		//[�ܱ��θŸ� ����] 
		m_strFrgTrd4 = trimNum(m_strFrgTrd4);
		Float f_m_strFrgTrd4 = Float.parseFloat(m_strFrgTrd4);
		
		//[����Ÿ� ����]
		m_strAgcyTrd4 = trimNum(m_strAgcyTrd4);
		Float f_m_strAgcyTrd4 = Float.parseFloat(m_strAgcyTrd4);
		
		//[�ϹݸŸ� ����]
		m_strGenTrd4 = trimNum(m_strGenTrd4);
		Float f_m_strGenTrd4 = Float.parseFloat(m_strGenTrd4);
		
		StringBuffer sb = new StringBuffer();
		
		if(f_m_strFrgTrd4 > 0){
			sb.append("ǲ�ɼ� ������, ")
			.append(", �ܱ���, ")
			.append(", ���ż�, ")
			.append(m_strFrgTrd4).append(", , ")
			.append(", ��, ");
		}else if(f_m_strFrgTrd4 < 0){
			sb.append("ǲ�ɼ� ������, ")
			.append(", �ܱ���, ")
			.append(", ���ŵ�, ")
			.append(m_strFrgTrd4).append(", , ")
			.append(", ��, ");
		}else{
			sb.append("ǲ�ɼ� ������, ")
			.append(", �ܱ���, ")
			.append(m_strFrgTrd4).append(", , ")
			.append(", ��, ");
		}
		
		if(f_m_strAgcyTrd4 > 0){
			sb.append("���, ")
			.append(", ���ż�, ")
			.append(m_strAgcyTrd4).append(", , ")
			.append(", ��, ");
		}else if(f_m_strAgcyTrd4 < 0){
			sb.append("���, ")
			.append(", ���ŵ�, ")
			.append(m_strAgcyTrd4).append(", , ")
			.append(", ��, ");
		}else{
			sb.append("���, ")
			.append(m_strAgcyTrd4).append(", , ")
			.append(", ��, ");
		}

		if(f_m_strGenTrd4 > 0){
			sb.append("����, ")
			.append(", ���ż�, ")
			.append(m_strGenTrd4).append(", , ")
			.append(", ��, ")
			.append(", �̸�, ");
		}else if(f_m_strGenTrd4 < 0){
			sb.append("����, ")
			.append(", ���ŵ�, ")
			.append(m_strGenTrd4).append(", , ")
			.append(", ��, ")
			.append(", �̸�, ");
		}else{
			sb.append("����, ")
			.append(m_strGenTrd4).append(", , ")
			.append(", ��, ")
			.append(", �̸�, ");
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
