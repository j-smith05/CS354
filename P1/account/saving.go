package account

import "p1/customer"

type SavingAccount struct {
	Account
	interest float64
}

func NewSavingAccount(number int, customer customer.Customer, balance float64) *SavingAccount {
	return &SavingAccount{
		Account: Account{
			number:   number,
			customer: customer,
			balance:  balance,
		},
		interest: 0,
	}
}

func (s *SavingAccount) Accrue(rate float64) float64 {
	interest := s.balance * rate

	s.interest += interest
	s.balance += interest

	return interest
}