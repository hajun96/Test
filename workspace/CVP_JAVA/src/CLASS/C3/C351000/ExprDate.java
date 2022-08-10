package CLASS.C3.C351000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class ExprDate  extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strNote = (String) actionAPI.getSessionData("m_strNote"); //비고
		
		if(m_strNote.equals("0") || m_strNote.equals("") || m_strNote.equals(null)){
			m_strNote = "";
		}else{
			int n1 = m_strNote.indexOf("만기일자:");
			m_strNote = m_strNote.substring(n1+5, m_strNote.length());
			m_strNote = m_strNote.replace("/", "");
		}
		actionAPI.setSessionData("m_strExprDate", m_strNote);
	}
}
