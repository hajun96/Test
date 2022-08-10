package TTS.S2.S210000;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_210000_5 extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
			
		SimpleDateFormat format = new SimpleDateFormat("HHmm");
		Date today = new Date();
		
		String nowTime = format.format(today);
		
		
		StringBuffer sb = new StringBuffer();
		
		Hashtable table = (Hashtable) actionAPI.getSessionData("g_objHostRecv");
		String maedoJan = (String) table.get("B11_RemOfferVol21");
		String maesuJan =   (String)table.get("B11_RemBidVol22"); 
		if(maedoJan == null || maedoJan.isEmpty()){
			maedoJan = "0";
		}
		if(maesuJan == null || maesuJan.isEmpty()){
			maesuJan = "0";
		}
		
		
		String m_strCurrentFluctFlag = (String) actionAPI.getSessionData("m_strCurrentFluctFlag");
		String m_strCurrentFluctAmt =  (String) actionAPI.getSessionData("m_strCurrentFluctAmt");
		String m_strCurrentAmt = (String) actionAPI.getSessionData("m_strCurrentAmt");
		String m_strCurrentVolume = (String) actionAPI.getSessionData("m_strCurrentVolume");
		
		maesuJan = trimNum(maesuJan);
		maedoJan = trimNum(maedoJan);
		m_strCurrentFluctFlag = trimNum(m_strCurrentFluctFlag);
		m_strCurrentFluctAmt = trimNum(m_strCurrentFluctAmt);
		m_strCurrentAmt = trimNum(m_strCurrentAmt);
		m_strCurrentVolume = trimNum(m_strCurrentVolume);
		
		if(m_strCurrentFluctFlag.equals("5")) {
			sb.append(", 전일대비, ").append(m_strCurrentFluctAmt).append(", ,").append("원, 내린,");
		} else if (m_strCurrentFluctFlag.equals("1")) {
			sb.append(", 전일대비, ").append(m_strCurrentFluctAmt).append(", ,").append("원, 오른,");
		} else if (m_strCurrentFluctFlag.equals("9") || m_strCurrentFluctFlag.equals("0")) {
			sb.append(", 전일대비, 보합인,");
		}  else if (m_strCurrentFluctFlag.equals("2") || m_strCurrentFluctFlag.equals("3") || m_strCurrentFluctFlag.equals("4")) {
			sb.append("전일대비, ").append(m_strCurrentFluctAmt).append(", ,").append("원, 오른,");
			if(m_strCurrentFluctFlag.equals("2")) {
				sb.append(", 상한까로,");
			} else if(m_strCurrentFluctFlag.equals("3")) {
				sb.append(", 기세상승으로,");
			} else {
				sb.append(", 기세상한으로,");
			}
		} else if (m_strCurrentFluctFlag.equals("6") || m_strCurrentFluctFlag.equals("7") || m_strCurrentFluctFlag.equals("8")) {
			sb.append(", 전일대비, ").append(m_strCurrentFluctAmt).append(", ,").append(", 원, 내린,");
			if(m_strCurrentFluctFlag.equals("6")) {
				sb.append(", 하한까로,").append(", ,");
			} else if(m_strCurrentFluctFlag.equals("7")) {
				sb.append(", 기세하락으로,");
			} else {
				sb.append(", 기세하한으로,");
			}
		}
		
		sb.append(m_strCurrentAmt).append(", ,").append(", 원, 거래량은,").append(m_strCurrentVolume).append(", ,").append(", 주로, 금일종가 마감되었습니다.");
		
		String m_strSelectStartTime2 = (String) actionAPI.getSessionData("m_strSelectStartTime2");
		String m_strSelectEndTime2 = (String) actionAPI.getSessionData("m_strSelectEndTime2");
		
		if (Integer.parseInt(nowTime) < Integer.parseInt(m_strSelectEndTime2)) {
			if(Integer.parseInt(maedoJan) > 0) {
				sb.append("시간외 매도물량은,").append(maedoJan).append(", ,").append(",주,");
			} else {
				sb.append("시간외 매도물량은, 없고,");
			}
			
			if(Integer.parseInt(maesuJan) > 0) {
				sb.append("시간외 매수물량은,").append(maesuJan).append(", ,").append(",주, 입니다.");
			} else {
				sb.append("시간외 매수물량은 없습니다.");
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
