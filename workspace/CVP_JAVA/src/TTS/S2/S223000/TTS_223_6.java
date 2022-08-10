package TTS.S2.S223000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_223_6 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strExpectFlucBit = (String) actionAPI.getSessionData("m_strExpectFlucBit"); //�ڽ���, 200, �ְ����� ���ϴ�񱸺�
		String m_strExpectFluctAmt = (String) actionAPI.getSessionData("m_strExpectFluctAmt");	//���� �ڽ���, 200,  ����
		String m_strExpectAmt = (String) actionAPI.getSessionData("m_strExpectAmt");	// �ڽ���, 200,  ����
		String m_strExpectVolume = (String) actionAPI.getSessionData("m_strExpectVolume");	// ����ŷ��� ����
		m_strExpectVolume = trimNum(m_strExpectVolume);
		
		// [�ڽ���, 200, �ְ����� �ڽ���, 200,  ���� ���]
		// �Ҽ��� �ڸ����� �����´�. 
		int strCurrentDotIndex = m_strExpectAmt.indexOf(".");
		// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
		String strCurrentDotLeft = m_strExpectAmt.substring(0, strCurrentDotIndex);
		// �տ� 0�� ������ ���ش�.
		strCurrentDotLeft = trimNum(strCurrentDotLeft);
		// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
		String strCurrentDotRight = m_strExpectAmt.substring(strCurrentDotIndex + 1);
		

		// [�ڽ���, 200, �ְ����� ���� �ڽ���, 200,  ���� ���]
		// �Ҽ��� �ڸ����� �����´�. 
		int strFluctDotIndex = m_strExpectFluctAmt.indexOf(".");
		// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
		String strFluctDotLeft = m_strExpectFluctAmt.substring(0, strFluctDotIndex);
		// �տ� 0�� ������ ���ش�.
		strFluctDotLeft = trimNum(strFluctDotLeft);
		// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
		String strFluctDotRight = m_strExpectFluctAmt.substring(strFluctDotIndex + 1);
		
		String m_strStockPriceUpCnt = (String) actionAPI.getSessionData("m_strStockPriceUpCnt");		     //�ڽ���, 200,  ������� ����
		m_strStockPriceUpCnt = trimNum(m_strStockPriceUpCnt);
		String m_strStockPriceDnCnt = (String) actionAPI.getSessionData("m_strStockPriceDnCnt");		      //�ڽ���, 200,  �϶����� ����
		m_strStockPriceDnCnt = trimNum(m_strStockPriceDnCnt);
		String m_strStockPriceUnChgCnt = (String) actionAPI.getSessionData("m_strStockPriceUnChgCnt");		//�ڽ���, 200,  �������� ����
		m_strStockPriceUnChgCnt = trimNum(m_strStockPriceUnChgCnt);
		String m_strStockPriceUpLimitCnt = (String) actionAPI.getSessionData("m_strStockPriceUpLimitCnt");		//�ڽ���, 200,  ���Ѱ����� ����
		m_strStockPriceUpLimitCnt = trimNum(m_strStockPriceUpLimitCnt);
		String m_strStockPriceDnLimitCnt = (String) actionAPI.getSessionData("m_strStockPriceDnLimitCnt");		//�ڽ���, 200,  ���Ѱ� ���� ����
		m_strStockPriceDnLimitCnt = trimNum(m_strStockPriceDnLimitCnt);
		
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
			sb.append(", ���� �ڽ���, 200,  �ְ�������, ").append(", ������, ").append(", , ").
			append(strCurrentDotLeft).append(", �� , [").append(strCurrentDotRight).append("], ����Ʈ�̰�,  ");
		}else if(m_strExpectFlucBit.equals("1")){	//����
			sb.append(", ���� �ڽ���, 200,  �ְ�������, ").append(strFluctDotLeft).append(", ��, [").append(strFluctDotRight).append("], ����, ").
			append(strCurrentDotLeft).append(", �� , [").append(strCurrentDotRight).append("], ����Ʈ�̰�,  ");
		}else if(m_strExpectFlucBit.equals("2")){	//���Ѱ�
			sb.append(", ���� �ڽ���, 200,  �ְ�������, ").append(", ���Ѱ���, ").append(", , ").
			append(strCurrentDotLeft).append(", �� , [").append(strCurrentDotRight).append("], ����Ʈ�̰�, ");
		}else if(m_strExpectFlucBit.equals("3")){	//�⼼���
			sb.append(", ���� �ڽ���, 200,  �ְ�������, ").append(", �⼼�����, ").append(", , ").
			append(strCurrentDotLeft).append(", �� , [").append(strCurrentDotRight).append("], ����Ʈ�̰�, ");
		}else if(m_strExpectFlucBit.equals("4")){	//�⼼����
			sb.append(", ���� �ڽ���, 200,  �ְ�������, ").append(", �⼼������, ").append(", , ").
			append(strCurrentDotLeft).append(", �� , [").append(strCurrentDotRight).append("], ����Ʈ�̰�, ");
		}else if(m_strExpectFlucBit.equals("5")){	//����
			sb.append(", ���� �ڽ���, 200,  �ְ�������, ").append(strFluctDotLeft).append(", ��, [").append(strFluctDotRight).append(",] ����, ").
			append(strCurrentDotLeft).append(", �� , [").append(strCurrentDotRight).append("], ����Ʈ�̰�, ");
		}else if(m_strExpectFlucBit.equals("6")){	//���Ѱ�
			sb.append(", ���� �ڽ���, 200,  �ְ�������, ").append(", ���Ѱ���, ").append(", , ").
			append(strCurrentDotLeft).append(", �� , [").append(strCurrentDotRight).append("], ����Ʈ�̰�, ");
		}else if(m_strExpectFlucBit.equals("7")){	//�⼼�϶�
			sb.append(", ���� �ڽ���, 200,  �ְ�������, ").append(", �⼼�϶���, ").append(", , ").
			append(strCurrentDotLeft).append(", �� , [").append(strCurrentDotRight).append("], ����Ʈ�̰�, ");
		}else if(m_strExpectFlucBit.equals("8")){	//�⼼����
			sb.append(", ���� �ڽ���, 200,  �ְ�������, ").append(", �⼼������, ").append(", , ").
			append(strCurrentDotLeft).append(", �� , [").append(strCurrentDotRight).append("], ����Ʈ�̰�, ");
		}else if(m_strExpectFlucBit.equals("9")){	//�ŷ�����
			sb.append(", ���� �ڽ���, 200,  �ְ�������, ").append(" ,������, ").append(", , ").
			append(strCurrentDotLeft).append(", �� , [").append(strCurrentDotRight).append("], ����Ʈ�̰�, ");
		}else{
			actionAPI.setSessionData("ment", "error");
		}
		
		
		if(m_strExpectVolume != null && Integer.parseInt(m_strExpectVolume) > 0) {
			sb.append(" ���� �ŷ�����,").append(m_strExpectVolume).append(", ��, �Դϴ�.");
		} else {
			sb.append(" ���� �ŷ�����, �����ϴ�.");
		}
		
		
		// m_strStockPriceUpCnt3 �ڽ���, 200, �ְ����� ������� ����Ȯ��
		if(m_strStockPriceUpCnt.equals("0") || m_strStockPriceUpCnt.equals("") || m_strStockPriceUpCnt.equals(null)){
		sb.append(",�������, ����,");
		}else{
			sb.append(", ������� , ")
		.append(m_strStockPriceUpCnt)
		.append(", ����, ");
		}
		// m_strStockPriceDnCnt �ڽ���, 200, �ְ����� �϶����� ����Ȯ��
		if(m_strStockPriceDnCnt.equals("0") || m_strStockPriceDnCnt.equals("") || m_strStockPriceDnCnt.equals(null)){
		sb.append(",�϶�����, ����,");
		}else{
			sb.append(", �϶����� , ")
		.append(m_strStockPriceDnCnt)
		.append(", ����, ");
		}

	    // m_strStockPriceUnChgCnt �ڽ���, 200, �ְ����� �������� ����Ȯ��
		if(m_strStockPriceUnChgCnt.equals("0") || m_strStockPriceUnChgCnt.equals("") || m_strStockPriceUnChgCnt.equals(null)){
			sb.append(",��������, ����,");
		}else{
			sb.append(", �������� , ")
			.append(m_strStockPriceUnChgCnt)
			.append(", ����, ");
		}
		// m_strStockPriceUpLimitCnt �ڽ���, 200, �ְ����� ���Ѱ����� ����Ȯ��
		if(m_strStockPriceUpLimitCnt.equals("0") || m_strStockPriceUpLimitCnt.equals("") || m_strStockPriceUpLimitCnt.equals(null)){
			sb.append(",���ѱ�, ����,");
		}else{
			sb.append(", ���ѱ� , ")
			.append(m_strStockPriceUpLimitCnt)
			.append(", ����, ");
		}
		// m_strStockPriceDnLimitCnt �ڽ���, 200, �ְ����� ���Ѱ����� ����Ȯ��
		if(m_strStockPriceDnLimitCnt.equals("0") || m_strStockPriceDnLimitCnt.equals("") || m_strStockPriceDnLimitCnt.equals(null)){
			sb.append(",���ѱ�, �����ϴ�.,");
		}else{
			sb.append(", ���ѱ� , ")
			.append(m_strStockPriceDnLimitCnt)
			.append(", ����, �Դϴ�., ");
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
