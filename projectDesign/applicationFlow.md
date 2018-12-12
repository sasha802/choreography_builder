Application Flow

User Sign up
1.	User chooses sign up on the menu (available on all pages, unless the user is signed in already).
2.	User fills out the sign up form and submits.
3.	Request goes to sign up servlet.
4.	Servlet creates a user object and then creates user in the database.

User Sign In
1.	User chooses sign in on the menu (available on all pages, unless the user is signed in already).
2.	User enters email and password on form and submits.
3.	If user is authenticated, the server will handle allowing access to edit pages. 
4.	If authentication fails, show error message/page.

First Dance Info Pag
1.	Static page – html only.

Dance Builder Page
1.	HTML page to display the form to collect dance choreography specifications.
2.	On submit button page sends request to the dance builder servlet with all the specifications (beats per minute, choreography type, number of steps).
3.	Servlet sends specs to the java bean to perform the query according to user specs.
4.	Java bean gets results from the database.
5.	Servlet sends choreography result to the results jsp

Dance Choreography Results Page
1.	The dance choreography results jsp displays the name of the dance, beats per minute, choreography type and steps in choreographed order with the links to the demo video.
2.	The results page will provide the option to rebuild choreography. 
3.	Build New Choreography Button take the user to the build jsp page.


Edit Profile Page
1.	HTML page that displays the form for user to change profile info
2.	User can change first name, last name, password, email address
3.	On submit page sends request to the edit user info servlet with criteria.
4.	Servlet sends specs to the java dao
5.	Dao updates the user information according to the criteria.
6.	Servlet sends confirmation that info has been updated. 

Dance technique and movements service
1.	Service to provide the technical details about the specific dance

