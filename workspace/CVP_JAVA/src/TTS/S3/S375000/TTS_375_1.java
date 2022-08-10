package TTS.S3.S375000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_375_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI)throws AudiumException {
		/*m_strRsvOrdNo : �����ֹ���ȣ / ex) 0000024166
		m_strRsvRegDate : ���������� : YYYYmmddHHMMSS(����Ͻú���) ex) 11/14 14:16:06
		m_strItemName : �����
		m_strRsvOrderVol : �ֹ�����  
		m_strRsvTrdTypeCd : �Ÿ������ڵ� (01:������, 02:���尡, 06:���Ǻ�������)
		m_strRsvOrderPrice : �ֹ�����
		m_strRsvTrdSect : �Ÿű���(1.�ŵ�, 2.�ż�)
		m_strRsvWorkProcRslt : �۾�ó�����(1.����, 2.����)
		m_strRsvOrderNum : �ֹ���ȣ
		m_strRsvErrMsgNo : ������ȣ*/
		
		String m_strRsvOrdNo = (String) actionAPI.getSessionData("m_strRsvOrdNo");//�����ȣ
		m_strRsvOrdNo = trimNum(m_strRsvOrdNo);
		String m_strOrderDateyyyy = (String) actionAPI.getSessionData("m_strOrderDateyyyy");//�����ֹ���
		String m_strRsvRegDate = (String) actionAPI.getSessionData("m_strRsvRegDate");//�����ֹ����Ͻú�
		String m_strRsvRegDateMon = m_strRsvRegDate.substring(0, 2); // ��
		m_strRsvRegDateMon = trimNum(m_strRsvRegDateMon);
	    String m_strRsvRegDateDay = m_strRsvRegDate.substring(3, 5); // ��
	    m_strRsvRegDateDay = trimNum(m_strRsvRegDateDay);
	    String m_strRsvRegDateHour = m_strRsvRegDate.substring(6, 8); // ��
	    m_strRsvRegDateHour = trimNum(m_strRsvRegDateHour);
	    String m_strRsvRegDateMin = m_strRsvRegDate.substring(9, 11); // ��
	    m_strRsvRegDateMin = trimNum(m_strRsvRegDateMin);
		String m_strItemName = (String) actionAPI.getSessionData("m_strItemName");	//�����
		String m_strRsvOrderVol = (String) actionAPI.getSessionData("m_strRsvOrderVol");	//�ֹ�����
		m_strRsvOrderVol = trimNum(m_strRsvOrderVol);
		String m_strRsvTrdTypeCd = (String) actionAPI.getSessionData("m_strRsvTrdTypeCd");	//�Ÿ������ڵ� (01:������, 02:���尡, 06:���Ǻ�������)
		String m_strRsvOrderPrice = (String) actionAPI.getSessionData("m_strRsvOrderPrice");	//�ֹ�����
		m_strRsvOrderPrice = trimNum(m_strRsvOrderPrice);
		String m_strRsvTrdSect = (String) actionAPI.getSessionData("m_strRsvTrdSect");	//�Ÿű���
		String m_strRsvWorkProcRslt = (String) actionAPI.getSessionData("m_strRsvWorkProcRslt");	//�۾�ó�����(1.����, 2.����)
		String m_strRsvOrderNum = (String) actionAPI.getSessionData("m_strRsvOrderNum");	//�ֹ���ȣ
		m_strRsvOrderNum = trimNum(m_strRsvOrderNum);
		String m_strRsvErrMsgNo = (String) actionAPI.getSessionData("m_strRsvErrMsgNo");	//������ȣ
		
		StringBuffer sb = new StringBuffer();
		//�����ֹ���ȣ
		if(m_strRsvOrdNo.equals("0") || m_strRsvOrdNo.equals("") || m_strRsvOrdNo.equals(null)){
			sb.append(", �����ȣ, ����,");
		}else{
			sb.append(", �����ȣ, ")
			.append(m_strRsvOrdNo)
			.append(", ����, ");
		}
		
		//����������
		if(m_strRsvRegDate.equals("0") || m_strRsvRegDate.equals("") || m_strRsvRegDate.equals(null)){
			sb.append(", ��������, ����,");
		}else{
			sb.append(", ��������, ")
			.append(m_strOrderDateyyyy).append(", ��, ")
			.append(m_strRsvRegDateMon).append(", ��, ")
			.append(m_strRsvRegDateDay).append(", ��, ")
			.append(m_strRsvRegDateHour).append(", ��, ")
			.append(m_strRsvRegDateMin).append(", ��, ")
			.append(", �̰�, ");
		}
		
		//�����
		if(m_strItemName.equals("0") || m_strItemName.equals("") || m_strItemName.equals(null)){
			sb.append(", �����, ����, ");
		}else{
			sb.append(m_strItemName).append(", ");
		}
		
		//�����ֹ�����
		if(m_strRsvOrderVol.equals("0") || m_strRsvOrderVol.equals("") || m_strRsvOrderVol.equals(null)){
			sb.append(", �����ֹ�����, ����, ");
		}else{
			sb.append(m_strRsvOrderVol).append(", ��, ");
		}
		
		//�Ÿ������ڵ� (01:������, 05:���尡, 06:���Ǻ�������)
		if(m_strRsvTrdTypeCd.equals("0") || m_strRsvTrdTypeCd.equals("") || m_strRsvTrdTypeCd.equals(null)){
			sb.append(",�Ÿű���, ����, ");
		}else if(m_strRsvTrdTypeCd.equals("01")){
			if(m_strRsvOrderPrice.equals("0") || m_strRsvOrderPrice.equals("") || m_strRsvOrderPrice.equals(null)){
				sb.append(", ��������, ");
			}else{
				sb.append(m_strRsvOrderPrice).append(", ����, ")
				.append(", ��������, ");
			}
		}else if(m_strRsvTrdTypeCd.equals("05")){
			sb.append(", ���尡��, ");
		}else if(m_strRsvTrdTypeCd.equals("06")){
			if(m_strRsvOrderPrice.equals("0") || m_strRsvOrderPrice.equals("") || m_strRsvOrderPrice.equals(null)){
				sb.append(", ���Ǻ� ��������, ");
			}else{
				sb.append(m_strRsvOrderPrice).append(", ����, ")
				.append(", ���Ǻ� ��������, ");
			}
		}else{
			sb.append(",�Ÿ���������, ����, ");
		}
		
		//�Ÿű���
		if(m_strRsvTrdSect.equals("0") || m_strRsvTrdSect.equals("") || m_strRsvTrdSect.equals(null)){
			sb.append("");
		}else if(m_strRsvTrdSect.equals("1")){
			sb.append(", �ŵ�, ");
		}else{
			sb.append(", �ż�, ");
		}
		
		//����ó������m_strRsvWorkProcRslt
		
		//�Ÿű���
		if(m_strRsvWorkProcRslt.equals("1")){
			sb.append(", �ֹ�, �Ϸ�Ǿ����ϴ�.")
			.append(", �ֹ���ȣ��,");
			//�����ֹ�����
			if(m_strRsvOrderNum.equals("0") || m_strRsvOrderNum.equals("") || m_strRsvOrderNum.equals(null)){
				sb.append(", �����ϴ�. ");
			}else{
				sb.append(m_strRsvOrderNum).append(", �Դϴ�. ");
			}
		}else{
			sb.append(", �����ڵ�, ").append(m_strRsvErrMsgNo).append(", ����, �߻��Ͽ����ϴ�.");
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
