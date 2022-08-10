package CLASS.MDB000;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class DivideCellNum extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
		
		String digitvalue = (String) actionAPI.getSessionData("digitvalue");
		
		String cellNum_1 = "";
		String cellNum_2 = "";
		String cellNum_3 = "";
		
		if(digitvalue.length() >= 10) {
			cellNum_1 = digitvalue.substring(0, 3);
			if(digitvalue.length() == 10) {
				cellNum_2 = digitvalue.substring(3, 6);
				cellNum_3 = digitvalue.substring(6);
			} else {
				cellNum_2 = digitvalue.substring(3, 7);
				cellNum_3 = digitvalue.substring(7);
			}
		}
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date today = new Date();
		
		
		
		actionAPI.setSessionData("cellNum_1", cellNum_1);
		actionAPI.setSessionData("cellNum_2", cellNum_2);
		actionAPI.setSessionData("cellNum_3", cellNum_3);
		actionAPI.setSessionData("today", format.format(today).toString());
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
