package eapli.base.TeamType.domain;

import eapli.base.Color.domain.Color;
import eapli.base.Color.domain.ColorDesignation;
import eapli.base.Color.domain.ColorHexCode;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTypeTest {

    @Test
    public void codeColorDesignationAndHexCodeMustNotBeNullOrEmpty() {
        TeamType teamType1 = new TeamType(CodeTeamType.valueOf("1"), "Team Type 1", new Color(ColorDesignation.valueOf("red"), ColorHexCode.valueOf("#FF0000")));
        assertNotNull("Team TypeShould not be Null", teamType1);

    }

    @Test
    public void ensureEqualsPassesForSameTeamType() {
        TeamType teamType1 = new TeamType(CodeTeamType.valueOf("1"), "Team Type 1", new Color(ColorDesignation.valueOf("red"), ColorHexCode.valueOf("#FF0000")));
        TeamType teamType2 = new TeamType(CodeTeamType.valueOf("1"), "Team Type 1", new Color(ColorDesignation.valueOf("red"), ColorHexCode.valueOf("#FF0000")));
        boolean a = teamType1.toString().equals(teamType2.toString());
        assertTrue("Should be True", a);
    }

    @Test
    public void ensureNotEqualsPassesForDifferentCodeTeamType() {
        TeamType teamType1 = new TeamType(CodeTeamType.valueOf("1"), "Team Type 1", new Color(ColorDesignation.valueOf("red"), ColorHexCode.valueOf("#FF0000")));
        TeamType teamType2 = new TeamType(CodeTeamType.valueOf("2"), "Team Type 1", new Color(ColorDesignation.valueOf("red"), ColorHexCode.valueOf("#FF0000")));
        boolean a = teamType1.getCode().equals(teamType2.getCode());
        assertFalse("Should be false", a);
    }

    @Test
    public void ensureNotEqualsPassesForDifferentDesignationTeamType() {
        TeamType teamType1 = new TeamType(CodeTeamType.valueOf("1"), "Team Type 1", new Color(ColorDesignation.valueOf("red"), ColorHexCode.valueOf("#FF0000")));
        TeamType teamType2 = new TeamType(CodeTeamType.valueOf("1"), "Team Type 2", new Color(ColorDesignation.valueOf("red"), ColorHexCode.valueOf("#FF0000")));
        boolean a = teamType1.getDesignation().equals(teamType2.getDesignation());
        assertFalse("Should be false", a);
    }

    @Test
    public void ensureNotEqualsPassesForDifferentColorTeamType() {
        TeamType teamType1 = new TeamType(CodeTeamType.valueOf("1"), "Team Type 1", new Color(ColorDesignation.valueOf("red"), ColorHexCode.valueOf("#FF0000")));
        TeamType teamType2 = new TeamType(CodeTeamType.valueOf("1"), "Team Type 1", new Color(ColorDesignation.valueOf("blue"), ColorHexCode.valueOf("#0000FF")));
        boolean a = teamType1.getColor().equals(teamType2.getColor());
        assertFalse("Should be false", a);
    }


}
