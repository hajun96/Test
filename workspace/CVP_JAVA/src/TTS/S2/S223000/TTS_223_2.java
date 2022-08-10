package TTS.S2.S223000;


import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_223_2 extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
		
		// TR 통신 후 결과값이 존재하는 Hashtable 을 가져온다.
		StringBuffer sb = new StringBuffer();
		
		String m_strExpectFlucBit = (String) actionAPI.getSessionData("m_strExpectFlucBit");
		String m_strExpectFluctAmt = (String) actionAPI.getSessionData("m_strExpectFluctAmt");
		String m_strExpectAmt =  (String) actionAPI.getSessionData("m_strExpectAmt");
		
		
		String m_strExpectFluctAmt_1 = trimNum(m_strExpectFluctAmt.substring(0, 4));
		String m_strExpectFluctAmt_2 = m_strExpectFluctAmt.substring(5);
		String m_strExpectAmt_1 = trimNum(m_strExpectAmt.substring(0, 5));
		String m_strExpectAmt_2 = m_strExpectAmt.substring(6);
		
		
		sb.append(", 예상 코스피 200 지수는, ");
		if(m_strExpectFlucBit.equals("5")){
			sb.append(m_strExpectFluctAmt_1).append(",쩜, [").append(m_strExpectFluctAmt_2).append("]");
			sb.append(", 내린, ");
		} else if(m_strExpectFlucBit.equals("1")){
			sb.append(m_strExpectFluctAmt_1).append(",쩜, [").append(m_strExpectFluctAmt_2).append("]");
			sb.append(", 오른, ");
		} else if(m_strExpectFlucBit.equals("9") || m_strExpectFlucBit.equals("0")){
			sb.append(", 보합인,");
		} 
			
		sb.append(m_strExpectAmt_1).append(",쩜,[").append(m_strExpectAmt_2).append("] 포인트, 입니다.");
		
		// 멘트를 만들기 위한 String 데이터를 ment 라는 이름의 Session Data 로 저장한다.
		actionAPI.setSessionData("ment", sb.toString());
		
		
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
