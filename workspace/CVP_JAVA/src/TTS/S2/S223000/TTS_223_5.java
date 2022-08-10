package TTS.S2.S223000;

import java.util.Hashtable;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_223_5 extends ActionElementBase{
	@Override
	public void doAction(String arg0, ActionElementData actionAPI) throws AudiumException {
		String m_strStockPriceFluctFlag = (String) actionAPI.getSessionData("m_strStockPriceFluctFlag");        //�ڽ���200���� ���ϴ�񱸺�
		String m_strStockPriceFluctAmt = (String) actionAPI.getSessionData("m_strStockPriceFluctAmt");	      //�ڽ���200���� ���ϴ��
		String m_strStockPriceCurrentAmt = (String) actionAPI.getSessionData("m_strStockPriceCurrentAmt");	  //�ڽ���200���� ���簡
		String m_strStockPriceVol = (String) actionAPI.getSessionData("m_strStockPriceVol");		              //�ڽ���200���� �ŷ���
		String m_strStockPriceTrdAmt = (String) actionAPI.getSessionData("m_strStockPriceTrdAmt");		      //�ڽ���200���� �ŷ����
		String m_strStockPriceUpCnt = (String) actionAPI.getSessionData("m_strStockPriceUpCnt");		          //�ڽ���200���� ������� ����
		m_strStockPriceUpCnt = trimNum(m_strStockPriceUpCnt);
		String m_strStockPriceDnCnt = (String) actionAPI.getSessionData("m_strStockPriceDnCnt");		          //�ڽ���200���� �϶����� ����
		m_strStockPriceDnCnt = trimNum(m_strStockPriceDnCnt);
		String m_strStockPriceUnChgCnt = (String) actionAPI.getSessionData("m_strStockPriceUnChgCnt");		  //�ڽ���200���� �������� ����
		m_strStockPriceUnChgCnt = trimNum(m_strStockPriceUnChgCnt);
		String m_strStockPriceUpLimitCnt = (String) actionAPI.getSessionData("m_strStockPriceUpLimitCnt");	  //�ڽ���200���� ���Ѱ����� ����
		m_strStockPriceUpLimitCnt = trimNum(m_strStockPriceUpLimitCnt);
		String m_strStockPriceDnLimitCnt = (String) actionAPI.getSessionData("m_strStockPriceDnLimitCnt");	  //�ڽ���200���� ���Ѱ� ���� ����
		m_strStockPriceDnLimitCnt = trimNum(m_strStockPriceDnLimitCnt);

		// [�ڽ���200���� �ŷ��� ���]
		m_strStockPriceVol = trimNum(m_strStockPriceVol);
		long l_m_strStockPriceVol = Long.parseLong(m_strStockPriceVol) * 1000;
		m_strStockPriceVol = String.valueOf(l_m_strStockPriceVol);
		// [�ڽ���200���� �ŷ���� ���]
		m_strStockPriceTrdAmt = trimNum(m_strStockPriceTrdAmt); 
		Long m_lStockPriceTrdAmt3 = Long.parseLong(m_strStockPriceTrdAmt) * 1000000;
		m_strStockPriceTrdAmt = m_lStockPriceTrdAmt3.toString();
		
		// [�ڽ���200����  ���� ��� ���] 
		// �Ҽ��� �ڸ����� �����´�. 
		int strFluctDotIndex3 = m_strStockPriceFluctAmt.indexOf(".");
		// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
		String strFluctDotLeft3 = m_strStockPriceFluctAmt.substring(0, strFluctDotIndex3);
		// �տ� 0�� ������ ���ش�.
		strFluctDotLeft3 = trimNum(strFluctDotLeft3);
		// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
		String strFluctDotRight3 = m_strStockPriceFluctAmt.substring(strFluctDotIndex3+1);
		// [�ڽ������� ���簡 ���]
		// �Ҽ��� �ڸ����� �����´�. 
		int strCurrentDotIndex3 = m_strStockPriceCurrentAmt.indexOf(".");
		// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
		String strCurrentDotLeft3 = m_strStockPriceCurrentAmt.substring(0, strCurrentDotIndex3);
		// �տ� 0�� ������ ���ش�.
		strCurrentDotLeft3 = trimNum(strCurrentDotLeft3);
		// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
		String strCurrentDotRight3 = m_strStockPriceCurrentAmt.substring(strCurrentDotIndex3+1);
		
		StringBuffer sb = new StringBuffer();
		sb.append(",�ڽ��� 200 ������, ");
	
		if(m_strStockPriceFluctFlag.equals("0")){			//����
			sb.append(", ������ , ")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ  , ").append(", �̰�, ")
			.append(", �ŷ����� , " ).append(m_strStockPriceVol).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������ , ").append(m_strStockPriceTrdAmt).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag.equals("1")){	//����
			sb.append(strFluctDotLeft3).append(", ��, [").append(strFluctDotRight3).append("], ����Ʈ, ")
			.append(", ����  , ")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , �̰�,")
			.append(", �ŷ����� , " ).append(m_strStockPriceVol).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������ , ").append(m_strStockPriceTrdAmt).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag.equals("2")){	//���Ѱ�
			sb.append(", ���Ѱ��� , ")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , �̰�,")
			.append(", �ŷ����� , " ).append(m_strStockPriceVol).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������ , ").append(m_strStockPriceTrdAmt).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag.equals("3")){	//�⼼���
			sb.append(", �⼼���, ����, ")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , �̰�,")
			.append(", �ŷ�����, " ).append(m_strStockPriceVol).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������, ").append(m_strStockPriceTrdAmt).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag.equals("4")){	//�⼼����
			sb.append(", �⼼����, ����, ")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , �̰�,")
			.append(", �ŷ�����, " ).append(m_strStockPriceVol).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������, ").append(m_strStockPriceTrdAmt).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag.equals("5")){	//����
			sb.append(strFluctDotLeft3).append(", ��, [").append(strFluctDotRight3).append("], ����Ʈ, ")
			.append(", ���� , ")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , �̰�,")
			.append(", �ŷ�����, " ).append(m_strStockPriceVol).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������, ").append(m_strStockPriceTrdAmt).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag.equals("6")){	//���Ѱ�
			sb.append(", ���Ѱ���,")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , �̰�,")
			.append(", �ŷ�����, " ).append(m_strStockPriceVol).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������, ").append(m_strStockPriceTrdAmt).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag.equals("7")){	//�⼼�϶�
			sb.append(", �⼼�϶�, ����,")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , �̰�,")
			.append(", �ŷ�����, " ).append(m_strStockPriceVol).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������, ").append(m_strStockPriceTrdAmt).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag.equals("8")){	//�⼼����
			sb.append(", �⼼����, ����, ")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , �̰�,")
			.append(", �ŷ�����, " ).append(m_strStockPriceVol).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������, ").append(m_strStockPriceTrdAmt).append(",  , ").append(", ��, �Դϴ�.");
		}else if(m_strStockPriceFluctFlag.equals("9")){	//�ŷ�����
			sb.append(", ������, ")
			.append(strCurrentDotLeft3).append(", �� , [").append(strCurrentDotRight3).append("], ����Ʈ , ").append(", �̰�, ")
			.append(", �ŷ�����, " ).append(m_strStockPriceVol).append(",  , ").append(", ��, �̸�,")
			.append(", �ŷ������, ").append(m_strStockPriceTrdAmt).append(",  , ").append(", ��, �Դϴ�.");
		}else{
			actionAPI.setSessionData("ment", "error");
		}
		
		// m_strStockPriceUpCnt  �ڽ����ְ����� ������� ����Ȯ��
		if(m_strStockPriceUpCnt.equals("0") || m_strStockPriceUpCnt.equals("") || m_strStockPriceUpCnt.equals(null)){
			sb.append(",�������, ����,");
		}else{
			sb.append(", ������� , ")
			.append(m_strStockPriceUpCnt)
			.append(", ����, ");
		}
		// m_strStockPriceDnCnt �ڽ����ְ����� �϶����� ����Ȯ��
		if(m_strStockPriceDnCnt.equals("0") || m_strStockPriceDnCnt.equals("") || m_strStockPriceDnCnt.equals(null)){
			sb.append(",�϶�����, ����,");
		}else{
			sb.append(", �϶����� , ")
			.append(m_strStockPriceDnCnt)
			.append(", ����, ");
		}
		// m_strStockPriceUnChgCnt �ڽ����ְ����� �������� ����Ȯ��
		if(m_strStockPriceUnChgCnt.equals("0") || m_strStockPriceUnChgCnt.equals("") || m_strStockPriceUnChgCnt.equals(null)){
			sb.append(",��������, ����,");
		}else{
			sb.append(", �������� , ")
			.append(m_strStockPriceUnChgCnt)
			.append(", ����, ");
		}
		// m_strStockPriceUpLimitCnt �ڽ����ְ����� ���Ѱ����� ����Ȯ��
		if(m_strStockPriceUpLimitCnt.equals("0") || m_strStockPriceUpLimitCnt.equals("") || m_strStockPriceUpLimitCnt.equals(null)){
			sb.append(",���ѱ�, ����,");
		}else{
			sb.append(", ���ѱ� , ")
			.append(m_strStockPriceUpLimitCnt)
			.append(", ����, ");
		}
		// m_strStockPriceDnLimitCnt �ڽ����ְ����� ���Ѱ����� ����Ȯ��
		if(m_strStockPriceDnLimitCnt.equals("0") || m_strStockPriceDnLimitCnt.equals("") || m_strStockPriceDnLimitCnt.equals(null)){
			sb.append(",���ѱ�, �����ϴ�.");
		}else{
			sb.append(", ���ѱ� , ")
			.append(m_strStockPriceDnLimitCnt)
			.append(", ���� , �Դϴ�. ");
		}
		
		actionAPI.setSessionData("ment", sb.toString());
	}
	

	private String convertHour(String hour) {
		// TODO Auto-generated method stub
		if(hour == null || hour.isEmpty()) {
			return "";
		}
		
		int time = Integer.parseInt(hour);
		if(time <= 12){
			return hour;
		}
		
		time = time - 12;
		
		switch (time) {
		case 1:
			hour = "�ѽ�";
			break;
		case 2: 
			hour = "�ν�";
			break;
		case 3:
			hour = "����";
			break;
		case 4:
			hour = "�׽�";
			break;
		case 5:
			hour = "�ټ���";
			break;
		case 6:
			hour = "������";
			break;
		case 7:
			hour = "�ϰ���";
			break;
		case 8:
			hour = "������";
			break;
		case 9:
			hour = "��ȩ��";
			break;
		case 10:
			hour = "����";
			break;
		case 11:
			hour = "���ѽ�";
			break;
		case 12:
			hour = "���ν�";
			break;
		default:
			break;
		}
		
		return hour;
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
