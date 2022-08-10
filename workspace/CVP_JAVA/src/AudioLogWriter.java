
import java.io.PrintWriter;
import java.io.StringWriter;

import com.audium.server.AudiumException;
import com.audium.server.proxy.VoiceElementInterface;
import com.audium.server.session.ElementAPI;
import com.audium.server.xml.VoiceElementConfig;
import com.audium.server.xml.VoiceElementConfig.StaticAudio;
import com.isiClient.LogWriter;
import com.isiClient.PropertyRead;
import com.isiConst.LOGLEVEL;
import com.isiConst.LOGTYPE;

public class AudioLogWriter implements VoiceElementInterface 
{
	private StringWriter sw;
	private PrintWriter pw;
	private String callKey;
	private String ani;
	private String svccode;
	private LogWriter lw;
	private PropertyRead pr;
	
	@Override
	public VoiceElementConfig getConfig(String name, ElementAPI elementAPI,
			VoiceElementConfig defaults) throws AudiumException {
		sw = new StringWriter();
		pw = new PrintWriter(sw);
		lw = new LogWriter();
		
		VoiceElementConfig.AudioGroup audioGroup = null;
		try {
			callKey = (String) elementAPI.getSessionData("m_strCallkey");
			ani 	= (String) elementAPI.getSessionData("m_strAnyNum");
			svccode = (String) elementAPI.getSessionData("m_strSvcCode");
			
			if(callKey == null) callKey = "";
			if(ani == null) ani = "";
			if(svccode == null) svccode = "";
			
			if(defaults.getAudioGroup("initial_audio_group", 1) == null) {
			} else {
				audioGroup = defaults.getAudioGroup("initial_audio_group", 1);
			}
			
			if(audioGroup != null) {
				StaticAudio item = (StaticAudio) audioGroup.getAudioItem(0);
				if(item != null) {
					lw.write(LOGLEVEL.LOG_LEVEL_1, LOGTYPE.ARS_LOG, callKey
							, elementAPI.getApplicationName() + "[" + svccode +"], " + elementAPI.getCurrentElement()
//							, "SVC=" + svccode + ", ELEMENT=" + elementAPI.getCurrentElement()
							, ani
							, "AUD: PATH=" + item.getSrc() + ", MENT=" + item.getTranscript());
					
				}
			}
		} catch(Exception e) {
			
		}
		return defaults;
	}
	
}

