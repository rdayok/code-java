package diary;

import java.util.ArrayList;
import java.util.List;

public class RdDiaries {
    private List<RdDiary> listOfDiaries = new ArrayList<>();
    public void addDiary(String username, String password) {
        validateUsername(username);
        RdDiary rdDiary = new RdDiary(username, password);
        listOfDiaries.add(rdDiary);
    }

    private void validateUsername(String username) {
        for (RdDiary diary : listOfDiaries) if(diary.getDiaryUsername().equals(username)) throw new IllegalArgumentException("** This username exist **");
    }

    public RdDiary findDiaryByUsername(String username) {
        for (RdDiary diary : listOfDiaries) if (diary.getDiaryUsername().equals(username)) return diary;
        throw new IllegalArgumentException("** This diary is not found **");
    }

    public void deleteDiary(String username, String password) {
        RdDiary foundDiary = findDiaryByUsername(username);
        foundDiary.unlockDiary(password);
        listOfDiaries.remove(foundDiary);
    }
}
