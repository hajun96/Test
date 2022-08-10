package TTS.S1.S121000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_121_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strExpectAmt = (String) actionAPI.getSessionData("m_strExpectAmt");			//���簡
		m_strExpectAmt = trimNum(m_strExpectAmt);
		String m_strExpectFlucBit = (String) actionAPI.getSessionData("m_strExpectFlucBit");	//���ϴ�񱸺�
		m_strExpectFlucBit = trimNum(m_strExpectFlucBit);
		String m_strExpectFluctAmt = (String) actionAPI.getSessionData("m_strExpectFluctAmt");	//���ϴ��
		m_strExpectFluctAmt = trimNum(m_strExpectFluctAmt);
		//String m_strExpectVolume = (String) actionAPI.getSessionData("m_strExpectVolume");		//�ŷ���
		StringBuffer sb = new StringBuffer();
		
		if(m_strExpectFlucBit.equals("0")){			//����
			sb.append(", , , ���󰡴�, , ")
			.append(", , ������, ")
			.append(m_strExpectAmt)
			.append(", , ��, ")
			.append(", , �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("1")){	//����
			sb.append(", , , ���󰡴�, , ")
			.append(m_strExpectFluctAmt)
			.append(", , ��, ")
			.append(", , ����, ")
			.append(m_strExpectAmt)
			.append(", , ��, ")
			.append(", , �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("2")){	//���Ѱ�
			sb.append(", , , ���󰡴�, , ")
			.append(", , ���Ѱ���, ")
			.append(m_strExpectAmt)
			.append(", , ��, ")
			.append(", , �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("3")){	//�⼼���
			sb.append(", , , ���󰡴�, , ")
			.append(", , �⼼�������, ")
			.append(m_strExpectAmt)
			.append(", , ��, ")
			.append(", , �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("4")){	//�⼼����
			sb.append(", , , ���󰡴�, , ")
			.append(", , �⼼��������, ")
			.append(m_strExpectAmt)
			.append(", , ��, ")
			.append(", , �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("5")){	//����
			sb.append(", , , ���󰡴�, , ")
			.append(m_strExpectFluctAmt)
			.append(", , ��, ")
			.append(", , ����, ")
			.append(m_strExpectAmt)
			.append(", , ��, ")
			.append(", , �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("6")){	//���Ѱ�
			sb.append(", , ���󰡴�, ")
			.append(", , ���Ѱ���, ")
			.append(m_strExpectAmt)
			.append(", , ��, ")
			.append(", , �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("7")){	//�⼼�϶�
			sb.append(", , ���󰡴�, ")
			.append(", , �⼼�϶�����, ")
			.append(m_strExpectAmt)
			.append(", , ��, ")
			.append(", , �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("8")){	//�⼼����
			sb.append(", , ���󰡴�, ")
			.append(", �⼼��������")
			.append(m_strExpectAmt)
			.append(", , ��, ")
			.append(", �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("9")){	//�ŷ�����
			sb.append(", , ���󰡴�, ")
			.append(", ������")
			.append(m_strExpectAmt)
			.append(", , ��, ")
			.append(", �Դϴ�.");
		}else{
			actionAPI.setSessionData("ment", "error");
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
