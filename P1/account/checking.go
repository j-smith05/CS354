/*
 * checking.go
 *
 * Defines the CheckingAccount type and its constructor. Checking
 * accounts use the common Account functionality but do not accrue
 * interest.
 * @author: Jacob Smith
 */

package account

import "p1/customer"

type CheckingAccount struct {
	Account
}
/**
 * NewCheckingAccount creates a new CheckingAccount with the specified
 * account number, customer, and initial balance.
 */
func NewCheckingAccount(number int, customer customer.Customer, balance float64) *CheckingAccount {
	return &CheckingAccount{
		Account: Account{
			number:   number,
			customer: customer,
			balance:  balance,
		},
	}
}

/** 
* Accrue is a placeholder method for accruing interest. 
*Checking accounts do not accrue interest, so this 
* method returns 0.
*/
func (c *CheckingAccount) Accrue(rate float64) float64 {
	// Checking accounts don't accrue interest.
	return 0
}