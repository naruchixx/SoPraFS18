package ch.uzh.ifi.seal.soprafs18.Controller;

import ch.uzh.ifi.seal.soprafs18.Constant.CardWrapper;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.BoardPiece;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.Service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TurnController {
    private final String CONTEXT = "/Games";

    @Autowired
    private TurnService turnService;

    @PutMapping(value = CONTEXT + "/{room}/{user}/turn")
    @ResponseStatus(HttpStatus.OK)
    public List<Card> setupturn(@PathVariable(value = "user",required = true) String user, @PathVariable(value = "room",required = true) String room){
        List<Card> cards = turnService.TurnSetup(room,user);
        return cards;
    }

    @RequestMapping(value = CONTEXT + "/{room}/{user}/discard",method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Card> Discardturn(@PathVariable(value = "user",required = true) String user, @PathVariable(value = "room",required = true) String room,
                                  @RequestBody CardWrapper cardnames){
        List<Card> cards = turnService.Discard(room,user,cardnames);
        return cards;
    }

    @PostMapping(value = CONTEXT + "/{room}/{user}/trash")
    @ResponseStatus(HttpStatus.OK)
    public List<Card> TrashCard(@PathVariable(value = "user",required = true) String user, @PathVariable(value = "room",required = true) String room,
                                @RequestParam("cards") List<String> cardnames){
        List<Card> cards = turnService.Trash(room,user,cardnames);
        return cards;

    }

    @PutMapping(value = CONTEXT + "/{room}/{user}/endturn")
    @ResponseStatus(HttpStatus.OK)
    public void Endmyturn(@PathVariable(value = "user",required = true) String user, @PathVariable(value = "room",required = true) String room) {
        turnService.Endturn(room, user);

    }

    @GetMapping(value = CONTEXT + "/{room}/{user}/{cardname}/move")
    @ResponseStatus(HttpStatus.OK)
    public List<BoardPiece> getMyOptions(@PathVariable(value = "user",required = true) String user, @PathVariable(value = "room",required = true) String room, @PathVariable(value="cardname") String cardname){
        List<BoardPiece> myOptions = turnService.GetPossibleFields(room,user,cardname);
        return myOptions;
    }

    @PutMapping(value = CONTEXT + "/{room}/{user}/{card}/{fieldname}")
    @ResponseStatus(HttpStatus.OK)
    public Field getNewPositon(@PathVariable(value = "user",required = true) String user, @PathVariable(value = "room",required = true) String room,@PathVariable(value="card") String card, @PathVariable(value="fieldname") String fieldname){
        Field newposition = turnService.moveFigure(room,user,card,fieldname);
        return newposition;
    }


    @RequestMapping(value = CONTEXT + "/{room}/{user}/{card}",method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Player buywantedcard(@PathVariable(value = "user",required = true) String user, @PathVariable(value = "room",required = true) String room, @PathVariable(value ="card") String card,
                                @RequestBody CardWrapper cards){
        return turnService.buyCard(room,user,card,cards);
    }

    @GetMapping(value = CONTEXT + "/{room}/{user}/handcards")
    @ResponseStatus(HttpStatus.OK)
    public List<Card> getcurrentcards(@PathVariable(value = "user",required = true) String user, @PathVariable(value = "room",required = true) String room){
        return turnService.getCurrenthandCards(room,user);
    }

    @GetMapping(value = CONTEXT + "/{room}/checkWinner")
    @ResponseStatus(HttpStatus.OK)
    public Player getWinner(@PathVariable(value = "room",required = true) String room){
        return turnService.isGameWon(room);
    }



}
