package TTS.S3.S351000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_351_3 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strItemNm = (String) actionAPI.getSessionData("m_strItemNm");// �����
		String m_strInOrderVol = (String) actionAPI.getSessionData("m_strInOrderVol"); // �ŵ� ����
		String m_strBalanSeq = (String) actionAPI.getSessionData("m_strBalanSeq"); // �ܰ� ��ȣ
		String m_strSellAmtStckCntSect = (String) actionAPI.getSessionData("m_strSellAmtStckCntSect"); // 1:�Ϻ� / 2:����
		String m_strFeeTot = (String) actionAPI.getSessionData("m_strFeeTot"); // ȯ�ż�����
		
		
		/*����� (m_strItemNm) 
		���� (m_strInOrderVol) ��, 
		�ܰ��ȣ  (m_strBalanSeq) ���� 
		(���� / �Ϻ�) �ŵ� ��û�ϼ̽��ϴ�.
		�ݵ� �ŵ��� 
		ȯ�ż����� ##���� ����˴ϴ�.*/
		m_strInOrderVol = trimNum(m_strInOrderVol);
		m_strBalanSeq = trimNum(m_strBalanSeq);
		m_strFeeTot = trimNum(m_strFeeTot);
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(m_strItemNm); 
		
		if(m_strInOrderVol.equals("0") || m_strInOrderVol.equals(null)){
			sb.append(", ����, ")
			.append(", �����ϴ�. ");
		}else{
			sb.append(", ����, ")
			.append(m_strInOrderVol)
			.append(", ��, ");
		}
		
		sb.append(", �ܰ��ȣ, ")
		.append(m_strBalanSeq)
		.append(", ����, "); 
		
		if(m_strSellAmtStckCntSect.equals("1")){
			sb.append(", �Ϻ�, �ŵ� ��û �ϼ̽��ϴ�.");
		}else if(m_strSellAmtStckCntSect.equals("2")){
			sb.append(", ����, �ŵ� ��û �ϼ̽��ϴ�.");
		}else{
			sb.append(", �ŵ� ��û �ϼ̽��ϴ�.");
		}
		
		if(m_strFeeTot.equals("0") || m_strFeeTot.equals(null)){
			sb.append(",ȯ�� ������� �����ϴ�.");
		}else{
			sb.append(",ȯ�� �������")
			.append(m_strFeeTot)
			.append(",���� ���� �˴ϴ�.");
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
