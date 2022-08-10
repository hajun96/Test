package TTS.S3.S313000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_313_1 extends ActionElementBase{
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
		m_strUpdtCnclSect : (0: �ֹ�, 1: ����, 2: ���)
		m_strOrdCrdtLoanSect : �ſ���ⱸ��*/
		
		String m_strPrevOrderNum = (String) actionAPI.getSessionData("m_strPrevOrderNum");	//�ֹ���ȣ
		m_strPrevOrderNum = trimNum(m_strPrevOrderNum);
		String m_strOrderVol = (String) actionAPI.getSessionData("m_strOrderVol");	//�ֹ�����
		m_strOrderVol = trimNum(m_strOrderVol);
		String m_strOrderPrice = (String) actionAPI.getSessionData("m_strOrderPrice");	//�ֹ��ܰ�
		m_strOrderPrice = trimNum(m_strOrderPrice);
		String m_strUpdtCnclSect = (String) actionAPI.getSessionData("m_strUpdtCnclSect");	//(0: �ֹ�, 1: ����, 2: ���)
		m_strUpdtCnclSect = trimNum(m_strUpdtCnclSect);
		String m_strContVol = (String) actionAPI.getSessionData("m_strContVol");	//ü�����
		m_strContVol = trimNum(m_strContVol);
		String m_strContPrice = (String) actionAPI.getSessionData("m_strContPrice");	//ü��ܰ�
		m_strContPrice = trimNum(m_strContPrice);
		String m_strTrdSect = (String) actionAPI.getSessionData("m_strTrdSect");	//�ŵ��ż����� (1:�ŵ�, 2:�ż�)
		m_strTrdSect = trimNum(m_strTrdSect);
		
		StringBuffer sb = new StringBuffer();
		
		//�ֹ���ȣ
		if(m_strPrevOrderNum.equals("0") || m_strPrevOrderNum.equals("") || m_strPrevOrderNum.equals(null)){
			sb.append("���ֹ���ȣ, ����,");
		}else{
			sb.append("���ֹ���ȣ, ")
			.append(m_strPrevOrderNum)
			.append(", ��, ");
		}
		
		if(m_strOrderPrice.equals("0") || m_strOrderPrice.equals("") || m_strOrderPrice.equals(null)){
			sb.append(",");
		}else{
			sb.append(m_strOrderPrice)
			.append(", ��, ");
		}
		
		//��ü�᳻������ = �ֹ����� - ü�����
		if(m_strOrderVol.equals("0") || m_strOrderVol.equals("") || m_strOrderVol.equals(null)){
			sb.append("�ֹ�����, ����,");
		}else{
			long m_lOrderVol = Long.parseLong(m_strOrderVol);
			long m_lContVol = Long.parseLong(m_strContVol);
			long m_lVol = m_lOrderVol - m_lContVol;
			String m_strVol = String.valueOf(m_lVol);
			sb.append(m_strVol)
			.append(", ��, ");
		}
		
		if(m_strTrdSect.equals("1")){
			sb.append(", �ŵ�, ");
		}else if(m_strTrdSect.equals("2")){
			sb.append(", �ż�, ");
		}else{
			sb.append(", �ż�, ");
		}
		
		//�Ÿű���(0: �ֹ�, 1: ����, 2: ���)
		if(m_strUpdtCnclSect.equals("1")){ //����
			sb.append(", ����, ");
		}else if(m_strUpdtCnclSect.equals("2")){ //���
			sb.append(", ���, ");
		}else{
			sb.append(",");
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
