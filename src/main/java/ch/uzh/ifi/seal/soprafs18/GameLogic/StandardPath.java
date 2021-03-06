package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Blockade;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;


import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Blockade;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class StandardPath {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Field> StandardPathFields = new ArrayList<>();
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Blockade> Blockades= new ArrayList<>(6);

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Blockade> currentBlockades = new ArrayList<>();
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Field> HillsOfGoldFields = new ArrayList<>();
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Field> HomeStretchFields = new ArrayList<>();
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Field> WindingPathsFields = new ArrayList<>();
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Field> SerpentineFields = new ArrayList<>();
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Field> SwamplandsFields = new ArrayList<>();
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Field> WitchsCauldronFields = new ArrayList<>();

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Blockade> removalList;




    public StandardPath(){
        Blockade blockade4= new Blockade("BK4",1,"Blue",false);
        Blockade blockade2= new Blockade("BK2",1,"Yellow",false);
        Blockade blockade1= new Blockade("BK1",1,"Green",false);
        Blockade blockade5= new Blockade("BK5",2,"Green",false);
        Blockade blockade6= new Blockade("BK6",2,"Yellow",false);   /** if blockade is white: play (blockade points) cards to cross, any card is acceptable */
        Blockade blockade3= new Blockade("BK3",1,"Blue",false);



        Blockades.add(blockade1);
        Blockades.add(blockade2);
        Blockades.add(blockade3);
        Blockades.add(blockade4);
        Blockades.add(blockade5);
        Blockades.add(blockade6);


    }

    public void setupStandardPath(){

        Random rand = new Random();
        int numberOfElements = 4;
        List<Blockade> blockadeList = new ArrayList<>(Blockades);

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(blockadeList.size());
            Blockade randomElement = blockadeList.get(randomIndex);
            blockadeList.remove(randomIndex);
            currentBlockades.add(randomElement);
        }

        currentBlockades.get(0).setName("BK1");
        currentBlockades.get(1).setName("BK2");
        currentBlockades.get(2).setName("BK3");
        currentBlockades.get(3).setName("BK4");

        removalList = new ArrayList<>(currentBlockades);


        Field A1 = new Field(0,"Green",true, "A1");
        Field A2 = new Field(0,"Green",true, "A2");
        Field A3 = new Field(0,"Green",true, "A3");
        Field A4 = new Field(0,"Green",true, "A4");
        Field A5 = new Field(1,"Green",true,"A5");
        Field A6 = new Field(1,"Green",true, "A6");
        Field A7 = new Field(1,"Green",true, "A7");
        Field A8 = new Field(1,"Green",true, "A8");
        Field A9 = new Field(1,"Green",true, "A9");
        Field A10 = new Field(1,"Green",true,"A10");
        Field A11 = new Field(1,"Green",true,"A11");
        Field A12 = new Field(1,"Yellow",true,"A12" );
        Field A13 = new Field(1,"Green",true,"A13");
        Field A14 = new Field(1,"Blue",true, "A14");
        Field A15 = new Field(1,"Green",true, "A15");
        Field A16 = new Field(1,"Green",true, "A16");
        Field A17 = new Field(1,"Yellow",true,"A17" );
        Field A18 = new Field(1,"Green",true, "A18");
        Field A19 = new Field(1,"Blue",true, "A19");
        Field A20 = new Field(1,"Green",true, "A20");
        Field A21 = new Field(1,"Yellow",true, "A21");
        Field A22 = new Field(1,"Green",true, "A22");
        Field A23 = new Field(1,"Green",true, "A23");
        Field A24 = new Field(0,"Cave",false, "A24");
        Field A25 = new Field(1,"Yellow",true, "A25");
        Field A26 = new Field(1,"Green",true, "A26");
        Field A27 = new Field(1,"Green",true, "A27");
        Field A28 = new Field(1,"Green",true, "A28");
        Field A29 = new Field(1,"Blue",true, "A29");
        Field A30 = new Field(0,"Cave",false, "A30");
        Field A31 = new Field(1,"Green",true, "A31");
        Field A32 = new Field(1,"Green",true, "A32");
        Field A33 = new Field(1,"Yellow",true, "A33");
        Field A34 = new Field(1,"Green",true, "A34");
        Field A35 = new Field(1,"Camp",true, "A35");
        Field A36 = new Field(1,"Green",true, "A36");
        Field A37 = new Field(1,"Green",true, "A37");
        A1.AddNewNeighbour(A2,A5,A6);
        A2.AddNewNeighbour(A1,A6,A7,A3);
        A3.AddNewNeighbour(A2,A7,A8,A4);
        A4.AddNewNeighbour(A3,A8,A9);
        A5.AddNewNeighbour(A1,A6,A10,A11);
        A6.AddNewNeighbour(A1,A2,A7,A12,A11,A5);
        A7.AddNewNeighbour(A2,A3,A8,A13,A12,A6);
        A8.AddNewNeighbour(A3,A4,A9,A14,A13,A7);
        A9.AddNewNeighbour(A4,A15,A14,A8);
        A10.AddNewNeighbour(A5,A11,A17,A16);
        A11.AddNewNeighbour(A5,A6,A12,A18,A17,A10);
        A12.AddNewNeighbour(A6,A7,A13,A19,A18,A11);
        A13.AddNewNeighbour(A7,A8,A14,A20,A19,A12);
        A14.AddNewNeighbour(A8,A9,A15,A21,A20,A13);
        A15.AddNewNeighbour(A9,A22,A21,A14);
        A16.AddNewNeighbour(A10,A17,A23);
        A17.AddNewNeighbour(A10,A11,A18,A24,A23,A16);
        A18.AddNewNeighbour(A11,A12,A19,A25,A24,A17);
        A19.AddNewNeighbour(A12,A13,A20,A26,A25,A18);
        A20.AddNewNeighbour(A13,A14,A21,A27,A26,A19);
        A21.AddNewNeighbour(A14,A15,A22,A28,A27,A20);
        A22.AddNewNeighbour(A15,A28,A21);
        A23.AddNewNeighbour(A16,A17,A24,A29);
        A24.AddNewNeighbour(A17,A18,A25,A30,A29,A23);
        A25.AddNewNeighbour(A18,A19,A26,A31,A30,A24);
        A26.AddNewNeighbour(A19,A20,A27,A32,A32,A25);
        A27.AddNewNeighbour(A20,A21,A28,A33,A32,A26);
        A28.AddNewNeighbour(A21,A22,A33,A27);
        A29.AddNewNeighbour(A23,A24,A30,A34);
        A30.AddNewNeighbour(A24,A25,A31,A35,A34,A29);
        A31.AddNewNeighbour(A25,A26,A32,A36,A35,A30);
        A32.AddNewNeighbour(A26,A27,A33,A37,A36,A31);
        A33.AddNewNeighbour(A27,A28,A37,A32);
        A34.AddNewNeighbour(A29,A30,A35);
        A35.AddNewNeighbour(A34,A30,A31,A36);
        A36.AddNewNeighbour(A35,A31,A32,A37);
        A37.AddNewNeighbour(A36,A32,A33);

        Field B1 = new Field(0,"Green",true, "B1");
        Field B2 = new Field(0,"Green",true, "B2");
        Field B3 = new Field(0,"Green",true, "B3");
        Field B4 = new Field(0,"Green",true, "B4");
        Field B5 = new Field(1,"Green",true, "B5");
        Field B6 = new Field(1,"Green",true, "B6");
        Field B7 = new Field(1,"Green",true, "B7");
        Field B8 = new Field(1,"Green",true, "B8");
        Field B9 = new Field(1,"Green",true, "B9");
        Field B10 = new Field(1,"Green",true,"B10");
        Field B11 = new Field(1,"Green",true, "B11");
        Field B12 = new Field(1,"Green",true,"B12" );
        Field B13 = new Field(1,"Blue",true, "B13");
        Field B14 = new Field(1,"Green",true, "B14");
        Field B15 = new Field(1,"Green",true, "B15");
        Field B16 = new Field(1,"Green",true, "B16");
        Field B17 = new Field(1,"Green",true,"B17" );
        Field B18 = new Field(1,"Yellow",true, "B18");
        Field B19 = new Field(1,"Green",true,"B19");
        Field B20 = new Field(1,"Yellow",true, "B20");
        Field B21 = new Field(1,"Green",true, "B21");
        Field B22 = new Field(1,"Blue",true, "B22");
        Field B23 = new Field(1,"Green",true,"B23");
        Field B24 = new Field(1,"Green",true, "B24");
        Field B25 = new Field(1,"Green",true, "B25");
        Field B26 = new Field(1,"Green",true, "B26");
        Field B27 = new Field(1,"Yellow",true, "B27");
        Field B28 = new Field(1,"Green",true, "B28");
        Field B29 = new Field(1,"Green",true, "B29");
        Field B30 = new Field(0,"Cave",false, "B30");
        Field B31 = new Field(1,"Yellow",true, "B31");
        Field B32 = new Field(1,"Green",true, "B32");
        Field B33 = new Field(1,"Green",true, "B33");
        Field B34 = new Field(1,"Blue",true, "B34");
        Field B35 = new Field(1,"Camp",true, "B35");
        Field B36 = new Field(1,"Blue",true, "B36");
        Field B37 = new Field(1,"Green",true, "B37");
        B1.AddNewNeighbour(B2,B5,B6);
        B2.AddNewNeighbour(B1,B6,B7,B3);
        B3.AddNewNeighbour(B2,B7,B8,B4);
        B4.AddNewNeighbour(B3,B8,B9);
        B5.AddNewNeighbour(B1,B6,B10,B11);
        B6.AddNewNeighbour(B1,B2,B7,B12,B11,B5);
        B7.AddNewNeighbour(B2,B3,B8,B13,B12,B6);
        B8.AddNewNeighbour(B3,B4,B9,B14,B13,B7);
        B9.AddNewNeighbour(B4,B15,B14,B8);
        B10.AddNewNeighbour(B5,B11,B17,B16);
        B11.AddNewNeighbour(B5,B6,B12,B18,B17,B10);
        B12.AddNewNeighbour(B6,B7,B13,B19,B18,B11);
        B13.AddNewNeighbour(B7,B8,B14,B20,B19,B12);
        B14.AddNewNeighbour(B8,B9,B15,B21,B20,B13);
        B15.AddNewNeighbour(B9,B22,B21,B14);
        B16.AddNewNeighbour(B10,B17,B23);
        B17.AddNewNeighbour(B10,B11,B18,B24,B23,B16);
        B18.AddNewNeighbour(B11,B12,B19,B25,B24,B17);
        B19.AddNewNeighbour(B12,B13,B20,B26,B25,B18);
        B20.AddNewNeighbour(B13,B14,B21,B27,B26,B19);
        B21.AddNewNeighbour(B14,B15,B22,B28,B27,B20);
        B22.AddNewNeighbour(B15,B28,B21);
        B23.AddNewNeighbour(B16,B17,B24,B29);
        B24.AddNewNeighbour(B17,B18,B25,B30,B29,B23);
        B25.AddNewNeighbour(B18,B19,B26,B31,B30,B24);
        B26.AddNewNeighbour(B19,B20,B27,B32,B32,B25);
        B27.AddNewNeighbour(B20,B21,B28,B33,B32,B26);
        B28.AddNewNeighbour(B21,B22,B33,B27);
        B29.AddNewNeighbour(B23,B24,B30,B34);
        B30.AddNewNeighbour(B24,B25,B31,B35,B34,B29);
        B31.AddNewNeighbour(B25,B26,B32,B36,B35,B30);
        B32.AddNewNeighbour(B26,B27,B33,B37,B36,B31);
        B33.AddNewNeighbour(B27,B28,B37,B32);
        B34.AddNewNeighbour(B29,B30,B35);
        B35.AddNewNeighbour(B34,B30,B31,B36);
        B36.AddNewNeighbour(B35,B31,B32,B37);
        B37.AddNewNeighbour(B36,B32,B33);

        Field C1 = new Field(1,"Blue",true, "C1");
        Field C2 = new Field(1,"Blue",true, "C2");
        Field C3 = new Field(1,"Green",true, "C3");
        Field C4 = new Field(1,"Green",true, "C4");
        Field C5 = new Field(1,"Yellow",true, "C5");
        Field C6 = new Field(1,"Yellow",true, "C6");
        Field C7 = new Field(1,"Blue",true,"C7");
        Field C8 = new Field(1,"Yellow",true, "C8");
        Field C9 = new Field(1,"Green",true, "C9");
        Field C10 = new Field(1,"Yellow",true,"C10");
        Field C11 = new Field(1,"White",true,"C11");
        Field C12 = new Field(1,"White",true,"C12" );
        Field C13 = new Field(1,"Yellow",true, "C13");
        Field C14 = new Field(1,"White",true, "C14");
        Field C15 = new Field(1,"White",true,"C15");
        Field C16 = new Field(1,"Green",true, "C16");
        Field C17 = new Field(1,"White",true,"C17" );
        Field C18 = new Field(1,"Blue",true,"C18");
        Field C19 = new Field(0,"Cave",false, "C19");
        Field C20 = new Field(1,"Yellow",true, "C20");
        Field C21 = new Field(1,"Blue",true, "C21");
        Field C22 = new Field(1,"White",true, "C22");
        Field C23 = new Field(1,"Green",true, "C23");
        Field C24 = new Field(1,"Green",true, "C24");
        Field C25 = new Field(1,"Blue",true, "C25");
        Field C26 = new Field(1,"Blue",true, "C26");
        Field C27 = new Field(1,"White",true, "C27");
        Field C28 = new Field(1,"Blue",true,"C28");
        Field C29 = new Field(1,"Blue",true, "C29");
        Field C30 = new Field(1,"Yellow",true, "C30");
        Field C31 = new Field(1,"Yellow",true, "C31");
        Field C32 = new Field(1,"White",true, "C32");
        Field C33 = new Field(1,"Blue",true, "C33");
        Field C34 = new Field(1,"Blue",true, "C34");
        Field C35 = new Field(1,"Blue",true, "C35");
        Field C36 = new Field(1,"Yellow",true, "C36");
        Field C37 = new Field(1,"White",true, "C37");
        C1.AddNewNeighbour(C2,C5, C6);
        C2.AddNewNeighbour(C1,C6,C7,C3);
        C3.AddNewNeighbour(C2,C7,C8,C4);
        C4.AddNewNeighbour(C3,C8,C9);
        C5.AddNewNeighbour(C1,C6,C10,C11);
        C6.AddNewNeighbour(C1,C2,C7,C12,C11,C5);
        C7.AddNewNeighbour(C2,C3,C8,C13,C12,C6);
        C8.AddNewNeighbour(C3,C4,C9,C14,C13,C7);
        C9.AddNewNeighbour(C4,C15,C14,C8);
        C10.AddNewNeighbour(C5,C11,C17,C16);
        C11.AddNewNeighbour(C5,C6,C12,C18,C17,C10);
        C12.AddNewNeighbour(C6,C7,C13,C19,C18,C11);
        C13.AddNewNeighbour(C7,C8,C14,C20,C19,C12);
        C14.AddNewNeighbour(C8,C9,C15,C21,C20,C13);
        C15.AddNewNeighbour(C9,C22,C21,C14);
        C16.AddNewNeighbour(C10,C17,C23);
        C17.AddNewNeighbour(C10,C11,C18,C24,C23,C16);
        C18.AddNewNeighbour(C11,C12,C19,C25,C24,C17);
        C19.AddNewNeighbour(C12,C13,C20,C26,C25,C18);
        C20.AddNewNeighbour(C13,C14,C21,C27,C26,C19);
        C21.AddNewNeighbour(C14,C15,C22,C28,C27,C20);
        C22.AddNewNeighbour(C15,C28,C21);
        C23.AddNewNeighbour(C16,C17,C24,C29);
        C24.AddNewNeighbour(C17,C18,C25,C30,C29,C23);
        C25.AddNewNeighbour(C18,C19,C26,C31,C30,C24);
        C26.AddNewNeighbour(C19,C20,C27,C32,C32,C25);
        C27.AddNewNeighbour(C20,C21,C28,C33,C32,C26);
        C28.AddNewNeighbour(C21,C22,C33,C27);
        C29.AddNewNeighbour(C23,C24,C30,C34);
        C30.AddNewNeighbour(C24,C25,C31,C35,C34,C29);
        C31.AddNewNeighbour(C25,C26,C32,C36,C35,C30);
        C32.AddNewNeighbour(C26,C27,C33,C37,C36,C31);
        C33.AddNewNeighbour(C27,C28,C37,C32);
        C34.AddNewNeighbour(C29,C30,C35);
        C35.AddNewNeighbour(C34,C30,C31,C36);
        C36.AddNewNeighbour(C35,C31,C32,C37);
        C37.AddNewNeighbour(C36,C32,C33);

        Field N1 = new Field(1,"Green",true, "N1");
        Field N2 = new Field(1,"Green",true, "N2");
        Field N3 = new Field(1,"Green",true, "N3");
        Field N4 = new Field(1,"Green",true, "N4");
        Field N5 = new Field(1,"Green",true, "N5");
        Field N6 = new Field(1,"Green",true, "N6");
        Field N7 = new Field(2,"Green",true,"N7");
        Field N8 = new Field(1,"Green",true, "N8");
        Field N9 = new Field(1,"Green",true, "N9");
        Field N10 = new Field(1,"Yellow",true,"N10");
        Field N11 = new Field(2,"Yellow",true,"N11");
        Field N12 = new Field(1,"Green",true,"N12" );
        Field N13 = new Field(1,"Blue",true, "N13");
        Field N14 = new Field(1,"Blue",true, "N14");
        Field N15 = new Field(1,"Blue",true,"N15");
        Field N16 = new Field(1,"Yellow",true, "N16");
        Field N17 = new Field(2,"Yellow",true,"N17" );
        Field N18 = new Field(3,"Yellow",true,"N18");
        Field N19 = new Field(4,"Yellow",true, "N19");
        Field N20 = new Field(3,"Yellow",true, "N20");
        Field N21 = new Field(1,"Blue",true, "N21");
        Field N22 = new Field(1,"Blue",true, "N22");
        Field N23 = new Field(1,"Blue",true, "N23");
        Field N24 = new Field(1,"Blue",true, "N24");
        Field N25 = new Field(1,"Blue",true, "N25");
        Field N26 = new Field(1,"Green",true, "N26");
        Field N27 = new Field(2,"Yellow",true, "N27");
        Field N28 = new Field(1,"Yellow",true,"N28");
        Field N29 = new Field(1,"Blue",true, "N29");
        Field N30 = new Field(1,"Green",true, "N30");
        Field N31 = new Field(2,"Green",true, "N31");
        Field N32 = new Field(1,"Green",true, "N32");
        Field N33 = new Field(1,"Yellow",true, "N33");
        Field N34 = new Field(1,"Green",true, "N34");
        Field N35 = new Field(1,"Green",true, "N35");
        Field N36 = new Field(1,"Green",true, "N36");
        Field N37 = new Field(1,"Green",true, "N37");
        N1.AddNewNeighbour(N2, N5, N6);
        N2.AddNewNeighbour(N1,N6,N7,N3);
        N3.AddNewNeighbour(N2,N7,N8,N4);
        N4.AddNewNeighbour(N3,N8,N9);
        N5.AddNewNeighbour(N1,N6,N10,N11);
        N6.AddNewNeighbour(N1,N2,N7,N12,N11,N5);
        N7.AddNewNeighbour(N2,N3,N8,N13,N12,N6);
        N8.AddNewNeighbour(N3,N4,N9,N14,N13,N7);
        N9.AddNewNeighbour(N4,N15,N14,N8);
        N10.AddNewNeighbour(N5,N11,N17,N16);
        N11.AddNewNeighbour(N5,N6,N12,N18,N17,N10);
        N12.AddNewNeighbour(N6,N7,N13,N19,N18,N11);
        N13.AddNewNeighbour(N7,N8,N14,N20,N19,N12);
        N14.AddNewNeighbour(N8,N9,N15,N21,N20,N13);
        N15.AddNewNeighbour(N9,N22,N21,N14);
        N16.AddNewNeighbour(N10,N17,N23);
        N17.AddNewNeighbour(N10,N11,N18,N24,N23,N16);
        N18.AddNewNeighbour(N11,N12,N19,N25,N24,N17);
        N19.AddNewNeighbour(N12,N13,N20,N26,N25,N18);
        N20.AddNewNeighbour(N13,N14,N21,N27,N26,N19);
        N21.AddNewNeighbour(N14,N15,N22,N28,N27,N20);
        N22.AddNewNeighbour(N15,N28,N21);
        N23.AddNewNeighbour(N16,N17,N24,N29);
        N24.AddNewNeighbour(N17,N18,N25,N30,N29,N23);
        N25.AddNewNeighbour(N18,N19,N26,N31,N30,N24);
        N26.AddNewNeighbour(N19,N20,N27,N32,N32,N25);
        N27.AddNewNeighbour(N20,N21,N28,N33,N32,N26);
        N28.AddNewNeighbour(N21,N22,N33,N27);
        N29.AddNewNeighbour(N23,N24,N30,N34);
        N30.AddNewNeighbour(N24,N25,N31,N35,N34,N29);
        N31.AddNewNeighbour(N25,N26,N32,N36,N35,N30);
        N32.AddNewNeighbour(N26,N27,N33,N37,N36,N31);
        N33.AddNewNeighbour(N27,N28,N37,N32);
        N34.AddNewNeighbour(N29,N30,N35);
        N35.AddNewNeighbour(N34,N30,N31,N36);
        N36.AddNewNeighbour(N35,N31,N32,N37);
        N37.AddNewNeighbour(N36,N32,N33);

        Field I1 = new Field(1,"Green",true, "I1");
        Field I2 = new Field(1,"Blue",true, "I2");
        Field I3 = new Field(2,"Blue",true, "I3");
        Field I4 = new Field(2,"Blue",true, "I4");
        Field I5 = new Field(1,"Green",true, "I5");
        Field I6 = new Field(1,"Green",true, "I6");
        Field I7 = new Field(1,"Blue",true,"I7");
        Field I8 = new Field(1,"Blue",true, "I8");
        Field I9 = new Field(2,"Blue",true, "I9");
        Field I10 = new Field(1,"Green",true,"I10");
        Field I11 = new Field(2,"Green",true,"I11");
        Field I12 = new Field(0,"Cave",false,"I12" );
        Field I13 = new Field(0,"Cave",false, "I13");
        Field I14 = new Field(3,"White",true, "I14");
        Field I15 = new Field(2,"Yellow",true,"I15");
        Field I16 = new Field(0,"Cave",false, "I16");
        Field I17 = new Field(0,"Cave",false,"I17" );
        Field I18 = new Field(3,"Camp",true,"I18");
        Field I19 = new Field(2,"Green",true, "I19");
        Field I20 = new Field(1,"Green",true, "I20");
        Field I21 = new Field(2,"Yellow",true, "I21");
        Field I22 = new Field(1,"Yellow",true, "I22");
        Field I23 = new Field(1,"Green",true, "I23");
        Field I24 = new Field(2,"Green",true, "I24");
        Field I25 = new Field(0,"Cave",false, "I25");
        Field I26 = new Field(1,"Green",true, "I26");
        Field I27 = new Field(2,"Yellow",true, "I27");
        Field I28 = new Field(1,"Yellow",true,"I28");
        Field I29 = new Field(1,"Green",true, "I29");
        Field I30 = new Field(1,"Green",true, "I30");
        Field I31 = new Field(0,"Cave",false, "I31");
        Field I32 = new Field(1,"Green",true, "I32");
        Field I33 = new Field(1,"Yellow",true, "I33");
        Field I34 = new Field(1,"Green",true, "I34");
        Field I35 = new Field(1,"Green",true, "I35");
        Field I36 = new Field(1,"Green",true, "I36");
        Field I37 = new Field(1,"Green",true, "I37");
        I1.AddNewNeighbour(I2, I5, I6);
        I2.AddNewNeighbour(I1,I6,I7,I3);
        I3.AddNewNeighbour(I2,I7,I8,I4);
        I4.AddNewNeighbour(I3,I8,I9);
        I5.AddNewNeighbour(I1,I6,I10,I11);
        I6.AddNewNeighbour(I1,I2,I7,I12,I11,I5);
        I7.AddNewNeighbour(I2,I3,I8,I13,I12,I6);
        I8.AddNewNeighbour(I3,I4,I9,I14,I13,I7);
        I9.AddNewNeighbour(I4,I15,I14,I8);
        I10.AddNewNeighbour(I5,I11,I17,I16);
        I11.AddNewNeighbour(I5,I6,I12,I18,I17,I10);
        I12.AddNewNeighbour(I6,I7,I13,I19,I18,I11);
        I13.AddNewNeighbour(I7,I8,I14,I20,I19,I12);
        I14.AddNewNeighbour(I8,I9,I15,I21,I20,I13);
        I15.AddNewNeighbour(I9,I22,I21,I14);
        I16.AddNewNeighbour(I10,I17,I23);
        I17.AddNewNeighbour(I10,I11,I18,I24,I23,I16);
        I18.AddNewNeighbour(I11,I12,I19,I25,I24,I17);
        I19.AddNewNeighbour(I12,I13,I20,I26,I25,I18);
        I20.AddNewNeighbour(I13,I14,I21,I27,I26,I19);
        I21.AddNewNeighbour(I14,I15,I22,I28,I27,I20);
        I22.AddNewNeighbour(I15,I28,I21);
        I23.AddNewNeighbour(I16,I17,I24,I29);
        I24.AddNewNeighbour(I17,I18,I25,I30,I29,I23);
        I25.AddNewNeighbour(I18,I19,I26,I31,I30,I24);
        I26.AddNewNeighbour(I19,I20,I27,I32,I32,I25);
        I27.AddNewNeighbour(I20,I21,I28,I33,I32,I26);
        I28.AddNewNeighbour(I21,I22,I33,I27);
        I29.AddNewNeighbour(I23,I24,I30,I34);
        I30.AddNewNeighbour(I24,I25,I31,I35,I34,I29);
        I31.AddNewNeighbour(I25,I26,I32,I36,I35,I30);
        I32.AddNewNeighbour(I26,I27,I33,I37,I36,I31);
        I33.AddNewNeighbour(I27,I28,I37,I32);
        I34.AddNewNeighbour(I29,I30,I35);
        I35.AddNewNeighbour(I34,I30,I31,I36);
        I36.AddNewNeighbour(I35,I31,I32,I37);
        I37.AddNewNeighbour(I36,I32,I33);

        Field K1 = new Field(1,"Green",true, "K1");
        Field K2 = new Field(2,"Green",true, "K2");
        Field K3 = new Field(2,"Green",true, "K3");
        Field K4 = new Field(2,"Green",true, "K4");
        Field K5 = new Field(2,"Green",true, "K5");
        Field K6 = new Field(1,"Green",true, "K6");
        Field K7 = new Field(1,"Green",true,"K7");
        Field K8 = new Field(1,"Green",true, "K8");
        Field K9 = new Field(1,"Green",true, "K9");
        Field K10 = new Field(2,"Green",true,"K10");
        Field K11 = new Field(4,"Yellow",true,"K11");
        Field K12 = new Field(3,"Green",true,"K12" );
        Field K13 = new Field(3,"Green",true, "K13");
        Field K14 = new Field(2,"Green",true, "K14");
        Field K15 = new Field(1,"Green",true,"K15");
        Field K16 = new Field(1,"Camp",true, "K16");
        Field K17 = new Field(1,"Green",true,"K17" );
        Field K18 = new Field(1,"Green",true,"K18");
        Field K19 = new Field(1,"Green",true, "K19");
        Field K20 = new Field(1,"Green",true, "K20");
        Field K21 = new Field(1,"Green",true, "K21");
        Field K22 = new Field(1,"Camp",true, "K22");
        Field K23 = new Field(1,"Green",true, "K23");
        Field K24 = new Field(2,"Green",true, "K24");
        Field K25 = new Field(3,"Green",true, "K25");
        Field K26 = new Field(3,"Green",true, "K26");
        Field K27 = new Field(3,"Blue",true, "K27");
        Field K28 = new Field(2,"Green",true,"K28");
        Field K29 = new Field(1,"Green",true, "K29");
        Field K30 = new Field(1,"Green",true, "K30");
        Field K31 = new Field(1,"Green",true, "K31");
        Field K32 = new Field(1,"Green",true, "K32");
        Field K33 = new Field(2,"Green",true, "K33");
        Field K34 = new Field(2,"Green",true, "K34");
        Field K35 = new Field(2,"Green",true, "K35");
        Field K36 = new Field(2,"Green",true, "K36");
        Field K37 = new Field(1,"Green",true, "K37");
        K1.AddNewNeighbour(K2, K5, K6);
        K2.AddNewNeighbour(K1,K6,K7,K3);
        K3.AddNewNeighbour(K2,K7,K8,K4);
        K4.AddNewNeighbour(K3,K8,K9);
        K5.AddNewNeighbour(K1,K6,K10,K11);
        K6.AddNewNeighbour(K1,K2,K7,K12,K11,K5);
        K7.AddNewNeighbour(K2,K3,K8,K13,K12,K6);
        K8.AddNewNeighbour(K3,K4,K9,K14,K13,K7);
        K9.AddNewNeighbour(K4,K15,K14,K8);
        K10.AddNewNeighbour(K5,K11,K17,K16);
        K11.AddNewNeighbour(K5,K6,K12,K18,K17,K10);
        K12.AddNewNeighbour(K6,K7,K13,K19,K18,K11);
        K13.AddNewNeighbour(K7,K8,K14,K20,K19,K12);
        K14.AddNewNeighbour(K8,K9,K15,K21,K20,K13);
        K15.AddNewNeighbour(K9,K22,K21,K14);
        K16.AddNewNeighbour(K10,K17,K23);
        K17.AddNewNeighbour(K10,K11,K18,K24,K23,K16);
        K18.AddNewNeighbour(K11,K12,K19,K25,K24,K17);
        K19.AddNewNeighbour(K12,K13,K20,K26,K25,K18);
        K20.AddNewNeighbour(K13,K14,K21,K27,K26,K19);
        K21.AddNewNeighbour(K14,K15,K22,K28,K27,K20);
        K22.AddNewNeighbour(K15,K28,K21);
        K23.AddNewNeighbour(K16,K17,K24,K29);
        K24.AddNewNeighbour(K17,K18,K25,K30,K29,K23);
        K25.AddNewNeighbour(K18,K19,K26,K31,K30,K24);
        K26.AddNewNeighbour(K19,K20,K27,K32,K32,K25);
        K27.AddNewNeighbour(K20,K21,K28,K33,K32,K26);
        K28.AddNewNeighbour(K21,K22,K33,K27);
        K29.AddNewNeighbour(K23,K24,K30,K34);
        K30.AddNewNeighbour(K24,K25,K31,K35,K34,K29);
        K31.AddNewNeighbour(K25,K26,K32,K36,K35,K30);
        K32.AddNewNeighbour(K26,K27,K33,K37,K36,K31);
        K33.AddNewNeighbour(K27,K28,K37,K32);
        K34.AddNewNeighbour(K29,K30,K35);
        K35.AddNewNeighbour(K34,K30,K31,K36);
        K36.AddNewNeighbour(K35,K31, K32,K37);
        K37.AddNewNeighbour(K36,K32,K33);

        Blockade first=currentBlockades.get(0);
        Blockade second=currentBlockades.get(1);
        Blockade third= currentBlockades.get(2);
        Blockade fourth= currentBlockades.get(3);


        Field B37StandardPath=B37;
        B37StandardPath.AddNewNeighbour(first);
        Field B33StandardPath=B33;
        B33StandardPath.AddNewNeighbour(first);
        Field B28StandardPath=B28;
        B28StandardPath.AddNewNeighbour(first);
        Field B22StandardPath=B22;
        B22StandardPath.AddNewNeighbour(first);
        first.addNeighbour(B22StandardPath);
        first.addNeighbour(B28StandardPath);
        first.addNeighbour(B33StandardPath);
        first.addNeighbour(B37StandardPath);
        first.addNeighbour(C4);
        first.addNeighbour(C3);
        first.addNeighbour(C2);
        first.addNeighbour(C1);

        Field C16StandardPath=C16;
        C16StandardPath.AddNewNeighbour(second);
        Field C23StandardPath=C23;
        C23StandardPath.AddNewNeighbour(second);
        Field C29StandardPath=C29;
        C29StandardPath.AddNewNeighbour(second);
        Field C34StandardPath=C34;
        C34StandardPath.AddNewNeighbour(second);

        Field N34StandardPath=N34;
        N34StandardPath.AddNewNeighbour(third);
        Field N35StandardPath=N35;
        N35StandardPath.AddNewNeighbour(third);
        Field N36StandardPath=N36;
        N36StandardPath.AddNewNeighbour(third);
        Field N37StandardPath=N37;
        N37StandardPath.AddNewNeighbour(third);

        Field I37StandardPath=I37;
        I37StandardPath.AddNewNeighbour(fourth);
        Field I33StandardPath=I33;
        I33StandardPath.AddNewNeighbour(fourth);
        Field I28StandardPath=I28;
        I28StandardPath.AddNewNeighbour(fourth);
        Field I22StandardPath=I22;
        I22StandardPath.AddNewNeighbour(fourth);

        /** el dorado fields ---> 3x the same field/ either blue or green all
         * if player enters a el dorado field set el dorado to reached */
        Field EDBlue1= new Field(1, "Blue", true, "EDBlue1");
        Field EDBlue2= new Field(1, "Blue", true, "EDBlue2");
        Field EDBlue3= new Field(1, "Blue", true, "EDBlue3");
        Field EDGreen1= new Field(1, "Green", true, "EDGreen1");
        Field EDGreen2= new Field(1, "Green", true, "EDGreen2");
        Field EDGreen3= new Field(1, "Green", true, "EDGreen3");

        /**adding el dorado fields as neighbours*/
        Field K36StandardPath=K36;
        K36StandardPath.AddNewNeighbour(EDBlue1);
        Field K37StandardPath=K37;
        K37StandardPath.AddNewNeighbour(EDBlue1,EDBlue2,EDBlue3);
        Field K33StandardPath=K33;
        K33StandardPath.AddNewNeighbour(EDBlue3);

        StandardPathFields.add(B1);StandardPathFields.add(B2);StandardPathFields.add(B3);StandardPathFields.add(B4);
        StandardPathFields.add(B5);StandardPathFields.add(B6);StandardPathFields.add(B7);StandardPathFields.add(B8);
        StandardPathFields.add(B9);StandardPathFields.add(B10);StandardPathFields.add(B11);StandardPathFields.add(B12);
        StandardPathFields.add(B13);StandardPathFields.add(B14);StandardPathFields.add(B15);StandardPathFields.add(B16);
        StandardPathFields.add(B17);StandardPathFields.add(B18);StandardPathFields.add(B19);StandardPathFields.add(B20);
        StandardPathFields.add(B21);StandardPathFields.add(B22);StandardPathFields.add(B23);StandardPathFields.add(B24);
        StandardPathFields.add(B25);StandardPathFields.add(B26);StandardPathFields.add(B27);StandardPathFields.add(B28StandardPath);
        StandardPathFields.add(B29);StandardPathFields.add(B30);StandardPathFields.add(B31);StandardPathFields.add(B32);
        StandardPathFields.add(B33StandardPath);StandardPathFields.add(B34);StandardPathFields.add(B35);StandardPathFields.add(B36);
        StandardPathFields.add(B37StandardPath);StandardPathFields.add(C1);StandardPathFields.add(C2);StandardPathFields.add(C3);
        StandardPathFields.add(C4);StandardPathFields.add(C5);StandardPathFields.add(C6);StandardPathFields.add(C7);
        StandardPathFields.add(C8);StandardPathFields.add(C9);StandardPathFields.add(C10);StandardPathFields.add(C11);
        StandardPathFields.add(C12);StandardPathFields.add(C13);StandardPathFields.add(C14);StandardPathFields.add(C15);
        StandardPathFields.add(C16StandardPath);StandardPathFields.add(C17);StandardPathFields.add(C18);StandardPathFields.add(C19);
        StandardPathFields.add(C20);StandardPathFields.add(C21);StandardPathFields.add(C22);StandardPathFields.add(C23StandardPath);
        StandardPathFields.add(C24);StandardPathFields.add(C25);StandardPathFields.add(C26);StandardPathFields.add(C27);
        StandardPathFields.add(C28);StandardPathFields.add(C29StandardPath);StandardPathFields.add(C30);StandardPathFields.add(C31);
        StandardPathFields.add(C32);StandardPathFields.add(C33);StandardPathFields.add(C34StandardPath);StandardPathFields.add(C35);
        StandardPathFields.add(C36);StandardPathFields.add(C37);StandardPathFields.add(N1);StandardPathFields.add(N2);StandardPathFields.add(N3);
        StandardPathFields.add(N4);StandardPathFields.add(N5);StandardPathFields.add(N6);StandardPathFields.add(N7);
        StandardPathFields.add(N8);StandardPathFields.add(N9);StandardPathFields.add(N10);StandardPathFields.add(N11);
        StandardPathFields.add(N12);StandardPathFields.add(N13);StandardPathFields.add(N14);StandardPathFields.add(N15);
        StandardPathFields.add(N16);StandardPathFields.add(N17);StandardPathFields.add(N18);StandardPathFields.add(N19);
        StandardPathFields.add(N20);StandardPathFields.add(N21);StandardPathFields.add(N22);StandardPathFields.add(N23);
        StandardPathFields.add(N24);StandardPathFields.add(N25);StandardPathFields.add(N26);StandardPathFields.add(N27);
        StandardPathFields.add(N28);StandardPathFields.add(N29);StandardPathFields.add(N30);StandardPathFields.add(N31);
        StandardPathFields.add(N32);StandardPathFields.add(N33);StandardPathFields.add(N34StandardPath);StandardPathFields.add(N35StandardPath);
        StandardPathFields.add(N36StandardPath);StandardPathFields.add(N37StandardPath);StandardPathFields.add(I1);StandardPathFields.add(I2);
        StandardPathFields.add(I3);StandardPathFields.add(I4);StandardPathFields.add(I5);StandardPathFields.add(I6);StandardPathFields.add(I7);
        StandardPathFields.add(I8);StandardPathFields.add(I9);StandardPathFields.add(I10);StandardPathFields.add(I11);StandardPathFields.add(I12);
        StandardPathFields.add(I13);StandardPathFields.add(I14);StandardPathFields.add(I15);StandardPathFields.add(I16);
        StandardPathFields.add(I17);StandardPathFields.add(I18);StandardPathFields.add(I19);StandardPathFields.add(I20);
        StandardPathFields.add(I21);StandardPathFields.add(I22StandardPath);StandardPathFields.add(I23);StandardPathFields.add(I24);
        StandardPathFields.add(I25);StandardPathFields.add(I26);StandardPathFields.add(I27);StandardPathFields.add(I28StandardPath);
        StandardPathFields.add(I29);StandardPathFields.add(I30);StandardPathFields.add(I31);StandardPathFields.add(I32);
        StandardPathFields.add(I33StandardPath);StandardPathFields.add(I34);StandardPathFields.add(I35);StandardPathFields.add(I36);
        StandardPathFields.add(I37StandardPath);StandardPathFields.add(K1);StandardPathFields.add(K2);
        StandardPathFields.add(K3);StandardPathFields.add(K4);StandardPathFields.add(K5);StandardPathFields.add(K6);StandardPathFields.add(K7);
        StandardPathFields.add(K8);StandardPathFields.add(K9);StandardPathFields.add(K10);StandardPathFields.add(K11);StandardPathFields.add(K12);
        StandardPathFields.add(K13);StandardPathFields.add(K14);StandardPathFields.add(K15);StandardPathFields.add(K16);
        StandardPathFields.add(K17);StandardPathFields.add(K18);StandardPathFields.add(K19);StandardPathFields.add(K20);
        StandardPathFields.add(K21);StandardPathFields.add(K22);StandardPathFields.add(K23);StandardPathFields.add(K24);
        StandardPathFields.add(K25);StandardPathFields.add(K26);StandardPathFields.add(K27);StandardPathFields.add(K28);
        StandardPathFields.add(K29);StandardPathFields.add(K30);StandardPathFields.add(K31);StandardPathFields.add(K32);
        StandardPathFields.add(K33StandardPath);StandardPathFields.add(K34);StandardPathFields.add(K35);StandardPathFields.add(K36StandardPath);
        StandardPathFields.add(K37StandardPath);StandardPathFields.add(EDBlue1);StandardPathFields.add(EDBlue2);StandardPathFields.add(EDBlue3);





    }


    public void setupHillsOfGold() {
        Field B1 = new Field(0, "Green", true, "B1");
        Field B2 = new Field(0, "Green", true, "B2");
        Field B3 = new Field(0, "Green", true, "B3");
        Field B4 = new Field(0, "Green", true, "B4");
        Field B5 = new Field(1, "Green", true, "B5");
        Field B6 = new Field(1, "Green", true, "B6");
        Field B7 = new Field(1, "Green", true, "B7");
        Field B8 = new Field(1, "Green", true, "B8");
        Field B9 = new Field(1, "Green", true, "B9");
        Field B10 = new Field(1, "Green", true, "B10");
        Field B11 = new Field(1, "Green", true, "B11");
        Field B12 = new Field(1, "Green", true, "B12");
        Field B13 = new Field(1, "Blue", true, "B13");
        Field B14 = new Field(1, "Green", true, "B14");
        Field B15 = new Field(1, "Green", true, "B15");
        Field B16 = new Field(1, "Green", true, "B16");
        Field B17 = new Field(1, "Green", true, "B17");
        Field B18 = new Field(1, "Yellow", true, "B18");
        Field B19 = new Field(1, "Green", true, "B19");
        Field B20 = new Field(1, "Yellow", true, "B20");
        Field B21 = new Field(1, "Green", true, "B21");
        Field B22 = new Field(1, "Blue", true, "B22");
        Field B23 = new Field(1, "Green", true, "B23");
        Field B24 = new Field(1, "Green", true, "B24");
        Field B25 = new Field(1, "Green", true, "B25");
        Field B26 = new Field(1, "Green", true, "B26");
        Field B27 = new Field(1, "Yellow", true, "B27");
        Field B28 = new Field(1, "Green", true, "B28");
        Field B29 = new Field(1, "Green", true, "B29");
        Field B30 = new Field(0, "Cave", false, "B30");
        Field B31 = new Field(1, "Yellow", true, "B31");
        Field B32 = new Field(1, "Green", true, "B32");
        Field B33 = new Field(1, "Green", true, "B33");
        Field B34 = new Field(1, "Blue", true, "B34");
        Field B35 = new Field(1, "Camp", true, "B35");
        Field B36 = new Field(1, "Blue", true, "B36");
        Field B37 = new Field(1, "Green", true, "B37");
        B1.AddNewNeighbour(B2, B5, B6);
        B2.AddNewNeighbour(B1, B6, B7, B3);
        B3.AddNewNeighbour(B2, B7, B8, B4);
        B4.AddNewNeighbour(B3, B8, B9);
        B5.AddNewNeighbour(B1, B6, B10, B11);
        B6.AddNewNeighbour(B1, B2, B7, B12, B11, B5);
        B7.AddNewNeighbour(B2, B3, B8, B13, B12, B6);
        B8.AddNewNeighbour(B3, B4, B9, B14, B13, B7);
        B9.AddNewNeighbour(B4, B15, B14, B8);
        B10.AddNewNeighbour(B5, B11, B17, B16);
        B11.AddNewNeighbour(B5, B6, B12, B18, B17, B10);
        B12.AddNewNeighbour(B6, B7, B13, B19, B18, B11);
        B13.AddNewNeighbour(B7, B8, B14, B20, B19, B12);
        B14.AddNewNeighbour(B8, B9, B15, B21, B20, B13);
        B15.AddNewNeighbour(B9, B22, B21, B14);
        B16.AddNewNeighbour(B10, B17, B23);
        B17.AddNewNeighbour(B10, B11, B18, B24, B23, B16);
        B18.AddNewNeighbour(B11, B12, B19, B25, B24, B17);
        B19.AddNewNeighbour(B12, B13, B20, B26, B25, B18);
        B20.AddNewNeighbour(B13, B14, B21, B27, B26, B19);
        B21.AddNewNeighbour(B14, B15, B22, B28, B27, B20);
        B22.AddNewNeighbour(B15, B28, B21);
        B23.AddNewNeighbour(B16, B17, B24, B29);
        B24.AddNewNeighbour(B17, B18, B25, B30, B29, B23);
        B25.AddNewNeighbour(B18, B19, B26, B31, B30, B24);
        B26.AddNewNeighbour(B19, B20, B27, B32, B32, B25);
        B27.AddNewNeighbour(B20, B21, B28, B33, B32, B26);
        B28.AddNewNeighbour(B21, B22, B33, B27);
        B29.AddNewNeighbour(B23, B24, B30, B34);
        B30.AddNewNeighbour(B24, B25, B31, B35, B34, B29);
        B31.AddNewNeighbour(B25, B26, B32, B36, B35, B30);
        B32.AddNewNeighbour(B26, B27, B33, B37, B36, B31);
        B33.AddNewNeighbour(B27, B28, B37, B32);
        B34.AddNewNeighbour(B29, B30, B35);
        B35.AddNewNeighbour(B34, B30, B31, B36);
        B36.AddNewNeighbour(B35, B31, B32, B37);
        B37.AddNewNeighbour(B36, B32, B33);

        Field C1 = new Field(1, "Blue", true, "C1");
        Field C2 = new Field(1, "Blue", true, "C2");
        Field C3 = new Field(1, "Green", true, "C3");
        Field C4 = new Field(1, "Green", true, "C4");
        Field C5 = new Field(1, "Yellow", true, "C5");
        Field C6 = new Field(1, "Yellow", true, "C6");
        Field C7 = new Field(1, "Blue", true, "C7");
        Field C8 = new Field(1, "Yellow", true, "C8");
        Field C9 = new Field(1, "Green", true, "C9");
        Field C10 = new Field(1, "Yellow", true, "C10");
        Field C11 = new Field(1, "White", true, "C11");
        Field C12 = new Field(1, "White", true, "C12");
        Field C13 = new Field(1, "Yellow", true, "C13");
        Field C14 = new Field(1, "White", true, "C14");
        Field C15 = new Field(1, "White", true, "C15");
        Field C16 = new Field(1, "Green", true, "C16");
        Field C17 = new Field(1, "White", true, "C17");
        Field C18 = new Field(1, "Blue", true, "C18");
        Field C19 = new Field(0, "Cave", false, "C19");
        Field C20 = new Field(1, "Yellow", true, "C20");
        Field C21 = new Field(1, "Blue", true, "C21");
        Field C22 = new Field(1, "White", true, "C22");
        Field C23 = new Field(1, "Green", true, "C23");
        Field C24 = new Field(1, "Green", true, "C24");
        Field C25 = new Field(1, "Blue", true, "C25");
        Field C26 = new Field(1, "Blue", true, "C26");
        Field C27 = new Field(1, "White", true, "C27");
        Field C28 = new Field(1, "Blue", true, "C28");
        Field C29 = new Field(1, "Blue", true, "C29");
        Field C30 = new Field(1, "Yellow", true, "C30");
        Field C31 = new Field(1, "Yellow", true, "C31");
        Field C32 = new Field(1, "White", true, "C32");
        Field C33 = new Field(1, "Blue", true, "C33");
        Field C34 = new Field(1, "Blue", true, "C34");
        Field C35 = new Field(1, "Blue", true, "C35");
        Field C36 = new Field(1, "Yellow", true, "C36");
        Field C37 = new Field(1, "White", true, "C37");
        C1.AddNewNeighbour(C2, C5, C6);
        C2.AddNewNeighbour(C1, C6, C7, C3);
        C3.AddNewNeighbour(C2, C7, C8, C4);
        C4.AddNewNeighbour(C3, C8, C9);
        C5.AddNewNeighbour(C1, C6, C10, C11);
        C6.AddNewNeighbour(C1, C2, C7, C12, C11, C5);
        C7.AddNewNeighbour(C2, C3, C8, C13, C12, C6);
        C8.AddNewNeighbour(C3, C4, C9, C14, C13, C7);
        C9.AddNewNeighbour(C4, C15, C14, C8);
        C10.AddNewNeighbour(C5, C11, C17, C16);
        C11.AddNewNeighbour(C5, C6, C12, C18, C17, C10);
        C12.AddNewNeighbour(C6, C7, C13, C19, C18, C11);
        C13.AddNewNeighbour(C7, C8, C14, C20, C19, C12);
        C14.AddNewNeighbour(C8, C9, C15, C21, C20, C13);
        C15.AddNewNeighbour(C9, C22, C21, C14);
        C16.AddNewNeighbour(C10, C17, C23);
        C17.AddNewNeighbour(C10, C11, C18, C24, C23, C16);
        C18.AddNewNeighbour(C11, C12, C19, C25, C24, C17);
        C19.AddNewNeighbour(C12, C13, C20, C26, C25, C18);
        C20.AddNewNeighbour(C13, C14, C21, C27, C26, C19);
        C21.AddNewNeighbour(C14, C15, C22, C28, C27, C20);
        C22.AddNewNeighbour(C15, C28, C21);
        C23.AddNewNeighbour(C16, C17, C24, C29);
        C24.AddNewNeighbour(C17, C18, C25, C30, C29, C23);
        C25.AddNewNeighbour(C18, C19, C26, C31, C30, C24);
        C26.AddNewNeighbour(C19, C20, C27, C32, C32, C25);
        C27.AddNewNeighbour(C20, C21, C28, C33, C32, C26);
        C28.AddNewNeighbour(C21, C22, C33, C27);
        C29.AddNewNeighbour(C23, C24, C30, C34);
        C30.AddNewNeighbour(C24, C25, C31, C35, C34, C29);
        C31.AddNewNeighbour(C25, C26, C32, C36, C35, C30);
        C32.AddNewNeighbour(C26, C27, C33, C37, C36, C31);
        C33.AddNewNeighbour(C27, C28, C37, C32);
        C34.AddNewNeighbour(C29, C30, C35);
        C35.AddNewNeighbour(C34, C30, C31, C36);
        C36.AddNewNeighbour(C35, C31, C32, C37);
        C37.AddNewNeighbour(C36, C32, C33);

        Field G1 = new Field(1, "Green", true, "G1");
        Field G2 = new Field(1, "Green", true, "G2");
        Field G3 = new Field(1, "Green", true, "G3");
        Field G4 = new Field(1, "Green", true, "G4");
        Field G5 = new Field(1, "Green", true, "G5");
        Field G6 = new Field(2, "Green", true, "G6");
        Field G7 = new Field(1, "Yellow", true, "G7");
        Field G8 = new Field(0, "Cave", false, "G8");
        Field G9 = new Field(1, "Green", true, "G9");
        Field G10 = new Field(1, "Yellow", true, "G10");
        Field G11 = new Field(2, "Yellow", true, "G11");
        Field G12 = new Field(2, "Yellow", true, "G12");
        Field G13 = new Field(1, "White", true, "G13");
        Field G14 = new Field(1, "Yellow", true, "G14");
        Field G15 = new Field(1, "Green", true, "G15");
        Field G16 = new Field(0, "Cave", false, "G16");
        Field G17 = new Field(0, "Cave", false, "G17");
        Field G18 = new Field(4, "Yellow", true, "G18");
        Field G19 = new Field(3, "Yellow", true, "G19");
        Field G20 = new Field(2, "Yellow", true, "G20");
        Field G21 = new Field(2, "Green", true, "G21");
        Field G22 = new Field(1, "Camp", true, "G22");
        Field G23 = new Field(1, "Yellow", true, "G23");
        Field G24 = new Field(2, "Yellow", true, "G24");
        Field G25 = new Field(2, "Yellow", true, "G25");
        Field G26 = new Field(1, "White", true, "G26");
        Field G27 = new Field(1, "Yellow", true, "G27");
        Field G28 = new Field(1, "Green", true, "G28");
        Field G29 = new Field(1, "Green", true, "G29");
        Field G30 = new Field(2, "Green", true, "G30");
        Field G31 = new Field(1, "Yellow", true, "G31");
        Field G32 = new Field(0, "Cave", false, "G32");
        Field G33 = new Field(1, "Green", true, "G33");
        Field G34 = new Field(1, "Green", true, "G34");
        Field G35 = new Field(1, "Green", true, "G35");
        Field G36 = new Field(1, "Green", true, "G36");
        Field G37 = new Field(1, "Green", true, "G37");
        G1.AddNewNeighbour(G2, G5, G6);
        G2.AddNewNeighbour(G1, G6, G7, G3);
        G3.AddNewNeighbour(G2, G7, G8, G4);
        G4.AddNewNeighbour(G3, G8, G9);
        G5.AddNewNeighbour(G1, G6, G10, G11);
        G6.AddNewNeighbour(G1, G2, G7, G12, G11, G5);
        G7.AddNewNeighbour(G2, G3, G8, G13, G12, G6);
        G8.AddNewNeighbour(G3, G4, G9, G14, G13, G7);
        G9.AddNewNeighbour(G4, G15, G14, G8);
        G10.AddNewNeighbour(G5, G11, G17, G16);
        G11.AddNewNeighbour(G5, G6, G12, G18, G17, G10);
        G12.AddNewNeighbour(G6, G7, G13, G19, G18, G11);
        G13.AddNewNeighbour(G7, G8, G14, G20, G19, G12);
        G14.AddNewNeighbour(G8, G9, G15, G21, G20, G13);
        G15.AddNewNeighbour(G9, G22, G21, G14);
        G16.AddNewNeighbour(G10, G17, G23);
        G17.AddNewNeighbour(G10, G11, G18, G24, G23, G16);
        G18.AddNewNeighbour(G11, G12, G19, G25, G24, G17);
        G19.AddNewNeighbour(G12, G13, G20, G26, G25, G18);
        G20.AddNewNeighbour(G13, G14, G21, G27, G26, G19);
        G21.AddNewNeighbour(G14, G15, G22, G28, G27, G20);
        G22.AddNewNeighbour(G15, G28, G21);
        G23.AddNewNeighbour(G16, G17, G24, G29);
        G24.AddNewNeighbour(G17, G18, G25, G30, G29, G23);
        G25.AddNewNeighbour(G18, G19, G26, G31, G30, G24);
        G26.AddNewNeighbour(G19, G20, G27, G32, G32, G25);
        G27.AddNewNeighbour(G20, G21, G28, G33, G32, G26);
        G28.AddNewNeighbour(G21, G22, G33, G27);
        G29.AddNewNeighbour(G23, G24, G30, G34);
        G30.AddNewNeighbour(G24, G25, G31, G35, G34, G29);
        G31.AddNewNeighbour(G25, G26, G32, G36, G35, G30);
        G32.AddNewNeighbour(G26, G27, G33, G37, G36, G31);
        G33.AddNewNeighbour(G27, G28, G37, G32);
        G34.AddNewNeighbour(G29, G30, G35);
        G35.AddNewNeighbour(G34, G30, G31, G36);
        G36.AddNewNeighbour(G35, G31, G32, G37);
        G37.AddNewNeighbour(G36, G32, G33);

        Field J1 = new Field(1, "Yellow", true, "J1");
        Field J2 = new Field(1, "Yellow", true, "J2");
        Field J3 = new Field(1, "Yellow", true, "J3");
        Field J4 = new Field(1, "Yellow", true, "J4");
        Field J5 = new Field(1, "Yellow", true, "J5");
        Field J6 = new Field(2, "Yellow", true, "J6");
        Field J7 = new Field(2, "Yellow", true, "J7");
        Field J8 = new Field(1, "Yellow", true, "J8");
        Field J9 = new Field(1, "Blue", true, "J9");
        Field J10 = new Field(1, "Yellow", true, "J10");
        Field J11 = new Field(2, "Yellow", true, "J11");
        Field J12 = new Field(1, "Green", true, "J12");
        Field J13 = new Field(2, "Green", true, "J13");
        Field J14 = new Field(2, "Blue", true, "J14");
        Field J15 = new Field(1, "Blue", true, "J15");
        Field J16 = new Field(2, "White", true, "J16");
        Field J17 = new Field(0, "Cave", false, "J17");
        Field J18 = new Field(1, "Green", true, "J18");
        Field J19 = new Field(1, "Camp", true, "J19");
        Field J20 = new Field(1, "Green", true, "J20");
        Field J21 = new Field(0, "Cave", false, "J21");
        Field J22 = new Field(1, "Blue", true, "J22");
        Field J23 = new Field(1, "White", true, "J23");
        Field J24 = new Field(2, "White", true, "J24");
        Field J25 = new Field(1, "Green", true, "J25");
        Field J26 = new Field(2, "Green", true, "J26");
        Field J27 = new Field(2, "Blue", true, "J27");
        Field J28 = new Field(1, "Blue", true, "J28");
        Field J29 = new Field(1, "White", true, "J29");
        Field J30 = new Field(2, "White", true, "J30");
        Field J31 = new Field(2, "White", true, "J31");
        Field J32 = new Field(1, "Blue", true, "J32");
        Field J33 = new Field(1, "Blue", true, "J33");
        Field J34 = new Field(1, "White", true, "J34");
        Field J35 = new Field(1, "White", true, "J35");
        Field J36 = new Field(2, "White", true, "J36");
        Field J37 = new Field(1, "Blue", true, "J37");
        J1.AddNewNeighbour(J2, J5, J6);
        J2.AddNewNeighbour(J1, J6, J7, J3);
        J3.AddNewNeighbour(J2, J7, J8, J4);
        J4.AddNewNeighbour(J3, J8, J9);
        J5.AddNewNeighbour(J1, J6, J10, J11);
        J6.AddNewNeighbour(J1, J2, J7, J12, J11, J5);
        J7.AddNewNeighbour(J2, J3, J8, J13, J12, J6);
        J8.AddNewNeighbour(J3, J4, J9, J14, J13, J7);
        J9.AddNewNeighbour(J4, J15, J14, J8);
        J10.AddNewNeighbour(J5, J11, J17, J16);
        J11.AddNewNeighbour(J5, J6, J12, J18, J17, J10);
        J12.AddNewNeighbour(J6, J7, J13, J19, J18, J11);
        J13.AddNewNeighbour(J7, J8, J14, J20, J19, J12);
        J14.AddNewNeighbour(J8, J9, J15, J21, J20, J13);
        J15.AddNewNeighbour(J9, J22, J21, J14);
        J16.AddNewNeighbour(J10, J17, J23);
        J17.AddNewNeighbour(J10, J11, J18, J24, J23, J16);
        J18.AddNewNeighbour(J11, J12, J19, J25, J24, J17);
        J19.AddNewNeighbour(J12, J13, J20, J26, J25, J18);
        J20.AddNewNeighbour(J13, J14, J21, J27, J26, J19);
        J21.AddNewNeighbour(J14, J15, J22, J28, J27, J20);
        J22.AddNewNeighbour(J15, J28, J21);
        J23.AddNewNeighbour(J16, J17, J24, J29);
        J24.AddNewNeighbour(J17, J18, J25, J30, J29, J23);
        J25.AddNewNeighbour(J18, J19, J26, J31, J30, J24);
        J26.AddNewNeighbour(J19, J20, J27, J32, J32, J25);
        J27.AddNewNeighbour(J20, J21, J28, J33, J32, J26);
        J28.AddNewNeighbour(J21, J22, J33, J27);
        J29.AddNewNeighbour(J23, J24, J30, J34);
        J30.AddNewNeighbour(J24, J25, J31, J35, J34, J29);
        J31.AddNewNeighbour(J25, J26, J32, J36, J35, J30);
        J32.AddNewNeighbour(J26, J27, J33, J37, J36, J31);
        J33.AddNewNeighbour(J27, J28, J37, J32);
        J34.AddNewNeighbour(J29, J30, J35);
        J35.AddNewNeighbour(J34, J30, J31, J36);
        J36.AddNewNeighbour(J35, J31, J32, J37);
        J37.AddNewNeighbour(J36, J32, J33);

        Field K1 = new Field(1, "Green", true, "K1");
        Field K2 = new Field(2, "Green", true, "K2");
        Field K3 = new Field(2, "Green", true, "K3");
        Field K4 = new Field(2, "Green", true, "K4");
        Field K5 = new Field(2, "Green", true, "K5");
        Field K6 = new Field(1, "Green", true, "K6");
        Field K7 = new Field(1, "Green", true, "K7");
        Field K8 = new Field(1, "Green", true, "K8");
        Field K9 = new Field(1, "Green", true, "K9");
        Field K10 = new Field(2, "Green", true, "K10");
        Field K11 = new Field(4, "Yellow", true, "K11");
        Field K12 = new Field(3, "Green", true, "K12");
        Field K13 = new Field(3, "Green", true, "K13");
        Field K14 = new Field(2, "Green", true, "K14");
        Field K15 = new Field(1, "Green", true, "K15");
        Field K16 = new Field(1, "Camp", true, "K16");
        Field K17 = new Field(1, "Green", true, "K17");
        Field K18 = new Field(1, "Green", true, "K18");
        Field K19 = new Field(1, "Green", true, "K19");
        Field K20 = new Field(1, "Green", true, "K20");
        Field K21 = new Field(1, "Green", true, "K21");
        Field K22 = new Field(1, "Camp", true, "K22");
        Field K23 = new Field(1, "Green", true, "K23");
        Field K24 = new Field(2, "Green", true, "K24");
        Field K25 = new Field(3, "Green", true, "K25");
        Field K26 = new Field(3, "Green", true, "K26");
        Field K27 = new Field(3, "Blue", true, "K27");
        Field K28 = new Field(2, "Green", true, "K28");
        Field K29 = new Field(1, "Green", true, "K29");
        Field K30 = new Field(1, "Green", true, "K30");
        Field K31 = new Field(1, "Green", true, "K31");
        Field K32 = new Field(1, "Green", true, "K32");
        Field K33 = new Field(2, "Green", true, "K33");
        Field K34 = new Field(2, "Green", true, "K34");
        Field K35 = new Field(2, "Green", true, "K35");
        Field K36 = new Field(2, "Green", true, "K36");
        Field K37 = new Field(1, "Green", true, "K37");
        K1.AddNewNeighbour(K2, K5, K6);
        K2.AddNewNeighbour(K1, K6, K7, K3);
        K3.AddNewNeighbour(K2, K7, K8, K4);
        K4.AddNewNeighbour(K3, K8, K9);
        K5.AddNewNeighbour(K1, K6, K10, K11);
        K6.AddNewNeighbour(K1, K2, K7, K12, K11, K5);
        K7.AddNewNeighbour(K2, K3, K8, K13, K12, K6);
        K8.AddNewNeighbour(K3, K4, K9, K14, K13, K7);
        K9.AddNewNeighbour(K4, K15, K14, K8);
        K10.AddNewNeighbour(K5, K11, K17, K16);
        K11.AddNewNeighbour(K5, K6, K12, K18, K17, K10);
        K12.AddNewNeighbour(K6, K7, K13, K19, K18, K11);
        K13.AddNewNeighbour(K7, K8, K14, K20, K19, K12);
        K14.AddNewNeighbour(K8, K9, K15, K21, K20, K13);
        K15.AddNewNeighbour(K9, K22, K21, K14);
        K16.AddNewNeighbour(K10, K17, K23);
        K17.AddNewNeighbour(K10, K11, K18, K24, K23, K16);
        K18.AddNewNeighbour(K11, K12, K19, K25, K24, K17);
        K19.AddNewNeighbour(K12, K13, K20, K26, K25, K18);
        K20.AddNewNeighbour(K13, K14, K21, K27, K26, K19);
        K21.AddNewNeighbour(K14, K15, K22, K28, K27, K20);
        K22.AddNewNeighbour(K15, K28, K21);
        K23.AddNewNeighbour(K16, K17, K24, K29);
        K24.AddNewNeighbour(K17, K18, K25, K30, K29, K23);
        K25.AddNewNeighbour(K18, K19, K26, K31, K30, K24);
        K26.AddNewNeighbour(K19, K20, K27, K32, K32, K25);
        K27.AddNewNeighbour(K20, K21, K28, K33, K32, K26);
        K28.AddNewNeighbour(K21, K22, K33, K27);
        K29.AddNewNeighbour(K23, K24, K30, K34);
        K30.AddNewNeighbour(K24, K25, K31, K35, K34, K29);
        K31.AddNewNeighbour(K25, K26, K32, K36, K35, K30);
        K32.AddNewNeighbour(K26, K27, K33, K37, K36, K31);
        K33.AddNewNeighbour(K27, K28, K37, K32);
        K34.AddNewNeighbour(K29, K30, K35);
        K35.AddNewNeighbour(K34, K30, K31, K36);
        K36.AddNewNeighbour(K35, K31, K32, K37);
        K37.AddNewNeighbour(K36, K32, K33);

        Field N1 = new Field(1, "Green", true, "N1");
        Field N2 = new Field(1, "Green", true, "N2");
        Field N3 = new Field(1, "Green", true, "N3");
        Field N4 = new Field(1, "Green", true, "N4");
        Field N5 = new Field(1, "Green", true, "N5");
        Field N6 = new Field(1, "Green", true, "N6");
        Field N7 = new Field(2, "Green", true, "N7");
        Field N8 = new Field(1, "Green", true, "N8");
        Field N9 = new Field(1, "Green", true, "N9");
        Field N10 = new Field(1, "Yellow", true, "N10");
        Field N11 = new Field(2, "Yellow", true, "N11");
        Field N12 = new Field(1, "Green", true, "N12");
        Field N13 = new Field(1, "Blue", true, "N13");
        Field N14 = new Field(1, "Blue", true, "N14");
        Field N15 = new Field(1, "Blue", true, "N15");
        Field N16 = new Field(1, "Yellow", true, "N16");
        Field N17 = new Field(2, "Yellow", true, "N17");
        Field N18 = new Field(3, "Yellow", true, "N18");
        Field N19 = new Field(4, "Yellow", true, "N19");
        Field N20 = new Field(3, "Yellow", true, "N20");
        Field N21 = new Field(1, "Blue", true, "N21");
        Field N22 = new Field(1, "Blue", true, "N22");
        Field N23 = new Field(1, "Blue", true, "N23");
        Field N24 = new Field(1, "Blue", true, "N24");
        Field N25 = new Field(1, "Blue", true, "N25");
        Field N26 = new Field(1, "Green", true, "N26");
        Field N27 = new Field(2, "Yellow", true, "N27");
        Field N28 = new Field(1, "Yellow", true, "N28");
        Field N29 = new Field(1, "Blue", true, "N29");
        Field N30 = new Field(1, "Green", true, "N30");
        Field N31 = new Field(2, "Green", true, "N31");
        Field N32 = new Field(1, "Green", true, "N32");
        Field N33 = new Field(1, "Yellow", true, "N33");
        Field N34 = new Field(1, "Green", true, "N34");
        Field N35 = new Field(1, "Green", true, "N35");
        Field N36 = new Field(1, "Green", true, "N36");
        Field N37 = new Field(1, "Green", true, "N37");
        N1.AddNewNeighbour(N2, N5, N6);
        N2.AddNewNeighbour(N1, N6, N7, N3);
        N3.AddNewNeighbour(N2, N7, N8, N4);
        N4.AddNewNeighbour(N3, N8, N9);
        N5.AddNewNeighbour(N1, N6, N10, N11);
        N6.AddNewNeighbour(N1, N2, N7, N12, N11, N5);
        N7.AddNewNeighbour(N2, N3, N8, N13, N12, N6);
        N8.AddNewNeighbour(N3, N4, N9, N14, N13, N7);
        N9.AddNewNeighbour(N4, N15, N14, N8);
        N10.AddNewNeighbour(N5, N11, N17, N16);
        N11.AddNewNeighbour(N5, N6, N12, N18, N17, N10);
        N12.AddNewNeighbour(N6, N7, N13, N19, N18, N11);
        N13.AddNewNeighbour(N7, N8, N14, N20, N19, N12);
        N14.AddNewNeighbour(N8, N9, N15, N21, N20, N13);
        N15.AddNewNeighbour(N9, N22, N21, N14);
        N16.AddNewNeighbour(N10, N17, N23);
        N17.AddNewNeighbour(N10, N11, N18, N24, N23, N16);
        N18.AddNewNeighbour(N11, N12, N19, N25, N24, N17);
        N19.AddNewNeighbour(N12, N13, N20, N26, N25, N18);
        N20.AddNewNeighbour(N13, N14, N21, N27, N26, N19);
        N21.AddNewNeighbour(N14, N15, N22, N28, N27, N20);
        N22.AddNewNeighbour(N15, N28, N21);
        N23.AddNewNeighbour(N16, N17, N24, N29);
        N24.AddNewNeighbour(N17, N18, N25, N30, N29, N23);
        N25.AddNewNeighbour(N18, N19, N26, N31, N30, N24);
        N26.AddNewNeighbour(N19, N20, N27, N32, N32, N25);
        N27.AddNewNeighbour(N20, N21, N28, N33, N32, N26);
        N28.AddNewNeighbour(N21, N22, N33, N27);
        N29.AddNewNeighbour(N23, N24, N30, N34);
        N30.AddNewNeighbour(N24, N25, N31, N35, N34, N29);
        N31.AddNewNeighbour(N25, N26, N32, N36, N35, N30);
        N32.AddNewNeighbour(N26, N27, N33, N37, N36, N31);
        N33.AddNewNeighbour(N27, N28, N37, N32);
        N34.AddNewNeighbour(N29, N30, N35);
        N35.AddNewNeighbour(N34, N30, N31, N36);
        N36.AddNewNeighbour(N35, N31, N32, N37);
        N37.AddNewNeighbour(N36, N32, N33);

        Random rand = new Random();
        int numberOfElements = 5;
        List<Blockade> blockadeList = new ArrayList<>(Blockades);

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(blockadeList.size());
            Blockade randomElement = blockadeList.get(randomIndex);
            blockadeList.remove(randomIndex);
            currentBlockades.add(randomElement);
        }

        currentBlockades.get(0).setName("BK1");
        currentBlockades.get(1).setName("BK2");
        currentBlockades.get(2).setName("BK3");
        currentBlockades.get(3).setName("BK4");
        currentBlockades.get(4).setName("BK5");

        removalList = new ArrayList<>(currentBlockades);


        Blockade HillsOfGoldfirst=currentBlockades.get(0);
        Blockade HillsOfGoldsecond=currentBlockades.get(1);
        Blockade HillsOfGoldthird= currentBlockades.get(2);
        Blockade HillsOfGoldfourth= currentBlockades.get(3);
        Blockade HillsOfGoldfifth=currentBlockades.get(4);


        Field B37HillsOfGold = B37;
        B37HillsOfGold.AddNewNeighbour(HillsOfGoldfirst);
        Field B33HillsOfGold = B33;
        B33HillsOfGold.AddNewNeighbour(HillsOfGoldfirst);
        Field B28HillsOfGold = B28;
        B28HillsOfGold.AddNewNeighbour(HillsOfGoldfirst);
        Field B22HillsOfGold = B22;
        B22HillsOfGold.AddNewNeighbour(HillsOfGoldfirst);
        HillsOfGoldfirst.addNeighbour(B37HillsOfGold);
        HillsOfGoldfirst.addNeighbour(B33HillsOfGold);
        HillsOfGoldfirst.addNeighbour(B28HillsOfGold);
        HillsOfGoldfirst.addNeighbour(B22HillsOfGold);
        HillsOfGoldfirst.addNeighbour(C34);
        HillsOfGoldfirst.addNeighbour(C29);
        HillsOfGoldfirst.addNeighbour(C23);
        HillsOfGoldfirst.addNeighbour(C16);

        Field C22HillsOfGold = C22;
        C22HillsOfGold.AddNewNeighbour(HillsOfGoldsecond);
        Field C15HillsOfGold = C15;
        C15HillsOfGold.AddNewNeighbour(HillsOfGoldsecond);
        Field C9HillsOfGold = C9;
        C9HillsOfGold.AddNewNeighbour(HillsOfGoldsecond);
        Field C4HillsOfGold = C4;
        C4HillsOfGold.AddNewNeighbour(HillsOfGoldsecond);
        HillsOfGoldsecond.addNeighbour(C22HillsOfGold);
        HillsOfGoldsecond.addNeighbour(C15HillsOfGold);
        HillsOfGoldsecond.addNeighbour(C9HillsOfGold);
        HillsOfGoldsecond.addNeighbour(C4HillsOfGold);
        HillsOfGoldsecond.addNeighbour(G16);
        HillsOfGoldsecond.addNeighbour(G10);
        HillsOfGoldsecond.addNeighbour(G5);
        HillsOfGoldsecond.addNeighbour(G1);

        Field G16HillsOfGold = G16;
        G16HillsOfGold.AddNewNeighbour(HillsOfGoldthird);
        Field G23HillsOfGold = G23;
        G23HillsOfGold.AddNewNeighbour(HillsOfGoldthird);
        Field G29HillsOfGold = G29;
        G29HillsOfGold.AddNewNeighbour(HillsOfGoldthird);
        Field G34HillsOfGold = G34;
        G34HillsOfGold.AddNewNeighbour(HillsOfGoldthird);
        HillsOfGoldthird.addNeighbour(G16HillsOfGold);
        HillsOfGoldthird.addNeighbour(G23HillsOfGold);
        HillsOfGoldthird.addNeighbour(G29HillsOfGold);
        HillsOfGoldthird.addNeighbour(G34HillsOfGold);
        HillsOfGoldthird.addNeighbour(K1);
        HillsOfGoldthird.addNeighbour(K2);
        HillsOfGoldthird.addNeighbour(K3);
        HillsOfGoldthird.addNeighbour(K4);

        Field K34HillsOfGold = K34;
        K34HillsOfGold.AddNewNeighbour(HillsOfGoldfourth);
        Field K35HillsOfGold = K35;
        K35HillsOfGold.AddNewNeighbour(HillsOfGoldfourth);
        Field K36HillsOfGold = K36;
        K36HillsOfGold.AddNewNeighbour(HillsOfGoldfourth);
        Field K37HillsOfGold = K37;
        K37HillsOfGold.AddNewNeighbour(HillsOfGoldfourth);
        HillsOfGoldfourth.addNeighbour(K34HillsOfGold);
        HillsOfGoldfourth.addNeighbour(K35HillsOfGold);
        HillsOfGoldfourth.addNeighbour(K36HillsOfGold);
        HillsOfGoldfourth.addNeighbour(K37HillsOfGold);
        HillsOfGoldfourth.addNeighbour(J1);
        HillsOfGoldfourth.addNeighbour(J2);
        HillsOfGoldfourth.addNeighbour(J3);
        HillsOfGoldfourth.addNeighbour(J4);

        Field J37HillsOfGold = J37;
        J37HillsOfGold.AddNewNeighbour(HillsOfGoldfifth);
        Field J33HillsOfGold = J33;
        J33HillsOfGold.AddNewNeighbour(HillsOfGoldfifth);
        Field J28HillsOfGold = J28;
        J28HillsOfGold.AddNewNeighbour(HillsOfGoldfifth);
        Field J22HillsOfGold = J22;
        J22HillsOfGold.AddNewNeighbour(HillsOfGoldfifth);
        HillsOfGoldfifth.addNeighbour(J37HillsOfGold);
        HillsOfGoldfifth.addNeighbour(J33HillsOfGold);
        HillsOfGoldfifth.addNeighbour(J28HillsOfGold);
        HillsOfGoldfifth.addNeighbour(J22HillsOfGold);
        HillsOfGoldfifth.addNeighbour(N37);
        HillsOfGoldfifth.addNeighbour(N36);
        HillsOfGoldfifth.addNeighbour(N35);
        HillsOfGoldfifth.addNeighbour(N34);

        Field EDGreen1 = new Field(1, "Green", true, "EDGreen1");
        Field EDGreen2 = new Field(1, "Green", true, "EDGreen2");
        Field EDGreen3 = new Field(1, "Green", true, "EDGreen3");

        Field N9HillsOfGold = N9;
        N9HillsOfGold.AddNewNeighbour(EDGreen1);
        Field N4HillsOfGold = N4;
        N4HillsOfGold.AddNewNeighbour(EDGreen1, EDGreen2, EDGreen3);
        Field N3HillsOfGold = N3;
        N3HillsOfGold.AddNewNeighbour(EDGreen3);




        HillsOfGoldFields.add(B1);
        HillsOfGoldFields.add(B2);
        HillsOfGoldFields.add(B3);
        HillsOfGoldFields.add(B4);
        HillsOfGoldFields.add(B5);
        HillsOfGoldFields.add(B6);
        HillsOfGoldFields.add(B7);
        HillsOfGoldFields.add(B8);
        HillsOfGoldFields.add(B9);
        HillsOfGoldFields.add(B10);
        HillsOfGoldFields.add(B11);
        HillsOfGoldFields.add(B12);
        HillsOfGoldFields.add(B13);
        HillsOfGoldFields.add(B14);
        HillsOfGoldFields.add(B15);
        HillsOfGoldFields.add(B16);
        HillsOfGoldFields.add(B17);
        HillsOfGoldFields.add(B18);
        HillsOfGoldFields.add(B19);
        HillsOfGoldFields.add(B20);
        HillsOfGoldFields.add(B21);
        HillsOfGoldFields.add(B22HillsOfGold);
        HillsOfGoldFields.add(B23);
        HillsOfGoldFields.add(B24);
        HillsOfGoldFields.add(B25);
        HillsOfGoldFields.add(B26);
        HillsOfGoldFields.add(B27);
        HillsOfGoldFields.add(B28HillsOfGold);
        HillsOfGoldFields.add(B29);
        HillsOfGoldFields.add(B30);
        HillsOfGoldFields.add(B31);
        HillsOfGoldFields.add(B32);
        HillsOfGoldFields.add(B33HillsOfGold);
        HillsOfGoldFields.add(B34);
        HillsOfGoldFields.add(B35);
        HillsOfGoldFields.add(B36);
        HillsOfGoldFields.add(B37HillsOfGold);
        HillsOfGoldFields.add(C1);
        HillsOfGoldFields.add(C2);
        HillsOfGoldFields.add(C3);
        HillsOfGoldFields.add(C4HillsOfGold);
        HillsOfGoldFields.add(C5);
        HillsOfGoldFields.add(C6);
        HillsOfGoldFields.add(C7);
        HillsOfGoldFields.add(C8);
        HillsOfGoldFields.add(C9HillsOfGold);
        HillsOfGoldFields.add(C10);
        HillsOfGoldFields.add(C11);
        HillsOfGoldFields.add(C12);
        HillsOfGoldFields.add(C13);
        HillsOfGoldFields.add(C14);
        HillsOfGoldFields.add(C15HillsOfGold);
        HillsOfGoldFields.add(C16);
        HillsOfGoldFields.add(C17);
        HillsOfGoldFields.add(C18);
        HillsOfGoldFields.add(C19);
        HillsOfGoldFields.add(C20);
        HillsOfGoldFields.add(C21);
        HillsOfGoldFields.add(C22HillsOfGold);
        HillsOfGoldFields.add(C23);
        HillsOfGoldFields.add(C24);
        HillsOfGoldFields.add(C25);
        HillsOfGoldFields.add(C26);
        HillsOfGoldFields.add(C27);
        HillsOfGoldFields.add(C28);
        HillsOfGoldFields.add(C29);
        HillsOfGoldFields.add(C30);
        HillsOfGoldFields.add(C31);
        HillsOfGoldFields.add(C32);
        HillsOfGoldFields.add(C33);
        HillsOfGoldFields.add(C34);
        HillsOfGoldFields.add(C35);
        HillsOfGoldFields.add(C36);
        HillsOfGoldFields.add(C37);
        HillsOfGoldFields.add(G1);
        HillsOfGoldFields.add(G2);
        HillsOfGoldFields.add(G3);
        HillsOfGoldFields.add(G4);
        HillsOfGoldFields.add(G5);
        HillsOfGoldFields.add(G6);
        HillsOfGoldFields.add(G7);
        HillsOfGoldFields.add(G8);
        HillsOfGoldFields.add(G9);
        HillsOfGoldFields.add(G10);
        HillsOfGoldFields.add(G11);
        HillsOfGoldFields.add(G12);
        HillsOfGoldFields.add(G13);
        HillsOfGoldFields.add(G14);
        HillsOfGoldFields.add(G15);
        HillsOfGoldFields.add(G16HillsOfGold);
        HillsOfGoldFields.add(G17);
        HillsOfGoldFields.add(G18);
        HillsOfGoldFields.add(G19);
        HillsOfGoldFields.add(G20);
        HillsOfGoldFields.add(G21);
        HillsOfGoldFields.add(G22);
        HillsOfGoldFields.add(G23HillsOfGold);
        HillsOfGoldFields.add(G24);
        HillsOfGoldFields.add(G25);
        HillsOfGoldFields.add(G26);
        HillsOfGoldFields.add(G27);
        HillsOfGoldFields.add(G28);
        HillsOfGoldFields.add(G29HillsOfGold);
        HillsOfGoldFields.add(G30);
        HillsOfGoldFields.add(G31);
        HillsOfGoldFields.add(G32);
        HillsOfGoldFields.add(G33);
        HillsOfGoldFields.add(G34HillsOfGold);
        HillsOfGoldFields.add(G35);
        HillsOfGoldFields.add(G36);
        HillsOfGoldFields.add(G37);
        HillsOfGoldFields.add(K1);
        HillsOfGoldFields.add(K2);
        HillsOfGoldFields.add(K3);
        HillsOfGoldFields.add(K4);
        HillsOfGoldFields.add(K5);
        HillsOfGoldFields.add(K6);
        HillsOfGoldFields.add(K7);
        HillsOfGoldFields.add(K8);
        HillsOfGoldFields.add(K9);
        HillsOfGoldFields.add(K10);
        HillsOfGoldFields.add(K11);
        HillsOfGoldFields.add(K12);
        HillsOfGoldFields.add(K13);
        HillsOfGoldFields.add(K14);
        HillsOfGoldFields.add(K15);
        HillsOfGoldFields.add(K16);
        HillsOfGoldFields.add(K17);
        HillsOfGoldFields.add(K18);
        HillsOfGoldFields.add(K19);
        HillsOfGoldFields.add(K20);
        HillsOfGoldFields.add(K21);
        HillsOfGoldFields.add(K22);
        HillsOfGoldFields.add(K23);
        HillsOfGoldFields.add(K24);
        HillsOfGoldFields.add(K25);
        HillsOfGoldFields.add(K26);
        HillsOfGoldFields.add(K27);
        HillsOfGoldFields.add(K28);
        HillsOfGoldFields.add(K29);
        HillsOfGoldFields.add(K30);
        HillsOfGoldFields.add(K31);
        HillsOfGoldFields.add(K32);
        HillsOfGoldFields.add(K33);
        HillsOfGoldFields.add(K34HillsOfGold);
        HillsOfGoldFields.add(K35HillsOfGold);
        HillsOfGoldFields.add(K36HillsOfGold);
        HillsOfGoldFields.add(K37HillsOfGold);
        HillsOfGoldFields.add(J1);
        HillsOfGoldFields.add(J2);
        HillsOfGoldFields.add(J3);
        HillsOfGoldFields.add(J4);
        HillsOfGoldFields.add(J5);
        HillsOfGoldFields.add(J6);
        HillsOfGoldFields.add(J7);
        HillsOfGoldFields.add(J8);
        HillsOfGoldFields.add(J9);
        HillsOfGoldFields.add(J10);
        HillsOfGoldFields.add(J11);
        HillsOfGoldFields.add(J12);
        HillsOfGoldFields.add(J13);
        HillsOfGoldFields.add(J14);
        HillsOfGoldFields.add(J15);
        HillsOfGoldFields.add(J16);
        HillsOfGoldFields.add(J17);
        HillsOfGoldFields.add(J18);
        HillsOfGoldFields.add(J19);
        HillsOfGoldFields.add(J20);
        HillsOfGoldFields.add(J21);
        HillsOfGoldFields.add(J22HillsOfGold);
        HillsOfGoldFields.add(J23);
        HillsOfGoldFields.add(J24);
        HillsOfGoldFields.add(J25);
        HillsOfGoldFields.add(J26);
        HillsOfGoldFields.add(J27);
        HillsOfGoldFields.add(J28HillsOfGold);
        HillsOfGoldFields.add(J29);
        HillsOfGoldFields.add(J30);
        HillsOfGoldFields.add(J31);
        HillsOfGoldFields.add(J32);
        HillsOfGoldFields.add(J33HillsOfGold);
        HillsOfGoldFields.add(J34);
        HillsOfGoldFields.add(J35);
        HillsOfGoldFields.add(J36);
        HillsOfGoldFields.add(J37HillsOfGold);
        HillsOfGoldFields.add(N1);
        HillsOfGoldFields.add(N2);
        HillsOfGoldFields.add(N3HillsOfGold);
        HillsOfGoldFields.add(N4HillsOfGold);
        HillsOfGoldFields.add(N5);
        HillsOfGoldFields.add(N6);
        HillsOfGoldFields.add(N7);
        HillsOfGoldFields.add(N8);
        HillsOfGoldFields.add(N9HillsOfGold);
        HillsOfGoldFields.add(N10);
        HillsOfGoldFields.add(N11);
        HillsOfGoldFields.add(N12);
        HillsOfGoldFields.add(N13);
        HillsOfGoldFields.add(N14);
        HillsOfGoldFields.add(N15);
        HillsOfGoldFields.add(N16);
        HillsOfGoldFields.add(N17);
        HillsOfGoldFields.add(N18);
        HillsOfGoldFields.add(N19);
        HillsOfGoldFields.add(N20);
        HillsOfGoldFields.add(N21);
        HillsOfGoldFields.add(N22);
        HillsOfGoldFields.add(N23);
        HillsOfGoldFields.add(N24);
        HillsOfGoldFields.add(N25);
        HillsOfGoldFields.add(N26);
        HillsOfGoldFields.add(N27);
        HillsOfGoldFields.add(N28);
        HillsOfGoldFields.add(N29);
        HillsOfGoldFields.add(N30);
        HillsOfGoldFields.add(N31);
        HillsOfGoldFields.add(N32);
        HillsOfGoldFields.add(N33);
        HillsOfGoldFields.add(N34);
        HillsOfGoldFields.add(N35);
        HillsOfGoldFields.add(N36);
        HillsOfGoldFields.add(N37);
        HillsOfGoldFields.add(EDGreen1);
        HillsOfGoldFields.add(EDGreen2);
        HillsOfGoldFields.add(EDGreen3);
    }


    public void setupHomeStretchFields() {

        Field Q1 = new Field(1, "White", true, "Q1");
        Field Q2 = new Field(1, "Yellow", true, "Q2");
        Field Q3 = new Field(1, "Yellow", true, "Q3");
        Field Q4 = new Field(1, "Blue", true, "Q4");
        Field Q5 = new Field(3, "Green", true, "Q5");
        Field Q6 = new Field(2, "Green", true, "Q6");
        Field Q7 = new Field(1, "White", true, "Q7");
        Field Q8 = new Field(2, "Green", true, "Q8");
        Field Q9 = new Field(3, "Yellow", true, "Q9");
        Field Q10 = new Field(1, "Blue", true, "Q10");
        Field Q11 = new Field(2, "Green", true, "Q11");
        Field Q12 = new Field(1, "Green", true, "Q12");
        Field Q13 = new Field(3, "White", true, "Q13");
        Field Q14 = new Field(1, "Green", true, "Q14");
        Field Q15 = new Field(1, "Green", true, "Q15");
        Field Q16 = new Field(2, "Blue", true, "Q16");
        Q1.AddNewNeighbour(Q2, Q6, Q7);
        Q2.AddNewNeighbour(Q1, Q8, Q7, Q3);
        Q3.AddNewNeighbour(Q2, Q9, Q8, Q4);
        Q4.AddNewNeighbour(Q3, Q5, Q9, Q10);
        Q5.AddNewNeighbour(Q4, Q10, Q11);
        Q6.AddNewNeighbour(Q1, Q7, Q12);
        Q7.AddNewNeighbour(Q1, Q6, Q12, Q13, Q8, Q2);
        Q8.AddNewNeighbour(Q3, Q2, Q7, Q14, Q13, Q9);
        Q9.AddNewNeighbour(Q3, Q4, Q15, Q14, Q8, Q10);
        Q10.AddNewNeighbour(Q5, Q4, Q16, Q15, Q9, Q11);
        Q11.AddNewNeighbour(Q5, Q16, Q10);
        Q12.AddNewNeighbour(Q6, Q7, Q13);
        Q13.AddNewNeighbour(Q7, Q8, Q14, Q12);
        Q14.AddNewNeighbour(Q8, Q9, Q15, Q13);
        Q15.AddNewNeighbour(Q9, Q10, Q16, Q14);
        Q16.AddNewNeighbour(Q10, Q15, Q11);

        Field K1 = new Field(1, "Green", true, "K1");
        Field K2 = new Field(2, "Green", true, "K2");
        Field K3 = new Field(2, "Green", true, "K3");
        Field K4 = new Field(2, "Green", true, "K4");
        Field K5 = new Field(2, "Green", true, "K5");
        Field K6 = new Field(1, "Green", true, "K6");
        Field K7 = new Field(1, "Green", true, "K7");
        Field K8 = new Field(1, "Green", true, "K8");
        Field K9 = new Field(1, "Green", true, "K9");
        Field K10 = new Field(2, "Green", true, "K10");
        Field K11 = new Field(4, "Yellow", true, "K11");
        Field K12 = new Field(3, "Green", true, "K12");
        Field K13 = new Field(3, "Green", true, "K13");
        Field K14 = new Field(2, "Green", true, "K14");
        Field K15 = new Field(1, "Green", true, "K15");
        Field K16 = new Field(1, "Camp", true, "K16");
        Field K17 = new Field(1, "Green", true, "K17");
        Field K18 = new Field(1, "Green", true, "K18");
        Field K19 = new Field(1, "Green", true, "K19");
        Field K20 = new Field(1, "Green", true, "K20");
        Field K21 = new Field(1, "Green", true, "K21");
        Field K22 = new Field(1, "Camp", true, "K22");
        Field K23 = new Field(1, "Green", true, "K23");
        Field K24 = new Field(2, "Green", true, "K24");
        Field K25 = new Field(3, "Green", true, "K25");
        Field K26 = new Field(3, "Green", true, "K26");
        Field K27 = new Field(3, "Blue", true, "K27");
        Field K28 = new Field(2, "Green", true, "K28");
        Field K29 = new Field(1, "Green", true, "K29");
        Field K30 = new Field(1, "Green", true, "K30");
        Field K31 = new Field(1, "Green", true, "K31");
        Field K32 = new Field(1, "Green", true, "K32");
        Field K33 = new Field(2, "Green", true, "K33");
        Field K34 = new Field(2, "Green", true, "K34");
        Field K35 = new Field(2, "Green", true, "K35");
        Field K36 = new Field(2, "Green", true, "K36");
        Field K37 = new Field(1, "Green", true, "K37");
        K1.AddNewNeighbour(K2, K5, K6);
        K2.AddNewNeighbour(K1, K6, K7, K3);
        K3.AddNewNeighbour(K2, K7, K8, K4);
        K4.AddNewNeighbour(K3, K8, K9);
        K5.AddNewNeighbour(K1, K6, K10, K11);
        K6.AddNewNeighbour(K1, K2, K7, K12, K11, K5);
        K7.AddNewNeighbour(K2, K3, K8, K13, K12, K6);
        K8.AddNewNeighbour(K3, K4, K9, K14, K13, K7);
        K9.AddNewNeighbour(K4, K15, K14, K8);
        K10.AddNewNeighbour(K5, K11, K17, K16);
        K11.AddNewNeighbour(K5, K6, K12, K18, K17, K10);
        K12.AddNewNeighbour(K6, K7, K13, K19, K18, K11);
        K13.AddNewNeighbour(K7, K8, K14, K20, K19, K12);
        K14.AddNewNeighbour(K8, K9, K15, K21, K20, K13);
        K15.AddNewNeighbour(K9, K22, K21, K14);
        K16.AddNewNeighbour(K10, K17, K23);
        K17.AddNewNeighbour(K10, K11, K18, K24, K23, K16);
        K18.AddNewNeighbour(K11, K12, K19, K25, K24, K17);
        K19.AddNewNeighbour(K12, K13, K20, K26, K25, K18);
        K20.AddNewNeighbour(K13, K14, K21, K27, K26, K19);
        K21.AddNewNeighbour(K14, K15, K22, K28, K27, K20);
        K22.AddNewNeighbour(K15, K28, K21);
        K23.AddNewNeighbour(K16, K17, K24, K29);
        K24.AddNewNeighbour(K17, K18, K25, K30, K29, K23);
        K25.AddNewNeighbour(K18, K19, K26, K31, K30, K24);
        K26.AddNewNeighbour(K19, K20, K27, K32, K32, K25);
        K27.AddNewNeighbour(K20, K21, K28, K33, K32, K26);
        K28.AddNewNeighbour(K21, K22, K33, K27);
        K29.AddNewNeighbour(K23, K24, K30, K34);
        K30.AddNewNeighbour(K24, K25, K31, K35, K34, K29);
        K31.AddNewNeighbour(K25, K26, K32, K36, K35, K30);
        K32.AddNewNeighbour(K26, K27, K33, K37, K36, K31);
        K33.AddNewNeighbour(K27, K28, K37, K32);
        K34.AddNewNeighbour(K29, K30, K35);
        K35.AddNewNeighbour(K34, K30, K31, K36);
        K36.AddNewNeighbour(K35, K31, K32, K37);
        K37.AddNewNeighbour(K36, K32, K33);

        Field B1 = new Field(0, "Green", true, "B1");
        Field B2 = new Field(0, "Green", true, "B2");
        Field B3 = new Field(0, "Green", true, "B3");
        Field B4 = new Field(0, "Green", true, "B4");
        Field B5 = new Field(1, "Green", true, "B5");
        Field B6 = new Field(1, "Green", true, "B6");
        Field B7 = new Field(1, "Green", true, "B7");
        Field B8 = new Field(1, "Green", true, "B8");
        Field B9 = new Field(1, "Green", true, "B9");
        Field B10 = new Field(1, "Green", true, "B10");
        Field B11 = new Field(1, "Green", true, "B11");
        Field B12 = new Field(1, "Green", true, "B12");
        Field B13 = new Field(1, "Blue", true, "B13");
        Field B14 = new Field(1, "Green", true, "B14");
        Field B15 = new Field(1, "Green", true, "B15");
        Field B16 = new Field(1, "Green", true, "B16");
        Field B17 = new Field(1, "Green", true, "B17");
        Field B18 = new Field(1, "Yellow", true, "B18");
        Field B19 = new Field(1, "Green", true, "B19");
        Field B20 = new Field(1, "Yellow", true, "B20");
        Field B21 = new Field(1, "Green", true, "B21");
        Field B22 = new Field(1, "Blue", true, "B22");
        Field B23 = new Field(1, "Green", true, "B23");
        Field B24 = new Field(1, "Green", true, "B24");
        Field B25 = new Field(1, "Green", true, "B25");
        Field B26 = new Field(1, "Green", true, "B26");
        Field B27 = new Field(1, "Yellow", true, "B27");
        Field B28 = new Field(1, "Green", true, "B28");
        Field B29 = new Field(1, "Green", true, "B29");
        Field B30 = new Field(0, "Cave", false, "B30");
        Field B31 = new Field(1, "Yellow", true, "B31");
        Field B32 = new Field(1, "Green", true, "B32");
        Field B33 = new Field(1, "Green", true, "B33");
        Field B34 = new Field(1, "Blue", true, "B34");
        Field B35 = new Field(1, "Camp", true, "B35");
        Field B36 = new Field(1, "Blue", true, "B36");
        Field B37 = new Field(1, "Green", true, "B37");
        B1.AddNewNeighbour(B2, B5, B6);
        B2.AddNewNeighbour(B1, B6, B7, B3);
        B3.AddNewNeighbour(B2, B7, B8, B4);
        B4.AddNewNeighbour(B3, B8, B9);
        B5.AddNewNeighbour(B1, B6, B10, B11);
        B6.AddNewNeighbour(B1, B2, B7, B12, B11, B5);
        B7.AddNewNeighbour(B2, B3, B8, B13, B12, B6);
        B8.AddNewNeighbour(B3, B4, B9, B14, B13, B7);
        B9.AddNewNeighbour(B4, B15, B14, B8);
        B10.AddNewNeighbour(B5, B11, B17, B16);
        B11.AddNewNeighbour(B5, B6, B12, B18, B17, B10);
        B12.AddNewNeighbour(B6, B7, B13, B19, B18, B11);
        B13.AddNewNeighbour(B7, B8, B14, B20, B19, B12);
        B14.AddNewNeighbour(B8, B9, B15, B21, B20, B13);
        B15.AddNewNeighbour(B9, B22, B21, B14);
        B16.AddNewNeighbour(B10, B17, B23);
        B17.AddNewNeighbour(B10, B11, B18, B24, B23, B16);
        B18.AddNewNeighbour(B11, B12, B19, B25, B24, B17);
        B19.AddNewNeighbour(B12, B13, B20, B26, B25, B18);
        B20.AddNewNeighbour(B13, B14, B21, B27, B26, B19);
        B21.AddNewNeighbour(B14, B15, B22, B28, B27, B20);
        B22.AddNewNeighbour(B15, B28, B21);
        B23.AddNewNeighbour(B16, B17, B24, B29);
        B24.AddNewNeighbour(B17, B18, B25, B30, B29, B23);
        B25.AddNewNeighbour(B18, B19, B26, B31, B30, B24);
        B26.AddNewNeighbour(B19, B20, B27, B32, B32, B25);
        B27.AddNewNeighbour(B20, B21, B28, B33, B32, B26);
        B28.AddNewNeighbour(B21, B22, B33, B27);
        B29.AddNewNeighbour(B23, B24, B30, B34);
        B30.AddNewNeighbour(B24, B25, B31, B35, B34, B29);
        B31.AddNewNeighbour(B25, B26, B32, B36, B35, B30);
        B32.AddNewNeighbour(B26, B27, B33, B37, B36, B31);
        B33.AddNewNeighbour(B27, B28, B37, B32);
        B34.AddNewNeighbour(B29, B30, B35);
        B35.AddNewNeighbour(B34, B30, B31, B36);
        B36.AddNewNeighbour(B35, B31, B32, B37);
        B37.AddNewNeighbour(B36, B32, B33);


        Field C1 = new Field(1, "Blue", true, "C1");
        Field C2 = new Field(1, "Blue", true, "C2");
        Field C3 = new Field(1, "Green", true, "C3");
        Field C4 = new Field(1, "Green", true, "C4");
        Field C5 = new Field(1, "Yellow", true, "C5");
        Field C6 = new Field(1, "Yellow", true, "C6");
        Field C7 = new Field(1, "Blue", true, "C7");
        Field C8 = new Field(1, "Yellow", true, "C8");
        Field C9 = new Field(1, "Green", true, "C9");
        Field C10 = new Field(1, "Yellow", true, "C10");
        Field C11 = new Field(1, "White", true, "C11");
        Field C12 = new Field(1, "White", true, "C12");
        Field C13 = new Field(1, "Yellow", true, "C13");
        Field C14 = new Field(1, "White", true, "C14");
        Field C15 = new Field(1, "White", true, "C15");
        Field C16 = new Field(1, "Green", true, "C16");
        Field C17 = new Field(1, "White", true, "C17");
        Field C18 = new Field(1, "Blue", true, "C18");
        Field C19 = new Field(0, "Cave", false, "C19");
        Field C20 = new Field(1, "Yellow", true, "C20");
        Field C21 = new Field(1, "Blue", true, "C21");
        Field C22 = new Field(1, "White", true, "C22");
        Field C23 = new Field(1, "Green", true, "C23");
        Field C24 = new Field(1, "Green", true, "C24");
        Field C25 = new Field(1, "Blue", true, "C25");
        Field C26 = new Field(1, "Blue", true, "C26");
        Field C27 = new Field(1, "White", true, "C27");
        Field C28 = new Field(1, "Blue", true, "C28");
        Field C29 = new Field(1, "Blue", true, "C29");
        Field C30 = new Field(1, "Yellow", true, "C30");
        Field C31 = new Field(1, "Yellow", true, "C31");
        Field C32 = new Field(1, "White", true, "C32");
        Field C33 = new Field(1, "Blue", true, "C33");
        Field C34 = new Field(1, "Blue", true, "C34");
        Field C35 = new Field(1, "Blue", true, "C35");
        Field C36 = new Field(1, "Yellow", true, "C36");
        Field C37 = new Field(1, "White", true, "C37");
        C1.AddNewNeighbour(C2, C5, C6);
        C2.AddNewNeighbour(C1, C6, C7, C3);
        C3.AddNewNeighbour(C2, C7, C8, C4);
        C4.AddNewNeighbour(C3, C8, C9);
        C5.AddNewNeighbour(C1, C6, C10, C11);
        C6.AddNewNeighbour(C1, C2, C7, C12, C11, C5);
        C7.AddNewNeighbour(C2, C3, C8, C13, C12, C6);
        C8.AddNewNeighbour(C3, C4, C9, C14, C13, C7);
        C9.AddNewNeighbour(C4, C15, C14, C8);
        C10.AddNewNeighbour(C5, C11, C17, C16);
        C11.AddNewNeighbour(C5, C6, C12, C18, C17, C10);
        C12.AddNewNeighbour(C6, C7, C13, C19, C18, C11);
        C13.AddNewNeighbour(C7, C8, C14, C20, C19, C12);
        C14.AddNewNeighbour(C8, C9, C15, C21, C20, C13);
        C15.AddNewNeighbour(C9, C22, C21, C14);
        C16.AddNewNeighbour(C10, C17, C23);
        C17.AddNewNeighbour(C10, C11, C18, C24, C23, C16);
        C18.AddNewNeighbour(C11, C12, C19, C25, C24, C17);
        C19.AddNewNeighbour(C12, C13, C20, C26, C25, C18);
        C20.AddNewNeighbour(C13, C14, C21, C27, C26, C19);
        C21.AddNewNeighbour(C14, C15, C22, C28, C27, C20);
        C22.AddNewNeighbour(C15, C28, C21);
        C23.AddNewNeighbour(C16, C17, C24, C29);
        C24.AddNewNeighbour(C17, C18, C25, C30, C29, C23);
        C25.AddNewNeighbour(C18, C19, C26, C31, C30, C24);
        C26.AddNewNeighbour(C19, C20, C27, C32, C32, C25);
        C27.AddNewNeighbour(C20, C21, C28, C33, C32, C26);
        C28.AddNewNeighbour(C21, C22, C33, C27);
        C29.AddNewNeighbour(C23, C24, C30, C34);
        C30.AddNewNeighbour(C24, C25, C31, C35, C34, C29);
        C31.AddNewNeighbour(C25, C26, C32, C36, C35, C30);
        C32.AddNewNeighbour(C26, C27, C33, C37, C36, C31);
        C33.AddNewNeighbour(C27, C28, C37, C32);
        C34.AddNewNeighbour(C29, C30, C35);
        C35.AddNewNeighbour(C34, C30, C31, C36);
        C36.AddNewNeighbour(C35, C31, C32, C37);
        C37.AddNewNeighbour(C36, C32, C33);

        Field M1 = new Field(1, "Green", true, "M1");
        Field M2 = new Field(1, "Green", true, "M2");
        Field M3 = new Field(1, "Green", true, "M3");
        Field M4 = new Field(1, "Camp", true, "M4");
        Field M5 = new Field(1, "Green", true, "M5");
        Field M6 = new Field(3, "Yellow", true, "M6");
        Field M7 = new Field(0, "Cave", false, "M7");
        Field M8 = new Field(0, "Cave", false, "M8");
        Field M9 = new Field(4, "Blue", true, "M9");
        Field M10 = new Field(1, "Green", true, "M10");
        Field M11 = new Field(2, "Yellow", true, "M11");
        Field M12 = new Field(1, "Green", true, "M12");
        Field M13 = new Field(1, "Green", true, "M13");
        Field M14 = new Field(1, "Blue", true, "M14");
        Field M15 = new Field(0, "Cave", false, "M15");
        Field M16 = new Field(0, "Cave", false, "M16");
        Field M17 = new Field(1, "Green", true, "M17");
        Field M18 = new Field(1, "Green", true, "M18");
        Field M19 = new Field(2, "White", true, "M19");
        Field M20 = new Field(1, "Green", true, "M20");
        Field M21 = new Field(1, "Green", true, "M21");
        Field M22 = new Field(0, "Cave", false, "M22");
        Field M23 = new Field(0, "Cave", false, "M23");
        Field M24 = new Field(0, "Cave", false, "M24");
        Field M25 = new Field(0, "Cave", false, "M25");
        Field M26 = new Field(0, "Cave", false, "M26");
        Field M27 = new Field(2, "White", true, "M27");
        Field M28 = new Field(1, "Green", true, "M28");
        Field M29 = new Field(1, "Green", true, "M29");
        Field M30 = new Field(1, "Green", true, "M30");
        Field M31 = new Field(1, "Green", true, "M31");
        Field M32 = new Field(2, "White", true, "M32");
        Field M33 = new Field(1, "Green", true, "M33");
        Field M34 = new Field(1, "Blue", true, "M34");
        Field M35 = new Field(1, "Blue", true, "M35");
        Field M36 = new Field(1, "Green", true, "M36");
        Field M37 = new Field(1, "Green", true, "M37");
        M1.AddNewNeighbour(M2, M5, M6);
        M2.AddNewNeighbour(M1, M6, M7, M3);
        M3.AddNewNeighbour(M2, M7, M8, M4);
        M4.AddNewNeighbour(M3, M8, M9);
        M5.AddNewNeighbour(M1, M6, M10, M11);
        M6.AddNewNeighbour(M1, M2, M7, M12, M11, M5);
        M7.AddNewNeighbour(M2, M3, M8, M13, M12, M6);
        M8.AddNewNeighbour(M3, M4, M9, M14, M13, M7);
        M9.AddNewNeighbour(M4, M15, M14, M8);
        M10.AddNewNeighbour(M5, M11, M17, M16);
        M11.AddNewNeighbour(M5, M6, M12, M18, M17, M10);
        M12.AddNewNeighbour(M6, M7, M13, M19, M18, M11);
        M13.AddNewNeighbour(M7, M8, M14, M20, M19, M12);
        M14.AddNewNeighbour(M8, M9, M15, M21, M20, M13);
        M15.AddNewNeighbour(M9, M22, M21, M14);
        M16.AddNewNeighbour(M10, M17, M23);
        M17.AddNewNeighbour(M10, M11, M18, M24, M23, M16);
        M18.AddNewNeighbour(M11, M12, M19, M25, M24, M17);
        M19.AddNewNeighbour(M12, M13, M20, M26, M25, M18);
        M20.AddNewNeighbour(M13, M14, M21, M27, M26, M19);
        M21.AddNewNeighbour(M14, M15, M22, M28, M27, M20);
        M22.AddNewNeighbour(M15, M28, M21);
        M23.AddNewNeighbour(M16, M17, M24, M29);
        M24.AddNewNeighbour(M17, M18, M25, M30, M29, M23);
        M25.AddNewNeighbour(M18, M19, M26, M31, M30, M24);
        M26.AddNewNeighbour(M19, M20, M27, M32, M32, M25);
        M27.AddNewNeighbour(M20, M21, M28, M33, M32, M26);
        M28.AddNewNeighbour(M21, M22, M33, M27);
        M29.AddNewNeighbour(M23, M24, M30, M34);
        M30.AddNewNeighbour(M24, M25, M31, M35, M34, M29);
        M31.AddNewNeighbour(M25, M26, M32, M36, M35, M30);
        M32.AddNewNeighbour(M26, M27, M33, M37, M36, M31);
        M33.AddNewNeighbour(M27, M28, M37, M32);
        M34.AddNewNeighbour(M29, M30, M35);
        M35.AddNewNeighbour(M34, M30, M31, M36);
        M36.AddNewNeighbour(M35, M31, M32, M37);
        M37.AddNewNeighbour(M36, M32, M33);

        Field J1 = new Field(1, "Yellow", true, "J1");
        Field J2 = new Field(1, "Yellow", true, "J2");
        Field J3 = new Field(1, "Yellow", true, "J3");
        Field J4 = new Field(1, "Yellow", true, "J4");
        Field J5 = new Field(1, "Yellow", true, "J5");
        Field J6 = new Field(2, "Yellow", true, "J6");
        Field J7 = new Field(2, "Yellow", true, "J7");
        Field J8 = new Field(1, "Yellow", true, "J8");
        Field J9 = new Field(1, "Blue", true, "J9");
        Field J10 = new Field(1, "Yellow", true, "J10");
        Field J11 = new Field(2, "Yellow", true, "J11");
        Field J12 = new Field(1, "Green", true, "J12");
        Field J13 = new Field(2, "Green", true, "J13");
        Field J14 = new Field(2, "Blue", true, "J14");
        Field J15 = new Field(1, "Blue", true, "J15");
        Field J16 = new Field(2, "White", true, "J16");
        Field J17 = new Field(0, "Cave", false, "J17");
        Field J18 = new Field(1, "Green", true, "J18");
        Field J19 = new Field(1, "Camp", true, "J19");
        Field J20 = new Field(1, "Green", true, "J20");
        Field J21 = new Field(0, "Cave", false, "J21");
        Field J22 = new Field(1, "Blue", true, "J22");
        Field J23 = new Field(1, "White", true, "J23");
        Field J24 = new Field(2, "White", true, "J24");
        Field J25 = new Field(1, "Green", true, "J25");
        Field J26 = new Field(2, "Green", true, "J26");
        Field J27 = new Field(2, "Blue", true, "J27");
        Field J28 = new Field(1, "Blue", true, "J28");
        Field J29 = new Field(1, "White", true, "J29");
        Field J30 = new Field(2, "White", true, "J30");
        Field J31 = new Field(2, "White", true, "J31");
        Field J32 = new Field(1, "Blue", true, "J32");
        Field J33 = new Field(1, "Blue", true, "J33");
        Field J34 = new Field(1, "White", true, "J34");
        Field J35 = new Field(1, "White", true, "J35");
        Field J36 = new Field(2, "White", true, "J36");
        Field J37 = new Field(1, "Blue", true, "J37");
        J1.AddNewNeighbour(J2, J5, J6);
        J2.AddNewNeighbour(J1, J6, J7, J3);
        J3.AddNewNeighbour(J2, J7, J8, J4);
        J4.AddNewNeighbour(J3, J8, J9);
        J5.AddNewNeighbour(J1, J6, J10, J11);
        J6.AddNewNeighbour(J1, J2, J7, J12, J11, J5);
        J7.AddNewNeighbour(J2, J3, J8, J13, J12, J6);
        J8.AddNewNeighbour(J3, J4, J9, J14, J13, J7);
        J9.AddNewNeighbour(J4, J15, J14, J8);
        J10.AddNewNeighbour(J5, J11, J17, J16);
        J11.AddNewNeighbour(J5, J6, J12, J18, J17, J10);
        J12.AddNewNeighbour(J6, J7, J13, J19, J18, J11);
        J13.AddNewNeighbour(J7, J8, J14, J20, J19, J12);
        J14.AddNewNeighbour(J8, J9, J15, J21, J20, J13);
        J15.AddNewNeighbour(J9, J22, J21, J14);
        J16.AddNewNeighbour(J10, J17, J23);
        J17.AddNewNeighbour(J10, J11, J18, J24, J23, J16);
        J18.AddNewNeighbour(J11, J12, J19, J25, J24, J17);
        J19.AddNewNeighbour(J12, J13, J20, J26, J25, J18);
        J20.AddNewNeighbour(J13, J14, J21, J27, J26, J19);
        J21.AddNewNeighbour(J14, J15, J22, J28, J27, J20);
        J22.AddNewNeighbour(J15, J28, J21);
        J23.AddNewNeighbour(J16, J17, J24, J29);
        J24.AddNewNeighbour(J17, J18, J25, J30, J29, J23);
        J25.AddNewNeighbour(J18, J19, J26, J31, J30, J24);
        J26.AddNewNeighbour(J19, J20, J27, J32, J32, J25);
        J27.AddNewNeighbour(J20, J21, J28, J33, J32, J26);
        J28.AddNewNeighbour(J21, J22, J33, J27);
        J29.AddNewNeighbour(J23, J24, J30, J34);
        J30.AddNewNeighbour(J24, J25, J31, J35, J34, J29);
        J31.AddNewNeighbour(J25, J26, J32, J36, J35, J30);
        J32.AddNewNeighbour(J26, J27, J33, J37, J36, J31);
        J33.AddNewNeighbour(J27, J28, J37, J32);
        J34.AddNewNeighbour(J29, J30, J35);
        J35.AddNewNeighbour(J34, J30, J31, J36);
        J36.AddNewNeighbour(J35, J31, J32, J37);
        J37.AddNewNeighbour(J36, J32, J33);

        Random rand = new Random();
        int numberOfElements = 5;

        List<Blockade> blockadeList = new ArrayList<>(Blockades);

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(blockadeList.size());
            Blockade randomElement = blockadeList.get(randomIndex);
            blockadeList.remove(randomIndex);
            currentBlockades.add(randomElement);
        }

        currentBlockades.get(0).setName("BK1");
        currentBlockades.get(1).setName("BK2");
        currentBlockades.get(2).setName("BK3");
        currentBlockades.get(3).setName("BK4");
        currentBlockades.get(4).setName("BK5");

        removalList = new ArrayList<>(currentBlockades);

        Blockade HomeStretchfirst = currentBlockades.get(0);
        Blockade HomeStretchsecond = currentBlockades.get(1);
        Blockade HomeStretchthird = currentBlockades.get(2);
        Blockade HomeStretchfourth = currentBlockades.get(3);
        Blockade HomeStretchfifth = currentBlockades.get(4);



        Field B37HomeStretch = B37;
        B37HomeStretch.AddNewNeighbour(HomeStretchfirst);
        Field B33HomeStretch = B33;
        B33HomeStretch.AddNewNeighbour(HomeStretchfirst);
        Field B28HomeStretch = B28;
        B28HomeStretch.AddNewNeighbour(HomeStretchfirst);
        Field B22HomeStretch = B22;
        B22HomeStretch.AddNewNeighbour(HomeStretchfirst);
        HomeStretchfirst.addNeighbour(B37HomeStretch);
        HomeStretchfirst.addNeighbour(B33HomeStretch);
        HomeStretchfirst.addNeighbour(B28HomeStretch);
        HomeStretchfirst.addNeighbour(B22HomeStretch);
        HomeStretchfirst.addNeighbour(J1);
        HomeStretchfirst.addNeighbour(J2);
        HomeStretchfirst.addNeighbour(J3);
        HomeStretchfirst.addNeighbour(J4);

        Field J16HomeStretch = J16;
        J16HomeStretch.AddNewNeighbour(HomeStretchsecond);
        Field J23HomeStretch = J23;
        J23HomeStretch.AddNewNeighbour(HomeStretchsecond);
        Field J29HomeStretch = J29;
        J29HomeStretch.AddNewNeighbour(HomeStretchsecond);
        Field J34HomeStretch = J34;
        J34HomeStretch.AddNewNeighbour(HomeStretchsecond);
        HomeStretchsecond.addNeighbour(J16HomeStretch);
        HomeStretchsecond.addNeighbour(J23HomeStretch);
        HomeStretchsecond.addNeighbour(J29HomeStretch);
        HomeStretchsecond.addNeighbour(J34HomeStretch);
        HomeStretchsecond.addNeighbour(Q1);
        HomeStretchsecond.addNeighbour(Q2);
        HomeStretchsecond.addNeighbour(Q3);
        HomeStretchsecond.addNeighbour(Q4);
        HomeStretchsecond.addNeighbour(Q5);


        Field Q12HomeStretch = Q12;
        Q12HomeStretch.AddNewNeighbour(HomeStretchthird);
        Field Q13HomeStretch = Q13;
        Q13HomeStretch.AddNewNeighbour(HomeStretchthird);
        Field Q14HomeStretch = Q14;
        Q14HomeStretch.AddNewNeighbour(HomeStretchthird);
        Field Q15HomeStretch = Q15;
        Q15HomeStretch.AddNewNeighbour(HomeStretchthird);
        Field Q16HomeStretch = Q16;
        Q16HomeStretch.AddNewNeighbour(HomeStretchthird);
        HomeStretchthird.addNeighbour(Q12HomeStretch);
        HomeStretchthird.addNeighbour(Q13HomeStretch);
        HomeStretchthird.addNeighbour(Q14HomeStretch);
        HomeStretchthird.addNeighbour(Q15HomeStretch);
        HomeStretchthird.addNeighbour(Q16HomeStretch);
        HomeStretchthird.addNeighbour(K1);
        HomeStretchthird.addNeighbour(K2);
        HomeStretchthird.addNeighbour(K3);
        HomeStretchthird.addNeighbour(K4);

        Field K34HomeStretch = K34;
        K34HomeStretch.AddNewNeighbour(HomeStretchfourth);
        Field K35HomeStretch = K35;
        K35HomeStretch.AddNewNeighbour(HomeStretchfourth);
        Field K36HomeStretch = K36;
        K36HomeStretch.AddNewNeighbour(HomeStretchfourth);
        Field K37HomeStretch = K37;
        K37HomeStretch.AddNewNeighbour(HomeStretchfourth);
        HomeStretchfourth.addNeighbour(K34HomeStretch);
        HomeStretchfourth.addNeighbour(K35HomeStretch);
        HomeStretchfourth.addNeighbour(K36HomeStretch);
        HomeStretchfourth.addNeighbour(K37HomeStretch);
        HomeStretchfourth.addNeighbour(M1);
        HomeStretchfourth.addNeighbour(M2);
        HomeStretchfourth.addNeighbour(M3);
        HomeStretchfourth.addNeighbour(M4);

        Field M34HomeStretch = M34;
        M34HomeStretch.AddNewNeighbour(HomeStretchfifth);
        Field M35HomeStretch = M35;
        M35HomeStretch.AddNewNeighbour(HomeStretchfifth);
        Field M36HomeStretch = M36;
        M36HomeStretch.AddNewNeighbour(HomeStretchfifth);
        Field M37HomeStretch = M37;
        M37HomeStretch.AddNewNeighbour(HomeStretchfifth);
        HomeStretchfifth.addNeighbour(M34HomeStretch);
        HomeStretchfifth.addNeighbour(M35HomeStretch);
        HomeStretchfifth.addNeighbour(M36HomeStretch);
        HomeStretchfifth.addNeighbour(M37HomeStretch);
        HomeStretchfifth.addNeighbour(C16);
        HomeStretchfifth.addNeighbour(C10);
        HomeStretchfifth.addNeighbour(C5);
        HomeStretchfifth.addNeighbour(C1);

        Field EDGreen1 = new Field(1, "Green", true, "EDGreen1");
        Field EDGreen2 = new Field(1, "Green", true, "EDGreen2");
        Field EDGreen3 = new Field(1, "Green", true, "EDGreen3");

        Field C9HomeStretch = C9;
        C9HomeStretch.AddNewNeighbour(EDGreen1);
        Field C4HomeStretch = C4;
        C4HomeStretch.AddNewNeighbour(EDGreen1, EDGreen2, EDGreen3);
        Field C3HomeStretch = C3;
        C3HomeStretch.AddNewNeighbour(EDGreen3);




            HomeStretchFields.add(B1);
            HomeStretchFields.add(B2);
            HomeStretchFields.add(B3);
            HomeStretchFields.add(B4);
            HomeStretchFields.add(B5);
            HomeStretchFields.add(B6);
            HomeStretchFields.add(B7);
            HomeStretchFields.add(B8);
            HomeStretchFields.add(B9);
            HomeStretchFields.add(B10);
            HomeStretchFields.add(B11);
            HomeStretchFields.add(B12);
            HomeStretchFields.add(B13);
            HomeStretchFields.add(B14);
            HomeStretchFields.add(B15);
            HomeStretchFields.add(B16);
            HomeStretchFields.add(B17);
            HomeStretchFields.add(B18);
            HomeStretchFields.add(B19);
            HomeStretchFields.add(B20);
            HomeStretchFields.add(B21);
            HomeStretchFields.add(B22HomeStretch);
            HomeStretchFields.add(B23);
            HomeStretchFields.add(B24);
            HomeStretchFields.add(B25);
            HomeStretchFields.add(B26);
            HomeStretchFields.add(B27);
            HomeStretchFields.add(B28HomeStretch);
            HomeStretchFields.add(B29);
            HomeStretchFields.add(B30);
            HomeStretchFields.add(B31);
            HomeStretchFields.add(B32);
            HomeStretchFields.add(B33HomeStretch);
            HomeStretchFields.add(B34);
            HomeStretchFields.add(B35);
            HomeStretchFields.add(B36);
            HomeStretchFields.add(B37HomeStretch);
            HomeStretchFields.add(J1);
            HomeStretchFields.add(J2);
            HomeStretchFields.add(J3);
            HomeStretchFields.add(J4);
            HomeStretchFields.add(J5);
            HomeStretchFields.add(J6);
            HomeStretchFields.add(J7);
            HomeStretchFields.add(J8);
            HomeStretchFields.add(J9);
            HomeStretchFields.add(J10);
            HomeStretchFields.add(J11);
            HomeStretchFields.add(J12);
            HomeStretchFields.add(J13);
            HomeStretchFields.add(J14);
            HomeStretchFields.add(J15);
            HomeStretchFields.add(J16HomeStretch);
            HomeStretchFields.add(J17);
            HomeStretchFields.add(J18);
            HomeStretchFields.add(J19);
            HomeStretchFields.add(J20);
            HomeStretchFields.add(J21);
            HomeStretchFields.add(J22);
            HomeStretchFields.add(J23HomeStretch);
            HomeStretchFields.add(J24);
            HomeStretchFields.add(J25);
            HomeStretchFields.add(J26);
            HomeStretchFields.add(J27);
            HomeStretchFields.add(J28);
            HomeStretchFields.add(J29HomeStretch);
            HomeStretchFields.add(J30);
            HomeStretchFields.add(J31);
            HomeStretchFields.add(J32);
            HomeStretchFields.add(J33);
            HomeStretchFields.add(J34HomeStretch);
            HomeStretchFields.add(J35);
            HomeStretchFields.add(J36);
            HomeStretchFields.add(J37);
            HomeStretchFields.add(Q1);
            HomeStretchFields.add(Q2);
            HomeStretchFields.add(Q3);
            HomeStretchFields.add(Q4);
            HomeStretchFields.add(Q5);
            HomeStretchFields.add(Q6);
            HomeStretchFields.add(Q7);
            HomeStretchFields.add(Q8);
            HomeStretchFields.add(Q9);
            HomeStretchFields.add(Q10);
            HomeStretchFields.add(Q11);
            HomeStretchFields.add(Q12HomeStretch);
            HomeStretchFields.add(Q13HomeStretch);
            HomeStretchFields.add(Q14HomeStretch);
            HomeStretchFields.add(Q15HomeStretch);
            HomeStretchFields.add(Q16HomeStretch);
            HomeStretchFields.add(K1);
            HomeStretchFields.add(K2);
            HomeStretchFields.add(K3);
            HomeStretchFields.add(K4);
            HomeStretchFields.add(K5);
            HomeStretchFields.add(K6);
            HomeStretchFields.add(K7);
            HomeStretchFields.add(K8);
            HomeStretchFields.add(K9);
            HomeStretchFields.add(K10);
            HomeStretchFields.add(K11);
            HomeStretchFields.add(K12);
            HomeStretchFields.add(K13);
            HomeStretchFields.add(K14);
            HomeStretchFields.add(K15);
            HomeStretchFields.add(K16);
            HomeStretchFields.add(K17);
            HomeStretchFields.add(K18);
            HomeStretchFields.add(K19);
            HomeStretchFields.add(K20);
            HomeStretchFields.add(K21);
            HomeStretchFields.add(K22);
            HomeStretchFields.add(K23);
            HomeStretchFields.add(K24);
            HomeStretchFields.add(K25);
            HomeStretchFields.add(K26);
            HomeStretchFields.add(K27);
            HomeStretchFields.add(K28);
            HomeStretchFields.add(K29);
            HomeStretchFields.add(K30);
            HomeStretchFields.add(K31);
            HomeStretchFields.add(K32);
            HomeStretchFields.add(K33);
            HomeStretchFields.add(K34HomeStretch);
            HomeStretchFields.add(K35HomeStretch);
            HomeStretchFields.add(K36HomeStretch);
            HomeStretchFields.add(K37HomeStretch);
            HomeStretchFields.add(M1);
            HomeStretchFields.add(M2);
            HomeStretchFields.add(M3);
            HomeStretchFields.add(M4);
            HomeStretchFields.add(M5);
            HomeStretchFields.add(M6);
            HomeStretchFields.add(M7);
            HomeStretchFields.add(M8);
            HomeStretchFields.add(M9);
            HomeStretchFields.add(M10);
            HomeStretchFields.add(M11);
            HomeStretchFields.add(M12);
            HomeStretchFields.add(M13);
            HomeStretchFields.add(M14);
            HomeStretchFields.add(M15);
            HomeStretchFields.add(M16);
            HomeStretchFields.add(M17);
            HomeStretchFields.add(M18);
            HomeStretchFields.add(M19);
            HomeStretchFields.add(M20);
            HomeStretchFields.add(M21);
            HomeStretchFields.add(M22);
            HomeStretchFields.add(M23);
            HomeStretchFields.add(M24);
            HomeStretchFields.add(M25);
            HomeStretchFields.add(M26);
            HomeStretchFields.add(M27);
            HomeStretchFields.add(M28);
            HomeStretchFields.add(M29);
            HomeStretchFields.add(M30);
            HomeStretchFields.add(M31);
            HomeStretchFields.add(M32);
            HomeStretchFields.add(M33);
            HomeStretchFields.add(M34HomeStretch);
            HomeStretchFields.add(M35HomeStretch);
            HomeStretchFields.add(M36HomeStretch);
            HomeStretchFields.add(M37HomeStretch);
            HomeStretchFields.add(C1);
            HomeStretchFields.add(C2);
            HomeStretchFields.add(C3HomeStretch);
            HomeStretchFields.add(C4HomeStretch);
            HomeStretchFields.add(C5);
            HomeStretchFields.add(C6);
            HomeStretchFields.add(C7);
            HomeStretchFields.add(C8);
            HomeStretchFields.add(C9HomeStretch);
            HomeStretchFields.add(C10);
            HomeStretchFields.add(C11);
            HomeStretchFields.add(C12);
            HomeStretchFields.add(C13);
            HomeStretchFields.add(C14);
            HomeStretchFields.add(C15);
            HomeStretchFields.add(C16);
            HomeStretchFields.add(C17);
            HomeStretchFields.add(C18);
            HomeStretchFields.add(C19);
            HomeStretchFields.add(C20);
            HomeStretchFields.add(C21);
            HomeStretchFields.add(C22);
            HomeStretchFields.add(C23);
            HomeStretchFields.add(C24);
            HomeStretchFields.add(C25);
            HomeStretchFields.add(C26);
            HomeStretchFields.add(C27);
            HomeStretchFields.add(C28);
            HomeStretchFields.add(C29);
            HomeStretchFields.add(C30);
            HomeStretchFields.add(C31);
            HomeStretchFields.add(C32);
            HomeStretchFields.add(C33);
            HomeStretchFields.add(C34);
            HomeStretchFields.add(C35);
            HomeStretchFields.add(C36);
            HomeStretchFields.add(C37);
            HomeStretchFields.add(EDGreen1);
            HomeStretchFields.add(EDGreen2);
            HomeStretchFields.add(EDGreen3);

        }


    public void setupWindingPath() {


        Field F1 = new Field(1, "Blue", true, "F1");
        Field F2 = new Field(1, "Blue", true, "F2");
        Field F3 = new Field(1, "White", true, "F3");
        Field F4 = new Field(1, "White", true, "F4");
        Field F5 = new Field(0, "Cave", false, "F5");
        Field F6 = new Field(1, "Blue", true, "F6");
        Field F7 = new Field(1, "Blue", true, "F7");
        Field F8 = new Field(1, "Green", true, "F8");
        Field F9 = new Field(1, "White", true, "F9");
        Field F10 = new Field(0, "Cave", false, "F10");
        Field F11 = new Field(0, "Cave", false, "F11");
        Field F12 = new Field(3, "Blue", true, "F12");
        Field F13 = new Field(2, "Green", true, "F13");
        Field F14 = new Field(1, "Green", true, "F14");
        Field F15 = new Field(2, "Blue", true, "F15");
        Field F16 = new Field(1, "Green", true, "F16");
        Field F17 = new Field(1, "Green", true, "F17");
        Field F18 = new Field(2, "Blue", true, "F18");
        Field F19 = new Field(0, "Cave", false, "F19");
        Field F20 = new Field(1, "Green", true, "F20");
        Field F21 = new Field(2, "Blue", true, "F21");
        Field F22 = new Field(2, "Camp", true, "F22");
        Field F23 = new Field(2, "Green", true, "F23");
        Field F24 = new Field(1, "Green", true, "F24");
        Field F25 = new Field(2, "Yellow", true, "F25");
        Field F26 = new Field(2, "White", true, "F26");
        Field F27 = new Field(1, "Green", true, "F27");
        Field F28 = new Field(1, "White", true, "F28");
        Field F29 = new Field(1, "White", true, "F29");
        Field F30 = new Field(1, "Yellow", true, "F30");
        Field F31 = new Field(1, "Yellow", true, "F31");
        Field F32 = new Field(3, "Green", true, "F32");
        Field F33 = new Field(2, "Green", true, "F33");
        Field F34 = new Field(1, "White", true, "F34");
        Field F35 = new Field(1, "White", true, "F35");
        Field F36 = new Field(1, "Green", true, "F36");
        Field F37 = new Field(1, "Camp", true, "F37");
        F1.AddNewNeighbour(F2, F5, F6);
        F2.AddNewNeighbour(F1, F6, F7, F3);
        F3.AddNewNeighbour(F2, F7, F8, F4);
        F4.AddNewNeighbour(F3, F8, F9);
        F5.AddNewNeighbour(F1, F6, F10, F11);
        F6.AddNewNeighbour(F1, F2, F7, F12, F11, F5);
        F7.AddNewNeighbour(F2, F3, F8, F13, F12, F6);
        F8.AddNewNeighbour(F3, F4, F9, F14, F13, F7);
        F9.AddNewNeighbour(F4, F15, F14, F8);
        F10.AddNewNeighbour(F5, F11, F17, F16);
        F11.AddNewNeighbour(F5, F6, F12, F18, F17, F10);
        F12.AddNewNeighbour(F6, F7, F13, F19, F18, F11);
        F13.AddNewNeighbour(F7, F8, F14, F20, F19, F12);
        F14.AddNewNeighbour(F8, F9, F15, F21, F20, F13);
        F15.AddNewNeighbour(F9, F22, F21, F14);
        F16.AddNewNeighbour(F10, F17, F23);
        F17.AddNewNeighbour(F10, F11, F18, F24, F23, F16);
        F18.AddNewNeighbour(F11, F12, F19, F25, F24, F17);
        F19.AddNewNeighbour(F12, F13, F20, F26, F25, F18);
        F20.AddNewNeighbour(F13, F14, F21, F27, F26, F19);
        F21.AddNewNeighbour(F14, F15, F22, F28, F27, F20);
        F22.AddNewNeighbour(F15, F28, F21);
        F23.AddNewNeighbour(F16, F17, F24, F29);
        F24.AddNewNeighbour(F17, F18, F25, F30, F29, F23);
        F25.AddNewNeighbour(F18, F19, F26, F31, F30, F24);
        F26.AddNewNeighbour(F19, F20, F27, F32, F32, F25);
        F27.AddNewNeighbour(F20, F21, F28, F33, F32, F26);
        F28.AddNewNeighbour(F21, F22, F33, F27);
        F29.AddNewNeighbour(F23, F24, F30, F34);
        F30.AddNewNeighbour(F24, F25, F31, F35, F34, F29);
        F31.AddNewNeighbour(F25, F26, F32, F36, F35, F30);
        F32.AddNewNeighbour(F26, F27, F33, F37, F36, F31);
        F33.AddNewNeighbour(F27, F28, F37, F32);
        F34.AddNewNeighbour(F29, F30, F35);
        F35.AddNewNeighbour(F34, F30, F31, F36);
        F36.AddNewNeighbour(F35, F31, F32, F37);
        F37.AddNewNeighbour(F36, F32, F33);

        Random rand = new Random();
        int numberOfElements = 5;

        List<Blockade> blockadeList = new ArrayList<>(Blockades);

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(blockadeList.size());
            Blockade randomElement = blockadeList.get(randomIndex);
            blockadeList.remove(randomIndex);
            currentBlockades.add(randomElement);

        }

        currentBlockades.get(0).setName("BK1");
        currentBlockades.get(1).setName("BK2");
        currentBlockades.get(2).setName("BK3");
        currentBlockades.get(3).setName("BK4");
        currentBlockades.get(4).setName("BK5");

        Blockade WindingPathsfirst = currentBlockades.get(0);
        Blockade WindingPathssecond = currentBlockades.get(1);
        Blockade WindingPathsthird = currentBlockades.get(2);
        Blockade WindingPathsfourth = currentBlockades.get(3);
        Blockade WindingPathsfifth = currentBlockades.get(4);

        removalList = new ArrayList<>(currentBlockades);

        Field G1 = new Field(1, "Green", true, "G1");
        Field G2 = new Field(1, "Green", true, "G2");
        Field G3 = new Field(1, "Green", true, "G3");
        Field G4 = new Field(1, "Green", true, "G4");
        Field G5 = new Field(1, "Green", true, "G5");
        Field G6 = new Field(2, "Green", true, "G6");
        Field G7 = new Field(1, "Yellow", true, "G7");
        Field G8 = new Field(0, "Cave", false, "G8");
        Field G9 = new Field(1, "Green", true, "G9");
        Field G10 = new Field(1, "Yellow", true, "G10");
        Field G11 = new Field(2, "Yellow", true, "G11");
        Field G12 = new Field(2, "Yellow", true, "G12");
        Field G13 = new Field(1, "White", true, "G13");
        Field G14 = new Field(1, "Yellow", true, "G14");
        Field G15 = new Field(1, "Green", true, "G15");
        Field G16 = new Field(0, "Cave", false, "G16");
        Field G17 = new Field(0, "Cave", false, "G17");
        Field G18 = new Field(4, "Yellow", true, "G18");
        Field G19 = new Field(3, "Yellow", true, "G19");
        Field G20 = new Field(2, "Yellow", true, "G20");
        Field G21 = new Field(2, "Green", true, "G21");
        Field G22 = new Field(1, "Camp", true, "G22");
        Field G23 = new Field(1, "Yellow", true, "G23");
        Field G24 = new Field(2, "Yellow", true, "G24");
        Field G25 = new Field(2, "Yellow", true, "G25");
        Field G26 = new Field(1, "White", true, "G26");
        Field G27 = new Field(1, "Yellow", true, "G27");
        Field G28 = new Field(1, "Green", true, "G28");
        Field G29 = new Field(1, "Green", true, "G29");
        Field G30 = new Field(2, "Green", true, "G30");
        Field G31 = new Field(1, "Yellow", true, "G31");
        Field G32 = new Field(0, "Cave", false, "G32");
        Field G33 = new Field(1, "Green", true, "G33");
        Field G34 = new Field(1, "Green", true, "G34");
        Field G35 = new Field(1, "Green", true, "G35");
        Field G36 = new Field(1, "Green", true, "G36");
        Field G37 = new Field(1, "Green", true, "G37");
        G1.AddNewNeighbour(G2, G5, G6);
        G2.AddNewNeighbour(G1, G6, G7, G3);
        G3.AddNewNeighbour(G2, G7, G8, G4);
        G4.AddNewNeighbour(G3, G8, G9);
        G5.AddNewNeighbour(G1, G6, G10, G11);
        G6.AddNewNeighbour(G1, G2, G7, G12, G11, G5);
        G7.AddNewNeighbour(G2, G3, G8, G13, G12, G6);
        G8.AddNewNeighbour(G3, G4, G9, G14, G13, G7);
        G9.AddNewNeighbour(G4, G15, G14, G8);
        G10.AddNewNeighbour(G5, G11, G17, G16);
        G11.AddNewNeighbour(G5, G6, G12, G18, G17, G10);
        G12.AddNewNeighbour(G6, G7, G13, G19, G18, G11);
        G13.AddNewNeighbour(G7, G8, G14, G20, G19, G12);
        G14.AddNewNeighbour(G8, G9, G15, G21, G20, G13);
        G15.AddNewNeighbour(G9, G22, G21, G14);
        G16.AddNewNeighbour(G10, G17, G23);
        G17.AddNewNeighbour(G10, G11, G18, G24, G23, G16);
        G18.AddNewNeighbour(G11, G12, G19, G25, G24, G17);
        G19.AddNewNeighbour(G12, G13, G20, G26, G25, G18);
        G20.AddNewNeighbour(G13, G14, G21, G27, G26, G19);
        G21.AddNewNeighbour(G14, G15, G22, G28, G27, G20);
        G22.AddNewNeighbour(G15, G28, G21);
        G23.AddNewNeighbour(G16, G17, G24, G29);
        G24.AddNewNeighbour(G17, G18, G25, G30, G29, G23);
        G25.AddNewNeighbour(G18, G19, G26, G31, G30, G24);
        G26.AddNewNeighbour(G19, G20, G27, G32, G32, G25);
        G27.AddNewNeighbour(G20, G21, G28, G33, G32, G26);
        G28.AddNewNeighbour(G21, G22, G33, G27);
        G29.AddNewNeighbour(G23, G24, G30, G34);
        G30.AddNewNeighbour(G24, G25, G31, G35, G34, G29);
        G31.AddNewNeighbour(G25, G26, G32, G36, G35, G30);
        G32.AddNewNeighbour(G26, G27, G33, G37, G36, G31);
        G33.AddNewNeighbour(G27, G28, G37, G32);
        G34.AddNewNeighbour(G29, G30, G35);
        G35.AddNewNeighbour(G34, G30, G31, G36);
        G36.AddNewNeighbour(G35, G31, G32, G37);
        G37.AddNewNeighbour(G36, G32, G33);

        Field N1 = new Field(1, "Green", true, "N1");
        Field N2 = new Field(1, "Green", true, "N2");
        Field N3 = new Field(1, "Green", true, "N3");
        Field N4 = new Field(1, "Green", true, "N4");
        Field N5 = new Field(1, "Green", true, "N5");
        Field N6 = new Field(1, "Green", true, "N6");
        Field N7 = new Field(2, "Green", true, "N7");
        Field N8 = new Field(1, "Green", true, "N8");
        Field N9 = new Field(1, "Green", true, "N9");
        Field N10 = new Field(1, "Yellow", true, "N10");
        Field N11 = new Field(2, "Yellow", true, "N11");
        Field N12 = new Field(1, "Green", true, "N12");
        Field N13 = new Field(1, "Blue", true, "N13");
        Field N14 = new Field(1, "Blue", true, "N14");
        Field N15 = new Field(1, "Blue", true, "N15");
        Field N16 = new Field(1, "Yellow", true, "N16");
        Field N17 = new Field(2, "Yellow", true, "N17");
        Field N18 = new Field(3, "Yellow", true, "N18");
        Field N19 = new Field(4, "Yellow", true, "N19");
        Field N20 = new Field(3, "Yellow", true, "N20");
        Field N21 = new Field(1, "Blue", true, "N21");
        Field N22 = new Field(1, "Blue", true, "N22");
        Field N23 = new Field(1, "Blue", true, "N23");
        Field N24 = new Field(1, "Blue", true, "N24");
        Field N25 = new Field(1, "Blue", true, "N25");
        Field N26 = new Field(1, "Green", true, "N26");
        Field N27 = new Field(2, "Yellow", true, "N27");
        Field N28 = new Field(1, "Yellow", true, "N28");
        Field N29 = new Field(1, "Blue", true, "N29");
        Field N30 = new Field(1, "Green", true, "N30");
        Field N31 = new Field(2, "Green", true, "N31");
        Field N32 = new Field(1, "Green", true, "N32");
        Field N33 = new Field(1, "Yellow", true, "N33");
        Field N34 = new Field(1, "Green", true, "N34");
        Field N35 = new Field(1, "Green", true, "N35");
        Field N36 = new Field(1, "Green", true, "N36");
        Field N37 = new Field(1, "Green", true, "N37");
        N1.AddNewNeighbour(N2, N5, N6);
        N2.AddNewNeighbour(N1, N6, N7, N3);
        N3.AddNewNeighbour(N2, N7, N8, N4);
        N4.AddNewNeighbour(N3, N8, N9);
        N5.AddNewNeighbour(N1, N6, N10, N11);
        N6.AddNewNeighbour(N1, N2, N7, N12, N11, N5);
        N7.AddNewNeighbour(N2, N3, N8, N13, N12, N6);
        N8.AddNewNeighbour(N3, N4, N9, N14, N13, N7);
        N9.AddNewNeighbour(N4, N15, N14, N8);
        N10.AddNewNeighbour(N5, N11, N17, N16);
        N11.AddNewNeighbour(N5, N6, N12, N18, N17, N10);
        N12.AddNewNeighbour(N6, N7, N13, N19, N18, N11);
        N13.AddNewNeighbour(N7, N8, N14, N20, N19, N12);
        N14.AddNewNeighbour(N8, N9, N15, N21, N20, N13);
        N15.AddNewNeighbour(N9, N22, N21, N14);
        N16.AddNewNeighbour(N10, N17, N23);
        N17.AddNewNeighbour(N10, N11, N18, N24, N23, N16);
        N18.AddNewNeighbour(N11, N12, N19, N25, N24, N17);
        N19.AddNewNeighbour(N12, N13, N20, N26, N25, N18);
        N20.AddNewNeighbour(N13, N14, N21, N27, N26, N19);
        N21.AddNewNeighbour(N14, N15, N22, N28, N27, N20);
        N22.AddNewNeighbour(N15, N28, N21);
        N23.AddNewNeighbour(N16, N17, N24, N29);
        N24.AddNewNeighbour(N17, N18, N25, N30, N29, N23);
        N25.AddNewNeighbour(N18, N19, N26, N31, N30, N24);
        N26.AddNewNeighbour(N19, N20, N27, N32, N32, N25);
        N27.AddNewNeighbour(N20, N21, N28, N33, N32, N26);
        N28.AddNewNeighbour(N21, N22, N33, N27);
        N29.AddNewNeighbour(N23, N24, N30, N34);
        N30.AddNewNeighbour(N24, N25, N31, N35, N34, N29);
        N31.AddNewNeighbour(N25, N26, N32, N36, N35, N30);
        N32.AddNewNeighbour(N26, N27, N33, N37, N36, N31);
        N33.AddNewNeighbour(N27, N28, N37, N32);
        N34.AddNewNeighbour(N29, N30, N35);
        N35.AddNewNeighbour(N34, N30, N31, N36);
        N36.AddNewNeighbour(N35, N31, N32, N37);
        N37.AddNewNeighbour(N36, N32, N33);


        Field B1 = new Field(0, "Green", true, "B1");
        Field B2 = new Field(0, "Green", true, "B2");
        Field B3 = new Field(0, "Green", true, "B3");
        Field B4 = new Field(0, "Green", true, "B4");
        Field B5 = new Field(1, "Green", true, "B5");
        Field B6 = new Field(1, "Green", true, "B6");
        Field B7 = new Field(1, "Green", true, "B7");
        Field B8 = new Field(1, "Green", true, "B8");
        Field B9 = new Field(1, "Green", true, "B9");
        Field B10 = new Field(1, "Green", true, "B10");
        Field B11 = new Field(1, "Green", true, "B11");
        Field B12 = new Field(1, "Green", true, "B12");
        Field B13 = new Field(1, "Blue", true, "B13");
        Field B14 = new Field(1, "Green", true, "B14");
        Field B15 = new Field(1, "Green", true, "B15");
        Field B16 = new Field(1, "Green", true, "B16");
        Field B17 = new Field(1, "Green", true, "B17");
        Field B18 = new Field(1, "Yellow", true, "B18");
        Field B19 = new Field(1, "Green", true, "B19");
        Field B20 = new Field(1, "Yellow", true, "B20");
        Field B21 = new Field(1, "Green", true, "B21");
        Field B22 = new Field(1, "Blue", true, "B22");
        Field B23 = new Field(1, "Green", true, "B23");
        Field B24 = new Field(1, "Green", true, "B24");
        Field B25 = new Field(1, "Green", true, "B25");
        Field B26 = new Field(1, "Green", true, "B26");
        Field B27 = new Field(1, "Yellow", true, "B27");
        Field B28 = new Field(1, "Green", true, "B28");
        Field B29 = new Field(1, "Green", true, "B29");
        Field B30 = new Field(0, "Cave", false, "B30");
        Field B31 = new Field(1, "Yellow", true, "B31");
        Field B32 = new Field(1, "Green", true, "B32");
        Field B33 = new Field(1, "Green", true, "B33");
        Field B34 = new Field(1, "Blue", true, "B34");
        Field B35 = new Field(1, "Camp", true, "B35");
        Field B36 = new Field(1, "Blue", true, "B36");
        Field B37 = new Field(1, "Green", true, "B37");
        B1.AddNewNeighbour(B2, B5, B6);
        B2.AddNewNeighbour(B1, B6, B7, B3);
        B3.AddNewNeighbour(B2, B7, B8, B4);
        B4.AddNewNeighbour(B3, B8, B9);
        B5.AddNewNeighbour(B1, B6, B10, B11);
        B6.AddNewNeighbour(B1, B2, B7, B12, B11, B5);
        B7.AddNewNeighbour(B2, B3, B8, B13, B12, B6);
        B8.AddNewNeighbour(B3, B4, B9, B14, B13, B7);
        B9.AddNewNeighbour(B4, B15, B14, B8);
        B10.AddNewNeighbour(B5, B11, B17, B16);
        B11.AddNewNeighbour(B5, B6, B12, B18, B17, B10);
        B12.AddNewNeighbour(B6, B7, B13, B19, B18, B11);
        B13.AddNewNeighbour(B7, B8, B14, B20, B19, B12);
        B14.AddNewNeighbour(B8, B9, B15, B21, B20, B13);
        B15.AddNewNeighbour(B9, B22, B21, B14);
        B16.AddNewNeighbour(B10, B17, B23);
        B17.AddNewNeighbour(B10, B11, B18, B24, B23, B16);
        B18.AddNewNeighbour(B11, B12, B19, B25, B24, B17);
        B19.AddNewNeighbour(B12, B13, B20, B26, B25, B18);
        B20.AddNewNeighbour(B13, B14, B21, B27, B26, B19);
        B21.AddNewNeighbour(B14, B15, B22, B28, B27, B20);
        B22.AddNewNeighbour(B15, B28, B21);
        B23.AddNewNeighbour(B16, B17, B24, B29);
        B24.AddNewNeighbour(B17, B18, B25, B30, B29, B23);
        B25.AddNewNeighbour(B18, B19, B26, B31, B30, B24);
        B26.AddNewNeighbour(B19, B20, B27, B32, B32, B25);
        B27.AddNewNeighbour(B20, B21, B28, B33, B32, B26);
        B28.AddNewNeighbour(B21, B22, B33, B27);
        B29.AddNewNeighbour(B23, B24, B30, B34);
        B30.AddNewNeighbour(B24, B25, B31, B35, B34, B29);
        B31.AddNewNeighbour(B25, B26, B32, B36, B35, B30);
        B32.AddNewNeighbour(B26, B27, B33, B37, B36, B31);
        B33.AddNewNeighbour(B27, B28, B37, B32);
        B34.AddNewNeighbour(B29, B30, B35);
        B35.AddNewNeighbour(B34, B30, B31, B36);
        B36.AddNewNeighbour(B35, B31, B32, B37);
        B37.AddNewNeighbour(B36, B32, B33);


        Field C1 = new Field(1, "Blue", true, "C1");
        Field C2 = new Field(1, "Blue", true, "C2");
        Field C3 = new Field(1, "Green", true, "C3");
        Field C4 = new Field(1, "Green", true, "C4");
        Field C5 = new Field(1, "Yellow", true, "C5");
        Field C6 = new Field(1, "Yellow", true, "C6");
        Field C7 = new Field(1, "Blue", true, "C7");
        Field C8 = new Field(1, "Yellow", true, "C8");
        Field C9 = new Field(1, "Green", true, "C9");
        Field C10 = new Field(1, "Yellow", true, "C10");
        Field C11 = new Field(1, "White", true, "C11");
        Field C12 = new Field(1, "White", true, "C12");
        Field C13 = new Field(1, "Yellow", true, "C13");
        Field C14 = new Field(1, "White", true, "C14");
        Field C15 = new Field(1, "White", true, "C15");
        Field C16 = new Field(1, "Green", true, "C16");
        Field C17 = new Field(1, "White", true, "C17");
        Field C18 = new Field(1, "Blue", true, "C18");
        Field C19 = new Field(0, "Cave", false, "C19");
        Field C20 = new Field(1, "Yellow", true, "C20");
        Field C21 = new Field(1, "Blue", true, "C21");
        Field C22 = new Field(1, "White", true, "C22");
        Field C23 = new Field(1, "Green", true, "C23");
        Field C24 = new Field(1, "Green", true, "C24");
        Field C25 = new Field(1, "Blue", true, "C25");
        Field C26 = new Field(1, "Blue", true, "C26");
        Field C27 = new Field(1, "White", true, "C27");
        Field C28 = new Field(1, "Blue", true, "C28");
        Field C29 = new Field(1, "Blue", true, "C29");
        Field C30 = new Field(1, "Yellow", true, "C30");
        Field C31 = new Field(1, "Yellow", true, "C31");
        Field C32 = new Field(1, "White", true, "C32");
        Field C33 = new Field(1, "Blue", true, "C33");
        Field C34 = new Field(1, "Blue", true, "C34");
        Field C35 = new Field(1, "Blue", true, "C35");
        Field C36 = new Field(1, "Yellow", true, "C36");
        Field C37 = new Field(1, "White", true, "C37");
        C1.AddNewNeighbour(C2, C5, C6);
        C2.AddNewNeighbour(C1, C6, C7, C3);
        C3.AddNewNeighbour(C2, C7, C8, C4);
        C4.AddNewNeighbour(C3, C8, C9);
        C5.AddNewNeighbour(C1, C6, C10, C11);
        C6.AddNewNeighbour(C1, C2, C7, C12, C11, C5);
        C7.AddNewNeighbour(C2, C3, C8, C13, C12, C6);
        C8.AddNewNeighbour(C3, C4, C9, C14, C13, C7);
        C9.AddNewNeighbour(C4, C15, C14, C8);
        C10.AddNewNeighbour(C5, C11, C17, C16);
        C11.AddNewNeighbour(C5, C6, C12, C18, C17, C10);
        C12.AddNewNeighbour(C6, C7, C13, C19, C18, C11);
        C13.AddNewNeighbour(C7, C8, C14, C20, C19, C12);
        C14.AddNewNeighbour(C8, C9, C15, C21, C20, C13);
        C15.AddNewNeighbour(C9, C22, C21, C14);
        C16.AddNewNeighbour(C10, C17, C23);
        C17.AddNewNeighbour(C10, C11, C18, C24, C23, C16);
        C18.AddNewNeighbour(C11, C12, C19, C25, C24, C17);
        C19.AddNewNeighbour(C12, C13, C20, C26, C25, C18);
        C20.AddNewNeighbour(C13, C14, C21, C27, C26, C19);
        C21.AddNewNeighbour(C14, C15, C22, C28, C27, C20);
        C22.AddNewNeighbour(C15, C28, C21);
        C23.AddNewNeighbour(C16, C17, C24, C29);
        C24.AddNewNeighbour(C17, C18, C25, C30, C29, C23);
        C25.AddNewNeighbour(C18, C19, C26, C31, C30, C24);
        C26.AddNewNeighbour(C19, C20, C27, C32, C32, C25);
        C27.AddNewNeighbour(C20, C21, C28, C33, C32, C26);
        C28.AddNewNeighbour(C21, C22, C33, C27);
        C29.AddNewNeighbour(C23, C24, C30, C34);
        C30.AddNewNeighbour(C24, C25, C31, C35, C34, C29);
        C31.AddNewNeighbour(C25, C26, C32, C36, C35, C30);
        C32.AddNewNeighbour(C26, C27, C33, C37, C36, C31);
        C33.AddNewNeighbour(C27, C28, C37, C32);
        C34.AddNewNeighbour(C29, C30, C35);
        C35.AddNewNeighbour(C34, C30, C31, C36);
        C36.AddNewNeighbour(C35, C31, C32, C37);
        C37.AddNewNeighbour(C36, C32, C33);

        Field I1 = new Field(1, "Green", true, "I1");
        Field I2 = new Field(1, "Blue", true, "I2");
        Field I3 = new Field(2, "Blue", true, "I3");
        Field I4 = new Field(2, "Blue", true, "I4");
        Field I5 = new Field(1, "Green", true, "I5");
        Field I6 = new Field(1, "Green", true, "I6");
        Field I7 = new Field(1, "Blue", true, "I7");
        Field I8 = new Field(1, "Blue", true, "I8");
        Field I9 = new Field(2, "Blue", true, "I9");
        Field I10 = new Field(1, "Green", true, "I10");
        Field I11 = new Field(2, "Green", true, "I11");
        Field I12 = new Field(0, "Cave", false, "I12");
        Field I13 = new Field(0, "Cave", false, "I13");
        Field I14 = new Field(3, "White", true, "I14");
        Field I15 = new Field(2, "Yellow", true, "I15");
        Field I16 = new Field(0, "Cave", false, "I16");
        Field I17 = new Field(0, "Cave", false, "I17");
        Field I18 = new Field(3, "Camp", true, "I18");
        Field I19 = new Field(2, "Green", true, "I19");
        Field I20 = new Field(1, "Green", true, "I20");
        Field I21 = new Field(2, "Yellow", true, "I21");
        Field I22 = new Field(1, "Yellow", true, "I22");
        Field I23 = new Field(1, "Green", true, "I23");
        Field I24 = new Field(2, "Green", true, "I24");
        Field I25 = new Field(0, "Cave", false, "I25");
        Field I26 = new Field(1, "Green", true, "I26");
        Field I27 = new Field(2, "Yellow", true, "I27");
        Field I28 = new Field(1, "Yellow", true, "I28");
        Field I29 = new Field(1, "Green", true, "I29");
        Field I30 = new Field(1, "Green", true, "I30");
        Field I31 = new Field(0, "Cave", false, "I31");
        Field I32 = new Field(1, "Green", true, "I32");
        Field I33 = new Field(1, "Yellow", true, "I33");
        Field I34 = new Field(1, "Green", true, "I34");
        Field I35 = new Field(1, "Green", true, "I35");
        Field I36 = new Field(1, "Green", true, "I36");
        Field I37 = new Field(1, "Green", true, "I37");
        I1.AddNewNeighbour(I2, I5, I6);
        I2.AddNewNeighbour(I1, I6, I7, I3);
        I3.AddNewNeighbour(I2, I7, I8, I4);
        I4.AddNewNeighbour(I3, I8, I9);
        I5.AddNewNeighbour(I1, I6, I10, I11);
        I6.AddNewNeighbour(I1, I2, I7, I12, I11, I5);
        I7.AddNewNeighbour(I2, I3, I8, I13, I12, I6);
        I8.AddNewNeighbour(I3, I4, I9, I14, I13, I7);
        I9.AddNewNeighbour(I4, I15, I14, I8);
        I10.AddNewNeighbour(I5, I11, I17, I16);
        I11.AddNewNeighbour(I5, I6, I12, I18, I17, I10);
        I12.AddNewNeighbour(I6, I7, I13, I19, I18, I11);
        I13.AddNewNeighbour(I7, I8, I14, I20, I19, I12);
        I14.AddNewNeighbour(I8, I9, I15, I21, I20, I13);
        I15.AddNewNeighbour(I9, I22, I21, I14);
        I16.AddNewNeighbour(I10, I17, I23);
        I17.AddNewNeighbour(I10, I11, I18, I24, I23, I16);
        I18.AddNewNeighbour(I11, I12, I19, I25, I24, I17);
        I19.AddNewNeighbour(I12, I13, I20, I26, I25, I18);
        I20.AddNewNeighbour(I13, I14, I21, I27, I26, I19);
        I21.AddNewNeighbour(I14, I15, I22, I28, I27, I20);
        I22.AddNewNeighbour(I15, I28, I21);
        I23.AddNewNeighbour(I16, I17, I24, I29);
        I24.AddNewNeighbour(I17, I18, I25, I30, I29, I23);
        I25.AddNewNeighbour(I18, I19, I26, I31, I30, I24);
        I26.AddNewNeighbour(I19, I20, I27, I32, I32, I25);
        I27.AddNewNeighbour(I20, I21, I28, I33, I32, I26);
        I28.AddNewNeighbour(I21, I22, I33, I27);
        I29.AddNewNeighbour(I23, I24, I30, I34);
        I30.AddNewNeighbour(I24, I25, I31, I35, I34, I29);
        I31.AddNewNeighbour(I25, I26, I32, I36, I35, I30);
        I32.AddNewNeighbour(I26, I27, I33, I37, I36, I31);
        I33.AddNewNeighbour(I27, I28, I37, I32);
        I34.AddNewNeighbour(I29, I30, I35);
        I35.AddNewNeighbour(I34, I30, I31, I36);
        I36.AddNewNeighbour(I35, I31, I32, I37);
        I37.AddNewNeighbour(I36, I32, I33);


        Field B37WindingPaths = B37;
        B37WindingPaths.AddNewNeighbour(WindingPathsfirst);
        Field B33WindingPaths = B33;
        B33WindingPaths.AddNewNeighbour(WindingPathsfirst);
        Field B28WindingPaths = B28;
        B28WindingPaths.AddNewNeighbour(WindingPathsfirst);
        Field B22WindingPaths = B22;
        B22WindingPaths.AddNewNeighbour(WindingPathsfirst);
        WindingPathsfirst.addNeighbour(B37WindingPaths);
        WindingPathsfirst.addNeighbour(B33WindingPaths);
        WindingPathsfirst.addNeighbour(B28WindingPaths);
        WindingPathsfirst.addNeighbour(B22WindingPaths);
        WindingPathsfirst.addNeighbour(I37);
        WindingPathsfirst.addNeighbour(I36);
        WindingPathsfirst.addNeighbour(I35);
        WindingPathsfirst.addNeighbour(I34);

        Field I22WindingPaths = I22;
        I22WindingPaths.AddNewNeighbour(WindingPathssecond);
        Field I15WindingPaths = I15;
        I15WindingPaths.AddNewNeighbour(WindingPathssecond);
        Field I9WindingPaths = I9;
        I9WindingPaths.AddNewNeighbour(WindingPathssecond);
        Field I4WindingPaths = I4;
        I4WindingPaths.AddNewNeighbour(WindingPathssecond);
        WindingPathssecond.addNeighbour(I22WindingPaths);
        WindingPathssecond.addNeighbour(I15WindingPaths);
        WindingPathssecond.addNeighbour(I9WindingPaths);
        WindingPathssecond.addNeighbour(I4WindingPaths);
        WindingPathssecond.addNeighbour(F1);
        WindingPathssecond.addNeighbour(F2);
        WindingPathssecond.addNeighbour(F3);
        WindingPathssecond.addNeighbour(F4);

        Field F16WindingPaths = F16;
        F16WindingPaths.AddNewNeighbour(WindingPathsthird);
        Field F23WindingPaths = F23;
        F23WindingPaths.AddNewNeighbour(WindingPathsthird);
        Field F29WindingPaths = F29;
        F29WindingPaths.AddNewNeighbour(WindingPathsthird);
        Field F34WindingPaths = F34;
        F34WindingPaths.AddNewNeighbour(WindingPathsthird);
        WindingPathsthird.addNeighbour(F16WindingPaths);
        WindingPathsthird.addNeighbour(F23WindingPaths);
        WindingPathsthird.addNeighbour(F29WindingPaths);
        WindingPathsthird.addNeighbour(F34WindingPaths);
        WindingPathsthird.addNeighbour(G34);
        WindingPathsthird.addNeighbour(G29);
        WindingPathsthird.addNeighbour(G23);
        WindingPathsthird.addNeighbour(G16);

        Field G1WindingPaths = G1;
        G1WindingPaths.AddNewNeighbour(WindingPathsfourth);
        Field G5WindingPaths = G5;
        G5WindingPaths.AddNewNeighbour(WindingPathsfourth);
        Field G10WindingPaths = G10;
        G10WindingPaths.AddNewNeighbour(WindingPathsfourth);
        Field G16WindingPaths = G16;
        G16WindingPaths.AddNewNeighbour(WindingPathsfourth);
        WindingPathsfourth.addNeighbour(G1WindingPaths);
        WindingPathsfourth.addNeighbour(G5WindingPaths);
        WindingPathsfourth.addNeighbour(G10WindingPaths);
        WindingPathsfourth.addNeighbour(G16WindingPaths);
        WindingPathsfourth.addNeighbour(C34);
        WindingPathsfourth.addNeighbour(C29);
        WindingPathsfourth.addNeighbour(C23);
        WindingPathsfourth.addNeighbour(C16);

        Field C37WindingPaths = C37;
        C37WindingPaths.AddNewNeighbour(WindingPathsfifth);
        Field C33WindingPaths = C33;
        C33WindingPaths.AddNewNeighbour(WindingPathsfifth);
        Field C28WindingPaths = C28;
        C28WindingPaths.AddNewNeighbour(WindingPathsfifth);
        Field C22WindingPaths = C22;
        C22WindingPaths.AddNewNeighbour(WindingPathsfifth);
        WindingPathsfifth.addNeighbour(C37WindingPaths);
        WindingPathsfifth.addNeighbour(C33WindingPaths);
        WindingPathsfifth.addNeighbour(C28WindingPaths);
        WindingPathsfifth.addNeighbour(C22WindingPaths);
        WindingPathsfifth.addNeighbour(N37);
        WindingPathsfifth.addNeighbour(N36);
        WindingPathsfifth.addNeighbour(N35);
        WindingPathsfifth.addNeighbour(N34);

        Field EDBlue1= new Field(1, "Blue", true, "EDBlue1");
        Field EDBlue2= new Field(1, "Blue", true, "EDBlue2");
        Field EDBlue3= new Field(1, "Blue", true, "EDBlue3");

        Field N2WindingPaths = N2;
        N2WindingPaths.AddNewNeighbour(EDBlue1);
        Field N1WindingPaths = N1;
        N1WindingPaths.AddNewNeighbour(EDBlue1, EDBlue2, EDBlue3);
        Field N5WindingPaths = N5;
        N5WindingPaths.AddNewNeighbour(EDBlue3);





            WindingPathsFields.add(B1);
            WindingPathsFields.add(B2);
            WindingPathsFields.add(B3);
            WindingPathsFields.add(B4);
            WindingPathsFields.add(B5);
            WindingPathsFields.add(B6);
            WindingPathsFields.add(B7);
            WindingPathsFields.add(B8);
            WindingPathsFields.add(B9);
            WindingPathsFields.add(B10);
            WindingPathsFields.add(B11);
            WindingPathsFields.add(B12);
            WindingPathsFields.add(B13);
            WindingPathsFields.add(B14);
            WindingPathsFields.add(B15);
            WindingPathsFields.add(B16);
            WindingPathsFields.add(B17);
            WindingPathsFields.add(B18);
            WindingPathsFields.add(B19);
            WindingPathsFields.add(B20);
            WindingPathsFields.add(B21);
            WindingPathsFields.add(B22WindingPaths);
            WindingPathsFields.add(B23);
            WindingPathsFields.add(B24);
            WindingPathsFields.add(B25);
            WindingPathsFields.add(B26);
            WindingPathsFields.add(B27);
            WindingPathsFields.add(B28WindingPaths);
            WindingPathsFields.add(B29);
            WindingPathsFields.add(B30);
            WindingPathsFields.add(B31);
            WindingPathsFields.add(B32);
            WindingPathsFields.add(B33WindingPaths);
            WindingPathsFields.add(B34);
            WindingPathsFields.add(B35);
            WindingPathsFields.add(B36);
            WindingPathsFields.add(B37WindingPaths);
            WindingPathsFields.add(I1);
            WindingPathsFields.add(I2);
            WindingPathsFields.add(I3);
            WindingPathsFields.add(I4WindingPaths);
            WindingPathsFields.add(I5);
            WindingPathsFields.add(I6);
            WindingPathsFields.add(I7);
            WindingPathsFields.add(I8);
            WindingPathsFields.add(I9WindingPaths);
            WindingPathsFields.add(I10);
            WindingPathsFields.add(I11);
            WindingPathsFields.add(I12);
            WindingPathsFields.add(I13);
            WindingPathsFields.add(I14);
            WindingPathsFields.add(I15WindingPaths);
            WindingPathsFields.add(I16);
            WindingPathsFields.add(I17);
            WindingPathsFields.add(I18);
            WindingPathsFields.add(I19);
            WindingPathsFields.add(I20);
            WindingPathsFields.add(I21);
            WindingPathsFields.add(I22WindingPaths);
            WindingPathsFields.add(I23);
            WindingPathsFields.add(I24);
            WindingPathsFields.add(I25);
            WindingPathsFields.add(I26);
            WindingPathsFields.add(I27);
            WindingPathsFields.add(I28);
            WindingPathsFields.add(I29);
            WindingPathsFields.add(I30);
            WindingPathsFields.add(I31);
            WindingPathsFields.add(I32);
            WindingPathsFields.add(I33);
            WindingPathsFields.add(I34);
            WindingPathsFields.add(I35);
            WindingPathsFields.add(I36);
            WindingPathsFields.add(I37);
            WindingPathsFields.add(F1);
            WindingPathsFields.add(F2);
            WindingPathsFields.add(F3);
            WindingPathsFields.add(F4);
            WindingPathsFields.add(F5);
            WindingPathsFields.add(F6);
            WindingPathsFields.add(F7);
            WindingPathsFields.add(F8);
            WindingPathsFields.add(F9);
            WindingPathsFields.add(F10);
            WindingPathsFields.add(F11);
            WindingPathsFields.add(F12);
            WindingPathsFields.add(F13);
            WindingPathsFields.add(F14);
            WindingPathsFields.add(F15);
            WindingPathsFields.add(F16WindingPaths);
            WindingPathsFields.add(F17);
            WindingPathsFields.add(F18);
            WindingPathsFields.add(F19);
            WindingPathsFields.add(F20);
            WindingPathsFields.add(F21);
            WindingPathsFields.add(F22);
            WindingPathsFields.add(F23WindingPaths);
            WindingPathsFields.add(F24);
            WindingPathsFields.add(F25);
            WindingPathsFields.add(F26);
            WindingPathsFields.add(F27);
            WindingPathsFields.add(F28);
            WindingPathsFields.add(F29WindingPaths);
            WindingPathsFields.add(F30);
            WindingPathsFields.add(F31);
            WindingPathsFields.add(F32);
            WindingPathsFields.add(F33);
            WindingPathsFields.add(F34WindingPaths);
            WindingPathsFields.add(F35);
            WindingPathsFields.add(F36);
            WindingPathsFields.add(F37);
            WindingPathsFields.add(G1WindingPaths);
            WindingPathsFields.add(G2);
            WindingPathsFields.add(G3);
            WindingPathsFields.add(G4);
            WindingPathsFields.add(G5WindingPaths);
            WindingPathsFields.add(G6);
            WindingPathsFields.add(G7);
            WindingPathsFields.add(G8);
            WindingPathsFields.add(G9);
            WindingPathsFields.add(G10WindingPaths);
            WindingPathsFields.add(G11);
            WindingPathsFields.add(G12);
            WindingPathsFields.add(G13);
            WindingPathsFields.add(G14);
            WindingPathsFields.add(G15);
            WindingPathsFields.add(G16WindingPaths);
            WindingPathsFields.add(G17);
            WindingPathsFields.add(G18);
            WindingPathsFields.add(G19);
            WindingPathsFields.add(G20);
            WindingPathsFields.add(G21);
            WindingPathsFields.add(G22);
            WindingPathsFields.add(G23);
            WindingPathsFields.add(G24);
            WindingPathsFields.add(G25);
            WindingPathsFields.add(G26);
            WindingPathsFields.add(G27);
            WindingPathsFields.add(G28);
            WindingPathsFields.add(G29);
            WindingPathsFields.add(G30);
            WindingPathsFields.add(G31);
            WindingPathsFields.add(G32);
            WindingPathsFields.add(G33);
            WindingPathsFields.add(G34);
            WindingPathsFields.add(G35);
            WindingPathsFields.add(G36);
            WindingPathsFields.add(G37);
            WindingPathsFields.add(C1);
            WindingPathsFields.add(C2);
            WindingPathsFields.add(C3);
            WindingPathsFields.add(C4);
            WindingPathsFields.add(C5);
            WindingPathsFields.add(C6);
            WindingPathsFields.add(C7);
            WindingPathsFields.add(C8);
            WindingPathsFields.add(C9);
            WindingPathsFields.add(C10);
            WindingPathsFields.add(C11);
            WindingPathsFields.add(C12);
            WindingPathsFields.add(C13);
            WindingPathsFields.add(C14);
            WindingPathsFields.add(C15);
            WindingPathsFields.add(C16);
            WindingPathsFields.add(C17);
            WindingPathsFields.add(C18);
            WindingPathsFields.add(C19);
            WindingPathsFields.add(C20);
            WindingPathsFields.add(C21);
            WindingPathsFields.add(C22WindingPaths);
            WindingPathsFields.add(C23);
            WindingPathsFields.add(C24);
            WindingPathsFields.add(C25);
            WindingPathsFields.add(C26);
            WindingPathsFields.add(C27);
            WindingPathsFields.add(C28WindingPaths);
            WindingPathsFields.add(C29);
            WindingPathsFields.add(C30);
            WindingPathsFields.add(C31);
            WindingPathsFields.add(C32);
            WindingPathsFields.add(C33WindingPaths);
            WindingPathsFields.add(C34);
            WindingPathsFields.add(C35);
            WindingPathsFields.add(C36);
            WindingPathsFields.add(C37WindingPaths);
            WindingPathsFields.add(N1WindingPaths);
            WindingPathsFields.add(N2WindingPaths);
            WindingPathsFields.add(N3);
            WindingPathsFields.add(N4);
            WindingPathsFields.add(N5WindingPaths);
            WindingPathsFields.add(N6);
            WindingPathsFields.add(N7);
            WindingPathsFields.add(N8);
            WindingPathsFields.add(N9);
            WindingPathsFields.add(N10);
            WindingPathsFields.add(N11);
            WindingPathsFields.add(N12);
            WindingPathsFields.add(N13);
            WindingPathsFields.add(N14);
            WindingPathsFields.add(N15);
            WindingPathsFields.add(N16);
            WindingPathsFields.add(N17);
            WindingPathsFields.add(N18);
            WindingPathsFields.add(N19);
            WindingPathsFields.add(N20);
            WindingPathsFields.add(N21);
            WindingPathsFields.add(N22);
            WindingPathsFields.add(N23);
            WindingPathsFields.add(N24);
            WindingPathsFields.add(N25);
            WindingPathsFields.add(N26);
            WindingPathsFields.add(N27);
            WindingPathsFields.add(N28);
            WindingPathsFields.add(N29);
            WindingPathsFields.add(N30);
            WindingPathsFields.add(N31);
            WindingPathsFields.add(N32);
            WindingPathsFields.add(N33);
            WindingPathsFields.add(N34);
            WindingPathsFields.add(N35);
            WindingPathsFields.add(N36);
            WindingPathsFields.add(N37);
            WindingPathsFields.add(EDBlue1);
            WindingPathsFields.add(EDBlue2);
            WindingPathsFields.add(EDBlue3);
    }


    public void setupSerpentine() {


        Field G1 = new Field(1, "Green", true, "G1");
        Field G2 = new Field(1, "Green", true, "G2");
        Field G3 = new Field(1, "Green", true, "G3");
        Field G4 = new Field(1, "Green", true, "G4");
        Field G5 = new Field(1, "Green", true, "G5");
        Field G6 = new Field(2, "Green", true, "G6");
        Field G7 = new Field(1, "Yellow", true, "G7");
        Field G8 = new Field(0, "Cave", false, "G8");
        Field G9 = new Field(1, "Green", true, "G9");
        Field G10 = new Field(1, "Yellow", true, "G10");
        Field G11 = new Field(2, "Yellow", true, "G11");
        Field G12 = new Field(2, "Yellow", true, "G12");
        Field G13 = new Field(1, "White", true, "G13");
        Field G14 = new Field(1, "Yellow", true, "G14");
        Field G15 = new Field(1, "Green", true, "G15");
        Field G16 = new Field(0, "Cave", false, "G16");
        Field G17 = new Field(0, "Cave", false, "G17");
        Field G18 = new Field(4, "Yellow", true, "G18");
        Field G19 = new Field(3, "Yellow", true, "G19");
        Field G20 = new Field(2, "Yellow", true, "G20");
        Field G21 = new Field(2, "Green", true, "G21");
        Field G22 = new Field(1, "Camp", true, "G22");
        Field G23 = new Field(1, "Yellow", true, "G23");
        Field G24 = new Field(2, "Yellow", true, "G24");
        Field G25 = new Field(2, "Yellow", true, "G25");
        Field G26 = new Field(1, "White", true, "G26");
        Field G27 = new Field(1, "Yellow", true, "G27");
        Field G28 = new Field(1, "Green", true, "G28");
        Field G29 = new Field(1, "Green", true, "G29");
        Field G30 = new Field(2, "Green", true, "G30");
        Field G31 = new Field(1, "Yellow", true, "G31");
        Field G32 = new Field(0, "Cave", false, "G32");
        Field G33 = new Field(1, "Green", true, "G33");
        Field G34 = new Field(1, "Green", true, "G34");
        Field G35 = new Field(1, "Green", true, "G35");
        Field G36 = new Field(1, "Green", true, "G36");
        Field G37 = new Field(1, "Green", true, "G37");
        G1.AddNewNeighbour(G2, G5, G6);
        G2.AddNewNeighbour(G1, G6, G7, G3);
        G3.AddNewNeighbour(G2, G7, G8, G4);
        G4.AddNewNeighbour(G3, G8, G9);
        G5.AddNewNeighbour(G1, G6, G10, G11);
        G6.AddNewNeighbour(G1, G2, G7, G12, G11, G5);
        G7.AddNewNeighbour(G2, G3, G8, G13, G12, G6);
        G8.AddNewNeighbour(G3, G4, G9, G14, G13, G7);
        G9.AddNewNeighbour(G4, G15, G14, G8);
        G10.AddNewNeighbour(G5, G11, G17, G16);
        G11.AddNewNeighbour(G5, G6, G12, G18, G17, G10);
        G12.AddNewNeighbour(G6, G7, G13, G19, G18, G11);
        G13.AddNewNeighbour(G7, G8, G14, G20, G19, G12);
        G14.AddNewNeighbour(G8, G9, G15, G21, G20, G13);
        G15.AddNewNeighbour(G9, G22, G21, G14);
        G16.AddNewNeighbour(G10, G17, G23);
        G17.AddNewNeighbour(G10, G11, G18, G24, G23, G16);
        G18.AddNewNeighbour(G11, G12, G19, G25, G24, G17);
        G19.AddNewNeighbour(G12, G13, G20, G26, G25, G18);
        G20.AddNewNeighbour(G13, G14, G21, G27, G26, G19);
        G21.AddNewNeighbour(G14, G15, G22, G28, G27, G20);
        G22.AddNewNeighbour(G15, G28, G21);
        G23.AddNewNeighbour(G16, G17, G24, G29);
        G24.AddNewNeighbour(G17, G18, G25, G30, G29, G23);
        G25.AddNewNeighbour(G18, G19, G26, G31, G30, G24);
        G26.AddNewNeighbour(G19, G20, G27, G32, G32, G25);
        G27.AddNewNeighbour(G20, G21, G28, G33, G32, G26);
        G28.AddNewNeighbour(G21, G22, G33, G27);
        G29.AddNewNeighbour(G23, G24, G30, G34);
        G30.AddNewNeighbour(G24, G25, G31, G35, G34, G29);
        G31.AddNewNeighbour(G25, G26, G32, G36, G35, G30);
        G32.AddNewNeighbour(G26, G27, G33, G37, G36, G31);
        G33.AddNewNeighbour(G27, G28, G37, G32);
        G34.AddNewNeighbour(G29, G30, G35);
        G35.AddNewNeighbour(G34, G30, G31, G36);
        G36.AddNewNeighbour(G35, G31, G32, G37);
        G37.AddNewNeighbour(G36, G32, G33);

        Field J1 = new Field(1, "Yellow", true, "J1");
        Field J2 = new Field(1, "Yellow", true, "J2");
        Field J3 = new Field(1, "Yellow", true, "J3");
        Field J4 = new Field(1, "Yellow", true, "J4");
        Field J5 = new Field(1, "Yellow", true, "J5");
        Field J6 = new Field(2, "Yellow", true, "J6");
        Field J7 = new Field(2, "Yellow", true, "J7");
        Field J8 = new Field(1, "Yellow", true, "J8");
        Field J9 = new Field(1, "Blue", true, "J9");
        Field J10 = new Field(1, "Yellow", true, "J10");
        Field J11 = new Field(2, "Yellow", true, "J11");
        Field J12 = new Field(1, "Green", true, "J12");
        Field J13 = new Field(2, "Green", true, "J13");
        Field J14 = new Field(2, "Blue", true, "J14");
        Field J15 = new Field(1, "Blue", true, "J15");
        Field J16 = new Field(2, "White", true, "J16");
        Field J17 = new Field(0, "Cave", false, "J17");
        Field J18 = new Field(1, "Green", true, "J18");
        Field J19 = new Field(1, "Camp", true, "J19");
        Field J20 = new Field(1, "Green", true, "J20");
        Field J21 = new Field(0, "Cave", false, "J21");
        Field J22 = new Field(1, "Blue", true, "J22");
        Field J23 = new Field(1, "White", true, "J23");
        Field J24 = new Field(2, "White", true, "J24");
        Field J25 = new Field(1, "Green", true, "J25");
        Field J26 = new Field(2, "Green", true, "J26");
        Field J27 = new Field(2, "Blue", true, "J27");
        Field J28 = new Field(1, "Blue", true, "J28");
        Field J29 = new Field(1, "White", true, "J29");
        Field J30 = new Field(2, "White", true, "J30");
        Field J31 = new Field(2, "White", true, "J31");
        Field J32 = new Field(1, "Blue", true, "J32");
        Field J33 = new Field(1, "Blue", true, "J33");
        Field J34 = new Field(1, "White", true, "J34");
        Field J35 = new Field(1, "White", true, "J35");
        Field J36 = new Field(2, "White", true, "J36");
        Field J37 = new Field(1, "Blue", true, "J37");
        J1.AddNewNeighbour(J2, J5, J6);
        J2.AddNewNeighbour(J1, J6, J7, J3);
        J3.AddNewNeighbour(J2, J7, J8, J4);
        J4.AddNewNeighbour(J3, J8, J9);
        J5.AddNewNeighbour(J1, J6, J10, J11);
        J6.AddNewNeighbour(J1, J2, J7, J12, J11, J5);
        J7.AddNewNeighbour(J2, J3, J8, J13, J12, J6);
        J8.AddNewNeighbour(J3, J4, J9, J14, J13, J7);
        J9.AddNewNeighbour(J4, J15, J14, J8);
        J10.AddNewNeighbour(J5, J11, J17, J16);
        J11.AddNewNeighbour(J5, J6, J12, J18, J17, J10);
        J12.AddNewNeighbour(J6, J7, J13, J19, J18, J11);
        J13.AddNewNeighbour(J7, J8, J14, J20, J19, J12);
        J14.AddNewNeighbour(J8, J9, J15, J21, J20, J13);
        J15.AddNewNeighbour(J9, J22, J21, J14);
        J16.AddNewNeighbour(J10, J17, J23);
        J17.AddNewNeighbour(J10, J11, J18, J24, J23, J16);
        J18.AddNewNeighbour(J11, J12, J19, J25, J24, J17);
        J19.AddNewNeighbour(J12, J13, J20, J26, J25, J18);
        J20.AddNewNeighbour(J13, J14, J21, J27, J26, J19);
        J21.AddNewNeighbour(J14, J15, J22, J28, J27, J20);
        J22.AddNewNeighbour(J15, J28, J21);
        J23.AddNewNeighbour(J16, J17, J24, J29);
        J24.AddNewNeighbour(J17, J18, J25, J30, J29, J23);
        J25.AddNewNeighbour(J18, J19, J26, J31, J30, J24);
        J26.AddNewNeighbour(J19, J20, J27, J32, J32, J25);
        J27.AddNewNeighbour(J20, J21, J28, J33, J32, J26);
        J28.AddNewNeighbour(J21, J22, J33, J27);
        J29.AddNewNeighbour(J23, J24, J30, J34);
        J30.AddNewNeighbour(J24, J25, J31, J35, J34, J29);
        J31.AddNewNeighbour(J25, J26, J32, J36, J35, J30);
        J32.AddNewNeighbour(J26, J27, J33, J37, J36, J31);
        J33.AddNewNeighbour(J27, J28, J37, J32);
        J34.AddNewNeighbour(J29, J30, J35);
        J35.AddNewNeighbour(J34, J30, J31, J36);
        J36.AddNewNeighbour(J35, J31, J32, J37);
        J37.AddNewNeighbour(J36, J32, J33);

        Field E1 = new Field(1, "Green", true, "E1");
        Field E2 = new Field(1, "White", true, "E2");
        Field E3 = new Field(1, "White", true, "E3");
        Field E4 = new Field(0, "Cave", false, "E4");
        Field E5 = new Field(1, "Green", true, "E5");
        Field E6 = new Field(2, "Blue", true, "E6");
        Field E7 = new Field(2, "Green", true, "E7");
        Field E8 = new Field(0, "Cave", false, "E8");
        Field E9 = new Field(1, "White", true, "E9");
        Field E10 = new Field(1, "Green", true, "E10");
        Field E11 = new Field(0, "Cave", false, "E11");
        Field E12 = new Field(1, "White", true, "E12");
        Field E13 = new Field(3, "White", true, "E13");
        Field E14 = new Field(1, "White", true, "E14");
        Field E15 = new Field(1, "Green", true, "E15");
        Field E16 = new Field(1, "White", true, "E16");
        Field E17 = new Field(2, "Green", true, "E17");
        Field E18 = new Field(1, "Green", true, "E18");
        Field E19 = new Field(1, "Blue", true, "E19");
        Field E20 = new Field(3, "Green", true, "E20");
        Field E21 = new Field(2, "Green", true, "E21");
        Field E22 = new Field(1, "Green", true, "E22");
        Field E23 = new Field(1, "Green", true, "E23");
        Field E24 = new Field(1, "Blue", true, "E24");
        Field E25 = new Field(1, "Blue", true, "E25");
        Field E26 = new Field(0, "Cave", false, "E26");
        Field E27 = new Field(1, "Green", true, "E27");
        Field E28 = new Field(1, "White", true, "E28");
        Field E29 = new Field(1, "Yellow", true, "E29");
        Field E30 = new Field(0, "Cave", false, "E30");
        Field E31 = new Field(1, "Green", true, "E31");
        Field E32 = new Field(2, "Green", true, "E32");
        Field E33 = new Field(1, "Green", true, "E33");
        Field E34 = new Field(1, "Yellow", true, "E34");
        Field E35 = new Field(1, "Yellow", true, "E35");
        Field E36 = new Field(1, "Yellow", true, "E36");
        Field E37 = new Field(1, "Camp", true, "E37");
        E1.AddNewNeighbour(E2, E5, E6);
        E2.AddNewNeighbour(E1, E6, E7, E3);
        E3.AddNewNeighbour(E2, E7, E8, E4);
        E4.AddNewNeighbour(E3, E8, E9);
        E5.AddNewNeighbour(E1, E6, E10, E11);
        E6.AddNewNeighbour(E1, E2, E7, E12, E11, E5);
        E7.AddNewNeighbour(E2, E3, E8, E13, E12, E6);
        E8.AddNewNeighbour(E3, E4, E9, E14, E13, E7);
        E9.AddNewNeighbour(E4, E15, E14, E8);
        E10.AddNewNeighbour(E5, E11, E17, E16);
        E11.AddNewNeighbour(E5, E6, E12, E18, E17, E10);
        E12.AddNewNeighbour(E6, E7, E13, E19, E18, E11);
        E13.AddNewNeighbour(E7, E8, E14, E20, E19, E12);
        E14.AddNewNeighbour(E8, E9, E15, E21, E20, E13);
        E15.AddNewNeighbour(E9, E22, E21, E14);
        E16.AddNewNeighbour(E10, E17, E23);
        E17.AddNewNeighbour(E10, E11, E18, E24, E23, E16);
        E18.AddNewNeighbour(E11, E12, E19, E25, E24, E17);
        E19.AddNewNeighbour(E12, E13, E20, E26, E25, E18);
        E20.AddNewNeighbour(E13, E14, E21, E27, E26, E19);
        E21.AddNewNeighbour(E14, E15, E22, E28, E27, E20);
        E22.AddNewNeighbour(E15, E28, E21);
        E23.AddNewNeighbour(E16, E17, E24, E29);
        E24.AddNewNeighbour(E17, E18, E25, E30, E29, E23);
        E25.AddNewNeighbour(E18, E19, E26, E31, E30, E24);
        E26.AddNewNeighbour(E19, E20, E27, E32, E32, E25);
        E27.AddNewNeighbour(E20, E21, E28, E33, E32, E26);
        E28.AddNewNeighbour(E21, E22, E33, E27);
        E29.AddNewNeighbour(E23, E24, E30, E34);
        E30.AddNewNeighbour(E24, E25, E31, E35, E34, E29);
        E31.AddNewNeighbour(E25, E26, E32, E36, E35, E30);
        E32.AddNewNeighbour(E26, E27, E33, E37, E36, E31);
        E33.AddNewNeighbour(E27, E28, E37, E32);
        E34.AddNewNeighbour(E29, E30, E35);
        E35.AddNewNeighbour(E34, E30, E31, E36);
        E36.AddNewNeighbour(E35, E31, E32, E37);
        E37.AddNewNeighbour(E36, E32, E33);

        Field A1 = new Field(0, "Green", true, "A1");
        Field A2 = new Field(0, "Green", true, "A2");
        Field A3 = new Field(0, "Green", true, "A3");
        Field A4 = new Field(0, "Green", true, "A4");
        Field A5 = new Field(1, "Green", true, "A5");
        Field A6 = new Field(1, "Green", true, "A6");
        Field A7 = new Field(1, "Green", true, "A7");
        Field A8 = new Field(1, "Green", true, "A8");
        Field A9 = new Field(1, "Green", true, "A9");
        Field A10 = new Field(1, "Green", true, "A10");
        Field A11 = new Field(1, "Green", true, "A11");
        Field A12 = new Field(1, "Yellow", true, "A12");
        Field A13 = new Field(1, "Green", true, "A13");
        Field A14 = new Field(1, "Blue", true, "A14");
        Field A15 = new Field(1, "Green", true, "A15");
        Field A16 = new Field(1, "Green", true, "A16");
        Field A17 = new Field(1, "Yellow", true, "A17");
        Field A18 = new Field(1, "Green", true, "A18");
        Field A19 = new Field(1, "Blue", true, "A19");
        Field A20 = new Field(1, "Green", true, "A20");
        Field A21 = new Field(1, "Yellow", true, "A21");
        Field A22 = new Field(1, "Green", true, "A22");
        Field A23 = new Field(1, "Green", true, "A23");
        Field A24 = new Field(0, "Cave", false, "A24");
        Field A25 = new Field(1, "Yellow", true, "A25");
        Field A26 = new Field(1, "Green", true, "A26");
        Field A27 = new Field(1, "Green", true, "A27");
        Field A28 = new Field(1, "Green", true, "A28");
        Field A29 = new Field(1, "Blue", true, "A29");
        Field A30 = new Field(0, "Cave", false, "A30");
        Field A31 = new Field(1, "Green", true, "A31");
        Field A32 = new Field(1, "Green", true, "A32");
        Field A33 = new Field(1, "Yellow", true, "A33");
        Field A34 = new Field(1, "Green", true, "A34");
        Field A35 = new Field(1, "Camp", true, "A35");
        Field A36 = new Field(1, "Green", true, "A36");
        Field A37 = new Field(1, "Green", true, "A37");
        A1.AddNewNeighbour(A2, A5, A6);
        A2.AddNewNeighbour(A1, A6, A7, A3);
        A3.AddNewNeighbour(A2, A7, A8, A4);
        A4.AddNewNeighbour(A3, A8, A9);
        A5.AddNewNeighbour(A1, A6, A10, A11);
        A6.AddNewNeighbour(A1, A2, A7, A12, A11, A5);
        A7.AddNewNeighbour(A2, A3, A8, A13, A12, A6);
        A8.AddNewNeighbour(A3, A4, A9, A14, A13, A7);
        A9.AddNewNeighbour(A4, A15, A14, A8);
        A10.AddNewNeighbour(A5, A11, A17, A16);
        A11.AddNewNeighbour(A5, A6, A12, A18, A17, A10);
        A12.AddNewNeighbour(A6, A7, A13, A19, A18, A11);
        A13.AddNewNeighbour(A7, A8, A14, A20, A19, A12);
        A14.AddNewNeighbour(A8, A9, A15, A21, A20, A13);
        A15.AddNewNeighbour(A9, A22, A21, A14);
        A16.AddNewNeighbour(A10, A17, A23);
        A17.AddNewNeighbour(A10, A11, A18, A24, A23, A16);
        A18.AddNewNeighbour(A11, A12, A19, A25, A24, A17);
        A19.AddNewNeighbour(A12, A13, A20, A26, A25, A18);
        A20.AddNewNeighbour(A13, A14, A21, A27, A26, A19);
        A21.AddNewNeighbour(A14, A15, A22, A28, A27, A20);
        A22.AddNewNeighbour(A15, A28, A21);
        A23.AddNewNeighbour(A16, A17, A24, A29);
        A24.AddNewNeighbour(A17, A18, A25, A30, A29, A23);
        A25.AddNewNeighbour(A18, A19, A26, A31, A30, A24);
        A26.AddNewNeighbour(A19, A20, A27, A32, A32, A25);
        A27.AddNewNeighbour(A20, A21, A28, A33, A32, A26);
        A28.AddNewNeighbour(A21, A22, A33, A27);
        A29.AddNewNeighbour(A23, A24, A30, A34);
        A30.AddNewNeighbour(A24, A25, A31, A35, A34, A29);
        A31.AddNewNeighbour(A25, A26, A32, A36, A35, A30);
        A32.AddNewNeighbour(A26, A27, A33, A37, A36, A31);
        A33.AddNewNeighbour(A27, A28, A37, A32);
        A34.AddNewNeighbour(A29, A30, A35);
        A35.AddNewNeighbour(A34, A30, A31, A36);
        A36.AddNewNeighbour(A35, A31, A32, A37);
        A37.AddNewNeighbour(A36, A32, A33);

        Field C1 = new Field(1, "Blue", true, "C1");
        Field C2 = new Field(1, "Blue", true, "C2");
        Field C3 = new Field(1, "Green", true, "C3");
        Field C4 = new Field(1, "Green", true, "C4");
        Field C5 = new Field(1, "Yellow", true, "C5");
        Field C6 = new Field(1, "Yellow", true, "C6");
        Field C7 = new Field(1, "Blue", true, "C7");
        Field C8 = new Field(1, "Yellow", true, "C8");
        Field C9 = new Field(1, "Green", true, "C9");
        Field C10 = new Field(1, "Yellow", true, "C10");
        Field C11 = new Field(1, "White", true, "C11");
        Field C12 = new Field(1, "White", true, "C12");
        Field C13 = new Field(1, "Yellow", true, "C13");
        Field C14 = new Field(1, "White", true, "C14");
        Field C15 = new Field(1, "White", true, "C15");
        Field C16 = new Field(1, "Green", true, "C16");
        Field C17 = new Field(1, "White", true, "C17");
        Field C18 = new Field(1, "Blue", true, "C18");
        Field C19 = new Field(0, "Cave", false, "C19");
        Field C20 = new Field(1, "Yellow", true, "C20");
        Field C21 = new Field(1, "Blue", true, "C21");
        Field C22 = new Field(1, "White", true, "C22");
        Field C23 = new Field(1, "Green", true, "C23");
        Field C24 = new Field(1, "Green", true, "C24");
        Field C25 = new Field(1, "Blue", true, "C25");
        Field C26 = new Field(1, "Blue", true, "C26");
        Field C27 = new Field(1, "White", true, "C27");
        Field C28 = new Field(1, "Blue", true, "C28");
        Field C29 = new Field(1, "Blue", true, "C29");
        Field C30 = new Field(1, "Yellow", true, "C30");
        Field C31 = new Field(1, "Yellow", true, "C31");
        Field C32 = new Field(1, "White", true, "C32");
        Field C33 = new Field(1, "Blue", true, "C33");
        Field C34 = new Field(1, "Blue", true, "C34");
        Field C35 = new Field(1, "Blue", true, "C35");
        Field C36 = new Field(1, "Yellow", true, "C36");
        Field C37 = new Field(1, "White", true, "C37");
        C1.AddNewNeighbour(C2, C5, C6);
        C2.AddNewNeighbour(C1, C6, C7, C3);
        C3.AddNewNeighbour(C2, C7, C8, C4);
        C4.AddNewNeighbour(C3, C8, C9);
        C5.AddNewNeighbour(C1, C6, C10, C11);
        C6.AddNewNeighbour(C1, C2, C7, C12, C11, C5);
        C7.AddNewNeighbour(C2, C3, C8, C13, C12, C6);
        C8.AddNewNeighbour(C3, C4, C9, C14, C13, C7);
        C9.AddNewNeighbour(C4, C15, C14, C8);
        C10.AddNewNeighbour(C5, C11, C17, C16);
        C11.AddNewNeighbour(C5, C6, C12, C18, C17, C10);
        C12.AddNewNeighbour(C6, C7, C13, C19, C18, C11);
        C13.AddNewNeighbour(C7, C8, C14, C20, C19, C12);
        C14.AddNewNeighbour(C8, C9, C15, C21, C20, C13);
        C15.AddNewNeighbour(C9, C22, C21, C14);
        C16.AddNewNeighbour(C10, C17, C23);
        C17.AddNewNeighbour(C10, C11, C18, C24, C23, C16);
        C18.AddNewNeighbour(C11, C12, C19, C25, C24, C17);
        C19.AddNewNeighbour(C12, C13, C20, C26, C25, C18);
        C20.AddNewNeighbour(C13, C14, C21, C27, C26, C19);
        C21.AddNewNeighbour(C14, C15, C22, C28, C27, C20);
        C22.AddNewNeighbour(C15, C28, C21);
        C23.AddNewNeighbour(C16, C17, C24, C29);
        C24.AddNewNeighbour(C17, C18, C25, C30, C29, C23);
        C25.AddNewNeighbour(C18, C19, C26, C31, C30, C24);
        C26.AddNewNeighbour(C19, C20, C27, C32, C32, C25);
        C27.AddNewNeighbour(C20, C21, C28, C33, C32, C26);
        C28.AddNewNeighbour(C21, C22, C33, C27);
        C29.AddNewNeighbour(C23, C24, C30, C34);
        C30.AddNewNeighbour(C24, C25, C31, C35, C34, C29);
        C31.AddNewNeighbour(C25, C26, C32, C36, C35, C30);
        C32.AddNewNeighbour(C26, C27, C33, C37, C36, C31);
        C33.AddNewNeighbour(C27, C28, C37, C32);
        C34.AddNewNeighbour(C29, C30, C35);
        C35.AddNewNeighbour(C34, C30, C31, C36);
        C36.AddNewNeighbour(C35, C31, C32, C37);
        C37.AddNewNeighbour(C36, C32, C33);

        Field M1 = new Field(1, "Green", true, "M1");
        Field M2 = new Field(1, "Green", true, "M2");
        Field M3 = new Field(1, "Green", true, "M3");
        Field M4 = new Field(1, "Camp", true, "M4");
        Field M5 = new Field(1, "Green", true, "M5");
        Field M6 = new Field(3, "Yellow", true, "M6");
        Field M7 = new Field(0, "Cave", false, "M7");
        Field M8 = new Field(0, "Cave", false, "M8");
        Field M9 = new Field(4, "Blue", true, "M9");
        Field M10 = new Field(1, "Green", true, "M10");
        Field M11 = new Field(2, "Yellow", true, "M11");
        Field M12 = new Field(1, "Green", true, "M12");
        Field M13 = new Field(1, "Green", true, "M13");
        Field M14 = new Field(1, "Blue", true, "M14");
        Field M15 = new Field(0, "Cave", false, "M15");
        Field M16 = new Field(0, "Cave", false, "M16");
        Field M17 = new Field(1, "Green", true, "M17");
        Field M18 = new Field(1, "Green", true, "M18");
        Field M19 = new Field(2, "White", true, "M19");
        Field M20 = new Field(1, "Green", true, "M20");
        Field M21 = new Field(1, "Green", true, "M21");
        Field M22 = new Field(0, "Cave", false, "M22");
        Field M23 = new Field(0, "Cave", false, "M23");
        Field M24 = new Field(0, "Cave", false, "M24");
        Field M25 = new Field(0, "Cave", false, "M25");
        Field M26 = new Field(0, "Cave", false, "M26");
        Field M27 = new Field(2, "White", true, "M27");
        Field M28 = new Field(1, "Green", true, "M28");
        Field M29 = new Field(1, "Green", true, "M29");
        Field M30 = new Field(1, "Green", true, "M30");
        Field M31 = new Field(1, "Green", true, "M31");
        Field M32 = new Field(2, "White", true, "M32");
        Field M33 = new Field(1, "Green", true, "M33");
        Field M34 = new Field(1, "Blue", true, "M34");
        Field M35 = new Field(1, "Blue", true, "M35");
        Field M36 = new Field(1, "Green", true, "M36");
        Field M37 = new Field(1, "Green", true, "M37");
        M1.AddNewNeighbour(M2, M5, M6);
        M2.AddNewNeighbour(M1, M6, M7, M3);
        M3.AddNewNeighbour(M2, M7, M8, M4);
        M4.AddNewNeighbour(M3, M8, M9);
        M5.AddNewNeighbour(M1, M6, M10, M11);
        M6.AddNewNeighbour(M1, M2, M7, M12, M11, M5);
        M7.AddNewNeighbour(M2, M3, M8, M13, M12, M6);
        M8.AddNewNeighbour(M3, M4, M9, M14, M13, M7);
        M9.AddNewNeighbour(M4, M15, M14, M8);
        M10.AddNewNeighbour(M5, M11, M17, M16);
        M11.AddNewNeighbour(M5, M6, M12, M18, M17, M10);
        M12.AddNewNeighbour(M6, M7, M13, M19, M18, M11);
        M13.AddNewNeighbour(M7, M8, M14, M20, M19, M12);
        M14.AddNewNeighbour(M8, M9, M15, M21, M20, M13);
        M15.AddNewNeighbour(M9, M22, M21, M14);
        M16.AddNewNeighbour(M10, M17, M23);
        M17.AddNewNeighbour(M10, M11, M18, M24, M23, M16);
        M18.AddNewNeighbour(M11, M12, M19, M25, M24, M17);
        M19.AddNewNeighbour(M12, M13, M20, M26, M25, M18);
        M20.AddNewNeighbour(M13, M14, M21, M27, M26, M19);
        M21.AddNewNeighbour(M14, M15, M22, M28, M27, M20);
        M22.AddNewNeighbour(M15, M28, M21);
        M23.AddNewNeighbour(M16, M17, M24, M29);
        M24.AddNewNeighbour(M17, M18, M25, M30, M29, M23);
        M25.AddNewNeighbour(M18, M19, M26, M31, M30, M24);
        M26.AddNewNeighbour(M19, M20, M27, M32, M32, M25);
        M27.AddNewNeighbour(M20, M21, M28, M33, M32, M26);
        M28.AddNewNeighbour(M21, M22, M33, M27);
        M29.AddNewNeighbour(M23, M24, M30, M34);
        M30.AddNewNeighbour(M24, M25, M31, M35, M34, M29);
        M31.AddNewNeighbour(M25, M26, M32, M36, M35, M30);
        M32.AddNewNeighbour(M26, M27, M33, M37, M36, M31);
        M33.AddNewNeighbour(M27, M28, M37, M32);
        M34.AddNewNeighbour(M29, M30, M35);
        M35.AddNewNeighbour(M34, M30, M31, M36);
        M36.AddNewNeighbour(M35, M31, M32, M37);
        M37.AddNewNeighbour(M36, M32, M33);

        Random rand = new Random();
        int numberOfElements = 5;

        List<Blockade> blockadeList = new ArrayList<>(Blockades);

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(blockadeList.size());
            Blockade randomElement = blockadeList.get(randomIndex);
            blockadeList.remove(randomIndex);
            currentBlockades.add(randomElement);

        }
        currentBlockades.get(0).setName("BK1");
        currentBlockades.get(1).setName("BK2");
        currentBlockades.get(2).setName("BK3");
        currentBlockades.get(3).setName("BK4");
        currentBlockades.get(4).setName("BK5");

        removalList = new ArrayList<>(currentBlockades);


        Blockade Serpentinefirst = currentBlockades.get(0);
        Blockade Serpentinesecond = currentBlockades.get(1);
        Blockade Serpentinethird = currentBlockades.get(2);
        Blockade Serpentinefourth = currentBlockades.get(3);
        Blockade Serpentinefifth = currentBlockades.get(4);


        Field A22Serpentine = A22;
        A22Serpentine.AddNewNeighbour(Serpentinefirst);
        Field A28Serpentine = A28;
        A28Serpentine.AddNewNeighbour(Serpentinefirst);
        Field A33Serpentine = A33;
        A33Serpentine.AddNewNeighbour(Serpentinefirst);
        Field A37Serpentine = A37;
        A37Serpentine.AddNewNeighbour(Serpentinefirst);
        Serpentinefirst.addNeighbour(A22Serpentine);
        Serpentinefirst.addNeighbour(A28Serpentine);
        Serpentinefirst.addNeighbour(A33Serpentine);
        Serpentinefirst.addNeighbour(A37Serpentine);
        Serpentinefirst.addNeighbour(C22);
        Serpentinefirst.addNeighbour(C28);
        Serpentinefirst.addNeighbour(C33);
        Serpentinefirst.addNeighbour(C37);

        Field C16Serpentine = C16;
        C16Serpentine.AddNewNeighbour(Serpentinesecond);
        Field C23Serpentine = C23;
        C23Serpentine.AddNewNeighbour(Serpentinesecond);
        Field C29Serpentine = C29;
        C29Serpentine.AddNewNeighbour(Serpentinesecond);
        Field C34Serpentine = C34;
        C34Serpentine.AddNewNeighbour(Serpentinesecond);
        Serpentinesecond.addNeighbour(C16Serpentine);
        Serpentinesecond.addNeighbour(C23Serpentine);
        Serpentinesecond.addNeighbour(C29Serpentine);
        Serpentinesecond.addNeighbour(C34Serpentine);
        Serpentinesecond.addNeighbour(E1);
        Serpentinesecond.addNeighbour(E2);
        Serpentinesecond.addNeighbour(E3);
        Serpentinesecond.addNeighbour(E4);

        Field E4Serpentine = E4;
        E4Serpentine.AddNewNeighbour(Serpentinethird);
        Field E9Serpentine = E9;
        E9Serpentine.AddNewNeighbour(Serpentinethird);
        Field E15Serpentine = E15;
        E15Serpentine.AddNewNeighbour(Serpentinethird);
        Field E22Serpentine = E22;
        E22Serpentine.AddNewNeighbour(Serpentinethird);
        Serpentinethird.addNeighbour(E4Serpentine);
        Serpentinethird.addNeighbour(E9Serpentine);
        Serpentinethird.addNeighbour(E15Serpentine);
        Serpentinethird.addNeighbour(E22Serpentine);
        Serpentinethird.addNeighbour(G16);
        Serpentinethird.addNeighbour(G10);
        Serpentinethird.addNeighbour(G5);
        Serpentinethird.addNeighbour(G1);

        Field G16Serpentine = G16;
        G16Serpentine.AddNewNeighbour(Serpentinefourth);
        Field G23Serpentine = G23;
        G23Serpentine.AddNewNeighbour(Serpentinefourth);
        Field G29Serpentine = G29;
        G29Serpentine.AddNewNeighbour(Serpentinefourth);
        Field G34Serpentine = G34;
        G34Serpentine.AddNewNeighbour(Serpentinefourth);
        Serpentinefourth.addNeighbour(G16Serpentine);
        Serpentinefourth.addNeighbour(G23Serpentine);
        Serpentinefourth.addNeighbour(G29Serpentine);
        Serpentinefourth.addNeighbour(G34Serpentine);
        Serpentinefourth.addNeighbour(J37);
        Serpentinefourth.addNeighbour(J36);
        Serpentinefourth.addNeighbour(J35);
        Serpentinefourth.addNeighbour(J34);

        Field J22Serpentine = J22;
        J22Serpentine.AddNewNeighbour(Serpentinefifth);
        Field J15Serpentine = J15;
        J15Serpentine.AddNewNeighbour(Serpentinefifth);
        Field J9Serpentine = J9;
        J9Serpentine.AddNewNeighbour(Serpentinefifth);
        Field J4Serpentine = J4;
        J4Serpentine.AddNewNeighbour(Serpentinefifth);
        Serpentinefifth.addNeighbour(J22Serpentine);
        Serpentinefifth.addNeighbour(J15Serpentine);
        Serpentinefifth.addNeighbour(J9Serpentine);
        Serpentinefifth.addNeighbour(J4Serpentine);
        Serpentinefifth.addNeighbour(M1);
        Serpentinefifth.addNeighbour(M2);
        Serpentinefifth.addNeighbour(M3);
        Serpentinefifth.addNeighbour(M4);

        Field EDBlue1 = new Field(1, "Blue", true, "EDBlue1");
        Field EDBlue2 = new Field(1, "Blue", true, "EDBlue2");
        Field EDBlue3 = new Field(1, "Blue", true, "EDBlue3");

        Field M29Serpentine = M29;
        M29Serpentine.AddNewNeighbour(EDBlue1);
        Field M34Serpentine = M34;
        M34Serpentine.AddNewNeighbour(EDBlue1, EDBlue2, EDBlue3);
        Field M35Serpentine = M35;
        M35Serpentine.AddNewNeighbour(EDBlue3);





            SerpentineFields.add(A1);
            SerpentineFields.add(A2);
            SerpentineFields.add(A3);
            SerpentineFields.add(A4);
            SerpentineFields.add(A5);
            SerpentineFields.add(A6);
            SerpentineFields.add(A7);
            SerpentineFields.add(A8);
            SerpentineFields.add(A9);
            SerpentineFields.add(A10);
            SerpentineFields.add(A11);
            SerpentineFields.add(A12);
            SerpentineFields.add(A13);
            SerpentineFields.add(A14);
            SerpentineFields.add(A15);
            SerpentineFields.add(A16);
            SerpentineFields.add(A17);
            SerpentineFields.add(A18);
            SerpentineFields.add(A19);
            SerpentineFields.add(A20);
            SerpentineFields.add(A21);
            SerpentineFields.add(A22Serpentine);
            SerpentineFields.add(A23);
            SerpentineFields.add(A24);
            SerpentineFields.add(A25);
            SerpentineFields.add(A26);
            SerpentineFields.add(A27);
            SerpentineFields.add(A28Serpentine);
            SerpentineFields.add(A29);
            SerpentineFields.add(A30);
            SerpentineFields.add(A31);
            SerpentineFields.add(A32);
            SerpentineFields.add(A33Serpentine);
            SerpentineFields.add(A34);
            SerpentineFields.add(A35);
            SerpentineFields.add(A36);
            SerpentineFields.add(A37Serpentine);
            SerpentineFields.add(C1);
            SerpentineFields.add(C2);
            SerpentineFields.add(C3);
            SerpentineFields.add(C4);
            SerpentineFields.add(C5);
            SerpentineFields.add(C6);
            SerpentineFields.add(C7);
            SerpentineFields.add(C8);
            SerpentineFields.add(C9);
            SerpentineFields.add(C10);
            SerpentineFields.add(C11);
            SerpentineFields.add(C12);
            SerpentineFields.add(C13);
            SerpentineFields.add(C14);
            SerpentineFields.add(C15);
            SerpentineFields.add(C16Serpentine);
            SerpentineFields.add(C17);
            SerpentineFields.add(C18);
            SerpentineFields.add(C19);
            SerpentineFields.add(C20);
            SerpentineFields.add(C21);
            SerpentineFields.add(C22);
            SerpentineFields.add(C23Serpentine);
            SerpentineFields.add(C24);
            SerpentineFields.add(C25);
            SerpentineFields.add(C26);
            SerpentineFields.add(C27);
            SerpentineFields.add(C28);
            SerpentineFields.add(C29Serpentine);
            SerpentineFields.add(C30);
            SerpentineFields.add(C31);
            SerpentineFields.add(C32);
            SerpentineFields.add(C33);
            SerpentineFields.add(C34Serpentine);
            SerpentineFields.add(C35);
            SerpentineFields.add(C36);
            SerpentineFields.add(C37);
            SerpentineFields.add(E1);
            SerpentineFields.add(E2);
            SerpentineFields.add(E3);
            SerpentineFields.add(E4Serpentine);
            SerpentineFields.add(E5);
            SerpentineFields.add(E6);
            SerpentineFields.add(E7);
            SerpentineFields.add(E8);
            SerpentineFields.add(E9Serpentine);
            SerpentineFields.add(E10);
            SerpentineFields.add(E11);
            SerpentineFields.add(E12);
            SerpentineFields.add(E13);
            SerpentineFields.add(E14);
            SerpentineFields.add(E15Serpentine);
            SerpentineFields.add(E16);
            SerpentineFields.add(E17);
            SerpentineFields.add(E18);
            SerpentineFields.add(E19);
            SerpentineFields.add(E20);
            SerpentineFields.add(E21);
            SerpentineFields.add(E22Serpentine);
            SerpentineFields.add(E23);
            SerpentineFields.add(E24);
            SerpentineFields.add(E25);
            SerpentineFields.add(E26);
            SerpentineFields.add(E27);
            SerpentineFields.add(E28);
            SerpentineFields.add(E29);
            SerpentineFields.add(E30);
            SerpentineFields.add(E31);
            SerpentineFields.add(E32);
            SerpentineFields.add(E33);
            SerpentineFields.add(E34);
            SerpentineFields.add(E35);
            SerpentineFields.add(E36);
            SerpentineFields.add(E37);
            SerpentineFields.add(G1);
            SerpentineFields.add(G2);
            SerpentineFields.add(G3);
            SerpentineFields.add(G4);
            SerpentineFields.add(G5);
            SerpentineFields.add(G6);
            SerpentineFields.add(G7);
            SerpentineFields.add(G8);
            SerpentineFields.add(G9);
            SerpentineFields.add(G10);
            SerpentineFields.add(G11);
            SerpentineFields.add(G12);
            SerpentineFields.add(G13);
            SerpentineFields.add(G14);
            SerpentineFields.add(G15);
            SerpentineFields.add(G16Serpentine);
            SerpentineFields.add(G17);
            SerpentineFields.add(G18);
            SerpentineFields.add(G19);
            SerpentineFields.add(G20);
            SerpentineFields.add(G21);
            SerpentineFields.add(G22);
            SerpentineFields.add(G23Serpentine);
            SerpentineFields.add(G24);
            SerpentineFields.add(G25);
            SerpentineFields.add(G26);
            SerpentineFields.add(G27);
            SerpentineFields.add(G28);
            SerpentineFields.add(G29Serpentine);
            SerpentineFields.add(G30);
            SerpentineFields.add(G31);
            SerpentineFields.add(G32);
            SerpentineFields.add(G33);
            SerpentineFields.add(G34Serpentine);
            SerpentineFields.add(G35);
            SerpentineFields.add(G36);
            SerpentineFields.add(G37);
            SerpentineFields.add(J1);
            SerpentineFields.add(J2);
            SerpentineFields.add(J3);
            SerpentineFields.add(J4Serpentine);
            SerpentineFields.add(J5);
            SerpentineFields.add(J6);
            SerpentineFields.add(J7);
            SerpentineFields.add(J8);
            SerpentineFields.add(J9Serpentine);
            SerpentineFields.add(J10);
            SerpentineFields.add(J11);
            SerpentineFields.add(J12);
            SerpentineFields.add(J13);
            SerpentineFields.add(J14);
            SerpentineFields.add(J15Serpentine);
            SerpentineFields.add(J16);
            SerpentineFields.add(J17);
            SerpentineFields.add(J18);
            SerpentineFields.add(J19);
            SerpentineFields.add(J20);
            SerpentineFields.add(J21);
            SerpentineFields.add(J22Serpentine);
            SerpentineFields.add(J23);
            SerpentineFields.add(J24);
            SerpentineFields.add(J25);
            SerpentineFields.add(J26);
            SerpentineFields.add(J27);
            SerpentineFields.add(J28);
            SerpentineFields.add(J29);
            SerpentineFields.add(J30);
            SerpentineFields.add(J31);
            SerpentineFields.add(J32);
            SerpentineFields.add(J33);
            SerpentineFields.add(J34);
            SerpentineFields.add(J35);
            SerpentineFields.add(J36);
            SerpentineFields.add(J37);
            SerpentineFields.add(M1);
            SerpentineFields.add(M2);
            SerpentineFields.add(M3);
            SerpentineFields.add(M4);
            SerpentineFields.add(M5);
            SerpentineFields.add(M6);
            SerpentineFields.add(M7);
            SerpentineFields.add(M8);
            SerpentineFields.add(M9);
            SerpentineFields.add(M10);
            SerpentineFields.add(M11);
            SerpentineFields.add(M12);
            SerpentineFields.add(M13);
            SerpentineFields.add(M14);
            SerpentineFields.add(M15);
            SerpentineFields.add(M16);
            SerpentineFields.add(M17);
            SerpentineFields.add(M18);
            SerpentineFields.add(M19);
            SerpentineFields.add(M20);
            SerpentineFields.add(M21);
            SerpentineFields.add(M22);
            SerpentineFields.add(M23);
            SerpentineFields.add(M24);
            SerpentineFields.add(M25);
            SerpentineFields.add(M26);
            SerpentineFields.add(M27);
            SerpentineFields.add(M28);
            SerpentineFields.add(M29Serpentine);
            SerpentineFields.add(M30);
            SerpentineFields.add(M31);
            SerpentineFields.add(M32);
            SerpentineFields.add(M33);
            SerpentineFields.add(M34Serpentine);
            SerpentineFields.add(M35Serpentine);
            SerpentineFields.add(M36);
            SerpentineFields.add(M37);
            SerpentineFields.add(EDBlue1);
            SerpentineFields.add(EDBlue2);
            SerpentineFields.add(EDBlue3);
        }


    public void setupSwamplands() {

        Field R1 = new Field(1, "Yellow", true, "R1");
        Field R2 = new Field(1, "Yellow", true, "R2");
        Field R3 = new Field(0, "Cave", false, "R3");
        Field R4 = new Field(1, "Green", true, "R4");
        Field R5 = new Field(1, "Green", true, "R5");
        Field R6 = new Field(1, "Yellow", true, "R6");
        Field R7 = new Field(1, "Camp", true, "R7");
        Field R8 = new Field(1, "Yellow", true, "R8");
        Field R9 = new Field(0, "Cave", false, "R9");
        Field R10 = new Field(3, "Green", true, "R10");
        Field R11 = new Field(1, "Green", true, "R11");
        Field R12 = new Field(1, "Yellow", true, "R12");
        Field R13 = new Field(1, "Yellow", true, "R13");
        Field R14 = new Field(0, "Cave", false, "R14");
        Field R15 = new Field(1, "Green", true, "R15");
        Field R16 = new Field(1, "Green", true, "R16");
        R1.AddNewNeighbour(R2, R6, R7);
        R2.AddNewNeighbour(R1, R8, R7, R3);
        R3.AddNewNeighbour(R2, R9, R8, R4);
        R4.AddNewNeighbour(R3, R5, R9, R10);
        R5.AddNewNeighbour(R4, R10, R11);
        R6.AddNewNeighbour(R1, R7, R12);
        R7.AddNewNeighbour(R1, R6, R12, R13, R8, R2);
        R8.AddNewNeighbour(R3, R2, R7, R14, R13, R9);
        R9.AddNewNeighbour(R3, R4, R15, R14, R8, R10);
        R10.AddNewNeighbour(R5, R4, R16, R15, R9, R11);
        R11.AddNewNeighbour(R5, R16, R10);
        R12.AddNewNeighbour(R6, R7, R13);
        R13.AddNewNeighbour(R7, R8, R14, R12);
        R14.AddNewNeighbour(R8, R9, R15, R13);
        R15.AddNewNeighbour(R9, R10, R16, R14);
        R16.AddNewNeighbour(R10, R15, R11);

        Field O1 = new Field(2, "Yellow", true, "O1");
        Field O2 = new Field(1, "Yellow", true, "O2");
        Field O3 = new Field(1, "White", true, "O3");
        Field O4 = new Field(2, "Green", true, "O4");
        Field O5 = new Field(2, "White", true, "O5");
        Field O6 = new Field(1, "Yellow", true, "O6");
        Field O7 = new Field(0, "Cave", false, "O7");
        Field O8 = new Field(4, "Blue", true, "O8");
        Field O9 = new Field(0, "Cave", false, "O9");
        Field O10 = new Field(0, "Cave", false, "O10");
        Field O11 = new Field(1, "White", true, "O11");
        Field O12 = new Field(1, "Yellow", true, "O12");
        Field O13 = new Field(1, "Blue", true, "O13");
        Field O14 = new Field(2, "Green", true, "O14");
        Field O15 = new Field(1, "Green", true, "O15");
        Field O16 = new Field(1, "White", true, "O16");
        O1.AddNewNeighbour(O2, O6, O7);
        O2.AddNewNeighbour(O1, O8, O7, O3);
        O3.AddNewNeighbour(O2, O9, O8, O4);
        O4.AddNewNeighbour(O3, O5, O9, O10);
        O5.AddNewNeighbour(O4, O10, O11);
        O6.AddNewNeighbour(O1, O7, O12);
        O7.AddNewNeighbour(O1, O6, O12, O13, O8, O2);
        O8.AddNewNeighbour(O3, O2, O7, O14, O13, O9);
        O9.AddNewNeighbour(O3, O4, O15, O14, O8, O10);
        O10.AddNewNeighbour(O5, O4, O16, O15, O9, O11);
        O11.AddNewNeighbour(O5, O16, O10);
        O12.AddNewNeighbour(O6, O7, O13);
        O13.AddNewNeighbour(O7, O8, O14, O12);
        O14.AddNewNeighbour(O8, O9, O15, O13);
        O15.AddNewNeighbour(O9, O10, O16, O14);
        O16.AddNewNeighbour(O10, O15, O11);

        Field D1 = new Field(2, "Green", true, "D1");
        Field D2 = new Field(1, "Green", true, "D2");
        Field D3 = new Field(1, "Green", true, "D3");
        Field D4 = new Field(2, "Green", true, "D4");
        Field D5 = new Field(1, "Green", true, "D5");
        Field D6 = new Field(1, "Green", true, "D6");
        Field D7 = new Field(1, "Blue", true, "D7");
        Field D8 = new Field(1, "Blue", true, "D8");
        Field D9 = new Field(1, "Green", true, "D9");
        Field D10 = new Field(0, "Cave", false, "D10");
        Field D11 = new Field(3, "Yellow", true, "D11");
        Field D12 = new Field(1, "Green", true, "D12");
        Field D13 = new Field(2, "Blue", true, "D13");
        Field D14 = new Field(1, "Blue", true, "D14");
        Field D15 = new Field(1, "Green", true, "D15");
        Field D16 = new Field(3, "Blue", true, "D16");
        Field D17 = new Field(1, "Yellow", true, "D17");
        Field D18 = new Field(0, "Cave", false, "D18");
        Field D19 = new Field(0, "Cave", false, "D19");
        Field D20 = new Field(1, "Blue", true, "D20");
        Field D21 = new Field(1, "Blue", true, "D21");
        Field D22 = new Field(1, "Green", true, "D22");
        Field D23 = new Field(0, "Cave", false, "D23");
        Field D24 = new Field(3, "Yellow", true, "D24");
        Field D25 = new Field(1, "Green", true, "D25");
        Field D26 = new Field(2, "Blue", true, "D26");
        Field D27 = new Field(1, "Blue", true, "D27");
        Field D28 = new Field(1, "Green", true, "D28");
        Field D29 = new Field(1, "Green", true, "D29");
        Field D30 = new Field(1, "Green", true, "D30");
        Field D31 = new Field(1, "Blue", true, "D31");
        Field D32 = new Field(1, "Blue", true, "D32");
        Field D33 = new Field(1, "Green", true, "D33");
        Field D34 = new Field(2, "Green", true, "D34");
        Field D35 = new Field(1, "Green", true, "D35");
        Field D36 = new Field(1, "Green", true, "D36");
        Field D37 = new Field(2, "Green", true, "D37");
        D1.AddNewNeighbour(D2, D5, D6);
        D2.AddNewNeighbour(D1, D6, D7, D3);
        D3.AddNewNeighbour(D2, D7, D8, D4);
        D4.AddNewNeighbour(D3, D8, D9);
        D5.AddNewNeighbour(D1, D6, D10, D11);
        D6.AddNewNeighbour(D1, D2, D7, D12, D11, D5);
        D7.AddNewNeighbour(D2, D3, D8, D13, D12, D6);
        D8.AddNewNeighbour(D3, D4, D9, D14, D13, D7);
        D9.AddNewNeighbour(D4, D15, D14, D8);
        D10.AddNewNeighbour(D5, D11, D17, D16);
        D11.AddNewNeighbour(D5, D6, D12, D18, D17, D10);
        D12.AddNewNeighbour(D6, D7, D13, D19, D18, D11);
        D13.AddNewNeighbour(D7, D8, D14, D20, D19, D12);
        D14.AddNewNeighbour(D8, D9, D15, D21, D20, D13);
        D15.AddNewNeighbour(D9, D22, D21, D14);
        D16.AddNewNeighbour(D10, D17, D23);
        D17.AddNewNeighbour(D10, D11, D18, D24, D23, D16);
        D18.AddNewNeighbour(D11, D12, D19, D25, D24, D17);
        D19.AddNewNeighbour(D12, D13, D20, D26, D25, D18);
        D20.AddNewNeighbour(D13, D14, D21, D27, D26, D19);
        D21.AddNewNeighbour(D14, D15, D22, D28, D27, D20);
        D22.AddNewNeighbour(D15, D28, D21);
        D23.AddNewNeighbour(D16, D17, D24, D29);
        D24.AddNewNeighbour(D17, D18, D25, D30, D29, D23);
        D25.AddNewNeighbour(D18, D19, D26, D31, D30, D24);
        D26.AddNewNeighbour(D19, D20, D27, D32, D32, D25);
        D27.AddNewNeighbour(D20, D21, D28, D33, D32, D26);
        D28.AddNewNeighbour(D21, D22, D33, D27);
        D29.AddNewNeighbour(D23, D24, D30, D34);
        D30.AddNewNeighbour(D24, D25, D31, D35, D34, D29);
        D31.AddNewNeighbour(D25, D26, D32, D36, D35, D30);
        D32.AddNewNeighbour(D26, D27, D33, D37, D36, D31);
        D33.AddNewNeighbour(D27, D28, D37, D32);
        D34.AddNewNeighbour(D29, D30, D35);
        D35.AddNewNeighbour(D34, D30, D31, D36);
        D36.AddNewNeighbour(D35, D31, D32, D37);
        D37.AddNewNeighbour(D36, D32, D33);

        Field H1 = new Field(2, "Green", true, "H1");
        Field H2 = new Field(2, "Green", true, "H2");
        Field H3 = new Field(2, "Green", true, "H3");
        Field H4 = new Field(1, "Green", true, "H4");
        Field H5 = new Field(2, "Green", true, "H5");
        Field H6 = new Field(1, "Green", true, "H6");
        Field H7 = new Field(1, "Green", true, "H7");
        Field H8 = new Field(1, "Green", true, "H8");
        Field H9 = new Field(1, "Yellow", true, "H9");
        Field H10 = new Field(2, "Green", true, "H10");
        Field H11 = new Field(1, "Green", true, "H11");
        Field H12 = new Field(1, "Yellow", true, "H12");
        Field H13 = new Field(1, "Yellow", true, "H13");
        Field H14 = new Field(2, "Yellow", true, "H14");
        Field H15 = new Field(2, "Yellow", true, "H15");
        Field H16 = new Field(1, "Green", true, "H16");
        Field H17 = new Field(1, "Green", true, "H17");
        Field H18 = new Field(1, "Yellow", true, "H18");
        Field H19 = new Field(2, "Yellow", true, "H19");
        Field H20 = new Field(2, "Yellow", true, "H20");
        Field H21 = new Field(0, "Cave", false, "H21");
        Field H22 = new Field(3, "Yellow", true, "H22");
        Field H23 = new Field(2, "Blue", true, "H23");
        Field H24 = new Field(1, "Blue", true, "H24");
        Field H25 = new Field(1, "Yellow", true, "H25");
        Field H26 = new Field(1, "Yellow", true, "H26");
        Field H27 = new Field(2, "Yellow", true, "H27");
        Field H28 = new Field(2, "Yellow", true, "H28");
        Field H29 = new Field(2, "Blue", true, "H29");
        Field H30 = new Field(1, "Blue", true, "H30");
        Field H31 = new Field(1, "Blue", true, "H31");
        Field H32 = new Field(1, "Blue", true, "H32");
        Field H33 = new Field(1, "Yellow", true, "H33");
        Field H34 = new Field(2, "Blue", true, "H34");
        Field H35 = new Field(2, "Blue", true, "H35");
        Field H36 = new Field(2, "Blue", true, "H36");
        Field H37 = new Field(1, "Blue", true, "H37");
        H1.AddNewNeighbour(H2, H5, H6);
        H2.AddNewNeighbour(H1, H6, H7, H3);
        H3.AddNewNeighbour(H2, H7, H8, H4);
        H4.AddNewNeighbour(H3, H8, H9);
        H5.AddNewNeighbour(H1, H6, H10, H11);
        H6.AddNewNeighbour(H1, H2, H7, H12, H11, H5);
        H7.AddNewNeighbour(H2, H3, H8, H13, H12, H6);
        H8.AddNewNeighbour(H3, H4, H9, H14, H13, H7);
        H9.AddNewNeighbour(H4, H15, H14, H8);
        H10.AddNewNeighbour(H5, H11, H17, H16);
        H11.AddNewNeighbour(H5, H6, H12, H18, H17, H10);
        H12.AddNewNeighbour(H6, H7, H13, H19, H18, H11);
        H13.AddNewNeighbour(H7, H8, H14, H20, H19, H12);
        H14.AddNewNeighbour(H8, H9, H15, H21, H20, H13);
        H15.AddNewNeighbour(H9, H22, H21, H14);
        H16.AddNewNeighbour(H10, H17, H23);
        H17.AddNewNeighbour(H10, H11, H18, H24, H23, H16);
        H18.AddNewNeighbour(H11, H12, H19, H25, H24, H17);
        H19.AddNewNeighbour(H12, H13, H20, H26, H25, H18);
        H20.AddNewNeighbour(H13, H14, H21, H27, H26, H19);
        H21.AddNewNeighbour(H14, H15, H22, H28, H27, H20);
        H22.AddNewNeighbour(H15, H28, H21);
        H23.AddNewNeighbour(H16, H17, H24, H29);
        H24.AddNewNeighbour(H17, H18, H25, H30, H29, H23);
        H25.AddNewNeighbour(H18, H19, H26, H31, H30, H24);
        H26.AddNewNeighbour(H19, H20, H27, H32, H32, H25);
        H27.AddNewNeighbour(H20, H21, H28, H33, H32, H26);
        H28.AddNewNeighbour(H21, H22, H33, H27);
        H29.AddNewNeighbour(H23, H24, H30, H34);
        H30.AddNewNeighbour(H24, H25, H31, H35, H34, H29);
        H31.AddNewNeighbour(H25, H26, H32, H36, H35, H30);
        H32.AddNewNeighbour(H26, H27, H33, H37, H36, H31);
        H33.AddNewNeighbour(H27, H28, H37, H32);
        H34.AddNewNeighbour(H29, H30, H35);
        H35.AddNewNeighbour(H34, H30, H31, H36);
        H36.AddNewNeighbour(H35, H31, H32, H37);
        H37.AddNewNeighbour(H36, H32, H33);

        Field A1 = new Field(0, "Green", true, "A1");
        Field A2 = new Field(0, "Green", true, "A2");
        Field A3 = new Field(0, "Green", true, "A3");
        Field A4 = new Field(0, "Green", true, "A4");
        Field A5 = new Field(1, "Green", true, "A5");
        Field A6 = new Field(1, "Green", true, "A6");
        Field A7 = new Field(1, "Green", true, "A7");
        Field A8 = new Field(1, "Green", true, "A8");
        Field A9 = new Field(1, "Green", true, "A9");
        Field A10 = new Field(1, "Green", true, "A10");
        Field A11 = new Field(1, "Green", true, "A11");
        Field A12 = new Field(1, "Yellow", true, "A12");
        Field A13 = new Field(1, "Green", true, "A13");
        Field A14 = new Field(1, "Blue", true, "A14");
        Field A15 = new Field(1, "Green", true, "A15");
        Field A16 = new Field(1, "Green", true, "A16");
        Field A17 = new Field(1, "Yellow", true, "A17");
        Field A18 = new Field(1, "Green", true, "A18");
        Field A19 = new Field(1, "Blue", true, "A19");
        Field A20 = new Field(1, "Green", true, "A20");
        Field A21 = new Field(1, "Yellow", true, "A21");
        Field A22 = new Field(1, "Green", true, "A22");
        Field A23 = new Field(1, "Green", true, "A23");
        Field A24 = new Field(0, "Cave", false, "A24");
        Field A25 = new Field(1, "Yellow", true, "A25");
        Field A26 = new Field(1, "Green", true, "A26");
        Field A27 = new Field(1, "Green", true, "A27");
        Field A28 = new Field(1, "Green", true, "A28");
        Field A29 = new Field(1, "Blue", true, "A29");
        Field A30 = new Field(0, "Cave", false, "A30");
        Field A31 = new Field(1, "Green", true, "A31");
        Field A32 = new Field(1, "Green", true, "A32");
        Field A33 = new Field(1, "Yellow", true, "A33");
        Field A34 = new Field(1, "Green", true, "A34");
        Field A35 = new Field(1, "Camp", true, "A35");
        Field A36 = new Field(1, "Green", true, "A36");
        Field A37 = new Field(1, "Green", true, "A37");
        A1.AddNewNeighbour(A2, A5, A6);
        A2.AddNewNeighbour(A1, A6, A7, A3);
        A3.AddNewNeighbour(A2, A7, A8, A4);
        A4.AddNewNeighbour(A3, A8, A9);
        A5.AddNewNeighbour(A1, A6, A10, A11);
        A6.AddNewNeighbour(A1, A2, A7, A12, A11, A5);
        A7.AddNewNeighbour(A2, A3, A8, A13, A12, A6);
        A8.AddNewNeighbour(A3, A4, A9, A14, A13, A7);
        A9.AddNewNeighbour(A4, A15, A14, A8);
        A10.AddNewNeighbour(A5, A11, A17, A16);
        A11.AddNewNeighbour(A5, A6, A12, A18, A17, A10);
        A12.AddNewNeighbour(A6, A7, A13, A19, A18, A11);
        A13.AddNewNeighbour(A7, A8, A14, A20, A19, A12);
        A14.AddNewNeighbour(A8, A9, A15, A21, A20, A13);
        A15.AddNewNeighbour(A9, A22, A21, A14);
        A16.AddNewNeighbour(A10, A17, A23);
        A17.AddNewNeighbour(A10, A11, A18, A24, A23, A16);
        A18.AddNewNeighbour(A11, A12, A19, A25, A24, A17);
        A19.AddNewNeighbour(A12, A13, A20, A26, A25, A18);
        A20.AddNewNeighbour(A13, A14, A21, A27, A26, A19);
        A21.AddNewNeighbour(A14, A15, A22, A28, A27, A20);
        A22.AddNewNeighbour(A15, A28, A21);
        A23.AddNewNeighbour(A16, A17, A24, A29);
        A24.AddNewNeighbour(A17, A18, A25, A30, A29, A23);
        A25.AddNewNeighbour(A18, A19, A26, A31, A30, A24);
        A26.AddNewNeighbour(A19, A20, A27, A32, A32, A25);
        A27.AddNewNeighbour(A20, A21, A28, A33, A32, A26);
        A28.AddNewNeighbour(A21, A22, A33, A27);
        A29.AddNewNeighbour(A23, A24, A30, A34);
        A30.AddNewNeighbour(A24, A25, A31, A35, A34, A29);
        A31.AddNewNeighbour(A25, A26, A32, A36, A35, A30);
        A32.AddNewNeighbour(A26, A27, A33, A37, A36, A31);
        A33.AddNewNeighbour(A27, A28, A37, A32);
        A34.AddNewNeighbour(A29, A30, A35);
        A35.AddNewNeighbour(A34, A30, A31, A36);
        A36.AddNewNeighbour(A35, A31, A32, A37);
        A37.AddNewNeighbour(A36, A32, A33);

        Field E1 = new Field(1, "Green", true, "E1");
        Field E2 = new Field(1, "White", true, "E2");
        Field E3 = new Field(1, "White", true, "E3");
        Field E4 = new Field(0, "Cave", false, "E4");
        Field E5 = new Field(1, "Green", true, "E5");
        Field E6 = new Field(2, "Blue", true, "E6");
        Field E7 = new Field(2, "Green", true, "E7");
        Field E8 = new Field(0, "Cave", false, "E8");
        Field E9 = new Field(1, "White", true, "E9");
        Field E10 = new Field(1, "Green", true, "E10");
        Field E11 = new Field(0, "Cave", false, "E11");
        Field E12 = new Field(1, "White", true, "E12");
        Field E13 = new Field(3, "White", true, "E13");
        Field E14 = new Field(1, "White", true, "E14");
        Field E15 = new Field(1, "Green", true, "E15");
        Field E16 = new Field(1, "White", true, "E16");
        Field E17 = new Field(2, "Green", true, "E17");
        Field E18 = new Field(1, "Green", true, "E18");
        Field E19 = new Field(1, "Blue", true, "E19");
        Field E20 = new Field(3, "Green", true, "E20");
        Field E21 = new Field(2, "Green", true, "E21");
        Field E22 = new Field(1, "Green", true, "E22");
        Field E23 = new Field(1, "Green", true, "E23");
        Field E24 = new Field(1, "Blue", true, "E24");
        Field E25 = new Field(1, "Blue", true, "E25");
        Field E26 = new Field(0, "Cave", false, "E26");
        Field E27 = new Field(1, "Green", true, "E27");
        Field E28 = new Field(1, "White", true, "E28");
        Field E29 = new Field(1, "Yellow", true, "E29");
        Field E30 = new Field(0, "Cave", false, "E30");
        Field E31 = new Field(1, "Green", true, "E31");
        Field E32 = new Field(2, "Green", true, "E32");
        Field E33 = new Field(1, "Green", true, "E33");
        Field E34 = new Field(1, "Yellow", true, "E34");
        Field E35 = new Field(1, "Yellow", true, "E35");
        Field E36 = new Field(1, "Yellow", true, "E36");
        Field E37 = new Field(1, "Camp", true, "E37");
        E1.AddNewNeighbour(E2, E5, E6);
        E2.AddNewNeighbour(E1, E6, E7, E3);
        E3.AddNewNeighbour(E2, E7, E8, E4);
        E4.AddNewNeighbour(E3, E8, E9);
        E5.AddNewNeighbour(E1, E6, E10, E11);
        E6.AddNewNeighbour(E1, E2, E7, E12, E11, E5);
        E7.AddNewNeighbour(E2, E3, E8, E13, E12, E6);
        E8.AddNewNeighbour(E3, E4, E9, E14, E13, E7);
        E9.AddNewNeighbour(E4, E15, E14, E8);
        E10.AddNewNeighbour(E5, E11, E17, E16);
        E11.AddNewNeighbour(E5, E6, E12, E18, E17, E10);
        E12.AddNewNeighbour(E6, E7, E13, E19, E18, E11);
        E13.AddNewNeighbour(E7, E8, E14, E20, E19, E12);
        E14.AddNewNeighbour(E8, E9, E15, E21, E20, E13);
        E15.AddNewNeighbour(E9, E22, E21, E14);
        E16.AddNewNeighbour(E10, E17, E23);
        E17.AddNewNeighbour(E10, E11, E18, E24, E23, E16);
        E18.AddNewNeighbour(E11, E12, E19, E25, E24, E17);
        E19.AddNewNeighbour(E12, E13, E20, E26, E25, E18);
        E20.AddNewNeighbour(E13, E14, E21, E27, E26, E19);
        E21.AddNewNeighbour(E14, E15, E22, E28, E27, E20);
        E22.AddNewNeighbour(E15, E28, E21);
        E23.AddNewNeighbour(E16, E17, E24, E29);
        E24.AddNewNeighbour(E17, E18, E25, E30, E29, E23);
        E25.AddNewNeighbour(E18, E19, E26, E31, E30, E24);
        E26.AddNewNeighbour(E19, E20, E27, E32, E32, E25);
        E27.AddNewNeighbour(E20, E21, E28, E33, E32, E26);
        E28.AddNewNeighbour(E21, E22, E33, E27);
        E29.AddNewNeighbour(E23, E24, E30, E34);
        E30.AddNewNeighbour(E24, E25, E31, E35, E34, E29);
        E31.AddNewNeighbour(E25, E26, E32, E36, E35, E30);
        E32.AddNewNeighbour(E26, E27, E33, E37, E36, E31);
        E33.AddNewNeighbour(E27, E28, E37, E32);
        E34.AddNewNeighbour(E29, E30, E35);
        E35.AddNewNeighbour(E34, E30, E31, E36);
        E36.AddNewNeighbour(E35, E31, E32, E37);
        E37.AddNewNeighbour(E36, E32, E33);

        Field K1 = new Field(1, "Green", true, "K1");
        Field K2 = new Field(2, "Green", true, "K2");
        Field K3 = new Field(2, "Green", true, "K3");
        Field K4 = new Field(2, "Green", true, "K4");
        Field K5 = new Field(2, "Green", true, "K5");
        Field K6 = new Field(1, "Green", true, "K6");
        Field K7 = new Field(1, "Green", true, "K7");
        Field K8 = new Field(1, "Green", true, "K8");
        Field K9 = new Field(1, "Green", true, "K9");
        Field K10 = new Field(2, "Green", true, "K10");
        Field K11 = new Field(4, "Yellow", true, "K11");
        Field K12 = new Field(3, "Green", true, "K12");
        Field K13 = new Field(3, "Green", true, "K13");
        Field K14 = new Field(2, "Green", true, "K14");
        Field K15 = new Field(1, "Green", true, "K15");
        Field K16 = new Field(1, "Camp", true, "K16");
        Field K17 = new Field(1, "Green", true, "K17");
        Field K18 = new Field(1, "Green", true, "K18");
        Field K19 = new Field(1, "Green", true, "K19");
        Field K20 = new Field(1, "Green", true, "K20");
        Field K21 = new Field(1, "Green", true, "K21");
        Field K22 = new Field(1, "Camp", true, "K22");
        Field K23 = new Field(1, "Green", true, "K23");
        Field K24 = new Field(2, "Green", true, "K24");
        Field K25 = new Field(3, "Green", true, "K25");
        Field K26 = new Field(3, "Green", true, "K26");
        Field K27 = new Field(3, "Blue", true, "K27");
        Field K28 = new Field(2, "Green", true, "K28");
        Field K29 = new Field(1, "Green", true, "K29");
        Field K30 = new Field(1, "Green", true, "K30");
        Field K31 = new Field(1, "Green", true, "K31");
        Field K32 = new Field(1, "Green", true, "K32");
        Field K33 = new Field(2, "Green", true, "K33");
        Field K34 = new Field(2, "Green", true, "K34");
        Field K35 = new Field(2, "Green", true, "K35");
        Field K36 = new Field(2, "Green", true, "K36");
        Field K37 = new Field(1, "Green", true, "K37");
        K1.AddNewNeighbour(K2, K5, K6);
        K2.AddNewNeighbour(K1, K6, K7, K3);
        K3.AddNewNeighbour(K2, K7, K8, K4);
        K4.AddNewNeighbour(K3, K8, K9);
        K5.AddNewNeighbour(K1, K6, K10, K11);
        K6.AddNewNeighbour(K1, K2, K7, K12, K11, K5);
        K7.AddNewNeighbour(K2, K3, K8, K13, K12, K6);
        K8.AddNewNeighbour(K3, K4, K9, K14, K13, K7);
        K9.AddNewNeighbour(K4, K15, K14, K8);
        K10.AddNewNeighbour(K5, K11, K17, K16);
        K11.AddNewNeighbour(K5, K6, K12, K18, K17, K10);
        K12.AddNewNeighbour(K6, K7, K13, K19, K18, K11);
        K13.AddNewNeighbour(K7, K8, K14, K20, K19, K12);
        K14.AddNewNeighbour(K8, K9, K15, K21, K20, K13);
        K15.AddNewNeighbour(K9, K22, K21, K14);
        K16.AddNewNeighbour(K10, K17, K23);
        K17.AddNewNeighbour(K10, K11, K18, K24, K23, K16);
        K18.AddNewNeighbour(K11, K12, K19, K25, K24, K17);
        K19.AddNewNeighbour(K12, K13, K20, K26, K25, K18);
        K20.AddNewNeighbour(K13, K14, K21, K27, K26, K19);
        K21.AddNewNeighbour(K14, K15, K22, K28, K27, K20);
        K22.AddNewNeighbour(K15, K28, K21);
        K23.AddNewNeighbour(K16, K17, K24, K29);
        K24.AddNewNeighbour(K17, K18, K25, K30, K29, K23);
        K25.AddNewNeighbour(K18, K19, K26, K31, K30, K24);
        K26.AddNewNeighbour(K19, K20, K27, K32, K32, K25);
        K27.AddNewNeighbour(K20, K21, K28, K33, K32, K26);
        K28.AddNewNeighbour(K21, K22, K33, K27);
        K29.AddNewNeighbour(K23, K24, K30, K34);
        K30.AddNewNeighbour(K24, K25, K31, K35, K34, K29);
        K31.AddNewNeighbour(K25, K26, K32, K36, K35, K30);
        K32.AddNewNeighbour(K26, K27, K33, K37, K36, K31);
        K33.AddNewNeighbour(K27, K28, K37, K32);
        K34.AddNewNeighbour(K29, K30, K35);
        K35.AddNewNeighbour(K34, K30, K31, K36);
        K36.AddNewNeighbour(K35, K31, K32, K37);
        K37.AddNewNeighbour(K36, K32, K33);

        Random rand = new Random();
        int numberOfElements = 6;

        List<Blockade> blockadeList = new ArrayList<>(Blockades);

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(blockadeList.size());
            Blockade randomElement = blockadeList.get(randomIndex);
            blockadeList.remove(randomIndex);
            currentBlockades.add(randomElement);
        }

        currentBlockades.get(0).setName("BK1");
        currentBlockades.get(1).setName("BK2");
        currentBlockades.get(2).setName("BK3");
        currentBlockades.get(3).setName("BK4");
        currentBlockades.get(4).setName("BK5");
        currentBlockades.get(5).setName("BK6");

        removalList = new ArrayList<>(currentBlockades);


        Blockade Swamplandsfirst = currentBlockades.get(0);
        Blockade Swamplandssecond = currentBlockades.get(1);
        Blockade Swamplandsthird = currentBlockades.get(2);
        Blockade Swamplandsfourth = currentBlockades.get(3);
        Blockade Swamplandsfifth = currentBlockades.get(4);
        Blockade Swamplandssixth = currentBlockades.get(5);

        Field A22Swamplands = A22;
        A22Swamplands.AddNewNeighbour(Swamplandsfirst);
        Field A28Swamplands = A28;
        A28Swamplands.AddNewNeighbour(Swamplandsfirst);
        Field A33Swamplands = A33;
        A33Swamplands.AddNewNeighbour(Swamplandsfirst);
        Field A37Swamplands = A37;
        A37Swamplands.AddNewNeighbour(Swamplandsfirst);
        Swamplandsfirst.addNeighbour(A22Swamplands);
        Swamplandsfirst.addNeighbour(A28Swamplands);
        Swamplandsfirst.addNeighbour(A33Swamplands);
        Swamplandsfirst.addNeighbour(A37Swamplands);
        Swamplandsfirst.addNeighbour(R1);
        Swamplandsfirst.addNeighbour(R2);
        Swamplandsfirst.addNeighbour(R3);
        Swamplandsfirst.addNeighbour(R4);
        Swamplandsfirst.addNeighbour(R5);

        Field R12Swamplands = R12;
        R12Swamplands.AddNewNeighbour(Swamplandssecond);
        Field R13Swamplands = R13;
        R13Swamplands.AddNewNeighbour(Swamplandssecond);
        Field R14Swamplands = R14;
        R14Swamplands.AddNewNeighbour(Swamplandssecond);
        Field R15Swamplands = R15;
        R15Swamplands.AddNewNeighbour(Swamplandssecond);
        Field R16Swamplands = R16;
        R16Swamplands.AddNewNeighbour(Swamplandssecond);
        Swamplandssecond.addNeighbour(R12Swamplands);
        Swamplandssecond.addNeighbour(R13Swamplands);
        Swamplandssecond.addNeighbour(R14Swamplands);
        Swamplandssecond.addNeighbour(R15Swamplands);
        Swamplandssecond.addNeighbour(R16Swamplands);
        Swamplandssecond.addNeighbour(D1);
        Swamplandssecond.addNeighbour(D2);
        Swamplandssecond.addNeighbour(D3);
        Swamplandssecond.addNeighbour(D4);

        Field D34Swamplands = D34;
        D34Swamplands.AddNewNeighbour(Swamplandsthird);
        Field D29Swamplands = D29;
        D29Swamplands.AddNewNeighbour(Swamplandsthird);
        Field D23Swamplands = D23;
        D23Swamplands.AddNewNeighbour(Swamplandsthird);
        Field D16Swamplands = D16;
        D16Swamplands.AddNewNeighbour(Swamplandsthird);
        Swamplandsthird.addNeighbour(D34Swamplands);
        Swamplandsthird.addNeighbour(D29Swamplands);
        Swamplandsthird.addNeighbour(D23Swamplands);
        Swamplandsthird.addNeighbour(D16Swamplands);
        Swamplandsthird.addNeighbour(H1);
        Swamplandsthird.addNeighbour(H2);
        Swamplandsthird.addNeighbour(H3);
        Swamplandsthird.addNeighbour(H4);

        Field H34Swamplands = H34;
        H34Swamplands.AddNewNeighbour(Swamplandsfourth);
        Field H35Swamplands = H35;
        H35Swamplands.AddNewNeighbour(Swamplandsfourth);
        Field H36Swamplands = H36;
        H36Swamplands.AddNewNeighbour(Swamplandsfourth);
        Field H37Swamplands = H37;
        H37Swamplands.AddNewNeighbour(Swamplandsfourth);
        Swamplandsfourth.addNeighbour(H34Swamplands);
        Swamplandsfourth.addNeighbour(H35Swamplands);
        Swamplandsfourth.addNeighbour(H36Swamplands);
        Swamplandsfourth.addNeighbour(H37Swamplands);
        Swamplandsfourth.addNeighbour(E4);
        Swamplandsfourth.addNeighbour(E9);
        Swamplandsfourth.addNeighbour(E15);
        Swamplandsfourth.addNeighbour(E22);

        Field E4Swamplands = E4;
        E4Swamplands.AddNewNeighbour(Swamplandsfifth);
        Field E3Swamplands = E3;
        E3Swamplands.AddNewNeighbour(Swamplandsfifth);
        Field E2Swamplands = E2;
        E2Swamplands.AddNewNeighbour(Swamplandsfifth);
        Field E1Swamplands = E1;
        E1Swamplands.AddNewNeighbour(Swamplandsfifth);
        Swamplandsfifth.addNeighbour(E4Swamplands);
        Swamplandsfifth.addNeighbour(E3Swamplands);
        Swamplandsfifth.addNeighbour(E2Swamplands);
        Swamplandsfifth.addNeighbour(E1Swamplands);
        Swamplandsfifth.addNeighbour(O16);
        Swamplandsfifth.addNeighbour(O15);
        Swamplandsfifth.addNeighbour(O14);
        Swamplandsfifth.addNeighbour(O13);
        Swamplandsfifth.addNeighbour(O12);

        Field O5Swamplands = O5;
        O5Swamplands.AddNewNeighbour(Swamplandssixth);
        Field O4Swamplands = O4;
        O4Swamplands.AddNewNeighbour(Swamplandssixth);
        Field O3Swamplands = O3;
        O3Swamplands.AddNewNeighbour(Swamplandssixth);
        Field O2Swamplands = O2;
        O2Swamplands.AddNewNeighbour(Swamplandssixth);
        Field O1Swamplands = O1;
        O1Swamplands.AddNewNeighbour(Swamplandssixth);
        Swamplandssixth.addNeighbour(O5Swamplands);
        Swamplandssixth.addNeighbour(O4Swamplands);
        Swamplandssixth.addNeighbour(O3Swamplands);
        Swamplandssixth.addNeighbour(O2Swamplands);
        Swamplandssixth.addNeighbour(O1Swamplands);
        Swamplandssixth.addNeighbour(K37);
        Swamplandssixth.addNeighbour(K36);
        Swamplandssixth.addNeighbour(K35);
        Swamplandssixth.addNeighbour(K34);

        Field EDBlue1 = new Field(1, "Blue", true, "EDBlue1");
        Field EDBlue2 = new Field(1, "Blue", true, "EDBlue2");
        Field EDBlue3 = new Field(1, "Blue", true, "EDBlue3");

        Field K2Swamplands = K2;
        K2Swamplands.AddNewNeighbour(EDBlue1);
        Field K1Swamplands = K1;
        K1Swamplands.AddNewNeighbour(EDBlue1, EDBlue2, EDBlue3);
        Field K5Swamplands = K5;
        K5Swamplands.AddNewNeighbour(EDBlue3);






            SwamplandsFields.add(A1);
            SwamplandsFields.add(A2);
            SwamplandsFields.add(A3);
            SwamplandsFields.add(A4);
            SwamplandsFields.add(A5);
            SwamplandsFields.add(A6);
            SwamplandsFields.add(A7);
            SwamplandsFields.add(A8);
            SwamplandsFields.add(A9);
            SwamplandsFields.add(A10);
            SwamplandsFields.add(A11);
            SwamplandsFields.add(A12);
            SwamplandsFields.add(A13);
            SwamplandsFields.add(A14);
            SwamplandsFields.add(A15);
            SwamplandsFields.add(A16);
            SwamplandsFields.add(A17);
            SwamplandsFields.add(A18);
            SwamplandsFields.add(A19);
            SwamplandsFields.add(A20);
            SwamplandsFields.add(A21);
            SwamplandsFields.add(A22Swamplands);
            SwamplandsFields.add(A23);
            SwamplandsFields.add(A24);
            SwamplandsFields.add(A25);
            SwamplandsFields.add(A26);
            SwamplandsFields.add(A27);
            SwamplandsFields.add(A28Swamplands);
            SwamplandsFields.add(A29);
            SwamplandsFields.add(A30);
            SwamplandsFields.add(A31);
            SwamplandsFields.add(A32);
            SwamplandsFields.add(A33Swamplands);
            SwamplandsFields.add(A34);
            SwamplandsFields.add(A35);
            SwamplandsFields.add(A36);
            SwamplandsFields.add(A37Swamplands);
            SwamplandsFields.add(R1);
            SwamplandsFields.add(R2);
            SwamplandsFields.add(R3);
            SwamplandsFields.add(R4);
            SwamplandsFields.add(R5);
            SwamplandsFields.add(R6);
            SwamplandsFields.add(R7);
            SwamplandsFields.add(R8);
            SwamplandsFields.add(R9);
            SwamplandsFields.add(R10);
            SwamplandsFields.add(R11);
            SwamplandsFields.add(R12Swamplands);
            SwamplandsFields.add(R13Swamplands);
            SwamplandsFields.add(R14Swamplands);
            SwamplandsFields.add(R15Swamplands);
            SwamplandsFields.add(R16Swamplands);
            SwamplandsFields.add(D1);
            SwamplandsFields.add(D2);
            SwamplandsFields.add(D3);
            SwamplandsFields.add(D4);
            SwamplandsFields.add(D5);
            SwamplandsFields.add(D6);
            SwamplandsFields.add(D7);
            SwamplandsFields.add(D8);
            SwamplandsFields.add(D9);
            SwamplandsFields.add(D10);
            SwamplandsFields.add(D11);
            SwamplandsFields.add(D12);
            SwamplandsFields.add(D13);
            SwamplandsFields.add(D14);
            SwamplandsFields.add(D15);
            SwamplandsFields.add(D16Swamplands);
            SwamplandsFields.add(D17);
            SwamplandsFields.add(D18);
            SwamplandsFields.add(D19);
            SwamplandsFields.add(D20);
            SwamplandsFields.add(D21);
            SwamplandsFields.add(D22);
            SwamplandsFields.add(D23Swamplands);
            SwamplandsFields.add(D24);
            SwamplandsFields.add(D25);
            SwamplandsFields.add(D26);
            SwamplandsFields.add(D27);
            SwamplandsFields.add(D28);
            SwamplandsFields.add(D29Swamplands);
            SwamplandsFields.add(D30);
            SwamplandsFields.add(D31);
            SwamplandsFields.add(D32);
            SwamplandsFields.add(D33);
            SwamplandsFields.add(D34Swamplands);
            SwamplandsFields.add(D35);
            SwamplandsFields.add(D36);
            SwamplandsFields.add(D37);
            SwamplandsFields.add(H1);
            SwamplandsFields.add(H2);
            SwamplandsFields.add(H3);
            SwamplandsFields.add(H4);
            SwamplandsFields.add(H5);
            SwamplandsFields.add(H6);
            SwamplandsFields.add(H7);
            SwamplandsFields.add(H8);
            SwamplandsFields.add(H9);
            SwamplandsFields.add(H10);
            SwamplandsFields.add(H11);
            SwamplandsFields.add(H12);
            SwamplandsFields.add(H13);
            SwamplandsFields.add(H14);
            SwamplandsFields.add(H15);
            SwamplandsFields.add(H16);
            SwamplandsFields.add(H17);
            SwamplandsFields.add(H18);
            SwamplandsFields.add(H19);
            SwamplandsFields.add(H20);
            SwamplandsFields.add(H21);
            SwamplandsFields.add(H22);
            SwamplandsFields.add(H23);
            SwamplandsFields.add(H24);
            SwamplandsFields.add(H25);
            SwamplandsFields.add(H26);
            SwamplandsFields.add(H27);
            SwamplandsFields.add(H28);
            SwamplandsFields.add(H29);
            SwamplandsFields.add(H30);
            SwamplandsFields.add(H31);
            SwamplandsFields.add(H32);
            SwamplandsFields.add(H33);
            SwamplandsFields.add(H34Swamplands);
            SwamplandsFields.add(H35Swamplands);
            SwamplandsFields.add(H36Swamplands);
            SwamplandsFields.add(H37Swamplands);
            SwamplandsFields.add(E1Swamplands);
            SwamplandsFields.add(E2Swamplands);
            SwamplandsFields.add(E3Swamplands);
            SwamplandsFields.add(E4Swamplands);
            SwamplandsFields.add(E5);
            SwamplandsFields.add(E6);
            SwamplandsFields.add(E7);
            SwamplandsFields.add(E8);
            SwamplandsFields.add(E9);
            SwamplandsFields.add(E10);
            SwamplandsFields.add(E11);
            SwamplandsFields.add(E12);
            SwamplandsFields.add(E13);
            SwamplandsFields.add(E14);
            SwamplandsFields.add(E15);
            SwamplandsFields.add(E16);
            SwamplandsFields.add(E17);
            SwamplandsFields.add(E18);
            SwamplandsFields.add(E19);
            SwamplandsFields.add(E20);
            SwamplandsFields.add(E21);
            SwamplandsFields.add(E22);
            SwamplandsFields.add(E23);
            SwamplandsFields.add(E24);
            SwamplandsFields.add(E25);
            SwamplandsFields.add(E26);
            SwamplandsFields.add(E27);
            SwamplandsFields.add(E28);
            SwamplandsFields.add(E29);
            SwamplandsFields.add(E30);
            SwamplandsFields.add(E31);
            SwamplandsFields.add(E32);
            SwamplandsFields.add(E33);
            SwamplandsFields.add(E34);
            SwamplandsFields.add(E35);
            SwamplandsFields.add(E36);
            SwamplandsFields.add(E37);
            SwamplandsFields.add(O1Swamplands);
            SwamplandsFields.add(O2Swamplands);
            SwamplandsFields.add(O3Swamplands);
            SwamplandsFields.add(O4Swamplands);
            SwamplandsFields.add(O5Swamplands);
            SwamplandsFields.add(O6);
            SwamplandsFields.add(O7);
            SwamplandsFields.add(O8);
            SwamplandsFields.add(O9);
            SwamplandsFields.add(O10);
            SwamplandsFields.add(O11);
            SwamplandsFields.add(O12);
            SwamplandsFields.add(O13);
            SwamplandsFields.add(O14);
            SwamplandsFields.add(O15);
            SwamplandsFields.add(O16);
            SwamplandsFields.add(K1Swamplands);
            SwamplandsFields.add(K2Swamplands);
            SwamplandsFields.add(K3);
            SwamplandsFields.add(K4);
            SwamplandsFields.add(K5Swamplands);
            SwamplandsFields.add(K6);
            SwamplandsFields.add(K7);
            SwamplandsFields.add(K8);
            SwamplandsFields.add(K9);
            SwamplandsFields.add(K10);
            SwamplandsFields.add(K11);
            SwamplandsFields.add(K12);
            SwamplandsFields.add(K13);
            SwamplandsFields.add(K14);
            SwamplandsFields.add(K15);
            SwamplandsFields.add(K16);
            SwamplandsFields.add(K17);
            SwamplandsFields.add(K18);
            SwamplandsFields.add(K19);
            SwamplandsFields.add(K20);
            SwamplandsFields.add(K21);
            SwamplandsFields.add(K22);
            SwamplandsFields.add(K23);
            SwamplandsFields.add(K24);
            SwamplandsFields.add(K25);
            SwamplandsFields.add(K26);
            SwamplandsFields.add(K27);
            SwamplandsFields.add(K28);
            SwamplandsFields.add(K29);
            SwamplandsFields.add(K30);
            SwamplandsFields.add(K31);
            SwamplandsFields.add(K32);
            SwamplandsFields.add(K33);
            SwamplandsFields.add(K34);
            SwamplandsFields.add(K35);
            SwamplandsFields.add(K36);
            SwamplandsFields.add(K37);
            SwamplandsFields.add(EDBlue1);
            SwamplandsFields.add(EDBlue2);
            SwamplandsFields.add(EDBlue3);

        }


    public void setupWitchsCauldron() {


        Field L1 = new Field(2, "Green", true, "L1");
        Field L2 = new Field(2, "Green", true, "L2");
        Field L3 = new Field(1, "Green", true, "L3");
        Field L4 = new Field(1, "Blue", true, "L4");
        Field L5 = new Field(1, "Green", true, "L5");
        Field L6 = new Field(1, "Green", true, "L6");
        Field L7 = new Field(1, "Green", true, "L7");
        Field L8 = new Field(1, "Blue", true, "L8");
        Field L9 = new Field(1, "Camp", true, "L9");
        Field L10 = new Field(2, "Yellow", true, "L10");
        Field L11 = new Field(2, "Green", true, "L11");
        Field L12 = new Field(0, "Cave", false, "L12");
        Field L13 = new Field(1, "Green", true, "L13");
        Field L14 = new Field(1, "Blue", true, "L14");
        Field L15 = new Field(1, "Camp", true, "L15");
        Field L16 = new Field(2, "Green", true, "L16");
        Field L17 = new Field(2, "Camp", true, "L17");
        Field L18 = new Field(2, "Green", true, "L18");
        Field L19 = new Field(1, "Green", true, "L19");
        Field L20 = new Field(3, "Green", true, "L20");
        Field L21 = new Field(3, "Green", true, "L21");
        Field L22 = new Field(3, "Green", true, "L22");
        Field L23 = new Field(2, "Green", true, "L23");
        Field L24 = new Field(2, "Yellow", true, "L24");
        Field L25 = new Field(1, "Green", true, "L25");
        Field L26 = new Field(0, "Cave", false, "L26");
        Field L27 = new Field(1, "Green", true, "L27");
        Field L28 = new Field(1, "Green", true, "L28");
        Field L29 = new Field(1, "Green", true, "L29");
        Field L30 = new Field(1, "Green", true, "L30");
        Field L31 = new Field(2, "Green", true, "L31");
        Field L32 = new Field(1, "Green", true, "L32");
        Field L33 = new Field(2, "Green", true, "L33");
        Field L34 = new Field(0, "Cave", false, "L34");
        Field L35 = new Field(1, "Green", true, "L35");
        Field L36 = new Field(1, "Green", true, "L36");
        Field L37 = new Field(2, "Green", true, "L37");
        L1.AddNewNeighbour(L2, L5, L6);
        L2.AddNewNeighbour(L1, L6, L7, L3);
        L3.AddNewNeighbour(L2, L7, L8, L4);
        L4.AddNewNeighbour(L3, L8, L9);
        L5.AddNewNeighbour(L1, L6, L10, L11);
        L6.AddNewNeighbour(L1, L2, L7, L12, L11, L5);
        L7.AddNewNeighbour(L2, L3, L8, L13, L12, L6);
        L8.AddNewNeighbour(L3, L4, L9, L14, L13, L7);
        L9.AddNewNeighbour(L4, L15, L14, L8);
        L10.AddNewNeighbour(L5, L11, L17, L16);
        L11.AddNewNeighbour(L5, L6, L12, L18, L17, L10);
        L12.AddNewNeighbour(L6, L7, L13, L19, L18, L11);
        L13.AddNewNeighbour(L7, L8, L14, L20, L19, L12);
        L14.AddNewNeighbour(L8, L9, L15, L21, L20, L13);
        L15.AddNewNeighbour(L9, L22, L21, L14);
        L16.AddNewNeighbour(L10, L17, L23);
        L17.AddNewNeighbour(L10, L11, L18, L24, L23, L16);
        L18.AddNewNeighbour(L11, L12, L19, L25, L24, L17);
        L19.AddNewNeighbour(L12, L13, L20, L26, L25, L18);
        L20.AddNewNeighbour(L13, L14, L21, L27, L26, L19);
        L21.AddNewNeighbour(L14, L15, L22, L28, L27, L20);
        L22.AddNewNeighbour(L15, L28, L21);
        L23.AddNewNeighbour(L16, L17, L24, L29);
        L24.AddNewNeighbour(L17, L18, L25, L30, L29, L23);
        L25.AddNewNeighbour(L18, L19, L26, L31, L30, L24);
        L26.AddNewNeighbour(L19, L20, L27, L32, L32, L25);
        L27.AddNewNeighbour(L20, L21, L28, L33, L32, L26);
        L28.AddNewNeighbour(L21, L22, L33, L27);
        L29.AddNewNeighbour(L23, L24, L30, L34);
        L30.AddNewNeighbour(L24, L25, L31, L35, L34, L29);
        L31.AddNewNeighbour(L25, L26, L32, L36, L35, L30);
        L32.AddNewNeighbour(L26, L27, L33, L37, L36, L31);
        L33.AddNewNeighbour(L27, L28, L37, L32);
        L34.AddNewNeighbour(L29, L30, L35);
        L35.AddNewNeighbour(L34, L30, L31, L36);
        L36.AddNewNeighbour(L35, L31, L32, L37);
        L37.AddNewNeighbour(L36, L32, L33);

        Field A1 = new Field(0, "Green", true, "A1");
        Field A2 = new Field(0, "Green", true, "A2");
        Field A3 = new Field(0, "Green", true, "A3");
        Field A4 = new Field(0, "Green", true, "A4");
        Field A5 = new Field(1, "Green", true, "A5");
        Field A6 = new Field(1, "Green", true, "A6");
        Field A7 = new Field(1, "Green", true, "A7");
        Field A8 = new Field(1, "Green", true, "A8");
        Field A9 = new Field(1, "Green", true, "A9");
        Field A10 = new Field(1, "Green", true, "A10");
        Field A11 = new Field(1, "Green", true, "A11");
        Field A12 = new Field(1, "Yellow", true, "A12");
        Field A13 = new Field(1, "Green", true, "A13");
        Field A14 = new Field(1, "Blue", true, "A14");
        Field A15 = new Field(1, "Green", true, "A15");
        Field A16 = new Field(1, "Green", true, "A16");
        Field A17 = new Field(1, "Yellow", true, "A17");
        Field A18 = new Field(1, "Green", true, "A18");
        Field A19 = new Field(1, "Blue", true, "A19");
        Field A20 = new Field(1, "Green", true, "A20");
        Field A21 = new Field(1, "Yellow", true, "A21");
        Field A22 = new Field(1, "Green", true, "A22");
        Field A23 = new Field(1, "Green", true, "A23");
        Field A24 = new Field(0, "Cave", false, "A24");
        Field A25 = new Field(1, "Yellow", true, "A25");
        Field A26 = new Field(1, "Green", true, "A26");
        Field A27 = new Field(1, "Green", true, "A27");
        Field A28 = new Field(1, "Green", true, "A28");
        Field A29 = new Field(1, "Blue", true, "A29");
        Field A30 = new Field(0, "Cave", false, "A30");
        Field A31 = new Field(1, "Green", true, "A31");
        Field A32 = new Field(1, "Green", true, "A32");
        Field A33 = new Field(1, "Yellow", true, "A33");
        Field A34 = new Field(1, "Green", true, "A34");
        Field A35 = new Field(1, "Camp", true, "A35");
        Field A36 = new Field(1, "Green", true, "A36");
        Field A37 = new Field(1, "Green", true, "A37");
        A1.AddNewNeighbour(A2, A5, A6);
        A2.AddNewNeighbour(A1, A6, A7, A3);
        A3.AddNewNeighbour(A2, A7, A8, A4);
        A4.AddNewNeighbour(A3, A8, A9);
        A5.AddNewNeighbour(A1, A6, A10, A11);
        A6.AddNewNeighbour(A1, A2, A7, A12, A11, A5);
        A7.AddNewNeighbour(A2, A3, A8, A13, A12, A6);
        A8.AddNewNeighbour(A3, A4, A9, A14, A13, A7);
        A9.AddNewNeighbour(A4, A15, A14, A8);
        A10.AddNewNeighbour(A5, A11, A17, A16);
        A11.AddNewNeighbour(A5, A6, A12, A18, A17, A10);
        A12.AddNewNeighbour(A6, A7, A13, A19, A18, A11);
        A13.AddNewNeighbour(A7, A8, A14, A20, A19, A12);
        A14.AddNewNeighbour(A8, A9, A15, A21, A20, A13);
        A15.AddNewNeighbour(A9, A22, A21, A14);
        A16.AddNewNeighbour(A10, A17, A23);
        A17.AddNewNeighbour(A10, A11, A18, A24, A23, A16);
        A18.AddNewNeighbour(A11, A12, A19, A25, A24, A17);
        A19.AddNewNeighbour(A12, A13, A20, A26, A25, A18);
        A20.AddNewNeighbour(A13, A14, A21, A27, A26, A19);
        A21.AddNewNeighbour(A14, A15, A22, A28, A27, A20);
        A22.AddNewNeighbour(A15, A28, A21);
        A23.AddNewNeighbour(A16, A17, A24, A29);
        A24.AddNewNeighbour(A17, A18, A25, A30, A29, A23);
        A25.AddNewNeighbour(A18, A19, A26, A31, A30, A24);
        A26.AddNewNeighbour(A19, A20, A27, A32, A32, A25);
        A27.AddNewNeighbour(A20, A21, A28, A33, A32, A26);
        A28.AddNewNeighbour(A21, A22, A33, A27);
        A29.AddNewNeighbour(A23, A24, A30, A34);
        A30.AddNewNeighbour(A24, A25, A31, A35, A34, A29);
        A31.AddNewNeighbour(A25, A26, A32, A36, A35, A30);
        A32.AddNewNeighbour(A26, A27, A33, A37, A36, A31);
        A33.AddNewNeighbour(A27, A28, A37, A32);
        A34.AddNewNeighbour(A29, A30, A35);
        A35.AddNewNeighbour(A34, A30, A31, A36);
        A36.AddNewNeighbour(A35, A31, A32, A37);
        A37.AddNewNeighbour(A36, A32, A33);

        Field D1 = new Field(2, "Green", true, "D1");
        Field D2 = new Field(1, "Green", true, "D2");
        Field D3 = new Field(1, "Green", true, "D3");
        Field D4 = new Field(2, "Green", true, "D4");
        Field D5 = new Field(1, "Green", true, "D5");
        Field D6 = new Field(1, "Green", true, "D6");
        Field D7 = new Field(1, "Blue", true, "D7");
        Field D8 = new Field(1, "Blue", true, "D8");
        Field D9 = new Field(1, "Green", true, "D9");
        Field D10 = new Field(0, "Cave", false, "D10");
        Field D11 = new Field(3, "Yellow", true, "D11");
        Field D12 = new Field(1, "Green", true, "D12");
        Field D13 = new Field(2, "Blue", true, "D13");
        Field D14 = new Field(1, "Blue", true, "D14");
        Field D15 = new Field(1, "Green", true, "D15");
        Field D16 = new Field(3, "Blue", true, "D16");
        Field D17 = new Field(1, "Yellow", true, "D17");
        Field D18 = new Field(0, "Cave", false, "D18");
        Field D19 = new Field(0, "Cave", false, "D19");
        Field D20 = new Field(1, "Blue", true, "D20");
        Field D21 = new Field(1, "Blue", true, "D21");
        Field D22 = new Field(1, "Green", true, "D22");
        Field D23 = new Field(0, "Cave", false, "D23");
        Field D24 = new Field(3, "Yellow", true, "D24");
        Field D25 = new Field(1, "Green", true, "D25");
        Field D26 = new Field(2, "Blue", true, "D26");
        Field D27 = new Field(1, "Blue", true, "D27");
        Field D28 = new Field(1, "Green", true, "D28");
        Field D29 = new Field(1, "Green", true, "D29");
        Field D30 = new Field(1, "Green", true, "D30");
        Field D31 = new Field(1, "Blue", true, "D31");
        Field D32 = new Field(1, "Blue", true, "D32");
        Field D33 = new Field(1, "Green", true, "D33");
        Field D34 = new Field(2, "Green", true, "D34");
        Field D35 = new Field(1, "Green", true, "D35");
        Field D36 = new Field(1, "Green", true, "D36");
        Field D37 = new Field(2, "Green", true, "D37");
        D1.AddNewNeighbour(D2, D5, D6);
        D2.AddNewNeighbour(D1, D6, D7, D3);
        D3.AddNewNeighbour(D2, D7, D8, D4);
        D4.AddNewNeighbour(D3, D8, D9);
        D5.AddNewNeighbour(D1, D6, D10, D11);
        D6.AddNewNeighbour(D1, D2, D7, D12, D11, D5);
        D7.AddNewNeighbour(D2, D3, D8, D13, D12, D6);
        D8.AddNewNeighbour(D3, D4, D9, D14, D13, D7);
        D9.AddNewNeighbour(D4, D15, D14, D8);
        D10.AddNewNeighbour(D5, D11, D17, D16);
        D11.AddNewNeighbour(D5, D6, D12, D18, D17, D10);
        D12.AddNewNeighbour(D6, D7, D13, D19, D18, D11);
        D13.AddNewNeighbour(D7, D8, D14, D20, D19, D12);
        D14.AddNewNeighbour(D8, D9, D15, D21, D20, D13);
        D15.AddNewNeighbour(D9, D22, D21, D14);
        D16.AddNewNeighbour(D10, D17, D23);
        D17.AddNewNeighbour(D10, D11, D18, D24, D23, D16);
        D18.AddNewNeighbour(D11, D12, D19, D25, D24, D17);
        D19.AddNewNeighbour(D12, D13, D20, D26, D25, D18);
        D20.AddNewNeighbour(D13, D14, D21, D27, D26, D19);
        D21.AddNewNeighbour(D14, D15, D22, D28, D27, D20);
        D22.AddNewNeighbour(D15, D28, D21);
        D23.AddNewNeighbour(D16, D17, D24, D29);
        D24.AddNewNeighbour(D17, D18, D25, D30, D29, D23);
        D25.AddNewNeighbour(D18, D19, D26, D31, D30, D24);
        D26.AddNewNeighbour(D19, D20, D27, D32, D32, D25);
        D27.AddNewNeighbour(D20, D21, D28, D33, D32, D26);
        D28.AddNewNeighbour(D21, D22, D33, D27);
        D29.AddNewNeighbour(D23, D24, D30, D34);
        D30.AddNewNeighbour(D24, D25, D31, D35, D34, D29);
        D31.AddNewNeighbour(D25, D26, D32, D36, D35, D30);
        D32.AddNewNeighbour(D26, D27, D33, D37, D36, D31);
        D33.AddNewNeighbour(D27, D28, D37, D32);
        D34.AddNewNeighbour(D29, D30, D35);
        D35.AddNewNeighbour(D34, D30, D31, D36);
        D36.AddNewNeighbour(D35, D31, D32, D37);
        D37.AddNewNeighbour(D36, D32, D33);

        Field M1 = new Field(1, "Green", true, "M1");
        Field M2 = new Field(1, "Green", true, "M2");
        Field M3 = new Field(1, "Green", true, "M3");
        Field M4 = new Field(1, "Camp", true, "M4");
        Field M5 = new Field(1, "Green", true, "M5");
        Field M6 = new Field(3, "Yellow", true, "M6");
        Field M7 = new Field(0, "Cave", false, "M7");
        Field M8 = new Field(0, "Cave", false, "M8");
        Field M9 = new Field(4, "Blue", true, "M9");
        Field M10 = new Field(1, "Green", true, "M10");
        Field M11 = new Field(2, "Yellow", true, "M11");
        Field M12 = new Field(1, "Green", true, "M12");
        Field M13 = new Field(1, "Green", true, "M13");
        Field M14 = new Field(1, "Blue", true, "M14");
        Field M15 = new Field(0, "Cave", false, "M15");
        Field M16 = new Field(0, "Cave", false, "M16");
        Field M17 = new Field(1, "Green", true, "M17");
        Field M18 = new Field(1, "Green", true, "M18");
        Field M19 = new Field(2, "White", true, "M19");
        Field M20 = new Field(1, "Green", true, "M20");
        Field M21 = new Field(1, "Green", true, "M21");
        Field M22 = new Field(0, "Cave", false, "M22");
        Field M23 = new Field(0, "Cave", false, "M23");
        Field M24 = new Field(0, "Cave", false, "M24");
        Field M25 = new Field(0, "Cave", false, "M25");
        Field M26 = new Field(0, "Cave", false, "M26");
        Field M27 = new Field(2, "White", true, "M27");
        Field M28 = new Field(1, "Green", true, "M28");
        Field M29 = new Field(1, "Green", true, "M29");
        Field M30 = new Field(1, "Green", true, "M30");
        Field M31 = new Field(1, "Green", true, "M31");
        Field M32 = new Field(2, "White", true, "M32");
        Field M33 = new Field(1, "Green", true, "M33");
        Field M34 = new Field(1, "Blue", true, "M34");
        Field M35 = new Field(1, "Blue", true, "M35");
        Field M36 = new Field(1, "Green", true, "M36");
        Field M37 = new Field(1, "Green", true, "M37");
        M1.AddNewNeighbour(M2, M5, M6);
        M2.AddNewNeighbour(M1, M6, M7, M3);
        M3.AddNewNeighbour(M2, M7, M8, M4);
        M4.AddNewNeighbour(M3, M8, M9);
        M5.AddNewNeighbour(M1, M6, M10, M11);
        M6.AddNewNeighbour(M1, M2, M7, M12, M11, M5);
        M7.AddNewNeighbour(M2, M3, M8, M13, M12, M6);
        M8.AddNewNeighbour(M3, M4, M9, M14, M13, M7);
        M9.AddNewNeighbour(M4, M15, M14, M8);
        M10.AddNewNeighbour(M5, M11, M17, M16);
        M11.AddNewNeighbour(M5, M6, M12, M18, M17, M10);
        M12.AddNewNeighbour(M6, M7, M13, M19, M18, M11);
        M13.AddNewNeighbour(M7, M8, M14, M20, M19, M12);
        M14.AddNewNeighbour(M8, M9, M15, M21, M20, M13);
        M15.AddNewNeighbour(M9, M22, M21, M14);
        M16.AddNewNeighbour(M10, M17, M23);
        M17.AddNewNeighbour(M10, M11, M18, M24, M23, M16);
        M18.AddNewNeighbour(M11, M12, M19, M25, M24, M17);
        M19.AddNewNeighbour(M12, M13, M20, M26, M25, M18);
        M20.AddNewNeighbour(M13, M14, M21, M27, M26, M19);
        M21.AddNewNeighbour(M14, M15, M22, M28, M27, M20);
        M22.AddNewNeighbour(M15, M28, M21);
        M23.AddNewNeighbour(M16, M17, M24, M29);
        M24.AddNewNeighbour(M17, M18, M25, M30, M29, M23);
        M25.AddNewNeighbour(M18, M19, M26, M31, M30, M24);
        M26.AddNewNeighbour(M19, M20, M27, M32, M32, M25);
        M27.AddNewNeighbour(M20, M21, M28, M33, M32, M26);
        M28.AddNewNeighbour(M21, M22, M33, M27);
        M29.AddNewNeighbour(M23, M24, M30, M34);
        M30.AddNewNeighbour(M24, M25, M31, M35, M34, M29);
        M31.AddNewNeighbour(M25, M26, M32, M36, M35, M30);
        M32.AddNewNeighbour(M26, M27, M33, M37, M36, M31);
        M33.AddNewNeighbour(M27, M28, M37, M32);
        M34.AddNewNeighbour(M29, M30, M35);
        M35.AddNewNeighbour(M34, M30, M31, M36);
        M36.AddNewNeighbour(M35, M31, M32, M37);
        M37.AddNewNeighbour(M36, M32, M33);

        Field G1 = new Field(1, "Green", true, "G1");
        Field G2 = new Field(1, "Green", true, "G2");
        Field G3 = new Field(1, "Green", true, "G3");
        Field G4 = new Field(1, "Green", true, "G4");
        Field G5 = new Field(1, "Green", true, "G5");
        Field G6 = new Field(2, "Green", true, "G6");
        Field G7 = new Field(1, "Yellow", true, "G7");
        Field G8 = new Field(0, "Cave", false, "G8");
        Field G9 = new Field(1, "Green", true, "G9");
        Field G10 = new Field(1, "Yellow", true, "G10");
        Field G11 = new Field(2, "Yellow", true, "G11");
        Field G12 = new Field(2, "Yellow", true, "G12");
        Field G13 = new Field(1, "White", true, "G13");
        Field G14 = new Field(1, "Yellow", true, "G14");
        Field G15 = new Field(1, "Green", true, "G15");
        Field G16 = new Field(0, "Cave", false, "G16");
        Field G17 = new Field(0, "Cave", false, "G17");
        Field G18 = new Field(4, "Yellow", true, "G18");
        Field G19 = new Field(3, "Yellow", true, "G19");
        Field G20 = new Field(2, "Yellow", true, "G20");
        Field G21 = new Field(2, "Green", true, "G21");
        Field G22 = new Field(1, "Camp", true, "G22");
        Field G23 = new Field(1, "Yellow", true, "G23");
        Field G24 = new Field(2, "Yellow", true, "G24");
        Field G25 = new Field(2, "Yellow", true, "G25");
        Field G26 = new Field(1, "White", true, "G26");
        Field G27 = new Field(1, "Yellow", true, "G27");
        Field G28 = new Field(1, "Green", true, "G28");
        Field G29 = new Field(1, "Green", true, "G29");
        Field G30 = new Field(2, "Green", true, "G30");
        Field G31 = new Field(1, "Yellow", true, "G31");
        Field G32 = new Field(0, "Cave", false, "G32");
        Field G33 = new Field(1, "Green", true, "G33");
        Field G34 = new Field(1, "Green", true, "G34");
        Field G35 = new Field(1, "Green", true, "G35");
        Field G36 = new Field(1, "Green", true, "G36");
        Field G37 = new Field(1, "Green", true, "G37");
        G1.AddNewNeighbour(G2, G5, G6);
        G2.AddNewNeighbour(G1, G6, G7, G3);
        G3.AddNewNeighbour(G2, G7, G8, G4);
        G4.AddNewNeighbour(G3, G8, G9);
        G5.AddNewNeighbour(G1, G6, G10, G11);
        G6.AddNewNeighbour(G1, G2, G7, G12, G11, G5);
        G7.AddNewNeighbour(G2, G3, G8, G13, G12, G6);
        G8.AddNewNeighbour(G3, G4, G9, G14, G13, G7);
        G9.AddNewNeighbour(G4, G15, G14, G8);
        G10.AddNewNeighbour(G5, G11, G17, G16);
        G11.AddNewNeighbour(G5, G6, G12, G18, G17, G10);
        G12.AddNewNeighbour(G6, G7, G13, G19, G18, G11);
        G13.AddNewNeighbour(G7, G8, G14, G20, G19, G12);
        G14.AddNewNeighbour(G8, G9, G15, G21, G20, G13);
        G15.AddNewNeighbour(G9, G22, G21, G14);
        G16.AddNewNeighbour(G10, G17, G23);
        G17.AddNewNeighbour(G10, G11, G18, G24, G23, G16);
        G18.AddNewNeighbour(G11, G12, G19, G25, G24, G17);
        G19.AddNewNeighbour(G12, G13, G20, G26, G25, G18);
        G20.AddNewNeighbour(G13, G14, G21, G27, G26, G19);
        G21.AddNewNeighbour(G14, G15, G22, G28, G27, G20);
        G22.AddNewNeighbour(G15, G28, G21);
        G23.AddNewNeighbour(G16, G17, G24, G29);
        G24.AddNewNeighbour(G17, G18, G25, G30, G29, G23);
        G25.AddNewNeighbour(G18, G19, G26, G31, G30, G24);
        G26.AddNewNeighbour(G19, G20, G27, G32, G32, G25);
        G27.AddNewNeighbour(G20, G21, G28, G33, G32, G26);
        G28.AddNewNeighbour(G21, G22, G33, G27);
        G29.AddNewNeighbour(G23, G24, G30, G34);
        G30.AddNewNeighbour(G24, G25, G31, G35, G34, G29);
        G31.AddNewNeighbour(G25, G26, G32, G36, G35, G30);
        G32.AddNewNeighbour(G26, G27, G33, G37, G36, G31);
        G33.AddNewNeighbour(G27, G28, G37, G32);
        G34.AddNewNeighbour(G29, G30, G35);
        G35.AddNewNeighbour(G34, G30, G31, G36);
        G36.AddNewNeighbour(G35, G31, G32, G37);
        G37.AddNewNeighbour(G36, G32, G33);

        Field I1 = new Field(1, "Green", true, "I1");
        Field I2 = new Field(1, "Blue", true, "I2");
        Field I3 = new Field(2, "Blue", true, "I3");
        Field I4 = new Field(2, "Blue", true, "I4");
        Field I5 = new Field(1, "Green", true, "I5");
        Field I6 = new Field(1, "Green", true, "I6");
        Field I7 = new Field(1, "Blue", true, "I7");
        Field I8 = new Field(1, "Blue", true, "I8");
        Field I9 = new Field(2, "Blue", true, "I9");
        Field I10 = new Field(1, "Green", true, "I10");
        Field I11 = new Field(2, "Green", true, "I11");
        Field I12 = new Field(0, "Cave", false, "I12");
        Field I13 = new Field(0, "Cave", false, "I13");
        Field I14 = new Field(3, "White", true, "I14");
        Field I15 = new Field(2, "Yellow", true, "I15");
        Field I16 = new Field(0, "Cave", false, "I16");
        Field I17 = new Field(0, "Cave", false, "I17");
        Field I18 = new Field(3, "Camp", true, "I18");
        Field I19 = new Field(2, "Green", true, "I19");
        Field I20 = new Field(1, "Green", true, "I20");
        Field I21 = new Field(2, "Yellow", true, "I21");
        Field I22 = new Field(1, "Yellow", true, "I22");
        Field I23 = new Field(1, "Green", true, "I23");
        Field I24 = new Field(2, "Green", true, "I24");
        Field I25 = new Field(0, "Cave", false, "I25");
        Field I26 = new Field(1, "Green", true, "I26");
        Field I27 = new Field(2, "Yellow", true, "I27");
        Field I28 = new Field(1, "Yellow", true, "I28");
        Field I29 = new Field(1, "Green", true, "I29");
        Field I30 = new Field(1, "Green", true, "I30");
        Field I31 = new Field(0, "Cave", false, "I31");
        Field I32 = new Field(1, "Green", true, "I32");
        Field I33 = new Field(1, "Yellow", true, "I33");
        Field I34 = new Field(1, "Green", true, "I34");
        Field I35 = new Field(1, "Green", true, "I35");
        Field I36 = new Field(1, "Green", true, "I36");
        Field I37 = new Field(1, "Green", true, "I37");
        I1.AddNewNeighbour(I2, I5, I6);
        I2.AddNewNeighbour(I1, I6, I7, I3);
        I3.AddNewNeighbour(I2, I7, I8, I4);
        I4.AddNewNeighbour(I3, I8, I9);
        I5.AddNewNeighbour(I1, I6, I10, I11);
        I6.AddNewNeighbour(I1, I2, I7, I12, I11, I5);
        I7.AddNewNeighbour(I2, I3, I8, I13, I12, I6);
        I8.AddNewNeighbour(I3, I4, I9, I14, I13, I7);
        I9.AddNewNeighbour(I4, I15, I14, I8);
        I10.AddNewNeighbour(I5, I11, I17, I16);
        I11.AddNewNeighbour(I5, I6, I12, I18, I17, I10);
        I12.AddNewNeighbour(I6, I7, I13, I19, I18, I11);
        I13.AddNewNeighbour(I7, I8, I14, I20, I19, I12);
        I14.AddNewNeighbour(I8, I9, I15, I21, I20, I13);
        I15.AddNewNeighbour(I9, I22, I21, I14);
        I16.AddNewNeighbour(I10, I17, I23);
        I17.AddNewNeighbour(I10, I11, I18, I24, I23, I16);
        I18.AddNewNeighbour(I11, I12, I19, I25, I24, I17);
        I19.AddNewNeighbour(I12, I13, I20, I26, I25, I18);
        I20.AddNewNeighbour(I13, I14, I21, I27, I26, I19);
        I21.AddNewNeighbour(I14, I15, I22, I28, I27, I20);
        I22.AddNewNeighbour(I15, I28, I21);
        I23.AddNewNeighbour(I16, I17, I24, I29);
        I24.AddNewNeighbour(I17, I18, I25, I30, I29, I23);
        I25.AddNewNeighbour(I18, I19, I26, I31, I30, I24);
        I26.AddNewNeighbour(I19, I20, I27, I32, I32, I25);
        I27.AddNewNeighbour(I20, I21, I28, I33, I32, I26);
        I28.AddNewNeighbour(I21, I22, I33, I27);
        I29.AddNewNeighbour(I23, I24, I30, I34);
        I30.AddNewNeighbour(I24, I25, I31, I35, I34, I29);
        I31.AddNewNeighbour(I25, I26, I32, I36, I35, I30);
        I32.AddNewNeighbour(I26, I27, I33, I37, I36, I31);
        I33.AddNewNeighbour(I27, I28, I37, I32);
        I34.AddNewNeighbour(I29, I30, I35);
        I35.AddNewNeighbour(I34, I30, I31, I36);
        I36.AddNewNeighbour(I35, I31, I32, I37);
        I37.AddNewNeighbour(I36, I32, I33);

        Random rand = new Random();
        int numberOfElements = 5;

        List<Blockade> blockadeList = new ArrayList<>(Blockades);

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(blockadeList.size());
            Blockade randomElement = blockadeList.get(randomIndex);
            blockadeList.remove(randomIndex);
            currentBlockades.add(randomElement);
        }

        currentBlockades.get(0).setName("BK1");
        currentBlockades.get(1).setName("BK2");
        currentBlockades.get(2).setName("BK3");
        currentBlockades.get(3).setName("BK4");
        currentBlockades.get(4).setName("BK5");

        removalList = new ArrayList<>(currentBlockades);

        Blockade WitchsCauldronfirst = currentBlockades.get(0);
        Blockade WitchsCauldronsecond = currentBlockades.get(1);
        Blockade WitchsCauldronthird = currentBlockades.get(2);
        Blockade WitchsCauldronfourth = currentBlockades.get(3);
        Blockade WitchsCauldronfifth = currentBlockades.get(4);


        Field A22WitchsCauldron = A22;
        A22WitchsCauldron.AddNewNeighbour(WitchsCauldronfirst);
        Field A28WitchsCauldron = A28;
        A28WitchsCauldron.AddNewNeighbour(WitchsCauldronfirst);
        Field A33WitchsCauldron = A33;
        A33WitchsCauldron.AddNewNeighbour(WitchsCauldronfirst);
        Field A37WitchsCauldron = A37;
        A37WitchsCauldron.AddNewNeighbour(WitchsCauldronfirst);
        WitchsCauldronfirst.addNeighbour(A22WitchsCauldron);
        WitchsCauldronfirst.addNeighbour(A28WitchsCauldron);
        WitchsCauldronfirst.addNeighbour(A33WitchsCauldron);
        WitchsCauldronfirst.addNeighbour(A37WitchsCauldron);
        WitchsCauldronfirst.addNeighbour(L1);
        WitchsCauldronfirst.addNeighbour(L2);
        WitchsCauldronfirst.addNeighbour(L3);
        WitchsCauldronfirst.addNeighbour(L4);

        Field L34WitchsCauldron = L34;
        L34WitchsCauldron.AddNewNeighbour(WitchsCauldronsecond);
        Field L35WitchsCauldron = L35;
        L35WitchsCauldron.AddNewNeighbour(WitchsCauldronsecond);
        Field L36WitchsCauldron = L36;
        L36WitchsCauldron.AddNewNeighbour(WitchsCauldronsecond);
        Field L37WitchsCauldron = L37;
        L37WitchsCauldron.AddNewNeighbour(WitchsCauldronsecond);
        WitchsCauldronsecond.addNeighbour(L34WitchsCauldron);
        WitchsCauldronsecond.addNeighbour(L35WitchsCauldron);
        WitchsCauldronsecond.addNeighbour(L36WitchsCauldron);
        WitchsCauldronsecond.addNeighbour(L37WitchsCauldron);
        WitchsCauldronsecond.addNeighbour(G1);
        WitchsCauldronsecond.addNeighbour(G2);
        WitchsCauldronsecond.addNeighbour(G3);
        WitchsCauldronsecond.addNeighbour(G4);

        Field EDBlue1 = new Field(1, "Blue", true, "EDBlue1");
        Field EDBlue2 = new Field(1, "Blue", true, "EDBlue2");
        Field EDBlue3 = new Field(1, "Blue", true, "EDBlue3");

        Field G16WitchsCauldron = G16;
        G16WitchsCauldron.AddNewNeighbour(WitchsCauldronthird);
        Field G23WitchsCauldron = G23;
        G23WitchsCauldron.AddNewNeighbour(WitchsCauldronthird);
        Field G29WitchsCauldron = G29;
        G29WitchsCauldron.AddNewNeighbour(WitchsCauldronthird);
        Field G34WitchsCauldron = G34;
        G34WitchsCauldron.AddNewNeighbour(WitchsCauldronthird);
        WitchsCauldronthird.addNeighbour(G16WitchsCauldron);
        WitchsCauldronthird.addNeighbour(G23WitchsCauldron);
        WitchsCauldronthird.addNeighbour(G29WitchsCauldron);
        WitchsCauldronthird.addNeighbour(G34WitchsCauldron);
        WitchsCauldronthird.addNeighbour(D16);
        WitchsCauldronthird.addNeighbour(D10);
        WitchsCauldronthird.addNeighbour(D5);
        WitchsCauldronthird.addNeighbour(D1);

        Field D34WitchsCauldron = D34;
        D34WitchsCauldron.AddNewNeighbour(WitchsCauldronfourth);
        Field D35WitchsCauldron = D35;
        D35WitchsCauldron.AddNewNeighbour(WitchsCauldronfourth);
        Field D36WitchsCauldron = D36;
        D36WitchsCauldron.AddNewNeighbour(WitchsCauldronfourth);
        Field D37WitchsCauldron = D37;
        D37WitchsCauldron.AddNewNeighbour(WitchsCauldronfourth);
        WitchsCauldronfourth.addNeighbour(D34WitchsCauldron);
        WitchsCauldronfourth.addNeighbour(D35WitchsCauldron);
        WitchsCauldronfourth.addNeighbour(D36WitchsCauldron);
        WitchsCauldronfourth.addNeighbour(D37WitchsCauldron);
        WitchsCauldronfourth.addNeighbour(M1);
        WitchsCauldronfourth.addNeighbour(M2);
        WitchsCauldronfourth.addNeighbour(M3);
        WitchsCauldronfourth.addNeighbour(M4);

        Field M16WitchsCauldron = M16;
        M16WitchsCauldron.AddNewNeighbour(WitchsCauldronfifth);
        Field M23WitchsCauldron = M23;
        M23WitchsCauldron.AddNewNeighbour(WitchsCauldronfifth);
        Field M29WitchsCauldron = M29;
        M29WitchsCauldron.AddNewNeighbour(WitchsCauldronfifth);
        Field M34WitchsCauldron = M34;
        M34WitchsCauldron.AddNewNeighbour(WitchsCauldronfifth);
        WitchsCauldronfifth.addNeighbour(M16WitchsCauldron);
        WitchsCauldronfifth.addNeighbour(M23WitchsCauldron);
        WitchsCauldronfifth.addNeighbour(M29WitchsCauldron);
        WitchsCauldronfifth.addNeighbour(M34WitchsCauldron);
        WitchsCauldronfifth.addNeighbour(I16);
        WitchsCauldronfifth.addNeighbour(I10);
        WitchsCauldronfifth.addNeighbour(I5);
        WitchsCauldronfifth.addNeighbour(I1);

        Field I36WitchsCauldorn = I36;
        I36WitchsCauldorn.AddNewNeighbour(EDBlue1);
        Field I37WitchsCauldron = I37;
        I37WitchsCauldron.AddNewNeighbour(EDBlue1, EDBlue2, EDBlue3);
        Field I33WitchsCauldron = I33;
        I33WitchsCauldron.AddNewNeighbour(EDBlue3);




            WitchsCauldronFields.add(A1);
            WitchsCauldronFields.add(A2);
            WitchsCauldronFields.add(A3);
            WitchsCauldronFields.add(A4);
            WitchsCauldronFields.add(A5);
            WitchsCauldronFields.add(A6);
            WitchsCauldronFields.add(A7);
            WitchsCauldronFields.add(A8);
            WitchsCauldronFields.add(A9);
            WitchsCauldronFields.add(A10);
            WitchsCauldronFields.add(A11);
            WitchsCauldronFields.add(A12);
            WitchsCauldronFields.add(A13);
            WitchsCauldronFields.add(A14);
            WitchsCauldronFields.add(A15);
            WitchsCauldronFields.add(A16);
            WitchsCauldronFields.add(A17);
            WitchsCauldronFields.add(A18);
            WitchsCauldronFields.add(A19);
            WitchsCauldronFields.add(A20);
            WitchsCauldronFields.add(A21);
            WitchsCauldronFields.add(A22WitchsCauldron);
            WitchsCauldronFields.add(A23);
            WitchsCauldronFields.add(A24);
            WitchsCauldronFields.add(A25);
            WitchsCauldronFields.add(A26);
            WitchsCauldronFields.add(A27);
            WitchsCauldronFields.add(A28WitchsCauldron);
            WitchsCauldronFields.add(A29);
            WitchsCauldronFields.add(A30);
            WitchsCauldronFields.add(A31);
            WitchsCauldronFields.add(A32);
            WitchsCauldronFields.add(A33WitchsCauldron);
            WitchsCauldronFields.add(A34);
            WitchsCauldronFields.add(A35);
            WitchsCauldronFields.add(A36);
            WitchsCauldronFields.add(A37WitchsCauldron);
            WitchsCauldronFields.add(L1);
            WitchsCauldronFields.add(L2);
            WitchsCauldronFields.add(L3);
            WitchsCauldronFields.add(L4);
            WitchsCauldronFields.add(L5);
            WitchsCauldronFields.add(L6);
            WitchsCauldronFields.add(L7);
            WitchsCauldronFields.add(L8);
            WitchsCauldronFields.add(L9);
            WitchsCauldronFields.add(L10);
            WitchsCauldronFields.add(L11);
            WitchsCauldronFields.add(L12);
            WitchsCauldronFields.add(L13);
            WitchsCauldronFields.add(L14);
            WitchsCauldronFields.add(L15);
            WitchsCauldronFields.add(L16);
            WitchsCauldronFields.add(L17);
            WitchsCauldronFields.add(L18);
            WitchsCauldronFields.add(L19);
            WitchsCauldronFields.add(L20);
            WitchsCauldronFields.add(L21);
            WitchsCauldronFields.add(L22);
            WitchsCauldronFields.add(L23);
            WitchsCauldronFields.add(L24);
            WitchsCauldronFields.add(L25);
            WitchsCauldronFields.add(L26);
            WitchsCauldronFields.add(L27);
            WitchsCauldronFields.add(L28);
            WitchsCauldronFields.add(L29);
            WitchsCauldronFields.add(L30);
            WitchsCauldronFields.add(L31);
            WitchsCauldronFields.add(L32);
            WitchsCauldronFields.add(L33);
            WitchsCauldronFields.add(L34WitchsCauldron);
            WitchsCauldronFields.add(L35WitchsCauldron);
            WitchsCauldronFields.add(L36WitchsCauldron);
            WitchsCauldronFields.add(L37WitchsCauldron);
            WitchsCauldronFields.add(G1);
            WitchsCauldronFields.add(G2);
            WitchsCauldronFields.add(G3);
            WitchsCauldronFields.add(G4);
            WitchsCauldronFields.add(G5);
            WitchsCauldronFields.add(G6);
            WitchsCauldronFields.add(G7);
            WitchsCauldronFields.add(G8);
            WitchsCauldronFields.add(G9);
            WitchsCauldronFields.add(G10);
            WitchsCauldronFields.add(G11);
            WitchsCauldronFields.add(G12);
            WitchsCauldronFields.add(G13);
            WitchsCauldronFields.add(G14);
            WitchsCauldronFields.add(G15);
            WitchsCauldronFields.add(G16WitchsCauldron);
            WitchsCauldronFields.add(G17);
            WitchsCauldronFields.add(G18);
            WitchsCauldronFields.add(G19);
            WitchsCauldronFields.add(G20);
            WitchsCauldronFields.add(G21);
            WitchsCauldronFields.add(G22);
            WitchsCauldronFields.add(G23WitchsCauldron);
            WitchsCauldronFields.add(G24);
            WitchsCauldronFields.add(G25);
            WitchsCauldronFields.add(G26);
            WitchsCauldronFields.add(G27);
            WitchsCauldronFields.add(G28);
            WitchsCauldronFields.add(G29WitchsCauldron);
            WitchsCauldronFields.add(G30);
            WitchsCauldronFields.add(G31);
            WitchsCauldronFields.add(G32);
            WitchsCauldronFields.add(G33);
            WitchsCauldronFields.add(G34WitchsCauldron);
            WitchsCauldronFields.add(G35);
            WitchsCauldronFields.add(G36);
            WitchsCauldronFields.add(G37);
            WitchsCauldronFields.add(D1);
            WitchsCauldronFields.add(D2);
            WitchsCauldronFields.add(D3);
            WitchsCauldronFields.add(D4);
            WitchsCauldronFields.add(D5);
            WitchsCauldronFields.add(D6);
            WitchsCauldronFields.add(D7);
            WitchsCauldronFields.add(D8);
            WitchsCauldronFields.add(D9);
            WitchsCauldronFields.add(D10);
            WitchsCauldronFields.add(D11);
            WitchsCauldronFields.add(D12);
            WitchsCauldronFields.add(D13);
            WitchsCauldronFields.add(D14);
            WitchsCauldronFields.add(D15);
            WitchsCauldronFields.add(D16);
            WitchsCauldronFields.add(D17);
            WitchsCauldronFields.add(D18);
            WitchsCauldronFields.add(D19);
            WitchsCauldronFields.add(D20);
            WitchsCauldronFields.add(D21);
            WitchsCauldronFields.add(D22);
            WitchsCauldronFields.add(D23);
            WitchsCauldronFields.add(D24);
            WitchsCauldronFields.add(D25);
            WitchsCauldronFields.add(D26);
            WitchsCauldronFields.add(D27);
            WitchsCauldronFields.add(D28);
            WitchsCauldronFields.add(D29);
            WitchsCauldronFields.add(D30);
            WitchsCauldronFields.add(D31);
            WitchsCauldronFields.add(D32);
            WitchsCauldronFields.add(D33);
            WitchsCauldronFields.add(D34WitchsCauldron);
            WitchsCauldronFields.add(D35WitchsCauldron);
            WitchsCauldronFields.add(D36WitchsCauldron);
            WitchsCauldronFields.add(D37WitchsCauldron);
            WitchsCauldronFields.add(M1);
            WitchsCauldronFields.add(M2);
            WitchsCauldronFields.add(M3);
            WitchsCauldronFields.add(M4);
            WitchsCauldronFields.add(M5);
            WitchsCauldronFields.add(M6);
            WitchsCauldronFields.add(M7);
            WitchsCauldronFields.add(M8);
            WitchsCauldronFields.add(M9);
            WitchsCauldronFields.add(M10);
            WitchsCauldronFields.add(M11);
            WitchsCauldronFields.add(M12);
            WitchsCauldronFields.add(M13);
            WitchsCauldronFields.add(M14);
            WitchsCauldronFields.add(M15);
            WitchsCauldronFields.add(M16WitchsCauldron);
            WitchsCauldronFields.add(M17);
            WitchsCauldronFields.add(M18);
            WitchsCauldronFields.add(M19);
            WitchsCauldronFields.add(M20);
            WitchsCauldronFields.add(M21);
            WitchsCauldronFields.add(M22);
            WitchsCauldronFields.add(M23WitchsCauldron);
            WitchsCauldronFields.add(M24);
            WitchsCauldronFields.add(M25);
            WitchsCauldronFields.add(M26);
            WitchsCauldronFields.add(M27);
            WitchsCauldronFields.add(M28);
            WitchsCauldronFields.add(M29WitchsCauldron);
            WitchsCauldronFields.add(M30);
            WitchsCauldronFields.add(M31);
            WitchsCauldronFields.add(M32);
            WitchsCauldronFields.add(M33);
            WitchsCauldronFields.add(M34WitchsCauldron);
            WitchsCauldronFields.add(M35);
            WitchsCauldronFields.add(M36);
            WitchsCauldronFields.add(M37);
            WitchsCauldronFields.add(I1);
            WitchsCauldronFields.add(I2);
            WitchsCauldronFields.add(I3);
            WitchsCauldronFields.add(I4);
            WitchsCauldronFields.add(I5);
            WitchsCauldronFields.add(I6);
            WitchsCauldronFields.add(I7);
            WitchsCauldronFields.add(I8);
            WitchsCauldronFields.add(I9);
            WitchsCauldronFields.add(I10);
            WitchsCauldronFields.add(I11);
            WitchsCauldronFields.add(I12);
            WitchsCauldronFields.add(I13);
            WitchsCauldronFields.add(I14);
            WitchsCauldronFields.add(I15);
            WitchsCauldronFields.add(I16);
            WitchsCauldronFields.add(I17);
            WitchsCauldronFields.add(I18);
            WitchsCauldronFields.add(I19);
            WitchsCauldronFields.add(I20);
            WitchsCauldronFields.add(I21);
            WitchsCauldronFields.add(I22);
            WitchsCauldronFields.add(I23);
            WitchsCauldronFields.add(I24);
            WitchsCauldronFields.add(I25);
            WitchsCauldronFields.add(I26);
            WitchsCauldronFields.add(I27);
            WitchsCauldronFields.add(I28);
            WitchsCauldronFields.add(I29);
            WitchsCauldronFields.add(I30);
            WitchsCauldronFields.add(I31);
            WitchsCauldronFields.add(I32);
            WitchsCauldronFields.add(I33WitchsCauldron);
            WitchsCauldronFields.add(I34);
            WitchsCauldronFields.add(I35);
            WitchsCauldronFields.add(I36WitchsCauldorn);
            WitchsCauldronFields.add(I37WitchsCauldron);
            WitchsCauldronFields.add(EDBlue1);
            WitchsCauldronFields.add(EDBlue2);
            WitchsCauldronFields.add(EDBlue3);
        }






    @JsonIgnore
    public void setStandardPathFields(List<Field> standardPathFields) {
        StandardPathFields = standardPathFields;

    }
    @JsonIgnore
    public List<Field> getStandardPathFields() {
        return StandardPathFields;
    }
    @JsonIgnore
    public List<Blockade> getCurrentBlockades() {
        return currentBlockades;
    }

    public void setWindingPathsFields(List<Field> windingPathsFields) {
        WindingPathsFields = windingPathsFields;
    }

    public void setWitchsCauldronFields(List<Field> witchsCauldronFields) {
        WitchsCauldronFields = witchsCauldronFields;
    }

    public void setSwamplandsFields(List<Field> swamplandsFields) {
        SwamplandsFields = swamplandsFields;
    }

    public void setSerpentineFields(List<Field> serpentineFields) {
        SerpentineFields = serpentineFields;
    }

    public List<Field> getWitchsCauldronFields() {
        return WitchsCauldronFields;
    }

    public List<Field> getWindingPathsFields() {
        return WindingPathsFields;
    }

    public List<Field> getSwamplandsFields() {
        return SwamplandsFields;
    }

    public List<Field> getSerpentineFields() {
        return SerpentineFields;
    }

    public void setHomeStretchFields(List<Field> homeStretchFields) {
        HomeStretchFields = homeStretchFields;
    }

    public void setHillsOfGoldFields(List<Field> hillsOfGoldFields) {
        HillsOfGoldFields = hillsOfGoldFields;
    }

    public List<Field> getHillsOfGoldFields() {
        return HillsOfGoldFields;
    }

    public List<Field> getHomeStretchFields() {
        return HomeStretchFields;
    }


    //add all other starters
    @JsonIgnore
    public List<Field> getStarters(String name){
        List<Field> starters = new ArrayList<>();
        if (name.equals("StandardPath")) {
            starters.add(StandardPathFields.get(0));
            starters.add(StandardPathFields.get(1));
            starters.add(StandardPathFields.get(2));
            starters.add(StandardPathFields.get(3));
        }
        if (name.equals("HillsOfGold")) {
            starters.add(HillsOfGoldFields.get(0));
            starters.add(HillsOfGoldFields.get(1));
            starters.add(HillsOfGoldFields.get(2));
            starters.add(HillsOfGoldFields.get(3));
        }

        if (name.equals("HomeStretchFields")) {
            starters.add(HomeStretchFields.get(0));
            starters.add(HomeStretchFields.get(1));
            starters.add(HomeStretchFields.get(2));
            starters.add(HomeStretchFields.get(3));
        }
        if (name.equals("Serpentine")) {
            starters.add(SerpentineFields.get(0));
            starters.add(SerpentineFields.get(1));
            starters.add(SerpentineFields.get(2));
            starters.add(SerpentineFields.get(3));
        }

        if (name.equals("Swamplands")) {
            starters.add(SwamplandsFields.get(0));
            starters.add(SwamplandsFields.get(1));
            starters.add(SwamplandsFields.get(2));
            starters.add(SwamplandsFields.get(3));
        }

        if (name.equals("WindingPath")) {
            starters.add(WindingPathsFields.get(0));
            starters.add(WindingPathsFields.get(1));
            starters.add(WindingPathsFields.get(2));
            starters.add(WindingPathsFields.get(3));
        }

        if (name.equals("WitchsCauldron")) {
            starters.add(WitchsCauldronFields.get(0));
            starters.add(WitchsCauldronFields.get(1));
            starters.add(WitchsCauldronFields.get(2));
            starters.add(WitchsCauldronFields.get(3));
        }

        return starters;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @JsonIgnore
    public List<Blockade> getBlockades() {
        return Blockades;
    }
    @JsonIgnore
    public void setBlockades(List<Blockade> blockades) {
        Blockades = blockades;
    }

    public void setCurrentBlockades(List<Blockade> currentBlockades) {
        this.currentBlockades = currentBlockades;
    }


    public List<Field> getCurrentPath(String name) {
        if (name.equals("StandardPath")) {
            return getStandardPathFields();
        }
        if (name.equals("HillsOfGold")) {
            return getHillsOfGoldFields();
        }

        if (name.equals("HomeStretchFields")) {
            return getHomeStretchFields();
        }

        if (name.equals("Serpentine")) {
            return getSerpentineFields();
        }

        if (name.equals("Swamplands")) {
            return getSwamplandsFields();
        }

        if (name.equals("WindingPath")) {
            return getWindingPathsFields();
        }
        if (name.equals("WitchsCauldron")) {
            return getWitchsCauldronFields();
        }

        return null;
    }

    public void setCurrentPath(String name, List<Field> updated){
        if (name.equals("StandardPath")) {
            setStandardPathFields(updated);
        }
        if (name.equals("HillsOfGold")) {
            setHillsOfGoldFields(updated);
        }

        if (name.equals("HomeStretchFields")) {
            setHomeStretchFields(updated);
        }

        if (name.equals("Serpentine")) {
            setSerpentineFields(updated);
        }

        if (name.equals("Swamplands")) {
            setSwamplandsFields(updated);
        }

        if (name.equals("WindingPath")) {
            setWindingPathsFields(updated);
        }
        if (name.equals("WitchsCauldron")) {
            setWitchsCauldronFields(updated);
        }

    }

    //add all other setups
    public void setupPath(String name){
        if (name.equals("StandardPath")) {
            setupStandardPath();
        }
        if (name.equals("HillsOfGold")) {
            setupHillsOfGold();
        }
        if (name.equals("HomeStretchFields")) {
            setupHomeStretchFields();
        }

        if (name.equals("WindingPath")) {
            setupWindingPath();
        }

        if (name.equals("Serpentine")) {
            setupSerpentine();
        }
        if (name.equals("Swamplands")) {
            setupSwamplands();
        }
        if (name.equals("WitchsCauldron")) {
            setupWitchsCauldron();

        }


    }

    public Blockade removeBlockade(String name, Integer counter){

        if (name.equals("StandardPath")) {
            Blockade b = removeStandard(counter);
            return b;

        } else if (name.equals("HillsOfGold")){
            Blockade b = removeHillsOfGold(counter);
            return b;

        }else if (name.equals("HomeStretchFields")){
            Blockade b = removeHomeStretch(counter);
            return b;
        }else if (name.equals("WindingPath")){
            Blockade b = removeWindingPaths(counter);
            return b;
        }else if (name.equals("Serpentine")){
            Blockade b = removeSerpentine(counter);
            return b;
        }else if (name.equals("Swamplands")){
            Blockade b = removeSwamplands(counter);
            return b;
        }else if (name.equals("WitchsCauldron")){
            Blockade b = removeWitchsCauldron(counter);
            return b;
        }

        return null;
    }

    public Blockade removeStandard(Integer counter){
        if(counter == 1){

            Blockade b = getStandardPathFields().get(21).getBlockadeFromNeighbours();
            getStandardPathFields().get(21).getNeighbours().remove(b);
            getStandardPathFields().get(27).getNeighbours().remove(b);
            getStandardPathFields().get(32).getNeighbours().remove(b);
            getStandardPathFields().get(36).getNeighbours().remove(b);
            getStandardPathFields().get(21).getNeighbours().add(getStandardPathFields().get(40));
            getStandardPathFields().get(27).getNeighbours().add(getStandardPathFields().get(40));
            getStandardPathFields().get(27).getNeighbours().add(getStandardPathFields().get(39));
            getStandardPathFields().get(32).getNeighbours().add(getStandardPathFields().get(39));
            getStandardPathFields().get(32).getNeighbours().add(getStandardPathFields().get(38));
            getStandardPathFields().get(36).getNeighbours().add(getStandardPathFields().get(38));
            getStandardPathFields().get(36).getNeighbours().add(getStandardPathFields().get(37));
            removalList.remove(b);

            return b;

        }

        if(counter == 2){
            Blockade b = getStandardPathFields().get(70).getBlockadeFromNeighbours();
            getStandardPathFields().get(70).getNeighbours().remove(b);
            getStandardPathFields().get(65).getNeighbours().remove(b);
            getStandardPathFields().get(59).getNeighbours().remove(b);
            getStandardPathFields().get(52).getNeighbours().remove(b);
            getStandardPathFields().get(70).getNeighbours().add(getStandardPathFields().get(74));
            getStandardPathFields().get(65).getNeighbours().add(getStandardPathFields().get(75));
            getStandardPathFields().get(65).getNeighbours().add(getStandardPathFields().get(74));
            getStandardPathFields().get(59).getNeighbours().add(getStandardPathFields().get(76));
            getStandardPathFields().get(59).getNeighbours().add(getStandardPathFields().get(75));
            getStandardPathFields().get(52).getNeighbours().add(getStandardPathFields().get(76));
            getStandardPathFields().get(52).getNeighbours().add(getStandardPathFields().get(77));
            removalList.remove(b);

            return b;
        }
        if(counter == 3){
            Blockade b = getStandardPathFields().get(107).getBlockadeFromNeighbours();
            getStandardPathFields().get(107).getNeighbours().remove(b);
            getStandardPathFields().get(108).getNeighbours().remove(b);
            getStandardPathFields().get(109).getNeighbours().remove(b);
            getStandardPathFields().get(110).getNeighbours().remove(b);
            getStandardPathFields().get(107).getNeighbours().add(getStandardPathFields().get(111));
            getStandardPathFields().get(107).getNeighbours().add(getStandardPathFields().get(112));
            getStandardPathFields().get(108).getNeighbours().add(getStandardPathFields().get(112));
            getStandardPathFields().get(108).getNeighbours().add(getStandardPathFields().get(113));
            getStandardPathFields().get(109).getNeighbours().add(getStandardPathFields().get(113));
            getStandardPathFields().get(109).getNeighbours().add(getStandardPathFields().get(114));
            getStandardPathFields().get(110).getNeighbours().add(getStandardPathFields().get(114));
            removalList.remove(b);

            return b;

        }

        if(counter == 4){
            Blockade b = getStandardPathFields().get(147).getBlockadeFromNeighbours();
            getStandardPathFields().get(147).getNeighbours().remove(b);
            getStandardPathFields().get(143).getNeighbours().remove(b);
            getStandardPathFields().get(138).getNeighbours().remove(b);
            getStandardPathFields().get(132).getNeighbours().remove(b);
            getStandardPathFields().get(147).getNeighbours().add(getStandardPathFields().get(148));
            getStandardPathFields().get(143).getNeighbours().add(getStandardPathFields().get(148));
            getStandardPathFields().get(143).getNeighbours().add(getStandardPathFields().get(149));
            getStandardPathFields().get(138).getNeighbours().add(getStandardPathFields().get(149));
            getStandardPathFields().get(138).getNeighbours().add(getStandardPathFields().get(150));
            getStandardPathFields().get(132).getNeighbours().add(getStandardPathFields().get(150));
            getStandardPathFields().get(132).getNeighbours().add(getStandardPathFields().get(151));
            removalList.remove(b);

            return b;
        }


        return null;
    }



    public Blockade removeHillsOfGold(Integer counter){
        if(counter == 1){

            Blockade b = getHillsOfGoldFields().get(21).getBlockadeFromNeighbours();
            getHillsOfGoldFields().get(21).getNeighbours().remove(b);
            getHillsOfGoldFields().get(27).getNeighbours().remove(b);
            getHillsOfGoldFields().get(32).getNeighbours().remove(b);
            getHillsOfGoldFields().get(36).getNeighbours().remove(b);
            getHillsOfGoldFields().get(21).getNeighbours().add(getHillsOfGoldFields().get(52));
            getHillsOfGoldFields().get(21).getNeighbours().add(getHillsOfGoldFields().get(59));
            getHillsOfGoldFields().get(27).getNeighbours().add(getHillsOfGoldFields().get(59));
            getHillsOfGoldFields().get(27).getNeighbours().add(getHillsOfGoldFields().get(65));
            getHillsOfGoldFields().get(32).getNeighbours().add(getHillsOfGoldFields().get(65));
            getHillsOfGoldFields().get(32).getNeighbours().add(getHillsOfGoldFields().get(70));
            getHillsOfGoldFields().get(36).getNeighbours().add(getHillsOfGoldFields().get(70));
            removalList.remove(b);


            return b;

        }

        if(counter == 2){
            Blockade b = getHillsOfGoldFields().get(40).getBlockadeFromNeighbours();
            getHillsOfGoldFields().get(40).getNeighbours().remove(b);
            getHillsOfGoldFields().get(45).getNeighbours().remove(b);
            getHillsOfGoldFields().get(51).getNeighbours().remove(b);
            getHillsOfGoldFields().get(58).getNeighbours().remove(b);
            getHillsOfGoldFields().get(40).getNeighbours().add(getHillsOfGoldFields().get(74));
            getHillsOfGoldFields().get(45).getNeighbours().add(getHillsOfGoldFields().get(74));
            getHillsOfGoldFields().get(45).getNeighbours().add(getHillsOfGoldFields().get(78));
            getHillsOfGoldFields().get(51).getNeighbours().add(getHillsOfGoldFields().get(78));
            getHillsOfGoldFields().get(51).getNeighbours().add(getHillsOfGoldFields().get(83));
            getHillsOfGoldFields().get(58).getNeighbours().add(getHillsOfGoldFields().get(83));
            getHillsOfGoldFields().get(58).getNeighbours().add(getHillsOfGoldFields().get(89));
            removalList.remove(b);


            return b;
        }
        if(counter == 3){
            Blockade b = getHillsOfGoldFields().get(107).getBlockadeFromNeighbours();
            getHillsOfGoldFields().get(89).getNeighbours().remove(b);
            getHillsOfGoldFields().get(96).getNeighbours().remove(b);
            getHillsOfGoldFields().get(102).getNeighbours().remove(b);
            getHillsOfGoldFields().get(107).getNeighbours().remove(b);
            getHillsOfGoldFields().get(89).getNeighbours().add(getHillsOfGoldFields().get(111));
            getHillsOfGoldFields().get(96).getNeighbours().add(getHillsOfGoldFields().get(111));
            getHillsOfGoldFields().get(96).getNeighbours().add(getHillsOfGoldFields().get(112));
            getHillsOfGoldFields().get(102).getNeighbours().add(getHillsOfGoldFields().get(112));
            getHillsOfGoldFields().get(102).getNeighbours().add(getHillsOfGoldFields().get(113));
            getHillsOfGoldFields().get(107).getNeighbours().add(getHillsOfGoldFields().get(113));
            getHillsOfGoldFields().get(107).getNeighbours().add(getHillsOfGoldFields().get(114));
            removalList.remove(b);


            return b;

        }

        if(counter == 4){
            Blockade b = getHillsOfGoldFields().get(144).getBlockadeFromNeighbours();
            getHillsOfGoldFields().get(144).getNeighbours().remove(b);
            getHillsOfGoldFields().get(145).getNeighbours().remove(b);
            getHillsOfGoldFields().get(146).getNeighbours().remove(b);
            getHillsOfGoldFields().get(147).getNeighbours().remove(b);
            getHillsOfGoldFields().get(144).getNeighbours().add(getHillsOfGoldFields().get(148));
            getHillsOfGoldFields().get(144).getNeighbours().add(getHillsOfGoldFields().get(149));
            getHillsOfGoldFields().get(145).getNeighbours().add(getHillsOfGoldFields().get(149));
            getHillsOfGoldFields().get(145).getNeighbours().add(getHillsOfGoldFields().get(150));
            getHillsOfGoldFields().get(146).getNeighbours().add(getHillsOfGoldFields().get(150));
            getHillsOfGoldFields().get(146).getNeighbours().add(getHillsOfGoldFields().get(151));
            getHillsOfGoldFields().get(147).getNeighbours().add(getHillsOfGoldFields().get(151));
            removalList.remove(b);


            return b;
        }
        if (counter == 5){
            Blockade b = getHillsOfGoldFields().get(184).getBlockadeFromNeighbours();
            getHillsOfGoldFields().get(184).getNeighbours().remove(b);
            getHillsOfGoldFields().get(180).getNeighbours().remove(b);
            getHillsOfGoldFields().get(175).getNeighbours().remove(b);
            getHillsOfGoldFields().get(169).getNeighbours().remove(b);
            getHillsOfGoldFields().get(184).getNeighbours().add(getHillsOfGoldFields().get(221));
            getHillsOfGoldFields().get(184).getNeighbours().add(getHillsOfGoldFields().get(220));
            getHillsOfGoldFields().get(180).getNeighbours().add(getHillsOfGoldFields().get(220));
            getHillsOfGoldFields().get(180).getNeighbours().add(getHillsOfGoldFields().get(219));
            getHillsOfGoldFields().get(175).getNeighbours().add(getHillsOfGoldFields().get(219));
            getHillsOfGoldFields().get(175).getNeighbours().add(getHillsOfGoldFields().get(218));
            getHillsOfGoldFields().get(169).getNeighbours().add(getHillsOfGoldFields().get(218));
            removalList.remove(b);

            return b;

        }

        return null;
    }


    public Blockade removeHomeStretch(Integer counter){
        if(counter == 1){

            Blockade b = getHomeStretchFields().get(21).getBlockadeFromNeighbours();
            getHomeStretchFields().get(21).getNeighbours().remove(b);
            getHomeStretchFields().get(27).getNeighbours().remove(b);
            getHomeStretchFields().get(32).getNeighbours().remove(b);
            getHomeStretchFields().get(36).getNeighbours().remove(b);
            getHomeStretchFields().get(21).getNeighbours().add(getHomeStretchFields().get(40));
            getHomeStretchFields().get(27).getNeighbours().add(getHomeStretchFields().get(40));
            getHomeStretchFields().get(27).getNeighbours().add(getHomeStretchFields().get(39));
            getHomeStretchFields().get(32).getNeighbours().add(getHomeStretchFields().get(39));
            getHomeStretchFields().get(32).getNeighbours().add(getHomeStretchFields().get(38));
            getHomeStretchFields().get(36).getNeighbours().add(getHomeStretchFields().get(38));
            getHomeStretchFields().get(36).getNeighbours().add(getHomeStretchFields().get(37));
            removalList.remove(b);


            return b;

        }

        if(counter == 2){
            Blockade b = getHomeStretchFields().get(52).getBlockadeFromNeighbours();
            getHomeStretchFields().get(52).getNeighbours().remove(b);
            getHomeStretchFields().get(59).getNeighbours().remove(b);
            getHomeStretchFields().get(65).getNeighbours().remove(b);
            getHomeStretchFields().get(70).getNeighbours().remove(b);
            getHomeStretchFields().get(52).getNeighbours().add(getHomeStretchFields().get(74));
            getHomeStretchFields().get(52).getNeighbours().add(getHomeStretchFields().get(75));
            getHomeStretchFields().get(59).getNeighbours().add(getHomeStretchFields().get(75));
            getHomeStretchFields().get(59).getNeighbours().add(getHomeStretchFields().get(76));
            getHomeStretchFields().get(65).getNeighbours().add(getHomeStretchFields().get(76));
            getHomeStretchFields().get(65).getNeighbours().add(getHomeStretchFields().get(77));
            getHomeStretchFields().get(70).getNeighbours().add(getHomeStretchFields().get(77));
            getHomeStretchFields().get(70).getNeighbours().add(getHomeStretchFields().get(78));
            removalList.remove(b);


            return b;
        }
        if(counter == 3){
            Blockade b = getHomeStretchFields().get(85).getBlockadeFromNeighbours();
            getHomeStretchFields().get(85).getNeighbours().remove(b);
            getHomeStretchFields().get(86).getNeighbours().remove(b);
            getHomeStretchFields().get(87).getNeighbours().remove(b);
            getHomeStretchFields().get(88).getNeighbours().remove(b);
            getHomeStretchFields().get(89).getNeighbours().remove(b);
            getHomeStretchFields().get(85).getNeighbours().add(getHomeStretchFields().get(90));
            getHomeStretchFields().get(86).getNeighbours().add(getHomeStretchFields().get(90));
            getHomeStretchFields().get(86).getNeighbours().add(getHomeStretchFields().get(91));
            getHomeStretchFields().get(87).getNeighbours().add(getHomeStretchFields().get(91));
            getHomeStretchFields().get(87).getNeighbours().add(getHomeStretchFields().get(92));
            getHomeStretchFields().get(88).getNeighbours().add(getHomeStretchFields().get(92));
            getHomeStretchFields().get(88).getNeighbours().add(getHomeStretchFields().get(93));
            getHomeStretchFields().get(89).getNeighbours().add(getHomeStretchFields().get(93));
            removalList.remove(b);


            return b;

        }

        if(counter == 4){
            Blockade b = getHomeStretchFields().get(123).getBlockadeFromNeighbours();
            getHomeStretchFields().get(123).getNeighbours().remove(b);
            getHomeStretchFields().get(124).getNeighbours().remove(b);
            getHomeStretchFields().get(125).getNeighbours().remove(b);
            getHomeStretchFields().get(126).getNeighbours().remove(b);
            getHomeStretchFields().get(123).getNeighbours().add(getHomeStretchFields().get(127));
            getHomeStretchFields().get(124).getNeighbours().add(getHomeStretchFields().get(127));
            getHomeStretchFields().get(124).getNeighbours().add(getHomeStretchFields().get(128));
            getHomeStretchFields().get(125).getNeighbours().add(getHomeStretchFields().get(128));
            getHomeStretchFields().get(125).getNeighbours().add(getHomeStretchFields().get(129));
            getHomeStretchFields().get(126).getNeighbours().add(getHomeStretchFields().get(129));
            getHomeStretchFields().get(126).getNeighbours().add(getHomeStretchFields().get(150));
            removalList.remove(b);


            return b;
        }
        if (counter == 5){
            Blockade b = getHomeStretchFields().get(160).getBlockadeFromNeighbours();
            getHomeStretchFields().get(160).getNeighbours().remove(b);
            getHomeStretchFields().get(161).getNeighbours().remove(b);
            getHomeStretchFields().get(162).getNeighbours().remove(b);
            getHomeStretchFields().get(163).getNeighbours().remove(b);
            getHomeStretchFields().get(160).getNeighbours().add(getHomeStretchFields().get(179));
            getHomeStretchFields().get(160).getNeighbours().add(getHomeStretchFields().get(173));
            getHomeStretchFields().get(161).getNeighbours().add(getHomeStretchFields().get(173));
            getHomeStretchFields().get(161).getNeighbours().add(getHomeStretchFields().get(168));
            getHomeStretchFields().get(162).getNeighbours().add(getHomeStretchFields().get(168));
            getHomeStretchFields().get(162).getNeighbours().add(getHomeStretchFields().get(164));
            getHomeStretchFields().get(163).getNeighbours().add(getHomeStretchFields().get(164));
            removalList.remove(b);


            return b;

        }

        return null;
    }

    public Blockade removeWindingPaths(Integer counter){
        if(counter == 1){

            Blockade b = getWindingPathsFields().get(21).getBlockadeFromNeighbours();
            getWindingPathsFields().get(21).getNeighbours().remove(b);
            getWindingPathsFields().get(27).getNeighbours().remove(b);
            getWindingPathsFields().get(32).getNeighbours().remove(b);
            getWindingPathsFields().get(36).getNeighbours().remove(b);
            getWindingPathsFields().get(21).getNeighbours().add(getWindingPathsFields().get(70));
            getWindingPathsFields().get(27).getNeighbours().add(getWindingPathsFields().get(70));
            getWindingPathsFields().get(27).getNeighbours().add(getWindingPathsFields().get(71));
            getWindingPathsFields().get(32).getNeighbours().add(getWindingPathsFields().get(71));
            getWindingPathsFields().get(32).getNeighbours().add(getWindingPathsFields().get(72));
            getWindingPathsFields().get(36).getNeighbours().add(getWindingPathsFields().get(72));
            getWindingPathsFields().get(36).getNeighbours().add(getWindingPathsFields().get(73));
            removalList.remove(b);


            return b;

        }

        if(counter == 2){
            Blockade b = getWindingPathsFields().get(58).getBlockadeFromNeighbours();
            getWindingPathsFields().get(58).getNeighbours().remove(b);
            getWindingPathsFields().get(51).getNeighbours().remove(b);
            getWindingPathsFields().get(45).getNeighbours().remove(b);
            getWindingPathsFields().get(40).getNeighbours().remove(b);
            getWindingPathsFields().get(58).getNeighbours().add(getWindingPathsFields().get(74));
            getWindingPathsFields().get(51).getNeighbours().add(getWindingPathsFields().get(74));
            getWindingPathsFields().get(51).getNeighbours().add(getWindingPathsFields().get(75));
            getWindingPathsFields().get(45).getNeighbours().add(getWindingPathsFields().get(75));
            getWindingPathsFields().get(45).getNeighbours().add(getWindingPathsFields().get(76));
            getWindingPathsFields().get(40).getNeighbours().add(getWindingPathsFields().get(76));
            getWindingPathsFields().get(40).getNeighbours().add(getWindingPathsFields().get(77));
            removalList.remove(b);


            return b;
        }
        if(counter == 3){
            Blockade b = getWindingPathsFields().get(89).getBlockadeFromNeighbours();
            getWindingPathsFields().get(89).getNeighbours().remove(b);
            getWindingPathsFields().get(96).getNeighbours().remove(b);
            getWindingPathsFields().get(102).getNeighbours().remove(b);
            getWindingPathsFields().get(107).getNeighbours().remove(b);
            getWindingPathsFields().get(89).getNeighbours().add(getWindingPathsFields().get(144));
            getWindingPathsFields().get(96).getNeighbours().add(getWindingPathsFields().get(144));
            getWindingPathsFields().get(96).getNeighbours().add(getWindingPathsFields().get(139));
            getWindingPathsFields().get(102).getNeighbours().add(getWindingPathsFields().get(139));
            getWindingPathsFields().get(102).getNeighbours().add(getWindingPathsFields().get(133));
            getWindingPathsFields().get(107).getNeighbours().add(getWindingPathsFields().get(133));
            getWindingPathsFields().get(107).getNeighbours().add(getWindingPathsFields().get(126));
            removalList.remove(b);


            return b;

        }

        if(counter == 4){
            Blockade b = getWindingPathsFields().get(111).getBlockadeFromNeighbours();
            getWindingPathsFields().get(111).getNeighbours().remove(b);
            getWindingPathsFields().get(115).getNeighbours().remove(b);
            getWindingPathsFields().get(120).getNeighbours().remove(b);
            getWindingPathsFields().get(126).getNeighbours().remove(b);
            getWindingPathsFields().get(111).getNeighbours().add(getWindingPathsFields().get(181));
            getWindingPathsFields().get(111).getNeighbours().add(getWindingPathsFields().get(176));
            getWindingPathsFields().get(115).getNeighbours().add(getWindingPathsFields().get(176));
            getWindingPathsFields().get(115).getNeighbours().add(getWindingPathsFields().get(170));
            getWindingPathsFields().get(120).getNeighbours().add(getWindingPathsFields().get(170));
            getWindingPathsFields().get(120).getNeighbours().add(getWindingPathsFields().get(163));
            getWindingPathsFields().get(126).getNeighbours().add(getWindingPathsFields().get(163));
            removalList.remove(b);

            return b;
        }
        if (counter == 5){
            Blockade b = getWindingPathsFields().get(184).getBlockadeFromNeighbours();
            getWindingPathsFields().get(184).getNeighbours().remove(b);
            getWindingPathsFields().get(180).getNeighbours().remove(b);
            getWindingPathsFields().get(175).getNeighbours().remove(b);
            getWindingPathsFields().get(169).getNeighbours().remove(b);
            getWindingPathsFields().get(184).getNeighbours().add(getWindingPathsFields().get(221));
            getWindingPathsFields().get(180).getNeighbours().add(getWindingPathsFields().get(221));
            getWindingPathsFields().get(180).getNeighbours().add(getWindingPathsFields().get(220));
            getWindingPathsFields().get(175).getNeighbours().add(getWindingPathsFields().get(220));
            getWindingPathsFields().get(175).getNeighbours().add(getWindingPathsFields().get(219));
            getWindingPathsFields().get(169).getNeighbours().add(getWindingPathsFields().get(219));
            getWindingPathsFields().get(169).getNeighbours().add(getWindingPathsFields().get(218));
            removalList.remove(b);


            return b;

        }

        return null;
    }

    public Blockade removeSerpentine(Integer counter){
        if(counter == 1){

            Blockade b = getSerpentineFields().get(21).getBlockadeFromNeighbours();
            getSerpentineFields().get(21).getNeighbours().remove(b);
            getSerpentineFields().get(27).getNeighbours().remove(b);
            getSerpentineFields().get(32).getNeighbours().remove(b);
            getSerpentineFields().get(36).getNeighbours().remove(b);
            getSerpentineFields().get(21).getNeighbours().add(getSerpentineFields().get(58));
            getSerpentineFields().get(27).getNeighbours().add(getSerpentineFields().get(58));
            getSerpentineFields().get(27).getNeighbours().add(getSerpentineFields().get(64));
            getSerpentineFields().get(32).getNeighbours().add(getSerpentineFields().get(64));
            getSerpentineFields().get(32).getNeighbours().add(getSerpentineFields().get(69));
            getSerpentineFields().get(36).getNeighbours().add(getSerpentineFields().get(69));
            getSerpentineFields().get(36).getNeighbours().add(getSerpentineFields().get(73));
            removalList.remove(b);


            return b;

        }

        if(counter == 2){
            Blockade b = getSerpentineFields().get(58).getBlockadeFromNeighbours();
            getSerpentineFields().get(52).getNeighbours().remove(b);
            getSerpentineFields().get(59).getNeighbours().remove(b);
            getSerpentineFields().get(65).getNeighbours().remove(b);
            getSerpentineFields().get(70).getNeighbours().remove(b);
            getSerpentineFields().get(52).getNeighbours().add(getSerpentineFields().get(74));
            getSerpentineFields().get(59).getNeighbours().add(getSerpentineFields().get(74));
            getSerpentineFields().get(59).getNeighbours().add(getSerpentineFields().get(75));
            getSerpentineFields().get(65).getNeighbours().add(getSerpentineFields().get(75));
            getSerpentineFields().get(65).getNeighbours().add(getSerpentineFields().get(76));
            getSerpentineFields().get(70).getNeighbours().add(getSerpentineFields().get(76));
            getSerpentineFields().get(70).getNeighbours().add(getSerpentineFields().get(77));
            removalList.remove(b);


            return b;
        }
        if(counter == 3){
            Blockade b = getSerpentineFields().get(95).getBlockadeFromNeighbours();
            getSerpentineFields().get(95).getNeighbours().remove(b);
            getSerpentineFields().get(88).getNeighbours().remove(b);
            getSerpentineFields().get(82).getNeighbours().remove(b);
            getSerpentineFields().get(77).getNeighbours().remove(b);
            getSerpentineFields().get(95).getNeighbours().add(getSerpentineFields().get(126));
            getSerpentineFields().get(95).getNeighbours().add(getSerpentineFields().get(120));
            getSerpentineFields().get(88).getNeighbours().add(getSerpentineFields().get(120));
            getSerpentineFields().get(88).getNeighbours().add(getSerpentineFields().get(115));
            getSerpentineFields().get(82).getNeighbours().add(getSerpentineFields().get(115));
            getSerpentineFields().get(82).getNeighbours().add(getSerpentineFields().get(111));
            getSerpentineFields().get(77).getNeighbours().add(getSerpentineFields().get(111));
            removalList.remove(b);

            return b;

        }

        if(counter == 4){
            Blockade b = getSerpentineFields().get(143).getBlockadeFromNeighbours();
            getSerpentineFields().get(143).getNeighbours().remove(b);
            getSerpentineFields().get(138).getNeighbours().remove(b);
            getSerpentineFields().get(132).getNeighbours().remove(b);
            getSerpentineFields().get(126).getNeighbours().remove(b);
            getSerpentineFields().get(143).getNeighbours().add(getSerpentineFields().get(181));
            getSerpentineFields().get(143).getNeighbours().add(getSerpentineFields().get(182));
            getSerpentineFields().get(138).getNeighbours().add(getSerpentineFields().get(182));
            getSerpentineFields().get(138).getNeighbours().add(getSerpentineFields().get(183));
            getSerpentineFields().get(132).getNeighbours().add(getSerpentineFields().get(183));
            getSerpentineFields().get(132).getNeighbours().add(getSerpentineFields().get(184));
            getSerpentineFields().get(126).getNeighbours().add(getSerpentineFields().get(184));
            removalList.remove(b);

            return b;
        }
        if (counter == 5){
            Blockade b = getSerpentineFields().get(169).getBlockadeFromNeighbours();
            getSerpentineFields().get(169).getNeighbours().remove(b);
            getSerpentineFields().get(162).getNeighbours().remove(b);
            getSerpentineFields().get(156).getNeighbours().remove(b);
            getSerpentineFields().get(151).getNeighbours().remove(b);
            getSerpentineFields().get(169).getNeighbours().add(getSerpentineFields().get(185));
            getSerpentineFields().get(162).getNeighbours().add(getSerpentineFields().get(185));
            getSerpentineFields().get(162).getNeighbours().add(getSerpentineFields().get(186));
            getSerpentineFields().get(156).getNeighbours().add(getSerpentineFields().get(186));
            getSerpentineFields().get(156).getNeighbours().add(getSerpentineFields().get(187));
            getSerpentineFields().get(151).getNeighbours().add(getSerpentineFields().get(187));
            getSerpentineFields().get(151).getNeighbours().add(getSerpentineFields().get(188));
            removalList.remove(b);


            return b;

        }

        return null;
    }


    public Blockade removeSwamplands(Integer counter){
        if(counter == 1){

            Blockade b = getSwamplandsFields().get(21).getBlockadeFromNeighbours();
            getSwamplandsFields().get(21).getNeighbours().remove(b);
            getSwamplandsFields().get(27).getNeighbours().remove(b);
            getSwamplandsFields().get(32).getNeighbours().remove(b);
            getSwamplandsFields().get(36).getNeighbours().remove(b);
            getSwamplandsFields().get(21).getNeighbours().add(getSwamplandsFields().get(37));
            getSwamplandsFields().get(21).getNeighbours().add(getSwamplandsFields().get(38));
            getSwamplandsFields().get(27).getNeighbours().add(getSwamplandsFields().get(38));
            getSwamplandsFields().get(27).getNeighbours().add(getSwamplandsFields().get(39));
            getSwamplandsFields().get(32).getNeighbours().add(getSwamplandsFields().get(39));
            getSwamplandsFields().get(32).getNeighbours().add(getSwamplandsFields().get(40));
            getSwamplandsFields().get(36).getNeighbours().add(getSwamplandsFields().get(40));
            getSwamplandsFields().get(36).getNeighbours().add(getSwamplandsFields().get(41));
            removalList.remove(b);


            return b;

        }

        if(counter == 2){
            Blockade b = getSwamplandsFields().get(48).getBlockadeFromNeighbours();
            getSwamplandsFields().get(48).getNeighbours().remove(b);
            getSwamplandsFields().get(49).getNeighbours().remove(b);
            getSwamplandsFields().get(50).getNeighbours().remove(b);
            getSwamplandsFields().get(51).getNeighbours().remove(b);
            getSwamplandsFields().get(52).getNeighbours().remove(b);
            getSwamplandsFields().get(48).getNeighbours().add(getSwamplandsFields().get(53));
            getSwamplandsFields().get(49).getNeighbours().add(getSwamplandsFields().get(53));
            getSwamplandsFields().get(49).getNeighbours().add(getSwamplandsFields().get(54));
            getSwamplandsFields().get(50).getNeighbours().add(getSwamplandsFields().get(54));
            getSwamplandsFields().get(50).getNeighbours().add(getSwamplandsFields().get(55));
            getSwamplandsFields().get(51).getNeighbours().add(getSwamplandsFields().get(55));
            getSwamplandsFields().get(51).getNeighbours().add(getSwamplandsFields().get(56));
            getSwamplandsFields().get(52).getNeighbours().add(getSwamplandsFields().get(56));
            removalList.remove(b);


            return b;
        }
        if(counter == 3){
            Blockade b = getSwamplandsFields().get(68).getBlockadeFromNeighbours();
            getSwamplandsFields().get(68).getNeighbours().remove(b);
            getSwamplandsFields().get(75).getNeighbours().remove(b);
            getSwamplandsFields().get(81).getNeighbours().remove(b);
            getSwamplandsFields().get(86).getNeighbours().remove(b);
            getSwamplandsFields().get(68).getNeighbours().add(getSwamplandsFields().get(90));
            getSwamplandsFields().get(68).getNeighbours().add(getSwamplandsFields().get(91));
            getSwamplandsFields().get(75).getNeighbours().add(getSwamplandsFields().get(91));
            getSwamplandsFields().get(75).getNeighbours().add(getSwamplandsFields().get(92));
            getSwamplandsFields().get(81).getNeighbours().add(getSwamplandsFields().get(92));
            getSwamplandsFields().get(81).getNeighbours().add(getSwamplandsFields().get(93));
            getSwamplandsFields().get(86).getNeighbours().add(getSwamplandsFields().get(93));
            removalList.remove(b);

            return b;

        }

        if(counter == 4){
            Blockade b = getSwamplandsFields().get(123).getBlockadeFromNeighbours();
            getSwamplandsFields().get(123).getNeighbours().remove(b);
            getSwamplandsFields().get(124).getNeighbours().remove(b);
            getSwamplandsFields().get(125).getNeighbours().remove(b);
            getSwamplandsFields().get(126).getNeighbours().remove(b);
            getSwamplandsFields().get(123).getNeighbours().add(getSwamplandsFields().get(130));
            getSwamplandsFields().get(123).getNeighbours().add(getSwamplandsFields().get(135));
            getSwamplandsFields().get(124).getNeighbours().add(getSwamplandsFields().get(135));
            getSwamplandsFields().get(124).getNeighbours().add(getSwamplandsFields().get(141));
            getSwamplandsFields().get(125).getNeighbours().add(getSwamplandsFields().get(141));
            getSwamplandsFields().get(125).getNeighbours().add(getSwamplandsFields().get(148));
            getSwamplandsFields().get(126).getNeighbours().add(getSwamplandsFields().get(148));
            removalList.remove(b);

            return b;
        }
        if (counter == 5){
            Blockade b = getSwamplandsFields().get(127).getBlockadeFromNeighbours();
            getSwamplandsFields().get(127).getNeighbours().remove(b);
            getSwamplandsFields().get(128).getNeighbours().remove(b);
            getSwamplandsFields().get(129).getNeighbours().remove(b);
            getSwamplandsFields().get(130).getNeighbours().remove(b);
            getSwamplandsFields().get(127).getNeighbours().add(getSwamplandsFields().get(176));
            getSwamplandsFields().get(127).getNeighbours().add(getSwamplandsFields().get(177));
            getSwamplandsFields().get(128).getNeighbours().add(getSwamplandsFields().get(177));
            getSwamplandsFields().get(128).getNeighbours().add(getSwamplandsFields().get(178));
            getSwamplandsFields().get(129).getNeighbours().add(getSwamplandsFields().get(178));
            getSwamplandsFields().get(129).getNeighbours().add(getSwamplandsFields().get(179));
            getSwamplandsFields().get(130).getNeighbours().add(getSwamplandsFields().get(179));
            removalList.remove(b);


            return b;

        }if (counter == 6){
            Blockade b = getSwamplandsFields().get(164).getBlockadeFromNeighbours();
            getSwamplandsFields().get(164).getNeighbours().remove(b);
            getSwamplandsFields().get(165).getNeighbours().remove(b);
            getSwamplandsFields().get(166).getNeighbours().remove(b);
            getSwamplandsFields().get(167).getNeighbours().remove(b);
            getSwamplandsFields().get(168).getNeighbours().remove(b);
            getSwamplandsFields().get(164).getNeighbours().add(getSwamplandsFields().get(213));
            getSwamplandsFields().get(165).getNeighbours().add(getSwamplandsFields().get(213));
            getSwamplandsFields().get(165).getNeighbours().add(getSwamplandsFields().get(214));
            getSwamplandsFields().get(166).getNeighbours().add(getSwamplandsFields().get(214));
            getSwamplandsFields().get(166).getNeighbours().add(getSwamplandsFields().get(215));
            getSwamplandsFields().get(167).getNeighbours().add(getSwamplandsFields().get(215));
            getSwamplandsFields().get(167).getNeighbours().add(getSwamplandsFields().get(216));
            getSwamplandsFields().get(168).getNeighbours().add(getSwamplandsFields().get(216));
            removalList.remove(b);


            return b;
        }

        return null;
    }


    public Blockade removeWitchsCauldron(Integer counter){
        if(counter == 1){

            Blockade b = getWitchsCauldronFields().get(21).getBlockadeFromNeighbours();
            getWitchsCauldronFields().get(21).getNeighbours().remove(b);
            getWitchsCauldronFields().get(27).getNeighbours().remove(b);
            getWitchsCauldronFields().get(32).getNeighbours().remove(b);
            getWitchsCauldronFields().get(36).getNeighbours().remove(b);
            getWitchsCauldronFields().get(21).getNeighbours().add(getWitchsCauldronFields().get(37));
            getWitchsCauldronFields().get(27).getNeighbours().add(getWitchsCauldronFields().get(37));
            getWitchsCauldronFields().get(27).getNeighbours().add(getWitchsCauldronFields().get(38));
            getWitchsCauldronFields().get(32).getNeighbours().add(getWitchsCauldronFields().get(38));
            getWitchsCauldronFields().get(32).getNeighbours().add(getWitchsCauldronFields().get(39));
            getWitchsCauldronFields().get(36).getNeighbours().add(getWitchsCauldronFields().get(39));
            getWitchsCauldronFields().get(36).getNeighbours().add(getWitchsCauldronFields().get(40));
            removalList.remove(b);

            return b;

        }

        if(counter == 2){
            Blockade b = getWitchsCauldronFields().get(70).getBlockadeFromNeighbours();
            getWitchsCauldronFields().get(70).getNeighbours().remove(b);
            getWitchsCauldronFields().get(71).getNeighbours().remove(b);
            getWitchsCauldronFields().get(72).getNeighbours().remove(b);
            getWitchsCauldronFields().get(73).getNeighbours().remove(b);
            getWitchsCauldronFields().get(70).getNeighbours().add(getWitchsCauldronFields().get(74));
            getWitchsCauldronFields().get(70).getNeighbours().add(getWitchsCauldronFields().get(75));
            getWitchsCauldronFields().get(71).getNeighbours().add(getWitchsCauldronFields().get(75));
            getWitchsCauldronFields().get(71).getNeighbours().add(getWitchsCauldronFields().get(76));
            getWitchsCauldronFields().get(72).getNeighbours().add(getWitchsCauldronFields().get(76));
            getWitchsCauldronFields().get(72).getNeighbours().add(getWitchsCauldronFields().get(77));
            getWitchsCauldronFields().get(73).getNeighbours().add(getWitchsCauldronFields().get(77));
            removalList.remove(b);


            return b;
        }
        if(counter == 3){
            Blockade b = getWitchsCauldronFields().get(89).getBlockadeFromNeighbours();
            getWitchsCauldronFields().get(89).getNeighbours().remove(b);
            getWitchsCauldronFields().get(96).getNeighbours().remove(b);
            getWitchsCauldronFields().get(102).getNeighbours().remove(b);
            getWitchsCauldronFields().get(107).getNeighbours().remove(b);
            getWitchsCauldronFields().get(89).getNeighbours().add(getWitchsCauldronFields().get(126));
            getWitchsCauldronFields().get(96).getNeighbours().add(getWitchsCauldronFields().get(126));
            getWitchsCauldronFields().get(96).getNeighbours().add(getWitchsCauldronFields().get(120));
            getWitchsCauldronFields().get(102).getNeighbours().add(getWitchsCauldronFields().get(120));
            getWitchsCauldronFields().get(102).getNeighbours().add(getWitchsCauldronFields().get(115));
            getWitchsCauldronFields().get(107).getNeighbours().add(getWitchsCauldronFields().get(115));
            getWitchsCauldronFields().get(107).getNeighbours().add(getWitchsCauldronFields().get(111));
            removalList.remove(b);


            return b;

        }

        if(counter == 4){
            Blockade b = getWitchsCauldronFields().get(144).getBlockadeFromNeighbours();
            getWitchsCauldronFields().get(144).getNeighbours().remove(b);
            getWitchsCauldronFields().get(145).getNeighbours().remove(b);
            getWitchsCauldronFields().get(146).getNeighbours().remove(b);
            getWitchsCauldronFields().get(147).getNeighbours().remove(b);
            getWitchsCauldronFields().get(144).getNeighbours().add(getWitchsCauldronFields().get(148));
            getWitchsCauldronFields().get(144).getNeighbours().add(getWitchsCauldronFields().get(149));
            getWitchsCauldronFields().get(145).getNeighbours().add(getWitchsCauldronFields().get(149));
            getWitchsCauldronFields().get(145).getNeighbours().add(getWitchsCauldronFields().get(150));
            getWitchsCauldronFields().get(146).getNeighbours().add(getWitchsCauldronFields().get(150));
            getWitchsCauldronFields().get(146).getNeighbours().add(getWitchsCauldronFields().get(151));
            getWitchsCauldronFields().get(147).getNeighbours().add(getWitchsCauldronFields().get(151));
            removalList.remove(b);


            return b;
        }
        if (counter == 5){
            Blockade b = getWitchsCauldronFields().get(163).getBlockadeFromNeighbours();
            getWitchsCauldronFields().get(163).getNeighbours().remove(b);
            getWitchsCauldronFields().get(170).getNeighbours().remove(b);
            getWitchsCauldronFields().get(176).getNeighbours().remove(b);
            getWitchsCauldronFields().get(181).getNeighbours().remove(b);
            getWitchsCauldronFields().get(163).getNeighbours().add(getWitchsCauldronFields().get(200));
            getWitchsCauldronFields().get(170).getNeighbours().add(getWitchsCauldronFields().get(200));
            getWitchsCauldronFields().get(170).getNeighbours().add(getWitchsCauldronFields().get(194));
            getWitchsCauldronFields().get(176).getNeighbours().add(getWitchsCauldronFields().get(194));
            getWitchsCauldronFields().get(176).getNeighbours().add(getWitchsCauldronFields().get(189));
            getWitchsCauldronFields().get(181).getNeighbours().add(getWitchsCauldronFields().get(189));
            getWitchsCauldronFields().get(181).getNeighbours().add(getWitchsCauldronFields().get(185));
            removalList.remove(b);


            return b;

        }

        return null;
    }

    public List<Blockade> getRemovalList() {
        return removalList;
    }
}