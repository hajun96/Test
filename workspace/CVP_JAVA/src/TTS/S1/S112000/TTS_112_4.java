package TTS.S1.S112000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

//���� �ְ����� �ȳ�
public class TTS_112_4 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strStockPriceCurrentAmt = (String) actionAPI.getSessionData("m_strStockPriceCurrentAmt"); //���簡
		String m_strStockPriceFluctFlag = (String) actionAPI.getSessionData("m_strStockPriceFluctFlag");	//���ϴ�񱸺�
		String m_strStockPriceFluctAmt = (String) actionAPI.getSessionData("m_strStockPriceFluctAmt");	//���ϴ��
		String m_strStockPriceVol = (String) actionAPI.getSessionData("m_strStockPriceVol");		//�ŷ���
		// [���� ��� ���] 
		// �Ҽ��� �ڸ����� �����´�. 
		int strFluctDotIndex = m_strStockPriceFluctAmt.indexOf(".");
		// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
		String strFluctDotLeft = m_strStockPriceFluctAmt.substring(0, strFluctDotIndex);
		// �տ� 0�� ������ ���ش�.
		strFluctDotLeft = trimNum(strFluctDotLeft);
		// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
		String strFluctDotRight = m_strStockPriceFluctAmt.substring(strFluctDotIndex+1);
		// �տ� 0�� ������ ���ش�.
		strFluctDotRight = trimNum(strFluctDotRight);
		
		// [���簡 ���]
		// �Ҽ��� �ڸ����� �����´�. 
		int strCurrentDotIndex = m_strStockPriceCurrentAmt.indexOf(".");
		// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
		String strCurrentDotLeft = m_strStockPriceCurrentAmt.substring(0, strCurrentDotIndex);
		// �տ� 0�� ������ ���ش�.
		strCurrentDotLeft = trimNum(strCurrentDotLeft);
		// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
		String strCurrentDotRight = m_strStockPriceCurrentAmt.substring(strCurrentDotIndex+1);
		
		
		
		// [�ŷ��� ���]
		m_strStockPriceVol = trimNum(m_strStockPriceVol);
		
		long l_m_strStockPriceVol = Long.parseLong(m_strStockPriceVol) * 1000;
		m_strStockPriceVol = String.valueOf(l_m_strStockPriceVol);
		//Float f_m_strStockPriceVol = Float.parseFloat(m_strStockPriceVol);
		//f_m_strStockPriceVol = (float) (f_m_strStockPriceVol * 1000.0);
		//m_strStockPriceVol = f_m_strStockPriceVol.toString();
		
		StringBuffer sb = new StringBuffer();
		
		
		if(m_strStockPriceFluctFlag.equals("0")){			//����
			sb.append(", ���� �ְ�������, ").append(", ������, ").
			append(strCurrentDotLeft).append(", ��, [").append(strCurrentDotRight).append(",] ����Ʈ�̰�,  , ");
		}else if(m_strStockPriceFluctFlag.equals("1")){	//����
			sb.append(", ���� �ְ�������, ").append(strFluctDotLeft).append(", ��, [").append(strFluctDotRight).append("], ����Ʈ , ")
			.append(", ����, ").append(strCurrentDotLeft).append(", ��, [").append(strCurrentDotRight).append("], ����Ʈ�̰� , ");
		}else if(m_strStockPriceFluctFlag.equals("2")){	//���Ѱ�
			sb.append(", ���� �ְ�������, ").append(", ���Ѱ���, ").
			append(strCurrentDotLeft).append(", ��, [").append(strCurrentDotRight).append("], ����Ʈ�̰� , ");
		}else if(m_strStockPriceFluctFlag.equals("3")){	//�⼼���
			sb.append(", ���� �ְ�������, ").append(", �⼼�����, ").
			append(strCurrentDotLeft).append(", ��, [").append(strCurrentDotRight).append("], ����Ʈ�̰� , ");
		}else if(m_strStockPriceFluctFlag.equals("4")){	//�⼼����
			sb.append(", ���� �ְ�������, ").append(", �⼼������, ").
			append(strCurrentDotLeft).append(", ��, [").append(strCurrentDotRight).append("], ����Ʈ�̰� , ");
		}else if(m_strStockPriceFluctFlag.equals("5")){	//����
			sb.append(", ���� �ְ�������, ").append(strFluctDotLeft).append(", ��, [").append(strFluctDotRight).append("], ����Ʈ , ")
			.append(", ����, ").append(strCurrentDotLeft).append(", ��, [").append(strCurrentDotRight).append("], ����Ʈ�̰� , ");
		}else if(m_strStockPriceFluctFlag.equals("6")){	//���Ѱ�
			sb.append(", ���� �ְ�������, ").append(", ���Ѱ���, ").
			append(m_strStockPriceFluctFlag).append(", ��, [").append(strCurrentDotRight).append("], ����Ʈ�̰� , ");
		}else if(m_strStockPriceFluctFlag.equals("7")){	//�⼼�϶�
			sb.append(", ���� �ְ�������, ").append(", �⼼�϶���, ").
			append(strCurrentDotLeft).append(", ��, [").append(strCurrentDotRight).append("], ����Ʈ�̰� , ");
		}else if(m_strStockPriceFluctFlag.equals("8")){	//�⼼����
			sb.append(", ���� �ְ�������, ").append(", �⼼������, ").
			append(strCurrentDotLeft).append(", ��, [").append(strCurrentDotRight).append("], ����Ʈ�̰� , ");
		}else if(m_strStockPriceFluctFlag.equals("9")){	//�ŷ�����
			sb.append(", ���� �ְ�������, ").append(", ������, ").
			append(strCurrentDotLeft).append(", ��, [").append(strCurrentDotRight).append("], ����Ʈ�̰� , ");
		}else{
			actionAPI.setSessionData("ment", "error");
		}
		
		if(l_m_strStockPriceVol > 0.0){
			sb.append(", �ŷ�����,  ").append(m_strStockPriceVol).append(", ��, ").append(", �Դϴ�., ");
		}else{
			sb.append(", �ŷ����� �����ϴ�., ");
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
