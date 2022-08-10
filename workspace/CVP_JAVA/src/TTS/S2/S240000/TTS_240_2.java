package TTS.S2.S240000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_240_2 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strGiftFluctFlag = (String) actionAPI.getSessionData("m_strGiftFluctFlag"); //���ϴ�񱸺�
		String m_strGiftYear = (String) actionAPI.getSessionData("m_strGiftYear"); //�� 
		String m_strGiftItemCode = (String) actionAPI.getSessionData("m_strGiftItemCode"); //��
		m_strGiftItemCode = trimNum(m_strGiftItemCode);
		String m_strGiftFluctAmt = (String) actionAPI.getSessionData("m_strGiftFluctAmt"); //���ϴ��
		String m_strGiftCurrentAmt = (String) actionAPI.getSessionData("m_strGiftCurrentAmt"); //���簡
		String m_strGiftVol = (String) actionAPI.getSessionData("m_strGiftVol"); //�ŷ���

		// [���� ��� ���] 
		// �Ҽ��� �ڸ����� �����´�. 
		int strFluctDotIndex = m_strGiftFluctAmt.indexOf(".");
		// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
		String strFluctDotLeft = m_strGiftFluctAmt.substring(0, strFluctDotIndex);
		// �տ� 0�� ������ ���ش�.
		strFluctDotLeft = trimNum(strFluctDotLeft);
		// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
		String strFluctDotRight = m_strGiftFluctAmt.substring(strFluctDotIndex+1);
		// �տ� 0�� ������ ���ش�.
		//strFluctDotRight = trimNum(strFluctDotRight);
		
		// [���簡 ���]
		// �Ҽ��� �ڸ����� �����´�. 
		int strCurrentDotIndex = m_strGiftCurrentAmt.indexOf(".");
		// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
		String strCurrentDotLeft = m_strGiftCurrentAmt.substring(0, strCurrentDotIndex);
		// �տ� 0�� ������ ���ش�.
		strCurrentDotLeft = trimNum(strCurrentDotLeft);
		// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
		String strCurrentDotRight = m_strGiftCurrentAmt.substring(strCurrentDotIndex+1);
		// �տ� 0�� ������ ���ش�.
		//strCurrentDotRight = trimNum(strCurrentDotRight);
		
		// [�ŷ��� ���]
		m_strGiftVol = trimNum(m_strGiftVol);
		Float f_m_strGiftVol = Float.parseFloat(m_strGiftVol);
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		String m_strGiftOfferAmt = (String) actionAPI.getSessionData("m_strGiftOfferAmt"); //�ŵ�ȣ�� (ex : 00256.25)
		String m_strGiftBidAmt = (String) actionAPI.getSessionData("m_strGiftBidAmt"); //�ż�ȣ�� (ex : 00256.20)
		String m_strGiftOfferVol = (String) actionAPI.getSessionData("m_strGiftOfferVol"); //�Ѹŵ�ȣ���ܷ� (ex : 000007513)
		String m_strGiftBidVol = (String) actionAPI.getSessionData("m_strGiftBidVol"); //�Ѹż�ȣ���ܷ� (ex : 000013311)
		
		// �̸� trimNum �ϸ� .00 �� �� ���� ��
		m_strGiftOfferAmt = trimNum(m_strGiftOfferAmt);
		Float f_m_strGiftOfferAmt = Float.parseFloat(m_strGiftOfferAmt);
		
		m_strGiftBidAmt = trimNum(m_strGiftBidAmt);
		Float f_m_strGiftBidAmt = Float.parseFloat(m_strGiftBidAmt);
		
		m_strGiftOfferVol = trimNum(m_strGiftOfferVol);
		Float f_m_strGiftOfferVol = Float.parseFloat(m_strGiftOfferVol);
		m_strGiftBidVol = trimNum(m_strGiftBidVol);
		Float f_m_strGiftBidVol = Float.parseFloat(m_strGiftBidVol);
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		String m_strGiftOpenAmt = (String) actionAPI.getSessionData("m_strGiftOpenAmt"); //�ñ� (ex : 00254.60)
		String m_strGiftHighAmt = (String) actionAPI.getSessionData("m_strGiftHighAmt"); //���� (ex : 00256.60)
		String m_strGiftLowAmt = (String) actionAPI.getSessionData("m_strGiftLowAmt"); //���� (ex : 00254.30)
		m_strGiftOpenAmt = trimNum(m_strGiftOpenAmt);
		Float f_m_strGiftOpenAmt = Float.parseFloat(m_strGiftOpenAmt);
		m_strGiftHighAmt = trimNum(m_strGiftHighAmt);
		Float f_m_strGiftHighAmt = Float.parseFloat(m_strGiftHighAmt);
		m_strGiftLowAmt = trimNum(m_strGiftLowAmt);
		Float f_m_strGiftLowAmt = Float.parseFloat(m_strGiftLowAmt);
		
		StringBuffer sb = new StringBuffer();
		if(m_strGiftFluctFlag.equals("0")){			//����
			sb.append(m_strGiftYear).append(", �� , ")
			.append(m_strGiftItemCode).append(", �� , ")
			.append(", ��, ��, ")
			.append(", ���簡��, ")
			.append(", ���ϴ��, ")
			.append(", ������, ")
			.append(strCurrentDotLeft)
			.append(", �� , [")
			.append(strCurrentDotRight)
			.append("], ����Ʈ , ");
		}else if(m_strGiftFluctFlag.equals("1")){	//����
			sb.append(m_strGiftYear).append(", �� , ")
			.append(m_strGiftItemCode).append(", �� , ")
			.append(", ��, ��, ")
			.append(", ���簡��, ")
			.append(", ���ϴ��, ")
			.append(strFluctDotLeft)
			.append(", ��, [")
			.append(strFluctDotRight)
			.append("], ����Ʈ, ")
			.append(", ����, ")
			.append(strCurrentDotLeft)
			.append(", �� , [")
			.append(strCurrentDotRight)
			.append("], ����Ʈ , ");
		}else if(m_strGiftFluctFlag.equals("2")){	//���Ѱ�
			sb.append(m_strGiftYear).append(", �� , ")
			.append(m_strGiftItemCode).append(", �� , ")
			.append(", ��, ��, ")
			.append(", ���簡��, ")
			.append(", ���ϴ��, ")
			.append(", ���Ѱ���, ")
			.append(strCurrentDotLeft)
			.append(", �� , [")
			.append(strCurrentDotRight)
			.append("], ����Ʈ , ");
		}else if(m_strGiftFluctFlag.equals("3")){	//�⼼���
			sb.append(m_strGiftYear).append(", �� , ")
			.append(m_strGiftItemCode).append(", �� , ")
			.append(", ��, ��, ")
			.append(", ���簡��, ")
			.append(", ���ϴ��, ")
			.append(", �⼼��� ����, ")
			.append(strCurrentDotLeft)
			.append(", �� , [")
			.append(strCurrentDotRight)
			.append("], ����Ʈ , ");
		}else if(m_strGiftFluctFlag.equals("4")){	//�⼼����
			sb.append(m_strGiftYear).append(", �� , ")
			.append(m_strGiftItemCode).append(", �� , ")
			.append(", ��, ��, ")
			.append(", ���簡��, ")
			.append(", ���ϴ��, ")
			.append(", �⼼���� ����, ")
			.append(strCurrentDotLeft)
			.append(", �� , [")
			.append(strCurrentDotRight)
			.append("], ����Ʈ , ");
		}else if(m_strGiftFluctFlag.equals("5")){	//����
			sb.append(m_strGiftYear).append(", �� , ")
			.append(m_strGiftItemCode).append(", �� , ")
			.append(", ��, ��, ")
			.append(", ���簡��, ")
			.append(", ���ϴ��, ")
			.append(strFluctDotLeft)
			.append(", ��, [")
			.append(strFluctDotRight)
			.append("], ����Ʈ, ")
			.append(", ����, ")
			.append(strCurrentDotLeft)
			.append(", �� , [")
			.append(strCurrentDotRight)
			.append("], ����Ʈ , ");
		}else if(m_strGiftFluctFlag.equals("6")){	//���Ѱ�
			sb.append(m_strGiftYear).append(", �� , ")
			.append(m_strGiftItemCode).append(", �� , ")
			.append(", ��, ��, ")
			.append(", ���簡��, ")
			.append(", ���ϴ��, ")
			.append(", ���Ѱ���, ")
			.append(strCurrentDotLeft)
			.append(", �� , [")
			.append(strCurrentDotRight)
			.append("], ����Ʈ , ");
		}else if(m_strGiftFluctFlag.equals("7")){	//�⼼�϶�
			sb.append(m_strGiftYear).append(", �� , ")
			.append(m_strGiftItemCode).append(", �� , ")
			.append(", ��, ��, ")
			.append(", ���簡��, ")
			.append(", ���ϴ��, ")
			.append(", �⼼�϶� ����, ")
			.append(strCurrentDotLeft)
			.append(", �� , [")
			.append(strCurrentDotRight)
			.append("], ����Ʈ , ");
		}else if(m_strGiftFluctFlag.equals("8")){	//�⼼����
			sb.append(m_strGiftYear).append(", �� , ")
			.append(m_strGiftItemCode).append(", �� , ")
			.append(", ��, ��, ")
			.append(", ���簡��, ")
			.append(", ���ϴ��, ")
			.append(", �⼼���� ����, ")
			.append(strCurrentDotLeft)
			.append(", �� , [")
			.append(strCurrentDotRight)
			.append("], ����Ʈ , ");
		}else{
			actionAPI.setSessionData("ment", "error");
		}
		
		if(f_m_strGiftVol > 0.0){
			sb.append(", �ŷ�����,  ")
			.append(m_strGiftVol)
			.append(", ���, ")
			.append(", �Դϴ�.");
		}else{
			sb.append("�ŷ�����, �����ϴ�.");
		}
		
		//f_m_strGiftOfferAmt //�ŵ�ȣ��
		if(f_m_strGiftOfferAmt > 0.0){
			sb.append(", �ŵ�ȣ��, ");
			sb.append(dotNumTTS(m_strGiftOfferAmt, "����Ʈ"));
			
		}else{
			sb.append(", �ŵ�ȣ��, ")
			.append(", ����, ");
		}
		
		//f_m_strGiftBidAmt // �ż�ȣ��
		if(f_m_strGiftBidAmt > 0.0){
			sb.append(", �ż�ȣ��, ");
			sb.append(dotNumTTS(m_strGiftBidAmt, "����Ʈ"));
		}else{
			sb.append(", �ż�ȣ��, ")
			.append(", ����, ");
		}
		
		//f_m_strGiftOfferVol // �Ѹŵ��ܷ�
		if(f_m_strGiftOfferVol > 0.0){
			sb.append(", �� �ŵ� ȣ���ܷ�, ")
			.append(m_strGiftOfferVol)
			.append(", ���, ");
		}else{
			sb.append(", �� �ŵ� ȣ���ܷ�, ")
			.append(", ����, ");
		}
		
		//f_m_strGiftBidVol // �Ѹż��ܷ�
		if(f_m_strGiftBidVol > 0.0){
			sb.append(", �� �ż� ȣ���ܷ�, ")
			.append(m_strGiftBidVol)
			.append(", ���, ")
			.append(", �Դϴ�., ");
		}else{
			sb.append(", �� �ż� ȣ���ܷ�, ")
			.append(", ����, ");
		}
		
		//f_m_strGiftOpenAmt // �ñ�
		if(f_m_strGiftOpenAmt > 0.0){
			sb.append(", �ñ� , ");
			sb.append(dotNumTTS(m_strGiftOpenAmt, "����Ʈ"));
		}else{
			sb.append(", �ñ�, ")
			.append(", ����, ");
		}
		
		//f_m_strGiftHighAmt // ����
		if(f_m_strGiftHighAmt > 0.0){
			sb.append(", ����, ");
			sb.append(dotNumTTS(m_strGiftHighAmt, "����Ʈ"));
		}else{
			sb.append(", ����, ")
			.append(", ����, ");
		}
		
		//f_m_strGiftLowAmt // ����
		if(f_m_strGiftLowAmt > 0.0){
			sb.append(", ���� , ");
			sb.append(dotNumTTS(m_strGiftLowAmt, "����Ʈ"));
		}else{
			sb.append(", ����, ")
			.append("�����ϴ�.");
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
	
	private String dotNumTTS(String str, String unit){
		String leftStr = "";
		String rightStr = "";
		StringBuffer sb = new StringBuffer();
		int index = str.indexOf(".");
		
		if(index < 0) {
			leftStr = str;
		} else {
			leftStr = str.substring(0, index);
			rightStr = str.substring(index+1);
		}
		//�ڿ��� ó��
		leftStr = trimNum(leftStr);
		sb.append(leftStr);
		//�Ҽ��� �� 2�ڸ� ó��
		if(rightStr.equals("00") || rightStr.equals("0") || rightStr.equals("")){
			sb.append(", " + unit + ", ");
		}else{
			String lastStr = rightStr.substring(rightStr.length() - 1);
			if(lastStr.equals("0")){
				rightStr = rightStr.substring(0, 1);
				sb.append(", ��, [")
				.append(rightStr)
				.append("], " + unit + ", ");
			}else{
				sb.append(", ��, [")
				.append(rightStr)
				.append("], " + unit + ", ");
			}
		}
		return sb.toString();
	}
}