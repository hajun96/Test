package TTS.S4.S462000;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_462_2 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException { 
		/*[W61OI32_OUTPUT_Grid]
		m_strCreditItemCode	ItemScd	단축종목코드 
		m_strCreditItemFullCode	ItemNo	종목번호      
		m_strCreditItemName	ItemNm	종목명       
		m_strCreditCrdSect	CrdtSect	"신용구분, 유융 = 유통융자, 자융 = 자기융자, 유대 = 유통대주, 일담 = 일반담보대출, 자대 = 자기대주        
		대차 = 신용대차        
		매입 = 매입자금대출    
		매도 = 매도자금담보대출
		대용 = 대용미수금      
		단기 = 단기매입자금대출
		현금 = 현금"
		m_strCreditHoldQty	HoldQty	보유수량     
		m_strCreditEnblQty	EnblQty	가능수량     
		m_strCreditLoanDate	LoanDate	대출일자     
		m_strCreditUprc	Uprc	단가         
		m_strCreditExprDate	ExprDate	만기일자*/
		//String m_strCreditItemCode = (String) actionAPI.getSessionData("m_strCreditItemCode"); //단축종목코드
		//String m_strCreditItemFullCode = (String) actionAPI.getSessionData("m_strCreditItemFullCode"); //종목번호
		String m_strCreditItemName = (String) actionAPI.getSessionData("m_strCreditItemName"); //종목명
		String m_strCreditCrdSect = (String) actionAPI.getSessionData("m_strCreditCrdSect"); //신용대출구분
		String m_strCreditHoldQty = (String) actionAPI.getSessionData("m_strCreditHoldQty"); //보유수량
		m_strCreditHoldQty = trimNum(m_strCreditHoldQty);
		//String m_strCreditEnblQty = (String) actionAPI.getSessionData("m_strCreditEnblQty"); //가능수량
		String m_strCreditLoanDate = (String) actionAPI.getSessionData("m_strCreditLoanDate"); //대출일자
		String year = m_strCreditLoanDate.substring(0, 4);
		String month = m_strCreditLoanDate.substring(4, 6);
		String day = m_strCreditLoanDate.substring(6);
		month = trimNum(month);
		day = trimNum(day);
		//String m_strCreditExprDate = (String) actionAPI.getSessionData("m_strCreditExprDate"); //만기일자
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(m_strCreditItemName);
		
		if(m_strCreditCrdSect.equals("유융")){
			sb.append(m_strCreditHoldQty)
			.append(", 주, ")
			.append(", 신용구분은, ")
			.append(", 유통융자, ")
			.append(", 융자 일자는, ")
			.append(year).append(", 년, ").append(month).append(", 월, ").append(day).append(", 일, ")
			.append(", 입니다. ");
		}else if(m_strCreditCrdSect.equals("자융")){
			sb.append(m_strCreditHoldQty)
			.append(", 주, ")
			.append(", 신용구분은, ")
			.append(", 자기융자, ")
			.append(", 융자 일자는, ")
			.append(year).append(", 년, ").append(month).append(", 월, ").append(day).append(", 일, ")
			.append(", 입니다. ");
		}else if(m_strCreditCrdSect.equals("유대")){
			sb.append(m_strCreditHoldQty)
			.append(", 주, ")
			.append(", 신용구분은, ")
			.append(", 유통대주, ")
			.append(", 융자 일자는, ")
			.append(year).append(", 년, ").append(month).append(", 월, ").append(day).append(", 일, ")
			.append(", 입니다. ");
		}else if(m_strCreditCrdSect.equals("일담")){
			sb.append(m_strCreditHoldQty)
			.append(", 주, ")
			.append(", 신용구분은, ")
			.append(", 일반담보대출, ")
			.append(", 융자 일자는, ")
			.append(year).append(", 년, ").append(month).append(", 월, ").append(day).append(", 일, ")
			.append(", 입니다. ");
		}else if(m_strCreditCrdSect.equals("자대")){
			sb.append(m_strCreditHoldQty)
			.append(", 주, ")
			.append(", 신용구분은, ")
			.append(", 자기대주, ")
			.append(", 융자 일자는, ")
			.append(year).append(", 년, ").append(month).append(", 월, ").append(day).append(", 일, ")
			.append(", 입니다. ");
		}else if(m_strCreditCrdSect.equals("대차")){
			sb.append(m_strCreditHoldQty)
			.append(", 주, ")
			.append(", 신용구분은, ")
			.append(", 신용대차, ")
			.append(", 융자 일자는, ")
			.append(year).append(", 년, ").append(month).append(", 월, ").append(day).append(", 일, ")
			.append(", 입니다. ");
		}else if(m_strCreditCrdSect.equals("매입")){
			sb.append(m_strCreditHoldQty)
			.append(", 주, ")
			.append(", 신용구분은, ")
			.append(", 매입자금대출, ")
			.append(", 융자 일자는, ")
			.append(year).append(", 년, ").append(month).append(", 월, ").append(day).append(", 일, ")
			.append(", 입니다. ");
		}else if(m_strCreditCrdSect.equals("매도")){
			sb.append(m_strCreditHoldQty)
			.append(", 주, ")
			.append(", 신용구분은, ")
			.append(", 매도자금담보대출, ")
			.append(", 융자 일자는, ")
			.append(year).append(", 년, ").append(month).append(", 월, ").append(day).append(", 일, ")
			.append(", 입니다. ");
		}else if(m_strCreditCrdSect.equals("대용")){
			sb.append(m_strCreditHoldQty)
			.append(", 주, ")
			.append(", 신용구분은, ")
			.append(", 대용미수금, ")
			.append(", 융자 일자는, ")
			.append(year).append(", 년, ").append(month).append(", 월, ").append(day).append(", 일, ")
			.append(", 입니다. ");
		}else if(m_strCreditCrdSect.equals("단기")){
			sb.append(m_strCreditHoldQty)
			.append(", 주, ")
			.append(", 신용구분은, ")
			.append(", 단기매입자금대출, ")
			.append(", 융자 일자는, ")
			.append(year).append(", 년, ").append(month).append(", 월, ").append(day).append(", 일, ")
			.append(", 입니다. ");
		}else{
			sb.append("");
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
