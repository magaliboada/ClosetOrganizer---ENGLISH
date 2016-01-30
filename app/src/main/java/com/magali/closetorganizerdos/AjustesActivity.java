package com.magali.closetorganizerdos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.magali.closetorganizer.R;

/**
 * Created by Magali on 24/05/2015.
 */
public class AjustesActivity extends Activity implements BillingProcessor.IBillingHandler{

    BillingProcessor bp;
    Button sub = null;
    final Activity act = this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
        sub = (Button)findViewById(R.id.clickButton);

        bp = new BillingProcessor(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuy6txxi76cg+VhCH6UFG4YQDiqQMYpBzIf/Mx0tajxyLTC+QpRU4ydAwWDWQ2JEQ+uwrOHfgvQIG+HbGoMlG5GkDp47U4z2RvPI5ZMblOZyY9AOtXmk6GOF30ROmPwQkZQhf9TUkWexvRCc9LrwtdGbEhVHg5nuzC+qSFK+fTzdnMnMCkxFJfR+KcUfkdPIU8cIfc+KeDzV26HQ50LAbiTYpHeCmHbLiSIgMxMnEW0V3/sNQ1NjI4ZRzmmfdWqryxpEYq5l7hvhpSMXePmO9RE3jT/7zcPpRxnUSNMn9Ke99gFVaoiuixdm8btzVpdGPXNHekFNd7/rSNHSepnkcgwIDAQAB", this);
        sub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                bp.subscribe(act, "heart");
            }
        });
    }
    @Override
    public void onBillingInitialized() {
        /*
         * Called when BillingProcessor was initialized and it's ready to purchase
         */
    }

    @Override
    public void onProductPurchased(String productId, TransactionDetails details) {
        /*
         * Called when requested PRODUCT ID was successfully purchased
         */
    }

    @Override
    public void onBillingError(int errorCode, Throwable error) {
        /*
         * Called when some error occurred. See Constants class for more details
         */
    }

    @Override
    public void onPurchaseHistoryRestored() {
        /*
         * Called when purchase history was restored and the list of all owned PRODUCT ID's
         * was loaded from Google Play
         */
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!bp.handleActivityResult(requestCode, resultCode, data))
            super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onDestroy() {
        if (bp != null)
            bp.release();

        super.onDestroy();
    }

}
