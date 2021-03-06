package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@DiscriminatorValue("D")
public class DrawActionCard extends ActionCard {

    @JsonIgnore
    @Transient
    private Boolean TrashSome; /** tells us if it gives us the trash option **/

    private Integer HowMany; /** tell us how many we can draw **/
    @JsonIgnore
    @Transient
    private Player player;


    public DrawActionCard(){}

    public DrawActionCard(String name,String cardColour, Boolean reusable,Integer Price,Integer HowMany, Boolean TrashSome){
        super(name,cardColour,reusable,Price);
        this.TrashSome = TrashSome;
        this.HowMany= HowMany;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Integer getHowMany() {
        return HowMany;
    }


    public void setHowMany(Integer howMany) {
        HowMany = howMany;
    }

    @Override
    public void doSpecialFunction(){

        /** get here input for do you wanna trash cards? if yes selection = choice, and trash choice **/
        int number = 0;
        while (number < HowMany) {
            Collections.shuffle(player.drawpile); /** i cant figure it out..makes me create a new player instance but i dont want that.. **/
            player.handcards.add(player.drawpile.get(0));
            player.drawpile.remove(0);
            number = number + 1;

        }





    }

}
