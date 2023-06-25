package diary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RdDiariesTest {
    RdDiaries rdDiaries;
    @BeforeEach public void beforeEach(){
        rdDiaries = new RdDiaries();
        rdDiaries.addDiary("username","password");
    }

    @Test public void testDiariesExist(){
        assertNotNull(rdDiaries);
    }

    @Test public void testDiaryCanBeAdded(){

        RdDiary foundDiary = rdDiaries.findDiaryByUsername("username");
        assertEquals("username", foundDiary.getDiaryUsername());
    }

    @Test public void testDiaryCanBeFoundByUserName(){
        rdDiaries.addDiary("user", "password");

        RdDiary foundDiary = rdDiaries.findDiaryByUsername("user");
        assertEquals("user", foundDiary.getDiaryUsername());
    }

    @Test public void testNoDuplicateUsernames(){
        assertThrows(IllegalArgumentException.class, () -> rdDiaries.addDiary("username", "password"));
    }

    @Test public void testDiaryCanBeDeleted(){
        rdDiaries.deleteDiary("username", "password");

        assertThrows(IllegalArgumentException.class, () -> rdDiaries.findDiaryByUsername("username"));
    }

    @Test public void testDeletingDiaryWithWrongPassword(){
        assertThrows(IllegalArgumentException.class, () -> rdDiaries.deleteDiary("username", "passw"));
    }
}
