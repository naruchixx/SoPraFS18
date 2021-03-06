package ch.uzh.ifi.seal.soprafs18.GameLogic.Turns;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards.DrawActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards.MarketActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards.MoveActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Market;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turn;

import java.util.List;

public class PlayActionCard implements Turn{

    ActionCard selectedCard;
    Player currentPlayer;


    public PlayActionCard(ActionCard ActionCard, Player currentPlayer) {
        this.selectedCard = ActionCard;
        this.currentPlayer=currentPlayer;
    }
    @Override
    public void turnfunction(){
        currentPlayer.selection.add(selectedCard);  /** da die karte von der hand benutzt wurde, wird sie in die selection gebracht **/
        currentPlayer.handcards.remove(selectedCard);

        if (selectedCard instanceof DrawActionCard){
            ((DrawActionCard) selectedCard).setPlayer(currentPlayer);
            selectedCard.doSpecialFunction();

        }
        if (selectedCard instanceof MoveActionCard){
            ((MoveActionCard) selectedCard).setPlayer(currentPlayer);
            /** set new position player choice get user input here **/
            selectedCard.doSpecialFunction();
        }

        if (selectedCard instanceof MarketActionCard){
            ((MarketActionCard) selectedCard).setPlayer(currentPlayer);
            ((MarketActionCard) selectedCard).setMarket(Market.getInstance());
            /** setplayer choice?? get user input here **/
            selectedCard.doSpecialFunction();
        }
    }
}