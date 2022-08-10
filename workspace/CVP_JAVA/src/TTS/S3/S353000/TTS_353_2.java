package TTS.S3.S353000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_353_2 extends ActionElementBase {
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		/*
		���ŷ��Ϸù�ȣ : m_strRsvTrSeq
		�Է��¼� : m_strOffrQty
		�Է±ݾ� : m_strOffrAmt
		����ŷ��Ϸù�ȣ : m_strBalanSeq*/
		
		String m_strItemNm = (String) actionAPI.getSessionData("m_strItemNm"); //�ݵ��
		String m_strOffrSect = (String) actionAPI.getSessionData("m_strOffrSect"); //�ŵ��ż����� (DTMF �Է°�)
		String m_strChoiceNum = (String) actionAPI.getSessionData("m_strChoiceNum"); //�����ѹ�ȣ
		
		String m_strBalanSeq = (String) actionAPI.getSessionData("m_strBalanSeq");	//�ܰ��ȣ
		m_strBalanSeq = trimNum(m_strBalanSeq);
		String m_strOffrQty = (String) actionAPI.getSessionData("m_strOffrQty"); //�ŵ�����
		m_strOffrQty = trimNum(m_strOffrQty);
		String m_strOffrAmt = (String) actionAPI.getSessionData("m_strOffrAmt"); //�ż��ݾ�
		m_strOffrAmt = trimNum(m_strOffrAmt);
		String m_strRsvTrSeq = (String) actionAPI.getSessionData("m_strRsvTrSeq"); //����ŷ��Ϸù�ȣ
		m_strRsvTrSeq = trimNum(m_strRsvTrSeq);
		
		
		StringBuffer sb = new StringBuffer();
		
		if(m_strOffrSect.equals("3")){ //�ŵ�
			sb.append(m_strChoiceNum).append(", ��, ")
			.append(m_strItemNm)
			.append(", �ŵ�����, ")
			.append(m_strOffrQty).append(", ��, ")
			.append(", �ܰ��ȣ, ")
			.append(m_strBalanSeq)
			.append(", ��,")
			.append(", �ݵ�ŵ� ��Ҹ� ��û�ϼ̽��ϴ�.");
		}else if(m_strOffrSect.equals("2")){ //�ż�
			sb.append(m_strChoiceNum).append(", ��, ")
			.append(m_strItemNm)
			.append(", �ż��ݾ�, ")
			.append(m_strOffrAmt).append(", ��, ")
			.append(", �ܰ��ȣ, ")
			.append(m_strBalanSeq)
			.append(", ��, ")
			.append(", �ݵ�ż� ��Ҹ� ��û�ϼ̽��ϴ�.");
		}else{
			sb.append("error");
		}
		actionAPI.setSessionData("m_strBalanSeq", m_strBalanSeq); //�ܰ��ȣ
		actionAPI.setSessionData("m_strOffrQty", m_strOffrQty); //�ŵ�����
		actionAPI.setSessionData("m_strOffrAmt", m_strOffrAmt); //�ż��ݾ�
		actionAPI.setSessionData("m_strRsvTrSeq", m_strRsvTrSeq); //����ŷ��Ϸù�ȣ
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