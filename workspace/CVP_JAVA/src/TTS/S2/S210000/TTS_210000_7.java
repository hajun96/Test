package TTS.S2.S210000;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_210000_7 extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat format = new SimpleDateFormat("HHmm");
		Date today = new Date();
		
		String nowTime = format.format(today);
		
		String m_strCurrentFluctFlag = (String) actionAPI.getSessionData("m_strCurrentFluctFlag"); // 전일대배구분 비교
		String m_strCurrentFluctAmt = (String) actionAPI.getSessionData("m_strCurrentFluctAmt");   // 전일대비구분 
		String m_strCurrentAmt = (String) actionAPI.getSessionData("m_strCurrentAmt");             // 전일대비구분 거래량
		String m_strCurrentVolume = (String) actionAPI.getSessionData("m_strCurrentVolume");
		
		

		m_strCurrentFluctFlag = trimNum(m_strCurrentFluctFlag);
		m_strCurrentFluctAmt = trimNum(m_strCurrentFluctAmt);
		m_strCurrentAmt = trimNum(m_strCurrentAmt);
		m_strCurrentVolume = trimNum(m_strCurrentVolume);

		
		
		StringBuffer sb = new StringBuffer();
		if(m_strCurrentFluctFlag.equals("0")) { // 보합인
			sb.append(", 전일대비, 보합인, ").append(m_strCurrentAmt).append(", ,").append("원,").append(", 거래량은,").append(m_strCurrentVolume).append(", ,").append(", 주로 금일종가 마감 되었습니다. ,");
		} else if(m_strCurrentFluctFlag.equals("1")){ //오른
			sb.append(", 전일대비 ,").append(m_strCurrentFluctAmt).append(", ,").append("원, 오른,").append(m_strCurrentAmt).append(", ,").append("원,")
			.append(", 거래량은,").append(m_strCurrentVolume).append(", ,").append(", 주로 금일종가 마감 되었습니다. ,");
		} else if(m_strCurrentFluctFlag.equals("2")){ // 상한가로
			sb.append(",전일대비,").append(m_strCurrentFluctAmt).append(", ,").append("원, 오른, 상한까로,")
			.append(m_strCurrentAmt).append(", ,").append("원,").append(", 거래량은,").append(m_strCurrentVolume).append(", ,").append(", 주로 금일종가 마감 되었습니다. ,");
		} else if(m_strCurrentFluctFlag.equals("3")){ // 기세상승
			sb.append(", 전일대비,").append(m_strCurrentFluctAmt).append(", ,").append("원, 오른, 기세상승으로,")
			.append(m_strCurrentAmt).append(", ,").append("원,").append(", 거래량은,").append(m_strCurrentVolume).append(", ,").append(", 주로 금일종가 마감 되었습니다. ,");
		} else if(m_strCurrentFluctFlag.equals("4")){ // 기세상한
			sb.append(", 전일대비,").append(m_strCurrentFluctAmt).append(", ,").append("원, 오른, 기세상한으로,")
			.append(m_strCurrentAmt).append(", ,").append("원,").append(", 거래량은,").append(m_strCurrentVolume).append(", ,").append(",주로 금일종가 마감 되었습니다. ,");		
		} else if(m_strCurrentFluctFlag.equals("5")){ // 내린
			sb.append(", 전일대비,").append(m_strCurrentFluctAmt).append(", ,").append("원, 내린,").append(m_strCurrentAmt).append(", ,").append("원,").append(", 거래량은,").append(m_strCurrentVolume).append(", ,").append(", 주로 금일종가 마감 되었습니다. ,");
		} else if(m_strCurrentFluctFlag.equals("6")) { // 하한가로
			sb.append(", 전일대비,").append(m_strCurrentFluctAmt).append(", ,").append("원, 내린, 하한까로,").
			append(m_strCurrentAmt).append(", ,").append("원,").append(", 거래량은,").append(m_strCurrentVolume).append(", ,").append(", 주로 금일종가 마감 되었습니다. ,");		
		} else if(m_strCurrentFluctFlag.equals("7")) { // 기세하락으로
			sb.append(", 전일대비,").append(m_strCurrentFluctAmt).append(", ,").append("원, 내린, 기세하락으로,").
			append(m_strCurrentAmt).append(", ,").append("원,").append(", 거래량은,").append(m_strCurrentVolume).append(", ,").append(", 주로 금일종가 마감 되었습니다. ,");
		} else if(m_strCurrentFluctFlag.equals("8")) { //기세하한으로
			sb.append(", 전일대비,").append(m_strCurrentFluctAmt).append(", ,").append("원, 내린, 기세하한으로,").
			append(m_strCurrentAmt).append(", ,").append("원,").append(", 거래량은,").append(m_strCurrentVolume).append(", ,").append(", 주로 금일종가 마감 되었습니다. ,");
		} else if(m_strCurrentFluctFlag.equals("9")) { //거래없음
			sb.append(", 전일대비, 보합인, ").append(m_strCurrentAmt).append(", ,").append("원,").append(", 거래량은,").append(m_strCurrentVolume).append(", ,").append(", 주로 금일종가 마감 되었습니다. ,");
		}
		
		
		
		String m_strSelectStartTime2 = (String) actionAPI.getSessionData("m_strSelectStartTime2");
		String m_strSelectEndTime2 = (String) actionAPI.getSessionData("m_strSelectEndTime2");
		String m_strOfferVol = (String) actionAPI.getSessionData("m_strOfferVol11");
		String m_strBidVol = (String) actionAPI.getSessionData("m_strBidVol11");
		
		
		m_strOfferVol = trimNum(m_strOfferVol);
		m_strBidVol = trimNum(m_strBidVol);
		
		
		
		if (Integer.parseInt(nowTime) < Integer.parseInt(m_strSelectEndTime2)) {
			if(Integer.parseInt(m_strOfferVol) > 0) { // 시간외 매도물량
				sb.append("시간외 매도물량은,").append(m_strOfferVol).append(", ,").append(",주,");
			} else {
				sb.append("시간외 매도물량은, 없고,");
			}
			
			if(Integer.parseInt(m_strBidVol) > 0) { // 시간외 매수잔량
				sb.append("시간외 매수물량은,").append(m_strBidVol).append(", ,").append(",주, 입니다.");
			} else {
				sb.append("시간외 매수물량은 없습니다.");
			}
			
			
			String m_strOpenAmt = (String) actionAPI.getSessionData("m_strOpenAmt"); // 시가
			String m_strHighAmt = (String) actionAPI.getSessionData("m_strHighAmt"); // 고가
			String m_strLowAmt = (String) actionAPI.getSessionData("m_strLowAmt"); // 저가
			
			m_strOpenAmt = trimNum(m_strOpenAmt);
			m_strHighAmt = trimNum(m_strHighAmt);
			m_strLowAmt = trimNum(m_strLowAmt);
			
			if(m_strOpenAmt != null && Integer.parseInt(m_strOpenAmt) > 0) {
				sb.append(", 시까,").append(m_strOpenAmt).append(", ,").append(", 원,");
			} else {
				sb.append(", 시까, 없고,");
			}
			
			if(m_strHighAmt != null && Integer.parseInt(m_strHighAmt) > 0) {
				sb.append(", 고까,").append(m_strHighAmt).append(", ,").append(",원,");
			} else {
				sb.append(", 고까, 없고,");
			}
			
			if(m_strLowAmt != null && Integer.parseInt(m_strLowAmt) > 0) {
				sb.append(", 저까,").append(m_strLowAmt).append(", ,").append(",원, 입니다.");
			} else {
				sb.append(", 저까, 없습니다.");
			}
			
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