package TTS.S2.S222000;

import java.util.Hashtable;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_222000_3 extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
		
		// TR 통신 후 결과값이 존재하는 Hashtable 을 가져온다.
		Hashtable table = (Hashtable) actionAPI.getSessionData("g_objHostRecv");
		
		
		StringBuffer sb = new StringBuffer();
		
		
		String m_strStockPriceJobDate = (String) table.get("A1_JobDate3");
		String m_strStockPriceJobTime = (String) table.get("A1_JobTime3");
		String m_strStockPriceCurrentAmt = (String) table.get("A1_Current3");
		String m_strStockPriceFluctFlag =  (String) table.get("A1_FluctBit3");
		String m_strStockPriceFluctAmt =   (String) table.get("A1_FluctAmt3");
		String m_strStockPriceVol =    (String) table.get("A1_Volume3");
		String m_strStockPriceTrdAmt = (String) table.get("A1_TrdAmt3");
		String m_strStockPriceUpCnt =  (String) table.get("A1_UpCnt3");
		String m_strStockPriceUpLimitCnt = (String) table.get("A1_UpLimitCnt3");
		String m_strStockPriceDnCnt =  (String) table.get("A1_DnCnt3");
		String m_strStockPriceDnLimitCnt = (String) table.get("A1_DnLimitCnt3");
		String m_strStockPriceUnChgCnt = (String) table.get("A1_UnchgCnt3");
		
		
		String m_strStockPriceFluctAmt_1  = m_strStockPriceFluctAmt.substring(0, 4);
		String m_strStockPriceFluctAmt_2 = m_strStockPriceFluctAmt.substring(5);
		m_strStockPriceFluctAmt_1 = trimNum(m_strStockPriceFluctAmt_1);
		
		String m_strStockPriceCurrentAmt_1 = m_strStockPriceCurrentAmt.substring(0, 6);
		String m_strStockPriceCurrentAmt_2 = m_strStockPriceCurrentAmt.substring(7);
		m_strStockPriceCurrentAmt_1 = trimNum(m_strStockPriceCurrentAmt_1);
		
		m_strStockPriceVol = trimNum(m_strStockPriceVol);
		m_strStockPriceTrdAmt = trimNum(m_strStockPriceTrdAmt);
		m_strStockPriceUpCnt = trimNum(m_strStockPriceUpCnt);
		m_strStockPriceDnCnt = trimNum(m_strStockPriceDnCnt);
		m_strStockPriceUnChgCnt = trimNum(m_strStockPriceUnChgCnt);
		m_strStockPriceUpLimitCnt = trimNum(m_strStockPriceUpLimitCnt);
		m_strStockPriceDnLimitCnt = trimNum(m_strStockPriceDnLimitCnt);
		
		
		
		sb.append(", 코스닥지수는,");
		
		if(m_strStockPriceFluctFlag.equals("5")) {
			sb.append(m_strStockPriceFluctAmt_1).append(",쩜,[").append(m_strStockPriceFluctAmt_2).append("]");
			sb.append(", 포인트 내린, ");
		} else if(m_strStockPriceFluctFlag.equals("0") || m_strStockPriceFluctFlag.equals("9")) {
			sb.append(", 보합인, ");
		} else if(m_strStockPriceFluctFlag.equals("1")){
			sb.append(m_strStockPriceFluctAmt_1).append(",쩜,[").append(m_strStockPriceFluctAmt_2).append("]");
			sb.append(", 포인트 오른, ");
		} else if(m_strStockPriceFluctFlag.equals("2")){
			sb.append(", 상한까로, ");
		} else if(m_strStockPriceFluctFlag.equals("3")){
			sb.append(", 기세상승으로, ");
		} else if(m_strStockPriceFluctFlag.equals("4")){
			sb.append(", 기세상한으로, ");
		} else if(m_strStockPriceFluctFlag.equals("6")){
			sb.append(", 하한까로, ");
		}else if(m_strStockPriceFluctFlag.equals("7")){
			sb.append(", 기세하락으로, ");
		}else if(m_strStockPriceFluctFlag.equals("8")){
			sb.append(", 기세하한으로, ");
		}
		
		sb.append(m_strStockPriceCurrentAmt_1).append(",쩜,[").append(m_strStockPriceCurrentAmt_2).append("] 포인트 이고 ,");
		sb.append(", 거래량은,");
		sb.append(m_strStockPriceVol).append(", 주, 이며,");
		sb.append(", 거래대금은,");
		sb.append(m_strStockPriceTrdAmt).append(", 원, 입니다.");
			
		
		
		
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
			sb.append(", 하한까, 없으며,");
		}
		
		
		m_strStockPriceFluctFlag 	= (String) actionAPI.getSessionData("m_strStockPriceFluctFlag");
		m_strStockPriceFluctAmt 	= (String) actionAPI.getSessionData("m_strStockPriceFluctAmt");
		m_strStockPriceCurrentAmt 	= (String) actionAPI.getSessionData("m_strStockPriceCurrentAmt");
		m_strStockPriceVol			= (String) actionAPI.getSessionData("m_strStockPriceVol");
		m_strStockPriceTrdAmt		= (String) actionAPI.getSessionData("m_strStockPriceTrdAmt");
		m_strStockPriceUpCnt		= (String) actionAPI.getSessionData("m_strStockPriceUpCnt");
		m_strStockPriceDnCnt		= (String) actionAPI.getSessionData("m_strStockPriceDnCnt");
		m_strStockPriceUnChgCnt 	= (String) actionAPI.getSessionData("m_strStockPriceUnChgCnt");
		m_strStockPriceUpLimitCnt	= (String) actionAPI.getSessionData("m_strStockPriceUpLimitCnt");
		m_strStockPriceDnLimitCnt	= (String) actionAPI.getSessionData("m_strStockPriceDnLimitCnt");
		
		
		m_strStockPriceFluctAmt_1  = m_strStockPriceFluctAmt.substring(0, 4);
		m_strStockPriceFluctAmt_2 = m_strStockPriceFluctAmt.substring(5);
		m_strStockPriceFluctAmt_1 = trimNum(m_strStockPriceFluctAmt_1);
		
		m_strStockPriceCurrentAmt_1 = m_strStockPriceCurrentAmt.substring(0, 6);
		m_strStockPriceCurrentAmt_2 = m_strStockPriceCurrentAmt.substring(7);
		m_strStockPriceCurrentAmt_1 = trimNum(m_strStockPriceCurrentAmt_1);
		
		m_strStockPriceVol = trimNum(m_strStockPriceVol);
		m_strStockPriceTrdAmt = trimNum(m_strStockPriceTrdAmt);
		m_strStockPriceUpCnt = trimNum(m_strStockPriceUpCnt);
		m_strStockPriceDnCnt = trimNum(m_strStockPriceDnCnt);
		m_strStockPriceUnChgCnt = trimNum(m_strStockPriceUnChgCnt);
		m_strStockPriceUpLimitCnt = trimNum(m_strStockPriceUpLimitCnt);
		m_strStockPriceDnLimitCnt = trimNum(m_strStockPriceDnLimitCnt);
		
		
		sb.append(", 종합주가지수는, 전일대비,");
		
		if(m_strStockPriceFluctFlag.equals("5")) {
			sb.append(m_strStockPriceFluctAmt_1).append(",쩜,[").append(m_strStockPriceFluctAmt_2).append("]");
			sb.append("포인트 내린,");
		} else if(m_strStockPriceFluctFlag.equals("0") || m_strStockPriceFluctFlag.equals("9")) {
			sb.append("보합인,");
		} else if(m_strStockPriceFluctFlag.equals("1")){
			sb.append(m_strStockPriceFluctAmt_1).append(",쩜,[").append(m_strStockPriceFluctAmt_2).append("]");
			sb.append("포인트 오른,");
		} else if(m_strStockPriceFluctFlag.equals("2")){
			sb.append("상한까로,");
		} else if(m_strStockPriceFluctFlag.equals("3")){
			sb.append("기세상승으로,");
		} else if(m_strStockPriceFluctFlag.equals("4")){
			sb.append("기세상한으로,");
		} else if(m_strStockPriceFluctFlag.equals("6")){
			sb.append("하한까로,");
		}else if(m_strStockPriceFluctFlag.equals("7")){
			sb.append("기세하락으로,");
		}else if(m_strStockPriceFluctFlag.equals("8")){
			sb.append("기세하한으로,");
		}
		
		sb.append(m_strStockPriceCurrentAmt_1).append(",쩜,[").append(m_strStockPriceCurrentAmt_2).append("] 포인트로,");
		sb.append(", 금일 장마감 되었습니다.");
		
		
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
