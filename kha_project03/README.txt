Thanh Kha '19
Project03
Pooja Priya
Muhammed Ali Binici

ACADEMIC HONESTY PLEDGE:

I affirm that I did not give or receive any unauthorized help on this project, and that all work is my own.


ASSIGNMENT DESCRIPTION


My workout application, GetFit was designed to target regular gym-goers. Gym-goers know’s what they do at gym on a day-to-day basis. They also are the ones that will use the application more than any other people, because other users look for motivation to keep do the workouts already listed. Gym-goers have a consistent weekly schedule that barely ever changes.


RUNNING 

Emulator: 
	- Nexus 5 x86 API 24 x86 to run google services and update


HOME FEATURES:
- Save workout for that weekday, and will be available for the next’s week session of the same weekday. 
- Schedule: lists the workouts with notes available when clicking. 
- Settings: allows changes to the current day’s workout. 
- Start: Begins the workout process, which goes to create a new routine if there was one previously.
-Extra: contains all other features that my application doesn’t need, but to follow the rubric, including screen orientation, tablet, sound, camera, music, and Google Maps. 


EXTRA CREDIT:
- I did an in-class presentation of my application. 


BASIC FEATURES: IMPLEMENTATION

A design based on Model View Controller (MVC):
	- Java classes to control the data flow and calculations (model package)

Best Practices for communication between fragments and activities: 
	- About all fragments uses a listener to connect to it’s Activity.

A custom theme that includes custom colors and styles:
	- Home and Extras has it’s own custom color and theme for it’s buttons and themes.

Separate interfaces for phone and tablet form factors:
	- Widgets and Displays are resized by parent’s width and height that allows good use for tablets and other large devices.

A landscape orientation that makes sense:
	- On the Extra page allows landscape. People may be running with their phones, so switching orientation is unnecessary. 

At least 2 activities:
	- More than two exists (Home, Create, Workout, Extra)

A layout comprised of one or more fragments. There should not be any widgets outside
of a fragment other than the layouts containing the fragments.
	— All of my Activities contains it’s on fragment.
	- All widgets are within a fragment, except for extras for cleaner and unnecessary 	features for my app.

Up navigation:
	- Up Navigation is in the (Extra) Activity.
	- Other features uses the finish and View Pager.

An options menu:
	- Home screen have several options to choose from, as well as Extras.

A RecyclerView​ or a ViewPager​:
	- Both Recycler with ViewPager is used. (Home and Schedule)

Persistence: your app must function properly:
	- Fully functional.

At least one dialog:
	- After completing a workout by pressing “Finish” open a dialog.
	- Finish: Saves workout.
	- Cancel: Pops toast and continue workout.

At least one toast:
	- Toasts is made after creating a new workout

Logging, logging, logging:
	- plenty of logging when troubleshooting my application.

Robust error handling. Your app should not crash.
	- Haven’t had any crashes from running my application.

A SQLite Database used for persistence across restarts.
	- SQLite Database is used to maintain user’s data of workouts.


ADVANCED FEATURES

Your app must feature at least 5 of the following features
- ExtraThe ability to use the camera to take and save photographs
- Playing sounds with SoundPool (Extra)
- Playing longer sounds or video with MediaPlayer (Extra)
- Google Maps (Extra)
	