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
				result = "���� ������ ���� ��� ������, ��, " +  waitCntStr + ",��° �Դϴ�.";
			} else {
				result = "���� ������ ���� ��� ������, " +  waitCntStr_1 + ",��° �Դϴ�.";
			}
			
//			result = "���� ������ ������ �ð���, " + timeStr + " , �̸�, ���� ��� ������, " +  waitCntStr + ",��° �Դϴ�.";
			
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
					result += "���� ������ ������ �ð���, " + timeStr + " , �̸�, ������ ������, " +  waitCntStr + ",��° �Դϴ�.";
				}
				
			}
			writer.standWrite(callkey, "CW0000", ani, "��� �ȳ� ��Ʈ [" + result + "]");
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
			retStr = "ù";
		} else if(waitCnt.equals("2")) {
			retStr = "��";
		} else if(waitCnt.equals("3")) {
			retStr = "��";
		} else if(waitCnt.equals("4")) {
			retStr = "��";
		} else if(waitCnt.equals("5")) {
			retStr = "�ټ�";
		} else if(waitCnt.equals("6")) {
			retStr = "����";
		} else if(waitCnt.equals("7")) {
			retStr = "�ϰ�";
		} else if(waitCnt.equals("8")) {
			retStr = "����";
		} else if(waitCnt.equals("9")) {
			retStr = "��ȩ";
		} else if(waitCnt.equals("10")) {
			retStr = "��";
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
			result += String.valueOf(hour) + ", �ð�,";
		}
		if(min > 0) {
			result += String.valueOf(min) + ", ��,";
		}
		if(second > 0) {
			result += String.valueOf(second) + ", ��,";
		}
		
		return result;
	}

	
	
	
	
	

	private String convertAgtType(String m_strAgtType) {
		// TODO Auto-generated method stub
		
		String result = "";
		if(m_strAgtType.equalsIgnoreCase("A")) {
			result = "�ܼ��ֹ�";
		} else if (m_strAgtType.equalsIgnoreCase("B")) {
			result = "�Ϲݾ���";
		} else if (m_strAgtType.equalsIgnoreCase("C")) {
			result = "���̹���ü";
		} else if (m_strAgtType.equalsIgnoreCase("D")) {
			result = "VIP";
		} else if (m_strAgtType.equalsIgnoreCase("E")) {
			result = "���Ű�";
		} else if (m_strAgtType.equalsIgnoreCase("F")) {
			result = "�湮���°���";
		} else if (m_strAgtType.equalsIgnoreCase("G")) {
			result = "��ȯ����";
		} else if (m_strAgtType.equalsIgnoreCase("H")) {
			result = "��Ÿ";
		} else if (m_strAgtType.equalsIgnoreCase("I")) {
			result = "����";
		} else if (m_strAgtType.equalsIgnoreCase("J")) {
			result = "�ܱ���(����)";
		} else if (m_strAgtType.equalsIgnoreCase("K")) {
			result = "�ܱ���(�߱���)";
		} else if (m_strAgtType.equalsIgnoreCase("L")) {
			result = "���ళ��";
		} else if (m_strAgtType.equalsIgnoreCase("M")) {
			result = "������ǰ";
		} else if (m_strAgtType.equalsIgnoreCase("N")) {
			result = "���ڻ��(����Ʈ)";
		} else if (m_strAgtType.equalsIgnoreCase("O")) {
			result = "�ܼ��ֹ�(����Ʈ)";
		} else if (m_strAgtType.equalsIgnoreCase("P")) {
			result = "������ǰ(����Ʈ)";
		} else if (m_strAgtType.equalsIgnoreCase("Q")) {
			result = "��������";
		} else if (m_strAgtType.equalsIgnoreCase("R")) {
			result = "Ÿ���ü";
		} else if (m_strAgtType.equalsIgnoreCase("S")) {
			result = "��������ũ";
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
