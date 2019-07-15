package cashregister;

public class FakePurchase extends Purchase{
    private String text;

    public FakePurchase(Item[] items) {
        super(items);
    }

    @Override
    public String asString() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
