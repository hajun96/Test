package CLASS.S00000;


import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;
import com.isiConst.DEF_VAR;

public class SubdialogReturn extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
			
		String CV1 = (String)actionAPI.getSessionData("CV1"); // VXML0
		String CV2 = (String)actionAPI.getSessionData("CV2"); // VXML0
		String CV3 = (String)actionAPI.getSessionData("CV3"); // VXML0
		String CV4 = (String)actionAPI.getSessionData("CV4"); // VXML0
		String CV5 = (String)actionAPI.getSessionData("CV5"); // VXML1
		String CV6 = (String)actionAPI.getSessionData("CV6"); // VXML1
		String CV7 = (String)actionAPI.getSessionData("CV7"); // VXML1
		String CV8 = (String)actionAPI.getSessionData("CV8"); // VXML1
		String CV9 = (String)actionAPI.getSessionData("CV9"); // VXML2
		String CV10 = (String)actionAPI.getSessionData("CV10"); // VXML2
		
		String m_strItemCode 		= (String)actionAPI.getSessionData(DEF_VAR.M_strItemCode);		// to0 VXML2
		String m_strCallkey 		= (String)actionAPI.getSessionData(DEF_VAR.M_strCALL_KEY);		// to1 VXML2
		String m_strAnyNum 			= (String)actionAPI.getSessionData(DEF_VAR.M_strAnyNum);		// to2 VXML2
		String m_strCustomNum 		= (String)actionAPI.getSessionData(DEF_VAR.M_strCustomNum);		// to3 VXML3
		String m_strAccountNum 		= (String)actionAPI.getSessionData(DEF_VAR.M_strAccountNum);	// to4 VXML3
		String m_strAccPwdNum 		= (String)actionAPI.getSessionData(DEF_VAR.M_strAccPwdNum);		// to5 VXML3
		String m_strEndType 		= (String)actionAPI.getSessionData(DEF_VAR.M_strEndType);		// to6 VXML3
		String m_strCallInQ 		= (String)actionAPI.getSessionData(DEF_VAR.M_strCallInQ);		// to7 VXML3
		String m_strEWT 			= (String)actionAPI.getSessionData(DEF_VAR.M_strEWT);			// to8 VXML3
		String m_strAccreditFlag 	= (String)actionAPI.getSessionData(DEF_VAR.M_strAccreditFlag);	// to9 VXML3
		String m_strProcSect 		= (String)actionAPI.getSessionData(DEF_VAR.M_strProcSect);		// to10 VXML3
		String m_strCustSect 		= (String)actionAPI.getSessionData(DEF_VAR.M_strCustSect);		// to11 VXML3
		String m_strPwdErrCnt 		= (String)actionAPI.getSessionData(DEF_VAR.M_strPwdErrCnt);		// to12 VXML3
		String m_strAccountType 	= (String)actionAPI.getSessionData(DEF_VAR.M_strAccountType);	// to13 VXML3
		String m_strAccountSect 	= (String)actionAPI.getSessionData(DEF_VAR.M_strAccountSect);	// to14 VXML3
		String m_strAgtType 		= (String)actionAPI.getSessionData(DEF_VAR.M_strAgtType);		// to15 VXML3
		String m_iSRPlayFlag 		= (String)actionAPI.getSessionData(DEF_VAR.M_iSRPlayFlag);		// to16 VXML2
		
		StringBuffer VXML0 = new StringBuffer();
		StringBuffer VXML1 = new StringBuffer();
		StringBuffer VXML2 = new StringBuffer();
		StringBuffer VXML3 = new StringBuffer();
		
		if(CV1 != null && !CV1.isEmpty()) {VXML0.append("CV1=").append(CV1).append(";");}
		if(CV2 != null && !CV2.isEmpty()) {VXML0.append("CV2=").append(CV2).append(";");}
		if(CV3 != null && !CV3.isEmpty()) {VXML0.append("CV3=").append(CV3).append(";");}
		if(CV4 != null && !CV4.isEmpty()) {VXML0.append("CV4=").append(CV4).append(";");}
		
		if(CV5 != null && !CV5.isEmpty()) {VXML1.append("CV5=").append(CV5).append(";");}
		if(CV6 != null && !CV6.isEmpty()) {VXML1.append("CV6=").append(CV6).append(";");}
		if(CV7 != null && !CV7.isEmpty()) {VXML1.append("CV7=").append(CV7).append(";");}
		if(CV8 != null && !CV8.isEmpty()) {VXML1.append("CV8=").append(CV8).append(";");}
		
		if(CV9 != null && !CV9.isEmpty()) {VXML2.append("CV9=").append(CV9).append(";");}
		if(CV10 != null && !CV10.isEmpty()) {VXML2.append("CV10=").append(CV10).append(";");}
		if(m_strItemCode != null && !m_strItemCode.isEmpty()) {VXML2.append("to0=").append(m_strItemCode).append(";");}
		if(m_strCallkey != null && !m_strCallkey.isEmpty()) {VXML2.append("to1=").append(m_strCallkey).append(";");}
		if(m_strAnyNum != null && !m_strAnyNum.isEmpty()) {VXML2.append("to2=").append(m_strAnyNum).append(";");}
		if(m_iSRPlayFlag != null && !m_iSRPlayFlag.isEmpty()) {VXML2.append("to16=").append(m_iSRPlayFlag).append(";");}
		
		if(m_strCustomNum != null && !m_strCustomNum.isEmpty()) {VXML3.append("to3=").append(m_strCustomNum).append(";");}
		if(m_strAccountNum != null && !m_strAccountNum.isEmpty()) {VXML3.append("to4=").append(m_strAccountNum).append(";");}
		if(m_strAccPwdNum != null && !m_strAccPwdNum.isEmpty()) {VXML3.append("to5=").append(m_strAccPwdNum).append(";");}
		if(m_strEndType != null && !m_strEndType.isEmpty()) {VXML3.append("to6=").append(m_strEndType).append(";");}
		if(m_strCallInQ != null && !m_strCallInQ.isEmpty()) {VXML3.append("to7=").append(m_strCallInQ).append(";");}
		if(m_strEWT != null && !m_strEWT.isEmpty()) {VXML3.append("to8=").append(m_strEWT).append(";");}
		if(m_strAccreditFlag != null && !m_strAccreditFlag.isEmpty()) {VXML3.append("to9=").append(m_strAccreditFlag).append(";");}
		if(m_strProcSect != null && !m_strProcSect.isEmpty()) {VXML3.append("to10=").append(m_strProcSect).append(";");}
		if(m_strCustSect != null && !m_strCustSect.isEmpty()) {VXML3.append("to11=").append(m_strCustSect).append(";");}
		if(m_strPwdErrCnt != null && !m_strPwdErrCnt.isEmpty()) {VXML3.append("to12=").append(m_strPwdErrCnt).append(";");}
		if(m_strAccountType != null && !m_strAccountType.isEmpty()) {VXML3.append("to13=").append(m_strAccountType).append(";");}
		if(m_strAccountSect != null && !m_strAccountSect.isEmpty()) {VXML3.append("to14=").append(m_strAccountSect).append(";");}
		if(m_strAgtType != null && !m_strAgtType.isEmpty()) {VXML3.append("to15=").append(m_strAgtType).append(";");}
		
		
		actionAPI.setSessionData("ToVXML0", VXML0.toString());
		actionAPI.setSessionData("ToVXML1", VXML1.toString());
		actionAPI.setSessionData("ToVXML2", VXML2.toString());
		actionAPI.setSessionData("ToVXML3", VXML3.toString());
		
		//m_strAccPwd
	}

}
