package TTS.S3.S362000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_362_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI)throws AudiumException {
		/*m_strPrevOrderNum : �ֹ���ȣ
		m_strOrderItemCode : �����ڵ�
		m_strItemName : �����
		m_strOrderVol : �ֹ�����
		m_strOrderPrice : �ֹ��ܰ�
		m_strContVol : ü�����
		m_strContPrice : ü��ܰ�
		m_strTrdSect : �ŵ��ż����� (1:�ŵ�, 2:�ż�)
		m_strTrdKindSect : �Ÿ���������(01:������, 02:����, 05:���尡, 06:���Ǻ�������)
		m_strOrdMkSect : �ֹ��屸��(1.�尳��������, 2.����, 3.�ð�������, 4.�ð��ܴ��ϰ�, 5.ECN(����̻��), 9.����)
		m_strOrdSect : �ֹ�����( 01:���ݸŵ�, 02:���ݸż�, 03:�ſ�ŵ�(�ڽ�������) , 04:�ſ�ż�(�ڽ�������) , 05:����ŵ� , 06:����ż�, 07:ä�Ǹŵ� , 08:ä�Ǹż�, 09:�ڽ������ݸŵ�, 10:�ڽ������ݸż� , 11:�ڽ�������ŵ� , 12:�ڽ�������ż�, 13:��������ŵ�, 14:��������ż�)
		m_strUpdtCnclSect : �Ÿű���(0: �ֹ�, 1: ����, 2: ���)
		m_strOrdCrdtLoanSect : �ſ���ⱸ��*/
		
		String m_strItemName = (String) actionAPI.getSessionData("m_strItemName");	//�����
		String m_strContVol = (String) actionAPI.getSessionData("m_strContVol");	//ü�����
		m_strContVol = trimNum(m_strContVol);
		String m_strContPrice = (String) actionAPI.getSessionData("m_strContPrice");	//ü��ܰ�
		m_strContPrice = trimNum(m_strContPrice);
		String m_strOrdCrdtLoanSect = (String) actionAPI.getSessionData("m_strOrdCrdtLoanSect");	//�ſ���ⱸ��
		String m_strTrdSect = (String) actionAPI.getSessionData("m_strTrdSect");	//�ŵ��ż�����
		m_strTrdSect = trimNum(m_strTrdSect);
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(m_strItemName).append(", ");
		
		//ü�����
		if(m_strContVol.equals("0") || m_strContVol.equals("") || m_strContVol.equals(null)){
			sb.append(", ü�����, ����,");
		}else{
			sb.append(m_strContVol)
			.append(", �ְ�, ");
		}
		
		//ü��ܰ�
		if(m_strContPrice.equals("0") || m_strContPrice.equals("") || m_strContPrice.equals(null)){
			sb.append(", ü��ܰ�, ����,");
		}else{
			sb.append(m_strContPrice)
			.append(", ����, ");
		}
		
		//�ſ���� ����
		if(m_strOrdCrdtLoanSect.equals("03")){
			sb.append(", �ڱ�����, ");
		}else if(m_strOrdCrdtLoanSect.equals("06")){
			sb.append(", �㺸����, ");
		}else{
			sb.append("");
		}
		
		//�ŵ��ż�����
		if(m_strTrdSect.equals("1")){
			sb.append(", �ŵ�, ü��Ǿ����ϴ�.");
		}else if(m_strTrdSect.equals("2")){
			sb.append(", �ż�, ü��Ǿ����ϴ�.");
		}else{
			sb.append(", �ż�, ü��Ǿ����ϴ�.");
		}
		
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