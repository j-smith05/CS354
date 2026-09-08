package customer

import "strings"

type Customer struct {
	name string
}

func NewCustomer(name string) Customer {
	return Customer{
		name: strings.ToLower(name),
	}
}

func (c Customer) String() string {
	return c.name
}