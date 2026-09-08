package account

import (
	"fmt"

	"p1/customer"
)

type IAccount interface {
	Balance() float64
	Accrue(rate float64)
	Deposit(amount float64)
	Withdraw(amount float64)
	String() string
}

type Account struct {
	number   int
	customer customer.Customer
	balance  float64
}

func (a *Account) Balance() float64 {
	return a.balance
}

func (a *Account) Deposit(amount float64) {
	a.balance += amount
}

func (a *Account) Withdraw(amount float64) {
	a.balance -= amount
}

func (a *Account) String() string {
	return fmt.Sprintf("%d: %s: %f", a.number, a.customer.String(), a.balance)
}