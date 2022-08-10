package TTS.S2.S251000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_251_3 extends ActionElementBase {
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		/*투_종목명	m_strGiftItemName
		투_현재가	m_strGiftCurrentAmt
		투_전일대비구분	m_strGiftFluctFlag
		투_전일대비	m_strGiftFluctAmt
		투_매도호까	m_strGiftOfferAmt
		투_매수호까	m_strGiftBidAmt
		투_거래량	m_strGiftVol
		투_전일종가	m_strGiftPrevAmt
		투_전일거래량	m_strGiftPrevVol
		투_시가	m_strGiftOpenAmt
		투_고가	m_strGiftHighAmt
		투_저가	m_strGiftLowAmt
		투_행사가격	m_strGiftStrikePrice
		우선매도호까잔량	m_strGiftDiffOfferAmt4
		우선매도계약	m_strGiftOfferVol4
		우선매수호까잔량	m_strGiftDiffBidAmt0
		우선매수계약	m_strGiftBidVol0
		차선매도호까잔량	m_strGiftDiffOfferAmt3
		차선매도계약	m_strGiftOfferVol3
		차선매수호까잔량	m_strGiftDiffBidAmt1
		차선매수계약	m_strGiftBidVol1
		총매도호까잔량	m_strGiftOfferVol5
		총매수호까잔량	m_strGiftBidVol5
		총매도건수	m_strGiftOfferCnt5
		총매수건수	m_strGiftBidCnt5*/
		
		String m_strGiftYear = (String) actionAPI.getSessionData("m_strGiftYear"); //년 
		String m_strGiftItemCode = (String) actionAPI.getSessionData("m_strGiftItemCode"); //월
		String m_strGiftStrikePrice = (String) actionAPI.getSessionData("m_strGiftStrikePrice"); //투_행사가격
		String m_strGiftFluctFlag = (String) actionAPI.getSessionData("m_strGiftFluctFlag"); //투_전일대비구분
		String m_strGiftFluctAmt = (String) actionAPI.getSessionData("m_strGiftFluctAmt"); //투_전일대비
		String m_strGiftCurrentAmt = (String) actionAPI.getSessionData("m_strGiftCurrentAmt"); //투_현재가
		String m_strGiftOfferAmt = (String) actionAPI.getSessionData("m_strGiftOfferAmt"); //투_매도호까
		String m_strGiftBidAmt = (String) actionAPI.getSessionData("m_strGiftBidAmt"); //투_매수호까
		String m_strGiftVol = (String) actionAPI.getSessionData("m_strGiftVol"); //투_거래량
		m_strGiftVol = trimNum(m_strGiftVol);
		String m_strGiftOpenAmt = (String) actionAPI.getSessionData("m_strGiftOpenAmt"); //투_시가
		String m_strGiftHighAmt = (String) actionAPI.getSessionData("m_strGiftHighAmt"); //투_고가
		String m_strGiftLowAmt = (String) actionAPI.getSessionData("m_strGiftLowAmt"); //투_저가
		String m_strGiftDiffOfferAmt4 = (String) actionAPI.getSessionData("m_strGiftDiffOfferAmt4"); //우선매도호까잔량
		String m_strGiftOfferVol4 = (String) actionAPI.getSessionData("m_strGiftOfferVol4"); //우선매도계약
		m_strGiftOfferVol4 = trimNum(m_strGiftOfferVol4);
		String m_strGiftDiffBidAmt0 = (String) actionAPI.getSessionData("m_strGiftDiffBidAmt0"); //우선매수호까잔량
		String m_strGiftBidVol0 = (String) actionAPI.getSessionData("m_strGiftBidVol0"); //우선매수계약
		m_strGiftBidVol0 = trimNum(m_strGiftBidVol0);
		String m_strGiftDiffOfferAmt3 = (String) actionAPI.getSessionData("m_strGiftDiffOfferAmt3"); //차선매도호까잔량
		String m_strGiftOfferVol3 = (String) actionAPI.getSessionData("m_strGiftOfferVol3"); //차선매도계약
		m_strGiftOfferVol3 = trimNum(m_strGiftOfferVol3);
		String m_strGiftDiffBidAmt1 = (String) actionAPI.getSessionData("m_strGiftDiffBidAmt1"); //차선매수호까잔량
		String m_strGiftBidVol1 = (String) actionAPI.getSessionData("m_strGiftBidVol1"); //차선매수계약
		m_strGiftBidVol1 = trimNum(m_strGiftBidVol1);
		String m_strGiftOfferVol5 = (String) actionAPI.getSessionData("m_strGiftOfferVol5"); //총매도호까잔량
		m_strGiftOfferVol5 = trimNum(m_strGiftOfferVol5);
		String m_strGiftBidVol5 = (String) actionAPI.getSessionData("m_strGiftBidVol5"); //총매수호까잔량
		m_strGiftBidVol5 = trimNum(m_strGiftBidVol5);
		String m_strGiftOfferCnt5 = (String) actionAPI.getSessionData("m_strGiftOfferCnt5"); //총매도건수
		m_strGiftOfferCnt5 = trimNum(m_strGiftOfferCnt5);
		String m_strGiftBidCnt5 = (String) actionAPI.getSessionData("m_strGiftBidCnt5"); //총매수건수
		m_strGiftBidCnt5 = trimNum(m_strGiftBidCnt5);
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(", 금일종가, 코스피 200 , ");
		
		//####년
		if(m_strGiftYear.equals("0") || m_strGiftYear.equals("") || m_strGiftYear.equals(null)){
			sb.append("년도, 없고,");
		}else{
			sb.append(m_strGiftYear).append(", 년, ");
		}
		
		//###월
		if(m_strGiftItemCode.equals("0") || m_strGiftItemCode.equals("") || m_strGiftItemCode.equals(null)){
			sb.append("월, 없고,");
		}else{
			String month = m_strGiftItemCode.substring(1, 3);
			month = trimNum(month);
			sb.append(month).append(", 월 , 물, ");
		}
		
		//행사가격
		if(m_strGiftStrikePrice.equals("0") || m_strGiftStrikePrice.equals("") || m_strGiftStrikePrice.equals(null)){
			sb.append("행사가격, 없고,");
		}else{
			// 소수점 자리수를 가져온다. 
			int strDotIndex = m_strGiftStrikePrice.indexOf(".");
			// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
			String strDotLeft = m_strGiftStrikePrice.substring(0, strDotIndex);
			// 앞에 0이 있으면 없앤다.
			strDotLeft = trimNum(strDotLeft);
			// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
			String strDotRight = m_strGiftStrikePrice.substring(strDotIndex+1);
			
			sb.append(", 행사가격, ")
			.append(strDotLeft).append(", , ").append(" , 쩜 , [")
			.append(strDotRight).append("], , ");
		}
		
		//콜옵션
		sb.append(", 콜옵션 , ").append(" , 전일대비 , ");
		

		//전일대비
		if(m_strGiftFluctFlag.equals("0") || m_strGiftFluctFlag.equals("1") || m_strGiftFluctFlag.equals("5")){
			if(m_strGiftFluctAmt.equals("0000.00") || m_strGiftFluctAmt.equals("0") || m_strGiftFluctAmt.equals("") || m_strGiftFluctAmt.equals(null)){
				sb.append("");
			}else{
				// [전일 대비 계산] 
				// 소수점 자리수를 가져온다. 
				int strFluctDotIndex = m_strGiftFluctAmt.indexOf(".");
				// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
				String strFluctDotLeft = m_strGiftFluctAmt.substring(0, strFluctDotIndex);
				// 앞에 0이 있으면 없앤다.
				strFluctDotLeft = trimNum(strFluctDotLeft);
				// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
				String strFluctDotRight = m_strGiftFluctAmt.substring(strFluctDotIndex+1);
				sb.append(strFluctDotLeft).append(", , ")
				.append(", 쩜 , [")
				.append(strFluctDotRight).append("], , ")
				.append(", 포인트, ");
			}
			
			if(m_strGiftFluctFlag.equals("0")){
				sb.append(", 보합인, ");
			}else if(m_strGiftFluctFlag.equals("1")){
				sb.append(", 오른, ");
			}else{
				sb.append(", 내린, ");
			}
		}else{
			if(m_strGiftFluctFlag.equals("2")){
				sb.append(", 상한가로 , ");
			}else if(m_strGiftFluctFlag.equals("3")){
				sb.append(", 기세상승으로 , ");
			}else if(m_strGiftFluctFlag.equals("4")){
				sb.append(", 기세상한으로 , ");
			}else if(m_strGiftFluctFlag.equals("6")){
				sb.append(", 하한가로 , ");
			}else if(m_strGiftFluctFlag.equals("7")){
				sb.append(", 기세하락으로 , ");
			}else if(m_strGiftFluctFlag.equals("8")){
				sb.append(", 기세하한으로 , ");
			}else{
				sb.append(", 보합인, ");
			}
		}

		//현재가
		if(m_strGiftCurrentAmt.equals("0000.00") || m_strGiftCurrentAmt.equals("0") || m_strGiftCurrentAmt.equals("") || m_strGiftCurrentAmt.equals(null)){
			sb.append(", 현재가 없고,");
		}else{
			// [현재가 계산]
			// 소수점 자리수를 가져온다. 
			int strCurrentDotIndex = m_strGiftCurrentAmt.indexOf(".");
			// "." 을 기준으로 왼쪽 문자열을 저장한다.  (자연수)
			String strCurrentDotLeft = m_strGiftCurrentAmt.substring(0, strCurrentDotIndex);
			// 앞에 0이 있으면 없앤다.
			strCurrentDotLeft = trimNum(strCurrentDotLeft);
			// "." 을 기준으로 오른쪽 문자열을 저장한다. (소수점)
			String strCurrentDotRight = m_strGiftCurrentAmt.substring(strCurrentDotIndex+1);
			
			sb.append(strCurrentDotLeft).append(", , ")
			.append(", 쩜 , [")
			.append(strCurrentDotRight).append("], , ")
			.append(", 포인트 이며 , ");
		}
		
		//매도호까 m_strGiftOfferAmt
		if(m_strGiftOfferAmt.equals("0000.00") || m_strGiftOfferAmt.equals("0") || m_strGiftOfferAmt.equals("") || m_strGiftOfferAmt.equals(null)){
			sb.append(", 매도호까, ")
			.append(", 없고, ");
		}else{
			int strGiftOfferDotIndex = m_strGiftOfferAmt.indexOf(".");
			String strGiftOfferDotLeft = m_strGiftOfferAmt.substring(0, strGiftOfferDotIndex);
			strGiftOfferDotLeft = trimNum(strGiftOfferDotLeft);
			String strGiftOfferDotRight = m_strGiftOfferAmt.substring(strGiftOfferDotIndex+1);
			strGiftOfferDotRight = trimNum(strGiftOfferDotRight);
			sb.append(", 매도호까, ")
			.append(strGiftOfferDotLeft).append(", , ")
			.append(", 쩜, [")
			.append(strGiftOfferDotRight).append("], , ")
			.append(", 포인트, ");
		}
		
		//매수호까 m_strGiftBidAmt
		if(m_strGiftBidAmt.equals("0000.00") || m_strGiftBidAmt.equals("0") || m_strGiftBidAmt.equals("") || m_strGiftBidAmt.equals(null)){
			sb.append(", 매수호까, ")
			.append(", 없고, ");
		}else{
			int strGiftBidDotIndex = m_strGiftBidAmt.indexOf(".");
			String strGiftBidDotLeft = m_strGiftBidAmt.substring(0, strGiftBidDotIndex);
			strGiftBidDotLeft = trimNum(strGiftBidDotLeft);
			String strGiftBidDotRight = m_strGiftBidAmt.substring(strGiftBidDotIndex+1);
			strGiftBidDotRight = trimNum(strGiftBidDotRight);
			sb.append(", 매수호까, ")
			.append(strGiftBidDotLeft).append(", , ")
			.append(", 쩜, [")
			.append(strGiftBidDotRight).append("], , ")
			.append(", 포인트, ");
		}
		
		//거래량 m_strGiftVol
		if(m_strGiftVol.equals("0") || m_strGiftVol.equals("") || m_strGiftVol.equals(null)){
			sb.append("거래량은, 없습니다.");
		}else{
			sb.append(", 거래량은,  ")
			.append(m_strGiftVol).append(", , ")
			.append(", 계약, ")
			.append(", 입니다.");
		}
		
		//시가 m_strGiftOpenAmt
		if(m_strGiftOpenAmt.equals("0000.00") || m_strGiftOpenAmt.equals("0") || m_strGiftOpenAmt.equals("") || m_strGiftOpenAmt.equals(null)){
			sb.append(", 시까, ")
			.append(", 없고, ");
		}else{
			int strGiftOpenDotIndex = m_strGiftOpenAmt.indexOf(".");
			String strGiftOpenDotLeft = m_strGiftOpenAmt.substring(0, strGiftOpenDotIndex);
			strGiftOpenDotLeft = trimNum(strGiftOpenDotLeft);
			String strGiftOpenDotRight = m_strGiftOpenAmt.substring(strGiftOpenDotIndex+1);
			strGiftOpenDotRight = trimNum(strGiftOpenDotRight);
			sb.append(", 시까, ")
			.append(strGiftOpenDotLeft).append(", , ")
			.append(", 쩜, [")
			.append(strGiftOpenDotRight).append("], , ")
			.append(", 포인트, ");
		}
		
		//고가  m_strGiftHighAmt
		if(m_strGiftHighAmt.equals("0000.00") || m_strGiftHighAmt.equals("0") || m_strGiftHighAmt.equals("") || m_strGiftHighAmt.equals(null)){
			sb.append(", 고까, ")
			.append(", 없고, ");
		}else{
			int strGiftHighDotIndex = m_strGiftHighAmt.indexOf(".");
			String strGiftHighDotLeft = m_strGiftHighAmt.substring(0, strGiftHighDotIndex);
			strGiftHighDotLeft = trimNum(strGiftHighDotLeft);
			String strGiftHighDotRight = m_strGiftHighAmt.substring(strGiftHighDotIndex+1);
			strGiftHighDotRight = trimNum(strGiftHighDotRight);
			sb.append(", 고까, ")
			.append(strGiftHighDotLeft)
			.append(", 쩜, [")
			.append(strGiftHighDotRight)
			.append("], 포인트, ");
		}

		//저가 m_strGiftLowAmt
		if(m_strGiftLowAmt.equals("0000.00") || m_strGiftLowAmt.equals("0") || m_strGiftLowAmt.equals("") || m_strGiftLowAmt.equals(null)){
			sb.append(", 저까, ")
			.append("없습니다.");
		}else{
			int strGiftLowDotIndex = m_strGiftLowAmt.indexOf(".");
			String strGiftLowDotLeft = m_strGiftLowAmt.substring(0, strGiftLowDotIndex);
			strGiftLowDotLeft = trimNum(strGiftLowDotLeft);
			String strGiftLowDotRight = m_strGiftLowAmt.substring(strGiftLowDotIndex+1);
			strGiftLowDotRight = trimNum(strGiftLowDotRight);
			sb.append(", 저까, ")
			.append(strGiftLowDotLeft)
			.append(", 쩜, [")
			.append(strGiftLowDotRight)
			.append("], 포인트, ")
			.append(", 입니다.");
		}
		
		//우선매도호까잔량	m_strGiftDiffOfferAmt4
		if(m_strGiftDiffOfferAmt4.equals("0000.00") || m_strGiftDiffOfferAmt4.equals("0") || m_strGiftDiffOfferAmt4.equals("") || m_strGiftDiffOfferAmt4.equals(null)){
			sb.append(", 우선, ")
			.append(", 매도호까 잔량은, ")
			.append(", 없고, ");
		}else{
			int strGiftDiffOfferAmt4DotIndex = m_strGiftDiffOfferAmt4.indexOf(".");
			String strGiftDiffOfferAmt4DotLeft = m_strGiftDiffOfferAmt4.substring(0, strGiftDiffOfferAmt4DotIndex);
			strGiftDiffOfferAmt4DotLeft = trimNum(strGiftDiffOfferAmt4DotLeft);
			String strGiftDiffOfferAmt4DotRight = m_strGiftDiffOfferAmt4.substring(strGiftDiffOfferAmt4DotIndex+1);
			strGiftDiffOfferAmt4DotRight = trimNum(strGiftDiffOfferAmt4DotRight);
			sb.append(", 우선, ")
			.append(", 매도호까 잔량은, ")
			.append(strGiftDiffOfferAmt4DotLeft)
			.append(", 쩜, [")
			.append(strGiftDiffOfferAmt4DotRight)
			.append("], 포인트에, ");
		}
		
		//우선매도계약	m_strGiftOfferVol4
		if(m_strGiftOfferVol4.equals("0") || m_strGiftOfferVol4.equals("") || m_strGiftOfferVol4.equals(null)){
			sb.append(", 우선, ")
			.append(", 매도호까 계약, ")
			.append(", 없고, ");
		}else{
			sb.append(m_strGiftOfferVol4)
			.append(", 계약, ");
		}
		
		//우선매수호까잔량	m_strGiftDiffBidAmt0
		if(m_strGiftDiffBidAmt0.equals("0000.00") || m_strGiftDiffBidAmt0.equals("0") || m_strGiftDiffBidAmt0.equals("") || m_strGiftDiffBidAmt0.equals(null)){
			sb.append(", 우선, ")
			.append(", 매수호까 잔량은, ")
			.append(", 없고, ");
		}else{
			int strGiftDiffBidAmt0DotIndex = m_strGiftDiffBidAmt0.indexOf(".");
			String strGiftDiffBidAmt0DotLeft = m_strGiftDiffBidAmt0.substring(0, strGiftDiffBidAmt0DotIndex);
			strGiftDiffBidAmt0DotLeft = trimNum(strGiftDiffBidAmt0DotLeft);
			String strGiftDiffBidAmt0DotRight = m_strGiftDiffBidAmt0.substring(strGiftDiffBidAmt0DotIndex+1);
			strGiftDiffBidAmt0DotRight = trimNum(strGiftDiffBidAmt0DotRight);
			sb.append(", 우선, ")
			.append(", 매수호까 잔량은, ")
			.append(strGiftDiffBidAmt0DotLeft)
			.append(", 쩜, [")
			.append(strGiftDiffBidAmt0DotRight)
			.append("], 포인트에, ");
		}
		
		//우선매수계약	m_strGiftBidVol0
		if(m_strGiftBidVol0.equals("0") || m_strGiftBidVol0.equals("") || m_strGiftBidVol0.equals(null)){
			sb.append(", 우선, ")
			.append(", 매수호까 계약, ")
			.append(", 없고, ");
		}else{
			sb.append(m_strGiftBidVol0)
			.append(", 계약, ");
		}
		
		//차선매도호까잔량	m_strGiftDiffOfferAmt3
		if(m_strGiftDiffOfferAmt3.equals("0000.00") || m_strGiftDiffOfferAmt3.equals("0") || m_strGiftDiffOfferAmt3.equals("") || m_strGiftDiffOfferAmt3.equals(null)){
			sb.append(", 차선, ")
			.append(", 매도호까 잔량은, ")
			.append(", 없고, ");
		}else{
			int strGiftDiffOfferAmt3DotIndex = m_strGiftDiffOfferAmt3.indexOf(".");
			String strGiftDiffOfferAmt3DotLeft = m_strGiftDiffOfferAmt3.substring(0, strGiftDiffOfferAmt3DotIndex);
			strGiftDiffOfferAmt3DotLeft = trimNum(strGiftDiffOfferAmt3DotLeft);
			String strGiftDiffOfferAmt3DotRight = m_strGiftDiffOfferAmt3.substring(strGiftDiffOfferAmt3DotIndex+1);
			strGiftDiffOfferAmt3DotRight = trimNum(strGiftDiffOfferAmt3DotRight);
			sb.append(", 차선, ")
			.append(", 매도호까 잔량은, ")
			.append(strGiftDiffOfferAmt3DotLeft)
			.append(", 쩜, [")
			.append(strGiftDiffOfferAmt3DotRight)
			.append("], 포인트에, ");
		}
		
		//차선매도계약	m_strGiftOfferVol3
		if(m_strGiftOfferVol3.equals("0") || m_strGiftOfferVol3.equals("") || m_strGiftOfferVol3.equals(null)){
			sb.append(", 차선, ")
			.append(", 매도호까 계약, ")
			.append(", 없고, ");
		}else{
			sb.append(m_strGiftOfferVol3)
			.append(", 계약, ");
		}
		
		//차선매수호까잔량	m_strGiftDiffBidAmt1
		if(m_strGiftDiffBidAmt1.equals("0000.00") || m_strGiftDiffBidAmt1.equals("0") || m_strGiftDiffBidAmt1.equals("") || m_strGiftDiffBidAmt1.equals(null)){
			sb.append(", 차선, ")
			.append(", 매수호까 잔량은, ")
			.append(", 없고, ");
		}else{
			int strGiftDiffBidAmt1DotIndex = m_strGiftDiffBidAmt1.indexOf(".");
			String strGiftDiffBidAmt1DotLeft = m_strGiftDiffBidAmt1.substring(1, strGiftDiffBidAmt1DotIndex);
			strGiftDiffBidAmt1DotLeft = trimNum(strGiftDiffBidAmt1DotLeft);
			String strGiftDiffBidAmt1DotRight = m_strGiftDiffBidAmt1.substring(strGiftDiffBidAmt1DotIndex+1);
			strGiftDiffBidAmt1DotRight = trimNum(strGiftDiffBidAmt1DotRight);
			sb.append(", 차선, ")
			.append(", 매수호까 잔량은, ")
			.append(strGiftDiffBidAmt1DotLeft)
			.append(", 쩜, [")
			.append(strGiftDiffBidAmt1DotRight)
			.append("], 포인트에, ");
		}
		
		//차선매수계약	m_strGiftBidVol1
		if(m_strGiftBidVol1.equals("0") || m_strGiftBidVol1.equals("") || m_strGiftBidVol1.equals(null)){
			sb.append(", 차선, ")
			.append(", 매수호까 계약, ")
			.append(", 없고, ");
		}else{
			sb.append(m_strGiftBidVol1)
			.append(", 계약, ");
		}
		
		//총매도호까잔량	m_strGiftOfferVol5
		if(m_strGiftOfferVol5.equals("0") || m_strGiftOfferVol5.equals("") || m_strGiftOfferVol5.equals(null)){
			sb.append(", 총 매도 호까잔량, ")
			.append(", 없고, ");
		}else{
			sb.append(",, 총 매도 호까잔량, ")
			.append(m_strGiftOfferVol5)
			.append(", 계약, ");
		}
		
		//총매수호까잔량	m_strGiftBidVol5
		if(m_strGiftBidVol5.equals("0") || m_strGiftBidVol5.equals("") || m_strGiftBidVol5.equals(null)){
			sb.append(", 총 매수 호까잔량, ")
			.append(", 없고, ");
		}else{
			sb.append(",, 총 매수 호까잔량, ")
			.append(m_strGiftBidVol5)
			.append(", 계약, ");
		}
		
		//총매도건수	m_strGiftOfferCnt5
		if(m_strGiftOfferCnt5.equals("0") || m_strGiftOfferCnt5.equals("") || m_strGiftOfferCnt5.equals(null)){
			sb.append(", 총 매도 껀수, ")
			.append(", 없고, ");
		}else{
			sb.append(", 총 매도 껀수, ")
			.append(m_strGiftOfferCnt5)
			.append(", 껀 , ");
		}
		
		//총매수건수	m_strGiftBidCnt5
		if(m_strGiftBidCnt5.equals("0") || m_strGiftBidCnt5.equals("") || m_strGiftBidCnt5.equals(null)){
			sb.append(", 총 매수 껀수, ")
			.append(", 없습니다. , ");
		}else{
			sb.append(", 총 매수 껀수, ")
			.append(m_strGiftBidCnt5)
			.append(", 껀, 으로, ");
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
