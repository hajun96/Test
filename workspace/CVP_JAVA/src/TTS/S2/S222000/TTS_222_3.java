package TTS.S2.S222000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_222_3 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strExpectFlucBit = (String) actionAPI.getSessionData("m_strExpectFlucBit"); //코스닥주가지수 전일대비구분
		String m_strExpectFluctAmt = (String) actionAPI.getSessionData("m_strExpectFluctAmt");	//예상 코스닥 지수
		String m_strExpectAmt = (String) actionAPI.getSessionData("m_strExpectAmt");	// 코스닥 지수
		String m_strExpectVolume = (String) actionAPI.getSessionData("m_strExpectVolume");	// 예상거래량 유무
		m_strExpectVolume = trimNum(m_strExpectVolume);
		
		
		
		// [코스닥주가지수 코스닥 지수 계산]
		// 소수점 자리수를 가져온다. 
		int strCurrentDotIndex3 = m_strExpectAmt.indexOf(".");
		// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
		String strCurrentDotLeft3 = m_strExpectAmt.substring(0, strCurrentDotIndex3);
		// 앞에 0이 있으면 없앤다.
		strCurrentDotLeft3 = trimNum(strCurrentDotLeft3);
		// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
		String strCurrentDotRight3 = m_strExpectAmt.substring(strCurrentDotIndex3+1);
		

		// [코스닥주가지수 예상 코스닥 지수 계산]
		// 소수점 자리수를 가져온다. 
		int strFluctDotIndex3 = m_strExpectFluctAmt.indexOf(".");
		// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
		String strFluctDotLeft3 = m_strExpectFluctAmt.substring(0, strFluctDotIndex3);
		// 앞에 0이 있으면 없앤다.
		strFluctDotLeft3 = trimNum(strFluctDotLeft3);
		// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
		String strFluctDotRight3 = m_strExpectFluctAmt.substring(strFluctDotIndex3+1);
		
		String m_strStockPriceUpCnt3 = (String) actionAPI.getSessionData("m_strStockPriceUpCnt3");		     //코스닥 상승종목 개수
		m_strStockPriceUpCnt3 = trimNum(m_strStockPriceUpCnt3);
		String m_strStockPriceDnCnt3 = (String) actionAPI.getSessionData("m_strStockPriceDnCnt3");		      //코스닥 하락종목 개수
		m_strStockPriceDnCnt3 = trimNum(m_strStockPriceDnCnt3);
		String m_strStockPriceUnChgCnt3 = (String) actionAPI.getSessionData("m_strStockPriceUnChgCnt3");		//코스닥 보합종목 개수
		m_strStockPriceUnChgCnt3 = trimNum(m_strStockPriceUnChgCnt3);
		String m_strStockPriceUpLimitCnt3 = (String) actionAPI.getSessionData("m_strStockPriceUpLimitCnt3");		//코스닥 상한가종목 개수
		m_strStockPriceUpLimitCnt3 = trimNum(m_strStockPriceUpLimitCnt3);
		String m_strStockPriceDnLimitCnt3 = (String) actionAPI.getSessionData("m_strStockPriceDnLimitCnt3");		//코스닥 하한가 종목 개수
		m_strStockPriceDnLimitCnt3 = trimNum(m_strStockPriceDnLimitCnt3);
		
		String m_strNowTime = (String) actionAPI.getSessionData("m_strNowTime");               // 현재시간 
		String HH = m_strNowTime.substring(0, 2);	//시
		HH = trimNum(HH);
		String mm = m_strNowTime.substring(2, 4);	//분
		mm = trimNum(mm);
		
        StringBuffer sb = new StringBuffer();
		
		
		sb.append(HH).append("시, ")
		.append(mm).append(", 분, ")
		.append(", 현재, ");
		
		
		if(m_strExpectFlucBit.equals("0")){			//보합
			sb.append(", 예상 코스닥 주가지수는, ").append(", 보합인, ").append(", , ").
			append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트이고,  ");
		}else if(m_strExpectFlucBit.equals("1")){	//오른
			sb.append(", 예상 코스닥 주가지수는, ").append(strFluctDotLeft3).append(", 점, [").append(strFluctDotRight3).append("], 오른, ").
			append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트이고,  ");
		}else if(m_strExpectFlucBit.equals("2")){	//상한가
			sb.append(", 예상 코스닥 주가지수는, ").append(", 상한가인, ").append(", , ").
			append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트이고, ");
		}else if(m_strExpectFlucBit.equals("3")){	//기세상승
			sb.append(", 예상 코스닥 주가지수는, ").append(", 기세상승인, ").append(", , ").
			append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트이고, ");
		}else if(m_strExpectFlucBit.equals("4")){	//기세상한
			sb.append(", 예상 코스닥 주가지수는, ").append(", 기세상한인, ").append(", , ").
			append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트이고, ");
		}else if(m_strExpectFlucBit.equals("5")){	//내린
			sb.append(", 예상 코스닥 주가지수는, ").append(strFluctDotLeft3).append(", 점, [").append(strFluctDotRight3).append(",] 내린, ").
			append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트이고, ");
		}else if(m_strExpectFlucBit.equals("6")){	//하한가
			sb.append(", 예상 코스닥 주가지수는, ").append(", 하한가인, ").append(", , ").
			append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트이고, ");
		}else if(m_strExpectFlucBit.equals("7")){	//기세하락
			sb.append(", 예상 코스닥 주가지수는, ").append(", 기세하락인, ").append(", , ").
			append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트이고, ");
		}else if(m_strExpectFlucBit.equals("8")){	//기세하한
			sb.append(", 예상 코스닥 주가지수는, ").append(", 기세하한인, ").append(", , ").
			append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트이고, ");
		}else if(m_strExpectFlucBit.equals("9")){	//거래없음
			sb.append(", 예상 코스닥 주가지수는, ").append(" ,보합인, ").append(", , ").
			append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트이고, ");
		}else{
			actionAPI.setSessionData("ment", "error");
		}
		
		
		if(m_strExpectVolume != null && Integer.parseInt(m_strExpectVolume) > 0) {
			sb.append(" 예상 거래량은,").append(m_strExpectVolume).append(", 주, 입니다.");
		} else {
			sb.append(" 예상 거래량은, 없습니다.");
		}
		
		
		// m_strStockPriceUpCnt3 코스닥주가지수 상승종목 유무확인
		if(m_strStockPriceUpCnt3.equals("0") || m_strStockPriceUpCnt3.equals("") || m_strStockPriceUpCnt3.equals(null)){
		sb.append(",상승종목, 없고,");
		}else{
			sb.append(", 상승종목 , ")
		.append(m_strStockPriceUpCnt3)
		.append(", 종목, ");
		}
		// m_strStockPriceDnCnt3 코스닥주가지수 하락종목 유무확인
		if(m_strStockPriceDnCnt3.equals("0") || m_strStockPriceDnCnt3.equals("") || m_strStockPriceDnCnt3.equals(null)){
		sb.append(",하락종목, 없고,");
		}else{
			sb.append(", 하락종목 , ")
		.append(m_strStockPriceDnCnt3)
		.append(", 종목, ");
		}

	    // m_strStockPriceUnChgCnt3 코스닥주가지수 보합종목 유무확인
		if(m_strStockPriceUnChgCnt3.equals("0") || m_strStockPriceUnChgCnt3.equals("") || m_strStockPriceUnChgCnt3.equals(null)){
			sb.append(",보합종목, 없고,");
		}else{
			sb.append(", 보합종목 , ")
			.append(m_strStockPriceUnChgCnt3)
			.append(", 종목, ");
		}
		// m_strStockPriceUpLimitCnt3 코스닥주가지수 상한가종목 유무확인
		if(m_strStockPriceUpLimitCnt3.equals("0") || m_strStockPriceUpLimitCnt3.equals("") || m_strStockPriceUpLimitCnt3.equals(null)){
			sb.append(",상한까, 없고,");
		}else{
			sb.append(", 상한까 , ")
			.append(m_strStockPriceUpLimitCnt3)
			.append(", 종목, ");
		}
		// m_strStockPriceDnLimitCnt3 코스닥주가지수 하한가종목 유무확인
		if(m_strStockPriceDnLimitCnt3.equals("0") || m_strStockPriceDnLimitCnt3.equals("") || m_strStockPriceDnLimitCnt3.equals(null)){
			sb.append(",하한까, 없습니다.,");
		}else{
			sb.append(", 하한까 , ")
			.append(m_strStockPriceDnLimitCnt3)
			.append(", 종목, 입니다., ");
		}

		actionAPI.setSessionData("ment", sb.toString());
		
	}
	
	private String convertHour(String HH) {
		// TODO Auto-generated method stub
		if(HH == null || HH.isEmpty()) {
			return "";
		}
		
		int time = Integer.parseInt(HH);
		if(time <= 12){
			return HH;
		}
		
		time = time - 12;
		
		switch (time) {
		case 1:
			HH = "한시";
			break;
		case 2: 
			HH = "두시";
			break;
		case 3:
			HH = "세시";
			break;
		case 4:
			HH = "네시";
			break;
		case 5:
			HH = "다섯시";
			break;
		case 6:
			HH = "여섯시";
			break;
		case 7:
			HH = "일곱시";
			break;
		case 8:
			HH = "여덟시";
			break;
		case 9:
			HH = "아홉시";
			break;
		case 10:
			HH = "열시";
			break;
		case 11:
			HH = "열한시";
			break;
		case 12:
			HH = "열두시";
			break;
		default:
			break;
		}
		
		return HH;
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
