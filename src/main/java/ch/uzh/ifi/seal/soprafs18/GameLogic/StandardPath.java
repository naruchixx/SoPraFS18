package ch.uzh.ifi.seal.soprafs18.GameLogic;

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

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Blockade> currentBlockades = new ArrayList<>();

    public StandardPath(){
        Blockade blockade4= new Blockade("BK4",1,"Blue",false);
        Blockade blockade2= new Blockade("BK2",1,"Yellow",false);
        Blockade blockade1= new Blockade("BK1",1,"Green",false);
        Blockade blockade5= new Blockade("BK5",2,"Green",false);
        Blockade blockade6= new Blockade("BK6",2,"White",false);   /** if blockade is white: play (blockade points) cards to cross, any card is acceptable */
        Blockade blockade3= new Blockade("BK3",1,"White",false);

        Blockades.add(blockade1);
        Blockades.add(blockade2);
        Blockades.add(blockade3);
        Blockades.add(blockade4);
        Blockades.add(blockade5);
        Blockades.add(blockade6);

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

        Blockade first=Blockades.get(0);
        Blockade second=Blockades.get(1);
        Blockade third= Blockades.get(2);
        Blockade fourth= Blockades.get(3);
        Blockade fifth=Blockades.get(4);
        Blockade sixth=Blockades.get(5);

        Field B37StandardPath=B37;
        B37StandardPath.AddNewNeighbour(first);
        Field B33StandardPath=B33;
        B33StandardPath.AddNewNeighbour(first);
        Field B28StandardPath=B28;
        B28StandardPath.AddNewNeighbour(first);
        Field B22StandardPath=B22;
        B22StandardPath.AddNewNeighbour(first);
        first.addNeighbour(B37StandardPath);
        first.addNeighbour(B33StandardPath);
        first.addNeighbour(B28StandardPath);
        first.addNeighbour(B22StandardPath);
        first.addNeighbour(C4);
        first.addNeighbour(C9);
        first.addNeighbour(C15);
        first.addNeighbour(C22);

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
        currentBlockades.add(first);
        currentBlockades.add(second);
        currentBlockades.add(third);
        currentBlockades.add(fourth);

    }


    public void setStandardPathFields(List<Field> standardPathFields) {
        StandardPathFields = standardPathFields;

    }

    public List<Field> getStandardPathFields() {
        return StandardPathFields;
    }

    public List<Blockade> getCurrentBlockades() {
        return currentBlockades;
    }

    @JsonIgnore
    public List<Field> getStarters(){
        List<Field> starters = new ArrayList<>();
        starters.add(StandardPathFields.get(0));
        starters.add(StandardPathFields.get(1));
        starters.add(StandardPathFields.get(2));
        starters.add(StandardPathFields.get(3));

        return starters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Blockade> getBlockades() {
        return Blockades;
    }

    public void setBlockades(List<Blockade> blockades) {
        Blockades = blockades;
    }

    public void setCurrentBlockades(List<Blockade> currentBlockades) {
        this.currentBlockades = currentBlockades;
    }
}