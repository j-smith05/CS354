/*
 * account.go
 *
 * Defines the base Account structure and IAccount interface used by
 * the different account types. Provides common account operations
 * including deposits, withdrawals, balance access, and formatting.
 * @author: Jacob Smith
 */

package account

import (
	"fmt"

	"p1/customer"
)

/**
 * IAccount defines the interface for all account types.
 */
type IAccount interface {
	Balance() float64
	Accrue(rate float64) float64
	Deposit(amount float64)
	Withdraw(amount float64)
	String() string
}

/**
 * Account is the base structure for all account types. It contains
 * common fields and methods used by both CheckingAccount and
 * SavingAccount.
 */
type Account struct {
	number   int
	customer customer.Customer
	balance  float64
}
/**
 * Balance returns the current balance of the account.
 */
func (a *Account) Balance() float64 {
	return a.balance
}

/**
 * Accrue is a placeholder method for accruing interest. It is overridden
 * by specific account types that support interest accrual.
 */
func (a *Account) Accrue(rate float64) float64 {
	// Base Account does not accrue interest.
	return 0
}

/**
 * Deposit adds the specified amount to the account balance.
 */
func (a *Account) Deposit(amount float64) {
	a.balance += amount
}

/**
 * Withdraw subtracts the specified amount from the account balance.
 */
func (a *Account) Withdraw(amount float64) {
	a.balance -= amount
}

/**
 * String returns a formatted string representation of the account,
 * including the account number, customer name, and balance.
 */
func (a *Account) String() string {
	return fmt.Sprintf("%d: %s: %.2f", a.number, a.customer.String(), a.balance)
}