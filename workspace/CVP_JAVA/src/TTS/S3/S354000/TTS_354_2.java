package TTS.S3.S354000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_354_2 extends ActionElementBase {
	public void doAction(String name, ActionElementData actionAPI)throws AudiumException {
		String m_strTrdTypeSect = (String) actionAPI.getSessionData("m_strTrdTypeSect"); //�Ÿ��������� (1. �ŵ�, 2. �ż�, 3. ��ȯ)
		String m_strProcStatSect = (String) actionAPI.getSessionData("m_strProcStatSect"); //ó�����±��� (1. ��û�� 2. ��û��� 3. �����Ϸ� 4. �������)
		String m_strItemNm = (String) actionAPI.getSessionData("m_strItemNm");	//�����
		String m_strBalanSeq = (String) actionAPI.getSessionData("m_strBalanSeq"); //�ܰ��Ϸù�ȣ
		m_strBalanSeq = trimNum(m_strBalanSeq);
		String m_strOffrDate = (String) actionAPI.getSessionData("m_strOffrDate"); //��û����
		
		String m_strApplicationYear = m_strOffrDate.substring(0, 4); // ��û���� ��
		String m_strApplicationMonth = m_strOffrDate.substring(4, 6); // ��û���� ��
		m_strApplicationMonth = trimNum(m_strApplicationMonth);
		String m_strApplicationDay = m_strOffrDate.substring(6, 8); // ��û���� ��
		m_strApplicationDay = trimNum(m_strApplicationDay);
		
		String m_strOffrQty = (String) actionAPI.getSessionData("m_strOffrQty"); //��û����
		m_strOffrQty = trimNum(m_strOffrQty);
		String m_strSttQty = (String) actionAPI.getSessionData("m_strSttQty"); //��������
		m_strSttQty = trimNum(m_strSttQty);
		String m_strSttAmt = (String) actionAPI.getSessionData("m_strSttAmt"); //�����ݾ�
		m_strSttAmt = trimNum(m_strSttAmt);
		
		String m_strSttDate = (String) actionAPI.getSessionData("m_strSttDate"); //��������		
		String m_strSttDateYear = m_strSttDate.substring(0, 4); // ������ ��
		String m_strSttDateMonth = m_strSttDate.substring(4, 6); // ������ ��
		m_strSttDateMonth = trimNum(m_strSttDateMonth);
		String m_strSttDateDay = m_strSttDate.substring(6, 8); // ������ ��
		m_strSttDateDay = trimNum(m_strSttDateDay);
		
		String m_strBsprAplyDate = (String) actionAPI.getSessionData("m_strBsprAplyDate"); //���ذ���������		
		String m_strBsprAplyYear = m_strBsprAplyDate.substring(0, 4); // ��û���� ��
		String m_strBsprAplyMonth = m_strBsprAplyDate.substring(4, 6); // ��û���� ��
		m_strBsprAplyMonth = trimNum(m_strBsprAplyMonth);
		String m_strBsprAplyDay = m_strBsprAplyDate.substring(6, 8); // ��û���� ��
		m_strBsprAplyDay = trimNum(m_strBsprAplyDay);
		
		StringBuffer sb = new StringBuffer();
		if(m_strTrdTypeSect.equals("1")){
			sb.append("���Բ�����, ")
			.append(m_strBalanSeq)
			.append(", ����, ")
			.append(m_strItemNm);
			
			if(m_strOffrQty.equals("0") || m_strOffrQty.equals("") || m_strOffrQty.equals(null)){
				sb.append(",");
			}else{
				sb.append(m_strOffrQty)
				.append(", �¸�, ");
			}
			
			sb.append(", �ŵ�,")
			.append(", ��û�Ͽ�,")
			.append(m_strSttDateYear)
			.append(", ��, ")
			.append(m_strSttDateMonth)
			.append(", ��, ")
			.append(m_strSttDateDay)
			.append(", ��, ");
			
			if(m_strSttQty.equals("0") || m_strSttQty.equals("") || m_strSttQty.equals(null)){
				sb.append(",");
			}else{
				sb.append(m_strSttQty)
				.append(", �°�, ");
			}
			
			sb.append(m_strSttAmt)
			.append(", ����, ")
			.append(", ����, ");
			
			if(m_strProcStatSect.equals("3")){//3. �����Ϸ� 
				sb.append(",����, ó�� �Ǿ����ϴ�.");
			}else if(m_strProcStatSect.equals("4")){//4. �������
				sb.append(",���, ó�� �Ǿ����ϴ�.");
			}else{
				sb.append(", ó�� �Ǿ����ϴ�.");
			}
			
		}else if(m_strTrdTypeSect.equals("2")){ //�ż�
			sb.append(m_strApplicationYear)
			.append(", ��, ")
			.append(m_strApplicationMonth)
			.append(", ��, ")
			.append(m_strApplicationDay)
			.append(", ��, ")
			.append(m_strBalanSeq)
			.append(", ����, ")
			.append(m_strItemNm)
			.append(m_strBsprAplyYear)
			.append(", ��, ")
			.append(m_strBsprAplyMonth)
			.append(", ��, ")
			.append(m_strBsprAplyDay)
			.append(", ��, ")
			.append(", ���ذ���, ");
			if(m_strOffrQty.equals("0") || m_strOffrQty.equals("") || m_strOffrQty.equals(null)){
				sb.append(",");
			}else{
				sb.append(m_strOffrQty)
				.append(", �¸�, ");
			}
			
			sb.append(", �ż� �Ͽ�, ");
			
			if(m_strSttQty.equals("0") || m_strSttQty.equals("") || m_strSttQty.equals(null)){
				sb.append(",");
			}else{
				sb.append(m_strSttQty)
				.append(", �°�, ");
			}
			sb.append(m_strSttAmt)
			.append(", ����, ")
			.append(", ����, ");
			
			if(m_strProcStatSect.equals("3")){//3. �����Ϸ� 
				sb.append(",����, ó�� �Ǿ����ϴ�.");
			}else if(m_strProcStatSect.equals("4")){//4. �������
				sb.append(",���, ó�� �Ǿ����ϴ�.");
			}else{
				sb.append(", ó�� �Ǿ����ϴ�.");
			}
					
					
		}else{ //�׿�
			sb.append("error");
		}
		
		actionAPI.setSessionData("ment", sb.toString());

	}

	private String trimNum(String num) {
		if (num == null)
			return "0";

		boolean isMinus = false;
		String result = "";

		if (num.startsWith("-")) {
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
		if (result.isEmpty()) {
			return "0";
		}

		if (result.startsWith("."))
			result = "0" + result;

		if (isMinus) {
			result = "-" + result;
		}

		return result;
	}
	
}