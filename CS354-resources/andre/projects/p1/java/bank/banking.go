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

func (b *Bank) Accrue(rate float64) {
	for _, a := range b.accounts {
		a.Accrue(rate)
	}
}

func (b *Bank) String() string {
	var result strings.Builder

	for _, a := range b.accounts {
		result.WriteString(a.String())
		result.WriteString("\n")
	}

	return result.String()
}