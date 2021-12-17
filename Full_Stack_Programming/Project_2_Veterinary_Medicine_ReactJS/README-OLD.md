# Final-Project

607 final project

Spring framework is used for API and the runnable file is “ProjectApplication” which is accessible via:

Final-Project-API  src  main  java  com  example  project  ProjectApplication

API's instruction:


Login Page API:
In this project, we designed a specific API and requests for our login page. The purpose of this 
webpage is to get the username and password from the user, the backend checks if they are in the
database and the authentication is successful, and the right page and types of access be shown to 
them after this process. From the implementation point of view, we created a java file under the 
controller package named LoginController to make HTTP connections (get, post, ...) between 
the user and backend with the proper URL. On the other hand, we will completely implement 
this page's backend and front end and match it to the existing API in future work. This part of 
API design covers VET981-15, which is related to user access/management of the project.

******************************************************************************
Admin Page API:
In this work, the admin page must access all users to add/delete/block them, watch animals’ 
progress and comments and have full access to their staff. Therefore, we designed a separated 
API with the ‘/admin/’ URL for this page to show all the mentioned types of access and 
functions to them. Therefore, at this point, we have a java class named AdminController to 
communicate and get/post information to that webpage address. We also have a simple model of 
the Admin class under the model package to show some functions this class must do. To 
implement all the required APIs, we used the Spring framework. For future work, we will 
establish certain integrity between the backend and frontend of the Admin page and ensure it 
works smoothly and properly. This page covers VET981-16/17/18/19/20 stories in this project. It
should also be mentioned that as Teaching Technician, Student, Health Care Attendants have 
similar pages but with different types of access, their specific databases, and their functions, as 
well as backend and frontend, will be implemented in the next phase of the project.
Stories covered in this phase of the project: VET981- 15/16/17/18/19/20

******************************************************************************
 Jira task: User Profile Page API VET981-59
 https://uofeng607981.atlassian.net/browse/VET981-59

 Related Stories:

 VET981-36 https://uofeng607981.atlassian.net/browse/VET981-36
 VET981-37 https://uofeng607981.atlassian.net/browse/VET981-37
 VET981-43 https://uofeng607981.atlassian.net/browse/VET981-43

 VET981-59 is implemented via UserController:

 This controller is implemented for the user stories that shows all users can access    their   own user    information page    where   they
 can view their profile info including FirstName,LastName, Bithday , Role,.... . This is accessible by "/user/{userId}" URL endpoint that send http GET request which "userId" shows the specific User and return would be the information of that user. 

 In this story list of assigned animals to the user is displayed. The URL for http GET request of this activity is "/user/{userId}/animals".

 In this story all the listed animal can be searched and filtered by different feature such as animalID, Type, breed, OwnerInformation(Name, Number) and each of these features will send to server via GET request to get the results. for example, for animamls with specific animalID, URL would be "/user/{userId}/animalId/{id}" that "userId" shows isspecific user and “id" will search specific animal. 
 features such as photos and comments of animal also can be reviewed as well. For all of them http GET request will use with the input parameters such as specific user ("userId) specific animal("id") to see the photos or comments. For example, the URL for GET photo request is "/user/{userId}/animalId/{id}/photo". 

 In this controller we also have logout and back button and for each of users. For example, a method for user log out will be executed by @RequestMapping("/userlogout/{userId}") that "userId" will logged out the specific user.

*****************************************************************************

 Jira task: Search Page API

 https://uofeng607981.atlassian.net/browse/VET981-57

 Related Stories:

 VET981-29 https://uofeng607981.atlassian.net/browse/VET981-29
 VET981-31 https://uofeng607981.atlassian.net/browse/VET981-31

 VET981-57 is implemented via SearchController:
 
 This Controller is implemented to display the list of animals, and this can be requested via "/search/animal" URL that gets the information of animals. In this page 
 search on all the animals based on different features such as animalID, Type, breed, ... is provided. For example, in order to get the animals with specific color the http GET request "/search/animalColor/{color}" is used, that "color" filter the specific color. For all the features this approach is used.

*****************************************************************************

AnimalProfilesController 
API:
The following Jira stories are covered in the following API’s: VET981-22, 23, 
24, 25, 26, 27, 30, 32, 33, 35, 38.
The pictures GetMapping API call will be used to get the animal pictures from
the back end and display them on the front end for the designated animalID. 
The commented out ArrayList is there since the final implementation of the 
API will return an array of animal pictures, but current functionality is to only 
return a String, as an example.

@GetMapping("/animal/{animalID}/pictures")
public /*ArrayList<AnimalPicture>*/String pictures(@PathVariable("animalID") 
String animalID)

The addPicture PostMapping API call will be used to allow various users to 
add pictures of the designated animal to the database on the backend. This 
covers Jira story VET981-33.

@PostMapping("/animal/{animalID}/pictures")
public void addPicture(@RequestBody AnimalPicture newAnimalPicture, 
@PathVariable("animalID") String animalID)

The information GetMapping API call will be used to display the designated 
animal’s information from the database on the front-end GUI. The 
commented out ArrayList is there since the final implementation of the API 
will return an array of information, but current functionality is to only return 
a String, as an example.

@GetMapping("/animal/{animalID}/information")
public /*ArrayList<String>*/ String information(@PathVariable("animalID") 
String animalID)

The updateInformation PutMapping API will be used to update the 
information in the database, from the user input from the front end.

@PutMapping("/animal/{animalID}/information")
public void updateInformation(@RequestBody String information, 
@PathVariable("animalID") String animalID)

The status GetMapping API will be used to retrieve the designated animal’s 
status from the back end and display on the front end. The commented out 
ArrayList is there since the final implementation of the API will return an 
array of animal statuses, but current functionality is to only return a String, 
as an example. This covers Jira story VET981-22, 27.

@GetMapping("/animal/{animalID}/status")
public /*ArrayList<AnimalStatus>*/ String status(@PathVariable("animalID") 
String animalID)

The updateStatus PutMapping API is used so that the user can add an 
updated status from the front-end GUI that then will be added to the 
database on the back end for the designated animalID. This covers Jira story 
VET981-24, 25, 26.

@PutMapping("/animal/{animalID}/status")
public void updateStatus(@RequestBody AnimalStatus newAnimalStatus, 
@PathVariable("animalID") String animalID)

The treatments GetMapping API is used to get the list of treatments from the
databased and display treatments for a distinct animalID on the front end. . 
The commented out ArrayList is there since the final implementation of the 
API will return an array of treatments, but current functionality is to only 
return a String, as an example. This covers Jira story VET981-35.

@GetMapping("/animal/{animalID}/treatments")
public /*ArrayList<AnimalTreatment>*/ String 
treatments(@PathVariable("animalID") String animalID)

The addTreatment PostMapping API is used to get a user’s input from the 
front end for adding an animal treatment, and adding it to the backend 
database. This covers Jira story VET981-25, 35.

@PostMapping("/animal/{animalID}/treatments")
public void addTreatment(@RequestBody AnimalTreatment newAnimalTreatment, 
@PathVariable("animalID") String animalID)

The comments GetMapping API is used to get comments for a distinct animal
from the back end database and display them on the front end. . The 
commented out ArrayList is there since the final implementation of the API 
will return an array of animal comments, but current functionality is to only 
return a String, as an example. This covers Jira story VET981-23.

@GetMapping("/animal/{animalID}/comments")
public /*ArrayList<AnimalComment>*/ String comments(@PathVariable("animalID") 
String animalID)

The addComment PostMapping API is for the user to be able to add a 
comment on the front end which is then sent and stored on the back end 
database. This covers Jira story VET981-30, 32

@PostMapping("/animal/{animalID}/comments")
public void addComment(@RequestBody AnimalComment newAnimalComment, 
@PathVariable("animalID") String animalID)

The prescriptions GetMapping API is used to get the list of prescriptions form 
the back end database and send them to the front end. The commented out 
ArrayList is there since the final implementation of the API will return an 
array of prescriptions, but current functionality is to only return a String, as 
an example.

@GetMapping("/animal/{animalID}/prescriptions")
public /*ArrayList<AnimalPrescription>*/ String 
prescriptions(@PathVariable("animalID") String animalID)

The addPrescriptions PostMapping API is used for a user to be able to add 
prescriptions for a distinct animal into the front end which is then added to 
the database on the backend. This covers Jira story VET981-38.

@PostMapping("/anima/{animalID}l/prescriptions")
public void addPrescriptions(@RequestBody AnimalPrescription 
newAnimalPrescription, @PathVariable("animalID") String animalID)


