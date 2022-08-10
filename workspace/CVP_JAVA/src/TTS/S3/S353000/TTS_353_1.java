package TTS.S3.S353000;

import java.util.Hashtable;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;
import com.isiClient.LogWriter;

public class TTS_353_1 extends ActionElementBase {
	public void doAction(String name, ActionElementData actionAPI)throws AudiumException {
		Hashtable table = (Hashtable) actionAPI.getSessionData("g_objHostRecv");
		if(table != null && !table.isEmpty()){
			StringBuffer sb = new StringBuffer();
			try{
				String A_CNT = (String) actionAPI.getSessionData("A_CNT");//그리드카운트
				int CNT = Integer.parseInt(A_CNT);
				LogWriter lw = new LogWriter();
				String m_strOffrSect = (String) actionAPI.getSessionData("m_strOffrSect");			//매도매수 구분
				for(int i=0; i<CNT; i++){
					String m_strItemNm = (String) table.get("A"+String.valueOf(i)+"_"+"ItemNm"); //종목명 
					String m_strBalanSeq = (String) table.get("A"+String.valueOf(i)+"_"+"BalanSeq"); //잔고번호
					m_strBalanSeq = trimNum(m_strBalanSeq);
					String m_strOffrQty = (String) table.get("A"+String.valueOf(i)+"_"+"OffrQty"); //매도수량
					m_strOffrQty = trimNum(m_strOffrQty);
					String m_strOffrAmt = (String) table.get("A"+String.valueOf(i)+"_"+"OffrAmt"); //매수금액
					m_strOffrAmt = trimNum(m_strOffrAmt);
					
					int num = i+1;
					
					if(m_strOffrSect.equals("3")){ //매도
						sb.append(String.valueOf(num)).append(", 번, ")
						.append(m_strItemNm)
						.append(", 매도수량, ")
						.append(m_strOffrQty).append(", 좌, ")
						.append(", 잔고번호, ")
						.append(m_strBalanSeq)
						.append(", 번, 입니다.");
					}else if(m_strOffrSect.equals("2")){ //매수
						sb.append(String.valueOf(num)).append(", 번, ")
						.append(m_strItemNm)
						.append(", 매수금액, ")
						.append(m_strOffrAmt).append(", 원, ")
						.append(", 잔고번호, ")
						.append(m_strBalanSeq)
						.append(", 번, 입니다.");
					}else{
						sb.append("error");
					}
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