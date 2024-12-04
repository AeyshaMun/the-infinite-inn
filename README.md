# The Infinite Inn
This repository contains the necessary code and information for our implementation of a hotel 
booking and management software for The Infinite Inn.

### Table of Contents
- [Contributors](#contributors)
- [Purpose](#purpose)
- [Features/User Stories](#featuresuser-stories)
- [Installation Instructions](#installation-instructions)
- [Usage Guide](#usage-guide)
- [License](#license)
- [Feedback](#feedback)
- [Contributions](#contributions)

### Contributors
- Aeysha Munawwarah (username: AeyshaMun)  
- Ayusha Thapa (username: ayushathapa16)  
- Emily Tseng (username: yuching530)                 
- Noga Altman (username: nogaaltman)  
- Olivia Zhou (username: seven143143)

### Purpose
This project implements hotel booking and management software for The Infinite Inn, a fictional inn 
located in Zürich, Switzerland with an infinite number of rooms. Our software 
streamlines the booking and management process for either a room or private event by allowing users 
to do everything remotely and in one place without dealing with long wait times or phone calls. 
Users are able to use our software to book a room or book out one of the event halls as a venue for 
private events. Users can then specify any needed accommodations and order room service or catering 
from a set list of meals. At the end of their stay, users can check out of 
their room or event hall once their stay is over. 

### Features/User Stories
#### Team:
- As a guest, I want to be able to log into my room booking to gain access to ordering room 
service, specifying accommodations, or checking out of my room.
- As a client, I want to be able to log into my event booking to gain access to ordering catering, 
specifying accommodations, or checking out of my event hall.
#### Aeysha:
- As a client, I want to be able to book out one of the private event rooms at the inn so that I 
can host an event, such as a wedding or small conference, without actually staying at the inn as a 
guest.
#### Ayusha:
- As a potential guest, I want to be able to make a booking at the inn so that I can secure a place 
to stay during my trip according to my preferences.
#### Emily:
- As a guest or a client, once my trip or event is over, I want to check out of my room or the 
event hall on my phone remotely so that I can leave on my own time.
#### Noga:
- As a guest, I want to order room service so that I can get food delivered without having to leave 
my room.
- As a guest, I want to order catering from the inn so that I don't have to worry about getting 
food from some outside service.
#### Olivia:
- As a guest or client, I want to specify any accommodations I need for my stay to let staff know 
of my personal needs in advance or as they change.

### Installation Instructions
Follow these steps to install and set up the project on your local machine.

#### Requirements
Before you begin, ensure you have the following software and packages installed:
1. Java Development Kit (JDK) 11 or higher
   - Download JDK [here](https://www.oracle.com/java/technologies/downloads/#java11?er=221886) 
   - Required version: JDK 11 or later.
2. Maven (for project build and dependency management)
   - Download Maven [here](https://maven.apache.org/download.cgi)
   - Required version: Maven 3.6.3 or later.
3. IntelliJ IDEA (preferred IDE for the project)
   - Download Intellij [here](https://www.jetbrains.com/help/idea/installation-guide.html)
   - Required version: IntelliJ IDEA Community or Ultimate edition. 
   - SDK: You need to set up the Java SDK in IntelliJ IDEA. This SDK should be the JDK 11 or higher.
     For this project, we used the Oracle OpenJDK 22.0.2.
4. Git (for cloning the repository)
   - Download Git [here](https://git-scm.com/downloads)
   - Required version: Git 2.0 or higher.

#### Supported Operating Systems
This project is intended to run on the following operating systems:
- Windows: Windows 10 or later
- macOS: macOS 10.14 or later
- Linux: Ubuntu 18.04 or later, Fedora 30 or later

The software has not been tested on other operating systems, so we cannot guarantee compatibility.

#### Step-by-step Installation (using Intellij)
1. Fork this repository to your GitHub account.
2. Clone your fork to your local machine: you can do this by clicking the green Code button in your 
   repository on GitHub and copying the HTTPS URL that you will see.
3. Open IntelliJ. If you already have a project open, close that project. From the main screen, 
   choose the "get from VCS" option.
4. In the menu that appears, paste the URL.
5. Set up the Java SDK in IntelliJ IDEA:
   - If the SDK isn't automatically detected, follow these steps:
     - Go to File > Project Structure.
     - Under Project Settings > Project, make sure Project SDK is set to JDK 11 or higher. If it is 
       not listed, click Add SDK and select the correct JDK location on your system.
     - Under Modules, ensure that the module SDK is set to the same JDK version.
6. IntelliJ IDEA should automatically recognize the Maven configuration.
   - Note: sometimes you may need to right-click the pom.xml file and select "Maven > reload project".
7. To run the project from IntelliJ IDEA:
   - Go to Run > Edit Configurations.
   - Click on the + sign to add a new configuration.
   - Select "application" and configure it with the main class of your project.
   - Click "ok" and then hit the "run" button.

### Usage Guide
Start the application: refer to the [Installation Instructions](#installation-instructions) section for details on how
to run the project. 

#### Booking a room
1. Make a booking
    - Select "book a room" from main page.
    - Enter your name and the type of room you're interested in (single, double, deluxe, accessible)
    - Click "submit booking" to finalize.
    - View the booking summary dialog for confirmation.
2. Order room service
    - Select "my booking" from main page.
    - To log in, enter your name and room number when prompted.
    - Select "room service/catering".
    - Indicate desired quantity next to each item in the list.
    - Click "order" to finalize.
    - View the order summary dialog for confirmation.
3. Specify accommodations
    - Select "my booking" from main page.
    - To log in, enter your name and room number when prompted.
    - Select "accommodations".
    - Enter desired accommodations.
    - Click "submit accommodations" to finalize.
    - View the accommodations summary dialog for confirmation.
4. Check out of room
    - Select "my booking" from main page.
    - To log in, enter your name and room number when prompted.
    - Select "check out".

#### Booking a private event
1. Make a booking
    - Select "book a private event" from main page.
    - Enter your name, date of the event and party size.
    - Click "next".
    - Receive weather forecast for chose event date and choose between an indoor and outdoor event 
      hall, if conditions are suitable.
    - Click "submit booking" to finalize. 
    - View the booking summary dialog for confirmation.
2. Order catering
    - Select "my booking" from main page.
    - To log in, enter your name and room number when prompted.
    - Select "room service/catering".
    - Indicate desired quantity next to each item in the list.
    - Click "order" to finalize.
    - View the order summary dialog for confirmation.
3. Specify accommodations
    - Select "my booking" from main page. 
    - To log in, enter your name and room number when prompted.
    - Select "accommodations".
    - Enter desired accommodations.
    - Click "submit accommodations" to finalize.
    - View the accommodations summary dialog for confirmation.
4. Check out of event hall
    - Select "my booking" from main page.
    - To log in, enter your name and room number when prompted.
     - Select "check out".

### License
This work is dedicated to the public domain under the
[Creative Commons CC0 1.0 Universal (CC0 1.0) Public Domain Dedication](https://creativecommons.org/publicdomain/zero/1.0/).
You can copy, modify, distribute, and perform the work, even for commercial purposes, all without 
asking permission. For more details, see the [LICENSE](LICENSE) file.

### Feedback
We value any feedback you may have about this project! If you have suggestions, comments, or 
questions, please feel free to reach out using this [form](https://forms.gle/WjdnDMLNHCKkvL3u8).

Guidelines for feedback:
- Please be respectful and constructive when submitting feedback.
- Focus on the functionality, design, or potential improvements for this project.
- Keep in mind that this is a class project, and responses may be limited.

We will review all feedback carefully, though due to the nature of the project, responses may be 
delayed.

### Contributions
This project is our final assignment for CSC207 and is currently closed to external contributions. 
We appreciate your interest, but no further pull requests or contributions are being accepted at 
this time.
If you have any questions or feedback, please refer to the [Feedback](#feedback) section for more 
information on how to reach us.
