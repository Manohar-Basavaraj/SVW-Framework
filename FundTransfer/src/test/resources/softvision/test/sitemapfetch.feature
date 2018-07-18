Feature: Search for a sitemap in the websites 

Scenario Outline: Check whether the site has a sitmap 
	Given the user is on "<siteUrl>" site
	When the user checks for the sitemap
	Then the user should be shown whether the site has a sitemap 
	
	Examples: 
		| siteUrl							|
		| https://www.softvision.com		|
		| http://toolsqa.com				|  
		| https://www.amazon.in				| 
		| http://automationpractice.com		|