package TTS.S2.S210000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_210000_8 extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
	
		String m_strExpectAmt = (String) actionAPI.getSessionData("m_strExpectAmt");
		String m_strExpectFluctAmt = (String) actionAPI.getSessionData("m_strExpectFluctAmt");
		String m_strExpectVolume = (String) actionAPI.getSessionData("m_strExpectVolume");
		String m_strOfferAmt = (String) actionAPI.getSessionData("m_strOfferAmt9"); // ����ŵ�ȣ���ܷ� ��
		String m_strOfferVol = (String) actionAPI.getSessionData("m_strOfferVol9"); // ����ŵ�ȣ���ܷ� ��
		String m_strBidAmt = (String) actionAPI.getSessionData("m_strBidAmt"); //����ż�ȣ���ܷ�
		String m_strBidVol = (String) actionAPI.getSessionData("m_strBidVol"); //����ż�ȣ���ܷ�
		
		m_strExpectAmt = trimNum(m_strExpectAmt);
		m_strExpectFluctAmt = trimNum(m_strExpectFluctAmt);
		m_strExpectVolume = trimNum(m_strExpectVolume);
		m_strOfferAmt = trimNum(m_strOfferAmt);
		m_strBidAmt = trimNum(m_strBidAmt);
		m_strOfferVol = trimNum(m_strOfferVol);
		m_strBidVol = trimNum(m_strBidVol);
		
		StringBuffer sb = new StringBuffer();
		
		if(m_strOfferAmt != null && Integer.parseInt(m_strOfferAmt) > 0) {
			sb.append(", ���� �ŵ� ȣ�� �ܷ���,").append(m_strOfferAmt).append(", ,").append(", �� ,").append(m_strOfferVol).append(", ,").append(",�� ,");
		} else {
			sb.append(", ���� �ŵ� ȣ�� �ܷ���,").append(", ����,");
		}
		
		
		
		if(m_strBidAmt != null && Integer.parseInt(m_strBidAmt) > 0) {
			sb.append("���� �ż� ȣ�� �ܷ���,").append(m_strBidAmt).append(", �� ,").append(m_strBidVol).append(",�� ,");
		} else {
			sb.append("���� �ż� ȣ�� �ܷ���,").append(", �����ϴ�.,");
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
