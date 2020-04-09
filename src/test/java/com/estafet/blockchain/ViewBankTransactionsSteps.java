package com.estafet.blockchain;

import com.estafet.blockchain.demo.data.lib.bank.Account;
import com.estafet.blockchain.demo.data.lib.exchangerate.ExchangeRate;
import com.estafet.blockchain.demo.data.lib.wallet.Wallet;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import static java.lang.Double.parseDouble;
import static org.junit.Assert.assertEquals;

public class ViewBankTransactionsSteps {

    Account account;
    int accountId;

    @Given("This bank account exist:")
    public void setupAccount(DataTable dataTable) {
        Account.deleteAccounts();
        ExchangeRate.setExchangeRate("USD", 10);
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            account = Account.createAccount(list.get(i).get("account name"),list.get(i).get("currency"));
            accountId = account.getId();
        }
    }

    @Given("The account has the following transactions:")
    public void setupTransactions(DataTable dataTable) throws Exception{
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        if (Account.getAccountByName(account.getAccountName()) != null) {
        	System.out.println("Mike: Account Name exists");
        }else {
        	System.out.println("Mike: account doesn't exist");
        	
        		
        }
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).get("transaction").toLowerCase().equals("credit"))
            { Account.creditAccount(account,parseDouble(list.get(i).get("amount")),true);
            account.transactionClearedWait(account.getId());
            }else if(list.get(i).get("transaction").toLowerCase().equals("debit"))
            { String walletAddress = account.getWalletAddress();
                Wallet.banktoWalletTransfer(walletAddress, BigInteger.valueOf(Long.parseLong(list.get(i).get("amount"))), true);
                account.transactionClearedWait(account.getId());
            }else {
                throw new Exception("Unknown transaction type: "+list.get(i).get("transaction"));
            }
            //Thread.sleep(60000);
            System.out.println(account.getBalance(account.getId()));
        }
    }

     @Then("The account balance is (.+)")
    public void verifyAccountBalance(double expectedBalance) {
        for (int i=0;i<12;i++) {
            try {
                account.transactionClearedWait(account.getId());
            } catch (RuntimeException e){System.out.println("Try: "+i);}
        }
        double balance = account.getBalance(account.getId());
        assertEquals(expectedBalance,balance,0);
    }

    @Then("The account status will be (.+)")
    public void verifyAccountStatus(String string) {
        Assert.assertTrue(Account.getLastTransaction(account.getId()).getStatus().equals("CLEARED"));
    }

//    @Test
//    public void testDebitAccount() {
//        Account account =  Account.createCreditedAccount("Shukri Shukriev", "USD",60000);
//        Account.debitAccount(account,250,false);
//        Transaction transaction = Account.getLastTransaction(account.getId());
//        assertEquals(-250.0, transaction.getAmount(),0.1);
//        assertEquals("PENDING", transaction.getStatus());
//    }
}
