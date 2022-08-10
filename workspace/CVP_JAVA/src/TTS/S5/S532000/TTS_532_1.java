package TTS.S5.S532000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TTS_532_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		/*m_strTransFtrnDate / FtrnDate / ��ü����     
		m_strTransIamtBnkCd / IamtBnkCd / �Ա������ڵ� : "000"=�������(��ü�ΰ��)
		m_strTransFtrnAmt / FtrnAmt / ��ü�ݾ�     
		m_strTransProcRslt / ProcRslt / ó����� : 1="ó����" 2="ó���Ϸ�" 3="�������" �׿�="������"
		m_strTransJobMediaSect / JobMediaSect / "������ü���� (0=â��, 1=PC, 2=ARS, 3=���ͳ�, 4=������(����CD��), 5=��������ī��, 6=�����(��û��ü), 7=�ݼ���(�ڵ���ü), 8=������ü, 9=���ϸ���, A=���̹���, D=��������, I=Ȩ������, W=WRAP)
		m_strTransObjAcntNm / ObjAcntNm / �����¸�  
		m_strTransTrSect / TrSect / �ŷ����� : �Ա�="01" ���="02" ??="03"
		m_strBankName / ����� (DB���� ��ȸ)*/
		
		String m_strTransIamtBnkCd = (String) actionAPI.getSessionData("m_strTransIamtBnkCd"); //�Ա������ڵ� : "000"=�������(��ü�ΰ��)
		String m_strBankName = (String) actionAPI.getSessionData("m_strBankName"); //�����
		String m_strTransFtrnDate = (String) actionAPI.getSessionData("m_strTransFtrnDate"); //��ü����
		String m_strTransFtrnAmt = (String) actionAPI.getSessionData("m_strTransFtrnAmt"); //��ü�ݾ�
		m_strTransFtrnAmt = trimNum(m_strTransFtrnAmt);
		String m_strTransProcRslt = (String) actionAPI.getSessionData("m_strTransProcRslt"); // ó����� : 1="ó����" 2="ó���Ϸ�" 3="�������" �׿�="������"
		String m_strTransJobMediaSect = (String) actionAPI.getSessionData("m_strTransJobMediaSect"); //"������ü���� (0=â��, 1=PC, 2=ARS, 3=���ͳ�, 4=������(����CD��), 5=��������ī��, 6=�����(��û��ü), 7=�ݼ���(�ڵ���ü), 8=������ü, 9=���ϸ���, A=���̹���, D=��������, I=Ȩ������, W=WRAP)
		String m_strTransObjAcntNm = (String) actionAPI.getSessionData("m_strTransObjAcntNm"); //�����¸�
		String m_strTransTrSect = (String) actionAPI.getSessionData("m_strTransTrSect"); //�ŷ����� : �Ա�="01" ���="02" ??="03"
		
		//[���ó�¥���]
		String formStr = "yyyyMMdd";
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat(formStr);
		String nowDate = format.format(date);
		
		//[��ü��¥���]
		String year = m_strTransFtrnDate.substring(0, 4);
		String month = m_strTransFtrnDate.substring(4, 6);
		String day = m_strTransFtrnDate.substring(6);
		month = trimNum(month);
		day = trimNum(day);
		
		StringBuffer sb = new StringBuffer();
		
		if(nowDate.equals(m_strTransFtrnDate)){
			sb.append(year)
			.append(", ��, ")
			.append(month)
			.append(", ��, ")
			.append(day)
			.append(", ��, ")
			.append("����� ������,");
		}else{
			sb.append(year)
			.append(", ��, ")
			.append(month)
			.append(", ��, ")
			.append(day)
			.append(", ��, ")
			.append("����� ������,");
		}
		
		if(m_strTransIamtBnkCd.equals(null) || m_strTransIamtBnkCd.isEmpty()){
			sb.append("");
		}else{
			if(m_strTransTrSect.equals("01")){//�Ա�
				sb.append(m_strBankName).append(",");
			}else{
				sb.append(m_strBankName).append(",");
			}
		}
		
		if(m_strTransObjAcntNm.equals(null) || m_strTransObjAcntNm.isEmpty()){
			sb.append("");
		}else{
			/*sb.append(m_strTransObjAcntNm)
			.append(", ���� ���·�, ");*/
			if(m_strTransTrSect.equals("01")){//�Ա�
				sb.append(m_strTransObjAcntNm)
				.append(", ���� ���� ����, ");
			}else{
				sb.append(m_strTransObjAcntNm)
				.append(", ���� ���·�, ");
			}
		}
		
		if(m_strTransFtrnAmt.equals(null) || m_strTransFtrnAmt.isEmpty()){
			sb.append("");
		}else{
			sb.append(m_strTransFtrnAmt)
			.append(", ����, ");
		}
		
		//"������ü���� (0=â��, 1=PC, 2=ARS, 3=���ͳ�, 4=������(����CD��), 5=��������ī��, 6=�����(��û��ü), 7=�ݼ���(�ڵ���ü), 8=������ü, 9=���ϸ���, A=���̹���, D=��������, I=Ȩ������, W=WRAP)
		if(m_strTransJobMediaSect.equals("0")){ //â��
			sb.append(", â������, ");
		}else if(m_strTransJobMediaSect.equals("1")){ //PC
			sb.append(", �Ǿ� ����, ");
		}else if(m_strTransJobMediaSect.equals("2")){ //ARS
			sb.append(", ���̾˿��� ����, ");
		}else if(m_strTransJobMediaSect.equals("3")){ //���ͳ�
			sb.append(", ���ͳ� ����, ");
		}else if(m_strTransJobMediaSect.equals("4")){ //������(����CD��)
			sb.append(", ���� ����� ����  , ");
		}else if(m_strTransJobMediaSect.equals("5")){ //��������ī��
			sb.append(", ���� ����ī�� ���� , ");
		}else if(m_strTransJobMediaSect.equals("6")){ //�����(��û��ü)
			sb.append(", ����� ����, ");
		}else if(m_strTransJobMediaSect.equals("7")){ //�ݼ���(�ڵ���ü)
			sb.append(", �ݼ��� ����, ");
		}else if(m_strTransJobMediaSect.equals("8")){ //������ü
			sb.append(", ���� ��ü��, ");
		}else if(m_strTransJobMediaSect.equals("9")){ //���ϸ���
			sb.append(", ���� ��������, ");
		}else if(m_strTransJobMediaSect.equals("A")){ //���̹���
			sb.append(", ���̹��� ����, ");
		}else if(m_strTransJobMediaSect.equals("D")){ //��������
			sb.append(", �������� ����, ");
		}else if(m_strTransJobMediaSect.equals("I")){ //Ȩ������
			sb.append(", Ȩ������ ����, ");
		}else if(m_strTransJobMediaSect.equals("W")){ //WRAP
			sb.append(", WRAP ����, ");
		}
		
		if(m_strTransIamtBnkCd.equals("000")){//��ü
			if(m_strTransTrSect.equals("01")){//�Ա�
				sb.append(", ��ü �Ա�, ");
			}else if(m_strTransTrSect.equals("02")){//���
				sb.append(", ��ü ��� , ");
			}else{
				sb.append("");
			}
		}else{
			if(m_strTransTrSect.equals("01")){//�Ա�
				sb.append(", ��ü �Ա�, ");
			}else if(m_strTransTrSect.equals("02")){//���
				sb.append(", ��ü ��� , ");
			}else{
				sb.append("");
			}
		}
		
		if(m_strTransProcRslt.equals("1")){ //ó����
			sb.append(", ó�� ��, �Դϴ�.");
		}else if(m_strTransProcRslt.equals("2")){ //ó���Ϸ�
			sb.append(", ó��, �Ǿ����ϴ�.");
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
