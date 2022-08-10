package TTS.S3.S352000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_352_3 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strItemNm = (String) actionAPI.getSessionData("m_strItemNm"); // �����
		String m_strBalanSeq = (String) actionAPI.getSessionData("m_strBalanSeq"); // �ܰ� ��ȣ
		m_strBalanSeq = trimNum(m_strBalanSeq);
		String m_strInOrderPrice = (String) actionAPI.getSessionData("m_strInOrderPrice"); // �߰��ż��ݾ�
		String m_strBsprAplyDate = (String) actionAPI.getSessionData("m_strBsprAplyDate"); // ���ذ���������
		String m_strSttDate = (String) actionAPI.getSessionData("m_strSttDate"); // �ݵ��������
		
		StringBuffer sb = new StringBuffer();
		
		if(m_strItemNm.equals("0") || m_strItemNm.equals("") || m_strItemNm.equals(null)){
			sb.append(",");
		}else{
			sb.append(m_strItemNm).append(", ");
		}
		
		if(m_strBalanSeq.equals("0") || m_strBalanSeq.equals("") || m_strBalanSeq.equals(null)){
			sb.append("�ܰ��ȣ, ")
			.append(", ����, ");
		}else{
			sb.append("�ܰ��ȣ, ")
			.append(m_strBalanSeq)
			.append(", ������, ");
		}
		
		if(m_strInOrderPrice.equals("0") || m_strInOrderPrice.equals("") || m_strInOrderPrice.equals(null)){
			sb.append("�߰��ż��ݾ�, ")
			.append(", �����ϴ�., ");
		}else{
			sb.append(m_strInOrderPrice)
			.append(", ��, ")
			.append(", �߰��ż� ��û �ϼ̽��ϴ�.");
		}
		
		if(m_strBsprAplyDate.equals("0") || m_strBsprAplyDate.equals("") || m_strBsprAplyDate.equals(null)){
			sb.append(", ���ذ� ��������, ")
			.append(", ������, ");
		}else{
			String SellBsprAplyDate1 = m_strBsprAplyDate.substring(0, 4); // ��
			String SellBsprAplyDate2 = m_strBsprAplyDate.substring(4, 6); // ��
			SellBsprAplyDate2 = trimNum(SellBsprAplyDate2);
			String SellBsprAplyDate3 = m_strBsprAplyDate.substring(6, 8); // ��
			SellBsprAplyDate3 = trimNum(SellBsprAplyDate3);
			
			sb.append(", ���ذ� ��������, ")
			.append(SellBsprAplyDate1).append(", ��, ")
			.append(SellBsprAplyDate2).append(", ��, ")
			.append(SellBsprAplyDate3).append(", ��, �̸�,");
		}
		
		//m_strSttDate
		if(m_strSttDate.equals("0") || m_strSttDate.equals("") || m_strSttDate.equals(null)){
			sb.append(", �ݵ� ��������, ")
			.append(", ������, ");
		}else{
			String m_strSellSttDate1 = m_strSttDate.substring(0, 4); // ��
			String m_strSellSttDate2 = m_strSttDate.substring(4, 6); // ��
			m_strSellSttDate2 = trimNum(m_strSellSttDate2);
			String m_strSellSttDate3 = m_strSttDate.substring(6, 8); // ��
			m_strSellSttDate3 = trimNum(m_strSellSttDate3);
			sb.append(", �ݵ� ��������, ")
			.append(m_strSellSttDate1).append(", ��, ")
			.append(m_strSellSttDate2).append(", ��, ")
			.append(m_strSellSttDate3).append(", ��, �Դϴ�.");
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
