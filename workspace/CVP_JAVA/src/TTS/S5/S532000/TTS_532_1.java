package TTS.S5.S532000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TTS_532_1 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		/*m_strTransFtrnDate / FtrnDate / 이체일자     
		m_strTransIamtBnkCd / IamtBnkCd / 입금은행코드 : "000"=대우증권(대체인경우)
		m_strTransFtrnAmt / FtrnAmt / 이체금액     
		m_strTransProcRslt / ProcRslt / 처리결과 : 1="처리전" 2="처리완료" 3="은행오류" 그외="당사오류"
		m_strTransJobMediaSect / JobMediaSect / "업무매체구분 (0=창구, 1=PC, 2=ARS, 3=인터넷, 4=딜링룸(은행CD기), 5=은행제휴카드, 6=모바일(신청이체), 7=콜센터(자동이체), 8=예약이체, 9=마켓리더, A=사이버룸, D=오프라인, I=홈페이지, W=WRAP)
		m_strTransObjAcntNm / ObjAcntNm / 상대계좌명  
		m_strTransTrSect / TrSect / 거래구분 : 입금="01" 출금="02" ??="03"
		m_strBankName / 은행명 (DB에서 조회)*/
		
		String m_strTransIamtBnkCd = (String) actionAPI.getSessionData("m_strTransIamtBnkCd"); //입금은행코드 : "000"=대우증권(대체인경우)
		String m_strBankName = (String) actionAPI.getSessionData("m_strBankName"); //은행명
		String m_strTransFtrnDate = (String) actionAPI.getSessionData("m_strTransFtrnDate"); //이체일자
		String m_strTransFtrnAmt = (String) actionAPI.getSessionData("m_strTransFtrnAmt"); //이체금액
		m_strTransFtrnAmt = trimNum(m_strTransFtrnAmt);
		String m_strTransProcRslt = (String) actionAPI.getSessionData("m_strTransProcRslt"); // 처리결과 : 1="처리전" 2="처리완료" 3="은행오류" 그외="당사오류"
		String m_strTransJobMediaSect = (String) actionAPI.getSessionData("m_strTransJobMediaSect"); //"업무매체구분 (0=창구, 1=PC, 2=ARS, 3=인터넷, 4=딜링룸(은행CD기), 5=은행제휴카드, 6=모바일(신청이체), 7=콜센터(자동이체), 8=예약이체, 9=마켓리더, A=사이버룸, D=오프라인, I=홈페이지, W=WRAP)
		String m_strTransObjAcntNm = (String) actionAPI.getSessionData("m_strTransObjAcntNm"); //상대계좌명
		String m_strTransTrSect = (String) actionAPI.getSessionData("m_strTransTrSect"); //거래구분 : 입금="01" 출금="02" ??="03"
		
		//[오늘날짜계산]
		String formStr = "yyyyMMdd";
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat(formStr);
		String nowDate = format.format(date);
		
		//[이체날짜계산]
		String year = m_strTransFtrnDate.substring(0, 4);
		String month = m_strTransFtrnDate.substring(4, 6);
		String day = m_strTransFtrnDate.substring(6);
		month = trimNum(month);
		day = trimNum(day);
		
		StringBuffer sb = new StringBuffer();
		
		if(nowDate.equals(m_strTransFtrnDate)){
			sb.append(year)
			.append(", 년, ")
			.append(month)
			.append(", 월, ")
			.append(day)
			.append(", 일, ")
			.append("입출금 내역은,");
		}else{
			sb.append(year)
			.append(", 년, ")
			.append(month)
			.append(", 월, ")
			.append(day)
			.append(", 일, ")
			.append("입출금 내역은,");
		}
		
		if(m_strTransIamtBnkCd.equals(null) || m_strTransIamtBnkCd.isEmpty()){
			sb.append("");
		}else{
			if(m_strTransTrSect.equals("01")){//입금
				sb.append(m_strBankName).append(",");
			}else{
				sb.append(m_strBankName).append(",");
			}
		}
		
		if(m_strTransObjAcntNm.equals(null) || m_strTransObjAcntNm.isEmpty()){
			sb.append("");
		}else{
			/*sb.append(m_strTransObjAcntNm)
			.append(", 님의 계좌로, ");*/
			if(m_strTransTrSect.equals("01")){//입금
				sb.append(m_strTransObjAcntNm)
				.append(", 님의 계좌 에서, ");
			}else{
				sb.append(m_strTransObjAcntNm)
				.append(", 님의 계좌로, ");
			}
		}
		
		if(m_strTransFtrnAmt.equals(null) || m_strTransFtrnAmt.isEmpty()){
			sb.append("");
		}else{
			sb.append(m_strTransFtrnAmt)
			.append(", 원이, ");
		}
		
		//"업무매체구분 (0=창구, 1=PC, 2=ARS, 3=인터넷, 4=딜링룸(은행CD기), 5=은행제휴카드, 6=모바일(신청이체), 7=콜센터(자동이체), 8=예약이체, 9=마켓리더, A=사이버룸, D=오프라인, I=홈페이지, W=WRAP)
		if(m_strTransJobMediaSect.equals("0")){ //창구
			sb.append(", 창구에서, ");
		}else if(m_strTransJobMediaSect.equals("1")){ //PC
			sb.append(", 피씨 에서, ");
		}else if(m_strTransJobMediaSect.equals("2")){ //ARS
			sb.append(", 에이알에스 에서, ");
		}else if(m_strTransJobMediaSect.equals("3")){ //인터넷
			sb.append(", 인터넷 에서, ");
		}else if(m_strTransJobMediaSect.equals("4")){ //딜링룸(은행CD기)
			sb.append(", 은행 씨디기 에서  , ");
		}else if(m_strTransJobMediaSect.equals("5")){ //은행제휴카드
			sb.append(", 은행 제휴카드 에서 , ");
		}else if(m_strTransJobMediaSect.equals("6")){ //모바일(신청이체)
			sb.append(", 모바일 에서, ");
		}else if(m_strTransJobMediaSect.equals("7")){ //콜센터(자동이체)
			sb.append(", 콜센터 에서, ");
		}else if(m_strTransJobMediaSect.equals("8")){ //예약이체
			sb.append(", 예약 이체로, ");
		}else if(m_strTransJobMediaSect.equals("9")){ //마켓리더
			sb.append(", 마켓 리더에서, ");
		}else if(m_strTransJobMediaSect.equals("A")){ //사이버룸
			sb.append(", 사이버룸 에서, ");
		}else if(m_strTransJobMediaSect.equals("D")){ //오프라인
			sb.append(", 오프라인 에서, ");
		}else if(m_strTransJobMediaSect.equals("I")){ //홈페이지
			sb.append(", 홈페이지 에서, ");
		}else if(m_strTransJobMediaSect.equals("W")){ //WRAP
			sb.append(", WRAP 에서, ");
		}
		
		if(m_strTransIamtBnkCd.equals("000")){//대체
			if(m_strTransTrSect.equals("01")){//입금
				sb.append(", 대체 입금, ");
			}else if(m_strTransTrSect.equals("02")){//출금
				sb.append(", 대체 출금 , ");
			}else{
				sb.append("");
			}
		}else{
			if(m_strTransTrSect.equals("01")){//입금
				sb.append(", 이체 입금, ");
			}else if(m_strTransTrSect.equals("02")){//출금
				sb.append(", 이체 출금 , ");
			}else{
				sb.append("");
			}
		}
		
		if(m_strTransProcRslt.equals("1")){ //처리전
			sb.append(", 처리 전, 입니다.");
		}else if(m_strTransProcRslt.equals("2")){ //처리완료
			sb.append(", 처리, 되었습니다.");
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
