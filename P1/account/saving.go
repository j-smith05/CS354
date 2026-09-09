/*
 * saving.go
 *
 * Defines the SavingAccount type and its constructor. Saving
 * accounts use the common Account functionality and accrue
 * interest.
 * @author: Jacob Smith
 */
 
package account

import "p1/customer"

type SavingAccount struct {
	Account
	interest float64
}

/**
 * NewSavingAccount creates a new SavingAccount with the specified
 * account number, customer, and initial balance.
 */
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

/**
 * Accrue calculates the interest based on the current balance and the provided rate,
 * updates the account balance with the accrued interest, and returns the amount of interest accrued.
 */
func (s *SavingAccount) Accrue(rate float64) float64 {
	interest := s.balance * rate

	s.interest += interest
	s.balance += interest

	return interest
}