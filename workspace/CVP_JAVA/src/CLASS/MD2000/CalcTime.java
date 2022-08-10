package CLASS.MD2000;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class CalcTime extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
		
		String expectTime = "";
		
		// 장 시작시간
		String m_strSelectStartTime1 = (String)actionAPI.getSessionData("m_strSelectStartTime1");
		
		int startTime = 0;
		if(m_strSelectStartTime1 != null) {
			startTime = Integer.parseInt(m_strSelectStartTime1);
			int tempNum = Integer.parseInt(m_strSelectStartTime1.substring(2, m_strSelectStartTime1.length()));
			
			if(tempNum > 30) {
				startTime = startTime - 30;
			} else {
				startTime = startTime - 70;
			}
			
		}
		
		
		SimpleDateFormat format = new SimpleDateFormat("HHmm");
		Date today = new Date();
		
		String nowTime = format.format(today);
		
		
		if(Integer.parseInt(nowTime) < startTime) {
			// 예상지수 시작시간전
			expectTime = "-1";
		} else if(Integer.parseInt(nowTime) < Integer.parseInt(m_strSelectStartTime1)) {
			// 예상지수 시간
			expectTime = "0";
		} else {
			// 그외
			expectTime = "1";
		}
		
		actionAPI.setSessionData("expectTime", expectTime);
		
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
