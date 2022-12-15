package eapli.base.contract.domain;


import eapli.base.Color.domain.Color;
import eapli.base.Color.domain.ColorDesignation;
import eapli.base.Color.domain.ColorHexCode;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityID;
import junit.framework.TestCase;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

public class ContractTest extends TestCase {


    @Test
    public void testGetContractID() {
        Set<Criticality> criticalities = new HashSet<>();

        ContractID id = new ContractID(15L);
        Contract contract1 = new Contract(criticalities, id);
        ContractID actual = contract1.getContractID();
        assertEquals("Should return the id of the contract created", id, actual);
    }

    public void testAddCriticalityToContract() {
        Set<Criticality> criticalities = new HashSet<>();

        Set<Criticality> expected = new HashSet<>();

        ColorDesignation yellow = new ColorDesignation("yellow");
        ColorHexCode yellowHex = new ColorHexCode("#FFFFF10");
        Color color = new Color(yellow, yellowHex);
        CriticalityID critId = new CriticalityID(15L);
        ContractID id = new ContractID(15L);
        Contract contract1 = new Contract(criticalities, id);
        Criticality criticality = new Criticality(critId, 5, 10, color, 20, 14, 12, 24);

        assertEquals("Shouldn't be equal, criticality hasn't been added yet", expected, contract1.getCriticalities());

        contract1.addCriticalityToContract(criticality);

        expected.add(criticality);

        assertEquals("Should be equal, sets have the same criticalities", expected, contract1.getCriticalities());


    }

    public void testRemoveCriticalityToContract() {
        Set<Criticality> criticalities = new HashSet<>();
        Set<Criticality> expected = new HashSet<>();

        ColorDesignation yellow = new ColorDesignation("yellow");
        ColorHexCode yellowHex = new ColorHexCode("#FFFFF10");
        Color color = new Color(yellow, yellowHex);
        CriticalityID critId = new CriticalityID(15L);
        ContractID id = new ContractID(15L);
        Contract contract1 = new Contract(criticalities, id);
        Criticality criticality = new Criticality(critId, 5, 10, color, 20, 14, 12, 24);
        criticalities.add(criticality);

        assertNotSame("Shouldn't be equal, criticality hasn't been removed yet", expected, contract1.getCriticalities());

        contract1.removeCriticalityToContract(criticality);

        assertEquals("Should be equal, sets have the same criticalities", expected, contract1.getCriticalities());

    }
}