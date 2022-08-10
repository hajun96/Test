package TTS.S6.S615000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_615_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		
		
		/*
		 * m_strSubsTurn / SubsTrun	청약회차

           m_strSubItemNm / ItemNm	종목명

           m_strSubsStrDate /  SubsStrDate	청약시작일자

           m_strSubsEndDate / SubsEndDate	청약종료일자

           m_strSubsRpmtDate / RpmtDate	환불일자

           m_strSubsListDate / ListDate	상장일자
		
		*/
		
	
		String m_strSubItemNm = (String) actionAPI.getSessionData("m_strSubItemNm"); // 종목명
		
		String m_strSubsStrDate = (String) actionAPI.getSessionData("m_strSubsStrDate"); // 청약시작일자
		String month = m_strSubsStrDate.substring(4, 6);
		String day = m_strSubsStrDate.substring(6);
		month = trimNum(month);
		day = trimNum(day);
		
		String m_strSubsEndDate = (String) actionAPI.getSessionData("m_strSubsEndDate"); // 청약종료일자
		String month1 = m_strSubsEndDate.substring(4, 6);
		String day1 = m_strSubsEndDate.substring(6);
		month1 = trimNum(month1);
		day1 = trimNum(day1);
		
		
	
		String m_strSubsRpmtDate = (String) actionAPI.getSessionData("m_strSubsRpmtDate"); // 환불일자
		String month2 = m_strSubsRpmtDate.substring(4, 6);
		String day2 = m_strSubsRpmtDate.substring(6);
		month2 = trimNum(month2);
		day2 = trimNum(day2);
		
		
		String m_strSubsListDate = (String) actionAPI.getSessionData("m_strSubsListDate"); // 상장일자
		String month3 = m_strSubsListDate.substring(4, 6);
		String day3 = m_strSubsListDate.substring(6);
		month3 = trimNum(month3);
		day3 = trimNum(day3);
		
	
		
		StringBuffer sb = new StringBuffer();
		sb.append(m_strSubItemNm).append(", , , ").append("청약시작일자").append(", , , ").
		append(month).append(", , , ").append("월").append(", , , ").append(day).append(", , , ").append("일").append(", , , ").
		append("청약종료일").append(month1).append(", , , ").append("월").append(", , , ").append(day1).append(", , , ").append("일").append(", , , ").
		append("환불일").append(", , , ").append(month2).append(", , , ").append("월").append(", , , ").append(day2).append(", , , ").append("일").append(", , , ").
		append("상장예정일").append(", , , ").append(month3).append(", , , ").append("월").append(", , , ").append(day3).append(", , , ").append("일 입니다");
		
		
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
