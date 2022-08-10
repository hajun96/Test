package TTS.S2.S252000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_252_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strGiftYear = (String) actionAPI.getSessionData("m_strGiftYear"); //�� 
		String m_strGiftItemCode = (String) actionAPI.getSessionData("m_strGiftItemCode"); //��
		String month = m_strGiftItemCode.substring(1, 3);
		String m_strGiftStrikePrice = (String) actionAPI.getSessionData("m_strGiftStrikePrice"); //��簡��
		String m_strGiftPrevAmt = (String) actionAPI.getSessionData("m_strGiftPrevAmt"); //�ݿɼ� ��������
		
		if(m_strGiftStrikePrice != null && !m_strGiftStrikePrice.isEmpty()){
			// �Ҽ��� �ڸ����� �����´�. 
			int strDotIndex = m_strGiftStrikePrice.indexOf(".");
			// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
			String strDotLeft = m_strGiftStrikePrice.substring(0, strDotIndex);
			// �տ� 0�� ������ ���ش�.
			strDotLeft = trimNum(strDotLeft);
			// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
			String strDotRight = m_strGiftStrikePrice.substring(strDotIndex+1);

		
		if(m_strGiftPrevAmt != null && !m_strGiftPrevAmt.isEmpty()){
				// �Ҽ��� �ڸ����� �����´�. 
			int strDotIndex1 = m_strGiftPrevAmt.indexOf(".");
				// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
			String strDotLeft1 = m_strGiftPrevAmt.substring(0, strDotIndex1);
				// �տ� 0�� ������ ���ش�.
			strDotLeft1 = trimNum(strDotLeft1);
				// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
			String strDotRight1 = m_strGiftPrevAmt.substring(strDotIndex1+1);

			
			
			
			StringBuffer sb = new StringBuffer();
			
			sb.append(", �ڽ��� 200 , ").append(m_strGiftYear).append(", , ").append(", �� , ")
			.append(month).append(", , ").append(", �� , ")
			.append(", ��, ")
			.append(", ��簡��, ")
			.append(strDotLeft).append(", , ").append(" , �� , [")
			.append(strDotRight).append("], , ").append(" , ǲ�ɼ� , ").append(" , ���������� , ").append(strDotLeft1).append(", , ").append(" , �� , [").append(strDotRight1)
			.append("], , ").append(" , ����Ʈ �Դϴ�. ");
			
			actionAPI.setSessionData("ment", sb.toString());
		}else{
			actionAPI.setSessionData("ment", "error");
		}
	 }
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
