package TTS.S2.S222000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_222_3 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strExpectFlucBit = (String) actionAPI.getSessionData("m_strExpectFlucBit"); //�ڽ����ְ����� ���ϴ�񱸺�
		String m_strExpectFluctAmt = (String) actionAPI.getSessionData("m_strExpectFluctAmt");	//���� �ڽ��� ����
		String m_strExpectAmt = (String) actionAPI.getSessionData("m_strExpectAmt");	// �ڽ��� ����
		String m_strExpectVolume = (String) actionAPI.getSessionData("m_strExpectVolume");	// ����ŷ��� ����
		m_strExpectVolume = trimNum(m_strExpectVolume);
		
		
		
		// [�ڽ����ְ����� �ڽ��� ���� ���]
		// �Ҽ��� �ڸ����� �����´�. 
		int strCurrentDotIndex3 = m_strExpectAmt.indexOf(".");
		// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
		String strCurrentDotLeft3 = m_strExpectAmt.substring(0, strCurrentDotIndex3);
		// �տ� 0�� ������ ���ش�.
		strCurrentDotLeft3 = trimNum(strCurrentDotLeft3);
		// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
		String strCurrentDotRight3 = m_strExpectAmt.substring(strCurrentDotIndex3+1);
		

		// [�ڽ����ְ����� ���� �ڽ��� ���� ���]
		// �Ҽ��� �ڸ����� �����´�. 
		int strFluctDotIndex3 = m_strExpectFluctAmt.indexOf(".");
		// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
		String strFluctDotLeft3 = m_strExpectFluctAmt.substring(0, strFluctDotIndex3);
		// �տ� 0�� ������ ���ش�.
		strFluctDotLeft3 = trimNum(strFluctDotLeft3);
		// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
		String strFluctDotRight3 = m_strExpectFluctAmt.substring(strFluctDotIndex3+1);
		
		String m_strStockPriceUpCnt3 = (String) actionAPI.getSessionData("m_strStockPriceUpCnt3");		     //�ڽ��� ������� ����
		m_strStockPriceUpCnt3 = trimNum(m_strStockPriceUpCnt3);
		String m_strStockPriceDnCnt3 = (String) actionAPI.getSessionData("m_strStockPriceDnCnt3");		      //�ڽ��� �϶����� ����
		m_strStockPriceDnCnt3 = trimNum(m_strStockPriceDnCnt3);
		String m_strStockPriceUnChgCnt3 = (String) actionAPI.getSessionData("m_strStockPriceUnChgCnt3");		//�ڽ��� �������� ����
		m_strStockPriceUnChgCnt3 = trimNum(m_strStockPriceUnChgCnt3);
		String m_strStockPriceUpLimitCnt3 = (String) actionAPI.getSessionData("m_strStockPriceUpLimitCnt3");		//�ڽ��� ���Ѱ����� ����
		m_strStockPriceUpLimitCnt3 = trimNum(m_strStockPriceUpLimitCnt3);
		String m_strStockPriceDnLimitCnt3 = (String) actionAPI.getSessionData("m_strStockPriceDnLimitCnt3");		//�ڽ��� ���Ѱ� ���� ����
		m_strStockPriceDnLimitCnt3 = trimNum(m_strStockPriceDnLimitCnt3);
		
		String m_strNowTime = (String) actionAPI.getSessionData("m_strNowTime");               // ����ð� 
		String HH = m_strNowTime.substring(0, 2);	//��
		HH = trimNum(HH);
		String mm = m_strNowTime.substring(2, 4);	//��
		mm = trimNum(mm);
		
        StringBuffer sb = new StringBuffer();
		
		
		sb.append(HH).append("��, ")
		.append(mm).append(", ��, ")
		.append(", ����, ");
		
		
		if(m_strExpectFlucBit.equals("0")){			//����
			sb.append(", ���� �ڽ��� �ְ�������, ").append(", ������, ").append(", , ").
			append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ�̰�,  ");
		}else if(m_strExpectFlucBit.equals("1")){	//����
			sb.append(", ���� �ڽ��� �ְ�������, ").append(strFluctDotLeft3).append(", ��, [").append(strFluctDotRight3).append("], ����, ").
			append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ�̰�,  ");
		}else if(m_strExpectFlucBit.equals("2")){	//���Ѱ�
			sb.append(", ���� �ڽ��� �ְ�������, ").append(", ���Ѱ���, ").append(", , ").
			append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ�̰�, ");
		}else if(m_strExpectFlucBit.equals("3")){	//�⼼���
			sb.append(", ���� �ڽ��� �ְ�������, ").append(", �⼼�����, ").append(", , ").
			append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ�̰�, ");
		}else if(m_strExpectFlucBit.equals("4")){	//�⼼����
			sb.append(", ���� �ڽ��� �ְ�������, ").append(", �⼼������, ").append(", , ").
			append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ�̰�, ");
		}else if(m_strExpectFlucBit.equals("5")){	//����
			sb.append(", ���� �ڽ��� �ְ�������, ").append(strFluctDotLeft3).append(", ��, [").append(strFluctDotRight3).append(",] ����, ").
			append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ�̰�, ");
		}else if(m_strExpectFlucBit.equals("6")){	//���Ѱ�
			sb.append(", ���� �ڽ��� �ְ�������, ").append(", ���Ѱ���, ").append(", , ").
			append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ�̰�, ");
		}else if(m_strExpectFlucBit.equals("7")){	//�⼼�϶�
			sb.append(", ���� �ڽ��� �ְ�������, ").append(", �⼼�϶���, ").append(", , ").
			append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ�̰�, ");
		}else if(m_strExpectFlucBit.equals("8")){	//�⼼����
			sb.append(", ���� �ڽ��� �ְ�������, ").append(", �⼼������, ").append(", , ").
			append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ�̰�, ");
		}else if(m_strExpectFlucBit.equals("9")){	//�ŷ�����
			sb.append(", ���� �ڽ��� �ְ�������, ").append(" ,������, ").append(", , ").
			append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ�̰�, ");
		}else{
			actionAPI.setSessionData("ment", "error");
		}
		
		
		if(m_strExpectVolume != null && Integer.parseInt(m_strExpectVolume) > 0) {
			sb.append(" ���� �ŷ�����,").append(m_strExpectVolume).append(", ��, �Դϴ�.");
		} else {
			sb.append(" ���� �ŷ�����, �����ϴ�.");
		}
		
		
		// m_strStockPriceUpCnt3 �ڽ����ְ����� ������� ����Ȯ��
		if(m_strStockPriceUpCnt3.equals("0") || m_strStockPriceUpCnt3.equals("") || m_strStockPriceUpCnt3.equals(null)){
		sb.append(",�������, ����,");
		}else{
			sb.append(", ������� , ")
		.append(m_strStockPriceUpCnt3)
		.append(", ����, ");
		}
		// m_strStockPriceDnCnt3 �ڽ����ְ����� �϶����� ����Ȯ��
		if(m_strStockPriceDnCnt3.equals("0") || m_strStockPriceDnCnt3.equals("") || m_strStockPriceDnCnt3.equals(null)){
		sb.append(",�϶�����, ����,");
		}else{
			sb.append(", �϶����� , ")
		.append(m_strStockPriceDnCnt3)
		.append(", ����, ");
		}

	    // m_strStockPriceUnChgCnt3 �ڽ����ְ����� �������� ����Ȯ��
		if(m_strStockPriceUnChgCnt3.equals("0") || m_strStockPriceUnChgCnt3.equals("") || m_strStockPriceUnChgCnt3.equals(null)){
			sb.append(",��������, ����,");
		}else{
			sb.append(", �������� , ")
			.append(m_strStockPriceUnChgCnt3)
			.append(", ����, ");
		}
		// m_strStockPriceUpLimitCnt3 �ڽ����ְ����� ���Ѱ����� ����Ȯ��
		if(m_strStockPriceUpLimitCnt3.equals("0") || m_strStockPriceUpLimitCnt3.equals("") || m_strStockPriceUpLimitCnt3.equals(null)){
			sb.append(",���ѱ�, ����,");
		}else{
			sb.append(", ���ѱ� , ")
			.append(m_strStockPriceUpLimitCnt3)
			.append(", ����, ");
		}
		// m_strStockPriceDnLimitCnt3 �ڽ����ְ����� ���Ѱ����� ����Ȯ��
		if(m_strStockPriceDnLimitCnt3.equals("0") || m_strStockPriceDnLimitCnt3.equals("") || m_strStockPriceDnLimitCnt3.equals(null)){
			sb.append(",���ѱ�, �����ϴ�.,");
		}else{
			sb.append(", ���ѱ� , ")
			.append(m_strStockPriceDnLimitCnt3)
			.append(", ����, �Դϴ�., ");
		}

		actionAPI.setSessionData("ment", sb.toString());
		
	}
	
	private String convertHour(String HH) {
		// TODO Auto-generated method stub
		if(HH == null || HH.isEmpty()) {
			return "";
		}
		
		int time = Integer.parseInt(HH);
		if(time <= 12){
			return HH;
		}
		
		time = time - 12;
		
		switch (time) {
		case 1:
			HH = "�ѽ�";
			break;
		case 2: 
			HH = "�ν�";
			break;
		case 3:
			HH = "����";
			break;
		case 4:
			HH = "�׽�";
			break;
		case 5:
			HH = "�ټ���";
			break;
		case 6:
			HH = "������";
			break;
		case 7:
			HH = "�ϰ���";
			break;
		case 8:
			HH = "������";
			break;
		case 9:
			HH = "��ȩ��";
			break;
		case 10:
			HH = "����";
			break;
		case 11:
			HH = "���ѽ�";
			break;
		case 12:
			HH = "���ν�";
			break;
		default:
			break;
		}
		
		return HH;
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
