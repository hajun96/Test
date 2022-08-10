package TTS.S2.S240000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_240_2 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		String m_strGiftFluctFlag = (String) actionAPI.getSessionData("m_strGiftFluctFlag"); //전일대비구분
		String m_strGiftYear = (String) actionAPI.getSessionData("m_strGiftYear"); //년 
		String m_strGiftItemCode = (String) actionAPI.getSessionData("m_strGiftItemCode"); //월
		m_strGiftItemCode = trimNum(m_strGiftItemCode);
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
		// 앞에 0이 없으면 없앤다.
		//strFluctDotRight = trimNum(strFluctDotRight);
		
		// [현재가 계산]
		// 소수점 자리수를 가져온다. 
		int strCurrentDotIndex = m_strGiftCurrentAmt.indexOf(".");
		// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
		String strCurrentDotLeft = m_strGiftCurrentAmt.substring(0, strCurrentDotIndex);
		// 앞에 0이 있으면 없앤다.
		strCurrentDotLeft = trimNum(strCurrentDotLeft);
		// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
		String strCurrentDotRight = m_strGiftCurrentAmt.substring(strCurrentDotIndex+1);
		// 앞에 0이 없으면 없앤다.
		//strCurrentDotRight = trimNum(strCurrentDotRight);
		
		// [거래량 계산]
		m_strGiftVol = trimNum(m_strGiftVol);
		Float f_m_strGiftVol = Float.parseFloat(m_strGiftVol);
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		String m_strGiftOfferAmt = (String) actionAPI.getSessionData("m_strGiftOfferAmt"); //매도호가 (ex : 00256.25)
		String m_strGiftBidAmt = (String) actionAPI.getSessionData("m_strGiftBidAmt"); //매수호가 (ex : 00256.20)
		String m_strGiftOfferVol = (String) actionAPI.getSessionData("m_strGiftOfferVol"); //총매도호가잔량 (ex : 000007513)
		String m_strGiftBidVol = (String) actionAPI.getSessionData("m_strGiftBidVol"); //총매수호가잔량 (ex : 000013311)
		
		// 미리 trimNum 하면 .00 일 때 에러 남
		m_strGiftOfferAmt = trimNum(m_strGiftOfferAmt);
		Float f_m_strGiftOfferAmt = Float.parseFloat(m_strGiftOfferAmt);
		
		m_strGiftBidAmt = trimNum(m_strGiftBidAmt);
		Float f_m_strGiftBidAmt = Float.parseFloat(m_strGiftBidAmt);
		
		m_strGiftOfferVol = trimNum(m_strGiftOfferVol);
		Float f_m_strGiftOfferVol = Float.parseFloat(m_strGiftOfferVol);
		m_strGiftBidVol = trimNum(m_strGiftBidVol);
		Float f_m_strGiftBidVol = Float.parseFloat(m_strGiftBidVol);
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		String m_strGiftOpenAmt = (String) actionAPI.getSessionData("m_strGiftOpenAmt"); //시까 (ex : 00254.60)
		String m_strGiftHighAmt = (String) actionAPI.getSessionData("m_strGiftHighAmt"); //고까 (ex : 00256.60)
		String m_strGiftLowAmt = (String) actionAPI.getSessionData("m_strGiftLowAmt"); //저까 (ex : 00254.30)
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
			.append(", 물, 의, ")
			.append(", 현재가는, ")
			.append(", 전일대비, ")
			.append(", 보합인, ")
			.append(strCurrentDotLeft)
			.append(", 점 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else if(m_strGiftFluctFlag.equals("1")){	//오른
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물, 의, ")
			.append(", 현재가는, ")
			.append(", 전일대비, ")
			.append(strFluctDotLeft)
			.append(", 점, [")
			.append(strFluctDotRight)
			.append("], 포인트, ")
			.append(", 오른, ")
			.append(strCurrentDotLeft)
			.append(", 점 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else if(m_strGiftFluctFlag.equals("2")){	//상한가
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물, 의, ")
			.append(", 현재가는, ")
			.append(", 전일대비, ")
			.append(", 상한가로, ")
			.append(strCurrentDotLeft)
			.append(", 점 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else if(m_strGiftFluctFlag.equals("3")){	//기세상승
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물, 의, ")
			.append(", 현재가는, ")
			.append(", 전일대비, ")
			.append(", 기세상승 으로, ")
			.append(strCurrentDotLeft)
			.append(", 점 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else if(m_strGiftFluctFlag.equals("4")){	//기세상한
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물, 의, ")
			.append(", 현재가는, ")
			.append(", 전일대비, ")
			.append(", 기세상한 으로, ")
			.append(strCurrentDotLeft)
			.append(", 점 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else if(m_strGiftFluctFlag.equals("5")){	//내린
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물, 의, ")
			.append(", 현재가는, ")
			.append(", 전일대비, ")
			.append(strFluctDotLeft)
			.append(", 점, [")
			.append(strFluctDotRight)
			.append("], 포인트, ")
			.append(", 내린, ")
			.append(strCurrentDotLeft)
			.append(", 점 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else if(m_strGiftFluctFlag.equals("6")){	//하한가
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물, 의, ")
			.append(", 현재가는, ")
			.append(", 전일대비, ")
			.append(", 하한가로, ")
			.append(strCurrentDotLeft)
			.append(", 점 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else if(m_strGiftFluctFlag.equals("7")){	//기세하락
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물, 의, ")
			.append(", 현재가는, ")
			.append(", 전일대비, ")
			.append(", 기세하락 으로, ")
			.append(strCurrentDotLeft)
			.append(", 점 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else if(m_strGiftFluctFlag.equals("8")){	//기세하한
			sb.append(m_strGiftYear).append(", 년 , ")
			.append(m_strGiftItemCode).append(", 월 , ")
			.append(", 물, 의, ")
			.append(", 현재가는, ")
			.append(", 전일대비, ")
			.append(", 기세하한 으로, ")
			.append(strCurrentDotLeft)
			.append(", 점 , [")
			.append(strCurrentDotRight)
			.append("], 포인트 , ");
		}else{
			actionAPI.setSessionData("ment", "error");
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
			sb.append(", 매도호가, ");
			sb.append(dotNumTTS(m_strGiftOfferAmt, "포인트"));
			
		}else{
			sb.append(", 매도호가, ")
			.append(", 없고, ");
		}
		
		//f_m_strGiftBidAmt // 매수호가
		if(f_m_strGiftBidAmt > 0.0){
			sb.append(", 매수호가, ");
			sb.append(dotNumTTS(m_strGiftBidAmt, "포인트"));
		}else{
			sb.append(", 매수호가, ")
			.append(", 없고, ");
		}
		
		//f_m_strGiftOfferVol // 총매도잔량
		if(f_m_strGiftOfferVol > 0.0){
			sb.append(", 총 매도 호가잔량, ")
			.append(m_strGiftOfferVol)
			.append(", 계약, ");
		}else{
			sb.append(", 총 매도 호가잔량, ")
			.append(", 없고, ");
		}
		
		//f_m_strGiftBidVol // 총매수잔량
		if(f_m_strGiftBidVol > 0.0){
			sb.append(", 총 매수 호가잔량, ")
			.append(m_strGiftBidVol)
			.append(", 계약, ")
			.append(", 입니다., ");
		}else{
			sb.append(", 총 매수 호가잔량, ")
			.append(", 없고, ");
		}
		
		//f_m_strGiftOpenAmt // 시까
		if(f_m_strGiftOpenAmt > 0.0){
			sb.append(", 시까 , ");
			sb.append(dotNumTTS(m_strGiftOpenAmt, "포인트"));
		}else{
			sb.append(", 시까, ")
			.append(", 없고, ");
		}
		
		//f_m_strGiftHighAmt // 고까
		if(f_m_strGiftHighAmt > 0.0){
			sb.append(", 고까, ");
			sb.append(dotNumTTS(m_strGiftHighAmt, "포인트"));
		}else{
			sb.append(", 고까, ")
			.append(", 없고, ");
		}
		
		//f_m_strGiftLowAmt // 저까
		if(f_m_strGiftLowAmt > 0.0){
			sb.append(", 저까 , ");
			sb.append(dotNumTTS(m_strGiftLowAmt, "포인트"));
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
	
	private String dotNumTTS(String str, String unit){
		String leftStr = "";
		String rightStr = "";
		StringBuffer sb = new StringBuffer();
		int index = str.indexOf(".");
		
		if(index < 0) {
			leftStr = str;
		} else {
			leftStr = str.substring(0, index);
			rightStr = str.substring(index+1);
		}
		//자연수 처리
		leftStr = trimNum(leftStr);
		sb.append(leftStr);
		//소수점 밑 2자리 처리
		if(rightStr.equals("00") || rightStr.equals("0") || rightStr.equals("")){
			sb.append(", " + unit + ", ");
		}else{
			String lastStr = rightStr.substring(rightStr.length() - 1);
			if(lastStr.equals("0")){
				rightStr = rightStr.substring(0, 1);
				sb.append(", 쩜, [")
				.append(rightStr)
				.append("], " + unit + ", ");
			}else{
				sb.append(", 쩜, [")
				.append(rightStr)
				.append("], " + unit + ", ");
			}
		}
		return sb.toString();
	}
}
