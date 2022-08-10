package CLASS.S00000;


import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;
import com.isiConst.DEF_VAR;

public class SetCV3 extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
		String m_strAccountNum = (String)actionAPI.getSessionData(DEF_VAR.M_strAccountNum);
		String CV3 = (String)actionAPI.getSessionData("CV3");
		
		if(m_strAccountNum.length() > 7) {
			
			String tempStr = "";
			tempStr = m_strAccountNum.substring(0, 7);
			
			for (int i = 0; i < 33; i++) {
				tempStr += "_";
			}
			
			CV3 = tempStr;
		}
		
		actionAPI.setSessionData("CV3", CV3);
		
	}

}
