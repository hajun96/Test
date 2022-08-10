package CLASS.C6.C610000;

import java.util.Hashtable;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class SubsTurn extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException{
		Hashtable table = (Hashtable) actionAPI.getSessionData("g_objHostRecv");
		if(table != null && !table.isEmpty()){
			StringBuffer sb = new StringBuffer();
			try{
				String A_CNT = (String) actionAPI.getSessionData("A_CNT");//그리드카운트
				String m_strDTMF = (String) actionAPI.getSessionData("m_strDTMF");//입력값
				String m_strIndex = "";
				int CNT = Integer.parseInt(A_CNT);
				for(int i=0; i<CNT; i++){
					//String m_strSubsTurn = (String) table.get("A"+String.valueOf(i)+"_"+"SubsTrun");
					String m_strSubsTurn = (String) table.get("A"+String.valueOf(i)+"_"+"SubsTrun");
					
					m_strSubsTurn = trimNum(m_strSubsTurn);
					
					if(m_strSubsTurn.equals(m_strDTMF)){
						m_strIndex = String.valueOf(i);
						actionAPI.setSessionData("m_strIndex", m_strIndex);
					}else{
						m_strIndex = "error";
					}
					int num = i+1;
				}
			}catch(Exception e){
				actionAPI.setSessionData("m_strIndex", "error");
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
