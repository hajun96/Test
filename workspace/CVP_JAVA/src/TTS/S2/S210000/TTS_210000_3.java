package TTS.S2.S210000;

import java.util.Hashtable;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_210000_3 extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI) throws AudiumException {
		// TODO Auto-generated method stub
		String m_strCurrentFluctFlag = (String) actionAPI.getSessionData("m_strCurrentFluctFlag"); // ���ϴ�豸�� ��
		String m_strCurrentFluctAmt = (String) actionAPI.getSessionData("m_strCurrentFluctAmt");   // ���ϴ�� 
		String m_strCurrentAmt = (String) actionAPI.getSessionData("m_strCurrentAmt");             // ���簡
		String m_strCurrentVolume = (String) actionAPI.getSessionData("m_strCurrentVolume");       // ���ϴ��
		
		m_strCurrentFluctFlag = trimNum(m_strCurrentFluctFlag);
		m_strCurrentFluctAmt = trimNum(m_strCurrentFluctAmt);
		m_strCurrentAmt = trimNum(m_strCurrentAmt);
		m_strCurrentVolume = trimNum(m_strCurrentVolume);
		
		StringBuffer sb = new StringBuffer();
		if(m_strCurrentFluctFlag.equals("0")) { // ������
			sb.append(", ������, ").append(m_strCurrentAmt).append(", ,").append("��,").append(", �ŷ�����,").append(m_strCurrentVolume).append(", ,").append(", �� �Դϴ�. ,");
		} else if(m_strCurrentFluctFlag.equals("1")){ //����
			sb.append(", ,").append(m_strCurrentFluctAmt).append(", ,").append("��, ����,").append(m_strCurrentAmt).append(", ,").append("��,")
			.append(", �ŷ�����,").append(m_strCurrentVolume).append(", ,").append(", ��, �Դϴ�. ,");
		} else if(m_strCurrentFluctFlag.equals("2")){ // ���Ѱ���
			sb.append(",���ϴ��,").append(m_strCurrentFluctAmt).append(", ,").append("��, ����, ���ѱ��,")
			.append(m_strCurrentAmt).append(", ,").append("��,").append(", �ŷ�����,").append(m_strCurrentVolume).append(", ,").append(", ��, �Դϴ�. ,");		
		} else if(m_strCurrentFluctFlag.equals("3")){ // �⼼���
			sb.append(", ���ϴ��,").append(m_strCurrentFluctAmt).append(", ,").append("��, ����, �⼼�������,")
			.append(m_strCurrentAmt).append(", ,").append("��,").append(", �ŷ�����,").append(m_strCurrentVolume).append(", ,").append(", ��, �Դϴ�. ,");
		} else if(m_strCurrentFluctFlag.equals("4")){ // �⼼����
			sb.append(", ���ϴ��,").append(m_strCurrentFluctAmt).append(", ,").append("��, ����, �⼼��������,")
			.append(m_strCurrentAmt).append(", ,").append("��,").append(", �ŷ�����,").append(m_strCurrentVolume).append(", ,").append(", ��, �Դϴ�. ,");
		} else if(m_strCurrentFluctFlag.equals("5")){ // ����
			sb.append(", ,").append(m_strCurrentFluctAmt).append(", ,").append("��, ����,").append(m_strCurrentAmt).append(", ,").append("��,").append(", �ŷ�����,").append(m_strCurrentVolume).append(", ,").append(", �� �Դϴ�. ,");
		} else if(m_strCurrentFluctFlag.equals("6")) { // ���Ѱ���
			sb.append(", ���ϴ��,").append(m_strCurrentFluctAmt).append(", ,").append("��, ����, ���ѱ��,").
			append(m_strCurrentAmt).append(", ,").append("��,").append(", �ŷ�����,").append(m_strCurrentVolume).append(", ,").append(", ��, �Դϴ�. ,");
		} else if(m_strCurrentFluctFlag.equals("7")) { // �⼼�϶�����
			sb.append(", ���ϴ��,").append(m_strCurrentFluctAmt).append(", ,").append("��, ����, �⼼�϶�����,").
			append(m_strCurrentAmt).append(", ,").append("��,").append(", �ŷ�����,").append(m_strCurrentVolume).append(", ,").append(", ��, �Դϴ�. ,");
		} else if(m_strCurrentFluctFlag.equals("8")) { //�⼼��������
			sb.append(", m_strCurrentAmt,").append(m_strCurrentFluctAmt).append(", ,").append("��, ����, �⼼��������,").
			append(m_strCurrentAmt).append(", ,").append("��,").append(", �ŷ�����,").append(m_strCurrentVolume).append(", ,").append(", ��, �Դϴ�. ,");
		} else if(m_strCurrentFluctFlag.equals("9")) { //�ŷ�����
			sb.append(", ������, ").append(m_strCurrentAmt).append(", ,").append("��,").append(", �ŷ�����,").append(m_strCurrentVolume).append(", ,").append(", �� �Դϴ�. ,");
		}
		
		String m_strOfferAmt = (String) actionAPI.getSessionData("m_strOfferAmt9"); // �ŵ�ȣ��
		String m_strOfferVol = (String) actionAPI.getSessionData("m_strOfferVol10"); //�ŵ��ܷ�
		String m_strBidAmt = (String) actionAPI.getSessionData("m_strBidAmt0"); //�ż�ȣ��
		String m_strBidVol = (String) actionAPI.getSessionData("m_strBidVol10"); //�ż��ܷ�
		m_strOfferAmt = trimNum(m_strOfferAmt);
		m_strOfferVol = trimNum(m_strOfferVol);
		m_strBidAmt = trimNum(m_strBidAmt);
		m_strBidVol = trimNum(m_strBidVol);
		
		if(m_strOfferAmt != null && Integer.parseInt(m_strOfferAmt) > 0) {
			sb.append(", �ŵ�ȣ��,").append(m_strOfferAmt).append(", ,").append(", �� ,");
		} else {
			sb.append(", �ŵ�ȣ��,").append(", ����,");
		}
		if(m_strBidAmt != null && Integer.parseInt(m_strBidAmt) > 0) {
			sb.append(", �ż�ȣ��,").append(m_strBidAmt).append(", �� ,");
		} else {
			sb.append(", �ż�ȣ��,").append(", ����,");
		}
		
		
		if(m_strOfferVol != null && Integer.parseInt(m_strOfferVol) > 0) { // �ŵ� �ܷ� ���� ��
			sb.append(", �ŵ� �ܷ� �հ�,").append(m_strOfferVol).append(", ,").append(",�� ,");
		} else {
			sb.append(", �ŵ�  �ܷ� �հ�,").append(", ����,");
		}
		
		
		if(m_strBidVol != null && Integer.parseInt(m_strBidVol) > 0) {  // �ż� �܎U ���� ��
			sb.append(", �ż�  �ܷ� �հ�,").append(m_strBidVol).append(",�� ,");
		} else {
			sb.append(" �ż� �ܷ� �հ�,").append(", ����,");
		}
		
		
		String m_strOpenAmt = (String) actionAPI.getSessionData("m_strOpenAmt"); // �ð�
		String m_strHighAmt = (String) actionAPI.getSessionData("m_strHighAmt"); // ����
		String m_strLowAmt = (String) actionAPI.getSessionData("m_strLowAmt"); // ����
		
		m_strOpenAmt = trimNum(m_strOpenAmt);
		m_strHighAmt = trimNum(m_strHighAmt);
		m_strLowAmt = trimNum(m_strLowAmt);
		
		if(m_strOpenAmt != null && Integer.parseInt(m_strOpenAmt) > 0) {
			sb.append(", �ñ�,").append(m_strOpenAmt).append(", ,").append(", ��,");
		} else {
			sb.append(", �ñ�, ����,");
		}
		
		if(m_strHighAmt != null && Integer.parseInt(m_strHighAmt) > 0) {
			sb.append(", ����,").append(m_strHighAmt).append(", ,").append(",��,");
		} else {
			sb.append(", ����, ����,");
		}
		
		if(m_strLowAmt != null && Integer.parseInt(m_strLowAmt) > 0) {
			sb.append(", ����,").append(m_strLowAmt).append(", ,").append(",��, �Դϴ�.");
		} else {
			sb.append(", ����, �����ϴ�.");
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
