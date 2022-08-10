package TTS.S6.S610000;

import java.util.Hashtable;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_610_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException{
		Hashtable table = (Hashtable) actionAPI.getSessionData("g_objHostRecv");
		if(table != null && !table.isEmpty()){
			StringBuffer sb = new StringBuffer();
			try{
				String A_CNT = (String) actionAPI.getSessionData("A_CNT");//�׸���ī��Ʈ
				int CNT = Integer.parseInt(A_CNT);
				for(int i=0; i<CNT; i++){
					//m_strSubsTurn = A{Data.Session.m_iCnt}_SubsTrun
					//m_strSubItemNm = A{Data.Session.m_iCnt}_ItemNm
					//m_strSubsStrDate = A{Data.Session.m_iCnt}_SubsStrDate
					//m_strSubsEndDate = A{Data.Session.m_iCnt}_SubsEndDate
					//m_strSubsRpmtDate = A{Data.Session.m_iCnt}_RpmtDate
					//m_strTdaySubsEnblYn = A{Data.Session.m_iCnt}_TdaySubsEnblYn
					String m_strSubsTurn = (String) table.get("A"+String.valueOf(i)+"_"+"SubsTrun");
					m_strSubsTurn = trimNum(m_strSubsTurn);
					String m_strSubItemNm = (String) table.get("A"+String.valueOf(i)+"_"+"ItemNm");
					
					/*String m_strSubsStrDate = (String) table.get("A"+String.valueOf(i)+"_"+"SubsStrDate");
					String m_strSubsEndDate = (String) table.get("A"+String.valueOf(i)+"_"+"SubsEndDate");
					String m_strSubsRpmtDate = (String) table.get("A"+String.valueOf(i)+"_"+"RpmtDate");
					String m_strTdaySubsEnblYn = (String) table.get("A"+String.valueOf(i)+"_"+"TdaySubsEnblYn");*/
					
					int num = i+1;
					
					if(m_strSubsTurn.equals("") || m_strSubsTurn.equals(null)){
						sb.append("ȸ��, ����, "); 
					}else{
						sb.append(m_strSubsTurn).append(", ȸ��, ");
					}
					
					if(m_strSubItemNm.equals("") || m_strSubItemNm.equals(null)){
						sb.append(", �����, ����, ");
					}else{
						sb.append(m_strSubItemNm);
					}
					
				}
				actionAPI.setSessionData("ment", sb.toString());
			}catch(Exception e){
				actionAPI.setSessionData("ment", "error");
			}
		}
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