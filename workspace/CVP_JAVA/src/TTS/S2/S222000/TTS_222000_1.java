package TTS.S2.S222000;


import java.util.Hashtable;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_222000_1 extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
		
		// TR ��� �� ������� �����ϴ� Hashtable �� �����´�.
		Hashtable table = (Hashtable) actionAPI.getSessionData("g_objHostRecv");
		StringBuffer sb = new StringBuffer();
		
		
		String m_strStockPriceCurrentAmt = (String) table.get("A1_Current3");
		
		int index = m_strStockPriceCurrentAmt.indexOf(".");
		
		String before = m_strStockPriceCurrentAmt.substring(0, index);
		String after = m_strStockPriceCurrentAmt.substring(index + 1, m_strStockPriceCurrentAmt.length() );
		
		
		before = trimNum(before);
		
		
		sb.append(", ����,  ,�ڽ��� ������,").append(before).append(", ��, [").append(after).append("] ����Ʈ �Դϴ�.");
		sb.append(", �������� �ȳ���, 8�� 30�к��� �����մϴ�., ");
		
		
		// ��Ʈ�� ����� ���� String �����͸� ment ��� �̸��� Session Data �� �����Ѵ�.
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
