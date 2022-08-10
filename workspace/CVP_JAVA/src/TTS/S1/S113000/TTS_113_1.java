package TTS.S1.S113000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_113_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		//m_strStockPriceCurrentAmt : �������� (�Ҽ���2�ڸ�)
		String m_strStockPriceCurrentAmt = (String) actionAPI.getSessionData("m_strStockPriceCurrentAmt");
		
		// m_strStockPriceCurrentAmt �� ���� NULL �̳� ������� ������, 
		if(m_strStockPriceCurrentAmt != null && !m_strStockPriceCurrentAmt.isEmpty()){
			// �Ҽ��� �ڸ����� �����´�. 
			int strDotIndex = m_strStockPriceCurrentAmt.indexOf(".");
			// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
			String strDotLeft = m_strStockPriceCurrentAmt.substring(0, strDotIndex);
			// �տ� 0�� ������ ���ش�.
			strDotLeft = trimNum(strDotLeft);
			// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
			String strDotRight = m_strStockPriceCurrentAmt.substring(strDotIndex+1);
			
			
			//���ڿ��� ������ StringBuffer ��ü�� �����. 
			StringBuffer sb = new StringBuffer();
			sb.append(", ���� , �ڽ���������, ").append(strDotLeft).append(", ��, [").append(strDotRight).append("], ����Ʈ, �Դϴ�.")
			.append(", ��������, �ȳ���, ������, ��ʺ�, ���� �����մϴ�., ");
			
			
			
			actionAPI.setSessionData("ment", sb.toString());
		}else {
			actionAPI.setSessionData("ment", "error");
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
