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
		
		// TR 통신 후 결과값이 존재하는 Hashtable 을 가져온다.
		Hashtable table = (Hashtable) actionAPI.getSessionData(DEF_VAR.G_HOST_RECV);
		
		// GRID TR 이라면 GRID 개수를 가져온다. 
		int cnt = Integer.parseInt((String)table.get("A_CNT"));
		
		// 멘트를 생성하기 위한 StringBuffer 생성
		StringBuffer sb = new StringBuffer();
		
		
		for (int i = 0; i < cnt; i++) {
			
			String a = (String) table.get("A" + i + "_JobTime1");
			String b = (String)table.get("A" + i + "_Current1");
			
			sb.append(a).append("는 뭐뭐뭐 해서 얼레리꼴레리").append(b).append("랑 사귄데요~");
			
			
		}
		
		// 멘트를 만들기 위한 String 데이터를 ment 라는 이름의 Session Data 로 저장한다.
		actionAPI.setSessionData("ment", sb.toString());
		
		
	}

}
