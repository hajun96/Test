package TTS;

import isiConst.DEF_VAR;

import java.util.Hashtable;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class Sample extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
		
		// TR ��� �� ������� �����ϴ� Hashtable �� �����´�.
		Hashtable table = (Hashtable) actionAPI.getSessionData(DEF_VAR.G_HOST_RECV);
		
		// GRID TR �̶�� GRID ������ �����´�. 
		int cnt = Integer.parseInt((String)table.get("A_CNT"));
		
		// ��Ʈ�� �����ϱ� ���� StringBuffer ����
		StringBuffer sb = new StringBuffer();
		
		
		for (int i = 0; i < cnt; i++) {
			
			String a = (String) table.get("A" + i + "_JobTime1");
			String b = (String)table.get("A" + i + "_Current1");
			
			sb.append(a).append("�� ������ �ؼ� �󷹸��÷���").append(b).append("�� ��ϵ���~");
			
			
		}
		
		// ��Ʈ�� ����� ���� String �����͸� ment ��� �̸��� Session Data �� �����Ѵ�.
		actionAPI.setSessionData("ment", sb.toString());
		
		
	}

}
