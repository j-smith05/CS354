/*
 * customer.go
 *
 * Defines the Customer type and its constructor. Customers have a name and are used to identify account holders.
 * @author: Jacob Smith
 */

 package customer

import "strings"

type Customer struct {
	name string
}

/**
 * NewCustomer creates a new Customer with the specified name.
 */
func NewCustomer(name string) Customer {
	return Customer{
		name: strings.ToLower(name),
	}
}

/**
 * String returns a formatted string representation of the customer,
 * including the customer name.
 */
func (c Customer) String() string {
	return c.name
}