# AndroidExamples

## ContactList

In this example, you will see how to use SQLite database with Recyclerview.

SQLite is the most popular database engine. This is due to it’s serverless, zero-configuration nature yet still reasonably performant. SQLite simply exists a single file and runs in a single process. This makes it efficient hence can easily be used in resource-constrained devices.

RecyclerView on the other hand is an adapterview that allows us render large datasets. Especially data coming from databases like sqlite and webservices qualify as good for being rendered in recyclerview. RecyclerViews are popular because of their flexibility and ease of use. Once we’ve retrieved our data from sqlite we will show this data in recyclerview. 

### Contact.java

Simple class to create contacts (that are stored in the Database) containing an id, name, and email.

### MainActivity.java

The main activity contains a RecyclerView to show the entries in the database and initializes the adapters.

### DatabaseAdapter.java

The adapter to collect data (a list of contacts) from the database to show in our Main Activity (through a RecyclerView).

### DatabaseHelper.java

The database helper to create, update, query... our local SQLite database. It inherits from SQLiteOpenHelper.

### ContactAdapter.java

The adapter to populate the view holders of our RecyclerView. It inherits from RecyclerView.Adapter<>.

### activity_main.xml

Layout of out main activity.

### single_item.xml

Layout for an item that will show in the recycler view of the main activity.
