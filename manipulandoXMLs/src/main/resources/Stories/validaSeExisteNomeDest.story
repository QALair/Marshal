Narrative:
As a inspector
I want to check if the recipient is filled
So that I can take the receipt as right

Scenario: When a receipt is generated the recipient name must be filled

Meta:
@TestSet TS001
@TestCaseID TC002
Given a receipt exists $name
When I look into the name of the recipient inside the receipt
Then the name filled should be the right one $name

Examples:
|name|
|Algum nome|