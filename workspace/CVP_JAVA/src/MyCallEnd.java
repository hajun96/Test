

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import com.audium.core.vfc.VPreference;
import com.audium.core.vfc.form.VBlock;
import com.audium.core.vfc.form.VForm;
import com.audium.core.vfc.util.VAction;
import com.audium.core.vfc.util.VMain;
import com.audium.server.AudiumException;
import com.audium.server.proxy.EndCallInterface;
import com.audium.server.session.CallEndAPI;
import com.isiClient.ArsLib;
import com.isiClient.LogWriter;
import com.isiClient.PropertyRead;
import com.isiConst.DEF_VAR;
import com.isiConst.LOGLEVEL;
import com.isiConst.LOGTYPE;
import com.isiConst.PROPERTIES;


public class MyCallEnd implements EndCallInterface {
	private ArsLib m_objArslib;
	private Properties tempProperties;
	private StringWriter sw;
	private PrintWriter pw;
	private String callKey;
	private String ani;
	private String svccode;
	private String secyn;
	private LogWriter lw;
	
	private String isLastDepthMenu_Path;
	private PropertyRead pr;
	private	String CV1 		;
	private	String CV2 		;
	private	String CV3		;
	private	String CV4		;
	private	String CV5		;
	private	String CV6		;
	private	String CV7		;
	private	String CV8		;
	private	String CV9		;
	private	String CV10		;
	private	String m_ErrCode;
	private	String m_CallKey;
	private	String m_CstANI	;
	private	String m_SID	;
	private	String m_BID	;
	private	String m_BIDPwd	;
	private	String m_EndType;
	private	String m_CallInQ;
	private	String m_EWT	;
	private StringBuffer sb;




	public void LogWrite(String msg) {
		String logDirectory = "C:/isiArsLib/LOG/";
		BufferedWriter br = null;
		try {
			Date today = Calendar.getInstance().getTime();
			SimpleDateFormat fomatter = new SimpleDateFormat("yyyyMMdd", java.util.Locale.KOREA);
			String current = fomatter.format(today);
			
			
			// 로그폴더/년월일/END_OBJ_년월일.log로 남음(로그양이 적기 때문에 하루치로그...)
			String logFile = logDirectory + current + File.separatorChar 
					+ "END_OBJ_" + current	+ ".log";

			long currentTime = Calendar.getInstance().getTimeInMillis();
			Date date = new Date(currentTime);
			SimpleDateFormat fommat = new SimpleDateFormat("HH:mm:ss.SSS");
			String time = fommat.format(date);
			br = new BufferedWriter(
					new FileWriter(logFile, true));

			br.write("[" + time + "] " + msg + "\r\n");
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	
	@Override
	public void onEndCall(CallEndAPI data) throws AudiumException {
		
		m_objArslib = new ArsLib();
		tempProperties = new Properties();
		sw = new StringWriter();
		pw = new PrintWriter(sw);
		pr = new PropertyRead();
		lw = new LogWriter();
		
		callKey = (String) data.getSessionData("m_CallKey");
		if(callKey == null){callKey = "";}
		ani = (String) data.getSessionData("m_CstANI");
		if(ani == null){ani = "";}
		svccode = (String) data.getSessionData(DEF_VAR.M_strSvcCode);
		if(svccode == null){svccode = "";}
		CV1 = (String) data.getSessionData("CV1");
		if(CV1 == null){CV1 = "";}
		secyn = (String) data.getSessionData(DEF_VAR.M_strAccreditFlag);
		if(secyn == null){secyn = "";}
		isLastDepthMenu_Path = pr.getValue(PROPERTIES.IS_LAST_MENU_INI);
		
		sb = new StringBuffer();

		String strAppName = "";
		String HowCallEnd = "";
		
		try {
			strAppName = data.getApplicationName();
			HowCallEnd = data.getHowCallEnded();
		} catch(Exception e) {
			
		}
		
		LogWrite("[ENDCALL] APP_NAME:" + strAppName 
				+ ", callKey:" + callKey 
				+ ", ani:" + ani
				+ ", svccode:" + svccode
				+ ", CV1:" + CV1
				+ ", secyn:" + secyn
				+ ", END-Event Type:" + HowCallEnd);
		
		
		if(HowCallEnd.equals("hangup") || HowCallEnd.equals("disconnect")) {
			VPreference pref = null;
			VMain vxml = null;
			
			try {
				pref = data.getPreference();
				vxml = VMain.getNew(pref);
				VForm ret_form = VForm.getNew(pref, "custom_subdialog_return");
				VBlock ret_blk = VBlock.getNew(pref);
				
				 CV1 		= (String)data.getSessionData("CV1");
				 CV2 		= (String)data.getSessionData("CV2");
				 CV3		= (String)data.getSessionData("CV3");
				 CV4		= (String)data.getSessionData("CV4");
				 CV5		= (String)data.getSessionData("CV5");
				 CV6		= (String)data.getSessionData("CV6");
				 CV7		= (String)data.getSessionData("CV7");
				 CV8		= (String)data.getSessionData("CV8");
				 CV9		= (String)data.getSessionData("CV9");
				 CV10		= (String)data.getSessionData("CV10");
				 m_ErrCode	= (String)data.getSessionData("m_ErrCode");
				 m_CallKey	= (String)data.getSessionData("m_CallKey");
				 m_CstANI	= (String)data.getSessionData("m_CstANI");
				 m_SID		= (String)data.getSessionData("c_SID");
				 m_BID		= (String)data.getSessionData("c_BID");
				 m_BIDPwd	= (String)data.getSessionData("c_BIDPwd");
				 m_EndType	= (String)data.getSessionData("m_EndType");
				 m_CallInQ	= (String)data.getSessionData("m_CallInQ");
				 m_EWT		= (String)data.getSessionData("m_EWT");
				
				 
				ret_blk.add(VAction.getNew(pref, VAction.VARIABLE, "caller_input", "hangup", VForm.WITH_QUOTES));

				String Vxml0 = String.format("CV1=%s;CV2=%s;CV3=%s;CV4=%s", CV1, CV2, CV3, CV4);
				String Vxml1 = String.format("CV5=%s;CV6=%s;CV7=%s;CV8=%s", CV5, CV6, CV7, CV8);
				String Vxml2 = String.format("CV9=%s;CV10=%s;m_ErrCode=%s;m_CallKey=%s;m_CstANI=%s"
						, CV9, CV10, m_ErrCode, m_CallKey, m_CstANI);
				String Vxml3 = String.format("m_SID=%s;m_BID=%s;m_BIDPwd=%s;m_EndType=%s;m_CallInQ=%s;m_EWT=%s"
						, m_SID, m_BID, m_BIDPwd, m_EndType, m_CallInQ, m_EWT);
						
				ret_blk.add(VAction.getNew(pref, VAction.VARIABLE, "FromExtVXML0", Vxml0, VForm.WITH_QUOTES));
				ret_blk.add(VAction.getNew(pref, VAction.VARIABLE, "FromExtVXML1", Vxml1, VForm.WITH_QUOTES));
				ret_blk.add(VAction.getNew(pref, VAction.VARIABLE, "FromExtVXML2", Vxml2, VForm.WITH_QUOTES));
				ret_blk.add(VAction.getNew(pref, VAction.VARIABLE, "FromExtVXML3", Vxml3, VForm.WITH_QUOTES));
				
				ret_blk.add(VAction.getNew(pref, VAction.RETURN
						, "caller_input FromExtVXML0 FromExtVXML1 FromExtVXML2 FromExtVXML3"));
				
				ret_form.add(ret_blk);
				vxml.add(ret_form);
				
				data.setCustomVxmlResponse(vxml);
				
			} catch (Exception e) {
				LogWrite("[ENDCALL] EXCEPTION:" + strAppName
						+ ", callKey:" + callKey 
						+ ", ani:" + ani 
						+ ", END-Event Type:" + HowCallEnd
						+ ", Exception:" + e.toString());
			}
			
			try{
				if (isLastDepth()) {
					sendFTP(data);
				}
			}catch(Exception e){
				e.printStackTrace(pw);
				LogWrite("[ENDCALL] APP_NAME:" + strAppName
						+ ", callKey:" + callKey 
						+ ", ani:" + ani 
						+ ", END-Event Type:" + HowCallEnd
						+ ", Exception:" + sw.toString());
			}
		}
		
		sb.append("CV1[").append(CV1).append("]");
		sb.append("CV2[").append(CV2).append("]");
		sb.append("CV3[").append(CV3).append("]");
		sb.append("CV4[").append(CV4).append("]");
		sb.append("CV5[").append(CV5).append("]");
		sb.append("CV6[").append(CV6).append("]");
		sb.append("CV7[").append(CV7).append("]");
		sb.append("CV8[").append(CV8).append("]");
		sb.append("CV9[").append(CV9).append("]");
		sb.append("CV10[").append(CV10).append("]");
		
		sb.append("m_ErrCode[").append(m_ErrCode).append("]");
		sb.append("m_CallKey[").append(m_CallKey).append("]");
		sb.append("m_CstANI[").append(m_CstANI).append("]");
		sb.append("m_SID[").append(m_SID).append("]");
		sb.append("m_BID[").append(m_BID).append("]");
		sb.append("m_BIDPwd[").append(m_BIDPwd).append("]");
		sb.append("m_EndType[").append(m_EndType).append("]");
		sb.append("m_CallInQ[").append(m_CallInQ).append("]");
		sb.append("m_EWT[").append(m_EWT).append("]");
		
		lw.write(LOGLEVEL.LOG_LEVEL_1, LOGTYPE.ARS_LOG, callKey, "SVC="+svccode+", Call End !!", ani , sb.toString());
	}
	
	private void sendFTP(CallEndAPI actionData) throws Exception {
		// TODO Auto-generated method stub
		String startDate = m_objArslib.getToday();
		String endDate = m_objArslib.getToday();
		String endTime = m_objArslib.getCurrentTime();
		String startTime = m_objArslib.getCurrentTime();
		startTime = startTime.substring(0, 6);
		endTime = endTime.substring(0, 6);
		String svcName;

		if (svccode == null || svccode.isEmpty()) {
			if (actionData.getCurrentElement().length() >= 6) {
				svccode = actionData.getCurrentElement().substring(0, 6);
			} else {
				svccode = actionData.getApplicationName();
			}
		}
		
		String isAsr = "N";
		String CV1 = (String) actionData.getSessionData("CV1");
		String secyn = (String) actionData.getSessionData(DEF_VAR.M_strAccreditFlag); 
		
		if (secyn == null || secyn.isEmpty() || secyn.equals("@null")) {
			secyn = "N";
		}
		
		svcName = tempProperties.getProperty(svccode);

		if (svccode.startsWith("v") || svccode.startsWith("V")) {
			isAsr = "Y";
		}
		String tempScvName = svcName;

		tempScvName = m_objArslib.uni2ksc(tempScvName);

		String sendMsg = callKey + "," + ani + "," + svccode + ","
				+ tempScvName + "," + startDate + "," + startTime + ","
				+ endDate + "," + endTime + "," + secyn + "," + isAsr + ","
				+ CV1;
		LogWrite("[ENDCALL] APP_NAME:" + actionData.getApplicationName() 
				+ ", callKey:" + callKey 
				+ ", ani:" + ani 
				+ ", END-Event Type:" + actionData.getHowCallEnded()
				+ ", [FTP UPLOAD MSG : " + sendMsg + "]");

		String resultCode = m_objArslib.FTPUpload(callKey, ani, svccode,
				svcName, startDate, startTime, endDate, endTime, secyn, isAsr,
				CV1);
		
		LogWrite("[ENDCALL] APP_NAME:" + actionData.getApplicationName() 
				+ ", callKey:" + callKey 
				+ ", ani:" + ani 
				+ ", END-Event Type:" + actionData.getHowCallEnded()
				+ ", [FTP UPLOAD RESULT : " + resultCode + "]");
	}
	private boolean isLastDepth() {
		FileInputStream in = null;
		try {
			in = new FileInputStream(isLastDepthMenu_Path);
			tempProperties.load(in);
			in.close();
			return tempProperties.containsKey(svccode);
		} catch(Exception e) {
			try {
				if(in != null)
				in.close();
			} catch (IOException e1) {
			}
			return false;
		}
		
	}
}
