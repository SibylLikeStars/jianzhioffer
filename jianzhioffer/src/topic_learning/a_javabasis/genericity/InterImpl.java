package topic_learning.a_javabasis.genericity;

public class InterImpl implements InterfaceGen<String> {
    @Override
    public String next() {
        return "huhu";
    }
}
