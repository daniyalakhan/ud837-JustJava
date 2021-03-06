package com.example.android.justjava;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.text.StringCharacterIterator;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        String orderSummary = createOrderSummary(price);
        displayMessage(orderSummary);
    }

    /**
     * Calculates the price of the order.
     */
    private int calculatePrice() {
        int pricePerCup = 5;
        int price = quantity * pricePerCup;
        return price;
    }

    /**
     * Generates the summary of the order.
     * @param totalPrice
     * @return
     */
    private String createOrderSummary(int totalPrice){
        String orderSummary = "Name: DAK" + "\n" + "Quantity: " + quantity + "\n" + "Total: $" + totalPrice;
        orderSummary = orderSummary + "\nThank you!";
        return orderSummary;
    }

    /**
     * This method is called when the plus[+] button is clicked.
     */
    public void increment(View view){
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus[-] button is clicked.
     */
    public void decrement(View view){
        quantity = quantity - 1;
        displayQuantity(quantity);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
