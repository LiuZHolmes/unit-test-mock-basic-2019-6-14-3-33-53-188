package cashregister;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
        FakePrinter fakePrinter = new FakePrinter();
        CashRegister cashRegister = new CashRegister(fakePrinter);
        Item[] items = new Item[1];
        items[0] = new Item("name",13.0);
        Purchase purchase = new Purchase(items);
        //when
        cashRegister.process(purchase);
        //then
        Assertions.assertTrue(fakePrinter.hasBeenCalled());
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        FakePrinter fakePrinter = new FakePrinter();
        Item[] items = new Item[1];
        items[0] = new Item("name",13.0);
        FakePurchase fakePurchase = new FakePurchase(items);
        fakePurchase.setText("test");
        CashRegister cashRegister = new CashRegister(fakePrinter);
        //when
        cashRegister.process(fakePurchase);
        //then
        Assertions.assertEquals("test",fakePrinter.getText());
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        String testString = "test";
        Printer printer = mock(Printer.class);
        Purchase purchase = mock(Purchase.class);
        when(purchase.asString()).thenReturn(testString);
        CashRegister cashRegister = new CashRegister(printer);

        //when
        cashRegister.process(purchase);
        //then
        Mockito.verify(printer).print(testString);
    }

}
