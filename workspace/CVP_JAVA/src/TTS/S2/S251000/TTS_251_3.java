package TTS.S2.S251000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_251_3 extends ActionElementBase {
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		/*��_�����	m_strGiftItemName
		��_���簡	m_strGiftCurrentAmt
		��_���ϴ�񱸺�	m_strGiftFluctFlag
		��_���ϴ��	m_strGiftFluctAmt
		��_�ŵ�ȣ��	m_strGiftOfferAmt
		��_�ż�ȣ��	m_strGiftBidAmt
		��_�ŷ���	m_strGiftVol
		��_��������	m_strGiftPrevAmt
		��_���ϰŷ���	m_strGiftPrevVol
		��_�ð�	m_strGiftOpenAmt
		��_��	m_strGiftHighAmt
		��_����	m_strGiftLowAmt
		��_��簡��	m_strGiftStrikePrice
		�켱�ŵ�ȣ���ܷ�	m_strGiftDiffOfferAmt4
		�켱�ŵ����	m_strGiftOfferVol4
		�켱�ż�ȣ���ܷ�	m_strGiftDiffBidAmt0
		�켱�ż����	m_strGiftBidVol0
		�����ŵ�ȣ���ܷ�	m_strGiftDiffOfferAmt3
		�����ŵ����	m_strGiftOfferVol3
		�����ż�ȣ���ܷ�	m_strGiftDiffBidAmt1
		�����ż����	m_strGiftBidVol1
		�Ѹŵ�ȣ���ܷ�	m_strGiftOfferVol5
		�Ѹż�ȣ���ܷ�	m_strGiftBidVol5
		�Ѹŵ��Ǽ�	m_strGiftOfferCnt5
		�Ѹż��Ǽ�	m_strGiftBidCnt5*/
		
		String m_strGiftYear = (String) actionAPI.getSessionData("m_strGiftYear"); //�� 
		String m_strGiftItemCode = (String) actionAPI.getSessionData("m_strGiftItemCode"); //��
		String m_strGiftStrikePrice = (String) actionAPI.getSessionData("m_strGiftStrikePrice"); //��_��簡��
		String m_strGiftFluctFlag = (String) actionAPI.getSessionData("m_strGiftFluctFlag"); //��_���ϴ�񱸺�
		String m_strGiftFluctAmt = (String) actionAPI.getSessionData("m_strGiftFluctAmt"); //��_���ϴ��
		String m_strGiftCurrentAmt = (String) actionAPI.getSessionData("m_strGiftCurrentAmt"); //��_���簡
		String m_strGiftOfferAmt = (String) actionAPI.getSessionData("m_strGiftOfferAmt"); //��_�ŵ�ȣ��
		String m_strGiftBidAmt = (String) actionAPI.getSessionData("m_strGiftBidAmt"); //��_�ż�ȣ��
		String m_strGiftVol = (String) actionAPI.getSessionData("m_strGiftVol"); //��_�ŷ���
		m_strGiftVol = trimNum(m_strGiftVol);
		String m_strGiftOpenAmt = (String) actionAPI.getSessionData("m_strGiftOpenAmt"); //��_�ð�
		String m_strGiftHighAmt = (String) actionAPI.getSessionData("m_strGiftHighAmt"); //��_��
		String m_strGiftLowAmt = (String) actionAPI.getSessionData("m_strGiftLowAmt"); //��_����
		String m_strGiftDiffOfferAmt4 = (String) actionAPI.getSessionData("m_strGiftDiffOfferAmt4"); //�켱�ŵ�ȣ���ܷ�
		String m_strGiftOfferVol4 = (String) actionAPI.getSessionData("m_strGiftOfferVol4"); //�켱�ŵ����
		m_strGiftOfferVol4 = trimNum(m_strGiftOfferVol4);
		String m_strGiftDiffBidAmt0 = (String) actionAPI.getSessionData("m_strGiftDiffBidAmt0"); //�켱�ż�ȣ���ܷ�
		String m_strGiftBidVol0 = (String) actionAPI.getSessionData("m_strGiftBidVol0"); //�켱�ż����
		m_strGiftBidVol0 = trimNum(m_strGiftBidVol0);
		String m_strGiftDiffOfferAmt3 = (String) actionAPI.getSessionData("m_strGiftDiffOfferAmt3"); //�����ŵ�ȣ���ܷ�
		String m_strGiftOfferVol3 = (String) actionAPI.getSessionData("m_strGiftOfferVol3"); //�����ŵ����
		m_strGiftOfferVol3 = trimNum(m_strGiftOfferVol3);
		String m_strGiftDiffBidAmt1 = (String) actionAPI.getSessionData("m_strGiftDiffBidAmt1"); //�����ż�ȣ���ܷ�
		String m_strGiftBidVol1 = (String) actionAPI.getSessionData("m_strGiftBidVol1"); //�����ż����
		m_strGiftBidVol1 = trimNum(m_strGiftBidVol1);
		String m_strGiftOfferVol5 = (String) actionAPI.getSessionData("m_strGiftOfferVol5"); //�Ѹŵ�ȣ���ܷ�
		m_strGiftOfferVol5 = trimNum(m_strGiftOfferVol5);
		String m_strGiftBidVol5 = (String) actionAPI.getSessionData("m_strGiftBidVol5"); //�Ѹż�ȣ���ܷ�
		m_strGiftBidVol5 = trimNum(m_strGiftBidVol5);
		String m_strGiftOfferCnt5 = (String) actionAPI.getSessionData("m_strGiftOfferCnt5"); //�Ѹŵ��Ǽ�
		m_strGiftOfferCnt5 = trimNum(m_strGiftOfferCnt5);
		String m_strGiftBidCnt5 = (String) actionAPI.getSessionData("m_strGiftBidCnt5"); //�Ѹż��Ǽ�
		m_strGiftBidCnt5 = trimNum(m_strGiftBidCnt5);
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(", ��������, �ڽ��� 200 , ");
		
		//####��
		if(m_strGiftYear.equals("0") || m_strGiftYear.equals("") || m_strGiftYear.equals(null)){
			sb.append("�⵵, ����,");
		}else{
			sb.append(m_strGiftYear).append(", ��, ");
		}
		
		//###��
		if(m_strGiftItemCode.equals("0") || m_strGiftItemCode.equals("") || m_strGiftItemCode.equals(null)){
			sb.append("��, ����,");
		}else{
			String month = m_strGiftItemCode.substring(1, 3);
			month = trimNum(month);
			sb.append(month).append(", �� , ��, ");
		}
		
		//��簡��
		if(m_strGiftStrikePrice.equals("0") || m_strGiftStrikePrice.equals("") || m_strGiftStrikePrice.equals(null)){
			sb.append("��簡��, ����,");
		}else{
			// �Ҽ��� �ڸ����� �����´�. 
			int strDotIndex = m_strGiftStrikePrice.indexOf(".");
			// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
			String strDotLeft = m_strGiftStrikePrice.substring(0, strDotIndex);
			// �տ� 0�� ������ ���ش�.
			strDotLeft = trimNum(strDotLeft);
			// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
			String strDotRight = m_strGiftStrikePrice.substring(strDotIndex+1);
			
			sb.append(", ��簡��, ")
			.append(strDotLeft).append(", , ").append(" , �� , [")
			.append(strDotRight).append("], , ");
		}
		
		//�ݿɼ�
		sb.append(", �ݿɼ� , ").append(" , ���ϴ�� , ");
		

		//���ϴ��
		if(m_strGiftFluctFlag.equals("0") || m_strGiftFluctFlag.equals("1") || m_strGiftFluctFlag.equals("5")){
			if(m_strGiftFluctAmt.equals("0000.00") || m_strGiftFluctAmt.equals("0") || m_strGiftFluctAmt.equals("") || m_strGiftFluctAmt.equals(null)){
				sb.append("");
			}else{
				// [���� ��� ���] 
				// �Ҽ��� �ڸ����� �����´�. 
				int strFluctDotIndex = m_strGiftFluctAmt.indexOf(".");
				// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
				String strFluctDotLeft = m_strGiftFluctAmt.substring(0, strFluctDotIndex);
				// �տ� 0�� ������ ���ش�.
				strFluctDotLeft = trimNum(strFluctDotLeft);
				// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
				String strFluctDotRight = m_strGiftFluctAmt.substring(strFluctDotIndex+1);
				sb.append(strFluctDotLeft).append(", , ")
				.append(", �� , [")
				.append(strFluctDotRight).append("], , ")
				.append(", ����Ʈ, ");
			}
			
			if(m_strGiftFluctFlag.equals("0")){
				sb.append(", ������, ");
			}else if(m_strGiftFluctFlag.equals("1")){
				sb.append(", ����, ");
			}else{
				sb.append(", ����, ");
			}
		}else{
			if(m_strGiftFluctFlag.equals("2")){
				sb.append(", ���Ѱ��� , ");
			}else if(m_strGiftFluctFlag.equals("3")){
				sb.append(", �⼼������� , ");
			}else if(m_strGiftFluctFlag.equals("4")){
				sb.append(", �⼼�������� , ");
			}else if(m_strGiftFluctFlag.equals("6")){
				sb.append(", ���Ѱ��� , ");
			}else if(m_strGiftFluctFlag.equals("7")){
				sb.append(", �⼼�϶����� , ");
			}else if(m_strGiftFluctFlag.equals("8")){
				sb.append(", �⼼�������� , ");
			}else{
				sb.append(", ������, ");
			}
		}

		//���簡
		if(m_strGiftCurrentAmt.equals("0000.00") || m_strGiftCurrentAmt.equals("0") || m_strGiftCurrentAmt.equals("") || m_strGiftCurrentAmt.equals(null)){
			sb.append(", ���簡 ����,");
		}else{
			// [���簡 ���]
			// �Ҽ��� �ڸ����� �����´�. 
			int strCurrentDotIndex = m_strGiftCurrentAmt.indexOf(".");
			// "." �� �������� ���� ���ڿ��� �����Ѵ�.  (�ڿ���)
			String strCurrentDotLeft = m_strGiftCurrentAmt.substring(0, strCurrentDotIndex);
			// �տ� 0�� ������ ���ش�.
			strCurrentDotLeft = trimNum(strCurrentDotLeft);
			// "." �� �������� ������ ���ڿ��� �����Ѵ�. (�Ҽ���)
			String strCurrentDotRight = m_strGiftCurrentAmt.substring(strCurrentDotIndex+1);
			
			sb.append(strCurrentDotLeft).append(", , ")
			.append(", �� , [")
			.append(strCurrentDotRight).append("], , ")
			.append(", ����Ʈ �̸� , ");
		}
		
		//�ŵ�ȣ�� m_strGiftOfferAmt
		if(m_strGiftOfferAmt.equals("0000.00") || m_strGiftOfferAmt.equals("0") || m_strGiftOfferAmt.equals("") || m_strGiftOfferAmt.equals(null)){
			sb.append(", �ŵ�ȣ��, ")
			.append(", ����, ");
		}else{
			int strGiftOfferDotIndex = m_strGiftOfferAmt.indexOf(".");
			String strGiftOfferDotLeft = m_strGiftOfferAmt.substring(0, strGiftOfferDotIndex);
			strGiftOfferDotLeft = trimNum(strGiftOfferDotLeft);
			String strGiftOfferDotRight = m_strGiftOfferAmt.substring(strGiftOfferDotIndex+1);
			strGiftOfferDotRight = trimNum(strGiftOfferDotRight);
			sb.append(", �ŵ�ȣ��, ")
			.append(strGiftOfferDotLeft).append(", , ")
			.append(", ��, [")
			.append(strGiftOfferDotRight).append("], , ")
			.append(", ����Ʈ, ");
		}
		
		//�ż�ȣ�� m_strGiftBidAmt
		if(m_strGiftBidAmt.equals("0000.00") || m_strGiftBidAmt.equals("0") || m_strGiftBidAmt.equals("") || m_strGiftBidAmt.equals(null)){
			sb.append(", �ż�ȣ��, ")
			.append(", ����, ");
		}else{
			int strGiftBidDotIndex = m_strGiftBidAmt.indexOf(".");
			String strGiftBidDotLeft = m_strGiftBidAmt.substring(0, strGiftBidDotIndex);
			strGiftBidDotLeft = trimNum(strGiftBidDotLeft);
			String strGiftBidDotRight = m_strGiftBidAmt.substring(strGiftBidDotIndex+1);
			strGiftBidDotRight = trimNum(strGiftBidDotRight);
			sb.append(", �ż�ȣ��, ")
			.append(strGiftBidDotLeft).append(", , ")
			.append(", ��, [")
			.append(strGiftBidDotRight).append("], , ")
			.append(", ����Ʈ, ");
		}
		
		//�ŷ��� m_strGiftVol
		if(m_strGiftVol.equals("0") || m_strGiftVol.equals("") || m_strGiftVol.equals(null)){
			sb.append("�ŷ�����, �����ϴ�.");
		}else{
			sb.append(", �ŷ�����,  ")
			.append(m_strGiftVol).append(", , ")
			.append(", ���, ")
			.append(", �Դϴ�.");
		}
		
		//�ð� m_strGiftOpenAmt
		if(m_strGiftOpenAmt.equals("0000.00") || m_strGiftOpenAmt.equals("0") || m_strGiftOpenAmt.equals("") || m_strGiftOpenAmt.equals(null)){
			sb.append(", �ñ�, ")
			.append(", ����, ");
		}else{
			int strGiftOpenDotIndex = m_strGiftOpenAmt.indexOf(".");
			String strGiftOpenDotLeft = m_strGiftOpenAmt.substring(0, strGiftOpenDotIndex);
			strGiftOpenDotLeft = trimNum(strGiftOpenDotLeft);
			String strGiftOpenDotRight = m_strGiftOpenAmt.substring(strGiftOpenDotIndex+1);
			strGiftOpenDotRight = trimNum(strGiftOpenDotRight);
			sb.append(", �ñ�, ")
			.append(strGiftOpenDotLeft).append(", , ")
			.append(", ��, [")
			.append(strGiftOpenDotRight).append("], , ")
			.append(", ����Ʈ, ");
		}
		
		//��  m_strGiftHighAmt
		if(m_strGiftHighAmt.equals("0000.00") || m_strGiftHighAmt.equals("0") || m_strGiftHighAmt.equals("") || m_strGiftHighAmt.equals(null)){
			sb.append(", ���, ")
			.append(", ����, ");
		}else{
			int strGiftHighDotIndex = m_strGiftHighAmt.indexOf(".");
			String strGiftHighDotLeft = m_strGiftHighAmt.substring(0, strGiftHighDotIndex);
			strGiftHighDotLeft = trimNum(strGiftHighDotLeft);
			String strGiftHighDotRight = m_strGiftHighAmt.substring(strGiftHighDotIndex+1);
			strGiftHighDotRight = trimNum(strGiftHighDotRight);
			sb.append(", ���, ")
			.append(strGiftHighDotLeft)
			.append(", ��, [")
			.append(strGiftHighDotRight)
			.append("], ����Ʈ, ");
		}

		//���� m_strGiftLowAmt
		if(m_strGiftLowAmt.equals("0000.00") || m_strGiftLowAmt.equals("0") || m_strGiftLowAmt.equals("") || m_strGiftLowAmt.equals(null)){
			sb.append(", ����, ")
			.append("�����ϴ�.");
		}else{
			int strGiftLowDotIndex = m_strGiftLowAmt.indexOf(".");
			String strGiftLowDotLeft = m_strGiftLowAmt.substring(0, strGiftLowDotIndex);
			strGiftLowDotLeft = trimNum(strGiftLowDotLeft);
			String strGiftLowDotRight = m_strGiftLowAmt.substring(strGiftLowDotIndex+1);
			strGiftLowDotRight = trimNum(strGiftLowDotRight);
			sb.append(", ����, ")
			.append(strGiftLowDotLeft)
			.append(", ��, [")
			.append(strGiftLowDotRight)
			.append("], ����Ʈ, ")
			.append(", �Դϴ�.");
		}
		
		//�켱�ŵ�ȣ���ܷ�	m_strGiftDiffOfferAmt4
		if(m_strGiftDiffOfferAmt4.equals("0000.00") || m_strGiftDiffOfferAmt4.equals("0") || m_strGiftDiffOfferAmt4.equals("") || m_strGiftDiffOfferAmt4.equals(null)){
			sb.append(", �켱, ")
			.append(", �ŵ�ȣ�� �ܷ���, ")
			.append(", ����, ");
		}else{
			int strGiftDiffOfferAmt4DotIndex = m_strGiftDiffOfferAmt4.indexOf(".");
			String strGiftDiffOfferAmt4DotLeft = m_strGiftDiffOfferAmt4.substring(0, strGiftDiffOfferAmt4DotIndex);
			strGiftDiffOfferAmt4DotLeft = trimNum(strGiftDiffOfferAmt4DotLeft);
			String strGiftDiffOfferAmt4DotRight = m_strGiftDiffOfferAmt4.substring(strGiftDiffOfferAmt4DotIndex+1);
			strGiftDiffOfferAmt4DotRight = trimNum(strGiftDiffOfferAmt4DotRight);
			sb.append(", �켱, ")
			.append(", �ŵ�ȣ�� �ܷ���, ")
			.append(strGiftDiffOfferAmt4DotLeft)
			.append(", ��, [")
			.append(strGiftDiffOfferAmt4DotRight)
			.append("], ����Ʈ��, ");
		}
		
		//�켱�ŵ����	m_strGiftOfferVol4
		if(m_strGiftOfferVol4.equals("0") || m_strGiftOfferVol4.equals("") || m_strGiftOfferVol4.equals(null)){
			sb.append(", �켱, ")
			.append(", �ŵ�ȣ�� ���, ")
			.append(", ����, ");
		}else{
			sb.append(m_strGiftOfferVol4)
			.append(", ���, ");
		}
		
		//�켱�ż�ȣ���ܷ�	m_strGiftDiffBidAmt0
		if(m_strGiftDiffBidAmt0.equals("0000.00") || m_strGiftDiffBidAmt0.equals("0") || m_strGiftDiffBidAmt0.equals("") || m_strGiftDiffBidAmt0.equals(null)){
			sb.append(", �켱, ")
			.append(", �ż�ȣ�� �ܷ���, ")
			.append(", ����, ");
		}else{
			int strGiftDiffBidAmt0DotIndex = m_strGiftDiffBidAmt0.indexOf(".");
			String strGiftDiffBidAmt0DotLeft = m_strGiftDiffBidAmt0.substring(0, strGiftDiffBidAmt0DotIndex);
			strGiftDiffBidAmt0DotLeft = trimNum(strGiftDiffBidAmt0DotLeft);
			String strGiftDiffBidAmt0DotRight = m_strGiftDiffBidAmt0.substring(strGiftDiffBidAmt0DotIndex+1);
			strGiftDiffBidAmt0DotRight = trimNum(strGiftDiffBidAmt0DotRight);
			sb.append(", �켱, ")
			.append(", �ż�ȣ�� �ܷ���, ")
			.append(strGiftDiffBidAmt0DotLeft)
			.append(", ��, [")
			.append(strGiftDiffBidAmt0DotRight)
			.append("], ����Ʈ��, ");
		}
		
		//�켱�ż����	m_strGiftBidVol0
		if(m_strGiftBidVol0.equals("0") || m_strGiftBidVol0.equals("") || m_strGiftBidVol0.equals(null)){
			sb.append(", �켱, ")
			.append(", �ż�ȣ�� ���, ")
			.append(", ����, ");
		}else{
			sb.append(m_strGiftBidVol0)
			.append(", ���, ");
		}
		
		//�����ŵ�ȣ���ܷ�	m_strGiftDiffOfferAmt3
		if(m_strGiftDiffOfferAmt3.equals("0000.00") || m_strGiftDiffOfferAmt3.equals("0") || m_strGiftDiffOfferAmt3.equals("") || m_strGiftDiffOfferAmt3.equals(null)){
			sb.append(", ����, ")
			.append(", �ŵ�ȣ�� �ܷ���, ")
			.append(", ����, ");
		}else{
			int strGiftDiffOfferAmt3DotIndex = m_strGiftDiffOfferAmt3.indexOf(".");
			String strGiftDiffOfferAmt3DotLeft = m_strGiftDiffOfferAmt3.substring(0, strGiftDiffOfferAmt3DotIndex);
			strGiftDiffOfferAmt3DotLeft = trimNum(strGiftDiffOfferAmt3DotLeft);
			String strGiftDiffOfferAmt3DotRight = m_strGiftDiffOfferAmt3.substring(strGiftDiffOfferAmt3DotIndex+1);
			strGiftDiffOfferAmt3DotRight = trimNum(strGiftDiffOfferAmt3DotRight);
			sb.append(", ����, ")
			.append(", �ŵ�ȣ�� �ܷ���, ")
			.append(strGiftDiffOfferAmt3DotLeft)
			.append(", ��, [")
			.append(strGiftDiffOfferAmt3DotRight)
			.append("], ����Ʈ��, ");
		}
		
		//�����ŵ����	m_strGiftOfferVol3
		if(m_strGiftOfferVol3.equals("0") || m_strGiftOfferVol3.equals("") || m_strGiftOfferVol3.equals(null)){
			sb.append(", ����, ")
			.append(", �ŵ�ȣ�� ���, ")
			.append(", ����, ");
		}else{
			sb.append(m_strGiftOfferVol3)
			.append(", ���, ");
		}
		
		//�����ż�ȣ���ܷ�	m_strGiftDiffBidAmt1
		if(m_strGiftDiffBidAmt1.equals("0000.00") || m_strGiftDiffBidAmt1.equals("0") || m_strGiftDiffBidAmt1.equals("") || m_strGiftDiffBidAmt1.equals(null)){
			sb.append(", ����, ")
			.append(", �ż�ȣ�� �ܷ���, ")
			.append(", ����, ");
		}else{
			int strGiftDiffBidAmt1DotIndex = m_strGiftDiffBidAmt1.indexOf(".");
			String strGiftDiffBidAmt1DotLeft = m_strGiftDiffBidAmt1.substring(1, strGiftDiffBidAmt1DotIndex);
			strGiftDiffBidAmt1DotLeft = trimNum(strGiftDiffBidAmt1DotLeft);
			String strGiftDiffBidAmt1DotRight = m_strGiftDiffBidAmt1.substring(strGiftDiffBidAmt1DotIndex+1);
			strGiftDiffBidAmt1DotRight = trimNum(strGiftDiffBidAmt1DotRight);
			sb.append(", ����, ")
			.append(", �ż�ȣ�� �ܷ���, ")
			.append(strGiftDiffBidAmt1DotLeft)
			.append(", ��, [")
			.append(strGiftDiffBidAmt1DotRight)
			.append("], ����Ʈ��, ");
		}
		
		//�����ż����	m_strGiftBidVol1
		if(m_strGiftBidVol1.equals("0") || m_strGiftBidVol1.equals("") || m_strGiftBidVol1.equals(null)){
			sb.append(", ����, ")
			.append(", �ż�ȣ�� ���, ")
			.append(", ����, ");
		}else{
			sb.append(m_strGiftBidVol1)
			.append(", ���, ");
		}
		
		//�Ѹŵ�ȣ���ܷ�	m_strGiftOfferVol5
		if(m_strGiftOfferVol5.equals("0") || m_strGiftOfferVol5.equals("") || m_strGiftOfferVol5.equals(null)){
			sb.append(", �� �ŵ� ȣ���ܷ�, ")
			.append(", ����, ");
		}else{
			sb.append(",, �� �ŵ� ȣ���ܷ�, ")
			.append(m_strGiftOfferVol5)
			.append(", ���, ");
		}
		
		//�Ѹż�ȣ���ܷ�	m_strGiftBidVol5
		if(m_strGiftBidVol5.equals("0") || m_strGiftBidVol5.equals("") || m_strGiftBidVol5.equals(null)){
			sb.append(", �� �ż� ȣ���ܷ�, ")
			.append(", ����, ");
		}else{
			sb.append(",, �� �ż� ȣ���ܷ�, ")
			.append(m_strGiftBidVol5)
			.append(", ���, ");
		}
		
		//�Ѹŵ��Ǽ�	m_strGiftOfferCnt5
		if(m_strGiftOfferCnt5.equals("0") || m_strGiftOfferCnt5.equals("") || m_strGiftOfferCnt5.equals(null)){
			sb.append(", �� �ŵ� ����, ")
			.append(", ����, ");
		}else{
			sb.append(", �� �ŵ� ����, ")
			.append(m_strGiftOfferCnt5)
			.append(", �� , ");
		}
		
		//�Ѹż��Ǽ�	m_strGiftBidCnt5
		if(m_strGiftBidCnt5.equals("0") || m_strGiftBidCnt5.equals("") || m_strGiftBidCnt5.equals(null)){
			sb.append(", �� �ż� ����, ")
			.append(", �����ϴ�. , ");
		}else{
			sb.append(", �� �ż� ����, ")
			.append(m_strGiftBidCnt5)
			.append(", ��, ����, ");
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
