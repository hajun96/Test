package TTS.S1.S125000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_125_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strItemName = (String) actionAPI.getSessionData("m_strItemName");// �����
		String m_strPrevOrderNum = (String) actionAPI.getSessionData("m_strPrevOrderNum"); // �ֹ���ȣ
		m_strPrevOrderNum = trimNum(m_strPrevOrderNum);
		//String m_strOrderItemCode = (String) actionAPI.getSessionData("m_strOrderItemCode"); // �����ڵ�
		String m_strOrderVol = (String) actionAPI.getSessionData("m_strOrderVol"); // �ֹ�����
		m_strOrderVol = trimNum(m_strOrderVol);
		String m_strOrderPrice = (String) actionAPI.getSessionData("m_strOrderPrice"); // �ֹ��ܰ�
		m_strOrderPrice = trimNum(m_strOrderPrice);
		Float f_m_strOrderPrice = Float.parseFloat(m_strOrderPrice);
		String m_strContVol = (String) actionAPI.getSessionData("m_strContVol"); // ü�����
		m_strContVol = trimNum(m_strContVol);
		Float f_m_strContVol = Float.parseFloat(m_strContVol);
		String m_strContPrice = (String) actionAPI.getSessionData("m_strContPrice"); // ü��ܰ�
		m_strContPrice = trimNum(m_strContPrice);
		String m_strTrdSect = (String) actionAPI.getSessionData("m_strTrdSect"); // �ŵ��ż� ���� (1:�ŵ� / 2:�ż�)
		m_strTrdSect = trimNum(m_strTrdSect);
		String m_strTrdKindSect = (String) actionAPI.getSessionData("m_strTrdKindSect"); // �Ÿű��� (01:������, 02:����, 05:���尡, 06:���Ǻ�������)
		//String m_strOrdMkSect = (String) actionAPI.getSessionData("m_strOrdMkSect"); // �ֹ��屸�� (1:�尳��������, 2:����, 3:�ð�������, 4:�ð��ܴ��ϰ�, 5:ECN(����̻��), 9:����)
		//String m_strOrdSect = (String) actionAPI.getSessionData("m_strOrdSect"); // �ŵ��ż��� ���� (01:���ݸŵ�, 02:���ݸż�, 03:�ſ�ŵ�(�ڽ�������), 04:�ſ�ż�(�ڽ�������), 05:����ŵ�, 06:����ż�, 07:ä�Ǹŵ�, 08:ä�Ǹż�, 09:�ڽ������ݸŵ�, 10:�ڽ������ݸż�, 11:�ڽ�������ŵ�, 12:�ڽ�������ż�, 13:��������ŵ�, 14:�������ż�)
		String m_strUpdtCnclSect = (String) actionAPI.getSessionData("m_strUpdtCnclSect"); // �ֹ����� (0:�ֹ�, 1:����, 2:���)
		//String m_strOrdCrdtLoanSect = (String) actionAPI.getSessionData("m_strOrdCrdtLoanSect"); // �ſ���ⱸ�� (00:����)
		
		// �ֹ���ȣ(m_strPrevOrderNum) ���� , (m_strMitemName) (m_strOrderVol) ��, 
		
		StringBuffer sb = new StringBuffer();
		sb.append(", �ֹ���ȣ, ")
		.append(m_strPrevOrderNum).append(", ,")
		.append(", ����, ")
		.append(m_strItemName).append(", ,")
		.append(", , , ")
		.append(m_strOrderVol).append(", ,")
		.append(", ��, ");
		
		if(m_strTrdKindSect.equals("01")){
			if(f_m_strOrderPrice > 0.0){
				sb.append(m_strOrderPrice).append(", ,")
				.append(", ����, ")
				.append(", ��������, ");
			}else{
				sb.append(", ��������, ");
			}
		}else if(m_strTrdKindSect.equals("06")){
			if(f_m_strOrderPrice > 0.0){
				sb.append(m_strOrderPrice).append(", ,")
				.append(", ����, ")
				.append(", ���Ǻ�, ��������,");
			}else{
				sb.append(", ���Ǻ�, ��������,");
			}
		}else{
			sb.append(", ���尡��, ");
		}
		
		if(m_strUpdtCnclSect.equals("1")){
			sb.append(", ����, ")
			.append(", �ֹ�, �ش� ü�᳻����, ");
		}else if(m_strUpdtCnclSect.equals("2")){
			sb.append(", ���, ")
			.append(", �ֹ�, �ش� ü�᳻����, ");
		}else{
			//m_strTrdSect
			if(m_strTrdSect.equals("1")){
				sb.append(", �ŵ�, ")
				.append(", �ֹ�, �ش� ü�᳻����, ");
			}else if(m_strTrdSect.equals("2")){
				sb.append(", �ż�, ")
				.append(", �ֹ�, �ش� ü�᳻����, ");
			}
		}
		
		if(f_m_strContVol > 0.0){
			sb.append(m_strContVol).append(", ,")
			.append(" , �ְ�, ")
			.append(m_strContPrice).append(", ,")
			.append(" , ����, ");
		}else{
			sb.append("����");
		}
		
		if(m_strTrdSect.equals("1")){ //�ŵ�
			sb.append(", �ŵ�, ").append(", ,")
			.append(", ü��, ");
		}else{ //�ż�
			sb.append(", �ż�, ").append(", ,")
			.append(", ü��, ");
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
