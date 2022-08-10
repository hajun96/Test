package CLASS.CA;

import java.util.Calendar;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class Week extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		Calendar cal = Calendar.getInstance();
		int nWeek = cal.get(Calendar.DAY_OF_WEEK);
		String m_strWeek = String.valueOf(nWeek);
		actionAPI.setSessionData("m_strWeek", m_strWeek);
	}
}
