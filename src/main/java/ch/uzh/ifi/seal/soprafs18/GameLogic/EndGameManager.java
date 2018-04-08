package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.ElDorado;

import java.util.ArrayList;
import java.util.List;

public class EndGameManager  {
    Player Winner;
    ElDorado elDorado = new ElDorado();
    private int i, j;
    private Player k;

    public EndGameManager(){

    }

    public boolean CheckifReached(){
        if (elDorado.isReached() == true){
            return true;
        }
        return false;
    }

    public Player getWinner(){
        if (elDorado.getReachers().size() == 1) {
            Winner = elDorado.getReachers().get(0);
        }
        else if (elDorado.getReachers().size() > 1) {
            k= elDorado.getReachers().get(0);
            for(j=0;j<elDorado.getReachers().size();j++){
                if(k.getBlockadePoints()< elDorado.getReachers().get(j).getBlockadePoints()){
                    k= elDorado.getReachers().get(j);
                }
            }
        }
        return k;
    }



}
