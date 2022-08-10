package TTS.S2.S222000;

import java.util.Hashtable;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_222000_5 extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
		
		// TR 통신 후 결과값이 존재하는 Hashtable 을 가져온다.
		Hashtable table = (Hashtable) actionAPI.getSessionData("g_objHostRecv");
		Hashtable tempTable =  (Hashtable) actionAPI.getSessionData("tempTable");
		
		StringBuffer sb = new StringBuffer();
		
		String m_strExpectAmt = (String) actionAPI.getSessionData("m_strExpectAmt");
		String m_strExpectFlucBit = (String) actionAPI.getSessionData("m_strExpectFlucBit");
		String m_strExpectFluctAmt = (String) actionAPI.getSessionData("m_strExpectFluctAmt");
		String m_strExpectVolume = (String) actionAPI.getSessionData("m_strExpectVolume");
		
		
		String m_strStockPriceUpCnt = (String) tempTable.get("A1_UpCnt3");
		String m_strStockPriceDnCnt = (String) tempTable.get("A1_DnCnt3");
		String m_strStockPriceUnChgCnt = (String) tempTable.get("A1_UnchgCnt3"); 
		String m_strStockPriceUpLimitCnt = (String) tempTable.get("A1_UnchgCnt3");
		String m_strStockPriceDnLimitCnt = (String) tempTable.get("A1_DnLimitCnt3");
		
		
		
		String m_strStockPriceFluctAmt_1  = m_strExpectFluctAmt.substring(0, 4);
		String m_strStockPriceFluctAmt_2 = m_strExpectFluctAmt.substring(5);
		m_strStockPriceFluctAmt_1 = trimNum(m_strStockPriceFluctAmt_1);
		
		String m_strStockPriceCurrentAmt_1 = m_strExpectAmt.substring(0, 6);
		String m_strStockPriceCurrentAmt_2 = m_strExpectAmt.substring(7);
		m_strStockPriceCurrentAmt_1 = trimNum(m_strStockPriceCurrentAmt_1);
		
		m_strStockPriceUpCnt = trimNum(m_strStockPriceUpCnt);
		m_strStockPriceDnCnt = trimNum(m_strStockPriceDnCnt);
		m_strStockPriceUnChgCnt = trimNum(m_strStockPriceUnChgCnt);
		m_strStockPriceUpLimitCnt = trimNum(m_strStockPriceUpLimitCnt);
		m_strStockPriceDnLimitCnt = trimNum(m_strStockPriceDnLimitCnt);
		
		
		sb.append(", 예상 코스닥 지수는,");
		
		if(m_strExpectFlucBit.equals("5")) {
			sb.append(m_strStockPriceFluctAmt_1).append(",쩜,[").append(m_strStockPriceFluctAmt_2).append("]");
			sb.append(", 포인트 내린, ");
		} else if(m_strExpectFlucBit.equals("0") || m_strExpectFlucBit.equals("9")) {
			sb.append(", 보합인, ");
		} else if(m_strExpectFlucBit.equals("1")){
			sb.append(m_strStockPriceFluctAmt_1).append(",쩜,[").append(m_strStockPriceFluctAmt_2).append("]");
			sb.append(", 포인트 오른, ");
		} else if(m_strExpectFlucBit.equals("2")){
			sb.append(", 상한까로, ");
		} else if(m_strExpectFlucBit.equals("3")){
			sb.append(", 기세상승으로, ");
		} else if(m_strExpectFlucBit.equals("4")){
			sb.append(", 기세상한으로, ");
		} else if(m_strExpectFlucBit.equals("6")){
			sb.append(", 하한까로, ");
		}else if(m_strExpectFlucBit.equals("7")){
			sb.append(", 기세하락으로, ");
		}else if(m_strExpectFlucBit.equals("8")){
			sb.append(", 기세하한으로, ");
		}
		
		sb.append(m_strStockPriceCurrentAmt_1).append(",쩜,[").append(m_strStockPriceCurrentAmt_2).append("] 포인트 이고 ,");
		
		
		if(m_strExpectVolume != null && Integer.parseInt(m_strExpectVolume) > 0) {
			sb.append(", 예상 거래량은, ").append(m_strExpectVolume).append(",주, 입니다.");
		} else {
			sb.append(", 예상 거래량은 없습니다.");
		}
		
		
		
		if(m_strStockPriceUpCnt != null && Integer.parseInt(m_strStockPriceUpCnt) > 0) {
			sb.append(", 상승종목,").append(m_strStockPriceUpCnt).append(", 종목,");
		} else {
			sb.append(", 상승종목, 없고,");
		}
		
		if(m_strStockPriceDnCnt != null && Integer.parseInt(m_strStockPriceDnCnt) > 0) {
			sb.append(", 하락종목,").append(m_strStockPriceDnCnt).append(", 종목,");
		} else {
			sb.append(", 하락종목, 없고,");
		}
		
		if(m_strStockPriceUnChgCnt != null && Integer.parseInt(m_strStockPriceUnChgCnt) > 0) {
			sb.append(", 보합종목,").append(m_strStockPriceUnChgCnt).append(", 종목,");
		} else {
			sb.append(", 보합종목, 없고,");
		}
		
		if(m_strStockPriceUpLimitCnt != null && Integer.parseInt(m_strStockPriceUpLimitCnt) > 0) {
			sb.append(", 상한까,").append(m_strStockPriceUpLimitCnt).append(", 종목,");
		} else {
			sb.append(", 상한까, 없고,");
		}
		
		if(m_strStockPriceDnLimitCnt != null && Integer.parseInt(m_strStockPriceDnLimitCnt) > 0) {
			sb.append(", 하한까,").append(m_strStockPriceDnLimitCnt).append(", 종목,");
		} else {
			sb.append(", 하한까, 없습니다.");
		}
		
		// 멘트를 만들기 위한 String 데이터를 ment 라는 이름의 Session Data 로 저장한다.
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
