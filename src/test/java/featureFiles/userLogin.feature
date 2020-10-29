 @end2end 
Feature: Login page Functionality 
	As a retuning customer
	I want to login to the application
	So that I can check my account balance
	and be able to add Contact info

Background: 
	Given User is on the login page  
	
@a 
Scenario: User should be able to login with valid credentials 
	When  User enter valid credentials 
	Then  User should be able to view account balance 
	
@b 
Scenario: 
	User should be able to log in with correct username and password ( Making Variables work as Placeholders ) 
	When User enters username as "techfiosdemo@gmail.com" 
	And  User enters password as "abc123" 
	And  User clicks on login 
	Then User should be able to view account balance 
@c 
Scenario Outline: 
	User should be able to login with the appropriate credentials (Keeping Variables and Placeholders separated  ) 
	When User enters "<username>" and "<password>" and click on login button 
	Then User should be able to view account balance 
	
	Examples: 
		| username | password |
		| techfiosdemo@gmail.com | abc123 |
		| asd@gmail.com | qwe123 |
		
@d 
Scenario: 
After a failed attempt, user should be able to login with correct info 
When User enters set of username and password 
| username | password |				
| asd@gmail.com | qwe123 |
| techfiosdemo@gmail.com | abc123 |
#			Then User should be able to view account balance
				
@e 
Scenario Outline: User should be able to login with the appropriate credentials (Keeping Variables and Placeholders separated  )
 and should be able to submit addContact info
	Given User is on the login page  
	When User enters "<username>" and "<password>" and click on login button 
	Then User land on HomePage 
	Then User clicks on addContact and enters "<FullName>"and "<CompanyName>"and "<Email>"and "<Phone>"and "<Address>"and "<City>"and "<StateRegion>"and "<ZipCode>" and clicks on submit 
	Then User should be able to see validation message 
			
Examples: 
| username | password | FullName | CompanyName | Email | Phone | Address | City | StateRegion | ZipCode |
| techfiosdemo@gmail.com | abc123 | John Smith | Techfios LLC | abc@gmail.com | 347 761 4065 | 123 Dream Ln | Austin | Texas | 30500 |
				
