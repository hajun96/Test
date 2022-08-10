package TTS.S2.S270000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;
import java.math.*;

public class TTS_270_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strNowTime = (String) actionAPI.getSessionData("m_strNowTime"); // ����ð�
		String m_strFrgTrd = (String) actionAPI.getSessionData("m_strFrgTrd"); //�ŷ��� �ܱ��θŸ�
		String m_strAgcyTrd = (String) actionAPI.getSessionData("m_strAgcyTrd"); //�ŷ��� ����Ÿ�
		String m_strGenTrd = (String) actionAPI.getSessionData("m_strGenTrd"); //�ŷ��� �ϹݸŸ�
		String m_strFrgTrd1 = (String) actionAPI.getSessionData("m_strFrgTrd1"); //�ڽ��� �ܱ��θŸ�
		String m_strAgcyTrd1 = (String) actionAPI.getSessionData("m_strAgcyTrd1"); //�ڽ��� ����Ÿ�
		String m_strGenTrd1 = (String) actionAPI.getSessionData("m_strGenTrd1"); //�ڽ��� �ϹݸŸ�
		String m_strFrgTrd2 = (String) actionAPI.getSessionData("m_strFrgTrd2"); //�������� �ܱ��θŸ�
		String m_strAgcyTrd2 = (String) actionAPI.getSessionData("m_strAgcyTrd2"); //�������� ����Ÿ�
		String m_strGenTrd2 = (String) actionAPI.getSessionData("m_strGenTrd2"); //�������� �ϹݸŸ�
		String m_strFrgTrd3 = (String) actionAPI.getSessionData("m_strFrgTrd3"); //�ݿɼǵ��� �ܱ��θŸ�
		String m_strAgcyTrd3 = (String) actionAPI.getSessionData("m_strAgcyTrd3"); //�ݿɼǵ��� ����Ÿ�
		String m_strGenTrd3 = (String) actionAPI.getSessionData("m_strGenTrd3"); //�ݿɼǵ��� �ϹݸŸ�
		String m_strFrgTrd4 = (String) actionAPI.getSessionData("m_strFrgTrd4"); //ǲ�ɼǵ��� �ܱ��θŸ�
		String m_strAgcyTrd4 = (String) actionAPI.getSessionData("m_strAgcyTrd4"); //ǲ�ɼǵ��� ����Ÿ�
		String m_strGenTrd4 = (String) actionAPI.getSessionData("m_strGenTrd4"); //ǲ�ɼǵ��� �ϹݸŸ�	
		String m_strTotBidTot = (String) actionAPI.getSessionData("m_strTotBidTot");	
		String m_strTotBidTot1 = (String) actionAPI.getSessionData("m_strTotBidTot1");//���α׷� �ڽ��� 
		
		m_strTotBidTot = trimNum(m_strTotBidTot);
		Float f_m_strTotBidTot = Float.parseFloat(m_strTotBidTot);
		if(m_strTotBidTot.startsWith("-")){
			m_strTotBidTot = m_strTotBidTot.substring(1);
		    }else{
		    	m_strTotBidTot = m_strTotBidTot;
		    }
		 long l_m_strTotBidTot = Long.parseLong(m_strTotBidTot) * 1000000;

		 m_strTotBidTot = String.valueOf(l_m_strTotBidTot);




		String yyyy = m_strNowTime.substring(0, 4);	//��
		String MM = m_strNowTime.substring(4, 6);	//��
		MM = trimNum(MM);
		String dd = m_strNowTime.substring(6, 8);	//��
		dd = trimNum(dd);
		String HH = m_strNowTime.substring(8, 10);	//�ð�
		HH = trimNum(HH);
		String mm = m_strNowTime.substring(10, 12);	//��
		mm = trimNum(mm);
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(yyyy).append(", ��, ")
		.append(MM).append(", ��, ")
		.append(dd).append(", ��, ")
		.append(HH).append("��, ")
		.append(mm).append(", ��, ")
		.append(", ����, ");
		
		//[�ŷ��� ���� �ܱ��θŸ� ����] 
		m_strFrgTrd = trimNum(m_strFrgTrd);
		Float f_m_strFrgTrd = Float.parseFloat(m_strFrgTrd);
		if(m_strFrgTrd.startsWith("-")){
			m_strFrgTrd = m_strFrgTrd.substring(1);
		    }else{
		    	m_strFrgTrd = m_strFrgTrd;
		    }
		 long l_m_strFrgTrd = Long.parseLong(m_strFrgTrd) * 100000000;

		 m_strFrgTrd = String.valueOf(l_m_strFrgTrd);
		
		//[�ŷ��� ���� ����Ÿ� ����]
		 
		m_strAgcyTrd = trimNum(m_strAgcyTrd);
		Float f_m_strAgcyTrd = Float.parseFloat(m_strAgcyTrd);
		if(m_strAgcyTrd.startsWith("-")){
			m_strAgcyTrd = m_strAgcyTrd.substring(1);
		    }else{
		    	m_strAgcyTrd = m_strAgcyTrd;
		    }
		 long l_m_strAgcyTrd = Long.parseLong(m_strAgcyTrd) * 100000000;
		 m_strAgcyTrd = String.valueOf(l_m_strAgcyTrd);
	
			 
		//[�ŷ��� ���� �ϹݸŸ� ����]
		 m_strGenTrd = trimNum(m_strGenTrd);
		Float f_m_strGenTrd = Float.parseFloat(m_strGenTrd);
		if(m_strGenTrd.startsWith("-")){
			m_strGenTrd = m_strGenTrd.substring(1);
		    }else{
		    	m_strGenTrd = m_strGenTrd;
		    }
		 long l_m_strGenTrd = Long.parseLong(m_strGenTrd) * 100000000;
		 m_strGenTrd = String.valueOf(l_m_strGenTrd);

		
		if(f_m_strFrgTrd > 0){			
			sb.append("�ŷ��ҽ�����, ")
			.append(", �ܱ���, ")
			.append(", ���ż�, ")
			.append(m_strFrgTrd)
			.append(", ��, ");
		}else if(f_m_strFrgTrd < 0){
			sb.append("�ŷ��ҽ�����, ")
			.append(", �ܱ���, ")
			.append(", ���ŵ�, ")
			.append(m_strFrgTrd)
			.append(", ��, ");
		}else{
			sb.append("�ŷ��ҽ�����, ")
			.append(", �ܱ���, ")
			.append(m_strFrgTrd)
			.append(", ��, ");
		}
				
		if(f_m_strAgcyTrd > 0){
			sb.append("���, ")
			.append(", ���ż�, ")
			.append(m_strAgcyTrd)
			.append(", ��, ");
		}else if(f_m_strAgcyTrd < 0){
			sb.append("���, ")
			.append(", ���ŵ�, ")
			.append(m_strAgcyTrd)
			.append(", ��, ");
		}else{
			sb.append("���, ")
			.append(m_strAgcyTrd)
			.append(", ��, ");
		}
		if(f_m_strGenTrd > 0){
			sb.append("����, ")
			.append(", ���ż�, ")
			.append(m_strGenTrd)
			.append(", ��, ")
			.append(", �̸�, ");
		}else if(f_m_strGenTrd < 0){
			sb.append("����, ")
			.append(", ���ŵ�, ")
			.append(m_strGenTrd)
			.append(", ��, ")
			.append(", �̸�, ");
		}else{
			sb.append("����, ")
			.append(m_strGenTrd)
			.append(", ��, ")
			.append(", �̸�, ");
		}
		
		
		//[�ŷ��� ���� �ܱ��θŸ� ����] 
		m_strFrgTrd1 = trimNum(m_strFrgTrd1);
		Float f_m_strFrgTrd1 = Float.parseFloat(m_strFrgTrd1);
		if(m_strFrgTrd1.startsWith("-")){
			m_strFrgTrd1 = m_strFrgTrd1.substring(1);
		    }else{
		    	m_strFrgTrd1 = m_strFrgTrd1;
		    }
		 long l_m_strFrgTrd1 = Long.parseLong(m_strFrgTrd1) * 100000000;

		 m_strFrgTrd1 = String.valueOf(l_m_strFrgTrd1);
		
		//[�ŷ��� ���� ����Ÿ� ����]
		 
		m_strAgcyTrd1 = trimNum(m_strAgcyTrd1);
		Float f_m_strAgcyTrd1 = Float.parseFloat(m_strAgcyTrd1);
		if(m_strAgcyTrd1.startsWith("-")){
			m_strAgcyTrd1 = m_strAgcyTrd1.substring(1);
		    }else{
		    	m_strAgcyTrd1 = m_strAgcyTrd1;
		    }
		 long l_m_strAgcyTrd1 = Long.parseLong(m_strAgcyTrd1) * 100000000;
		 m_strAgcyTrd1 = String.valueOf(l_m_strAgcyTrd1);
	
			 
		//[�ŷ��� ���� �ϹݸŸ� ����]
		m_strGenTrd1 = trimNum(m_strGenTrd1);
		Float f_m_strGenTrd1 = Float.parseFloat(m_strGenTrd1);
		if(m_strGenTrd1.startsWith("-")){
			m_strGenTrd1 = m_strGenTrd1.substring(1);
		    }else{
		    	m_strGenTrd1 = m_strGenTrd1;
		    }
		 long l_m_strGenTrd1 = Long.parseLong(m_strGenTrd1) * 100000000;
		 m_strGenTrd1 = String.valueOf(l_m_strGenTrd1);
		
		
		if(f_m_strFrgTrd1 > 0){
			sb.append("�ڽ��� ������, ")
			.append(", �ܱ���, ")
			.append(", ���ż�, ")
			.append(m_strFrgTrd1)
			.append(", ��, ");
		}else if(f_m_strFrgTrd1 < 0){
			sb.append("�ڽ��� ������, ")
			.append(", �ܱ���, ")
			.append(", ���ŵ�, ")
			.append(m_strFrgTrd1)
			.append(", ��, ");
		}else{
			sb.append("�ڽ��� ������, ")
			.append(", �ܱ���, ")
			.append(m_strFrgTrd1)
			.append(", ��, ");
		}
				
		if(f_m_strAgcyTrd1 > 0){
			sb.append("���, ")
			.append(", ���ż�, ")
			.append(m_strAgcyTrd1)
			.append(", ��, ");
		}else if(f_m_strAgcyTrd1 < 0){
			sb.append("���, ")
			.append(", ���ŵ�, ")
			.append(m_strAgcyTrd1)
			.append(", ��, ");
		}else{
			sb.append("���, ")
			.append(m_strAgcyTrd1)
			.append(", ��, ");
		}
		if(f_m_strGenTrd1 > 0){
			sb.append("����, ")
			.append(", ���ż�, ")
			.append(m_strGenTrd1)
			.append(", ��, ")
			.append(", �Դϴ�., ");
		}else if(f_m_strGenTrd1 < 0){
			sb.append("����, ")
			.append(", ���ŵ�, ")
			.append(m_strGenTrd1)
			.append(", ��, ")
			.append(", �Դϴ�., ");
		}else{
			sb.append("����, ")
			.append(m_strGenTrd1)
			.append(", �� �Դϴ�., ")
			.append(", �̸�, ");
		}
		
		//[�ŷ��� ���� �ܱ��θŸ� ����] 
		m_strFrgTrd2 = trimNum(m_strFrgTrd2);
		Float f_m_strFrgTrd2 = Float.parseFloat(m_strFrgTrd2);
		if(m_strFrgTrd2.startsWith("-")){
			m_strFrgTrd2 = m_strFrgTrd2.substring(1);
		    }else{
		    	m_strFrgTrd2 = m_strFrgTrd2;
		    }
		 long l_m_strFrgTrd2 = Long.parseLong(m_strFrgTrd2) * 1000000;

		 m_strFrgTrd2 = String.valueOf(l_m_strFrgTrd2);
		
		//[�ŷ��� ���� ����Ÿ� ����]
		m_strAgcyTrd2 = trimNum(m_strAgcyTrd2);
		Float f_m_strAgcyTrd2 = Float.parseFloat(m_strAgcyTrd2);
		if(m_strAgcyTrd2.startsWith("-")){
			m_strAgcyTrd2 = m_strAgcyTrd2.substring(1);
		    }else{
		    	m_strAgcyTrd2 = m_strAgcyTrd2;
		    }
		 long l_m_strAgcyTrd2 = Long.parseLong(m_strAgcyTrd2) * 1000000;
		 m_strAgcyTrd2 = String.valueOf(l_m_strAgcyTrd2);
	
			 
		//[�ŷ��� ���� �ϹݸŸ� ����]
		m_strGenTrd2 = trimNum(m_strGenTrd2);
		Float f_m_strGenTrd2 = Float.parseFloat(m_strGenTrd2);
		if(m_strGenTrd2.startsWith("-")){
			m_strGenTrd2 = m_strGenTrd2.substring(1);
		    }else{
		    	m_strGenTrd2 = m_strGenTrd2;
		    }
		 long l_m_strGenTrd2 = Long.parseLong(m_strGenTrd2) * 1000000;
		 m_strGenTrd2 = String.valueOf(l_m_strGenTrd2);		

		if(f_m_strFrgTrd2 > 0){
			sb.append("���� ������, ")
			.append(", �ܱ���, ")
			.append(", ���ż�, ")
			.append(m_strFrgTrd2).append(", , ")
			.append(", ��, ");
		}else if(f_m_strFrgTrd2 < 0){
			sb.append("���� ������, ")
			.append(", �ܱ���, ")
			.append(", ���ŵ�, ")
			.append(m_strFrgTrd2).append(", , ")
			.append(", ��, ");
		}else{
			sb.append("���� ������, ")
			.append(", �ܱ���, ")
			.append(m_strFrgTrd2).append(", , ")
			.append(", ��, ");
		}
		
		if(f_m_strAgcyTrd2 > 0){
			sb.append("���, ")
			.append(", ���ż�, ")
			.append(m_strAgcyTrd2).append(", , ")
			.append(", ��, ");
		}else if(f_m_strAgcyTrd2 < 0){
			sb.append("���, ")
			.append(", ���ŵ�, ")
			.append(m_strAgcyTrd2).append(", , ")
			.append(", ��, ");
		}else{
			sb.append("���, ")
			.append(m_strAgcyTrd2).append(", , ")
			.append(", ��, ");
		}

		if(f_m_strGenTrd2 > 0){
			sb.append("����, ")
			.append(", ���ż�, ")
			.append(m_strGenTrd2).append(", , ")
			.append(", ��, ")
			.append(", �̸�, ");
		}else if(f_m_strGenTrd2 < 0){
			sb.append("����, ")
			.append(", ���ŵ�, ")
			.append(m_strGenTrd2).append(", , ")
			.append(", ��, ")
			.append(", �̸�, ");
		}else{
			sb.append("����, ")
			.append(m_strGenTrd2).append(", , ")
			.append(", ��, ")
			.append(", �̸�, ");
		}	
		
		//[�ŷ��� ���� �ܱ��θŸ� ����] 
		m_strFrgTrd3 = trimNum(m_strFrgTrd3);
		Float f_m_strFrgTrd3 = Float.parseFloat(m_strFrgTrd3);
		if(m_strFrgTrd3.startsWith("-")){
			m_strFrgTrd3 = m_strFrgTrd3.substring(1);
		    }else{
		    	m_strFrgTrd3 = m_strFrgTrd3;
		    }
		 long l_m_strFrgTrd3 = Long.parseLong(m_strFrgTrd3) * 1000000;

		 m_strFrgTrd3 = String.valueOf(l_m_strFrgTrd3);
		
		//[�ŷ��� ���� ����Ÿ� ����]
		m_strAgcyTrd3 = trimNum(m_strAgcyTrd3);
		Float f_m_strAgcyTrd3 = Float.parseFloat(m_strAgcyTrd3);
		if(m_strAgcyTrd3.startsWith("-")){
			m_strAgcyTrd3 = m_strAgcyTrd3.substring(1);
		    }else{
		    	m_strAgcyTrd3 = m_strAgcyTrd3;
		    }
		 long l_m_strAgcyTrd3 = Long.parseLong(m_strAgcyTrd3) * 1000000;
		 m_strAgcyTrd3 = String.valueOf(l_m_strAgcyTrd3);
	
			 
		//[�ŷ��� ���� �ϹݸŸ� ����]
		m_strGenTrd3 = trimNum(m_strGenTrd3);
		Float f_m_strGenTrd3 = Float.parseFloat(m_strGenTrd3);
		if(m_strGenTrd3.startsWith("-")){
			m_strGenTrd3 = m_strGenTrd3.substring(1);
		    }else{
		    	m_strGenTrd3 = m_strGenTrd3;
		    }
		 long l_m_strGenTrd3 = Long.parseLong(m_strGenTrd3) * 1000000;
		 m_strGenTrd3 = String.valueOf(l_m_strGenTrd3);	
		
		
		if(f_m_strFrgTrd3 > 0){
			sb.append("�ݿɼ� ������, ")
			.append(", �ܱ���, ")
			.append(", ���ż�, ")
			.append(m_strFrgTrd3)
			.append(", ��, ");
		}else if(f_m_strFrgTrd3 < 0){
			sb.append("�ݿɼ� ������, ")
			.append(", �ܱ���, ")
			.append(", ���ŵ�, ")
			.append(m_strFrgTrd3)
			.append(", ��, ");
		}else{
			sb.append("�ݿɼ� ������, ")
			.append(", �ܱ���, ")
			.append(m_strFrgTrd3)
			.append(", ��, ");
		}
		
		if(f_m_strAgcyTrd3 > 0){
			sb.append("���, ")
			.append(", ���ż�, ")
			.append(m_strAgcyTrd3)
			.append(",��,");
		}else if(f_m_strAgcyTrd3 < 0){
			sb.append("���, ")
			.append(", ���ŵ�, ")
			.append(m_strAgcyTrd3)
			.append(",��,");
		}else{
			sb.append("���, ")
			.append(m_strAgcyTrd3)
			.append(",��,");
		}

		if(f_m_strGenTrd3 > 0){
			sb.append("����, ")
			.append(", ���ż�, ")
			.append(m_strGenTrd3)
			.append(",��,")
			.append(",�̸�,");
		}else if(f_m_strGenTrd3 < 0){
			sb.append("����, ")
			.append(", ���ŵ�, ")
			.append(m_strGenTrd3)
			.append(",��,")
			.append(",�̸�,");
		}else{
			sb.append("����, ")
			.append(m_strGenTrd3)
			.append(",��,")
			.append(",�̸�,");
		}
		
		//[�ŷ��� ���� �ܱ��θŸ� ����] 
		m_strFrgTrd4 = trimNum(m_strFrgTrd4);
		Float f_m_strFrgTrd4 = Float.parseFloat(m_strFrgTrd4);
		if(m_strFrgTrd4.startsWith("-")){
			m_strFrgTrd4 = m_strFrgTrd4.substring(1);
		    }else{
		    	m_strFrgTrd4 = m_strFrgTrd4;
		    }
		 long l_m_strFrgTrd4 = Long.parseLong(m_strFrgTrd4) * 1000000;

		 m_strFrgTrd4 = String.valueOf(l_m_strFrgTrd4);
		
		//[�ŷ��� ���� ����Ÿ� ����]
		m_strAgcyTrd4 = trimNum(m_strAgcyTrd4);
		Float f_m_strAgcyTrd4 = Float.parseFloat(m_strAgcyTrd4);
		if(m_strAgcyTrd4.startsWith("-")){
			m_strAgcyTrd4 = m_strAgcyTrd4.substring(1);
		    }else{
		    	m_strAgcyTrd4 = m_strAgcyTrd4;
		    }
		 long l_m_strAgcyTrd4 = Long.parseLong(m_strAgcyTrd4) * 1000000;
		 m_strAgcyTrd4 = String.valueOf(l_m_strAgcyTrd4);
	
			 
		//[�ŷ��� ���� �ϹݸŸ� ����]
		m_strGenTrd4 = trimNum(m_strGenTrd4);
		Float f_m_strGenTrd4 = Float.parseFloat(m_strGenTrd4);
		if(m_strGenTrd4.startsWith("-")){
			m_strGenTrd4 = m_strGenTrd4.substring(1);
		    }else{
		    	m_strGenTrd4 = m_strGenTrd4;
		    }
		 long l_m_strGenTrd4 = Long.parseLong(m_strGenTrd4) * 1000000;
		 m_strGenTrd4 = String.valueOf(l_m_strGenTrd4);	

		if(f_m_strFrgTrd4 > 0){
			sb.append("ǲ�ɼ� ������, ")
			.append(", �ܱ���, ")
			.append(", ���ż�, ")
			.append(m_strFrgTrd4)
			.append(", ��, ");
		}else if(f_m_strFrgTrd4 < 0){
			sb.append("ǲ�ɼ� ������, ")
			.append(", �ܱ���, ")
			.append(", ���ŵ�, ")
			.append(m_strFrgTrd4)
			.append(", ��, ");
		}else{
			sb.append("ǲ�ɼ� ������, ")
			.append(", �ܱ���, ")
			.append(m_strFrgTrd4)
			.append(", ��, ");
		}
		
		if(f_m_strAgcyTrd4 > 0){
			sb.append("���, ")
			.append(", ���ż�, ")
			.append(m_strAgcyTrd4)
			.append(", ��, ");
		}else if(f_m_strAgcyTrd4 < 0){
			sb.append("���, ")
			.append(", ���ŵ�, ")
			.append(m_strAgcyTrd4)
			.append(", ��, ");
		}else{
			sb.append("���, ")
			.append(m_strAgcyTrd4)
			.append(", ��, ");
		}

		if(f_m_strGenTrd4 > 0){
			sb.append("����, ")
			.append(", ���ż�, ")
			.append(m_strGenTrd4)
			.append(", ��, ")
			.append(", �̸�, ");
		}else if(f_m_strGenTrd4 < 0){
			sb.append("����, ")
			.append(", ���ŵ�, ")
			.append(m_strGenTrd4)
			.append(", ��, ")
			.append(", �̸�, ");
		}else{
			sb.append("����, ")
			.append(m_strGenTrd4)
			.append(", ��, ")
			.append(", �̸�, ");
		}
		
		
		 
		
		
		if(f_m_strTotBidTot > 0){
			sb.append("���α׷� �Ÿŵ�����, ")
			.append(", �ŷ���, ")
			.append(", ���ż�, ")
			.append(m_strTotBidTot)
			.append(", ��, ");
		}else if(f_m_strTotBidTot < 0){
			sb.append("���α׷� �Ÿŵ�����, ")
			.append(", �ŷ���, ")
			.append(", ���ŵ�, ")
			.append(m_strTotBidTot)
			.append(", ��, ");
		}else{
			sb.append("���α׷� �Ÿŵ�����, ")
			.append(", �ŷ���, ")
			.append(m_strTotBidTot)
			.append(", ��, ");
		}
		
		if(f_m_strAgcyTrd > 0){
			sb.append("�ڽ���, ")
			.append(", ���ż�, ")
			.append(m_strAgcyTrd)
			.append(", ��, ")
			.append(", �Դϴ�. ");
		}else if(f_m_strAgcyTrd < 0){
			sb.append("�ڽ���, ")
			.append(", ���ŵ�, ")
			.append(m_strAgcyTrd)
			.append(", ��, ")
			.append(", �Դϴ�. ");
		}else{
			sb.append("�ڽ���, ")
			.append(m_strAgcyTrd)
			.append(", ��, ")
			.append(", �Դϴ�. ");
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
