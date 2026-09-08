package account

import "p1/customer"

type CheckingAccount struct {
	Account
}

func NewCheckingAccount(number int, customer customer.Customer, balance float64) *CheckingAccount {
	return &CheckingAccount{
		Account: Account{
			number:   number,
			customer: customer,
			balance:  balance,
		},
	}
}

func (c *CheckingAccount) Accrue(rate float64) float64 {
	// Checking accounts don't accrue interest.
	return 0
}