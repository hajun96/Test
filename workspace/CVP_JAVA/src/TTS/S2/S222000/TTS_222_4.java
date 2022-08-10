package TTS.S2.S222000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_222_4 extends ActionElementBase {
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strStockPriceFluctFlag3 = (String) actionAPI.getSessionData("m_strStockPriceFluctFlag3"); //�ڽ����ְ����� ���ϴ�񱸺�
		String m_strStockPriceFluctAmt3 = (String) actionAPI.getSessionData("m_strStockPriceFluctAmt3");	//�ڽ����ְ����� ���ϴ��
		String m_strStockPriceCurrentAmt3 = (String) actionAPI.getSessionData("m_strStockPriceCurrentAmt3");	  //�ڽ����ְ����� ���簡
		String m_strStockPriceVol3 = (String) actionAPI.getSessionData("m_strStockPriceVol3");		//�ڽ����ְ����� �ŷ���
		String m_strStockPriceTrdAmt3 = (String) actionAPI.getSessionData("m_strStockPriceTrdAmt3");		//�ڽ����ְ����� �ŷ����
		String m_strStockPriceUpCnt3 = (String) actionAPI.getSessionData("m_strStockPriceUpCnt3");		//�ڽ����ְ����� ������� ����
		m_strStockPriceUpCnt3 = trimNum(m_strStockPriceUpCnt3);
		String m_strStockPriceDnCnt3 = (String) actionAPI.getSessionData("m_strStockPriceDnCnt3");		//�ڽ����ְ����� �϶����� ����
		m_strStockPriceDnCnt3 = trimNum(m_strStockPriceDnCnt3);
		String m_strStockPriceUnChgCnt3 = (String) actionAPI.getSessionData("m_strStockPriceUnChgCnt3");		//�ڽ����ְ����� �������� ����
		m_strStockPriceUnChgCnt3 = trimNum(m_strStockPriceUnChgCnt3);
		String m_strStockPriceUpLimitCnt3 = (String) actionAPI.getSessionData("m_strStockPriceUpLimitCnt3");		//�ڽ����ְ����� ���Ѱ����� ����
		m_strStockPriceUpLimitCnt3 = trimNum(m_strStockPriceUpLimitCnt3);
		String m_strStockPriceDnLimitCnt3 = (String) actionAPI.getSessionData("m_strStockPriceDnLimitCnt3");		//�ڽ����ְ����� ���Ѱ� ���� ����
		m_strStockPriceDnLimitCnt3 = trimNum(m_strStockPriceDnLimitCnt3);
		
		String m_strStockPriceFluctFlag0 = (String) actionAPI.getSessionData("m_strStockPriceFluctFlag0");     //�����ְ����� ���ϴ�񱸺�
		String m_strStockPriceFluctAmt0 = (String) actionAPI.getSessionData("m_strStockPriceFluctAmt0");	   //�����ְ����� ���ϴ��
		String m_strStockPriceCurrentAmt0 = (String) actionAPI.getSessionData("m_strStockPriceCurrentAmt0");//�����ְ����� ���簡
		
		
		String m_strNowTime = (String) actionAPI.getSessionData("m_strNowTime");               // ����ð�
		
		// ����ð� ���
		String HH = m_strNowTime.substring(0, 2);	//��
		HH = trimNum(HH);
		String mm = m_strNowTime.substring(2, 4);	//��
		mm = trimNum(mm);
		
		
		
		// [�ڽ����ְ����� ���� ��� ���] 
		// �Ҽ��� �ڸ����� �����´�. 
		int strFluctDotIndex3 = m_strStockPriceFluctAmt3.indexOf(".");
		// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
		String strFluctDotLeft3 = m_strStockPriceFluctAmt3.substring(0, strFluctDotIndex3);
		// �տ� 0�� ������ ���ش�.
		strFluctDotLeft3 = trimNum(strFluctDotLeft3);
		// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
		String strFluctDotRight3 = m_strStockPriceFluctAmt3.substring(strFluctDotIndex3+1);
			
		// [�ڽ����ְ����� ���簡 ���]
		// �Ҽ��� �ڸ����� �����´�. 
		int strCurrentDotIndex3 = m_strStockPriceCurrentAmt3.indexOf(".");
		// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
		String strCurrentDotLeft3 = m_strStockPriceCurrentAmt3.substring(0, strCurrentDotIndex3);
		// �տ� 0�� ������ ���ش�.
		strCurrentDotLeft3 = trimNum(strCurrentDotLeft3);
		// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
		String strCurrentDotRight3 = m_strStockPriceCurrentAmt3.substring(strCurrentDotIndex3+1);
		// [�ڽ����ְ����� �ŷ��� ���]
		m_strStockPriceVol3 = trimNum(m_strStockPriceVol3);
		long l_m_strStockPriceVol3 = Long.parseLong(m_strStockPriceVol3) * 1000;
		m_strStockPriceVol3 = String.valueOf(l_m_strStockPriceVol3);
		// [�ڽ����ְ����� �ŷ���� ���]
		m_strStockPriceTrdAmt3 = trimNum(m_strStockPriceTrdAmt3); 
		Long m_lStockPriceTrdAmt3 = Long.parseLong(m_strStockPriceTrdAmt3) * 1000000;
		m_strStockPriceTrdAmt3 = String.valueOf(m_lStockPriceTrdAmt3);
		
		
		
		// [�����ְ����� ���� ��� ���] 
		// �Ҽ��� �ڸ����� �����´�. 
		int strFluctDotIndex0 = m_strStockPriceFluctAmt0.indexOf(".");
		// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
		String strFluctDotLeft0 = m_strStockPriceFluctAmt0.substring(0, strFluctDotIndex0);
		// �տ� 0�� ������ ���ش�.
		strFluctDotLeft0 = trimNum(strFluctDotLeft0);
		// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
		String strFluctDotRight0 = m_strStockPriceFluctAmt0.substring(strFluctDotIndex0+1);
		// [�ڽ������� ���簡 ���]
		// �Ҽ��� �ڸ����� �����´�. 
		int strCurrentDotIndex0 = m_strStockPriceCurrentAmt0.indexOf(".");
		// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
		String strCurrentDotLeft0 = m_strStockPriceCurrentAmt0.substring(0, strCurrentDotIndex0);
		// �տ� 0�� ������ ���ش�.
		strCurrentDotLeft0 = trimNum(strCurrentDotLeft3);
		// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
		String strCurrentDotRight0 = m_strStockPriceCurrentAmt0.substring(strCurrentDotIndex0+1);
		

		StringBuffer sb = new StringBuffer();
		sb.append(HH).append("��, ")
		.append(mm).append(", ��, ")
		.append(", ����, ").append(", �ڽ��� , ������, ");
		
		if(m_strStockPriceFluctFlag3.equals("0")){			//����
			sb.append(", ������ , ")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ  , ").append(", �̰�, ")
			.append(", �ŷ����� , " ).append(m_strStockPriceVol3).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������ , ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag3.equals("1")){	//����
			sb.append(strFluctDotLeft3).append(", ��, [").append(strFluctDotRight3).append("], ����Ʈ, ")
			.append(", ����  , ")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , �̰�,")
			.append(", �ŷ����� , " ).append(m_strStockPriceVol3).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������ , ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag3.equals("2")){	//���Ѱ�
			sb.append(", ���Ѱ��� , ")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , �̰�,")
			.append(", �ŷ����� , " ).append(m_strStockPriceVol3).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������ , ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag3.equals("3")){	//�⼼���
			sb.append(", �⼼���, ����, ")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , �̰�,")
			.append(", �ŷ�����, " ).append(m_strStockPriceVol3).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������, ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag3.equals("4")){	//�⼼����
			sb.append(", �⼼����, ����, ")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , �̰�,")
			.append(", �ŷ�����, " ).append(m_strStockPriceVol3).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������, ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag3.equals("5")){	//����
			sb.append(strFluctDotLeft3).append(", ��, [").append(strFluctDotRight3).append("], ����Ʈ, ")
			.append(", ���� , ")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , �̰�,")
			.append(", �ŷ�����, " ).append(m_strStockPriceVol3).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������, ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag3.equals("6")){	//���Ѱ�
			sb.append(", ���Ѱ���,")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , �̰�,")
			.append(", �ŷ�����, " ).append(m_strStockPriceVol3).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������, ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag3.equals("7")){	//�⼼�϶�
			sb.append(", �⼼�϶�, ����,")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , �̰�,")
			.append(", �ŷ�����, " ).append(m_strStockPriceVol3).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������, ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag3.equals("8")){	//�⼼����
			sb.append(", �⼼����, ����, ")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , �̰�,")
			.append(", �ŷ�����, " ).append(m_strStockPriceVol3).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������, ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag3.equals("9")){	//�ŷ�����
			sb.append(", ������, ")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , ").append(", �̰�, ")
			.append(", �ŷ�����, " ).append(m_strStockPriceVol3).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������, ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", ��, �Դϴ�.");
		}else{
			actionAPI.setSessionData("ment", "error");
		}
		
        // m_strStockPriceUpCnt3 �����ְ����� ������� ����Ȯ��
		if(m_strStockPriceUpCnt3.equals("0") || m_strStockPriceUpCnt3.equals("") || m_strStockPriceUpCnt3.equals(null)){
			sb.append(",�������, ����,");
		}else{
			sb.append(", ������� , ")
			.append(m_strStockPriceUpCnt3)
			.append(", ����, ");
		}
		// m_strStockPriceDnCnt3 �����ְ����� �϶����� ����Ȯ��
		if(m_strStockPriceDnCnt3.equals("0") || m_strStockPriceDnCnt3.equals("") || m_strStockPriceDnCnt3.equals(null)){
			sb.append(",�϶�����, ����,");
		}else{
			sb.append(", �϶����� , ")
			.append(m_strStockPriceDnCnt3)
			.append(", ����, ");
		}
		// m_strStockPriceUnChgCnt3 �����ְ����� �������� ����Ȯ��
		if(m_strStockPriceUnChgCnt3.equals("0") || m_strStockPriceUnChgCnt3.equals("") || m_strStockPriceUnChgCnt3.equals(null)){
			sb.append(",��������, ����,");
		}else{
			sb.append(", �������� , ")
			.append(m_strStockPriceUnChgCnt3)
			.append(", ����, ");
		}
		// m_strStockPriceUpLimitCnt3 �����ְ����� ���Ѱ����� ����Ȯ��
		if(m_strStockPriceUpLimitCnt3.equals("0") || m_strStockPriceUpLimitCnt3.equals("") || m_strStockPriceUpLimitCnt3.equals(null)){
			sb.append(",���ѱ�, ����,");
		}else{
			sb.append(", ���ѱ� , ")
			.append(m_strStockPriceUpLimitCnt3)
			.append(", ����, ");
		}
		// m_strStockPriceDnLimitCnt3 �����ְ����� ���Ѱ����� ����Ȯ��
		if(m_strStockPriceDnLimitCnt3.equals("0") || m_strStockPriceDnLimitCnt3.equals("") || m_strStockPriceDnLimitCnt3.equals(null)){
			sb.append(",���ѱ�, ������,");
		}else{
			sb.append(", ���ѱ� , ")
			.append(m_strStockPriceDnLimitCnt3)
			.append(", ���� �̸�, ");
		}
		
		sb.append(", ����, �ְ�, ������, ���ϴ��, ");

		// ���� �ְ�����
		if(m_strStockPriceFluctFlag0.equals("0")){			//����
			sb.append(", ������ , ")
			.append(strCurrentDotLeft0).append(", �� , [").append(strCurrentDotRight0).append("], ����Ʈ  , ").append(", �Դϴ�. ");
		}else if(m_strStockPriceFluctFlag0.equals("1")){	//����
			sb.append(strFluctDotLeft0).append(", ��, [").append(strFluctDotRight0).append("], ����Ʈ, ")
			.append(", ����  , ")
			.append(strCurrentDotLeft0).append(", �� , [").append(strCurrentDotRight0).append("], ����Ʈ , �Դϴ�.");
		}else if(m_strStockPriceFluctFlag0.equals("2")){	//���Ѱ�
			sb.append(", ���Ѱ��� , ")
			.append(strCurrentDotLeft0).append(", �� , [").append(strCurrentDotRight0).append("], ����Ʈ , �Դϴ�.");
		}else if(m_strStockPriceFluctFlag0.equals("3")){	//�⼼���
			sb.append(", �⼼������� , ")
			.append(strCurrentDotLeft0).append(", �� , [").append(strCurrentDotRight0).append("], ����Ʈ , �Դϴ�.");
		}else if(m_strStockPriceFluctFlag0.equals("4")){	//�⼼����
			sb.append(", �⼼�������� , ")
			.append(strCurrentDotLeft0).append(", �� , [").append(strCurrentDotRight0).append("], ����Ʈ , �Դϴ�.");
		}else if(m_strStockPriceFluctFlag0.equals("5")){	//����
			sb.append(strFluctDotLeft0).append(", ��, [").append(strFluctDotRight0).append("], ����Ʈ, ")
			.append(", ���� , ")
			.append(strCurrentDotLeft0).append(", �� , [").append(strCurrentDotRight0).append("], ����Ʈ , �Դϴ�.");
		}else if(m_strStockPriceFluctFlag0.equals("6")){	//���Ѱ�
			sb.append(", ���Ѱ���,")
			.append(strCurrentDotLeft0).append(", �� , [").append(strCurrentDotRight0).append("], ����Ʈ , �Դϴ�.");
		}else if(m_strStockPriceFluctFlag0.equals("7")){	//�⼼�϶�
			sb.append(", �⼼�϶�����,")
			.append(strCurrentDotLeft0).append(", �� , [").append(strCurrentDotRight0).append("], ����Ʈ , �Դϴ�.");
		}else if(m_strStockPriceFluctFlag0.equals("8")){	//�⼼����
			sb.append(", �⼼��������,")
			.append(strCurrentDotLeft0).append(", �� , [").append(strCurrentDotRight0).append("], ����Ʈ , �Դϴ�.");
		}else if(m_strStockPriceFluctFlag0.equals("9")){	//�ŷ�����
			sb.append(", ������ , ")
			.append(strCurrentDotLeft0).append(", �� , [").append(strCurrentDotRight0).append("], ����Ʈ  , ").append(", �Դϴ�. ");
		}else{
			actionAPI.setSessionData("ment", "error");
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