/*
 * banking.go
 *
 * Defines the Bank type and its constructor. Banks manage a collection of accounts
 * and provide operations for adding accounts and accruing interest.
 * @author: Jacob Smith
 */
 
package bank

import (
	"strings"

	"p1/account"
)

type Bank struct {
	accounts []account.IAccount
}

/**
 * NewBank creates a new Bank with an empty collection of accounts.
 */
func NewBank() *Bank {
	return &Bank{
		accounts: make([]account.IAccount, 0),
	}
}

/**
 * Add adds a new account to the bank's collection of accounts.
 */
func (b *Bank) Add(a account.IAccount) {
	b.accounts = append(b.accounts, a)
}

/**
 * Accrue calculates the total interest accrued across all accounts in the bank
 * based on the provided interest rate. It returns the total interest accrued.
 */
func (b *Bank) Accrue(rate float64) float64 {
	ch := make(chan float64)

	for _, a := range b.accounts {
		go func(acct account.IAccount) {
			ch <- acct.Accrue(rate)
		}(a)
	}

	total := 0.0

	for range b.accounts {
		total += <-ch
	}

	return total
}

/**
 * String returns a formatted string representation of the bank,
 * including all accounts.
 */
func (b *Bank) String() string {
	var result strings.Builder

	for i, a := range b.accounts {
		result.WriteString(a.String())

		if i < len(b.accounts)-1 {
			result.WriteString("\n")
		}
	}

	return result.String()
}