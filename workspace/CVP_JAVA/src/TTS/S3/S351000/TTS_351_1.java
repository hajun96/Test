package TTS.S3.S351000;
import java.util.Hashtable;
import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class TTS_351_1 extends ActionElementBase {
	public void doAction(String name, ActionElementData actionAPI)
			throws AudiumException {
		/*m_strItemNm / AX_ItemNm : 종목명
		m_strBalanSeq / AX_BalanSeq : 잔고일련번호
		m_strBspr / AX_Bspr : 당일기준가격
		m_strSellEnblQty / AX_SellEnblQty : 매도가능수량
		m_strTaxaEstmAmt / AX_TaxaEstmAmt : 세후평가금액
		m_strBlqty / AX_Blqty : 잔고수량*/
		//XX번,(종목명), 잔고수량  ##좌, 평가금액 ####원 이며, 잔고번호 ####번 입니다.
		/*
		String m_iCnt = (String) actionAPI.getSessionData("m_iCnt");//항목 시퀀스
		int m_niCnt = Integer.parseInt(m_iCnt) + 1;
		m_iCnt = String.valueOf(m_niCnt);
		String m_strItemNm = (String) actionAPI.getSessionData("m_strItemNm");			//종목명
		String m_strSellEnblQty = (String) actionAPI.getSessionData("m_strSellEnblQty");			//잔고수량	
		m_strSellEnblQty = trimNum(m_strSellEnblQty);
		Float f_m_strSellEnblQty = Float.parseFloat(m_strSellEnblQty);
		
		String m_strTaxaEstmAmt = (String) actionAPI.getSessionData("m_strTaxaEstmAmt");			//평가금액
		m_strTaxaEstmAmt = trimNum(m_strTaxaEstmAmt);
		Float f_m_strTaxaEstmAmt = Float.parseFloat(m_strTaxaEstmAmt);
		
		String m_strBalanSeq = (String) actionAPI.getSessionData("m_strBalanSeq");			//잔고번호
		m_strBalanSeq = trimNum(m_strBalanSeq);



		StringBuffer sb = new StringBuffer();
		sb.append(m_iCnt).append(", 번, ")
		.append(m_strItemNm).append(", ");
		
		if(f_m_strSellEnblQty != 0.0){
			sb.append(", 잔고 수량, ")
			.append(m_strSellEnblQty)
			.append(", 좌,");
		}else{
			sb.append(", 잔고 수량, ")
			.append(", 없고 ,");
		}
		
		if(f_m_strTaxaEstmAmt != 0.0){
			sb.append(", 평가금액, ")
			.append(m_strTaxaEstmAmt)
			.append(", 원 이며,");
		}else{
			sb.append(", 평가금액은, ")
			.append(", 없고 ,");
		}
		
		sb.append(", 잔고번호, ").append(m_strBalanSeq).append(", , ").append(", 번 입니다. , ");*/
		Hashtable table = (Hashtable) actionAPI.getSessionData("g_objHostRecv");
		if(table != null && !table.isEmpty()){
			StringBuffer sb = new StringBuffer();
			try{
				String A_CNT = (String) actionAPI.getSessionData("A_CNT");//그리드카운트
				int CNT = Integer.parseInt(A_CNT);
				
				for(int i=0; i<CNT; i++){
					String m_strItemNm = (String) table.get("A"+String.valueOf(i)+"_"+"ItemNm"); //종목명 
					String m_strSellEnblQty = (String) table.get("A"+String.valueOf(i)+"_"+"SellEnblQty"); //매도가능수량 
					m_strSellEnblQty = trimNum(m_strSellEnblQty);
					Float f_m_strSellEnblQty = Float.parseFloat(m_strSellEnblQty);
					String m_strTaxaEstmAmt = (String) table.get("A"+String.valueOf(i)+"_"+"TaxaEstmAmt"); //평가금액
					m_strTaxaEstmAmt = trimNum(m_strTaxaEstmAmt);
					Float f_m_strTaxaEstmAmt = Float.parseFloat(m_strTaxaEstmAmt);
					String m_strBalanSeq = (String) table.get("A"+String.valueOf(i)+"_"+"BalanSeq"); //잔고번호
					m_strBalanSeq = trimNum(m_strBalanSeq);

					int num = i+1;
					
					sb.append(String.valueOf(num)).append(", 번, ")
					.append(m_strItemNm).append(", ");
					
					if(f_m_strSellEnblQty != 0.0){
						sb.append(", 잔고 수량, ")
						.append(m_strSellEnblQty)
						.append(", 좌,");
					}else{
						sb.append(", 잔고 수량, ")
						.append(", 없고 ,");
					}
					
					if(f_m_strTaxaEstmAmt != 0.0){
						sb.append(", 평가금액, ")
						.append(m_strTaxaEstmAmt)
						.append(", 원 이며,");
					}else{
						sb.append(", 평가금액은, ")
						.append(", 없고 ,");
					}
					
					sb.append(", 잔고번호, ").append(m_strBalanSeq).append(", , ").append(", 번 입니다. , ");
				}
				actionAPI.setSessionData("ment", sb.toString());
			}catch (Exception e){
				actionAPI.setSessionData("ment", "error");
			}
		}
		
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