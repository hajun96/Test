package TTS.S3.S374000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_374_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI)throws AudiumException {
		
		String m_strRsvOrdNo = (String) actionAPI.getSessionData("m_strRsvOrdNo");//예약번호
		m_strRsvOrdNo = trimNum(m_strRsvOrdNo);
		String m_strOrderDateyyyy = (String) actionAPI.getSessionData("m_strOrderDateyyyy");//예약주문년
		String m_strRsvRegDate = (String) actionAPI.getSessionData("m_strRsvRegDate");//예약주문월일시분
		String m_strRsvRegDateMon = m_strRsvRegDate.substring(0, 2); // 월
		m_strRsvRegDateMon = trimNum(m_strRsvRegDateMon);
	    String m_strRsvRegDateDay = m_strRsvRegDate.substring(3, 5); // 일
	    m_strRsvRegDateDay = trimNum(m_strRsvRegDateDay);
	    String m_strRsvRegDateHour = m_strRsvRegDate.substring(6, 8); // 시
	    m_strRsvRegDateHour = trimNum(m_strRsvRegDateHour);
	    String m_strRsvRegDateMin = m_strRsvRegDate.substring(9, 11); // 분
	    m_strRsvRegDateMin = trimNum(m_strRsvRegDateMin);
		String m_strItemName = (String) actionAPI.getSessionData("m_strItemName");	//종목명
		String m_strRsvOrderVol = (String) actionAPI.getSessionData("m_strRsvOrderVol");	//주문수량
		m_strRsvOrderVol = trimNum(m_strRsvOrderVol);
		String m_strRsvTrdTypeCd = (String) actionAPI.getSessionData("m_strRsvTrdTypeCd");	//매매유형코드 (01:지정가, 02:시장가, 06:조건부지정가)
		String m_strRsvOrderPrice = (String) actionAPI.getSessionData("m_strRsvOrderPrice");	//주문가격
		m_strRsvOrderPrice = trimNum(m_strRsvOrderPrice);
		String m_strRsvTrdSect = (String) actionAPI.getSessionData("m_strRsvTrdSect");	//매매구분
		String m_strRsvUpdtCnclSect = (String) actionAPI.getSessionData("m_strRsvUpdtCnclSect");	//취소구분
		
		
		StringBuffer sb = new StringBuffer();
		//예약주문번호
		if(m_strRsvOrdNo.equals("0") || m_strRsvOrdNo.equals("") || m_strRsvOrdNo.equals(null)){
			sb.append(", 예약번호, 없고,");
		}else{
			sb.append(", 예약번호, ")
			.append(m_strRsvOrdNo)
			.append(", 번에, ");
		}
		
		//예약등록일자
		if(m_strRsvRegDate.equals("0") || m_strRsvRegDate.equals("") || m_strRsvRegDate.equals(null)){
			sb.append(", 예약일자, 없고,");
		}else{
			sb.append(", 예약일자, ")
			.append(m_strOrderDateyyyy).append(", 년, ")
			.append(m_strRsvRegDateMon).append(", 월, ")
			.append(m_strRsvRegDateDay).append(", 일, ")
			.append(m_strRsvRegDateHour).append(", 시, ")
			.append(m_strRsvRegDateMin).append(", 분, ")
			.append(", 이고, ");
		}
		
		//종목명
		if(m_strItemName.equals("0") || m_strItemName.equals("") || m_strItemName.equals(null)){
			sb.append(", 종목명, 없고, ");
		}else{
			sb.append(m_strItemName).append(", ");
		}
		
		//예약주문수량
		if(m_strRsvOrderVol.equals("0") || m_strRsvOrderVol.equals("") || m_strRsvOrderVol.equals(null)){
			sb.append(", 예약주문수량, 없고, ");
		}else{
			sb.append(m_strRsvOrderVol).append(", 주, ");
		}
		
		//매매유형코드 (01:지정가, 05:시장가, 06:조건부지정가)
		if(m_strRsvTrdTypeCd.equals("0") || m_strRsvTrdTypeCd.equals("") || m_strRsvTrdTypeCd.equals(null)){
			sb.append(",매매구분, 없고, ");
		}else if(m_strRsvTrdTypeCd.equals("01")){
			if(m_strRsvOrderPrice.equals("0") || m_strRsvOrderPrice.equals("") || m_strRsvOrderPrice.equals(null)){
				sb.append(", 지정가로, ");
			}else{
				sb.append(m_strRsvOrderPrice).append(", 원에, ")
				.append(", 지정가로, ");
			}
		}else if(m_strRsvTrdTypeCd.equals("05")){
			sb.append(", 시장가로, ");
		}else if(m_strRsvTrdTypeCd.equals("06")){
			if(m_strRsvOrderPrice.equals("0") || m_strRsvOrderPrice.equals("") || m_strRsvOrderPrice.equals(null)){
				sb.append(", 조건부 지정가로, ");
			}else{
				sb.append(m_strRsvOrderPrice).append(", 원에, ")
				.append(", 조건부 지정가로, ");
			}
		}else{
			sb.append(",매매종류구분, 없고, ");
		}
		
		//매매구분
		if(m_strRsvTrdSect.equals("0") || m_strRsvTrdSect.equals("") || m_strRsvTrdSect.equals(null)){
			sb.append("");
		}else if(m_strRsvTrdSect.equals("1")){
			sb.append(", 매도, ");
		}else{
			sb.append(", 매수, ");
		}
		
		//취소구분
		if(m_strRsvUpdtCnclSect.equals("2")){
			sb.append(", 예약취소, 주문이, 있습니다.");
		}else{
			sb.append(", 예약접수, 되었습니다.");
		}
		
		
		actionAPI.setSessionData("ment", sb.toString());
	}
	
	private String trimNum(String num) {
		if (num == null)
			return "0";

		boolean isMinus = false;
		String result = "";

		if (num.startsWith("-")) {
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
		if (result.isEmpty()) {
			return "0";
		}

		if (result.startsWith("."))
			result = "0" + result;

		if (isMinus) {
			result = "-" + result;
		}

		return result;
	}
}
