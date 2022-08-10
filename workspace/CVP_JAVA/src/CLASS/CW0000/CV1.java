package CLASS.CW0000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class CV1 extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
		
		String CV1 = (String) actionAPI.getSessionData("CV1");
		
		String inNumber = "";
		if(CV1.length() > 1) {
			inNumber = CV1.substring(1);
		}
		
		String inType = "";
		
		if(inNumber.startsWith("1588-9200") || inNumber.startsWith("1588-9300") || inNumber.startsWith("1644-9200") || inNumber.startsWith("1577-9301")
				|| inNumber.startsWith("1644-9300") || inNumber.startsWith("1588-6800") || inNumber.startsWith("1588-3322")) {
			inType = "A";
		} else if (inNumber.startsWith("1544-5533")) {
			// 다이렉트 전용상담
			inType = "B";
		} else if (inNumber.startsWith("1644-3322") || inNumber.startsWith("02-6714-9340")){
			// 스마트 상담센터
			inType = "C"; 
		} else if (inNumber.startsWith("1577-4600")) {
			// VIP 상담센터
			inType = "D";
		} else if (inNumber.startsWith("1577-9300")) {
			// 금융상품상담센터
			inType = "E";
		} else if (inNumber.startsWith("02-3774-2000") || inNumber.startsWith("3774-2000") || 
				inNumber.startsWith("02-3774-7000") || inNumber.startsWith("3774-7000")) {
			// 퇴직연금 , 기업임원 VIP 상담센터
			inType = "F";
		} else if (inNumber.startsWith("02-500-0622") || inNumber.startsWith("500-0622")) {
			// 외국인 전용상담
			inType = "G";
		} else if (inNumber.startsWith("02-3774-1700") || inNumber.startsWith("02-768-3355")) {
			// 본사 대표전화
			inType = "H";
		} else if (inNumber.startsWith("080-396-0026")){
			// 경찰청 핫라인
			inType = "I";
		} else if (inNumber.startsWith("1599-3322")) {
			// 타사대체입고
			inType = "J";
		} else {
			inType = "A";
		}
		
		actionAPI.setSessionData("inType", inType);
		
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
