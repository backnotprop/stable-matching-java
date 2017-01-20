package StableMatch;

import java.util.ArrayList;
import java.util.Map;


public class Entity {

    public Entity(Map base) {
        _id = (String) base.get("id");
        _name = (String) base.get("name");
        _prefs = (ArrayList<Map>) base.get("prefs");
        _hasAcceptedSentProposal = false;
        _hasAcceptedReceivedProposal = false;
        _acceptedReceivedRank = -1;
        _acceptedSentID = -1;
        _acceptedReceivedID = -1;
        _acceptedSentRank = -1;
    }

    private String _id;
    private String _name;
    private Integer _acceptedSentRank;
    private Integer _acceptedSentID;
    private Boolean _hasAcceptedReceivedProposal;
    private Integer _acceptedReceivedRank;
    private Boolean _hasAcceptedSentProposal;
    private Integer _acceptedReceivedID;

    private ArrayList<Map> _prefs;

    public Integer getPreferenceStrength(String id) {
        Integer s = -1;
        for(Map pref: _prefs) {
            if(((String)pref.get("id")).equals(id)) {
                s = (Integer)pref.get("strength");
                break;
            }
        }
        return s;
    }


    public String    getId() { return _id; }
    public String    getName() { return _name; }
    public ArrayList<Map> getPrefs() { return _prefs; }
    public Integer   getAcceptedSentRank(){ return _acceptedSentRank; }
    public Integer   getAcceptedSentID(){ return _acceptedSentID; }
    public Boolean   getHasAcceptedReceivedProposal(){ return _hasAcceptedReceivedProposal; }
    public Integer   getAcceptedReceivedRank(){ return _acceptedReceivedRank; }
    public Boolean   getHasAcceptedSentProposal(){ return _hasAcceptedSentProposal; }
    public Integer   getAcceptedReceivedID() { return _acceptedReceivedID; }

    public void setAcceptedSentRank(Integer a){ _acceptedSentRank = a;}
    public void setAcceptedSentID(Integer a){ _acceptedSentID = a; }
    public void setHasAcceptedReceivedProposal(Boolean b){ _hasAcceptedReceivedProposal = b; }
    public void setAcceptedReceivedRank(Integer a){ _acceptedReceivedRank = a; }
    public void setHasAcceptedSentProposal(Boolean b){ _hasAcceptedSentProposal = b;}
    public void setAcceptedReceivedID(Integer a) { _acceptedReceivedID = a; }
}
