package MAIN;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;
import java.util.Hashtable;

public class G00000 extends ActionElementBase {

 private static final char GENERAL_CALL = 'G';
 private static final char FOREIGN_CALL = 'F';
 private static final char PUBLIC_CALL = 'P';

 class callInfo {
  private String strAppName = "";
  private char chInboundType = ' ';
  private String strNumber = "";
  private String strDesc = "";

  private callInfo(String strAppName, char chInboundType,
    String strNumber, String strDesc) {
   this.strAppName = strAppName;
   this.chInboundType = chInboundType;
   this.strNumber = strNumber;
   this.strDesc = strDesc;
  }

  public String getCV1_Number() {
   return String.format(
     "%c%-39s",
     new Object[] { Character.valueOf(this.chInboundType),
       this.strNumber }).replace(' ', '_');
  }

  public String getAppName() {
   if (this.strAppName == null) {
    this.strAppName = "";
   }
   return this.strAppName;
  }
 }

 public void doAction(String name, ActionElementData actionAPI)
   throws AudiumException {
  String Hunt = (String) actionAPI.getSessionData("Hunt");
  if (Hunt == null) {
   Hunt = "";
  }
  actionAPI.setSessionData("CV1",
    String.format("%40s", new Object[] { "" }).replace(' ', '_'));
  actionAPI.setSessionData("CV2",
    String.format("%40s", new Object[] { "" }).replace(' ', '_'));
  actionAPI.setSessionData("CV3",
    String.format("%40s", new Object[] { "" }).replace(' ', '_'));
  actionAPI.setSessionData("CV4",
    String.format("%40s", new Object[] { "" }).replace(' ', '_'));
  actionAPI.setSessionData("CV5",
    String.format("%40s", new Object[] { "" }).replace(' ', '_'));
  actionAPI.setSessionData("CV6",
    String.format("%40s", new Object[] { "" }).replace(' ', '_'));
  actionAPI.setSessionData("CV7",
    String.format("%40s", new Object[] { "" }).replace(' ', '_'));
  actionAPI.setSessionData("CV8",
    String.format("%40s", new Object[] { "" }).replace(' ', '_'));
  actionAPI.setSessionData("CV9",
    String.format("%40s", new Object[] { "" }).replace(' ', '_'));
  actionAPI.setSessionData("CV10",
    String.format("%40s", new Object[] { "" }).replace(' ', '_'));

  settingMoveApp(Hunt, actionAPI);
 }

 public Hashtable<String, callInfo> initMenuInfo() {
  Hashtable<String, callInfo> hash = new Hashtable();
  hash.put("50001", new callInfo("MDA000", 'G', "1588-9200","??????????????(????)"));
  hash.put("50051", new callInfo("MDA000", 'F', "1588-9200","??????????????(????)"));
  hash.put("50071", new callInfo("MDA000", 'P', "1588-9200","??????????????(????)"));
  
  hash.put("50002", new callInfo("MDA000", 'G', "1588-9300","??????????????_ARS(????)"));
  hash.put("50052", new callInfo("MDA000", 'F', "1588-9300","??????????????_ARS(????)"));
  hash.put("50072", new callInfo("MDA000", 'P', "1588-9300","??????????????_ARS(????)"));
  
  hash.put("50003", new callInfo("MDA000", 'G', "1644-9200","??????????????(????)"));
  hash.put("50053", new callInfo("MDA000", 'F', "1644-9200","??????????????(????)"));
  hash.put("50073", new callInfo("MDA000", 'P', "1644-9200","??????????????(????)"));
  
  hash.put("50004", new callInfo("MDA000", 'G', "1644-9300","??????????????(????)"));
  hash.put("50054", new callInfo("MDA000", 'F', "1644-9300","??????????????(????)"));
  hash.put("50074", new callInfo("MDA000", 'P', "1644-9300","??????????????(????)"));
  
  hash.put("50005", new callInfo("MDA000", 'G', "1577-9301","????????????(????)"));
  hash.put("50055", new callInfo("MDA000", 'F', "1577-9301","????????????(????)"));
  hash.put("50075", new callInfo("MDA000", 'P', "1577-9301","????????????(????)"));
  
  
  hash.put("50006", new callInfo("MDA000", 'G', "1588-6800","????????????(????)"));
  hash.put("50056", new callInfo("MDA000", 'F', "1588-6800","????????????(????)"));
  hash.put("50056", new callInfo("MDA000", 'P', "1588-6800","????????????(????)"));
  
  hash.put("50007", new callInfo("MDF000", 'G', "1577-9300", "????????????????"));
  hash.put("50057", new callInfo("MDF000", 'F', "1577-9300", "????????????????"));
  
  hash.put("50008", new callInfo("MDA000", 'G', "1588-3322", "????????"));
  hash.put("50058", new callInfo("MDA000", 'F', "1588-3322", "????????"));
  
  hash.put("50009", new callInfo("MDD000", 'G', "1577-4600", "VIP????????????"));
  hash.put("50010", new callInfo("MDG000", 'G', "1588-7400","????????????????????"));
  hash.put("50010", new callInfo("MDG000", 'F', "1588-7400","????????????????????")); 
  hash.put("50011", new callInfo("MDH000", 'G', "3774-2000","????????????????"));
  hash.put("50012", new callInfo("MDI000", 'G', "3774-7000","????????VIP????????"));
  hash.put("50013", new callInfo("ME0000", 'G', "3774-1700", "????????????")); // **********************
  hash.put("50014", new callInfo("MDN000", 'G', "080-396-0026", "????????????"));
  hash.put("50015", new callInfo("MDJ000", 'G', "080-555-9200","SMS????????"));
  hash.put("50016", new callInfo("MDK000", 'G', "080-234-9300", "????????????"));
  hash.put("50017", new callInfo("MDB000", 'G', "1544-5533", "????????????????"));
  hash.put("50018", new callInfo("MDC000", 'G', "1644-3322", "??????????????"));
  hash.put("50019", new callInfo("MDL000", 'G', "500-0622", "??????????????"));
  hash.put("50020", new callInfo("MDP000", 'G', "1599-3322", "????????????"));
  hash.put("50021", new callInfo("MDA000", 'G', "6967-2921", "??????&????????")); // **********
  
  return hash;
 }

 public void settingMoveApp(String Hunt, ActionElementData actionAPI) {
  try {
   Hashtable<String, callInfo> hash = initMenuInfo();
   
   callInfo info = (callInfo) hash.get(Hunt);
   if (info != null) {
    actionAPI.setSessionData("APPNAME", info.getAppName());
    actionAPI.setSessionData("CV1", info.getCV1_Number());
   } else {
    actionAPI.setSessionData("APPNAME", "MDA000");
    actionAPI.setSessionData("CV1", "");
   }
  } catch (Exception e) {
   try {
    actionAPI.setSessionData("APPNAME", "MDA000");
    actionAPI.setSessionData("CV1", "");
   } catch (AudiumException e1) {
    e1.printStackTrace();
   }
  }
 }
}

