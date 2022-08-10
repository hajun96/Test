package CLASS.A00000;


import java.util.Hashtable;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class DivideAnyNum extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
			
		String m_strAnyNum = (String)actionAPI.getSessionData("m_strAnyNum");
		
		String m_strAnyNum_1;
		String m_strAnyNum_2;
		String m_strAnyNum_3;
		
		if(m_strAnyNum.length() < 9) {
			
			int divideNum = m_strAnyNum.length() / 3;
			
			m_strAnyNum_1 = m_strAnyNum.substring(0, divideNum);
			m_strAnyNum_2 = m_strAnyNum.substring(divideNum, divideNum * 2);
			m_strAnyNum_3 = m_strAnyNum.substring(divideNum * 2, m_strAnyNum.length());
			
			actionAPI.setSessionData("m_strAnyNum_1", m_strAnyNum_1);
			actionAPI.setSessionData("m_strAnyNum_2", m_strAnyNum_2);
			actionAPI.setSessionData("m_strAnyNum_3", m_strAnyNum_3);
			
			return;
			
		}
		
		
		if(m_strAnyNum.startsWith("9")){
			m_strAnyNum = m_strAnyNum.substring(1);
		}
		
		
		if(m_strAnyNum.startsWith("02")){
			
			m_strAnyNum_1 = m_strAnyNum.substring(0, 2);
			if(m_strAnyNum.length() == 9) {
				m_strAnyNum_2 = m_strAnyNum.substring(2, 5);
				m_strAnyNum_3 = m_strAnyNum.substring(5, m_strAnyNum.length());
			} else {
				m_strAnyNum_2 = m_strAnyNum.substring(2, 6);
				m_strAnyNum_3 = m_strAnyNum.substring(6, m_strAnyNum.length());
			}
			
		} else {
			
			m_strAnyNum_1 =  m_strAnyNum.substring(0, 3);
			if(m_strAnyNum.length() == 10) {
				m_strAnyNum_2 = m_strAnyNum.substring(3, 6);
				m_strAnyNum_3 = m_strAnyNum.substring(6, m_strAnyNum.length());
			} else {
				m_strAnyNum_2 = m_strAnyNum.substring(3, 7);
				m_strAnyNum_3 = m_strAnyNum.substring(7, m_strAnyNum.length());
			}
			
		}
		
		if(m_strAnyNum_1.length() != 3) {
			m_strAnyNum_1 = " " + m_strAnyNum_1;
		}
		if(m_strAnyNum_2.length() != 4) {
			m_strAnyNum_2 = " " + m_strAnyNum_2;
		}
		if(m_strAnyNum_3.length() != 4) {
			m_strAnyNum_3 = " " + m_strAnyNum_3;
		}
		
		actionAPI.setSessionData("m_strAnyNum_1", m_strAnyNum_1);
		actionAPI.setSessionData("m_strAnyNum_2", m_strAnyNum_2);
		actionAPI.setSessionData("m_strAnyNum_3", m_strAnyNum_3);
		
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

