package com.estafet.blockchain;

import com.estafet.blockchain.demo.data.lib.bank.Account;
import com.estafet.blockchain.demo.data.lib.bank.Transaction;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static java.lang.Double.parseDouble;
import static org.junit.Assert.assertEquals;

public class ViewBankTransactionsSteps {

    Account account;
    @Given("This bank account exist:")
    public void setupAccount(DataTable dataTable) {
        Account.deleteAccounts();
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            account = Account.createAccount(list.get(i).get("account name"),list.get(i).get("currency"));
        }
    }

    @Given("The account has the following transactions:")
    public void setupTransactions(DataTable dataTable) throws Exception{
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("transaction").toLowerCase().equals("credit"))
            {
                Account.creditAccount(account,parseDouble(list.get(i).get("amount")),false);
            }else if(list.get(i).get("transaction").toLowerCase().equals("debit"))
            {
                Account.debitAccount(account,parseDouble(list.get(i).get("amount")),false);
            }else {
                throw new Exception("Unknown transaction type: "+list.get(i).get("transaction"));
            }
            Thread.sleep(10000);
            System.out.println(account.getBalance(account.getId()));
        }
    }

    @When("The user selects the account (.+)")
    public void selectAccount(String string) {

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

    @Then("User can see the list of transactions")
    public void verifyTransactionsList() {

    }
    @Test
    public void testDebitAccount() {
        Account account =  Account.createCreditedAccount("Shukri Shukriev", "USD",60000);
        Account.debitAccount(account,250,false);
        Transaction transaction = Account.getLastTransaction(account.getId());
        assertEquals(-250.0, transaction.getAmount(),0.1);
        assertEquals("PENDING", transaction.getStatus());
    }
}
