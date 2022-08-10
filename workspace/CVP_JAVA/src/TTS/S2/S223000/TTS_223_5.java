package TTS.S2.S223000;

import java.util.Hashtable;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_223_5 extends ActionElementBase{
	@Override
	public void doAction(String arg0, ActionElementData actionAPI) throws AudiumException {
		String m_strStockPriceFluctFlag = (String) actionAPI.getSessionData("m_strStockPriceFluctFlag");        //코스피200지수 전일대비구분
		String m_strStockPriceFluctAmt = (String) actionAPI.getSessionData("m_strStockPriceFluctAmt");	      //코스피200지수 전일대비
		String m_strStockPriceCurrentAmt = (String) actionAPI.getSessionData("m_strStockPriceCurrentAmt");	  //코스피200지수 현재가
		String m_strStockPriceVol = (String) actionAPI.getSessionData("m_strStockPriceVol");		              //코스피200지수 거래량
		String m_strStockPriceTrdAmt = (String) actionAPI.getSessionData("m_strStockPriceTrdAmt");		      //코스피200지수 거래대금
		String m_strStockPriceUpCnt = (String) actionAPI.getSessionData("m_strStockPriceUpCnt");		          //코스피200지수 상승종목 개수
		m_strStockPriceUpCnt = trimNum(m_strStockPriceUpCnt);
		String m_strStockPriceDnCnt = (String) actionAPI.getSessionData("m_strStockPriceDnCnt");		          //코스피200지수 하락종목 개수
		m_strStockPriceDnCnt = trimNum(m_strStockPriceDnCnt);
		String m_strStockPriceUnChgCnt = (String) actionAPI.getSessionData("m_strStockPriceUnChgCnt");		  //코스피200지수 보합종목 개수
		m_strStockPriceUnChgCnt = trimNum(m_strStockPriceUnChgCnt);
		String m_strStockPriceUpLimitCnt = (String) actionAPI.getSessionData("m_strStockPriceUpLimitCnt");	  //코스피200지수 상한가종목 개수
		m_strStockPriceUpLimitCnt = trimNum(m_strStockPriceUpLimitCnt);
		String m_strStockPriceDnLimitCnt = (String) actionAPI.getSessionData("m_strStockPriceDnLimitCnt");	  //코스피200지수 하한가 종목 개수
		m_strStockPriceDnLimitCnt = trimNum(m_strStockPriceDnLimitCnt);

		// [코스피200지수 거래량 계산]
		m_strStockPriceVol = trimNum(m_strStockPriceVol);
		long l_m_strStockPriceVol = Long.parseLong(m_strStockPriceVol) * 1000;
		m_strStockPriceVol = String.valueOf(l_m_strStockPriceVol);
		// [코스피200지수 거래대금 계산]
		m_strStockPriceTrdAmt = trimNum(m_strStockPriceTrdAmt); 
		Long m_lStockPriceTrdAmt3 = Long.parseLong(m_strStockPriceTrdAmt) * 1000000;
		m_strStockPriceTrdAmt = m_lStockPriceTrdAmt3.toString();
		
		// [코스피200지수  전일 대비 계산] 
		// 소수점 자리수를 가져온다. 
		int strFluctDotIndex3 = m_strStockPriceFluctAmt.indexOf(".");
		// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
		String strFluctDotLeft3 = m_strStockPriceFluctAmt.substring(0, strFluctDotIndex3);
		// 앞에 0이 있으면 없앤다.
		strFluctDotLeft3 = trimNum(strFluctDotLeft3);
		// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
		String strFluctDotRight3 = m_strStockPriceFluctAmt.substring(strFluctDotIndex3+1);
		// [코스닥지수 현재가 계산]
		// 소수점 자리수를 가져온다. 
		int strCurrentDotIndex3 = m_strStockPriceCurrentAmt.indexOf(".");
		// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
		String strCurrentDotLeft3 = m_strStockPriceCurrentAmt.substring(0, strCurrentDotIndex3);
		// 앞에 0이 있으면 없앤다.
		strCurrentDotLeft3 = trimNum(strCurrentDotLeft3);
		// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
		String strCurrentDotRight3 = m_strStockPriceCurrentAmt.substring(strCurrentDotIndex3+1);
		
		StringBuffer sb = new StringBuffer();
		sb.append(",코스피 200 지수는, ");
	
		if(m_strStockPriceFluctFlag.equals("0")){			//보합
			sb.append(", 보합인 , ")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트  , ").append(", 이고, ")
			.append(", 거래량은 , " ).append(m_strStockPriceVol).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은 , ").append(m_strStockPriceTrdAmt).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag.equals("1")){	//오른
			sb.append(strFluctDotLeft3).append(", 쩜, [").append(strFluctDotRight3).append("], 포인트, ")
			.append(", 오른  , ")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , 이고,")
			.append(", 거래량은 , " ).append(m_strStockPriceVol).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은 , ").append(m_strStockPriceTrdAmt).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag.equals("2")){	//상한가
			sb.append(", 상한가로 , ")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , 이고,")
			.append(", 거래량은 , " ).append(m_strStockPriceVol).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은 , ").append(m_strStockPriceTrdAmt).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag.equals("3")){	//기세상승
			sb.append(", 기세상승, 으로, ")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , 이고,")
			.append(", 거래량은, " ).append(m_strStockPriceVol).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은, ").append(m_strStockPriceTrdAmt).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag.equals("4")){	//기세상한
			sb.append(", 기세상한, 으로, ")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , 이고,")
			.append(", 거래량은, " ).append(m_strStockPriceVol).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은, ").append(m_strStockPriceTrdAmt).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag.equals("5")){	//내린
			sb.append(strFluctDotLeft3).append(", 쩜, [").append(strFluctDotRight3).append("], 포인트, ")
			.append(", 내린 , ")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , 이고,")
			.append(", 거래량은, " ).append(m_strStockPriceVol).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은, ").append(m_strStockPriceTrdAmt).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag.equals("6")){	//하한가
			sb.append(", 하한가로,")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , 이고,")
			.append(", 거래량은, " ).append(m_strStockPriceVol).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은, ").append(m_strStockPriceTrdAmt).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag.equals("7")){	//기세하락
			sb.append(", 기세하락, 으로,")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , 이고,")
			.append(", 거래량은, " ).append(m_strStockPriceVol).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은, ").append(m_strStockPriceTrdAmt).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag.equals("8")){	//기세하한
			sb.append(", 기세하한, 으로, ")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , 이고,")
			.append(", 거래량은, " ).append(m_strStockPriceVol).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은, ").append(m_strStockPriceTrdAmt).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag.equals("9")){	//거래없음
			sb.append(", 보합인, ")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , ").append(", 이고, ")
			.append(", 거래량은, " ).append(m_strStockPriceVol).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은, ").append(m_strStockPriceTrdAmt).append(",  , ").append(", 원, 입니다.");
		}else{
			actionAPI.setSessionData("ment", "error");
		}
		
		// m_strStockPriceUpCnt  코스닥주가지수 상승종목 유무확인
		if(m_strStockPriceUpCnt.equals("0") || m_strStockPriceUpCnt.equals("") || m_strStockPriceUpCnt.equals(null)){
			sb.append(",상승종목, 없고,");
		}else{
			sb.append(", 상승종목 , ")
			.append(m_strStockPriceUpCnt)
			.append(", 종목, ");
		}
		// m_strStockPriceDnCnt 코스닥주가지수 하락종목 유무확인
		if(m_strStockPriceDnCnt.equals("0") || m_strStockPriceDnCnt.equals("") || m_strStockPriceDnCnt.equals(null)){
			sb.append(",하락종목, 없고,");
		}else{
			sb.append(", 하락종목 , ")
			.append(m_strStockPriceDnCnt)
			.append(", 종목, ");
		}
		// m_strStockPriceUnChgCnt 코스닥주가지수 보합종목 유무확인
		if(m_strStockPriceUnChgCnt.equals("0") || m_strStockPriceUnChgCnt.equals("") || m_strStockPriceUnChgCnt.equals(null)){
			sb.append(",보합종목, 없고,");
		}else{
			sb.append(", 보합종목 , ")
			.append(m_strStockPriceUnChgCnt)
			.append(", 종목, ");
		}
		// m_strStockPriceUpLimitCnt 코스닥주가지수 상한가종목 유무확인
		if(m_strStockPriceUpLimitCnt.equals("0") || m_strStockPriceUpLimitCnt.equals("") || m_strStockPriceUpLimitCnt.equals(null)){
			sb.append(",상한까, 없고,");
		}else{
			sb.append(", 상한까 , ")
			.append(m_strStockPriceUpLimitCnt)
			.append(", 종목, ");
		}
		// m_strStockPriceDnLimitCnt 코스닥주가지수 하한가종목 유무확인
		if(m_strStockPriceDnLimitCnt.equals("0") || m_strStockPriceDnLimitCnt.equals("") || m_strStockPriceDnLimitCnt.equals(null)){
			sb.append(",하한까, 없습니다.");
		}else{
			sb.append(", 하한까 , ")
			.append(m_strStockPriceDnLimitCnt)
			.append(", 종목 , 입니다. ");
		}
		
		actionAPI.setSessionData("ment", sb.toString());
	}
	

	private String convertHour(String hour) {
		// TODO Auto-generated method stub
		if(hour == null || hour.isEmpty()) {
			return "";
		}
		
		int time = Integer.parseInt(hour);
		if(time <= 12){
			return hour;
		}
		
		time = time - 12;
		
		switch (time) {
		case 1:
			hour = "한시";
			break;
		case 2: 
			hour = "두시";
			break;
		case 3:
			hour = "세시";
			break;
		case 4:
			hour = "네시";
			break;
		case 5:
			hour = "다섯시";
			break;
		case 6:
			hour = "여섯시";
			break;
		case 7:
			hour = "일곱시";
			break;
		case 8:
			hour = "여덟시";
			break;
		case 9:
			hour = "아홉시";
			break;
		case 10:
			hour = "열시";
			break;
		case 11:
			hour = "열한시";
			break;
		case 12:
			hour = "열두시";
			break;
		default:
			break;
		}
		
		return hour;
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
