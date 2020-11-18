package tools.savers;

import java.util.List;

public interface SaveInterface {
    public void save(List arrayList, String fileName);
    public List load(String fileName);
}
