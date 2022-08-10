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

public class CheckCallBackTime extends ActionElementBase{

	@Override
	public void doAction(String arg0, ActionElementData actionAPI)
			throws AudiumException {
		// TODO Auto-generated method stub
		
		String callkey = (String)actionAPI.getSessionData(DEF_VAR.M_strCALL_KEY);
		String ani = (String)actionAPI.getSessionData(DEF_VAR.M_strAnyNum);
		String vruname = "CW0000";
		try {
			
			LogWriter logwrite = new LogWriter();
			
			String result = "false";
			
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("HHmm");
			
			String time = format.format(date);
			
			Calendar cal = Calendar.getInstance();
			int today = cal.get(Calendar.DAY_OF_WEEK);

			String query = "SELECT * FROM ARS_CBTIME_MNG WHERE DAY_NO = " + today;
			DBConnectOracle dbObj = new DBConnectOracle("search");
			Hashtable table = dbObj.doExcuteQuery(query);
			
			logwrite.standWrite(callkey, vruname, ani, "Check Callback SQL [" + query + "]");
			
			if(table == null || table.isEmpty() || !table.get(DBConnectOracle.KEY_RET).equals("0")) {
				
				logwrite.standWrite(callkey, vruname, ani, "DB DATA IS NULL !! TRY SEARCH INI FILE !! ");
				IniFileProcess iniProcess = new IniFileProcess("C:\\isiArsLib\\config\\CallBack.ini");
				
				String startTime = iniProcess.GetProfileString(getCallBackTime(today), "START_TIME");
				String endTime = iniProcess.GetProfileString(getCallBackTime(today), "END_TIME");
				
				logwrite.standWrite(callkey, vruname, ani, "현재시간["+time+"] , 콜백 이용가능시간 ["+startTime+" ~ "+endTime+"]");
				
				if(Integer.parseInt(startTime) <= Integer.parseInt(time) && Integer.parseInt(endTime) >= Integer.parseInt(time)){
					result = "true";
				}
				
			} else {
				int cnt = Integer.parseInt((String)table.get(DBConnectOracle.KEY_CNT));
				
				for (int i = 0; i < cnt; i++) {
					String callUseYN = (String) table.get("R"+i+"C4");
					String startTime = (String) table.get("R"+i+"C2");
					String endTime = (String) table.get("R"+i+"C3");
					
					logwrite.standWrite(callkey, vruname, ani, "현재시간["+time+"] , 콜백 이용가능시간 ["+startTime+" ~ "+endTime+"]");
					
					
					if(callUseYN.equalsIgnoreCase("N")) {
						result = "false";
						break;
					} else {
						if(Integer.parseInt(startTime) <= Integer.parseInt(time) && Integer.parseInt(endTime) >= Integer.parseInt(time)){
							result = "true";
							break;
						}
					}
					
				}
			}
			
			logwrite.standWrite(callkey, vruname, ani, "콜백 이용 가능 유무["+result+"]");
			
			actionAPI.setSessionData("callBackResult", result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
