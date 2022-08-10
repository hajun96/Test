package TTS.S1.S112000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_112_2 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strExpectAmt = (String) actionAPI.getSessionData("m_strExpectAmt");			//현재가
		String m_strExpectFlucBit = (String) actionAPI.getSessionData("m_strExpectFlucBit");	//전일대비구분
		String m_strExpectFluctAmt = (String) actionAPI.getSessionData("m_strExpectFluctAmt");	//전일대비
		//String m_strExpectVolume = (String) actionAPI.getSessionData("m_strExpectVolume");		//거래량
		
		// [전일 대비 계산] 
		// 소수점 자리수를 가져온다. 
		int strFluctDotIndex = m_strExpectFluctAmt.indexOf(".");
		// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
		String strFluctDotLeft = m_strExpectFluctAmt.substring(0, strFluctDotIndex);
		// 앞에 0이 있으면 없앤다.
		strFluctDotLeft = trimNum(strFluctDotLeft);
		// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
		String strFluctDotRight = m_strExpectFluctAmt.substring(strFluctDotIndex+1);
		// 앞에 0이 없으면 없앤다.
		strFluctDotRight = trimNum(strFluctDotRight);
		
		// [현재가 계산]
		// 소수점 자리수를 가져온다. 
		int strExpectDotIndex = m_strExpectAmt.indexOf(".");
		// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
		String strExpectDotLeft = m_strExpectAmt.substring(0, strExpectDotIndex);
		// 앞에 0이 있으면 없앤다.
		strExpectDotLeft = trimNum(strExpectDotLeft);
		// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
		String strExpectDotRight = m_strExpectAmt.substring(strExpectDotIndex+1);
		
		
		
		
		StringBuffer sb = new StringBuffer();
		
		if(m_strExpectFlucBit.equals("0")){			//보합
			sb.append("예상 종합 주가지수는").append("보합인").
			append(strExpectDotLeft).append(", 쩜, [").append(strExpectDotRight).append("], 포인트 입니다.");
		}else if(m_strExpectFlucBit.equals("1")){	//오른
			sb.append("예상 종합 주가지수는").append(strFluctDotLeft).append(", 쩜, [").append(strFluctDotRight).append("], 오른, ").
			append(strExpectDotLeft).append(", 쩜, [").append(strExpectDotRight).append("], 포인트 입니다.");
		}else if(m_strExpectFlucBit.equals("2")){	//상한가
			sb.append("예상 종합 주가지수는").append("상한가인").
			append(strExpectDotLeft).append(", 쩜, [").append(strExpectDotRight).append("], 포인트 입니다.");
		}else if(m_strExpectFlucBit.equals("3")){	//기세상승
			sb.append("예상 종합 주가지수는").append("기세상승인").
			append(strExpectDotLeft).append(", 쩜, [").append(strExpectDotRight).append("], 포인트 입니다.");
		}else if(m_strExpectFlucBit.equals("4")){	//기세상한
			sb.append("예상 종합 주가지수는").append("기세상한인").
			append(strExpectDotLeft).append(", 쩜, [").append(strExpectDotRight).append("], 포인트 입니다.");
		}else if(m_strExpectFlucBit.equals("5")){	//내린
			sb.append("예상 종합 주가지수는").append(strFluctDotLeft).append(", 쩜, [").append(strFluctDotRight).append("], 내린").
			append(strExpectDotLeft).append(", 쩜, [").append(strExpectDotRight).append("], 포인트 입니다.");
		}else if(m_strExpectFlucBit.equals("6")){	//하한가
			sb.append("예상 종합 주가지수는").append("하한가인").
			append(strExpectDotLeft).append(", 쩜, [").append(strExpectDotRight).append("], 포인트 입니다.");
		}else if(m_strExpectFlucBit.equals("7")){	//기세하락
			sb.append("예상 종합 주가지수는").append("기세하락인").
			append(strExpectDotLeft).append(", 쩜, [").append(strExpectDotRight).append("], 포인트 입니다.");
		}else if(m_strExpectFlucBit.equals("8")){	//기세하한
			sb.append("예상 종합 주가지수는").append("기세하한인").
			append(strExpectDotLeft).append(", 쩜, [").append(strExpectDotRight).append("], 포인트 입니다.");
		}else if(m_strExpectFlucBit.equals("9")){	//거래없음
			sb.append("예상 종합 주가지수는").append("보합인").
			append(strExpectDotLeft).append(", 쩜, [").append(strExpectDotRight).append("], 포인트 입니다.");
		}else{
			actionAPI.setSessionData("ment", "error");
		}
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
