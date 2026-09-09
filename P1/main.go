package main

import (
	"fmt"

	"p1/account"
	"p1/bank"
	"p1/customer"
)

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