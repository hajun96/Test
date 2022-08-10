package TTS.S4.S462000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_462_2 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException { 
		/*[W61OI32_OUTPUT_Grid]
		m_strCreditItemCode	ItemScd	���������ڵ� 
		m_strCreditItemFullCode	ItemNo	�����ȣ      
		m_strCreditItemName	ItemNm	�����       
		m_strCreditCrdSect	CrdtSect	"�ſ뱸��, ���� = ��������, ���� = �ڱ�����, ���� = �������, �ϴ� = �Ϲݴ㺸����, �ڴ� = �ڱ����        
		���� = �ſ����        
		���� = �����ڱݴ���    
		�ŵ� = �ŵ��ڱݴ㺸����
		��� = ���̼���      
		�ܱ� = �ܱ�����ڱݴ���
		���� = ����"
		m_strCreditHoldQty	HoldQty	��������     
		m_strCreditEnblQty	EnblQty	���ɼ���     
		m_strCreditLoanDate	LoanDate	��������     
		m_strCreditUprc	Uprc	�ܰ�         
		m_strCreditExprDate	ExprDate	��������*/
		//String m_strCreditItemCode = (String) actionAPI.getSessionData("m_strCreditItemCode"); //���������ڵ�
		//String m_strCreditItemFullCode = (String) actionAPI.getSessionData("m_strCreditItemFullCode"); //�����ȣ
		String m_strCreditItemName = (String) actionAPI.getSessionData("m_strCreditItemName"); //�����
		String m_strCreditCrdSect = (String) actionAPI.getSessionData("m_strCreditCrdSect"); //�ſ���ⱸ��
		String m_strCreditHoldQty = (String) actionAPI.getSessionData("m_strCreditHoldQty"); //��������
		m_strCreditHoldQty = trimNum(m_strCreditHoldQty);
		//String m_strCreditEnblQty = (String) actionAPI.getSessionData("m_strCreditEnblQty"); //���ɼ���
		String m_strCreditLoanDate = (String) actionAPI.getSessionData("m_strCreditLoanDate"); //��������
		String year = m_strCreditLoanDate.substring(0, 4);
		String month = m_strCreditLoanDate.substring(4, 6);
		String day = m_strCreditLoanDate.substring(6);
		month = trimNum(month);
		day = trimNum(day);
		//String m_strCreditExprDate = (String) actionAPI.getSessionData("m_strCreditExprDate"); //��������
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(m_strCreditItemName);
		
		if(m_strCreditCrdSect.equals("����")){
			sb.append(m_strCreditHoldQty)
			.append(", ��, ")
			.append(", �ſ뱸����, ")
			.append(", ��������, ")
			.append(", ���� ���ڴ�, ")
			.append(year).append(", ��, ").append(month).append(", ��, ").append(day).append(", ��, ")
			.append(", �Դϴ�. ");
		}else if(m_strCreditCrdSect.equals("����")){
			sb.append(m_strCreditHoldQty)
			.append(", ��, ")
			.append(", �ſ뱸����, ")
			.append(", �ڱ�����, ")
			.append(", ���� ���ڴ�, ")
			.append(year).append(", ��, ").append(month).append(", ��, ").append(day).append(", ��, ")
			.append(", �Դϴ�. ");
		}else if(m_strCreditCrdSect.equals("����")){
			sb.append(m_strCreditHoldQty)
			.append(", ��, ")
			.append(", �ſ뱸����, ")
			.append(", �������, ")
			.append(", ���� ���ڴ�, ")
			.append(year).append(", ��, ").append(month).append(", ��, ").append(day).append(", ��, ")
			.append(", �Դϴ�. ");
		}else if(m_strCreditCrdSect.equals("�ϴ�")){
			sb.append(m_strCreditHoldQty)
			.append(", ��, ")
			.append(", �ſ뱸����, ")
			.append(", �Ϲݴ㺸����, ")
			.append(", ���� ���ڴ�, ")
			.append(year).append(", ��, ").append(month).append(", ��, ").append(day).append(", ��, ")
			.append(", �Դϴ�. ");
		}else if(m_strCreditCrdSect.equals("�ڴ�")){
			sb.append(m_strCreditHoldQty)
			.append(", ��, ")
			.append(", �ſ뱸����, ")
			.append(", �ڱ����, ")
			.append(", ���� ���ڴ�, ")
			.append(year).append(", ��, ").append(month).append(", ��, ").append(day).append(", ��, ")
			.append(", �Դϴ�. ");
		}else if(m_strCreditCrdSect.equals("����")){
			sb.append(m_strCreditHoldQty)
			.append(", ��, ")
			.append(", �ſ뱸����, ")
			.append(", �ſ����, ")
			.append(", ���� ���ڴ�, ")
			.append(year).append(", ��, ").append(month).append(", ��, ").append(day).append(", ��, ")
			.append(", �Դϴ�. ");
		}else if(m_strCreditCrdSect.equals("����")){
			sb.append(m_strCreditHoldQty)
			.append(", ��, ")
			.append(", �ſ뱸����, ")
			.append(", �����ڱݴ���, ")
			.append(", ���� ���ڴ�, ")
			.append(year).append(", ��, ").append(month).append(", ��, ").append(day).append(", ��, ")
			.append(", �Դϴ�. ");
		}else if(m_strCreditCrdSect.equals("�ŵ�")){
			sb.append(m_strCreditHoldQty)
			.append(", ��, ")
			.append(", �ſ뱸����, ")
			.append(", �ŵ��ڱݴ㺸����, ")
			.append(", ���� ���ڴ�, ")
			.append(year).append(", ��, ").append(month).append(", ��, ").append(day).append(", ��, ")
			.append(", �Դϴ�. ");
		}else if(m_strCreditCrdSect.equals("���")){
			sb.append(m_strCreditHoldQty)
			.append(", ��, ")
			.append(", �ſ뱸����, ")
			.append(", ���̼���, ")
			.append(", ���� ���ڴ�, ")
			.append(year).append(", ��, ").append(month).append(", ��, ").append(day).append(", ��, ")
			.append(", �Դϴ�. ");
		}else if(m_strCreditCrdSect.equals("�ܱ�")){
			sb.append(m_strCreditHoldQty)
			.append(", ��, ")
			.append(", �ſ뱸����, ")
			.append(", �ܱ�����ڱݴ���, ")
			.append(", ���� ���ڴ�, ")
			.append(year).append(", ��, ").append(month).append(", ��, ").append(day).append(", ��, ")
			.append(", �Դϴ�. ");
		}else{
			sb.append("");
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
