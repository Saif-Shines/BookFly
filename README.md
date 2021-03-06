# BookFly
Assignment given to create a Flight Bookings and display. This is a Android Application. It takes in the from and to data from the user and then searches for the flights available to book. The Person's details will be inserted into the database. Additionally, it has a login screen for the Admin or the User to login. Admin has the previlige to add the flights and client info from his admin panel and User can book a flight.

In between the code I've give the links to the resources which I've referred to build this application.
 		

##Screenshots	

![client fill up form](https://user-images.githubusercontent.com/17451294/42310812-f9604c54-8059-11e8-846d-807df73717ed.png)
![client information conformation](https://user-images.githubusercontent.com/17451294/42310813-f9b62a3e-8059-11e8-8de3-fd0db82a61d6.png)
![client static only - details](https://user-images.githubusercontent.com/17451294/42310814-f9e3d484-8059-11e8-8ce8-ea38948288de.png)
![client-flightdetail](https://user-images.githubusercontent.com/17451294/42310815-fa124ef4-8059-11e8-90fb-ae3e141d4a93.png)
![starting screen - client or admin login](https://user-images.githubusercontent.com/17451294/42310816-fa446cd6-8059-11e8-92f5-9e40aa25e46b.png)
![admin-add a flight](https://user-images.githubusercontent.com/17451294/42310817-fa747d0e-8059-11e8-8b16-d1e04f068b8b.png)
![admin-add name to client list](https://user-images.githubusercontent.com/17451294/42310818-faa25bb6-8059-11e8-8593-481ea5ae0147.png)
![admin-admin panel for adding flights](https://user-images.githubusercontent.com/17451294/42310819-fad1eca0-8059-11e8-8acf-00d71e00c3da.png)
![admin-can add flights](https://user-images.githubusercontent.com/17451294/42310820-fb04aa46-8059-11e8-82ea-50e655bf8ab0.png)
![admin-edit flight to edit details of flight](https://user-images.githubusercontent.com/17451294/42310821-fb37e726-8059-11e8-8d75-7b1eb3e64154.png)
![admin-search for client](https://user-images.githubusercontent.com/17451294/42310822-fb6513ae-8059-11e8-83d4-9fd5a35adf61.png)
![client - client panel](https://user-images.githubusercontent.com/17451294/42310823-fb9523dc-8059-11e8-94db-eae3d9f6cd27.png)
![client - flight search](https://user-images.githubusercontent.com/17451294/42310825-fbcbf7f4-8059-11e8-9286-01d76a9b14a7.png)
![client confirmation and continuation](https://user-images.githubusercontent.com/17451294/42310826-fbfa3b14-8059-11e8-8696-0b24d2e09ea5.png)

## Executable File

Here is a apk file which is generated:(https://github.com/Saif-Shines/BookFly/blob/master/app-debug.apk) 

Note: Due to time limitations which we had less that 2 days, I couldn't do validation for date or no spinner views. One of the Bug observed is if there are more characters given into date field (Strictly YYYY-MM-DD), The app is likely to be crashing.

# The Execution Flow

*Initial one View*
![img_20180705_141102](https://user-images.githubusercontent.com/17451294/42312548-36c1ab52-805e-11e8-877b-3ebf4afa46d6.jpg)

*Fianlly*
![nw1](https://user-images.githubusercontent.com/17451294/42312717-b0316ae0-805e-11e8-8581-3e1e8727d070.jpg)


![nw2](https://user-images.githubusercontent.com/17451294/42312793-d5d1b5e8-805e-11e8-9b5f-f3ee6b33d05f.jpg)

# Database Scripts

I've used _Serialize_ to make it simpler for the database.

1. https://github.com/Saif-Shines/BookFly/tree/master/app/src/main/java/system

# Things that I could improve along with time.
This could be implemented if we have had more time.
1. Material Design.
2. Validation of Numbers/strings.
3. Architecture principles by Uncle Bob.
4. Populating Custom ListView using FlightSearch API. (Thought it's JSON)

# Step by Step Commit History

This repository has direct one branch of the code and the work flow. Before coming to this branch finally, I had to work on multiple ways dealing with App to run smooth with Android System for the App to sustain.Here I have every single time to time commit according the differect objects, Adaptors, SQLiteDatabase, DBHelper, Cursors and view validation objects like spinner and date selection calender view.

You can see the project with 7 branches and 107 commits here at https://github.com/Saif-Shines/FlightBookingSystem-OD
Database Management: https://github.com/Saif-Shines/FlightBookingSystem-OD/tree/database/app/src/main/java/com/example/saif/flightsearchapplication



