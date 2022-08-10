package TTS.S3.S334000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_334_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI)throws AudiumException {
		/*m_strCreditItemCode : ���������ڵ� 
		m_strCreditItemFullCode : �����ȣ 
		m_strItemName : �����
		m_strCreditCrdtSect : �ſ뱸�� (ex : ����, ����, ����, �ϴ�, �ڴ�, ����, ����, �ŵ�, ���, �ܱ�, ����)
		m_strCreditHoldQty : �������� (ex : 00000036500)    	
		m_strCreditEnblQty : ���ɼ��� (ex : 00000036500)
		m_strCreditLoanDate : ��������  (ex : 20161114)   	
		m_strCreditUprc : �ܰ� (ex : 00000012000)
		m_strCreditExprDate : �������� (ex : 20170512) */
		
		String m_strItemName = (String) actionAPI.getSessionData("m_strItemName");	//�����
		String m_strCreditEnblQty = (String) actionAPI.getSessionData("m_strCreditEnblQty");	//���ɼ���
		m_strCreditEnblQty = trimNum(m_strCreditEnblQty);
		String m_strCreditCrdtSect = (String) actionAPI.getSessionData("m_strCreditCrdtSect");	//�ſ뱸��
		String m_strCreditUprc = (String) actionAPI.getSessionData("m_strCreditUprc");	//�ܰ�
		m_strCreditUprc = trimNum(m_strCreditUprc);
		String m_strCreditLoanDate = (String) actionAPI.getSessionData("m_strCreditLoanDate");	//��������
		String m_strLoanYear = m_strCreditLoanDate.substring(0, 4);
		String m_strLoanMonth = m_strCreditLoanDate.substring(4, 6);
		String m_strLoanDay = m_strCreditLoanDate.substring(6);
		m_strLoanMonth = trimNum(m_strLoanMonth);
		m_strLoanDay = trimNum(m_strLoanDay);
		String m_strCreditExprDate = (String) actionAPI.getSessionData("m_strCreditExprDate");	//��������
		String m_strExprYear = m_strCreditExprDate.substring(0, 4);
		String m_strExprMonth = m_strCreditExprDate.substring(4, 6);
		String m_strExprDay = m_strCreditExprDate.substring(6);
		m_strExprMonth = trimNum(m_strExprMonth);
		m_strExprDay = trimNum(m_strExprDay);
		
		StringBuffer sb = new StringBuffer();
		
		//�����
		if(m_strItemName.equals("0") || m_strItemName.equals("") || m_strItemName.equals(null)){
			sb.append("�����, ����,");
		}else{
			sb.append(m_strItemName).append(", ");
		}
		
		//���ɼ���
		if(m_strCreditEnblQty.equals("0") || m_strCreditEnblQty.equals("") || m_strCreditEnblQty.equals(null)){
			sb.append(", ���ɼ���, ����,");
		}else{
			sb.append(m_strCreditEnblQty)
			.append(", ��, ");
		}
		
		//�ſ뱸�� (����, ����, ����, �ϴ�, �ڴ�, ����, ����, �ŵ�, ���, �ܱ�, ����)
		if(m_strCreditCrdtSect.equals("0") || m_strCreditCrdtSect.equals("") || m_strCreditCrdtSect.equals(null)){
			sb.append(", �ſ뱸��, ����, ");
		}else if(m_strCreditCrdtSect.equals("����")){
			sb.append(", ����, ");
		}else if(m_strCreditCrdtSect.equals("����")){
			sb.append(", �ڱ�����, ");
		}else if(m_strCreditCrdtSect.equals("����")){
			sb.append(", ����, ");
		}else if(m_strCreditCrdtSect.equals("�ϴ�")){
			sb.append(", �㺸����, ");
		}else if(m_strCreditCrdtSect.equals("�ڴ�")){
			sb.append(", �ڴ�, ");
		}else if(m_strCreditCrdtSect.equals("����")){
			sb.append(", ����, ");
		}else if(m_strCreditCrdtSect.equals("�ŵ�")){
			sb.append(", �ŵ�, ");
		}else if(m_strCreditCrdtSect.equals("���")){
			sb.append(", ���, ");
		}else if(m_strCreditCrdtSect.equals("�ܱ�")){
			sb.append(", �ܱ�, ");
		}else if(m_strCreditCrdtSect.equals("����")){
			sb.append(", ����, ");
		}else{
			sb.append(", �ſ뱸��, ����, ");
		}
		
		//���ڴܰ�
		if(m_strCreditUprc.equals("0") || m_strCreditUprc.equals("") || m_strCreditUprc.equals(null)){
			sb.append(", ���ڴܰ�, ����,");
		}else{
			sb.append(", ���ڴܰ�, ")
			.append(m_strCreditUprc)
			.append(", ��, ");
		}
		
		//��������
		if(m_strCreditLoanDate.equals("0") || m_strCreditLoanDate.equals("") || m_strCreditLoanDate.equals(null)){
			sb.append(", ��������, ����,");
		}else{
			sb.append(", ��������, ")
			.append(m_strLoanYear).append(", ��, ").append(m_strLoanMonth).append(", ��, ").append(m_strLoanDay).append(", ��, ");
		}
		
		//��������
		if(m_strCreditExprDate.equals("0") || m_strCreditExprDate.equals("") || m_strCreditExprDate.equals(null)){
			sb.append(", ��������, �����ϴ�.");
		}else{
			sb.append(", ��������, ")
			.append(m_strExprYear).append(", ��, ").append(m_strExprMonth).append(", ��, ").append(m_strExprDay).append(", ��, ")
			.append(", �Դϴ�. ");
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
