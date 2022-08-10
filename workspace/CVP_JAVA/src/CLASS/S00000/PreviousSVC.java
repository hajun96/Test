package CLASS.S00000;


import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;
import com.isiConst.DEF_VAR;

public class PreviousSVC extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
			
		String m_PreSvcCode = (String)actionAPI.getSessionData(DEF_VAR.M_PreSvcCode);
		
		String m_strEndType = "";
		if(m_PreSvcCode.startsWith("M")){
			m_strEndType = "MDA000";
		} else if (m_PreSvcCode.startsWith("100") || m_PreSvcCode.startsWith("200") || m_PreSvcCode.startsWith("300")
				|| m_PreSvcCode.startsWith("400") || m_PreSvcCode.startsWith("500") || m_PreSvcCode.startsWith("600")
				|| m_PreSvcCode.startsWith("700")) {
			m_strEndType = "MDA000";
		} else if (m_PreSvcCode.startsWith("110") || m_PreSvcCode.startsWith("120") || m_PreSvcCode.startsWith("130")){
			m_strEndType = "100000";
		} else if (m_PreSvcCode.startsWith("111") || m_PreSvcCode.startsWith("112") || m_PreSvcCode.startsWith("113")
				|| m_PreSvcCode.startsWith("114")) {
			m_strEndType = "110000";
		} else if (m_PreSvcCode.startsWith("121") || m_PreSvcCode.startsWith("122") || m_PreSvcCode.startsWith("123")
				|| m_PreSvcCode.startsWith("124") || m_PreSvcCode.startsWith("125")) {
			m_strEndType = "120000";
		} else if (m_PreSvcCode.startsWith("210") || m_PreSvcCode.startsWith("220") || m_PreSvcCode.startsWith("230")
				|| m_PreSvcCode.startsWith("240") || m_PreSvcCode.startsWith("250") || m_PreSvcCode.startsWith("260")
				|| m_PreSvcCode.startsWith("270")) {
			m_strEndType = "200000";
		} else if (m_PreSvcCode.startsWith("221") || m_PreSvcCode.startsWith("222") || m_PreSvcCode.startsWith("223")) {
			m_strEndType = "220000";
		} else if (m_PreSvcCode.startsWith("231") || m_PreSvcCode.startsWith("232") || m_PreSvcCode.startsWith("233")
				|| m_PreSvcCode.startsWith("234") || m_PreSvcCode.startsWith("235") || m_PreSvcCode.startsWith("236")
				|| m_PreSvcCode.startsWith("237") || m_PreSvcCode.startsWith("238")) {
			m_strEndType = "230000";
		} else if (m_PreSvcCode.startsWith("251") || m_PreSvcCode.startsWith("252")) {
			m_strEndType = "250000";
		} else if (m_PreSvcCode.startsWith("310") || m_PreSvcCode.startsWith("320") || m_PreSvcCode.startsWith("330")
				|| m_PreSvcCode.startsWith("340") || m_PreSvcCode.startsWith("350") || m_PreSvcCode.startsWith("360")
				|| m_PreSvcCode.startsWith("370") ) {
			m_strEndType = "300000";
		} else if(m_PreSvcCode.startsWith("311") || m_PreSvcCode.startsWith("312") || m_PreSvcCode.startsWith("313")
				|| m_PreSvcCode.startsWith("314")) {
			m_strEndType = "310000";
		} else if(m_PreSvcCode.startsWith("321") || m_PreSvcCode.startsWith("322") || m_PreSvcCode.startsWith("323")
				|| m_PreSvcCode.startsWith("324") || m_PreSvcCode.startsWith("325")) {
			m_strEndType = "320000";
		} else if (m_PreSvcCode.startsWith("331") || m_PreSvcCode.startsWith("332") || m_PreSvcCode.startsWith("333")
				|| m_PreSvcCode.startsWith("334") || m_PreSvcCode.startsWith("335") || m_PreSvcCode.startsWith("336")) {
			m_strEndType = "330000";
		} else if (m_PreSvcCode.startsWith("341") || m_PreSvcCode.startsWith("342") || m_PreSvcCode.startsWith("343")
				|| m_PreSvcCode.startsWith("344") || m_PreSvcCode.startsWith("345") || m_PreSvcCode.startsWith("346")
				|| m_PreSvcCode.startsWith("347")) {
			m_strEndType = "340000";
		} else if (m_PreSvcCode.startsWith("351") || m_PreSvcCode.startsWith("352") || m_PreSvcCode.startsWith("353")
				|| m_PreSvcCode.startsWith("354")) {
			m_strEndType = "350000";
		} else if (m_PreSvcCode.startsWith("361") || m_PreSvcCode.startsWith("362") || m_PreSvcCode.startsWith("363")
				|| m_PreSvcCode.startsWith("364") || m_PreSvcCode.startsWith("365")) {
			m_strEndType = "360000";
		} else if (m_PreSvcCode.startsWith("371") || m_PreSvcCode.startsWith("372") || m_PreSvcCode.startsWith("373")
				|| m_PreSvcCode.startsWith("374") || m_PreSvcCode.startsWith("375")) {
			m_strEndType = "370000";
		} else if (m_PreSvcCode.startsWith("410") || m_PreSvcCode.startsWith("420") || m_PreSvcCode.startsWith("430")
				|| m_PreSvcCode.startsWith("440") || m_PreSvcCode.startsWith("450") || m_PreSvcCode.startsWith("460")) {
			m_strEndType = "400000";
		} else if (m_PreSvcCode.startsWith("441") || m_PreSvcCode.startsWith("442")) {
			m_strEndType = "440000";
		} else if (m_PreSvcCode.startsWith("451") || m_PreSvcCode.startsWith("452")) {
			m_strEndType = "450000";
		} else if (m_PreSvcCode.startsWith("461") || m_PreSvcCode.startsWith("462") || m_PreSvcCode.startsWith("463")) {
			m_strEndType = "460000";
		} else if (m_PreSvcCode.startsWith("510") || m_PreSvcCode.startsWith("520") || m_PreSvcCode.startsWith("530")) {
			m_strEndType = "500000";
		} else if (m_PreSvcCode.startsWith("531") || m_PreSvcCode.startsWith("532")) {
			m_strEndType = "530000";
		} else if (m_PreSvcCode.startsWith("610") || m_PreSvcCode.startsWith("620")) {
			m_strEndType = "600000";
		} else if (m_PreSvcCode.startsWith("611") || m_PreSvcCode.startsWith("612") || m_PreSvcCode.startsWith("613")
				|| m_PreSvcCode.startsWith("614") || m_PreSvcCode.startsWith("615") || m_PreSvcCode.startsWith("616")) {
			m_strEndType = "610000";
		} else if (m_PreSvcCode.startsWith("621") || m_PreSvcCode.startsWith("622") || m_PreSvcCode.startsWith("623")
				|| m_PreSvcCode.startsWith("624") || m_PreSvcCode.startsWith("625")) {
			m_strEndType = "620000";
		} else if (m_PreSvcCode.startsWith("710") || m_PreSvcCode.startsWith("720") || m_PreSvcCode.startsWith("730")
				|| m_PreSvcCode.startsWith("740") || m_PreSvcCode.startsWith("750") || m_PreSvcCode.startsWith("760")
				|| m_PreSvcCode.startsWith("770") || m_PreSvcCode.startsWith("780")){
			m_strEndType = "700000";
		} else if (m_PreSvcCode.startsWith("741") || m_PreSvcCode.startsWith("742")) {
			m_strEndType = "740000";
		} else if (m_PreSvcCode.startsWith("751") || m_PreSvcCode.startsWith("751") || m_PreSvcCode.startsWith("753")
				|| m_PreSvcCode.startsWith("754")) {
			m_strEndType = "750000";
		} else if (m_PreSvcCode.startsWith("781") || m_PreSvcCode.startsWith("782") || m_PreSvcCode.startsWith("783")) {
			m_strEndType = "780000";
		} else {
			m_strEndType = "MDA000";
		}
		
		// 멘트를 만들기 위한 String 데이터를 ment 라는 이름의 Session Data 로 저장한다.
		actionAPI.setSessionData("m_strEndType", m_strEndType);
		
	}

}
