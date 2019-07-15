package cashregister;

public class FakePrinter extends Printer {
    private boolean isCalled ;

    public String getText() {
        return text;
    }

    private String text ;

    @Override
    public void print(String printThis) {
        text = printThis;
        isCalled = true;
    }

    public boolean hasBeenCalled() {
        return isCalled;
    }
}
