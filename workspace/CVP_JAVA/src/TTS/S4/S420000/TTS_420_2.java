package TTS.S4.S420000;

import java.util.Hashtable;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;
import com.isiClient.LogWriter;

public class TTS_420_2 extends ActionElementBase{
	public void doAction(String name, ActionElementData actionAPI) throws AudiumException {
		Hashtable table = (Hashtable) actionAPI.getSessionData("g_objHostRecv");
		if(table != null && !table.isEmpty()){
			StringBuffer sb = new StringBuffer();
			try{
				String A_CNT = (String) actionAPI.getSessionData("A_CNT");//그리드카운트
				int CNT = Integer.parseInt(A_CNT);
				for(int i=0; i<CNT; i++){
					String m_strItemNm = (String) table.get("A"+String.valueOf(i)+"_"+"ItemNm"); //종목명 
					String m_strBspr = (String) table.get("A"+String.valueOf(i)+"_"+"Bspr"); //당일기준가격  (ex : A0_Bspr=00000001033.29000)
					m_strBspr = trimNum(m_strBspr);
					String m_strBlqty = (String) table.get("A"+String.valueOf(i)+"_"+"Blqty"); // 잔고수량 (ex : A0_Blqty=0000000002331865)
					m_strBlqty = trimNum(m_strBlqty);
					String m_strIvstPrin = (String) table.get("A"+String.valueOf(i)+"_"+"IvstPrin"); // 투자원금 (ex: A0_IvstPrin=0000002100000)
					m_strIvstPrin = trimNum(m_strIvstPrin);
					String m_strTaxaEstmAmt = (String) table.get("A"+String.valueOf(i)+"_"+"TaxaEstmAmt"); // 세후평가금액  (ex : A0_TaxaEstmAmt=0000002397552)
					m_strTaxaEstmAmt = trimNum(m_strTaxaEstmAmt);
					String m_strAccmYirt = (String) table.get("A"+String.valueOf(i)+"_"+"AccmYirt"); // 누적수익률 (ex : A0_AccmYirt=00000014.17)
					m_strAccmYirt = trimNum(m_strAccmYirt);
					
					int num = i+1;
					
					sb.append(String.valueOf(num)).append(", 번, ");
					
					if(m_strItemNm.equals("0") || m_strItemNm.equals("") || m_strItemNm.equals(null)){
						sb.append(",");
					}else{
						sb.append(m_strItemNm).append(", ");
					}
					
					if(m_strBspr.equals("0") || m_strBspr.equals("") || m_strBspr.equals(null)){
						sb.append(",기준가격, 없으며,");
					}else{
						sb.append(", 기준가격, ")
						.append(m_strBspr)
						.append(", 원, 이며,");
					}
					
					if(m_strBlqty.equals("0") || m_strBlqty.equals("") || m_strBlqty.equals(null)){
						sb.append(",잔고수량, 없으며,");
					}else{
						sb.append(", 잔고수량, ")
						.append(m_strBlqty)
						.append(", 좌, 이며,");
					}					
					
					if(m_strIvstPrin.equals("0") || m_strIvstPrin.equals("") || m_strIvstPrin.equals(null)){
						sb.append(",매입금액, 없으며,");
					}else{
						sb.append(", 매입금액, ")
						.append(m_strIvstPrin)
						.append(", 원, 이며,");
					}
					
					if(m_strTaxaEstmAmt.equals("0") || m_strTaxaEstmAmt.equals("") || m_strTaxaEstmAmt.equals(null)){
						sb.append(",세후평가금액, 없으며,");
					}else{
						sb.append(", 세후평가금액, ")
						.append(m_strTaxaEstmAmt)
						.append(", 원, 이며,");
					}
					
					if(m_strAccmYirt.equals("0") || m_strAccmYirt.equals("") || m_strAccmYirt.equals(null)){
						sb.append(",수익률은, 없습니다.");
					}else{
						sb.append(", 수익률은, ")
						.append(m_strAccmYirt)
						.append(", 퍼센트, 입니다.");
					}
				}
				actionAPI.setSessionData("ment", sb.toString());
			}catch (Exception e){
				actionAPI.setSessionData("ment", "error");
			}
		}
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
