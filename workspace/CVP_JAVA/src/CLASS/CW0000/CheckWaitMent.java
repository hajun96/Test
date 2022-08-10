package CLASS.CW0000;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;
import com.isiClient.DBConnectOracle;
import com.isiClient.IniFileProcess;
import com.isiClient.LogWriter;
import com.isiConst.DEF_VAR;

public class CheckWaitMent extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
		LogWriter writer = new LogWriter();
		String callkey = (String)actionAPI.getSessionData(DEF_VAR.M_strCALL_KEY);
		String ani = (String)actionAPI.getSessionData(DEF_VAR.M_strAnyNum);
		try {
			
			String strWaitCnt = (String) actionAPI.getSessionData("m_strCallInQ");
			String strWaitTime = (String) actionAPI.getSessionData("m_strEWT");
			
			if(strWaitTime.indexOf(".") > 0) {
				strWaitTime = strWaitTime.substring(0, strWaitTime.indexOf("."));
			}
			
			
			int  waitCnt = Integer.parseInt(strWaitCnt);
			int waitTime = Integer.parseInt(strWaitTime);
			
			
			String timeStr = convertTimeString(waitTime);
			
			Hashtable table = (Hashtable)actionAPI.getSessionData("DB_OBJ");
			
			String result = "";
			String waitCntStr = String.valueOf(waitCnt);
			String waitCntStr_1 = convertString(waitCntStr);
			
			if(waitCntStr_1.isEmpty()) {
				result = "현재 고객님의 예상 대기 순서는, 약, " +  waitCntStr + ",번째 입니다.";
			} else {
				result = "현재 고객님의 예상 대기 순서는, " +  waitCntStr_1 + ",번째 입니다.";
			}
			
//			result = "현재 고객님의 예상대기 시간은, " + timeStr + " , 이며, 예상 대기 순서는, " +  waitCntStr + ",번째 입니다.";
			
			if(table == null || table.isEmpty() || !table.get(DBConnectOracle.KEY_RET).equals("0")) {
				
			} else {
				
				int cnt = Integer.parseInt((String)table.get(DBConnectOracle.KEY_CNT));
				writer.standWrite(callkey, "CW0000", ani, "SELECT RESULT [" + table.toString() +"]");
				
//				S_CNT, E_CNT, MENT_CONT, USE_YN
				for (int i = 0; i < cnt; i++) {
					int startCnt = Integer.parseInt((String)table.get("R"+i+"C0"));
					int endCnt = Integer.parseInt((String)table.get("R"+i+"C1"));
					
					if(waitCnt >= startCnt && waitCnt <= endCnt) {
						result +=(String) table.get("R"+i+"C2");
						break;
					}
					
				}
				
				if(result.isEmpty()) {
					result += "현재 고객님의 예상대기 시간은, " + timeStr + " , 이며, 예상대기 순서는, " +  waitCntStr + ",번째 입니다.";
				}
				
			}
			writer.standWrite(callkey, "CW0000", ani, "대기 안내 멘트 [" + result + "]");
			actionAPI.setSessionData("ment", result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writer.standWrite(callkey, "CW0000", ani, "## Exception !! " + e.toString());
		}

	}
	
	
	
	private String convertString(String waitCnt) {
		// TODO Auto-generated method stub
		
		String retStr = "";
		if(Integer.parseInt(waitCnt) <= 0) {
			return "";
		}
		
		if(waitCnt.equals("1")) {
			retStr = "첫";
		} else if(waitCnt.equals("2")) {
			retStr = "두";
		} else if(waitCnt.equals("3")) {
			retStr = "세";
		} else if(waitCnt.equals("4")) {
			retStr = "네";
		} else if(waitCnt.equals("5")) {
			retStr = "다섯";
		} else if(waitCnt.equals("6")) {
			retStr = "여섯";
		} else if(waitCnt.equals("7")) {
			retStr = "일곱";
		} else if(waitCnt.equals("8")) {
			retStr = "여덟";
		} else if(waitCnt.equals("9")) {
			retStr = "아홉";
		} else if(waitCnt.equals("10")) {
			retStr = "열";
		}
		
		return retStr;
	}



	private String convertTimeString(int waitTime) {
		// TODO Auto-generated method stub
		
		int hour = 0;
		int min = 0;
		int second = 0;
		int temp = 0;
		String result = "";
		
		hour = waitTime / 3600;
		temp = waitTime % 3600;
		min = temp / 60;
		second = temp % 60;
		
		if(hour > 0) {
			result += String.valueOf(hour) + ", 시간,";
		}
		if(min > 0) {
			result += String.valueOf(min) + ", 분,";
		}
		if(second > 0) {
			result += String.valueOf(second) + ", 초,";
		}
		
		return result;
	}

	
	
	
	
	

	private String convertAgtType(String m_strAgtType) {
		// TODO Auto-generated method stub
		
		String result = "";
		if(m_strAgtType.equalsIgnoreCase("A")) {
			result = "단순주문";
		} else if (m_strAgtType.equalsIgnoreCase("B")) {
			result = "일반업무";
		} else if (m_strAgtType.equalsIgnoreCase("C")) {
			result = "사이버매체";
		} else if (m_strAgtType.equalsIgnoreCase("D")) {
			result = "VIP";
		} else if (m_strAgtType.equalsIgnoreCase("E")) {
			result = "사기신고";
		} else if (m_strAgtType.equalsIgnoreCase("F")) {
			result = "방문계좌개설";
		} else if (m_strAgtType.equalsIgnoreCase("G")) {
			result = "교환업무";
		} else if (m_strAgtType.equalsIgnoreCase("H")) {
			result = "기타";
		} else if (m_strAgtType.equalsIgnoreCase("I")) {
			result = "진상";
		} else if (m_strAgtType.equalsIgnoreCase("J")) {
			result = "외국인(영어)";
		} else if (m_strAgtType.equalsIgnoreCase("K")) {
			result = "외국인(중국어)";
		} else if (m_strAgtType.equalsIgnoreCase("L")) {
			result = "은행개설";
		} else if (m_strAgtType.equalsIgnoreCase("M")) {
			result = "금융상품";
		} else if (m_strAgtType.equalsIgnoreCase("N")) {
			result = "투자상담(스마트)";
		} else if (m_strAgtType.equalsIgnoreCase("O")) {
			result = "단순주문(스마트)";
		} else if (m_strAgtType.equalsIgnoreCase("P")) {
			result = "금융상품(스마트)";
		} else if (m_strAgtType.equalsIgnoreCase("Q")) {
			result = "퇴직연금";
		} else if (m_strAgtType.equalsIgnoreCase("R")) {
			result = "타사대체";
		} else if (m_strAgtType.equalsIgnoreCase("S")) {
			result = "헬프데스크";
		}
		
		return result;
	}



	private String getCallBackTime(int today) {
		// TODO Auto-generated method stub
		
		String result = "";
		
		switch (today) {
		case 1:
			result = "SUN";
			break;
		case 2:
			result = "MON";
			break;
		case 3:
			result = "TUE";
			break;
		case 4:
			result = "WED";
			break;
		case 5:
			result = "THU";
			break;
		case 6:
			result = "FRI";
			break;
		case 7:
			result = "SAT";
			break;
		default:
			break;
		}
		
		return result;
		
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
