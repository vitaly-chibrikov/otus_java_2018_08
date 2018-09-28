package lambda;


public class MethodReference {
    @FunctionalInterface
    public interface Finder {
        public int find(String s1, String s2);
        default int find(String s1){ return 0;};
    }

    Finder finder1 = String::indexOf;

    Finder finder2 = (s1, s2) -> s1.indexOf(s2);

}
