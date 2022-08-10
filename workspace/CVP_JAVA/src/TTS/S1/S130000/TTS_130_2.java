package TTS.S1.S130000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_130_2 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		/*ItemScd / m_strBalItemcode / 6�ڸ� �����ڵ�
		ItemNo / m_strBalItemFullcode / 12�ڸ� Ǯ �����ڵ�
		ItemNm / m_strBalItemName / �����
		CrdtSect / m_strBalCrdtSect / �ſ뱸��
		HoldQty / m_strBalItemVol / ��������
		AvgUprc /  m_strBalAvgUprc / ��մܰ� 
		EstmAmt / m_strBalEstmAmt / �򰡱ݾ�*/
		
		//String m_strBalItemcode = (String) actionAPI.getSessionData("m_strBalItemcode"); //6�ڸ� �����ڵ�
		//String m_strBalItemFullcode = (String) actionAPI.getSessionData("m_strBalItemFullcode"); //12�ڸ� Ǯ �����ڵ�
		String m_strBalItemName = (String) actionAPI.getSessionData("m_strBalItemName"); //�����
		String m_strBalCrdtSect = (String) actionAPI.getSessionData("m_strBalCrdtSect"); //�ſ뱸��
		String m_strBalItemVol = (String) actionAPI.getSessionData("m_strBalItemVol"); //��������
		m_strBalItemVol = trimNum(m_strBalItemVol);
		String m_strBalEstmAmt = (String) actionAPI.getSessionData("m_strBalEstmAmt"); //�򰡱ݾ�
		m_strBalEstmAmt = trimNum(m_strBalEstmAmt);
		
		StringBuffer sb = new StringBuffer();
		sb.append(m_strBalItemName).append(", ,");
		
		if(m_strBalCrdtSect.equals("����")){
			sb.append(", ����, ");
		}else if(m_strBalCrdtSect.equals("����")){
			sb.append(", ��������, ");
		}else if(m_strBalCrdtSect.equals("����")){
			sb.append(", �ڱ�����, ");
		}else if(m_strBalCrdtSect.equals("����")){
			sb.append(", �������, ");
		}else if(m_strBalCrdtSect.equals("�ϴ�")){
			sb.append(", �Ϲݴ㺸����, ");
		}else if(m_strBalCrdtSect.equals("�ڴ�")){
			sb.append(", �ڱ����, ");
		}else if(m_strBalCrdtSect.equals("����")){
			sb.append(", �ſ����, ");
		}else if(m_strBalCrdtSect.equals("����")){
			sb.append(", �����ڱݴ���, ");
		}else if(m_strBalCrdtSect.equals("�ŵ�")){
			sb.append(", �ŵ��ڱݴ㺸����, ");
		}else if(m_strBalCrdtSect.equals("���")){
			sb.append(", ���̼���, ");
		}else if(m_strBalCrdtSect.equals("�ܱ�")){
			sb.append(", �ܱ�����ڱݴ���, ");
		}else{
			sb.append("");
		}
		
		//��������
		if(m_strBalItemVol.equals("0") || m_strBalItemVol.equals("") || m_strBalItemVol.equals(null)){
			sb.append(", ��������, ����,");
		}else{
			sb.append(m_strBalItemVol)
			.append(", �� ,");
		}
				
		//�򰡱ݾ�
		if(m_strBalEstmAmt.equals("0") || m_strBalEstmAmt.equals("") || m_strBalEstmAmt.equals(null)){
			sb.append(", �򰡱ݾ���, �����ϴ�.");
		}else{
			sb.append(", �򰡱ݾ��� ,")
			.append(m_strBalEstmAmt)
			.append(", ��, ")
			.append(", �Դϴ�. ");
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
