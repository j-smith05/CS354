package bank

import (
	"strings"

	"p1/account"
)

type Bank struct {
	accounts []account.IAccount
}

func NewBank() *Bank {
	return &Bank{
		accounts: make([]account.IAccount, 0),
	}
}

func (b *Bank) Add(a account.IAccount) {
	b.accounts = append(b.accounts, a)
}

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