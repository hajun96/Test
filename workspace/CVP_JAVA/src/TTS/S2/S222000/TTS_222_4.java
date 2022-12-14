package TTS.S2.S222000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_222_4 extends ActionElementBase {
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strStockPriceFluctFlag3 = (String) actionAPI.getSessionData("m_strStockPriceFluctFlag3"); //코스닥주가지수 전일대비구분
		String m_strStockPriceFluctAmt3 = (String) actionAPI.getSessionData("m_strStockPriceFluctAmt3");	//코스닥주가지수 전일대비
		String m_strStockPriceCurrentAmt3 = (String) actionAPI.getSessionData("m_strStockPriceCurrentAmt3");	  //코스닥주가지수 현재가
		String m_strStockPriceVol3 = (String) actionAPI.getSessionData("m_strStockPriceVol3");		//코스닥주가지수 거래량
		String m_strStockPriceTrdAmt3 = (String) actionAPI.getSessionData("m_strStockPriceTrdAmt3");		//코스닥주가지수 거래대금
		String m_strStockPriceUpCnt3 = (String) actionAPI.getSessionData("m_strStockPriceUpCnt3");		//코스닥주가지수 상승종목 개수
		m_strStockPriceUpCnt3 = trimNum(m_strStockPriceUpCnt3);
		String m_strStockPriceDnCnt3 = (String) actionAPI.getSessionData("m_strStockPriceDnCnt3");		//코스닥주가지수 하락종목 개수
		m_strStockPriceDnCnt3 = trimNum(m_strStockPriceDnCnt3);
		String m_strStockPriceUnChgCnt3 = (String) actionAPI.getSessionData("m_strStockPriceUnChgCnt3");		//코스닥주가지수 보합종목 개수
		m_strStockPriceUnChgCnt3 = trimNum(m_strStockPriceUnChgCnt3);
		String m_strStockPriceUpLimitCnt3 = (String) actionAPI.getSessionData("m_strStockPriceUpLimitCnt3");		//코스닥주가지수 상한가종목 개수
		m_strStockPriceUpLimitCnt3 = trimNum(m_strStockPriceUpLimitCnt3);
		String m_strStockPriceDnLimitCnt3 = (String) actionAPI.getSessionData("m_strStockPriceDnLimitCnt3");		//코스닥주가지수 하한가 종목 개수
		m_strStockPriceDnLimitCnt3 = trimNum(m_strStockPriceDnLimitCnt3);
		
		String m_strStockPriceFluctFlag0 = (String) actionAPI.getSessionData("m_strStockPriceFluctFlag0");     //종합주가지수 전일대비구분
		String m_strStockPriceFluctAmt0 = (String) actionAPI.getSessionData("m_strStockPriceFluctAmt0");	   //종합주가지수 전일대비
		String m_strStockPriceCurrentAmt0 = (String) actionAPI.getSessionData("m_strStockPriceCurrentAmt0");//종합주가지수 현재가
		
		
		String m_strNowTime = (String) actionAPI.getSessionData("m_strNowTime");               // 현재시간
		
		// 현재시간 계산
		String HH = m_strNowTime.substring(0, 2);	//시
		HH = trimNum(HH);
		String mm = m_strNowTime.substring(2, 4);	//분
		mm = trimNum(mm);
		
		
		
		// [코스닥주가지수 전일 대비 계산] 
		// 소수점 자리수를 가져온다. 
		int strFluctDotIndex3 = m_strStockPriceFluctAmt3.indexOf(".");
		// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
		String strFluctDotLeft3 = m_strStockPriceFluctAmt3.substring(0, strFluctDotIndex3);
		// 앞에 0이 있으면 없앤다.
		strFluctDotLeft3 = trimNum(strFluctDotLeft3);
		// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
		String strFluctDotRight3 = m_strStockPriceFluctAmt3.substring(strFluctDotIndex3+1);
			
		// [코스닥주가지수 현재가 계산]
		// 소수점 자리수를 가져온다. 
		int strCurrentDotIndex3 = m_strStockPriceCurrentAmt3.indexOf(".");
		// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
		String strCurrentDotLeft3 = m_strStockPriceCurrentAmt3.substring(0, strCurrentDotIndex3);
		// 앞에 0이 있으면 없앤다.
		strCurrentDotLeft3 = trimNum(strCurrentDotLeft3);
		// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
		String strCurrentDotRight3 = m_strStockPriceCurrentAmt3.substring(strCurrentDotIndex3+1);
		// [코스닥주가지수 거래량 계산]
		m_strStockPriceVol3 = trimNum(m_strStockPriceVol3);
		long l_m_strStockPriceVol3 = Long.parseLong(m_strStockPriceVol3) * 1000;
		m_strStockPriceVol3 = String.valueOf(l_m_strStockPriceVol3);
		// [코스닥주가지수 거래대금 계산]
		m_strStockPriceTrdAmt3 = trimNum(m_strStockPriceTrdAmt3); 
		Long m_lStockPriceTrdAmt3 = Long.parseLong(m_strStockPriceTrdAmt3) * 1000000;
		m_strStockPriceTrdAmt3 = String.valueOf(m_lStockPriceTrdAmt3);
		
		
		
		// [종합주가지수 전일 대비 계산] 
		// 소수점 자리수를 가져온다. 
		int strFluctDotIndex0 = m_strStockPriceFluctAmt0.indexOf(".");
		// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
		String strFluctDotLeft0 = m_strStockPriceFluctAmt0.substring(0, strFluctDotIndex0);
		// 앞에 0이 있으면 없앤다.
		strFluctDotLeft0 = trimNum(strFluctDotLeft0);
		// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
		String strFluctDotRight0 = m_strStockPriceFluctAmt0.substring(strFluctDotIndex0+1);
		// [코스닥지수 현재가 계산]
		// 소수점 자리수를 가져온다. 
		int strCurrentDotIndex0 = m_strStockPriceCurrentAmt0.indexOf(".");
		// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
		String strCurrentDotLeft0 = m_strStockPriceCurrentAmt0.substring(0, strCurrentDotIndex0);
		// 앞에 0이 있으면 없앤다.
		strCurrentDotLeft0 = trimNum(strCurrentDotLeft3);
		// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
		String strCurrentDotRight0 = m_strStockPriceCurrentAmt0.substring(strCurrentDotIndex0+1);
		

		StringBuffer sb = new StringBuffer();
		sb.append(HH).append("시, ")
		.append(mm).append(", 분, ")
		.append(", 현재, ").append(", 코스닥 , 지수는, ");
		
		if(m_strStockPriceFluctFlag3.equals("0")){			//보합
			sb.append(", 보합인 , ")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트  , ").append(", 이고, ")
			.append(", 거래량은 , " ).append(m_strStockPriceVol3).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은 , ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag3.equals("1")){	//오른
			sb.append(strFluctDotLeft3).append(", 쩜, [").append(strFluctDotRight3).append("], 포인트, ")
			.append(", 오른  , ")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , 이고,")
			.append(", 거래량은 , " ).append(m_strStockPriceVol3).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은 , ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag3.equals("2")){	//상한가
			sb.append(", 상한가로 , ")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , 이고,")
			.append(", 거래량은 , " ).append(m_strStockPriceVol3).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은 , ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag3.equals("3")){	//기세상승
			sb.append(", 기세상승, 으로, ")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , 이고,")
			.append(", 거래량은, " ).append(m_strStockPriceVol3).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은, ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag3.equals("4")){	//기세상한
			sb.append(", 기세상한, 으로, ")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , 이고,")
			.append(", 거래량은, " ).append(m_strStockPriceVol3).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은, ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag3.equals("5")){	//내린
			sb.append(strFluctDotLeft3).append(", 쩜, [").append(strFluctDotRight3).append("], 포인트, ")
			.append(", 내린 , ")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , 이고,")
			.append(", 거래량은, " ).append(m_strStockPriceVol3).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은, ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag3.equals("6")){	//하한가
			sb.append(", 하한가로,")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , 이고,")
			.append(", 거래량은, " ).append(m_strStockPriceVol3).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은, ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag3.equals("7")){	//기세하락
			sb.append(", 기세하락, 으로,")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , 이고,")
			.append(", 거래량은, " ).append(m_strStockPriceVol3).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은, ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag3.equals("8")){	//기세하한
			sb.append(", 기세하한, 으로, ")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , 이고,")
			.append(", 거래량은, " ).append(m_strStockPriceVol3).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은, ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", 원, 입니다.");
		}else if(m_strStockPriceFluctFlag3.equals("9")){	//거래없음
			sb.append(", 보합인, ")
			.append(strCurrentDotLeft3).append(", 쩜 , [").append(strCurrentDotRight3).append("], 포인트 , ").append(", 이고, ")
			.append(", 거래량은, " ).append(m_strStockPriceVol3).append(",  , ").append(", 주, 이며,")
			.append(", 거래대금은, ").append(m_strStockPriceTrdAmt3).append(",  , ").append(", 원, 입니다.");
		}else{
			actionAPI.setSessionData("ment", "error");
		}
		
        // m_strStockPriceUpCnt3 종합주가지수 상승종목 유무확인
		if(m_strStockPriceUpCnt3.equals("0") || m_strStockPriceUpCnt3.equals("") || m_strStockPriceUpCnt3.equals(null)){
			sb.append(",상승종목, 없고,");
		}else{
			sb.append(", 상승종목 , ")
			.append(m_strStockPriceUpCnt3)
			.append(", 종목, ");
		}
		// m_strStockPriceDnCnt3 종합주가지수 하락종목 유무확인
		if(m_strStockPriceDnCnt3.equals("0") || m_strStockPriceDnCnt3.equals("") || m_strStockPriceDnCnt3.equals(null)){
			sb.append(",하락종목, 없고,");
		}else{
			sb.append(", 하락종목 , ")
			.append(m_strStockPriceDnCnt3)
			.append(", 종목, ");
		}
		// m_strStockPriceUnChgCnt3 종합주가지수 보합종목 유무확인
		if(m_strStockPriceUnChgCnt3.equals("0") || m_strStockPriceUnChgCnt3.equals("") || m_strStockPriceUnChgCnt3.equals(null)){
			sb.append(",보합종목, 없고,");
		}else{
			sb.append(", 보합종목 , ")
			.append(m_strStockPriceUnChgCnt3)
			.append(", 종목, ");
		}
		// m_strStockPriceUpLimitCnt3 종합주가지수 상한가종목 유무확인
		if(m_strStockPriceUpLimitCnt3.equals("0") || m_strStockPriceUpLimitCnt3.equals("") || m_strStockPriceUpLimitCnt3.equals(null)){
			sb.append(",상한까, 없고,");
		}else{
			sb.append(", 상한까 , ")
			.append(m_strStockPriceUpLimitCnt3)
			.append(", 종목, ");
		}
		// m_strStockPriceDnLimitCnt3 종합주가지수 하한가종목 유무확인
		if(m_strStockPriceDnLimitCnt3.equals("0") || m_strStockPriceDnLimitCnt3.equals("") || m_strStockPriceDnLimitCnt3.equals(null)){
			sb.append(",하한까, 없으며,");
		}else{
			sb.append(", 하한까 , ")
			.append(m_strStockPriceDnLimitCnt3)
			.append(", 종목 이며, ");
		}
		
		sb.append(", 종합, 주가, 지수는, 전일대비, ");

		// 종합 주가지수
		if(m_strStockPriceFluctFlag0.equals("0")){			//보합
			sb.append(", 보합인 , ")
			.append(strCurrentDotLeft0).append(", 쩜 , [").append(strCurrentDotRight0).append("], 포인트  , ").append(", 입니다. ");
		}else if(m_strStockPriceFluctFlag0.equals("1")){	//오른
			sb.append(strFluctDotLeft0).append(", 쩜, [").append(strFluctDotRight0).append("], 포인트, ")
			.append(", 오른  , ")
			.append(strCurrentDotLeft0).append(", 쩜 , [").append(strCurrentDotRight0).append("], 포인트 , 입니다.");
		}else if(m_strStockPriceFluctFlag0.equals("2")){	//상한가
			sb.append(", 상한가로 , ")
			.append(strCurrentDotLeft0).append(", 쩜 , [").append(strCurrentDotRight0).append("], 포인트 , 입니다.");
		}else if(m_strStockPriceFluctFlag0.equals("3")){	//기세상승
			sb.append(", 기세상승으로 , ")
			.append(strCurrentDotLeft0).append(", 쩜 , [").append(strCurrentDotRight0).append("], 포인트 , 입니다.");
		}else if(m_strStockPriceFluctFlag0.equals("4")){	//기세상한
			sb.append(", 기세상한으로 , ")
			.append(strCurrentDotLeft0).append(", 쩜 , [").append(strCurrentDotRight0).append("], 포인트 , 입니다.");
		}else if(m_strStockPriceFluctFlag0.equals("5")){	//내린
			sb.append(strFluctDotLeft0).append(", 쩜, [").append(strFluctDotRight0).append("], 포인트, ")
			.append(", 내린 , ")
			.append(strCurrentDotLeft0).append(", 쩜 , [").append(strCurrentDotRight0).append("], 포인트 , 입니다.");
		}else if(m_strStockPriceFluctFlag0.equals("6")){	//하한가
			sb.append(", 하한가로,")
			.append(strCurrentDotLeft0).append(", 쩜 , [").append(strCurrentDotRight0).append("], 포인트 , 입니다.");
		}else if(m_strStockPriceFluctFlag0.equals("7")){	//기세하락
			sb.append(", 기세하락으로,")
			.append(strCurrentDotLeft0).append(", 쩜 , [").append(strCurrentDotRight0).append("], 포인트 , 입니다.");
		}else if(m_strStockPriceFluctFlag0.equals("8")){	//기세하한
			sb.append(", 기세하한으로,")
			.append(strCurrentDotLeft0).append(", 쩜 , [").append(strCurrentDotRight0).append("], 포인트 , 입니다.");
		}else if(m_strStockPriceFluctFlag0.equals("9")){	//거래없음
			sb.append(", 보합인 , ")
			.append(strCurrentDotLeft0).append(", 쩜 , [").append(strCurrentDotRight0).append("], 포인트  , ").append(", 입니다. ");
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