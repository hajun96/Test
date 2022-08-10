package TTS.S6.S614000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_614_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		
		
		
		/*
		 * m_strSubsTurn[@m_iCnt] / SubsTurn   û��ȸ��    
		 * 
		 * m_strSubsComptRate[@m_iCnt] /  ComptRate  �����
		 * 
		 * m_strSubsComptRate
		 * 
		 * 
          
		*/
		
		String m_strSubsItemName = (String) actionAPI.getSessionData("m_strSubsItemName"); // �����
		String m_strSubsTurn = (String) actionAPI.getSessionData("m_strSubsTurn"); // û��ȸ��
		m_strSubsTurn = trimNum(m_strSubsTurn);
		String m_strSubsComptRate = (String) actionAPI.getSessionData("m_strSubsComptRate"); // �����
		String m_strSubsSect = (String) actionAPI.getSessionData("m_strSubsSect"); // û��׷�(�Ϲ�, �׿�)
		
	
		// REPLACE(LEFT(@m_strSubsComptRate[@m_iCnt], LENGTH(@m_strSubsComptRate[@m_iCnt]) - 3),",","")
		// LEFT(@m_strSubsComptRate, LENGTH(@m_strSubsComptRate) - 3)
		// REPLACE("456,89",",","")
		
		
		// �Ҽ��� �ڸ����� �����´�. 
		int strDotIndex = m_strSubsComptRate.indexOf(".");
		// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
		String strDotLeft = m_strSubsComptRate.substring(0, strDotIndex);
		// �տ� 0�� ������ ���ش�.
		strDotLeft = trimNum(strDotLeft);
		// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
		String strDotRight = m_strSubsComptRate.substring(strDotIndex+1);

		
		
		
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(m_strSubsTurn).append(", , , ").append(",ȸ��,");
		
		if(m_strSubsSect.equals("01")){
			sb.append(", �Ϲ�, ");
		}else{
			sb.append(", ��� , ");
		}
		
		sb.append(", , , ").append(m_strSubsItemName).append(", , , ")
		.append(",�� û��������,").append(strDotLeft).append(", , , ")
		.append(", �� [,").append(strDotRight).append("], , , ").append(", , �� , �� �Դϴ�.,");
		
		
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



	/* public static void main(String[] args) {
		String m_strSubsComptRate = "333,22";
		
		String strSubsComptRate1 = m_strSubsComptRate.substring(0, m_strSubsComptRate.length() -3);
		strSubsComptRate1 = strSubsComptRate1.replaceAll(",", "");
		String strSubsComptRate2 = m_strSubsComptRate.substring(m_strSubsComptRate.length() - 2, m_strSubsComptRate.length());
		
		StringBuffer sb = new StringBuffer();
		sb.append("1").append("ȸ��").append("�����").append("�� û��������").append(strSubsComptRate1)
		.append("��").append(strSubsComptRate2).append("�� �� �Դϴ�.");
		
		System.out.println(sb.toString());
	}
}
	*/