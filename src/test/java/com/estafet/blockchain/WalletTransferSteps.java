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
String senderWalletAddress;
String receiverWalletAddress;

//    @Before
//    public void before() {
//        Account.deleteAccounts();
//    }
@Given("^A sender wallet exists with name (.+), balance of (.+), bank currency (.+) and bank balance of (.+)$")
public void setupSenderWallet(String name, BigInteger walletBalance, String currency, Double bankBalance) throws Throwable {
    Wallet.createCreditedWallet(name, walletBalance);
//    Wallet.createWallet(name, currency, bankBalance);
//    senderWalletAddress = Account.getAccountByName(name).getWalletAddress();
//    System.out.println(senderWalletAddress);
//    Wallet.banktoWalletTransfer(senderWalletAddress, walletBalance, false);

}

   @Given("^A receiver wallet exists with name (.+), balance of (.+), bank currency (.+) and bank balance of (.+)$")
   public void setupReceiverWallet(String name, BigInteger walletBalance, String currency, Double bankBalance) throws Throwable {
  Wallet.createCreditedWallet(name, walletBalance);
//    Wallet.createWallet(name, currency, bankBalance);
//    receiverWalletAddress = Account.getAccountByName(name).getWalletAddress();
//    System.out.println(receiverWalletAddress);
//    Wallet.banktoWalletTransfer(receiverWalletAddress, walletBalance, false);
}


//    @Given("^The following wallets exist:$")
//    public void setupWallets(DataTable dataTable) {
//        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
//            Wallet.createWallet(list.get(i).get("wallet name"), (list.get(i).get("bank currency")), Double.valueOf(list.get(i).get("bank balance")));
//            String senderWalletAddress = Account.getAccountByName(list.get(0).get("wallet name")).getWalletAddress();
//            String receiverWalletAddress = Account.getAccountByName(list.get(1).get("wallet name")).getWalletAddress();
//
//
//        }

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
