package TTS.S2.S210000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_210_3 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strOfferAmt9 = (String) actionAPI.getSessionData("m_strOfferAmt9"); //�ŵ�1ȣ��
		String m_strOfferVol9 = (String) actionAPI.getSessionData("m_strOfferVol9"); //�ŵ�1ȣ���ܷ�
		String m_strBidAmt0 = (String) actionAPI.getSessionData("m_strBidAmt0"); //�ż�1ȣ��
		String m_strBidVol0 = (String) actionAPI.getSessionData("m_strBidVol0"); //�ż�1ȣ���ܷ�
		m_strOfferAmt9 = trimNum(m_strOfferAmt9);
		m_strOfferVol9 = trimNum(m_strOfferVol9);
		m_strBidAmt0 = trimNum(m_strBidAmt0);
		m_strBidVol0 = trimNum(m_strBidVol0); 
		
		String m_strOfferAmt8 = (String) actionAPI.getSessionData("m_strOfferAmt8"); //�ŵ�2ȣ��
		String m_strOfferVol8 = (String) actionAPI.getSessionData("m_strOfferVol8"); //�ŵ�2ȣ���ܷ�
		String m_strBidAmt1 = (String) actionAPI.getSessionData("m_strBidAmt1"); //�ż�2ȣ��
		String m_strBidVol1 = (String) actionAPI.getSessionData("m_strBidVol1"); //�ż�2ȣ���ܷ�
		m_strOfferAmt8 = trimNum(m_strOfferAmt8);
		m_strOfferVol8 = trimNum(m_strOfferVol8);
		m_strBidAmt1 = trimNum(m_strBidAmt1);
		m_strBidVol1 = trimNum(m_strBidVol1); 
		
		String m_strOfferAmt7 = (String) actionAPI.getSessionData("m_strOfferAmt7"); //�ŵ�3ȣ��
		String m_strOfferVol7 = (String) actionAPI.getSessionData("m_strOfferVol7"); //�ŵ�3ȣ���ܷ�
		String m_strBidAmt2 = (String) actionAPI.getSessionData("m_strBidAmt2"); //�ż�3ȣ��
		String m_strBidVol2 = (String) actionAPI.getSessionData("m_strBidVol2"); //�ż�3ȣ���ܷ�
		m_strOfferAmt7 = trimNum(m_strOfferAmt7);
		m_strOfferVol7 = trimNum(m_strOfferVol7);
		m_strBidAmt2 = trimNum(m_strBidAmt2);
		m_strBidVol2 = trimNum(m_strBidVol2); 
		
		StringBuffer sb = new StringBuffer();
		
		//�ŵ�1ȣ��
		if(m_strOfferAmt9.equals("0") || m_strOfferAmt9.equals("") || m_strOfferAmt9.equals(null)){
			sb.append(", �ŵ�, ")
			.append(", 1, ȣ����, ")
			.append(", ����, "); 
		}else{
			sb.append("�ŵ�, ")
			.append(", 1, ȣ����, ")
			.append(m_strOfferAmt9)
			.append(", ����, ");
		}
		//�ŵ�1ȣ���ܷ�
		if(m_strOfferVol9.equals("0") || m_strOfferVol9.equals("") || m_strOfferVol9.equals(null)){
			sb.append("�ܷ���, ")
			.append(", ����, ");
		}else{
			sb.append("�ܷ���, ")
			.append(m_strOfferVol9)
			.append(", ��, ");
		}
		//�ż�1ȣ��
		if(m_strBidAmt0.equals("0") || m_strBidAmt0.equals("") || m_strBidAmt0.equals(null)){
			sb.append(", �ż�, ")
			.append(", 1, ȣ����, ")
			.append(", ����, ");
		}else{
			sb.append("�ż�, ")
			.append(", 1, ȣ����, ")
			.append(m_strBidAmt0)
			.append(", ����, ");
		}
		//�ż�1ȣ���ܷ�
		if(m_strBidVol0.equals("0") || m_strBidVol0.equals("") || m_strBidVol0.equals(null)){
			sb.append("�ܷ���, ")
			.append(", ����, ");
		}else{
			sb.append("�ܷ���, ")
			.append(m_strBidVol0)
			.append(", ��, ");
		}
		//�ŵ�2ȣ��
		if(m_strOfferAmt8.equals("0") || m_strOfferAmt8.equals("") || m_strOfferAmt8.equals(null)){
			sb.append(", �ŵ�, ")
			.append(", 2, ȣ����, ")
			.append(", ����, "); 
		}else{
			sb.append("�ŵ�, ")
			.append(", 2, ȣ����, ")
			.append(m_strOfferAmt8)
			.append(", ����, ");
		}
		//�ŵ�2ȣ���ܷ�
		if(m_strOfferVol8.equals("0") || m_strOfferVol8.equals("") || m_strOfferVol8.equals(null)){
			sb.append("�ܷ���, ")
			.append(", ����, ");
		}else{
			sb.append("�ܷ���, ")
			.append(m_strOfferVol8)
			.append(", ��, ");
		}
		//�ż�2ȣ��
		if(m_strBidAmt1.equals("0") || m_strBidAmt1.equals("") || m_strBidAmt1.equals(null)){
			sb.append(", �ż�, ")
			.append(", 2, ȣ����, ")
			.append(", ����, ");
		}else{
			sb.append("�ż�, ")
			.append(", 2, ȣ����, ")
			.append(m_strBidAmt1)
			.append(", ����, ");
		}
		//�ż�2ȣ���ܷ�
		if(m_strBidVol1.equals("0") || m_strBidVol1.equals("") || m_strBidVol1.equals(null)){
			sb.append("�ܷ���, ")
			.append(", ����, ");
		}else{
			sb.append("�ܷ���, ")
			.append(m_strBidVol1)
			.append(", ��, ");
		}
		//�ŵ�3ȣ��
		if(m_strOfferAmt7.equals("0") || m_strOfferAmt7.equals("") || m_strOfferAmt7.equals(null)){
			sb.append(", �ŵ�, ")
			.append(", 3, ȣ����, ")
			.append(", ����, "); 
		}else{
			sb.append("�ŵ�, ")
			.append(", 3, ȣ����, ")
			.append(m_strOfferAmt7)
			.append(", ����, ");
		}
		//�ŵ�3ȣ���ܷ�
		if(m_strOfferVol7.equals("0") || m_strOfferVol7.equals("") || m_strOfferVol7.equals(null)){
			sb.append("�ܷ���, ")
			.append(", ����, ");
		}else{
			sb.append("�ܷ���, ")
			.append(m_strOfferVol7)
			.append(", ��, ");
		}
		//�ż�3ȣ��
		if(m_strBidAmt2.equals("0") || m_strBidAmt2.equals("") || m_strBidAmt2.equals(null)){
			sb.append(", �ż�, ")
			.append(", 3, ȣ����, ")
			.append(", ����, ");
		}else{
			sb.append("�ż�, ")
			.append(", 3, ȣ����, ")
			.append(m_strBidAmt2)
			.append(", ����, ");
		}
		//�ż�3ȣ���ܷ�
		if(m_strBidVol2.equals("0") || m_strBidVol2.equals("") || m_strBidVol2.equals(null)){
			sb.append("�ܷ���, ")
			.append(", ����, ");
		}else{
			sb.append("�ܷ���, ")
			.append(m_strBidVol2)
			.append(", ��, ");
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