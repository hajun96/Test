package TTS.S1.S111000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_111_3 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		/*111000_Ing_4_TTS : 
			���ϴ�� {Data.Session.m_strCurrentFluctAmt} ��, 
			���� �⼼��������, {Data.Session.m_strCurrentAmt} ��,
			�ŷ����� {Data.Session.m_strCurrentVolume} ��, �Դϴ�.
			*/
		String m_strCurrentFluctFlag = (String) actionAPI.getSessionData("m_strCurrentFluctFlag");
		
		String m_strCurrentFluctAmt = (String) actionAPI.getSessionData("m_strCurrentFluctAmt");
		m_strCurrentFluctAmt = trimNum(m_strCurrentFluctAmt);
		String m_strCurrentAmt = (String) actionAPI.getSessionData("m_strCurrentAmt");
		m_strCurrentAmt = trimNum(m_strCurrentAmt);
		
		String m_strCurrentVolume = (String) actionAPI.getSessionData("m_strCurrentVolume");
		m_strCurrentVolume = trimNum(m_strCurrentVolume);
		Float f_m_strCurrentVolume = Float.parseFloat(m_strCurrentVolume);
		
		StringBuffer sb = new StringBuffer();
		
		if(m_strCurrentFluctFlag.equals("0")){			//����
			sb.append(", ������, ")
			.append(m_strCurrentAmt)
			.append(", ��, ");
		}else if(m_strCurrentFluctFlag.equals("1")){	//����
			sb.append(m_strCurrentFluctAmt)
			.append(", ��, ")
			.append(", ����, ")
			.append(m_strCurrentAmt)
			.append(", ��, ");
		}else if(m_strCurrentFluctFlag.equals("2")){	//���Ѱ�
			sb.append(", ���ϴ��, ")
			.append(m_strCurrentFluctAmt)
			.append(", ��, ")
			.append(", ����, ")
			.append(", ���Ѱ���, ")
			.append(m_strCurrentAmt)
			.append(", ��, ");
		}else if(m_strCurrentFluctFlag.equals("3")){	//�⼼���
			sb.append(", ���ϴ��, ")
			.append(m_strCurrentFluctAmt)
			.append(", ��, ")
			.append(", ����, ")
			.append(", �⼼��� ����, ")
			.append(m_strCurrentAmt)
			.append(", ��, ");
		}else if(m_strCurrentFluctFlag.equals("4")){	//�⼼����
			sb.append(", ���ϴ��, ")
			.append(m_strCurrentFluctAmt)
			.append(", ��, ")
			.append(", ����, ")
			.append(", �⼼���� ����, ")
			.append(m_strCurrentAmt)
			.append(", ��, ");
		}else if(m_strCurrentFluctFlag.equals("5")){	//����
			sb.append(m_strCurrentFluctAmt)
			.append(", ��, ")
			.append(", ����, ")
			.append(m_strCurrentAmt)
			.append(", ��, ");
		}else if(m_strCurrentFluctFlag.equals("6")){	//���Ѱ�
			sb.append(", ���ϴ��, ")
			.append(m_strCurrentFluctAmt)
			.append(", ��, ")
			.append(", ����, ")
			.append(", ���Ѱ���, ")
			.append(m_strCurrentAmt)
			.append(", ��, ");
		}else if(m_strCurrentFluctFlag.equals("7")){	//�⼼�϶�
			sb.append(", ���ϴ��, ")
			.append(m_strCurrentFluctAmt)
			.append(", ��, ")
			.append(", ����, ")
			.append(", �⼼�϶� ����, ")
			.append(m_strCurrentAmt)
			.append(", ��, ");
		}else if(m_strCurrentFluctFlag.equals("8")){	//�⼼����
			sb.append(", ���ϴ��, ")
			.append(m_strCurrentFluctAmt)
			.append(", ��, ")
			.append(", ����, ")
			.append(", �⼼���� ����, ")
			.append(m_strCurrentAmt)
			.append(", ��, ");
		}else if(m_strCurrentFluctFlag.equals("9")){	//�ŷ�����
			sb.append(", ������, ")
			.append(m_strCurrentAmt)
			.append(", ��, ");
		}else{
			actionAPI.setSessionData("ment", "error");
		}
		
		if(f_m_strCurrentVolume > 0.0){
			m_strCurrentVolume = trimNum(m_strCurrentVolume);
			sb.append(", �ŷ�����, ")
			.append(m_strCurrentVolume)
			.append(" , ��, ")
			.append(" , �Դϴ�. ");
		}else{
			sb.append("�ŷ�����")
			.append(" , �����ϴ�. ");
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
