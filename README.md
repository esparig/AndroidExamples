# AndroidExamples

## Contents
- [ContactList](#contactlist) 
- [NoTitleActivity](#notitleactivity)
- [Videodemo](#videodemo) 

## ContactList

In this example, you will see how to use SQLite database with Recyclerview.

SQLite is the most popular database engine. This is due to it’s serverless, zero-configuration nature yet still reasonably performant. SQLite simply exists a single file and runs in a single process. This makes it efficient hence can easily be used in resource-constrained devices.

RecyclerView on the other hand is an adapterview that allows us render large datasets. Especially data coming from databases like sqlite and webservices qualify as good for being rendered in recyclerview. RecyclerViews are popular because of their flexibility and ease of use. Once we’ve retrieved our data from sqlite we will show this data in recyclerview. 

### Contact.java

Simple class to create contacts (that are stored in the **SQLite Database**) containing an id, name, and email.

### MainActivity.java

The main activity contains a **RecyclerView** to show the entries in the database and initializes the adapters.

### DatabaseAdapter.java

The adapter to collect data (a list of contacts) from the database using a **Cursor** to show in our Main Activity (through a RecyclerView).

### DatabaseHelper.java

The database helper to create, update, query... our local SQLite database. It inherits from SQLiteOpenHelper.

### ContactAdapter.java

The adapter to populate the view holders of our RecyclerView. It inherits from RecyclerView.Adapter<>.

### activity_main.xml

Layout of out main activity.

### single_item.xml

Layout for an item that will show in the recycler view of the main activity.

## NoTitleActivity

This simple tutorial is to show you how to make not showing Action Bar in the activities of your Android Application...

### themes.xml

...By just adding this two lines in your themes.xml. Make sure you are using this theme in your android manifest.
```
<!-- Customize your theme here. -->
<item name="windowNoTitle">true</item>
<item name="windowActionBar">false</item>
```
## Videodemo

Tutorial extracted from https://www.geeksforgeeks.org/how-to-play-video-from-url-in-android/
For showing the video in our android application we will use the VideoView widget. The VideoView widget is capable of playing media files, and the formats supported by the VideoView are 3gp and MP4. By using VideoView you can play media files from the local storage and also from the internet.
