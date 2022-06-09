import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void getResult() {
        assertEquals(10, Solution.getResult("Human", "STWSWTPPTPTTPWPP"));
        assertEquals(12, Solution.getResult("Human", "WPPWWPTPTWSTTWPS"));
        assertEquals(12, Solution.getResult("Swamper", "WPPWWPTPTWSTTWPS"));
        assertEquals(13, Solution.getResult("Woodman", "WPPWWPTPTWSTTWPS"));
        assertEquals(14, Solution.getResult("Human", "PWTSWWWWWWPSWPSW"));
        assertEquals(12, Solution.getResult("Swamper", "PWTSWWWWWWPSWPSW"));
        assertEquals(16, Solution.getResult("Woodman", "PWTSWWWWWWPSWPSW"));
        assertEquals(7, Solution.getResult("Human", "PSSPWPPPSPPPSPTP"));
        assertEquals(12, Solution.getResult("Swamper", "PSSPWPPPSPPPSPTP"));
        assertEquals(13, Solution.getResult("Woodman", "PSSPWPPPSPPPSPTP"));
        assertEquals(11, Solution.getResult("Human", "TTWPPTSSWTTPPWSP"));
        assertEquals(12, Solution.getResult("Swamper", "TTWPPTSSWTTPPWSP"));
        assertEquals(12, Solution.getResult("Woodman", "TTWPPTSSWTTPPWSP"));
        assertEquals(9, Solution.getResult("Human", "STSWTPWPWPPTSTPW"));
        assertEquals(15, Solution.getResult("Swamper", "STSWTPWPWPPTSTPW"));
        assertEquals(13, Solution.getResult("Woodman", "STSWTPWPWPPTSTPW"));
    }
}