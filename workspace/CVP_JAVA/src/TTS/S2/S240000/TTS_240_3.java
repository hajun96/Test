package TTS.S2.S240000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_240_3 extends ActionElementBase {
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strGiftFluctFlag = (String) actionAPI.getSessionData("m_strGiftFluctFlag"); //전일대비구분
		String m_strGiftYear = (String) actionAPI.getSessionData("m_strGiftYear"); //년 
		String m_strGiftItemCode = (String) actionAPI.getSessionData("m_strGiftItemCode"); //월
		String m_strGiftFluctAmt = (String) actionAPI.getSessionData("m_strGiftFluctAmt"); //전일대비
		String m_strGiftCurrentAmt = (String) actionAPI.getSessionData("m_strGiftCurrentAmt"); //현재가
		String m_strGiftVol = (String) actionAPI.getSessionData("m_strGiftVol"); //거래량

		// [전일 대비 계산] 
		// 소수점 자리수를 가져온다. 
		int strFluctDotIndex = m_strGiftFluctAmt.indexOf(".");
		// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
		String strFluctDotLeft = m_strGiftFluctAmt.substring(0, strFluctDotIndex);
		// 앞에 0이 있으면 없앤다.
		strFluctDotLeft = trimNum(strFluctDotLeft);
		// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
		String strFluctDotRight = m_strGiftFluctAmt.substring(strFluctDotIndex+1);

		
		// [현재가 계산]
		// 소수점 자리수를 가져온다. 
		int strCurrentDotIndex = m_strGiftCurrentAmt.indexOf(".");
		// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
		String strCurrentDotLeft = m_strGiftCurrentAmt.substring(0, strCurrentDotIndex);
		// 앞에 0이 있으면 없앤다.
		strCurrentDotLeft = trimNum(strCurrentDotLeft);
		// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
		String strCurrentDotRight = m_strGiftCurrentAmt.substring(strCurrentDotIndex+1);

		// [거래량 계산]
		m_strGiftVol = trimNum(m_strGiftVol);
		Float f_m_strGiftVol = Float.parseFloat(m_strGiftVol);
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		String m_strGiftOfferAmt = (String) actionAPI.getSessionData("m_strGiftOfferAmt"); //매도호가 (ex : 00256.25)
		m_strGiftOfferAmt = trimNum(m_strGiftOfferAmt);
		Float f_m_strGiftOfferAmt = Float.parseFloat(m_strGiftOfferAmt);
		
		
		String m_strGiftBidAmt = (String) actionAPI.getSessionData("m_strGiftBidAmt"); //매수호가 (ex : 00256.20)
		m_strGiftBidAmt = trimNum(m_strGiftBidAmt);
		Float f_m_strGiftBidAmt = Float.parseFloat(m_strGiftBidAmt);
		
		
		String m_strGiftOfferVol = (String) actionAPI.getSessionData("m_strGiftOfferVol"); //총매도호가잔량 (ex : 000007513)
		m_strGiftOfferVol = trimNum(m_strGiftOfferVol);
		Float f_m_strGiftOfferVol = Float.parseFloat(m_strGiftOfferVol);
		
		String m_strGiftBidVol = (String) actionAPI.getSessionData("m_strGiftBidVol"); //총매수호가잔량 (ex : 000013311)
		m_strGiftBidVol = trimNum(m_strGiftBidVol);
		Float f_m_strGiftBidVol = Float.parseFloat(m_strGiftBidVol);
		
		/*m_strGiftOfferAmt = trimNum(m_strGiftOfferAmt);
		Float f_m_strGiftOfferAmt = Float.parseFloat(m_strGiftOfferAmt);
		m_strGiftBidAmt = trimNum(m_strGiftBidAmt);
		Float f_m_strGiftBidAmt = Float.parseFloat(m_strGiftBidAmt);
		m_strGiftOfferVol = trimNum(m_strGiftOfferVol);
		Float f_m_strGiftOfferVol = Float.parseFloat(m_strGiftOfferVol);
		m_strGiftBidVol = trimNum(m_strGiftBidVol);
		Float f_m_strGiftBidVol = Float.parseFloat(m_strGiftBidVol);*/
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		String m_strGiftOpenAmt = (String) actionAPI.getSessionData("m_strGiftOpenAmt"); //시가 (ex : 00254.60)
		String m_strGiftHighAmt = (String) actionAPI.getSessionData("m_strGiftHighAmt"); //고가 (ex : 00256.60)
		String m_strGiftLowAmt = (String) actionAPI.getSessionData("m_strGiftLowAmt"); //저가 (ex : 00254.30)
		m_strGiftOpenAmt = trimNum(m_strGiftOpenAmt);
		Float f_m_strGiftOpenAmt = Float.parseFloat(m_strGiftOpenAmt);
		m_strGiftHighAmt = trimNum(m_strGiftHighAmt);
		Float f_m_strGiftHighAmt = Float.parseFloat(m_strGiftHighAmt);
		m_strGiftLowAmt = trimNum(m_strGiftLowAmt);
		Float f_m_strGiftLowAmt = Float.parseFloat(m_strGiftLowAmt);
		
		StringBuffer sb = new StringBuffer();
		if(m_strGiftFluctFlag.equals("0")){			//보합
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물의, ")
			.append(", 금일종가, ")
			.append(", 전일대비, ")
			.append(", 보합인, ")
			.append(strCurrentDotLeft)
			.append(", 쩜 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else if(m_strGiftFluctFlag.equals("1")){	//오른
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물의, ")
			.append(", 금일종가, ")
			.append(", 전일대비, ")
			.append(strFluctDotLeft)
			.append(", 쩜, [")
			.append(strFluctDotRight)
			.append("], 포인트, ")
			.append(", 오른, ")
			.append(strCurrentDotLeft)
			.append(", 쩜 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else if(m_strGiftFluctFlag.equals("2")){	//상한가
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물의, ")
			.append(", 금일종가, ")
			.append(", 전일대비, ")
			.append(", 상한가로, ")
			.append(strCurrentDotLeft)
			.append(", 쩜 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else if(m_strGiftFluctFlag.equals("3")){	//기세상승
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물의, ")
			.append(", 금일종가, ")
			.append(", 전일대비, ")
			.append(", 기세상승 으로, ")
			.append(strCurrentDotLeft)
			.append(", 쩜 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else if(m_strGiftFluctFlag.equals("4")){	//기세상한
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물의, ")
			.append(", 금일종가, ")
			.append(", 전일대비, ")
			.append(", 기세상한 으로, ")
			.append(strCurrentDotLeft)
			.append(", 쩜 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else if(m_strGiftFluctFlag.equals("5")){	//내린
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물의, ")
			.append(", 금일종가, ")
			.append(", 전일대비, ")
			.append(strFluctDotLeft)
			.append(", 쩜, [")
			.append(strFluctDotRight)
			.append("], 포인트, ")
			.append(", 내린, ")
			.append(strCurrentDotLeft)
			.append(", 쩜 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else if(m_strGiftFluctFlag.equals("6")){	//하한가
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물의, ")
			.append(", 금일종가, ")
			.append(", 전일대비, ")
			.append(", 하한가로, ")
			.append(strCurrentDotLeft)
			.append(", 점 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else if(m_strGiftFluctFlag.equals("7")){	//기세하락
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물의, ")
			.append(", 금일종가, ")
			.append(", 전일대비, ")
			.append(", 기세하락 으로, ")
			.append(strCurrentDotLeft)
			.append(", 쩜 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else if(m_strGiftFluctFlag.equals("8")){	//기세하한
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물의, ")
			.append(", 금일종가, ")
			.append(", 전일대비, ")
			.append(", 기세하한 으로, ")
			.append(strCurrentDotLeft)
			.append(", 쩜 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else if(m_strGiftFluctFlag.equals("9")){
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물의, ")
			.append(", 금일종가, ")
			.append(", 전일대비, ")
			.append(", 보합인, ")
			.append(strCurrentDotLeft)
			.append(", 쩜 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else{
			sb.append("");
		}
		
		if(f_m_strGiftVol > 0.0){
			sb.append(", 거래량은,  ")
			.append(m_strGiftVol)
			.append(", 계약, ")
			.append(", 입니다.");
		}else{
			sb.append("거래량은, 없습니다.");
		}
		
		//f_m_strGiftOfferAmt //매도호가
		if(f_m_strGiftOfferAmt > 0.0){
			
			sb.append(", 매도호까, ");
			sb.append(makeTTSMent(m_strGiftOfferAmt));
			
//			int strGiftOfferDotIndex = m_strGiftOfferAmt.indexOf(".");
//			String strGiftOfferDotLeft = m_strGiftOfferAmt.substring(0, strGiftOfferDotIndex);
//			strGiftOfferDotLeft = trimNum(strGiftOfferDotLeft);
//			String strGiftOfferDotRight = m_strGiftOfferAmt.substring(strGiftOfferDotIndex+1);
//			strGiftOfferDotRight = trimNum(strGiftOfferDotRight);
//			.append(strGiftOfferDotLeft)
//			.append(", 점, ")
//			.append(strGiftOfferDotRight)
//			.append(", 포인트, ");
		}else{
			sb.append(", 매도호까, ")
			.append(", 없고, ");
		}
		
		//f_m_strGiftBidAmt // 매수호가
		if(f_m_strGiftBidAmt > 0.0){
			
			sb.append(", 매수호까, ");
			sb.append(makeTTSMent(m_strGiftBidAmt));
			
//			int strGiftBidDotIndex = m_strGiftBidAmt.indexOf(".");
//			String strGiftBidDotLeft = m_strGiftBidAmt.substring(0, strGiftBidDotIndex);
//			strGiftBidDotLeft = trimNum(strGiftBidDotLeft);
//			String strGiftBidDotRight = m_strGiftBidAmt.substring(strGiftBidDotIndex+1);
//			strGiftBidDotRight = trimNum(strGiftBidDotRight);
//			
//			.append(strGiftBidDotLeft)
//			.append(", 점, ")
//			.append(strGiftBidDotRight)
//			.append(", 포인트, ");
		}else{
			sb.append(", 매수호까, ")
			.append(", 없고, ");
		}
		
		//f_m_strGiftOfferVol // 총매도잔량
		if(f_m_strGiftOfferVol > 0.0){
			sb.append(", 총 매도 호까잔량, ")
			.append(m_strGiftOfferVol)
			.append(", 계약, ");
		}else{
			sb.append(", 총 매도 호까잔량, ")
			.append(", 없고, ");
		}
		
		//f_m_strGiftBidVol // 총매수잔량
		if(f_m_strGiftBidVol > 0.0){
			sb.append(", 총 매수 호까잔량, ")
			.append(f_m_strGiftBidVol)
			.append(", 계약, ");
		}else{
			sb.append(", 총 매수 호까잔량, ")
			.append(", 없고, ");
		}
		
		//f_m_strGiftOpenAmt // 시가
		if(f_m_strGiftOpenAmt > 0.0){
			
			sb.append(", 시까, ");
			sb.append(makeTTSMent(m_strGiftOpenAmt));
			
//			int strGiftOpenDotIndex = m_strGiftOpenAmt.indexOf(".");
//			String strGiftOpenDotLeft = m_strGiftOpenAmt.substring(0, strGiftOpenDotIndex);
//			strGiftOpenDotLeft = trimNum(strGiftOpenDotLeft);
//			String strGiftOpenDotRight = m_strGiftOpenAmt.substring(strGiftOpenDotIndex+1);
//			strGiftOpenDotRight = trimNum(strGiftOpenDotRight);
//			
//			.append(strGiftOpenDotLeft)
//			.append(", 점, ")
//			.append(strGiftOpenDotRight)
//			.append(", 포인트, ");
		}else{
			sb.append(", 시까, ")
			.append(", 없고, ");
		}
		
		//f_m_strGiftHighAmt // 고가
		if(f_m_strGiftHighAmt > 0.0){
			
			sb.append(", 고까, ");
			sb.append(makeTTSMent(m_strGiftHighAmt));
			
//			int strGiftHighDotIndex = m_strGiftHighAmt.indexOf(".");
//			String strGiftHighDotLeft = m_strGiftHighAmt.substring(0, strGiftHighDotIndex);
//			strGiftHighDotLeft = trimNum(strGiftHighDotLeft);
//			String strGiftHighDotRight = m_strGiftHighAmt.substring(strGiftHighDotIndex+1);
//			strGiftHighDotRight = trimNum(strGiftHighDotRight);
//			
//			.append(strGiftHighDotLeft)
//			.append(", 점, ")
//			.append(strGiftHighDotRight)
//			.append(", 포인트, ");
		}else{
			sb.append(", 고까, ")
			.append(", 없고, ");
		}
		
		//f_m_strGiftLowAmt // 저가
		if(f_m_strGiftLowAmt > 0.0){
			
			sb.append(", 저까, ");
			sb.append(makeTTSMent(m_strGiftLowAmt))
			.append(", 로 금일종가 마감되었습니다 ,");
			
//			int strGiftLowDotIndex = m_strGiftLowAmt.indexOf(".");
//			String strGiftLowDotLeft = m_strGiftLowAmt.substring(0, strGiftLowDotIndex);
//			strGiftLowDotLeft = trimNum(strGiftLowDotLeft);
//			String strGiftLowDotRight = m_strGiftLowAmt.substring(strGiftLowDotIndex+1);
//			strGiftLowDotRight = trimNum(strGiftLowDotRight);
//			
//			.append(strGiftLowDotLeft)
//			.append(", 점, ")
//			.append(strGiftLowDotRight)
//			.append(", 포인트로 , ")
//			.append(", 금일종가 마감되었습니다.");
		}else{
			sb.append(", 저까, ")
			.append("없습니다.");
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
	

	private String makeTTSMent (String str) {
		
		StringBuffer sb = new StringBuffer();
		
		int index = str.indexOf(".");
		
		String leftStr = "";
		String rightStr = "";
		if(index < 0) {
			leftStr = str;
		} else {
			leftStr = str.substring(0, index);
			rightStr = str.substring(index+1);
		}
		
		// 260
		leftStr = trimNum(leftStr);
		sb.append(leftStr);
		if(rightStr.isEmpty() || Integer.parseInt(rightStr) < 1){
			sb.append(", 포인트, ");
		} else {
			// 00
//			rightStr = trimNum(rightStr);
			sb.append(", 쩜, [")
			.append(rightStr)
			.append("], 포인트, ");
		}
		
		return sb.toString();
	}
	
	
}
