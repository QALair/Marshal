Scenario: When a receipt comes to the client, there must exist a CNPJ,
that is the document that companies have.

Given A existent receipt, there must be the tag CNPJ

When I look into the receipt I found the CNPJ filled inside its own tag

Then I print the document
