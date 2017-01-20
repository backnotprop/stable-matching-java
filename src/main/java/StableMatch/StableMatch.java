package StableMatch;

import java.util.Map;

public class StableMatch {
    public Map<String,Entity> dataMap;

    public StableMatch(Map data) {
        this.dataMap = data;
    }

    /**
     * Performs first stage in stable roomates solution. Everyone sends out a proposal and
     * they are either accepted or rejected. Accepted proposals are not official matches, but hold
     * intial weight. Rejection of proposals are outright rejection in the whole process
     * <p>
     * Each entity sends a proposal request to another entity. The receiver either rejects or accepts. Receivers
     * can receive multiple requests, and may chose accept a preference over a previously accepted.
     * <p>
     * Stage is not complete until each entity has been sent an accepted proposal. If one entity is rejected by all
     * then the set does not have a stable matching
     */
    public void proposalStage() {
        Boolean allProposed = false;


        while (!allProposed) {
            String sid = _findKeyUnaccepted();
            if(sid != "none") {
                Entity newSender = dataMap.get(sid);

                // TODO
                // probably need to think about reworking intial data load and structures
                String rid = (String) newSender.getPrefs().get(1).get("id");
                Integer rRank = (Integer) newSender.getPrefs().get(1).get("strength");

                Entity receiver = dataMap.get(rid);



                _proposalProcess(newSender, receiver, rRank);

                allProposed = true;
            } else {
                allProposed = true;
            }
        }

    }

    private void _proposalProcess(Entity sender, Entity receiver, Integer receiverRank) {

        // find out how the receiver ranks the sender
        Integer senderRank = receiver.getPreferenceStrength(sender.getId());

    }

    private String _findKeyUnaccepted() {
        String key = "none";
        for(Map.Entry<String, Entity> entry: dataMap.entrySet()) {
            if(!entry.getValue().getHasAcceptedSentProposal()) {
                key = entry.getValue().getId();
                break;
            }
        }
        return key;
    }

}
