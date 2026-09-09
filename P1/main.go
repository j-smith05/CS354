/*
 * main.go
 *
 * Entry point for the banking application. Creates customers and
 * accounts, adds the accounts to the bank, accrues interest, and
 * displays the account information and total interest accrued.
 * @author: Jacob Smith
 */

package main

import (
	"fmt"

	"p1/account"
	"p1/bank"
	"p1/customer"
)

/**
 * main is the entry point of the application. It creates a bank, customers,
 * and accounts, adds the accounts to the bank, accrues interest, and prints
 * the account information along with the total interest accrued.
 */
func main() {
	b := bank.NewBank()

	ann := customer.NewCustomer("Ann")
	bob := customer.NewCustomer("Bob")

	b.Add(account.NewCheckingAccount(1, ann, 100.00))
	b.Add(account.NewSavingAccount(2, ann, 200.00))
	b.Add(account.NewSavingAccount(3, bob, 150.00))

	totalInterest := b.Accrue(0.02)

	fmt.Print(b.String())
	fmt.Print("\n")
	fmt.Printf("Total Interest: %.2f", totalInterest)
}