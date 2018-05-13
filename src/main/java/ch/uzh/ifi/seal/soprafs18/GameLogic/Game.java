package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.Constant.GameStatus;
import ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Blockade;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Game {

    @Id
    @Column(unique=true)
    private String name;

    @Column
    private String owner;

    @Column
    private int maxplayer;

    @Column
    public String pathName;

    @Column
    private Boolean protection = false;

    @Column
    private String password;

    @Column
    private GameStatus gameStatus;

    @OneToMany
    public List<Player> players = new ArrayList<Player>(4);

    @OneToOne(cascade = {CascadeType.ALL})
    private Market market = Market.getInstance();

    @JsonIgnore
    @Transient
    private int roundNum=0;

    @JsonIgnore
    private int blockcount = 0;


    @OneToOne
    private Player winner;

    @Transient
    private int i;


    @OneToMany
    private  List<Player> winners = new ArrayList<>();

    @Column
    private int current;

    @OneToOne
    private Player currentPlayer;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.ALL})
    private StandardPath GamePath;

    /**steps when crossing blockade:
     * 1. from field: getBlockadeFromNeighbours()
     * 2. blockade: setCrossed()
     * 3. blockade: removeBlockade(...) -->removes from neighbours this blockade and sets new neighbours*/


    public Game(){}

    public void gameSetup() {
        Integer playerSize = players.size();
        if (playerSize.equals(2)){
            StandardPath path = new StandardPath();
            setGamePath(path);
            //path.setupStandardPath();
            path.setupPath(pathName);
            //List<Field> starters= GamePath.getStarters("StandardPath");
            List<Field> starters= GamePath.getStarters(getPathname());
            market.marketsetup();
            for (int i=0; i< players.size(); i++){
                players.get(i).setPlayerColor(PlayerColor.values()[i]);
                players.get(i).setTwoFigures("one","two");
                players.get(i).getMyFigures().get(0).setCurrentPosition(starters.get(i));
                players.get(i).getMyFigures().get(1).setCurrentPosition(starters.get(i+2));
                players.get(i).setup();
                players.get(i).setTurn(false);
            }
            setCurrentPlayer(players.get(0));

        } else {

        StandardPath path = new StandardPath();
        setGamePath(path);
        path.setupPath(pathName);
        List<Field> starters = GamePath.getStarters(getPathname());
        market.marketsetup();
        for (int j = 0; j < players.size(); j++) {
            players.get(j).setPlayerColor(PlayerColor.values()[j]);
            players.get(j).getMyFigure().setCurrentPosition(starters.get(j));
            players.get(j).setup();
            players.get(j).setTurn(false);

            /**all get their drawpile **/
            /** players.get(j).getMyFigure().setCurrentPosition(); **/
        }
        setCurrentPlayer(players.get(0));}

    }



    public void addPlayer(Player player){ players.add(player); }

    public int getRoundNum(){
        return roundNum;
    }

    public List<Player> getPlayers() {
        return players;
    }



    @Transient
    @JsonIgnore
    public int getNumFigures(){
        return players.size();
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }



    public void setOwner(String owner) {
        this.owner = owner;
    }




    public int getMaxplayer() {
        return maxplayer;
    }

    public void setMaxplayer(int maxplayer) {
        this.maxplayer = maxplayer;
    }


    public void addUser(Player player){
        players.add(player);
        current ++;


    }

    public int getCurrent() {
        return current;
    }


    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }


    public void deletePlayer(Player player){
        players.remove(player);

        current --;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getProtection() {
        return protection;
    }

    public void setProtection(Boolean protection) {
        this.protection = protection;
    }


    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public void setPathname(String name){
        this.pathName = name;
    }

    public String getPathname() {
        return pathName;
    }

    @JsonIgnore
    @Transient
    public List<Field> getGamePathList(){
        List<Field> Standartpath = GamePath.getStandardPathFields();

        return Standartpath;
    }

    @JsonIgnore
    public List<Blockade> getBlockades(){
        List<Blockade> Blockade = GamePath.getCurrentBlockades();
        return Blockade;
    }



    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setGamePath(StandardPath gamePath) {
        this.GamePath = gamePath;
    }

    public StandardPath getGamePath() {
        return GamePath;
    }

    public int getBlockcount() {
        return blockcount;
    }

    public void setBlockcount(int blockcount) {
        this.blockcount = blockcount;
    }

    public List<Player> getWinners() {
        return winners;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
