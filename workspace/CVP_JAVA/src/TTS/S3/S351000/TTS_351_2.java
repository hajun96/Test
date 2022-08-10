package TTS.S3.S351000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_351_2 extends ActionElementBase {
	public void doAction(String name, ActionElementData actionAPI)throws AudiumException {
		/*m_strItemNm / AX_ItemNm : �����
		m_strBalanSeq / AX_BalanSeq : �ܰ��Ϸù�ȣ
		m_strBspr / AX_Bspr : ���ϱ��ذ���
		m_strSellEnblQty / AX_SellEnblQty : �ŵ����ɼ���
		m_strTaxaEstmAmt / AX_TaxaEstmAmt : �����򰡱ݾ�
		m_strBlqty / AX_Blqty : �ܰ����*/
		//XX��,(�����), �ܰ����  ##��, �򰡱ݾ� ####�� �̸�, �ܰ��ȣ ####�� �Դϴ�.
		String m_strItemNm = (String) actionAPI.getSessionData("m_strItemNm");			//�����
		String m_strBspr = (String) actionAPI.getSessionData("m_strBspr");			//���ϱ��ذ�
		m_strBspr = trimNum(m_strBspr);
		String m_strBalanSeq = (String) actionAPI.getSessionData("m_strBalanSeq");			//�ܰ��ȣ
		m_strBalanSeq = trimNum(m_strBalanSeq);
		
		StringBuffer sb = new StringBuffer();
		sb.append(m_strItemNm).append(", , ")
		.append(", ���ذ���, ").append(m_strBspr).append(", ��, �̸�,")
		.append(", �ܰ��ȣ��, ").append(m_strBalanSeq).append(", �� �Դϴ�. ");
		
		// System.out.println( sb.toString());
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