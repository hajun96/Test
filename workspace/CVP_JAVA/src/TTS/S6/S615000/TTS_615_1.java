package TTS.S6.S615000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_615_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		
		
		/*
		 * m_strSubsTurn / SubsTrun	û��ȸ��

           m_strSubItemNm / ItemNm	�����

           m_strSubsStrDate /  SubsStrDate	û���������

           m_strSubsEndDate / SubsEndDate	û����������

           m_strSubsRpmtDate / RpmtDate	ȯ������

           m_strSubsListDate / ListDate	��������
		
		*/
		
	
		String m_strSubItemNm = (String) actionAPI.getSessionData("m_strSubItemNm"); // �����
		
		String m_strSubsStrDate = (String) actionAPI.getSessionData("m_strSubsStrDate"); // û���������
		String month = m_strSubsStrDate.substring(4, 6);
		String day = m_strSubsStrDate.substring(6);
		month = trimNum(month);
		day = trimNum(day);
		
		String m_strSubsEndDate = (String) actionAPI.getSessionData("m_strSubsEndDate"); // û����������
		String month1 = m_strSubsEndDate.substring(4, 6);
		String day1 = m_strSubsEndDate.substring(6);
		month1 = trimNum(month1);
		day1 = trimNum(day1);
		
		
	
		String m_strSubsRpmtDate = (String) actionAPI.getSessionData("m_strSubsRpmtDate"); // ȯ������
		String month2 = m_strSubsRpmtDate.substring(4, 6);
		String day2 = m_strSubsRpmtDate.substring(6);
		month2 = trimNum(month2);
		day2 = trimNum(day2);
		
		
		String m_strSubsListDate = (String) actionAPI.getSessionData("m_strSubsListDate"); // ��������
		String month3 = m_strSubsListDate.substring(4, 6);
		String day3 = m_strSubsListDate.substring(6);
		month3 = trimNum(month3);
		day3 = trimNum(day3);
		
	
		
		StringBuffer sb = new StringBuffer();
		sb.append(m_strSubItemNm).append(", , , ").append("û���������").append(", , , ").
		append(month).append(", , , ").append("��").append(", , , ").append(day).append(", , , ").append("��").append(", , , ").
		append("û��������").append(month1).append(", , , ").append("��").append(", , , ").append(day1).append(", , , ").append("��").append(", , , ").
		append("ȯ����").append(", , , ").append(month2).append(", , , ").append("��").append(", , , ").append(day2).append(", , , ").append("��").append(", , , ").
		append("���忹����").append(", , , ").append(month3).append(", , , ").append("��").append(", , , ").append(day3).append(", , , ").append("�� �Դϴ�");
		
		
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
