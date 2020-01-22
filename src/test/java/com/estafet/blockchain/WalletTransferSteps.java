package com.estafet.blockchain;


import com.estafet.blockchain.demo.data.lib.wallet.Wallet;
import com.estafet.blockchain.demo.data.lib.bank.Account;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Before;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class WalletTransferSteps {
//    @Before
//    public void before() {
//        Account.deleteAccounts();
//    }
    @Given("^The following wallets exist:$")
    public void setupWallets(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            Wallet.createCreditedWallet(String.valueOf(list.get(i).get("wallet name")),
                    BigInteger.valueOf(Long.parseLong(list.get(i).get("balance"))));
        }
    }

    @When("(.+) submits a transfer for (.+) to client (.+)")
    public void submitTransfer(String string, int arg1, String string2) throws InterruptedException {
        String senderWalletAddress = Account.getAccountByName(string).getWalletAddress();
        System.out.println(senderWalletAddress);
        String receiverWalletAddress = Account.getAccountByName(string2).getWalletAddress();
        System.out.println(receiverWalletAddress);
        Wallet.wallettoWalletTransfer(senderWalletAddress, receiverWalletAddress, BigInteger.valueOf(arg1), false);
        Thread.sleep(10000);
    }

    @Then("After the wallet (.+) is updated with its balance now equals (.+)")
    public void verifySenderBalance(String string, int arg1) {
        String senderWalletAddress = Account.getAccountByName(string).getWalletAddress();
        System.out.println(senderWalletAddress);
        Integer senderWalletBalance=Wallet.getWallet(senderWalletAddress).getBalance();
               Assert.assertTrue(senderWalletBalance.equals(arg1));
    }

    @Then("(.+) balance is now (.+)")
    public void verifyReceiverBalance(String string, int arg1) {
        String receiverWalletAddress = Account.getAccountByName(string).getWalletAddress();
        System.out.println(receiverWalletAddress);
        Integer receiverWalletBalance=Wallet.getWallet(receiverWalletAddress).getBalance();
        Assert.assertTrue(receiverWalletBalance.equals(arg1));

    }

}
