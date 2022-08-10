package TTS.S1.S112000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_112_2 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strExpectAmt = (String) actionAPI.getSessionData("m_strExpectAmt");			//���簡
		String m_strExpectFlucBit = (String) actionAPI.getSessionData("m_strExpectFlucBit");	//���ϴ�񱸺�
		String m_strExpectFluctAmt = (String) actionAPI.getSessionData("m_strExpectFluctAmt");	//���ϴ��
		//String m_strExpectVolume = (String) actionAPI.getSessionData("m_strExpectVolume");		//�ŷ���
		
		// [���� ��� ���] 
		// �Ҽ��� �ڸ����� �����´�. 
		int strFluctDotIndex = m_strExpectFluctAmt.indexOf(".");
		// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
		String strFluctDotLeft = m_strExpectFluctAmt.substring(0, strFluctDotIndex);
		// �տ� 0�� ������ ���ش�.
		strFluctDotLeft = trimNum(strFluctDotLeft);
		// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
		String strFluctDotRight = m_strExpectFluctAmt.substring(strFluctDotIndex+1);
		// �տ� 0�� ������ ���ش�.
		strFluctDotRight = trimNum(strFluctDotRight);
		
		// [���簡 ���]
		// �Ҽ��� �ڸ����� �����´�. 
		int strExpectDotIndex = m_strExpectAmt.indexOf(".");
		// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
		String strExpectDotLeft = m_strExpectAmt.substring(0, strExpectDotIndex);
		// �տ� 0�� ������ ���ش�.
		strExpectDotLeft = trimNum(strExpectDotLeft);
		// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
		String strExpectDotRight = m_strExpectAmt.substring(strExpectDotIndex+1);
		
		
		
		
		StringBuffer sb = new StringBuffer();
		
		if(m_strExpectFlucBit.equals("0")){			//����
			sb.append("���� ���� �ְ�������").append("������").
			append(strExpectDotLeft).append(", ��, [").append(strExpectDotRight).append("], ����Ʈ �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("1")){	//����
			sb.append("���� ���� �ְ�������").append(strFluctDotLeft).append(", ��, [").append(strFluctDotRight).append("], ����, ").
			append(strExpectDotLeft).append(", ��, [").append(strExpectDotRight).append("], ����Ʈ �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("2")){	//���Ѱ�
			sb.append("���� ���� �ְ�������").append("���Ѱ���").
			append(strExpectDotLeft).append(", ��, [").append(strExpectDotRight).append("], ����Ʈ �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("3")){	//�⼼���
			sb.append("���� ���� �ְ�������").append("�⼼�����").
			append(strExpectDotLeft).append(", ��, [").append(strExpectDotRight).append("], ����Ʈ �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("4")){	//�⼼����
			sb.append("���� ���� �ְ�������").append("�⼼������").
			append(strExpectDotLeft).append(", ��, [").append(strExpectDotRight).append("], ����Ʈ �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("5")){	//����
			sb.append("���� ���� �ְ�������").append(strFluctDotLeft).append(", ��, [").append(strFluctDotRight).append("], ����").
			append(strExpectDotLeft).append(", ��, [").append(strExpectDotRight).append("], ����Ʈ �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("6")){	//���Ѱ�
			sb.append("���� ���� �ְ�������").append("���Ѱ���").
			append(strExpectDotLeft).append(", ��, [").append(strExpectDotRight).append("], ����Ʈ �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("7")){	//�⼼�϶�
			sb.append("���� ���� �ְ�������").append("�⼼�϶���").
			append(strExpectDotLeft).append(", ��, [").append(strExpectDotRight).append("], ����Ʈ �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("8")){	//�⼼����
			sb.append("���� ���� �ְ�������").append("�⼼������").
			append(strExpectDotLeft).append(", ��, [").append(strExpectDotRight).append("], ����Ʈ �Դϴ�.");
		}else if(m_strExpectFlucBit.equals("9")){	//�ŷ�����
			sb.append("���� ���� �ְ�������").append("������").
			append(strExpectDotLeft).append(", ��, [").append(strExpectDotRight).append("], ����Ʈ �Դϴ�.");
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
